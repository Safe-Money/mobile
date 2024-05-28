package com.example.safemoney.planejamento

import ContaViewModel
import LancamentoViewModel
import LoginViewModel
import android.util.Log
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.safemoney.FooterBar
import com.example.safemoney.R
import com.example.safemoney.componentes.BotaoMes
import com.example.safemoney.componentes.BotoesSwitch
import com.example.safemoney.componentes.Lista
import kotlinx.coroutines.launch
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.Locale

@Composable
fun LancamentosScreen2(
    navController: NavController,
    lancamentoViewModel: LancamentoViewModel,
    loginViewModel: LoginViewModel,
    contaViewModel: ContaViewModel
) {
    val userId = loginViewModel.getId()
    val lancamentosState by lancamentoViewModel.lancamentos.observeAsState(listOf())

    LaunchedEffect(Unit) {
        val contasDoUsuario = contaViewModel.idConta(userId)
        contasDoUsuario.forEach { contaId ->
            lancamentoViewModel.listarLancamentos(contaId)
            Log.d("LancamentosScreen2", "Chamando listarLancamentos para idConta: $contaId")
        }
    }

    val months = listOf(
        "Janeiro", "Fevereiro", "Março", "Abril", "Maio", "Junho",
        "Julho", "Agosto", "Setembro", "Outubro", "Novembro", "Dezembro"
    )
    val currentMonthIndex = remember { mutableStateOf(LocalDate.now().monthValue - 1) }
    val scope = rememberCoroutineScope()

    val formatter = DateTimeFormatter.ofPattern("EEEE, dd", Locale("pt", "BR"))

    // Filtrar lançamentos pelo mês atual
    val lancamentosDoMesAtual = lancamentosState.filter { lancamento ->
        val lancamentoDate = LocalDate.parse(lancamento.data)
        lancamentoDate.monthValue == currentMonthIndex.value + 1
    }

    val groupedLancamentos = lancamentosDoMesAtual.groupBy { lancamento ->
        val parsedDate = LocalDate.parse(lancamento.data)
        val formattedDate = parsedDate.format(formatter)
        formattedDate.replaceFirstChar { it.uppercaseChar() }
    }

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = Color.White
    ) {
        Column(
            modifier = Modifier.fillMaxSize()
        ) {

            Spacer(modifier = Modifier.height(10.dp))
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
            ) {
                Text(
                    text = "Lançamentos",
                    fontFamily = FontFamily(Font(R.font.montserrat)),
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(start = 16.dp)
                )

                IconButton(
                    onClick = { navController.navigate("addLancamentos") },
                    modifier = Modifier
                        .size(24.dp)
                        .padding(end = 5.dp)
                ) {
                    Icon(
                        imageVector = Icons.Default.AddCircle,
                        contentDescription = null
                    )
                }
            }
            Spacer(modifier = Modifier.height(10.dp))

            Divider(
                color = Color(0xFFCDCDCD),
                thickness = 1.dp,
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(5.dp))

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp)
                    .padding(start = 16.dp)
            ) {
                BotoesSwitch()
            }

            Spacer(modifier = Modifier.height(5.dp))

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp)
                    .padding(start = 16.dp)
            ) {
                BotaoMes(
                    mesAtual = months[currentMonthIndex.value],
                    onClickPrevious = {
                        if (currentMonthIndex.value > 0) {
                            currentMonthIndex.value -= 1
                        }
                    },
                    onClickNext = {
                        if (currentMonthIndex.value < months.size - 1) {
                            currentMonthIndex.value += 1
                        }
                    }
                )
            }

            Divider(
                color = Color(0xFFCDCDCD),
                thickness = 1.dp,
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(10.dp))

            // Parte dentro do LazyColumn
            LazyColumn(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
            ) {
                groupedLancamentos.forEach { (data, lancamentos) ->
                    item {
                        Text(
                            text = data,
                            fontFamily = FontFamily(Font(R.font.montserrat)),
                            fontSize = 14.sp,
                            fontWeight = FontWeight.SemiBold,
                            modifier = Modifier.padding(start = 13.dp, top = 20.dp, bottom = 20.dp)
                        )
                    }
                    items(lancamentos) { lancamento ->
                        Lista(lancamentos = listOf(lancamento))
                    }
                }
            }

            FooterBar(navController)
        }
    }
}
