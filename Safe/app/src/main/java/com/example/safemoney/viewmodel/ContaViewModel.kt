import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.safemoney.repositorio.IContaRepository
import com.example.safemoney.repositorio.ILoginRepository
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ContaViewModel(
    private val contaRepository: IContaRepository
) : ViewModel() {
    val contasState: MutableState<List<UserConta>> = mutableStateOf(emptyList())

    private val _contasLiveData = MutableLiveData<List<UserConta>>()
    val contasLiveData: LiveData<List<UserConta>> = _contasLiveData

    val cadastroSucesso = mutableStateOf(false)
    private val coroutineExceptionHandler = CoroutineExceptionHandler { _, exception ->
        Log.e("ContaViewModel", "Erro ao cadastrar a conta", exception)
    }

    fun cadastrarConta(conta: UserConta) {
        CoroutineScope(Dispatchers.IO + coroutineExceptionHandler).launch {
            try {
                val response = contaRepository.cadastrarConta(conta)
                if (response.isSuccessful) {
                    cadastroSucesso.value = true
                    Log.d("ContaViewModel", "Conta cadastrada com sucesso!")
                    listarContas(conta.fkUsuario.id)
                } else {
                    Log.e("ContaViewModel", "Erro ao cadastrar a conta")
                }
            } catch (e: Exception) {
                Log.e("ContaViewModel", "Erro ao cadastrar a conta", e)
            }
        }
    }

    fun listarContas(userId: Int): LiveData<List<UserConta>> {
        CoroutineScope(Dispatchers.IO + coroutineExceptionHandler).launch {
            try {
                val response = contaRepository.listarContas(userId)
                if (response.isSuccessful) {
                    _contasLiveData.postValue(response.body())
                    Log.e("ContaViewModel", "listar as contas $response")

                } else {
                    val erro = response.errorBody()?.string() ?: "Erro desconhecido"
                    Log.e("ContaViewModel", "Erro ao listar as contas $erro")
                }
            } catch (e: Exception) {
                Log.e("ContaViewModel", "Erro ao listar as contas", e)
            }
        }
        return contasLiveData
    }
}


