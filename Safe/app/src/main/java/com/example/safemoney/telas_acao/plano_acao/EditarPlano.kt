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
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.safemoney.model.Categoria
import com.example.safemoney.planejamento.PlanejamentoItem
import com.example.safemoney.telas_acao.buttons.ButtonsRow
import com.example.safemoney.telas_acao.inputs.DataInput
import com.example.safemoney.telas_acao.inputs.DropInput
import com.example.safemoney.telas_acao.inputs.ValorInput
import com.example.safemoney.viewmodel.PlanejamentoViewModel
import toDatabaseDateFormat
import java.text.SimpleDateFormat
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.Date
import java.util.Locale


@Composable
fun EditarPlano(
    modifier: Modifier = Modifier,
    navController: NavController,
    loginViewModel: LoginViewModel = viewModel(),
    planejamentoViewModel: PlanejamentoViewModel = viewModel(),
    planejamento: PlanejamentoItem,
    categorias: List<Categoria>,
) {
    val usuario = Usuario1(loginViewModel.getId())
    val valor = remember { mutableStateOf<Double?>(planejamento.valorPlanejado) }
    val valorEditar= remember { mutableStateOf<String?>(String.format("%.2f", valor.value)) }
    val data = remember { mutableStateOf(planejamento.data) }
    val categoriaSelecionadaId = remember { mutableStateOf<Int?>(planejamento.categoria.id) }
    val categoriaSelecionadaNome = remember { mutableStateOf<String?>(planejamento.categoria.nome) }

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
                value = valorEditar.value!!,
                onValueChange = { valorEditar.value = it }

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
                    val valorDouble = if (valorEditar.value == null) valor.value!!.toDouble() else valorEditar.value!!.toDouble()
                    val p = PlanejamentoItem(null, valorDouble, null , data.value, usuario, categoriaInstance)

                    planejamentoViewModel.editarPlanejamento(p, planejamento.id!!)
                    navController.navigate("planejamento")
                },
                onCancelButtonClick = { navController.navigate("planejamento") }
            )

        }

    }


}

