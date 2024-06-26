package com.example.tela_objetivos

import Content

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.projetoaula07_03.home.TopBar
import com.example.safemoney.FooterBar


import com.example.safemoney.ui.theme.SafeMoneyTheme

@Composable
fun ObjetivoScreen(navController: NavController) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Column {
            TopBar()
            Content()
        }
        FooterBar(navController)
    }
}


@Preview(showBackground = true)
@Composable
fun LoginScreenPreview1() {
    val navController = rememberNavController()
    SafeMoneyTheme {
        ObjetivoScreen(navController = navController)
    }
}






