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
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.min
import androidx.compose.ui.unit.sp

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
            .width(300.dp)
            .height(160.dp)
    ) {
        // Imagem de fundo
        Image(
            painter = painterResource(id = R.drawable.image_cartao),
            contentDescription = null,
            contentScale = ContentScale.FillBounds,
            modifier = modifier.widthIn(min = 300.dp).fillMaxHeight()
        )

        Column (
            modifier = modifier
                .fillMaxWidth()
                .padding(16.dp)
        ){
            Row(
                modifier = modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Image(
                    painter = painterResource(id = R.drawable.logo_visa5),
                    contentDescription = null,
                    modifier = modifier
                        .width(40.dp)
                )

                Row () {
                    Text(
                        text = "Limite:",
                        color = Color.White,
                        textAlign = TextAlign.Center,
                        fontSize = 13.sp
                    )

                    Text(
                        text = "2.000,00",
                        color = Color.White,
                        textAlign = TextAlign.Center,
                        fontSize = 13.sp,
                        fontWeight = FontWeight.Bold
                    )
                }

            }

            Row(
                modifier = modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = "****  $numeroCartao",
                    color = Color.White,
                    textAlign = TextAlign.Center,
                    fontSize = 13.sp,
                    fontWeight = FontWeight.Bold
                )

                Row() {
                    Text(
                        text = "Fechamento:",
                        color = Color.White,
                        textAlign = TextAlign.Center,
                        fontSize = 13.sp
                    )

                    Text(
                        text = "21/10",
                        color = Color.White,
                        textAlign = TextAlign.Center,
                        fontSize = 13.sp,
                        fontWeight = FontWeight.Bold
                    )
                }

            }

            Row(
                modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = "Apelido do cartão",
                    color = Color.White,
                    textAlign = TextAlign.Center,
                    fontSize = 13.sp,
                    fontWeight = FontWeight.Bold
                )

                Row () {
                    Text(
                        text = "Vencimento:",
                        color = Color.White,
                        textAlign = TextAlign.Center,
                        fontSize = 13.sp
                    )

                    Text(
                        text = "29/10",
                        color = Color.White,
                        textAlign = TextAlign.Center,
                        fontSize = 13.sp,
                        fontWeight = FontWeight.Bold
                    )
                }

            }
        }
    }
}