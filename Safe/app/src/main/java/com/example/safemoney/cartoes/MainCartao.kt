package com.example.safemoney.cartoes

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.safemoney.FooterBar
import com.example.safemoney.TopBar
import com.example.safemoney.ui.theme.SafeMoneyTheme
import com.example.safemoney.ui.theme.Vermelho

@Composable
fun MainCartao(modifier: Modifier = Modifier, navController: NavController) {

    Scaffold(
        bottomBar = {
            FooterBar(navController = navController)
        }
    ) { padding ->

            LazyColumn(
                contentPadding = padding
            ) {
                item {
                    TopBar()
                }
                item {
                    CartaoRow()
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

@Preview
@Composable
fun MainCartaoPreview() {
    val navController = rememberNavController()
    MainCartao(navController = navController)
}