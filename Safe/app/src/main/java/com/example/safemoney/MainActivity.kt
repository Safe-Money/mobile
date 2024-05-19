package com.example.safemoney

import ContaViewModel
import LancamentoViewModel
import LoginViewModel
import MainPainel
import ObjetivoViewModel
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.safemoney.cadastro.CadastroScreen
import com.example.safemoney.cartoes.MainCartao
import com.example.safemoney.config.ConfigScreen
import com.example.safemoney.di.appModule
import com.example.safemoney.login.LoginScreen1
import com.example.safemoney.menu.Menu
import com.example.safemoney.planejamento.LancamentosScreen2
import com.example.safemoney.planejamento.Planejamento
import com.example.safemoney.telas_acao.cartao_acao.CartaoScreen
import com.example.safemoney.telas_acao.conta_acao.ContaScreen
import com.example.safemoney.telas_acao.despesa_acao.PlanoScreen
import com.example.safemoney.telas_acao.lancamentos_acao.LancamentosScreen
import com.example.safemoney.telas_acao.objetivo_acao.ObjetivoAddScreen
import com.example.safemoney.viewmodel.CadastroViewModel
import com.example.safemoney.viewmodel.CartaoViewModel
import com.example.safemoney.viewmodel.CategoriaViewModel
import com.example.tela_objetivos.ObjetivoScreen
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.androidx.compose.getViewModel
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        startKoin {
            androidLogger(Level.DEBUG)
            androidLogger(Level.ERROR)
            androidContext(this@MainActivity)
            modules(appModule)
        }
        setContent {
            SafeMoneyApp()
        }
    }
}

@Composable
fun SafeMoneyApp() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "login") {
        composable("cadastro") {
            println("cheguei")
            val cadastroViewModel: CadastroViewModel = getViewModel()
            CadastroScreen(navController = navController, cadastroViewModel = cadastroViewModel)
        }
        composable("login") {
            val loginViewModel: LoginViewModel = getViewModel()
            LoginScreen1(navController = navController, loginViewModel = loginViewModel)
        }
        composable("config") {
            val loginViewModel: LoginViewModel = getViewModel()
            ConfigScreen(navController = navController, loginViewModel = loginViewModel)
        }
        composable("addConta") {
            val contaViewModel: ContaViewModel = getViewModel()
            val loginViewModel: LoginViewModel = getViewModel()
            ContaScreen(
                navController = navController,
                contaViewModel = contaViewModel,
                loginViewModel = loginViewModel
            )
        }
        composable("painel") {
            val contaViewModel: ContaViewModel = getViewModel()
            val cartaoViewModel: CartaoViewModel = getViewModel()
            MainPainel(
                navController = navController,
                contaViewModel = contaViewModel,
                cartaoViewModel = cartaoViewModel
            )
        }
        composable("menu") {
            val loginViewModel: LoginViewModel = getViewModel()
            Menu(navController = navController, loginViewModel = loginViewModel)
        }
        composable("addCartao") {
            val cartaoViewModel: CartaoViewModel = getViewModel()
            val loginViewModel: LoginViewModel = getViewModel()
            val contaViewModel: ContaViewModel = getViewModel()
            val userId = loginViewModel.getId()
            val listaContas by contaViewModel.listarContas(userId)
                .observeAsState(initial = emptyList())
            CartaoScreen(
                navController = navController,
                cartaoViewModel = cartaoViewModel,
                contas = listaContas,
                loginViewModel = loginViewModel
            )
        }

        composable("telaCartao") {
            val cartaoViewModel: CartaoViewModel = getViewModel()
            MainCartao(navController = navController, cartaoViewModel = cartaoViewModel)
        }

        composable("addLancamentos") {
            val categoriaViewModel: CategoriaViewModel = getViewModel()
            val lancamentoViewModel: LancamentoViewModel = getViewModel()
            val loginViewModel: LoginViewModel = getViewModel()
            val listaCategorias by categoriaViewModel.listarCategorias()
                .observeAsState(initial = emptyList())
            val contaViewModel: ContaViewModel = getViewModel()
            val userId = loginViewModel.getId()
            val listaContas by contaViewModel.listarContas(userId)
                .observeAsState(initial = emptyList())
            LancamentosScreen(
                navController = navController,
                categoriaViewModel = categoriaViewModel,
                categorias = listaCategorias,
                contas = listaContas,
                lancamentoViewModel = lancamentoViewModel,
                loginViewModel = loginViewModel
            )
        }

        composable("topCartao") {
            TopBar1(navController = navController)
        }
        composable("lancamentos") {
            val lancamentoViewModel: LancamentoViewModel = getViewModel()
            val loginViewModel: LoginViewModel = getViewModel()
            val contaViewModel: ContaViewModel = getViewModel()
            val userId = loginViewModel.getId()
            val listaContas by contaViewModel.listarContas(userId)
                .observeAsState(initial = emptyList())
            LancamentosScreen2(
                navController = navController,
                lancamentoViewModel = lancamentoViewModel,
                loginViewModel = loginViewModel,

            )
        }
        composable("planejamento") {
            Planejamento(navController = navController)
        }

        composable("addPlanejamento") {
            val categoriaViewModel: CategoriaViewModel = getViewModel()
            val listaCategorias by categoriaViewModel.listarCategorias()
                .observeAsState(initial = emptyList())
            PlanoScreen(navController = navController, categorias = listaCategorias,)
        }

        composable("addObjetivos") {
            val loginViewModel: LoginViewModel = getViewModel()
            val objetivoViewModel : ObjetivoViewModel = getViewModel()
            ObjetivoAddScreen(navController = navController,  loginViewModel = loginViewModel, objetivoViewModel = objetivoViewModel)
        }


        composable("objetivo") {
            val objetivoViewModel : ObjetivoViewModel = getViewModel()
            ObjetivoScreen(navController = navController, objetivoViewModel = objetivoViewModel)
        }
    }
}
