package com.example.safemoney.cartoes

import android.content.Context
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.safemoney.FooterBar
import com.example.safemoney.TopBar1
import com.example.safemoney.model.Cartao
import com.example.safemoney.model.CartaoGet
import com.example.safemoney.viewmodel.CartaoViewModel
import com.example.safemoney.viewmodel.TransacaoViewModel
import java.time.LocalDate

@Composable
fun MainCartao(modifier: Modifier = Modifier, transacaoViewModel: TransacaoViewModel, navController: NavController, cartaoViewModel: CartaoViewModel) {
    val sharedPreferences = LocalContext.current.getSharedPreferences("user_session", Context.MODE_PRIVATE)
    val userId = sharedPreferences.getInt("id", -1)
    var selectedMonth by remember { mutableStateOf(LocalDate.now().withDayOfMonth(1)) }
    var selectedCartaoId by remember { mutableStateOf(-1) }


    Scaffold(
        bottomBar = {
            FooterBar(navController = navController)
        }
    ) { padding ->
        LazyColumn(
            contentPadding = padding
        ) {
            item {
                TopBar1(navController = navController)
            }
            item {
                CartaoRow(
                    cartoes = cartaoViewModel.cartaoLiveData.value ?: emptyList(),
                    onCartaoSelected = { id ->
                        if (id > 0) {
                            selectedCartaoId = id
                        }
                    }
                )
            }
            item {
                BotaoMes(onMonthChange = { month -> selectedMonth = month })
            }
            item {
                Log.d("MainCartao", "Selected Cartao ID: $selectedCartaoId")
                TransacaoColumn(
                    transacaoViewModel = transacaoViewModel,
                    idCartao = selectedCartaoId,
                    selectedMonth = selectedMonth
                )
            }
        }
    }
}
