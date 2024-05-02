package com.example.safemoney.telas_acao.conta_acao

import Conta
import ContaViewModel
import FkUsuario
import LoginViewModel
import UserConta
import Usuario
import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Snackbar
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.safemoney.telas_acao.buttons.ButtonsRow
import com.example.safemoney.telas_acao.inputs.ApelidoInput
import com.example.safemoney.telas_acao.inputs.BancoInput
import com.example.safemoney.telas_acao.inputs.DataVencimentoInput
import com.example.safemoney.telas_acao.inputs.LimiteInput
import com.example.safemoney.telas_acao.inputs.SaldoInput
import com.example.safemoney.telas_acao.inputs.TipoContaInput
import kotlinx.coroutines.launch


@Preview
@Composable
fun ContaScreenPreview() {

}
@Composable
fun ContaScreen(
    contaViewModel: ContaViewModel = viewModel(),
    loginViewModel: LoginViewModel = viewModel(),
    modifier: Modifier = Modifier,
    navController: NavController
) {
    var mostrarSnackbarErrado by remember { mutableStateOf(false) }
    val coroutineScope = rememberCoroutineScope()
    var apelido by remember { mutableStateOf("") }
    var tipoConta by remember { mutableStateOf(0) }
    var saldo by remember { mutableStateOf(0.0) }
    var banco by remember { mutableStateOf("") }

    val userId = loginViewModel.getId() ?: -1

    val cadastroSucesso by contaViewModel.cadastroSucesso

    Scaffold(
        topBar = {
            TopBarConta()
        }
    ) { contentPadding ->
        Column(
            modifier
                .padding(contentPadding)
                .padding(16.dp)
        ) {
            ApelidoInput(
                value = apelido,
                onValueChange = { apelido = it }
            )

            TipoContaInput(
                selectedType = tipoConta,
                onSelectedTypeChange = { tipoConta = it }
            )

            SaldoInput(
                value = saldo.toString(),
                onValueChange = { saldo = it }
            )

            BancoInput(
                value = banco,
                onValueChange = { banco = it }
            )

            ButtonsRow(
                navController = navController,
                onAddButtonClick = {
                    val usuario = FkUsuario(id = userId)
                    Log.d("ContaScreen", "Apelido: $apelido")
                    Log.d("ContaScreen", "Tipo de Conta: $tipoConta")
                    Log.d("ContaScreen", "Saldo: $saldo")
                    Log.d("ContaScreen", "Banco: $banco")
                    val novaConta = UserConta(
                        nome = apelido,
                        banco = banco,
                        tipo = tipoConta,
                        saldo = saldo.toDouble(),
                        fkUsuario = usuario
                    )
                    coroutineScope.launch {
                        contaViewModel.cadastrarConta(novaConta)
                    }
                    navController.navigate("painel")
                },

                onCancelButtonClick = {
                    navController.navigate("painel")
                }
            )
        }
    }




}