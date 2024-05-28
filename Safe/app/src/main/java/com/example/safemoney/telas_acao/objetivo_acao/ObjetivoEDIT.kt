package com.example.safemoney.telas_acao.objetivo_acao

import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.example.safemoney.telas_acao.cartao_acao.TopBarObjetivos
import com.example.safemoney.telas_acao.inputs.DataInicioInput
import com.example.safemoney.telas_acao.inputs.FinalDataInput


import Categoria1
import Conta1
import LancamentoViewModel
import Lancamentos
import LoginViewModel
import ObjetivoViewModel
import TipoTransacao
import UserConta
import Usuario1
import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.safemoney.model.Categoria
import com.example.safemoney.model.FkUsuario12
import com.example.safemoney.model.Objetivos

import com.example.safemoney.telas_acao.buttons.ButtonsRow
import com.example.safemoney.telas_acao.cartao_acao.TopBarLancamentos
import com.example.safemoney.telas_acao.inputs.ApelidoInput
import com.example.safemoney.telas_acao.inputs.ContaVinculadaInput
import com.example.safemoney.telas_acao.inputs.DataInput
import com.example.safemoney.telas_acao.inputs.DropInput
import com.example.safemoney.telas_acao.inputs.ImagemInput
import com.example.safemoney.telas_acao.inputs.ValorInput
import com.example.safemoney.telas_acao.inputs.toDatabaseDateFormat17
import com.example.safemoney.viewmodel.CartaoViewModel
import com.example.safemoney.viewmodel.CategoriaViewModel


@Composable
fun ObjetivoEDIT(
    modifier: Modifier = Modifier,
    objetivoViewModel: ObjetivoViewModel = viewModel(),
    loginViewModel: LoginViewModel = viewModel(),
    navController: NavController,
) {
    val userId = loginViewModel.getId()
    val apelido = remember { mutableStateOf("") }
    val url = remember { mutableStateOf("") }
    val valor = remember { mutableStateOf("") }
    val dataInicio = remember { mutableStateOf(System.currentTimeMillis()) }
    val dataFinal = remember { mutableStateOf(System.currentTimeMillis()) }

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
            ApelidoInput(
                value = apelido.value,
                onValueChange = { apelido.value = it }
            )

            DataInicioInput(
                value = dataInicio.value,
                onValueChange = { dataInicio.value = it }
            )

            FinalDataInput(
                value = dataFinal.value,
                onValueChange = { dataFinal.value = it }
            )

            ImagemInput(
                value = url.value,
                onValueChange = { url.value = it }
            )

            ValorInput(
                value = valor.value,
                onValueChange = { valor.value = it }
            )

            ButtonsRow(
                navController = navController,
                onAddButtonClick = {
                    val objetivo = Objetivos(

                        nome = apelido.value,
                        urlImagem = url.value,
                        dataInicio = dataInicio.value.toDatabaseDateFormat17(),
                        ultimoDeposito = dataInicio.value.toDatabaseDateFormat17(),
                        dataTermino = dataFinal.value.toDatabaseDateFormat17(),
                        concluida = 0,
                        valorInvestido = 0.0,
                        valorFinal = valor.value.toDoubleOrNull() ?: 0.0,
                        fkUsuario = FkUsuario12(id = userId)
                    )
                    objetivoViewModel.editarObjetivo(objetivo.id ?: 0, objetivo)
                    navController.navigate("objetivo")
                },
                onCancelButtonClick = { navController.navigate("objetivo") }
            )
        }
    }
}
