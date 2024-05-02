package com.example.safemoney.cartoes

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.magnifier
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.safemoney.model.Cartao
import com.example.safemoney.model.CartaoGet
import com.example.safemoney.ui.theme.CinzaDivisor
import com.example.safemoney.ui.theme.CinzaLetra
import com.example.safemoney.ui.theme.VerdeClaro





fun CartaoGet.toCartao(): Cartao {
    return Cartao(
        nome = this.nome,
        bandeira = this.bandeira,
        limite = this.limite,
        dataVencimento = this.vencimento,
        dataFechamento = this.fechamento,
        conta = this.conta
    )
}

@Composable
fun CartaoRow(
    modifier: Modifier = Modifier,
    cartoes: List<CartaoGet>,
)




{
    Column {

        Spacer(modifier = modifier.height(30.dp))

        LazyRow(
            modifier = modifier,
            horizontalArrangement = Arrangement.spacedBy(20.dp),
            contentPadding = PaddingValues(
                horizontal = 64.dp
            )
        )
            {
                items(cartoes) { cartao ->
                    Cartao(cartao = cartao)
                }
            }

        Row(
            modifier = modifier
                .fillMaxWidth()
                .height(80.dp),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Row (
                modifier = modifier
                    .width(192.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ){
                Column (
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.SpaceBetween,
                    modifier = modifier.height(36.dp)
                ){
                    Text(
                        text = "R$1.500,00",
                        fontSize = 14.sp
                    )
                    Divider(
                        modifier = Modifier
                            .width(70.dp)
                            .clip(RoundedCornerShape(3.dp)),
                        color = VerdeClaro,
                        thickness = 2.dp
                    )
                    Text(
                        text = "Fatura",
                        fontSize = 10.sp,
                        color = CinzaLetra
                    )
                }
                Column (
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.SpaceBetween,
                    modifier = modifier.height(36.dp)
                ){
                    Text(
                        text = "R$500,00",
                        fontSize = 14.sp
                    )
                    Divider(
                        modifier = Modifier
                            .width(70.dp)
                            .clip(RoundedCornerShape(3.dp)),
                        color = CinzaDivisor,
                        thickness = 2.dp
                    )
                    Text(
                        text = "Disponível",
                        fontSize = 10.sp,
                        color = CinzaLetra
                    )
                }
            }
        }
    }

}

data class Cartoes(
    val numeroCartao: String
) {
    companion object{
        fun getMockList(): List<Cartoes> {
            return List(3) {
                Cartoes(numeroCartao = "000$it")
            }
        }
    }
}