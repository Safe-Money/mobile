import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.safemoney.model.FkUsuario12
import com.example.safemoney.model.Objetivos
import com.example.safemoney.telas_acao.buttons.ButtonsRow
import com.example.safemoney.telas_acao.cartao_acao.TopBarObjetivos
import com.example.safemoney.telas_acao.inputs.ApelidoInput
import com.example.safemoney.telas_acao.inputs.DataInicioInput
import com.example.safemoney.telas_acao.inputs.FinalDataInput
import com.example.safemoney.telas_acao.inputs.ImagemInput
import com.example.safemoney.telas_acao.inputs.ObjetivoViewModel
import com.example.safemoney.telas_acao.inputs.ValorInput

import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

@Composable
fun ObjetivoEDIT(
    modifier: Modifier = Modifier,
    objetivoViewModel: ObjetivoViewModel = viewModel(),
    loginViewModel: LoginViewModel = viewModel(),
    navController: NavController,
    objetivoId: Int
) {
    val userId = loginViewModel.getId()
    val apelido = remember { mutableStateOf("") }
    val url = remember { mutableStateOf("") }
    val valor = remember { mutableStateOf("") }
    val dataInicio = remember { mutableStateOf(0L) }
    val dataFinal = remember { mutableStateOf(0L) }

    val objetivo by objetivoViewModel.objetivo.observeAsState()

    LaunchedEffect(objetivoId) {
        Log.d("ObjetivoEDIT", "LaunchedEffect called with objetivoId: $objetivoId")
        objetivoViewModel.getObjetivoById1(objetivoId)
    }

    LaunchedEffect(objetivo) {
        Log.d("ObjetivoEDIT", "Objetivo updated: $objetivo")
        objetivo?.let {
            apelido.value = it.nome ?: ""
            url.value = it.urlImagem ?: ""
            valor.value = it.valorFinal.toString()
            dataInicio.value = it.dataInicio.toDateInMillis()
            dataFinal.value = it.dataTermino.toDateInMillis()
        }
    }

    Scaffold(
        topBar = {
            TopBarObjetivos()
        }
    ) { contentPadding ->
        Column(
            modifier
                .padding(contentPadding)
                .padding(16.dp)
        ) {
            ApelidoInput(
                value = apelido.value,
                onValueChange = { apelido.value = it }
            )

            DataInicioInput(
                value = dataInicio.value,
                onValueChange = { dataInicio.value = it }
            )

            FinalDataInput(
                value = dataFinal.value,
                onValueChange = { dataFinal.value = it }
            )

            ImagemInput(
                value = url.value,
                onValueChange = { url.value = it }
            )

            ValorInput(
                value = valor.value,
                onValueChange = { valor.value = it }
            )

            ButtonsRow(
                navController = navController,
                onAddButtonClick = {
                    val objetivo = Objetivos(
                        id = objetivoId,
                        nome = apelido.value,
                        urlImagem = url.value,
                        dataInicio = dataInicio.value.toDatabaseDateFormat17(),
                        ultimoDeposito = dataInicio.value.toDatabaseDateFormat17(),
                        dataTermino = dataFinal.value.toDatabaseDateFormat17(),
                        concluida = 0,
                        valorInvestido = 0.0,
                        valorFinal = valor.value.toDoubleOrNull() ?: 0.0,
                        fkUsuario = FkUsuario12(id = userId)
                    )
                    objetivoViewModel.editarObjetivo(objetivo.id ?: 0, objetivo)
                    navController.navigate("objetivo")
                },
                onCancelButtonClick = { navController.navigate("objetivo") }
            )
        }
    }
}

fun String.toDateInMillis(): Long {
    val formatter = SimpleDateFormat("yyyy-MM-dd", Locale("pt-BR"))
    return formatter.parse(this)?.time ?: System.currentTimeMillis()
}

fun Long.toDatabaseDateFormat17(): String {
    val date = Date(this)
    val formatter = SimpleDateFormat("yyyy-MM-dd", Locale("pt-BR"))
    return formatter.format(date)
}
