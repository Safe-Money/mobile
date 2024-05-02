package com.example.safemoney.telas_acao.inputs

import UserConta
import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.safemoney.R
import com.example.safemoney.ui.theme.Branco
import com.example.safemoney.ui.theme.CinzaAcao
import com.example.safemoney.ui.theme.TelaAcaoTypography
import com.example.safemoney.ui.theme.Verde
import com.example.safemoney.ui.theme.VerdeFocus

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ContaVinculadaInput(
    modifier: Modifier = Modifier,
    contas: List<UserConta>,
    onChange: (UserConta) -> Unit
) {

    var color by remember { mutableStateOf(CinzaAcao) }
    val context = LocalContext.current


    val bancoLogos = mapOf(
        "bradesco" to R.drawable.bradesco,
        "Itau" to R.drawable.itau,
        "Santander" to R.drawable.santander
    )


    var expanded by remember { mutableStateOf(false) }
    var selectedConta by remember { mutableStateOf(contas.firstOrNull()) }


    Column(
        modifier = modifier
            .fillMaxWidth()
            .height(90.dp)
            .background(Branco)
    ) {
        Text(
            text = "Conta vinculada",
            style = TelaAcaoTypography.bodySmall,
            color = color
        )

        ExposedDropdownMenuBox(
            expanded = expanded,
            onExpandedChange = { expanded = !expanded },
        ) {
            TextField(
                value = selectedConta?.nome ?: "",
                onValueChange = {},
                readOnly = true,
                leadingIcon = {
                    val logoId = selectedConta?.banco?.let { bancoLogos[it] }
                    logoId?.let { id ->
                        Image(
                            painter = painterResource(id = id),
                            contentDescription = null,
                            modifier = Modifier.size(24.dp)
                        )
                    }
                },
                trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = expanded) },
                modifier = Modifier
                    .menuAnchor()
                    .fillMaxWidth()
                    .onFocusChanged { color = if (it.isFocused) Verde else CinzaAcao },
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
                contas.forEach { conta ->
                    DropdownMenuItem(
                        text = { Text(text = conta.nome) },
                        onClick = {
                            selectedConta = conta
                            expanded = false
                            onChange(conta)
                            Toast.makeText(context, conta.nome, Toast.LENGTH_SHORT).show()
                            Log.d("ContaVinculadaInput", "ID da conta selecionada: ${conta.id}")
                        }
                    )
                }
            }
        }
    }
}
