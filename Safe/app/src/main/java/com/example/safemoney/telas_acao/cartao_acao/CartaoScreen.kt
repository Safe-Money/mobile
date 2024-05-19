package com.example.safemoney.telas_acao.cartao_acao

import DataFechamentoInput
import LoginViewModel
import UserConta
import Usuario
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.safemoney.cartoes.Cartao
import com.example.safemoney.model.Cartao
import com.example.safemoney.model.ContaBanco
import com.example.safemoney.model.FkUsuario
import com.example.safemoney.telas_acao.buttons.ButtonsRow
import com.example.safemoney.telas_acao.conta_acao.TopBarConta
import com.example.safemoney.telas_acao.inputs.BandeiraInput
import com.example.safemoney.telas_acao.inputs.ContaVinculadaInput
import com.example.safemoney.telas_acao.inputs.DataVencimentoInput
import com.example.safemoney.telas_acao.inputs.LimiteInput
import com.example.safemoney.telas_acao.inputs.NomeCard
import com.example.safemoney.ui.theme.SafeMoneyTheme
import com.example.safemoney.viewmodel.CartaoViewModel
import kotlinx.coroutines.launch
import toDatabaseDateFormat

@Composable
fun CartaoScreen(
    modifier: Modifier = Modifier,
    cartaoViewModel: CartaoViewModel = viewModel(),
    loginViewModel: LoginViewModel = viewModel(),
    contas: List<UserConta>,
    navController: NavController
) {
    val userId = loginViewModel.getId()

    val nome = remember { mutableStateOf("") }
    val bandeira = remember { mutableStateOf("") }
    val limite = remember { mutableStateOf("") }
    val dataFechamento = remember { mutableStateOf(System.currentTimeMillis()) }
    val dataVencimento = remember { mutableStateOf(System.currentTimeMillis()) }
    val contaSelecionadaId = remember { mutableStateOf<Int?>(null) }

    val coroutineScope = rememberCoroutineScope()

    Scaffold(
        topBar = { TopBarCartao() }
    ) { contentPadding ->
        Column(
            modifier
                .padding(contentPadding)
                .padding(16.dp)
        ) {
            NomeCard(
                value = nome.value,
                onValueChange = { nome.value = it }
            )
            DataFechamentoInput(
                value = dataFechamento.value,
                onValueChange = { dataFechamento.value = it }
            )

            DataVencimentoInput(
                value = dataVencimento.value,
                onValueChange = { dataVencimento.value = it }
            )
            LimiteInput(
                value = limite.value,
                onValueChange = { limite.value = it }
            )

            BandeiraInput(
                value = bandeira.value,
                onValueChange = { bandeira.value = it }
            )
            ContaVinculadaInput(
                contas = contas,
                onChange = { selectedAccount ->
                    contaSelecionadaId.value = selectedAccount.id
                }
            )

            ButtonsRow(
                navController = navController,
                onAddButtonClick = {
                    coroutineScope.launch {
                        cartaoViewModel.cadastrarCartao(
                            cartao = Cartao(
                                nome = nome.value,
                                bandeira = bandeira.value,
                                limite = limite.value.toIntOrNull() ?: 0,
                                dataFechamento = dataFechamento.value.toDatabaseDateFormat(),
                                dataVencimento = dataVencimento.value.toDatabaseDateFormat(),
                                conta = ContaBanco(
                                    id = contaSelecionadaId.value ?: -1,
                                    fkUsuario = FkUsuario(userId ?: -1)
                                )
                            ),
                            userId = userId ?: 0
                        )
                    }
                    navController.navigate("telaCartao")
                },
                onCancelButtonClick = { navController.navigate("telaCartao") }
            )
        }
    }
}


