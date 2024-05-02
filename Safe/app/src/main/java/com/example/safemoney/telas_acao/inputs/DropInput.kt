package com.example.safemoney.telas_acao.inputs

import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

import com.example.safemoney.model.Categoria
import com.example.safemoney.ui.theme.Branco
import com.example.safemoney.ui.theme.CinzaAcao
import com.example.safemoney.ui.theme.TelaAcaoTypography
import com.example.safemoney.ui.theme.Verde
import com.example.safemoney.ui.theme.VerdeFocus
import com.example.safemoney.viewmodel.CategoriaViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DropInput(
    modifier: Modifier = Modifier,
    categorias: List<Categoria>,
    onChange: (Categoria) -> Unit
) {
    var color by remember {
        mutableStateOf(CinzaAcao)
    }

    val context = LocalContext.current
    var expanded by remember { mutableStateOf(false) }
    var selectedCategoria by remember { mutableStateOf(categorias.firstOrNull()) }



    Column(
        modifier = modifier
            .fillMaxWidth()
            .height(90.dp)
            .background(Branco)
    ) {
        Text(
            text = "Categoria",
            style = TelaAcaoTypography.bodySmall,
            color = color
        )

        ExposedDropdownMenuBox(
            expanded = expanded,
            onExpandedChange = {
                expanded = it
            },
        ) {
            TextField(
                value = selectedCategoria?.nome ?: "",
                onValueChange = {},
                readOnly = true,
                trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = expanded) },
                modifier = Modifier
                    .menuAnchor()
                    .fillMaxWidth()
                    .onFocusChanged {
                        color = if (it.isFocused) Verde else CinzaAcao
                    },
                colors = TextFieldDefaults.textFieldColors(
                    containerColor = Branco,
                    focusedIndicatorColor = Verde,
                    unfocusedIndicatorColor = CinzaAcao,
                )
            )

            ExposedDropdownMenu(
                expanded = expanded,
                onDismissRequest = { expanded = false }
            ) {
                categorias.forEach { categoria ->
                    DropdownMenuItem(
                        text = { Text(text = categoria.nome) },
                        onClick = {
                            selectedCategoria = categoria
                            expanded = false
                            onChange(categoria)
                            Toast.makeText(context, categoria.nome, Toast.LENGTH_SHORT).show()
                            Log.d("ContaVinculadaInput", "ID da conta selecionada: ${categoria.id}")
                        }
                    )
                }
            }
        }
    }
}
