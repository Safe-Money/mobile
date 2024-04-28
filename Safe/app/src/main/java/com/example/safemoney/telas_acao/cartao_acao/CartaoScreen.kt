package com.example.safemoney.telas_acao.cartao_acao

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.safemoney.telas_acao.buttons.ButtonsRow
import com.example.safemoney.telas_acao.conta_acao.TopBarConta
import com.example.safemoney.telas_acao.inputs.ApelidoInput
import com.example.safemoney.telas_acao.inputs.BandeiraInput
import com.example.safemoney.telas_acao.inputs.ContaVinculadaInput
import com.example.safemoney.telas_acao.inputs.DataFechamentoInput
import com.example.safemoney.telas_acao.inputs.DataVencimentoInput
import com.example.safemoney.telas_acao.inputs.LimiteInput
import com.example.safemoney.telas_acao.inputs.UltimosQuatroInput

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
            TopBarCartao()
        }
    ) {contentPadding ->
        Column (
            modifier
                .padding(contentPadding)
                .padding(16.dp)
        ) {


            DataFechamentoInput()

            DataVencimentoInput()

            LimiteInput()

            UltimosQuatroInput()

            BandeiraInput()

            ContaVinculadaInput()


        }
    }
}