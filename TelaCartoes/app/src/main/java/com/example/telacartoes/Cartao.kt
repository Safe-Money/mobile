package com.example.telacartoes

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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
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
import com.example.telacartoes.ui.theme.CardTypography

@Preview
@Composable
fun CartaoPreview() {
    Cartao(numeroCartao = "0805")
}

@Composable
fun Cartao(
    modifier: Modifier = Modifier,
    numeroCartao: String,
) {

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
            modifier = modifier
                .widthIn(min = 300.dp)
                .fillMaxHeight()
        )

        Column (
            modifier = modifier
                .fillMaxSize()
                .padding(16.dp, 24.dp),
            verticalArrangement = Arrangement.SpaceBetween
        ){
            Row(
                modifier = modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(id = R.drawable.logo_visa5),
                    contentDescription = null,
                    modifier = modifier
                        .width(40.dp)
                )

                Row (
                    modifier = modifier.width(90.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "Limite:",
                        style = CardTypography.bodySmall
                    )

                    Text(
                        text = "2.000,00",
                        style = CardTypography.bodyLarge
                    )
                }

            }

            Column(
                modifier = modifier
                    .height(40.dp),
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                Row(
                    modifier = modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "****  $numeroCartao",
                        style = CardTypography.bodyLarge
                    )

                    Row(
                        modifier = modifier.width(100.dp),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(
                            text = "Fechamento:",
                            style = CardTypography.bodySmall
                        )

                        Text(
                            text = "21/10",
                            style = CardTypography.bodyLarge
                        )
                    }

                }

                Row(
                    modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "Apelido do cartão",
                        style = CardTypography.bodyLarge
                    )

                    Row (
                        modifier = modifier.width(100.dp),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(
                            text = "Vencimento:",
                            style = CardTypography.bodySmall
                        )

                        Text(
                            text = "29/10",
                            style = CardTypography.bodyLarge
                        )
                    }

                }
            }

        }
    }
}