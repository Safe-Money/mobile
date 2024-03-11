package com.example.telacartoes.ui.theme

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.telacartoes.Cartao

@Preview(
    showBackground = true,
    widthDp = 300
)
@Composable
fun CartaoRowPreview() {
    CartaoRow()
}

@Composable
fun CartaoRow(
    modifier: Modifier = Modifier
) {
    LazyRow(
        modifier = modifier,
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        contentPadding = PaddingValues(
            horizontal = 16.dp
        )
    ) {
        items(Cartoes.getMockList()) { cartao ->
            Cartao(
                numeroCartao = cartao.numeroCartao
            )
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