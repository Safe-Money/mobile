import android.content.Context
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
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.safemoney.FooterBar

import com.example.safemoney.painel.ThreeContainersWithList
import com.example.safemoney.ui.theme.SafeMoneyTheme
import com.example.safemoney.ui.theme.Vermelho
import com.example.safemoney.viewmodel.CartaoViewModel
import com.example.safemoney.viewmodel.TransacaoViewModel

@Composable
fun MainPainel(modifier: Modifier = Modifier, navController: NavController, contaViewModel: ContaViewModel, cartaoViewModel: CartaoViewModel, transacaoViewModel: TransacaoViewModel, lancamentoViewModel: LancamentoViewModel, lancFixoTotal: LancFixoTotal) {
    val sharedPreferences = LocalContext.current.getSharedPreferences("user_session", Context.MODE_PRIVATE)
    val userId = sharedPreferences.getInt("id", -1)

    val listaContas by contaViewModel.contasLiveData.observeAsState(initial = emptyList())
    val listaTransacoes by transacaoViewModel.transacoes.observeAsState(initial = emptyList())

    LaunchedEffect(Unit) {
        contaViewModel.listarContas(userId)
        transacaoViewModel.listarTransacoes(userId)
    }

    Scaffold(
        bottomBar = { FooterBar(navController) }
    ) {it
        Column(
            modifier = Modifier
                .fillMaxSize(),
            verticalArrangement = Arrangement.Center
        ) {
            ThreeContainersWithList(navController = navController, contaViewModel = contaViewModel, cartaoViewModel = cartaoViewModel, transacaoViewModel = transacaoViewModel, lancamentoViewModel = lancamentoViewModel, lancFixoTotal = lancFixoTotal)
        }
    }
}
