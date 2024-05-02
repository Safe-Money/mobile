package com.example.safemoney.cartoes

import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.safemoney.FooterBar
import com.example.safemoney.TopBar1
import com.example.safemoney.viewmodel.CartaoViewModel

@Composable
fun MainCartao(modifier: Modifier = Modifier, navController: NavController, cartaoViewModel: CartaoViewModel) {
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
                TransacaoColumn()
            }
        }
    }
}
