import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.safemoney.model.Objetivos
import com.example.safemoney.repositorio.ObjetivoRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class ObjetivoViewModel(private val objetivoRepository: ObjetivoRepository, private val loginViewModel: LoginViewModel) : ViewModel() {

    companion object {
        private const val TAG = "ObjetivoViewModel"
    }

    private val _objetivos = MutableLiveData<List<Objetivos>>()
    val objetivos: LiveData<List<Objetivos>> = _objetivos

    init {
        getObjetivoById()
    }

    fun cadastrarObjetivo(objetivo: Objetivos) {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                Log.d(TAG, "Iniciando cadastro do objetivo: $objetivo")
                objetivoRepository.cadastrarObjetivo(objetivo)
                Log.d(TAG, "Objetivo cadastrado com sucesso: $objetivo")
                getObjetivoById()
            } catch (e: Exception) {
                Log.e(TAG, "Erro ao cadastrar o objetivo: $objetivo", e)
            }
        }
    }

    private fun getObjetivoById() {
        val userId = loginViewModel.getId()
        if (userId != -1) {
            viewModelScope.launch(Dispatchers.IO) {
                try {
                    val response = objetivoRepository.getObjetivoById(userId)
                    val objetivosList = response.body()
                    objetivosList?.let {
                        _objetivos.postValue(it)
                    } ?: Log.e(TAG, "Objetivos não encontrados para o ID: $userId")
                } catch (e: Exception) {
                    Log.e(TAG, "Erro ao obter os objetivos", e)
                }
            }
        } else {
            Log.e(TAG, "ID do usuário inválido")
        }
    }
}
