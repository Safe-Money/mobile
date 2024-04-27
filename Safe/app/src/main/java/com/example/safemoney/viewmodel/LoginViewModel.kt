import android.content.Context
import android.content.SharedPreferences
import androidx.lifecycle.ViewModel
import com.example.safemoney.repositorio.ILoginRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class LoginViewModel(
    private val loginRepository: ILoginRepository,
    private val context: Context
) : ViewModel() {

    private val sharedPreferences: SharedPreferences by lazy {
        context.getSharedPreferences("user_session", Context.MODE_PRIVATE)
    }

    suspend fun fazerLogin(email: String, senha: String): Boolean {
        val response = loginRepository.loginUsuario(email, senha)
        return if (response.isSuccessful) {
            val token = response.body()?.token ?: ""
            val nome = response.body()?.nome ?: ""
            val email = response.body()?.email ?: ""
            val id = response.body()?.id ?: -1


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
}
