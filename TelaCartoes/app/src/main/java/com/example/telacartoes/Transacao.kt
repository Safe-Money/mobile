package com.example.telacartoes

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

@Preview(
    showBackground = true
)
@Composable
fun TransacaoPreview() {
    Transacao(descricao = "Shopping")
}

@Composable
fun Transacao(
    modifier : Modifier = Modifier,
    descricao : String
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
                painter = painterResource(id = R.drawable.icon_shopping),
                contentDescription = null,
                modifier = modifier
                    .height(22.dp)
                    .width(22.dp)
            )

            Text(
                text = "Shopping",
                fontSize = 14.sp,
                fontWeight = FontWeight.Light
            )
        }

        Row(
            modifier = modifier
                .width(140.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
        ){
            Text(
                text = "01/10",
                fontSize = 14.sp,
                fontWeight = FontWeight.Light
            )

            Text(
                text = "R$ 80,60",
                fontSize = 14.sp,
                fontWeight = FontWeight.Normal
            )
        }
    }
}