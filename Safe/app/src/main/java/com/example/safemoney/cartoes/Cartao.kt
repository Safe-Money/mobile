package com.example.safemoney.cartoes

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.min
import androidx.compose.ui.unit.sp
import com.example.safemoney.R
import com.example.safemoney.model.Cartao
import com.example.safemoney.model.CartaoGet
import com.example.safemoney.painel.CartoesTableRow
import com.example.safemoney.ui.theme.CardTypography
import com.example.safemoney.viewmodel.CartaoViewModel
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.Locale

@Composable
fun Cartao(
    modifier: Modifier = Modifier,
    cartao: CartaoGet,

) {
    val bandeiraImageMap = mapOf(
        "visa" to R.mipmap.logo_visa5,
        "mastercard" to R.mipmap.mastercard,
        "elo" to R.mipmap.elo_branco
    )


    Box(
        modifier = modifier
            .width(260.dp)
            .height(160.dp)
            .clip(RoundedCornerShape(16.dp))
    ) {
        // Imagem de fundo
        Image(
            painter = painterResource(id = R.drawable.image_card),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .widthIn(min = 300.dp)
                .fillMaxHeight()
        )

        Column (
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp, 24.dp),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(id = bandeiraImageMap[cartao.bandeira.toLowerCase()] ?: R.drawable.safemoney2),
                    contentDescription = null,
                    modifier = Modifier.width(40.dp)
                )

                Column (
                    modifier = Modifier.width(90.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = "Limite:",
                        style = CardTypography.bodySmall
                    )
                    Text(
                        text = cartao.limite.toString(),
                        style = CardTypography.bodyLarge
                    )
                }
            }

            Column(
                modifier = Modifier.height(40.dp),
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "",
                        style = CardTypography.bodyLarge
                    )
                    Row(
                        modifier = Modifier.width(100.dp),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(
                            text = "Fechamento:",
                            style = CardTypography.bodySmall
                        )
                        val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd", Locale.getDefault())
                        val dataFechamento = LocalDate.parse(cartao.fechamento, formatter)

                        val fechamentoFormatado = dataFechamento.format(DateTimeFormatter.ofPattern("dd/MM", Locale.getDefault()))
                        Text(
                            text = fechamentoFormatado,
                            style = CardTypography.bodyLarge
                        )
                    }
                }
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = cartao.nome,
                        style = CardTypography.bodyLarge
                    )
                    Row(
                        modifier = Modifier.width(100.dp),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(
                            text = "Vencimento:",
                            style = CardTypography.bodySmall
                        )
                        val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd", Locale.getDefault())
                        val dataVencimento = LocalDate.parse(cartao.vencimento, formatter)

                        val vencimentoFormatado = dataVencimento.format(DateTimeFormatter.ofPattern("dd/MM", Locale.getDefault()))
                        Text(
                            text = vencimentoFormatado,
                            style = CardTypography.bodyLarge
                        )
                    }
                }
            }
        }
    }
}