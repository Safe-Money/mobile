package com.example.tela_objetivos

import Content
import ObjetivoViewModel

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.projetoaula07_03.home.TopBar
import com.example.safemoney.FooterBar


import com.example.safemoney.ui.theme.SafeMoneyTheme

@Composable
fun ObjetivoScreen(
    navController: NavController,
    objetivoViewModel: ObjetivoViewModel
) {
    val objetivosState = objetivoViewModel.objetivos.observeAsState(initial = emptyList())
    val objetivos = objetivosState.value


    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Column {
            TopBar(navController = navController)
            Content(objetivos = objetivos)
        }
        FooterBar(navController)
    }
}









