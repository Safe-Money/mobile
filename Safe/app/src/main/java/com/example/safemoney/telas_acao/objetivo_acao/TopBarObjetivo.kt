package com.example.safemoney.telas_acao.objetivo_acao

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.safemoney.R
import com.example.safemoney.ui.theme.Branco
import com.example.safemoney.ui.theme.TelaAcaoTypography
import com.example.safemoney.ui.theme.VerdeEscuro

@Preview
@Composable
fun TopBarObjetivoPreview() {
    TopBarObjetivo(text = "Novo Objetivo")
}

@Composable
fun TopBarObjetivo(
    modifier: Modifier = Modifier,
    text: String
) {
    Row (
        modifier = modifier
            .background(VerdeEscuro)
            .fillMaxWidth()
            .padding(16.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ){
        Text(
            text = text,
            style = TelaAcaoTypography.bodyLarge,
            fontFamily = FontFamily(Font(R.font.montserrat_semibold))
        )

        Icon(
            imageVector = Icons.Default.Close,
            contentDescription = null,
            tint = Branco
        )
    }
}