import com.example.cotacaomoedas4adsc.api.Rest
import retrofit2.Response

class CadastrarRepository : ICadastrarRepository {

    private val cadastrarService by lazy {
        Rest.getInstance().create(CadastrarService::class.java)
    }

    override suspend fun cadastrarUsuario(nome: String, dtNascimento: String, email: String, senha: String): Response<Usuario> {
        val usuario = Usuario(nome, dtNascimento, email, senha)
        val response: Response<Void> = cadastrarService.cadastrarUsuario(usuario)

        return if (response.isSuccessful) {

            Response.success(usuario)
        } else {

            Response.error(response.code(), response.errorBody()!!)
        }
    }
}
