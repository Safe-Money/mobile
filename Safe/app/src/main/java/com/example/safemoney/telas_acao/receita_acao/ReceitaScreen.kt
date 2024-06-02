package com.example.safemoney.telas_acao.despesa_acao

import LoginViewModel
import TipoTransacao
import UserConta
import Usuario1
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.safemoney.model.Categoria
import com.example.safemoney.model.Receita
import com.example.safemoney.model.UserContaDTO
import com.example.safemoney.planejamento.PlanejamentoItem
import com.example.safemoney.telas_acao.buttons.ButtonsRow
import com.example.safemoney.telas_acao.buttons.SwitchButton
import com.example.safemoney.telas_acao.inputs.ContasInput
import com.example.safemoney.telas_acao.inputs.DataInput
import com.example.safemoney.telas_acao.inputs.DescricaoInput
import com.example.safemoney.telas_acao.inputs.DropInput
import com.example.safemoney.telas_acao.inputs.ValorInput
import com.example.safemoney.telas_acao.inputs.toBrazilianDateFormat17
import com.example.safemoney.viewmodel.TransacaoViewModel
import toDatabaseDateFormat


@Composable
fun ReceitaScreen(
    modifier: Modifier = Modifier,
    navController: NavController,
    transacaoViewModel: TransacaoViewModel = viewModel(),
    categorias: List<Categoria>,
    contas: List<UserConta>
) {
    val valor = remember { mutableStateOf("") }
    val desc = remember { mutableStateOf("") }
    val data = remember { mutableStateOf(System.currentTimeMillis()) }
    val categoriaSelecionadaId = remember { mutableStateOf<Int?>(null) }
    val categoriaSelecionadaNome = remember { mutableStateOf<String?>(null) }
    val contaSelecionada = remember { mutableStateOf<Int?>(null) }
    val fixo = remember { mutableStateOf(false) }

    Scaffold(
        topBar = {
            TopBarReceita()
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

<<<<<<< Updated upstream
            DescricaoInput()

            SwitchButton()
=======
            DataInput(
                value = data.value,
                onValueChange = { data.value = it }
            )

            DescricaoInput(
                valor = desc.value,
                onValueChange = { desc.value = it }
            )

            DropInput(
                categorias = categorias,
                onChange = {
                    categoriaSelecionadaId.value = it.id
                    categoriaSelecionadaNome.value = it.nome
                }
            )

            ContasInput(
                categorias = contas,
                onChange = { contaSelecionada.value = it.id }
            )

            SwitchButton(
                bol = fixo.value,
                onChange = { fixo.value = it }
            )
>>>>>>> Stashed changes

            val transacaoId = if (fixo.value) 5 else 4

            ButtonsRow(
                navController = navController,
                onAddButtonClick = {
                    val categoriaInstance = Categoria(categoriaSelecionadaId.value!!, categoriaSelecionadaNome.value!!)
                    val contaOrigem = UserContaDTO(contaSelecionada.value!!)
                    val valorDouble = valor.value.toDouble()
                    val receita = Receita(
                        id = null,
                        nome = desc.value,
                        data = data.value.toDatabaseDateFormat(),
                        valor = valorDouble,
                        contaOrigem = contaOrigem,
                        categoria = categoriaInstance,
                        tipoTransacao = TipoTransacao(transacaoId),
                        fixo = fixo.value
                    )

                    if (transacaoId == 5) {
                        transacaoViewModel.adicionarReceitaFixa(receita)
                    } else {
                        transacaoViewModel.adicionarReceita(receita)
                    }
                    navController.navigate("painel")
                },
                onCancelButtonClick = { navController.navigate("painel") }
            )
        }
    }
}
