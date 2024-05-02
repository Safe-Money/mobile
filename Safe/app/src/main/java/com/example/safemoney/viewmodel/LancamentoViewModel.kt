import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.safemoney.model.CartaoGet

import com.example.safemoney.repositorio.ILancamentoRepository
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers

import kotlinx.coroutines.launch


class LancamentoViewModel(private val lancamentoRepository: ILancamentoRepository) : ViewModel() {

    private val coroutineExceptionHandler = CoroutineExceptionHandler { _, exception ->
        Log.e("lancamentosViewModel", "Erro ao cadastrar a lancamento", exception)
    }


    private val _successEvent = MutableLiveData<Boolean>()
    val successEvent: LiveData<Boolean>
        get() = _successEvent

    private val _errorEvent = MutableLiveData<String>()
    val errorEvent: LiveData<String>
        get() = _errorEvent

    private val _lancamentos = MutableLiveData<List<LancamentosGet>>()
    val lancamentos: LiveData<List<LancamentosGet>>
        get() = _lancamentos


    fun listarLancamentos(userId: Int): LiveData<List<LancamentosGet>> {
        CoroutineScope(Dispatchers.IO + coroutineExceptionHandler).launch {
            try {
                val response = lancamentoRepository.listarLancamentos(userId)
                if (response.isSuccessful) {
                    _lancamentos.postValue(response.body())
                    val lancamentos = response.body()
                    Log.e("lancamentosViewModel", "listar lancamentos $response $lancamentos")
                    lancamentos?.forEach { lancamentos ->
                        Log.d("lancamentosViewModel", "${lancamentos}")
                    }

                } else {
                    val erro = response.errorBody()?.string() ?: "Erro desconhecido"
                    Log.e("lancamentosViewModel", "Erro ao listar lancamentos $erro")
                }
            } catch (e: Exception) {
                Log.e("lancamentosViewModel", "Erro ao listar cartões", e)
            }
        }
        return lancamentos
    }


    fun cadastrarLancamentoFixo(lancamentos: Lancamentos) {
        viewModelScope.launch {
            try {

                Log.e("LancamentoViewModel", "Enviando lancamento: $lancamentos")

                lancamentoRepository.cadastrarLancamento(lancamentos)

                _successEvent.value = true
            } catch (e: Exception) {

                Log.e("LancamentoViewModel", "Enviando lancamento: ${e.message}")

                _errorEvent.value = "Erro ao cadastrar lancamento: ${e.message}"
            }
        }
    }





}





















