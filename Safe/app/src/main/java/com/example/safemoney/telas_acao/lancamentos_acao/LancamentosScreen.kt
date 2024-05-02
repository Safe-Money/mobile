package com.example.safemoney.telas_acao.lancamentos_acao

import Categoria1
import Conta1
import LancamentoViewModel
import Lancamentos
import LoginViewModel
import TipoTransacao
import UserConta
import Usuario1
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
import com.example.safemoney.componentes.Lancamento
import com.example.safemoney.model.Categoria

import com.example.safemoney.telas_acao.buttons.ButtonsRow
import com.example.safemoney.telas_acao.cartao_acao.TopBarLancamentos
import com.example.safemoney.telas_acao.inputs.ApelidoInput
import com.example.safemoney.telas_acao.inputs.ContaVinculadaInput
import com.example.safemoney.telas_acao.inputs.DataInput
import com.example.safemoney.telas_acao.inputs.DropInput
import com.example.safemoney.telas_acao.inputs.ValorInput
import com.example.safemoney.telas_acao.inputs.toDatabaseDateFormat17
import com.example.safemoney.viewmodel.CartaoViewModel
import com.example.safemoney.viewmodel.CategoriaViewModel


@Composable
fun LancamentosScreen(
    modifier: Modifier = Modifier,
    categoriaViewModel: CategoriaViewModel = viewModel(),
    loginViewModel: LoginViewModel = viewModel(),
    lancamentoViewModel: LancamentoViewModel = viewModel(),
    navController : NavController,
    categorias: List<Categoria>,
    contas: List<UserConta>,
) {


    val userId = loginViewModel.getId()
    val apelido = remember { mutableStateOf("") }
    val valor = remember { mutableStateOf("") }
    val data = remember { mutableStateOf(System.currentTimeMillis()) }
    val categoriaSelecionadaId = remember { mutableStateOf<Int?>(null) }
    val contaSelecionadaId = remember { mutableStateOf<Int?>(null) }


    LaunchedEffect(Unit) {
        categoriaViewModel.listarCategorias()
    }


    Scaffold(
        topBar = {
            TopBarLancamentos()
        }
    ) { contentPadding ->
        Column (
            modifier
                .padding(contentPadding)
                .padding(16.dp)
        ) {
            ApelidoInput(
                value = apelido.value,
                onValueChange = { apelido.value = it }
            )

            ValorInput(
                value = valor.value,
                onValueChange = { valor.value = it }

            )

            DataInput(
                value = data.value,
                onValueChange = { data.value = it }
            )

            DropInput(
                categorias = categorias,
                onChange = { selectedCategoria ->
                    categoriaSelecionadaId.value = selectedCategoria.id
                }
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
                    val valorString = valor.value.trim()
                    val valorNumerico = if (valorString.isNotEmpty()) {
                        valorString.toDoubleOrNull() ?: 0.0
                    } else {

                        0.0
                    }
                    val lancamento = Lancamentos(
                        nome = apelido.value,
                        valor = valorNumerico,
                        data = data.value.toDatabaseDateFormat17(),
                        fkConta = Conta1(id = contaSelecionadaId.value!!),
                        fkUsuario = Usuario1(id = userId),
                        fkTipoTransacao = TipoTransacao(id = 5),
                        fkCategoria = Categoria1(id = categoriaSelecionadaId.value!!)
                    )

                    lancamentoViewModel.cadastrarLancamentoFixo(lancamento)
                    navController.navigate("lancamentos")
                    } ,

                onCancelButtonClick = { navController.navigate("lancamentos") }
            )
        }
    }
}
