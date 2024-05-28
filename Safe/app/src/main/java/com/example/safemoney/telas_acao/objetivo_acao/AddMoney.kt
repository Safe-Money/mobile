package com.example.safemoney.telas_acao.objetivo_acao

import LoginViewModel
import ObjetivoViewModel
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.example.safemoney.telas_acao.cartao_acao.TopBarObjetivos
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.safemoney.model.Objetivos
import com.example.safemoney.telas_acao.buttons.ButtonsRow
import com.example.safemoney.telas_acao.inputs.ValorInput

@Composable
fun AddMoneyScreen(
    navController: NavController,
    loginViewModel: LoginViewModel,
    objetivoViewModel: ObjetivoViewModel,
    objetivoId: Int,
    modifier: Modifier = Modifier
) {
    val valor = remember { mutableStateOf("") }

    Scaffold(
        topBar = {
            TopBarObjetivos()
        }
    ) { contentPadding ->
        Column(
            modifier
                .padding(contentPadding)
                .padding(16.dp)
        ) {
            ValorInput(
                value = valor.value,
                onValueChange = { valor.value = it }
            )

            ButtonsRow(
                navController = navController,
                onAddButtonClick = {
                    val valorInvestido = valor.value.toDoubleOrNull()
                    if (valorInvestido != null) {
                        objetivoViewModel.adicionarValorInvestido(objetivoId, valorInvestido)
                        navController.navigate("objetivo")
                    } else {

                    }
                },
                onCancelButtonClick = { navController.navigate("objetivo") }
            )
        }
    }
}
