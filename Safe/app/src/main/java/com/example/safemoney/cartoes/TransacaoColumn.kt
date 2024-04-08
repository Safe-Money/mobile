package com.example.safemoney.cartoes

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Divider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.safemoney.ui.theme.CinzaDivisor


@Preview(
    showBackground = true,
)
@Composable
fun TransacaoColumnPreview() {
    TransacaoColumn()
}

@Composable
fun TransacaoColumn(
    modifier: Modifier = Modifier
) {
    Column (
        modifier = modifier
            .fillMaxWidth()
            .padding(28.dp, 16.dp),
    ) {
        val mockList = Transacoes.getMockList()

        mockList.forEachIndexed { index, transacao ->
            Transacao(descricao = transacao.descricao)

            if (index < mockList.size - 1) {
                Divider(
                    modifier = Modifier
                        .fillMaxWidth(),
                    color = CinzaDivisor,
                    thickness = 0.6.dp
                )
            }

        }
    }
}

data class Transacoes(
    val descricao: String
) {
    companion object{
        fun getMockList(): List<Transacoes> {
            return List(7) {
                Transacoes(descricao = "Shopping")
            }
        }
    }
}