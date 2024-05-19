package com.example.safemoney.telas_acao.inputs

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.DatePicker
import androidx.compose.material3.DatePickerDialog
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.focus.onFocusEvent
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.safemoney.ui.theme.Branco
import com.example.safemoney.ui.theme.CinzaAcao
import com.example.safemoney.ui.theme.TelaAcaoTypography
import com.example.safemoney.ui.theme.Verde
import com.example.safemoney.ui.theme.VerdeEscuro
import com.example.safemoney.ui.theme.VerdeFocus
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale
import java.util.TimeZone


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DataVencimentoInput(
    modifier: Modifier = Modifier,
    value: Long,
    onValueChange: (Long) -> Unit,
) {
    var color by remember {
        mutableStateOf(CinzaAcao)
    }

    val focusManager = LocalFocusManager.current
    var showDatePickerDialog by remember {
        mutableStateOf(false)
    }
    val datePickerState = rememberDatePickerState()

    Column(
        modifier = modifier
            .fillMaxWidth()
            .height(90.dp)
            .background(Branco)
    ) {
        Text(
            text = "Data Vencimento",
            style = TelaAcaoTypography.bodySmall,
            color = color
        )

        if (showDatePickerDialog) {
            DatePickerDialog(
                onDismissRequest = { showDatePickerDialog = false },
                confirmButton = {
                    Button(
                        onClick = {
                            datePickerState.selectedDateMillis?.let { millis ->
                                onValueChange(millis)
                            }
                            showDatePickerDialog = false
                        },
                        colors = ButtonDefaults.buttonColors(VerdeEscuro)
                    ) {
                        Text(text = "Selecionar")
                    }
                }) {
                DatePicker(state = datePickerState)
            }
        }

        val formattedDate = value.toBrazilianDateFormat()
        TextField(
            value = formattedDate,
            onValueChange = {},
            Modifier
                .fillMaxWidth()
                .onFocusEvent {
                    if (it.isFocused) {
                        showDatePickerDialog = true
                        focusManager.clearFocus(force = true)
                    }
                }
                .onFocusChanged {
                    color = if (it.isFocused) Verde else CinzaAcao
                },
            colors = TextFieldDefaults.textFieldColors(
                containerColor = Branco,
                focusedIndicatorColor = Verde,
                unfocusedIndicatorColor = CinzaAcao,
            )
        )
    }
}

fun Long.toBrazilianDateFormat(): String {
    val date = Date(this)
    val formatter = SimpleDateFormat("dd/MM/yyyy", Locale("pt-br"))
    return formatter.format(date)
}

fun Long.toDatabaseDateFormat(): String {
    val date = Date(this)
    val formatter = SimpleDateFormat("yyyy-MM-dd", Locale("pt-br"))
    return formatter.format(date)
}