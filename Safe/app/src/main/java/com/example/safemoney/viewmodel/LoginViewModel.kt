import android.content.Context
import android.content.SharedPreferences
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.safemoney.model.Senha
import com.example.safemoney.model.User
import com.example.safemoney.repositorio.ILoginRepository
import com.example.safemoney.viewmodel.CartaoViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class LoginViewModel(
    private val loginRepository: ILoginRepository,
    private val context: Context
) : ViewModel() {

    private val sharedPreferences: SharedPreferences by lazy {
        context.getSharedPreferences("user_session", Context.MODE_PRIVATE)
    }

    private val _loginResult = MutableLiveData<Boolean>()
    val loginResult: LiveData<Boolean> = _loginResult

    suspend fun fazerLogin(email: String, senha: String): Boolean {
        val response = loginRepository.loginUsuario(email, senha)
        return if (response.isSuccessful) {
            val token = response.body()?.token ?: ""
            val nome = response.body()?.nome ?: ""
            val email = response.body()?.email ?: ""
            val id = response.body()?.id ?: -1

            _loginResult.value = response.isSuccessful
            salvarDetalhesUsuario(token, nome, id, email)

            true
        } else {
            false
        }
    }

    private fun salvarDetalhesUsuario(token: String, nome: String, id: Int, email: String) {
        with(sharedPreferences.edit()) {
            putString("token", token)
            putString("nome", nome)
            putInt("id", id)
            putString("email", email)
            apply()
        }
    }
    suspend fun atualizarUsuario(nome: String, email: String, senha:String?): Boolean {
        val id = getId()
        val usuarioExistente = getUsuario(id)


        if (usuarioExistente != null) {

            val usuarioAtualizado = User(nome, email, senha)


            val response = loginRepository.atualizarUsuario(id, usuarioAtualizado)


            if (response.isSuccessful) {
                Log.d("LoginViewModel", "Dados do usuário atualizados com sucesso")
                return true
            } else {
                Log.e("LoginViewModel", "Erro na atualização do usuário: ${response.errorBody()?.string()}")
            }
        } else {
            Log.e("LoginViewModel", "Usuário não encontrado")
        }

        return false
    }


    suspend fun atualizarSenha(senha: String): Boolean {
        val id = getId()
        val senhaAtualizada = Senha(senha)
        val response = loginRepository.atualizarSenha(id, senhaAtualizada)

        if (response.isSuccessful) {
            Log.d("LoginViewModel", "Senha atualizada com sucesso")
            return true
        } else {
            Log.e("LoginViewModel", "Erro na atualização da senha: ${response.errorBody()?.string()}")
        }

        return false
    }

    suspend fun excluirUsuario(): Boolean {
        val id = getId()
        val response = loginRepository.excluirUsuario(id)

        if (response.isSuccessful) {
            Log.d("LoginViewModel", "Usuário excluído com sucesso")
            limparSessao()
            return true
        } else {
            Log.e("LoginViewModel", "Erro ao excluir usuário: ${response.errorBody()?.string()}")
            return false
        }
    }


    fun getToken(): String? {
        return sharedPreferences.getString("token", null)
    }

    fun getNome(): String? {
        return sharedPreferences.getString("nome", null)
    }
    fun getEmail(): String? {
        return sharedPreferences.getString("email", null)
    }

    fun getId(): Int {
        return sharedPreferences.getInt("id", -1)
    }

    fun limparSessao() {
        sharedPreferences.edit().clear().apply()
    }

    suspend fun getUsuario(id: Int): User? {
        val response = loginRepository.getUsuario(id)
        return if (response.isSuccessful) {
            response.body()
        } else {
            null
        }


    }
}
