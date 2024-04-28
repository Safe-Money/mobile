import android.util.Log
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


    private val coroutineExceptionHandler = CoroutineExceptionHandler { _, exception ->
        Log.e("ContaViewModel", "Erro ao cadastrar a conta", exception)
    }

    fun cadastrarConta(conta: UserConta) {
        CoroutineScope(Dispatchers.IO + coroutineExceptionHandler).launch {
            try {
                val response = contaRepository.cadastrarConta(conta)
                if (response.isSuccessful) {
                    Log.d("ContaViewModel", "Conta cadastrada com sucesso!")
                } else {
                    Log.e("ContaViewModel", "Erro ao cadastrar a conta")
                }
            } catch (e: Exception) {
                Log.e("ContaViewModel", "Erro ao cadastrar a conta", e)
            }
        }
    }

    fun listarContas(userId: Int): LiveData<List<UserConta>> {
        val contasLiveData = MutableLiveData<List<UserConta>>()

        CoroutineScope(Dispatchers.IO + coroutineExceptionHandler).launch {
            try {
                val response = contaRepository.listarContas(userId)
                if (response.isSuccessful) {
                    contasLiveData.postValue(response.body())
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



