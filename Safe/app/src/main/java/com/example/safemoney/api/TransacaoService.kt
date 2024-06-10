import com.example.safemoney.model.Transacao
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface TransacaoService {
    @POST("transacoes/receita")
    suspend fun adicionarReceita(@Body r: Transacao)

    @POST("lancamento-fixo/cadastrar")
    suspend fun adicionarFixa(@Body r: Transacao)

    @POST("transacoes/despesa")
    suspend fun adicionarDespesa(@Body r: Transacao)

    @GET("transacoes/listar-gastos/{id}")
    suspend fun listarTransacoes(@Path("id") idUser: Int): Response<List<Transacao>>

    @GET("cartao-credito/listar-fatura-cartao/{idCartao}")
    suspend fun getGastoCartao(@Path("idCartao") idCartao: Int): Response<List<Transacao>>
}
