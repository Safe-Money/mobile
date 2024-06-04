package com.example.safemoney.cartoes

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview

import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.safemoney.R
import com.example.safemoney.viewmodel.TransacaoViewModel

@Preview(
    showBackground = true,
)
@Composable
fun TransacaoCartaoPreview() {
    TransacaoCartao(
        imagemResId = R.drawable.saude,
        nome = "Shopping",
        data = "2024-03-91",
        valor = 100000.0)
}

@Composable
fun TransacaoCartao(
//    descricao: String,
    modifier: Modifier = Modifier,
    @DrawableRes
    imagemResId: Int,
    nome: String,
    data: String,
    valor: Double
) {

    Row(
        modifier = modifier
            .fillMaxWidth()
            .height(45.dp)
            .padding(8.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ){
        Row(
            modifier = modifier
                .width(100.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = imagemResId),
                contentDescription = null,
                modifier = modifier
                    .height(22.dp)
                    .width(22.dp)
            )

            Text(
                text = nome,
                fontSize = 14.sp,
                fontWeight = FontWeight.Light
            )
        }

        Row(
            modifier = modifier
                .width(200.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
        ){
            Text(
                text = data,
                fontSize = 14.sp,
                fontWeight = FontWeight.Light
            )

            val valorDouble = valor.toDouble()
            Text(
                text = String.format("R$ %.2f", valorDouble),
                fontSize = 14.sp,
                fontWeight = FontWeight.Normal
            )
        }
    }
}