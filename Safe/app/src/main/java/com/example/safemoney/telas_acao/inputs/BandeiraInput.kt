package com.example.safemoney.telas_acao.inputs

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
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
import com.example.safemoney.ui.theme.VerdeFocus

@Preview
@Composable
fun BandeiraInputPreview() {
    BandeiraInput()
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BandeiraInput(
    modifier: Modifier = Modifier,
) {
    var color by remember{
        mutableStateOf(CinzaAcao)
    }


    val context = LocalContext.current
    val coffeeDrinks = arrayOf("Bradesco", "Santander", "Itau", "Nubank", "Paypal")
    var expanded by remember { mutableStateOf(false) }
    var selectedText by remember { mutableStateOf(coffeeDrinks[0]) }



    Column (
        modifier = modifier
            .fillMaxWidth()
            .height(90.dp)
            .background(Branco)
    ){
        Text(
            text = "Bandeira",
            style = TelaAcaoTypography.bodySmall,
            color = color
        )

        ExposedDropdownMenuBox(
            expanded = expanded,
            onExpandedChange = {
                expanded = !expanded
            },
        ) {

            TextField(
                    value = selectedText,
                    onValueChange = {},
                    readOnly = true,
                leadingIcon = {
                    Image(
                        painter = painterResource(id = R.drawable.bradesco),
                        contentDescription = null,
                                modifier = Modifier.size(24.dp)
                    )
                },

                    trailingIcon =
                        { ExposedDropdownMenuDefaults.TrailingIcon(expanded = expanded) },
                    modifier = Modifier
                        .menuAnchor()
                        .fillMaxWidth()
                        .onFocusChanged {
                            color = if (it.isFocused) VerdeFocus else CinzaAcao
                        },
                    colors = TextFieldDefaults.textFieldColors(
                        containerColor = Branco,
                        focusedIndicatorColor = VerdeFocus,
                        unfocusedIndicatorColor = CinzaAcao,
                    )


            )


            ExposedDropdownMenu(
                expanded = expanded,
                onDismissRequest = { expanded = false }
            ) {
                coffeeDrinks.forEach { item ->
                    DropdownMenuItem(
                        text = {
                            Row(
                                verticalAlignment = Alignment.CenterVertically,
                                modifier = Modifier.fillMaxWidth()
                            ) {
                                Image(
                                    painter = painterResource(id = R.drawable.bradesco),
                                    contentDescription = null,
                                    modifier = Modifier
                                        .size(30.dp)
                                        .padding(end = 8.dp) // Espaçamento entre a imagem e o texto
                                )
                                Text(text = item)
                            }
                        },
                        onClick = {
                            selectedText = item
                            expanded = false
                            Toast.makeText(context, item, Toast.LENGTH_SHORT).show()
                        }
                    )
                }
            }

        }
    }
}