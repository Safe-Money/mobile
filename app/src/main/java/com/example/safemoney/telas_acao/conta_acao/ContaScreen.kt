package com.example.safemoney.telas_acao.conta_acao

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.safemoney.telas_acao.buttons.ButtonsRow
import com.example.safemoney.telas_acao.inputs.ApelidoInput
import com.example.safemoney.telas_acao.inputs.BancoInput
import com.example.safemoney.telas_acao.inputs.DataFechamentoInput
import com.example.safemoney.telas_acao.inputs.DataVencimentoInput
import com.example.safemoney.telas_acao.inputs.LimiteInput
import com.example.safemoney.telas_acao.inputs.SaldoInput
import com.example.safemoney.telas_acao.inputs.TipoContaInput


@Preview
@Composable
fun ContaScreenPreview() {
    ContaScreen()
}

@Composable
fun ContaScreen(
    modifier: Modifier = Modifier
) {
    Scaffold(
        topBar = {
            TopBarConta()
        }
    ) {contentPadding ->
        Column (
            modifier
                .padding(contentPadding)
                .padding(16.dp)
        ) {
            ApelidoInput()

            TipoContaInput()

            SaldoInput()

            BancoInput ()

            ButtonsRow()
        }
    }
}