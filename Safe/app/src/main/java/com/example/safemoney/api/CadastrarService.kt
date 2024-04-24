import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface CadastrarService {
    @POST("usuarios/cadastro")
    suspend fun cadastrarUsuario(@Body usuario: Usuario): Response<Void>
}
