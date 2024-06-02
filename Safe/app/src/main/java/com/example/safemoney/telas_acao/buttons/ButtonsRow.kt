package com.example.safemoney.telas_acao.buttons

import android.graphics.DashPathEffect
import android.graphics.PathEffect
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PaintingStyle.Companion.Stroke
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.safemoney.ui.theme.Branco
import com.example.safemoney.ui.theme.CinzaAcao
import com.example.safemoney.ui.theme.CinzaDivisor
import com.example.safemoney.ui.theme.VerdeEscuro


@Preview
@Composable
fun ButtonsRowPreview() {

}

@Composable
fun ButtonsRow(
    modifier: Modifier = Modifier,
    navController: NavController,
    onAddButtonClick: () -> Unit,
    onCancelButtonClick: () -> Unit,
) {
    Row (
        modifier = modifier
            .fillMaxWidth()
            .background(Branco),
        horizontalArrangement = Arrangement.End
    ) {
        Button(
            onClick = {
                onCancelButtonClick()
            },
            colors = ButtonDefaults.buttonColors(Branco),
        ) {
            Column (
                horizontalAlignment = Alignment.CenterHorizontally
            ){
                Spacer(modifier = modifier.height(6.dp))

                Text(
                    text = "Cancelar",
                    color = CinzaAcao,
                    modifier = modifier
                        .height(25.dp)
                )

                Canvas(modifier = modifier.size(90.dp, 1.dp)) {
                    val strokeWidth = 1f // Espessura da linha
                    val dotSpacing = 8f // Espaçamento entre os pontos
                    val dotSize = 4f // Tamanho dos pontos
                    var x = 0f

                    // Desenha a linha pontilhada
                    while (x < size.width) {
                        drawLine(
                            color = Color.Black, // Cor da linha
                            start = Offset(x, size.height / 2), // Ponto inicial do segmento de linha
                            end = Offset(x + dotSize, size.height / 2), // Ponto final do segmento de linha
                            strokeWidth = strokeWidth, // Espessura da linha
                            cap = StrokeCap.Round // Arredonda as extremidades dos segmentos de linha
                        )
                        x += dotSpacing + dotSize // Move para o próximo ponto
                    }
                }
            }
        }

        Spacer(
            modifier = modifier
                .width(15.dp)
        )

        Button(
            onClick = { onAddButtonClick() },
            colors = ButtonDefaults.buttonColors(VerdeEscuro)
        ) {
            Text(text = "Salvar")
        }
    }
}