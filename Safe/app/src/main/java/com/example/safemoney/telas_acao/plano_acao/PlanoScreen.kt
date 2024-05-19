package com.example.safemoney.telas_acao.despesa_acao

import TopBarPlano
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
import androidx.navigation.NavController
import com.example.safemoney.model.Categoria
import com.example.safemoney.model.FkUsuario12
import com.example.safemoney.model.Objetivos
import com.example.safemoney.telas_acao.buttons.ButtonsRow
import com.example.safemoney.telas_acao.buttons.SwitchButton
import com.example.safemoney.telas_acao.inputs.DataInput
import com.example.safemoney.telas_acao.inputs.DescricaoInput
import com.example.safemoney.telas_acao.inputs.DropInput
import com.example.safemoney.telas_acao.inputs.ValorInput
import com.example.safemoney.telas_acao.inputs.toDatabaseDateFormat17


@Composable
fun PlanoScreen(
    modifier: Modifier = Modifier,
    navController: NavController,
    categorias: List<Categoria>,
) {
    val valor = remember { mutableStateOf("") }
    val categoriaSelecionadaId = remember { mutableStateOf<Int?>(null) }


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

            DropInput(
                categorias = categorias,
                onChange = { selectedCategoria ->
                    categoriaSelecionadaId.value = selectedCategoria.id
                }
            )

            ButtonsRow(
                navController = navController,
                onAddButtonClick = {
                },
                onCancelButtonClick = { navController.navigate("planejamento") }
            )

        }
    }
}