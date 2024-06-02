package com.example.safemoney.telas_acao.despesa_acao

import Conta
import Conta1
import LoginViewModel
import UserConta
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.safemoney.model.Categoria
import com.example.safemoney.telas_acao.buttons.ButtonsRow
import com.example.safemoney.telas_acao.buttons.SwitchButton
import com.example.safemoney.telas_acao.inputs.DataInput
import com.example.safemoney.telas_acao.inputs.DescricaoInput
import com.example.safemoney.telas_acao.inputs.DropInput
import com.example.safemoney.telas_acao.inputs.ValorInput

@Composable
fun DespesaScreen(
    modifier: Modifier = Modifier,
    loginViewModel: LoginViewModel = viewModel(),
    categorias: List<Categoria>,
    contas: List<UserConta>
) {
    val valor = remember {
        mutableStateOf("")
    }
    val data = remember {
        mutableStateOf(System.currentTimeMillis())
    }
    val categoriaSelecionadaId = remember { mutableStateOf<Int?>(null) }
    val categoriaSelecionadaNome = remember { mutableStateOf<String?>(null) }
    Scaffold(
        topBar = {
            TopBarDespesa()
        }
    ) {contentPadding ->
        Column (
            modifier
                .padding(contentPadding)
                .padding(16.dp)
        ) {

            ValorInput(
                value = valor.value,
                onValueChange = { valor.value = it }

            )

            DataInput(
                value = data.value,
                onValueChange = { data.value = it }
            )

            DescricaoInput(
                valor = valor.value,
                onValueChange = { valor.value = it }
            )
            
            /*
            DropInput(categorias = categorias, onChange = )



            SwitchButton()

            */
        }
    }
}