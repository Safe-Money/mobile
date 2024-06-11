import com.example.cotacaomoedas4adsc.api.Rest
import com.example.safemoney.model.TokenJWT
import com.example.safemoney.api.LoginService
import com.example.safemoney.model.Credenciais
import com.example.safemoney.model.Senha
import com.example.safemoney.model.User

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
    override suspend fun atualizarUsuario(id: Int, usuario: User): Response<Unit> {
        return loginService.atualizarUsuario(id, usuario)
    }

    override suspend fun excluirUsuario(id: Int): Response<Unit> {
        return loginService.excluirUsuario(id)
    }

    override suspend fun atualizarSenha(id: Int, usuario: Senha): Response<Unit> {
        return loginService.atualizarSenha(id, usuario)
    }
    override suspend fun getUsuario(id: Int): Response<User> {
        return loginService.getUsuario(id)
    }




}
