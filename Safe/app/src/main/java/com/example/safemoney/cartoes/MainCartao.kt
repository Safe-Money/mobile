package com.example.safemoney.cartoes

import android.content.Context
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.remember
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

@Composable
fun MainCartao(modifier: Modifier = Modifier, transacaoViewModel: TransacaoViewModel, navController: NavController, cartaoViewModel: CartaoViewModel) {
    val sharedPreferences = LocalContext.current.getSharedPreferences("user_session", Context.MODE_PRIVATE)
    val userId = sharedPreferences.getInt("id", -1)
    val listaTransacoes by transacaoViewModel.transacoes.observeAsState(initial = emptyList())
    LaunchedEffect(Unit) {
        transacaoViewModel.listarTransacoes(userId)
    }
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
                CartaoRow(cartoes = cartaoViewModel.cartaoLiveData.value ?: emptyList())
            }
            item {
                BotaoMes()
            }
            item {
                TransacaoColumn(transacaoViewModel = transacaoViewModel)
            }
        }
    }
}
