    package com.example.safemoney.cartoes

    import android.util.Log
    import androidx.compose.foundation.layout.Arrangement
    import androidx.compose.foundation.layout.Column
    import androidx.compose.foundation.layout.PaddingValues
    import androidx.compose.foundation.layout.fillMaxWidth
    import androidx.compose.foundation.layout.height
    import androidx.compose.foundation.layout.padding
    import androidx.compose.foundation.layout.width
    import androidx.compose.foundation.lazy.LazyColumn
    import androidx.compose.foundation.lazy.items
    import androidx.compose.material3.Divider
    import androidx.compose.runtime.Composable
    import androidx.compose.runtime.LaunchedEffect
    import androidx.compose.runtime.livedata.observeAsState
    import androidx.compose.runtime.mutableStateOf
    import androidx.compose.runtime.remember
    import androidx.compose.ui.Modifier
    import androidx.compose.ui.tooling.preview.Preview
    import androidx.compose.ui.unit.dp
    import com.example.safemoney.R
    import com.example.safemoney.model.Cartao
    import com.example.safemoney.model.CartaoGet
    import com.example.safemoney.model.Transacao
    import com.example.safemoney.painel.TransacaoTableRow
    import com.example.safemoney.ui.theme.CinzaDivisor
    import com.example.safemoney.viewmodel.TransacaoViewModel
    import java.time.LocalDate


    //@Preview(
    //    showBackground = true,
    //)
    //@Composable
    //fun TransacaoColumnPreview() {
    //    TransacaoColumn(cartao = cartao.cartaoGet)
    //}

    @Composable
    fun TransacaoColumn(
        modifier: Modifier = Modifier,
        transacaoViewModel: TransacaoViewModel,
        idCartao: Int,
        selectedMonth: LocalDate
    ) {
        val listaFaturaCartao = transacaoViewModel.faturaCartao.observeAsState(initial = emptyList()).value
        val filteredTransacoes = listaFaturaCartao.filter { transacao ->
            val transacaoDate = LocalDate.parse(transacao.data) // Supondo que a data esteja no formato "yyyy-MM-dd"
            transacaoDate.month == selectedMonth.month && transacaoDate.year == selectedMonth.year
        }

        LaunchedEffect(idCartao) {
            Log.d("TransacaoColumn", "ID do cartão utilizado: $idCartao") // Log do ID do cartão
            transacaoViewModel.listarFaturaCartao(idCartao)
        }

        Column (
            modifier = modifier
                .fillMaxWidth()
                .padding(28.dp, 16.dp),
        ) {
    //        val mockList = Transacoes.getMockList()
            LazyColumn(
                modifier = Modifier
                    .height(250.dp)
                    .fillMaxWidth()
            ) {
                items(filteredTransacoes) { conta ->
                    val image = when (conta.categoria.nome) {
                        "saúde" -> R.drawable.saude
                        "alimentacao" -> R.drawable.alimentacao
                        "lazer" -> R.drawable.game
                        "gym" -> R.drawable.icon___academia
                        "pet" -> R.drawable.pet
                        "vestuario" -> R.drawable.icon___shopping
                        "economia" -> R.drawable.economia
                        "transporte" -> R.drawable.onibus_escolar
                        else -> R.drawable.safemoney2
                    }
                    TransacaoCartao(
                        imagemResId = image,
                        nome = conta.nome,
                        data = conta.data,
                        valor = conta.valor
                    )
                }
            }
        }
    }

    //data class Transacoes(
    //    val descricao: String
    //) {
    //    companion object{
    //        fun getMockList(): List<Transacoes> {
    //            return List(7) {
    //                Transacoes(descricao = "Shopping")
    //            }
    //        }
    //    }
    //}