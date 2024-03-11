package com.example.telacartoes

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.width
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
import androidx.compose.ui.unit.sp

@Preview(showBackground = true)
@Composable
fun CartaoPreview() {
    Cartao(numeroCartao = "0805")
}

@Composable
fun Cartao(
    modifier: Modifier = Modifier,
    numeroCartao: String,
) {

    Box() {
        // Imagem de fundo
        Image(
            painter = painterResource(id = R.drawable.image_cartao),
            contentDescription = null,
            modifier = Modifier.fillMaxWidth(),
            contentScale = ContentScale.Crop
        )

        // Texto sobreposto
        Text(
            text = "Limite:",
            color = Color.White,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .offset(x = 230.dp, y = 50.dp),
            fontSize = 13.sp
        )

        Text(
            text = "2.000,00",
            color = Color.White,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .offset(x = 290.dp, y = 50.dp),
            fontSize = 13.sp,
            fontWeight = FontWeight.Bold
        )

        Text(
            text = "Fechamento:",
            color = Color.White,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .offset(x = 229.dp, y = 160.dp),
            fontSize = 13.sp
        )

        Text(
            text = "21/10",
            color = Color.White,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .offset(x = 308.dp, y = 160.dp),
            fontSize = 13.sp,
            fontWeight = FontWeight.Bold
        )

        Text(
            text = "Vencimento:",
            color = Color.White,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .offset(x = 229.dp, y = 190.dp),
            fontSize = 13.sp
        )

        Text(
            text = "29/10",
            color = Color.White,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .offset(x = 308.dp, y = 190.dp),
            fontSize = 13.sp,
            fontWeight = FontWeight.Bold
        )

        Image(
            painter = painterResource(id = R.drawable.logo_visa5),
            contentDescription = null,
            modifier = modifier
                .width(50.dp)
                .offset(x = 32.dp, y = 50.dp),
        )

        Text(
            text = "****  $numeroCartao",
            color = Color.White,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .offset(x = 32.dp, y = 160.dp),
            fontSize = 13.sp,
            fontWeight = FontWeight.Bold
        )

        Text(
            text = "Apelido do cartão",
            color = Color.White,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .offset(x = 32.dp, y = 190.dp),
            fontSize = 13.sp,
            fontWeight = FontWeight.Bold
        )
    }
}