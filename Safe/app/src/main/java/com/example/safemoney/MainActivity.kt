package com.example.safemoney



import ContaViewModel
import LancamentoViewModel
import LoginViewModel
import MainPainel
import UserConta
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.safemoney.cadastro.CadastroScreen
import com.example.safemoney.cartoes.MainCartao
import com.example.safemoney.config.ConfigScreen
import com.example.safemoney.di.appModule
import com.example.safemoney.login.LoginScreen1
import com.example.safemoney.menu.Menu
import com.example.safemoney.model.Categoria
import com.example.safemoney.planejamento.LancamentosScreen2
import com.example.safemoney.telas_acao.cartao_acao.CartaoScreen
import com.example.safemoney.telas_acao.conta_acao.ContaScreen
import com.example.safemoney.telas_acao.despesa_acao.PlanoScreen
import com.example.safemoney.telas_acao.lancamentos_acao.LancamentosScreen
import com.example.safemoney.viewmodel.CadastroViewModel
import com.example.safemoney.viewmodel.CartaoViewModel
import com.example.safemoney.viewmodel.CategoriaViewModel
import com.example.tela_objetivos.ObjetivoScreen
import org.koin.android.ext.android.inject
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
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
            val navController = rememberNavController()
            val cadastroViewModel: CadastroViewModel by inject()
            val loginViewModel: LoginViewModel by inject()
            val contaViewModel: ContaViewModel by inject()
            val lancamentoViewModel: LancamentoViewModel by inject()
            val cartaoViewModel: CartaoViewModel by inject()
            val categoriaViewModel: CategoriaViewModel by inject()
            val userId = loginViewModel.getId()

            val listaContas by contaViewModel.listarContas(userId).observeAsState(initial = emptyList())
            val listaCategorias by categoriaViewModel.listarCategorias().observeAsState(initial = emptyList())

            SafeMoneyApp(
                navController = navController,
                cadastroViewModel = cadastroViewModel,
                loginViewModel = loginViewModel,
                contaViewModel = contaViewModel,
                listaContas = listaContas,
                cartaoViewModel = cartaoViewModel,
                categoriaViewModel = categoriaViewModel,
                listaCategorias = listaCategorias,
                lancamentoViewModel= lancamentoViewModel
            )
        }
    }
}

@Composable
fun SafeMoneyApp(navController: NavHostController,
                 cadastroViewModel: CadastroViewModel,
                 loginViewModel: LoginViewModel,
                 contaViewModel: ContaViewModel,
                 listaContas: List<UserConta>,
                 listaCategorias: List<Categoria>,
                 cartaoViewModel: CartaoViewModel,
                 categoriaViewModel: CategoriaViewModel,
                 lancamentoViewModel: LancamentoViewModel) {

    NavHost(navController = navController, startDestination = "login") {
        composable("cadastro") {
            println("cheguei")
            CadastroScreen(navController = navController, cadastroViewModel = cadastroViewModel)
        }
        composable("login") {
            LoginScreen1(navController = navController, loginViewModel = loginViewModel)
        }
        composable("config") {
            ConfigScreen(navController = navController, loginViewModel = loginViewModel )
        }
        composable("addConta") {
            ContaScreen(navController = navController, contaViewModel = contaViewModel,  loginViewModel = loginViewModel )
        }
        composable("painel") {
            MainPainel(navController = navController,contaViewModel = contaViewModel,  cartaoViewModel = cartaoViewModel )
        }
        composable("menu") {
            Menu(navController = navController,loginViewModel = loginViewModel)
        }
        composable("addCartao") {
            CartaoScreen(navController = navController, cartaoViewModel = cartaoViewModel, contas = listaContas, loginViewModel = loginViewModel)
        }

        composable("telaCartao") {
            MainCartao(navController = navController, cartaoViewModel = cartaoViewModel)
        }

        composable("addLancamentos") {
            LancamentosScreen(navController = navController, categoriaViewModel = categoriaViewModel, categorias = listaCategorias, contas = listaContas,lancamentoViewModel = lancamentoViewModel,loginViewModel = loginViewModel )
        }

        composable("topCartao") {
            TopBar1(navController = navController)
        }
        composable("lancamentos") {
            LancamentosScreen2(navController = navController,  lancamentoViewModel = lancamentoViewModel, loginViewModel = loginViewModel)
        }
        composable("planejamento") {
            PlanoScreen(navController = navController)
        }
        composable("objetivo") {
            ObjetivoScreen(navController = navController)
        }
    }
}
