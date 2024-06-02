package com.example.safemoney.telas_acao.despesa_acao

import LoginViewModel
import TopBarPlano
import Usuario1
import android.util.Log
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
import com.example.safemoney.model.FkUsuario
import com.example.safemoney.model.FkUsuario12
import com.example.safemoney.model.Objetivos
import com.example.safemoney.planejamento.PlanejamentoItem
import com.example.safemoney.telas_acao.buttons.ButtonsRow
import com.example.safemoney.telas_acao.buttons.SwitchButton
import com.example.safemoney.telas_acao.inputs.DataInput
import com.example.safemoney.telas_acao.inputs.DescricaoInput
import com.example.safemoney.telas_acao.inputs.DropInput
import com.example.safemoney.telas_acao.inputs.ValorInput
import com.example.safemoney.telas_acao.inputs.toBrazilianDateFormat17
import com.example.safemoney.viewmodel.PlanejamentoViewModel
import toDatabaseDateFormat
import java.time.LocalDate
import java.time.format.DateTimeFormatter


@Composable
fun PlanoScreen(
    modifier: Modifier = Modifier,
    navController: NavController,
    loginViewModel: LoginViewModel = viewModel(),
    planejamentoViewModel: PlanejamentoViewModel = viewModel(),
    categorias: List<Categoria>,
) {
    val usuario = Usuario1(loginViewModel.getId())
    val valor = remember { mutableStateOf("") }
    val data = remember { mutableStateOf(System.currentTimeMillis()) }
    val categoriaSelecionadaId = remember { mutableStateOf<Int?>(null) }
    val categoriaSelecionadaNome = remember { mutableStateOf<String?>(null) }
    Log.d("PlanejamentoAdd", "Tela de cadastrar!")

    Scaffold(
        topBar = {
            TopBarPlano()
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

            DropInput(
                categorias = categorias,
                onChange = { selectedCategoria ->
                    categoriaSelecionadaId.value = selectedCategoria.id
                    categoriaSelecionadaNome.value = selectedCategoria.nome
                }
            )

            ButtonsRow(
                navController = navController,
                onAddButtonClick =
                {
                    val categoriaInstance = Categoria(categoriaSelecionadaId.value!!, categoriaSelecionadaNome.value!!)
                    val valorDouble = valor.value.toDouble()
                    val planejamento = PlanejamentoItem(null, valorDouble, null , data.value.toDatabaseDateFormat(), usuario, categoriaInstance)

                    planejamentoViewModel.cadastrarPlanejamento(planejamento)
                    navController.navigate("planejamento")
                },
                onCancelButtonClick = { navController.navigate("planejamento") }
            )

        }
    }
}

