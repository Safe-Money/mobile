package com.example.safemoney



import ContaViewModel
import LoginViewModel
import UserConta
import UsuarioViewModel
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.remember
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.safemoney.cadastro.CadastroScreen
import com.example.safemoney.config.ConfigScreen
import com.example.safemoney.di.appModule
import com.example.safemoney.login.LoginScreen1
import com.example.safemoney.menu.Menu
import com.example.safemoney.painel.ThreeContainersWithList
import com.example.safemoney.telas_acao.conta_acao.ContaScreen
import com.example.safemoney.viewmodel.CadastroViewModel
import org.koin.android.ext.android.inject
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.context.startKoin
import org.koin.core.logger.Level
import org.koin.android.ext.koin.androidApplication
import org.koin.android.ext.koin.androidLogger
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import org.koin.dsl.module

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        startKoin {
            androidLogger(Level.ERROR)
            androidContext(this@MainActivity)
            modules(appModule)
        }

        setContent {
            val navController = rememberNavController()
            val cadastroViewModel: CadastroViewModel by inject()
            val loginViewModel: LoginViewModel by inject()
            val contaViewModel: ContaViewModel by inject()
            val userId = loginViewModel.getId()

            val listaContas by contaViewModel.listarContas(userId).observeAsState(initial = emptyList())

            SafeMoneyApp(
                navController = navController,
                cadastroViewModel = cadastroViewModel,
                loginViewModel = loginViewModel,
                contaViewModel = contaViewModel,
                listaContas = listaContas
            )
        }
    }
}

@Composable
fun SafeMoneyApp(navController: NavHostController, cadastroViewModel: CadastroViewModel, loginViewModel: LoginViewModel, contaViewModel: ContaViewModel,  listaContas: List<UserConta>) {
    NavHost(navController = navController, startDestination = "cadastro") {
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
            ThreeContainersWithList(navController = navController,contaViewModel = contaViewModel )
        }
        composable("menu") {
            Menu(navController = navController)
        }
    }
}
