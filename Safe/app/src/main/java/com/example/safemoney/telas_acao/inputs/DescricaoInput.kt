package com.example.safemoney.telas_acao.inputs

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.safemoney.ui.theme.Branco
import com.example.safemoney.ui.theme.CinzaAcao
import com.example.safemoney.ui.theme.TelaAcaoTypography
import com.example.safemoney.ui.theme.VerdeFocus

@Preview
@Composable
fun DescricaoInputPreview() {
    DescricaoInput()
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DescricaoInput(
    modifier : Modifier = Modifier
) {
    var valor by remember{
        mutableStateOf("")
    }

    var color by remember{
        mutableStateOf(CinzaAcao)
    }

    Column (
        modifier = modifier
            .fillMaxWidth()
            .height(90.dp)
            .background(Branco)
    ) {
        Text(
            text = "Descrição",
            style = TelaAcaoTypography.bodySmall,
            color = color
        )
        TextField(
            value = valor,
            onValueChange = {
                valor = it
            },
            colors = TextFieldDefaults.textFieldColors(
                containerColor = Branco,
                focusedIndicatorColor = VerdeFocus,
                unfocusedIndicatorColor = CinzaAcao,
            ),
            modifier = modifier
                .fillMaxWidth()
                .onFocusChanged {
                    color = if (it.isFocused) VerdeFocus else CinzaAcao
                }
        )
    }
}