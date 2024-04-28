import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface ContaService {
    @POST("contas/")
    suspend fun cadastrarConta(@Body conta: UserConta): Response<Void>

    @GET("contas/listar-contas/{id}")
    suspend fun listarContas(@Path("id") userId: Int): Response<List<UserConta>>
}
