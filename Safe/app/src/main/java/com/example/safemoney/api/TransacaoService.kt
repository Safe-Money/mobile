import com.example.safemoney.model.Receita
import retrofit2.http.Body
import retrofit2.http.POST

interface TransacaoService {
    @POST("transacoes/receita")
    suspend fun adicionarReceita(@Body r: Receita)

    @POST("lancamento-fixo/cadastrar")
    suspend fun adicionarReceitaFixa(@Body r: Receita)
}
