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
import androidx.compose.material3.OutlinedTextField
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
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.safemoney.R
import com.example.safemoney.ui.theme.Branco
import com.example.safemoney.ui.theme.Verde
import com.example.safemoney.ui.theme.VerdeEscuro
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Date1(
    modifier: Modifier = Modifier,
    onDateChange: (String) -> Unit
) {
    var color by remember {
        mutableStateOf(Verde)
    }

    val focusManager = LocalFocusManager.current
    var showDatePickerDialog by remember {
        mutableStateOf(false)
    }
    val datePickerState = rememberDatePickerState()
    var selectedDate by remember {
        mutableStateOf("")
    }

    Column(
        modifier = modifier
            .fillMaxWidth()
            .height(70.dp)
    ) {


        if (showDatePickerDialog) {
            DatePickerDialog(
                onDismissRequest = { showDatePickerDialog = false },
                confirmButton = {
                    Button(
                        onClick = {
                            datePickerState
                                .selectedDateMillis?.let { millis ->
                                    selectedDate = millis.toBrazilianDateFormat()

                                    val formattedDate = selectedDate.toDatabaseDateFormat()
                                    onDateChange(formattedDate)
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
        OutlinedTextField(
            value = selectedDate,
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
                    color = if (it.isFocused) Verde else Verde
                },
            colors = TextFieldDefaults.textFieldColors(
                containerColor = Branco,
                focusedIndicatorColor = Verde,
                unfocusedIndicatorColor = Verde,
            ),
            label = {
                Text(
                    text = "Data",
                    fontFamily = FontFamily(Font(R.font.montserrat)),
                    fontSize = 12.sp
                )
            }
        )
    }
}

fun String.toDatabaseDateFormat(): String {
    val formatter = SimpleDateFormat("dd/MM/yyyy", Locale("pt-br"))
    val date = formatter.parse(this)
    return SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(date)
}

fun Long.toBrazilianDateFormat(pattern: String = "dd/MM/yyyy"): String {
    val date = Date(this)
    val formatter = SimpleDateFormat(pattern, Locale("pt-br"))
    return formatter.format(date)
}

@Preview(showBackground = true)
@Composable
fun DatePreview1() {
    Date1(modifier = Modifier, onDateChange = {})
}
