package com.example.safemoney.telas_acao.objetivo_acao

import ValorMoedaInput
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.safemoney.telas_acao.buttons.ButtonsRow
import com.example.safemoney.telas_acao.objetivo_acao.inputs.ButtonsEdit
import com.example.safemoney.telas_acao.objetivo_acao.inputs.DataObjetivoInput
import com.example.safemoney.telas_acao.objetivo_acao.inputs.NameInput
import com.example.safemoney.telas_acao.objetivo_acao.inputs.UrlInput

@Preview
@Composable
fun EditarObjetivoPreview(){
    EditarObjetivo()
}

@Composable
fun EditarObjetivo(
    modifier: Modifier = Modifier
){
    Scaffold(
        topBar = {
            TopBarObjetivo(text = "Editar Objetivo")
        }
    ) {contentPadding ->
        Column (
            modifier
                .padding(contentPadding)
                .padding(16.dp)
        ) {
            NameInput()

            DataObjetivoInput(label = "Data Início")

            DataObjetivoInput(label = "Data de Término")

            UrlInput()

            ValorMoedaInput()

            ButtonsEdit()
        }
    }
}