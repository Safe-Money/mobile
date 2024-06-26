package com.example.safemoney

import MainPainel
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.safemoney.cadastro.CadastroScreen
import com.example.safemoney.cartoes.Cartoes
import com.example.safemoney.config.ConfigScreen
import com.example.safemoney.cartoes.MainCartao

import com.example.safemoney.login.LoginScreen1
import com.example.safemoney.menu.Menu
import com.example.safemoney.menu.Options


import com.example.safemoney.painel.ThreeContainersWithList

import com.example.safemoney.planejamento.LancamentosScreen2
import com.example.safemoney.planejamento.Planejamento
import com.example.safemoney.splash.SplashScreen
import com.example.safemoney.ui.theme.SafeMoneyTheme
import com.example.tela_objetivos.ObjetivoScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()


            SafeMoneyApp(navController = navController)
        }
    }
}

@Composable
fun SafeMoneyApp(navController: NavHostController) {

    NavHost(navController = navController, startDestination = "cadastro") {
        composable("painel") {
            MainPainel(navController = navController)
        }

        composable("planejamento") {
            Planejamento(navController = navController)
        }

        composable("menu") {
            Menu(navController = navController)
        }

        composable("configuracoes") {
            ConfigScreen(navController = navController)
        }

        composable("lancamentos") {
            LancamentosScreen2(navController = navController)
        }

        composable("cadastro") {
            CadastroScreen(navController = navController)
        }

        composable("cartoes") {
            MainCartao(navController = navController)
        }
        composable("objetivo") {
            ObjetivoScreen(navController = navController)
        }

        composable("login") {
            LoginScreen1(navController = navController)
        }



    }

}