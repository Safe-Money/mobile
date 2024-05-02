package com.example.safemoney.telas_acao.transicao_acao

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.safemoney.telas_acao.buttons.ButtonsRow
import com.example.safemoney.telas_acao.buttons.SwitchButton
import com.example.safemoney.telas_acao.inputs.ContaRemetenteInput
import com.example.safemoney.telas_acao.inputs.DataInput
import com.example.safemoney.telas_acao.inputs.DescricaoInput
import com.example.safemoney.telas_acao.inputs.DropInput
import com.example.safemoney.telas_acao.inputs.ValorInput

@Preview
@Composable
fun TransicaoScreenPreview() {
    TransicaoScreen()
}

@Composable
fun TransicaoScreen(
    modifier: Modifier = Modifier
) {
    Scaffold(
        topBar = {
            TopBarTransicao()
        }
    ) {contentPadding ->
        Column (
            modifier
                .padding(contentPadding)
                .padding(16.dp)
        ) {
            ContaRemetenteInput()



            DescricaoInput()




        }
    }
}