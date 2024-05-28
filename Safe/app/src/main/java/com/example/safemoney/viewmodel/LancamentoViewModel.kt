import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.safemoney.repositorio.ILancamentoRepository
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class LancamentoViewModel(private val lancamentoRepository: ILancamentoRepository) : ViewModel() {

    private val coroutineExceptionHandler = CoroutineExceptionHandler { _, exception ->
        Log.e("LancamentoViewModel", "Erro ao cadastrar a lançamento", exception)
        _errorEvent.postValue("Erro ao cadastrar lançamento: ${exception.message}")
    }

    private val _successEvent = MutableLiveData<Boolean>()
    val successEvent: LiveData<Boolean> get() = _successEvent

    private val _errorEvent = MutableLiveData<String>()
    val errorEvent: LiveData<String> get() = _errorEvent

    private val _lancamentos = MutableLiveData<List<LancamentosGet>>(emptyList())
    val lancamentos: LiveData<List<LancamentosGet>> get() = _lancamentos

    fun listarLancamentos(contaId: Int) {
        viewModelScope.launch(Dispatchers.IO + coroutineExceptionHandler) {
            try {
                val response = lancamentoRepository.listarLancamentos(contaId)
                if (response.isSuccessful) {
                    val novosLancamentos = response.body() ?: emptyList()
                    val listaAtualizada = (_lancamentos.value ?: emptyList()) + novosLancamentos
                    _lancamentos.postValue(listaAtualizada)
                    novosLancamentos.forEach { lancamento ->
                        Log.d("LancamentoViewModel", lancamento.toString())
                    }
                } else {
                    val erro = response.errorBody()?.string() ?: "Erro desconhecido"
                    Log.e("LancamentoViewModel", "Erro ao listar lançamentos: $erro")
                    _errorEvent.postValue("Erro ao listar lançamentos: $erro")
                }
            } catch (e: Exception) {
                Log.e("LancamentoViewModel", "Erro ao listar lançamentos", e)
                _errorEvent.postValue("Erro ao listar lançamentos: ${e.message}")
            }
        }
    }

    fun cadastrarLancamentoFixo(lancamentos: Lancamentos) {
        viewModelScope.launch(Dispatchers.IO + coroutineExceptionHandler) {
            try {
                Log.d("LancamentoViewModel", "Enviando lançamento: $lancamentos")
                lancamentoRepository.cadastrarLancamento(lancamentos)
                _successEvent.postValue(true)
                listarLancamentos(lancamentos.fkConta.id)
            } catch (e: Exception) {
                Log.e("LancamentoViewModel", "Erro ao cadastrar lançamento", e)
                _errorEvent.postValue("Erro ao cadastrar lançamento: ${e.message}")
            }
        }
    }
}
