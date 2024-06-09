
import com.example.safemoney.model.CartaoGet
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface LancamentoService {
    @POST("lancamento-fixo/cadastrar")
    suspend fun cadastrarLancamento(@Body lancamento: Lancamentos)

    @GET("lancamento-fixo/buscar-fixos/{id}")
    suspend fun listarLancamento(@Path("id") contaId: Int): Response<List<LancamentosGet>>

    @GET("graficos/previsto/{id}")
    suspend fun listarTotalFixos(@Path("id") userId: Int): Response<LancFixoTotal>
}