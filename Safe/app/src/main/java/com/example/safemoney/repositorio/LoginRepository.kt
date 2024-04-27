import com.example.cotacaomoedas4adsc.api.Rest
import com.example.safemoney.model.TokenJWT
import com.example.safemoney.api.LoginService
import com.example.safemoney.model.Credenciais

import com.example.safemoney.repositorio.ILoginRepository
import retrofit2.Response


class LoginRepository : ILoginRepository {

    private val loginService by lazy {
        Rest.getInstance().create(LoginService::class.java)
    }

    override suspend fun loginUsuario(email: String, senha: String): Response<TokenJWT> {
        val credenciais = Credenciais(email, senha)
        return loginService.loginUser(credenciais)
    }


}
