package com.example.safemoney.planejamento

import LancamentoViewModel
import LancamentosGet
import LoginViewModel
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.safemoney.FooterBar
import com.example.safemoney.R
import com.example.safemoney.componentes.BotaoMes
import com.example.safemoney.componentes.BotoesSwitch


import com.example.safemoney.componentes.Lista

@Composable
fun LancamentosScreen2(navController: NavController, lancamentoViewModel: LancamentoViewModel, loginViewModel: LoginViewModel) {


    val userId = loginViewModel.getId()


    val lancamentosState by lancamentoViewModel.lancamentos.observeAsState(listOf())


    LaunchedEffect(Unit) {
        lancamentoViewModel.listarLancamentos(userId)
    }






    Surface(
        modifier = Modifier.fillMaxSize(),
        color = Color.White
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Spacer(modifier = Modifier.height(10.dp))
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
            ) {
                Text(
                    text = "Lançamentos",
                    fontFamily = FontFamily(Font(R.font.montserrat)),
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier
                        .padding(start = 16.dp)

                )

                IconButton(
                    onClick = { navController.navigate("addLancamentos") },
                    modifier = Modifier
                        .size(24.dp)
                        .padding(end = 5.dp)
                ) {
                    Icon(
                        imageVector = Icons.Default.AddCircle,
                        contentDescription = null
                    )
                }
            }
            Spacer(modifier = Modifier.height(10.dp))

            Divider(
                color = Color(0xFFCDCDCD),
                thickness = 1.dp,
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(5.dp))

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp)
                    .padding(start = 16.dp)
            ) {
                BotoesSwitch()
            }

            Spacer(modifier = Modifier.height(5.dp))

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp)
                    .padding(start = 16.dp)
            ) {
                BotaoMes(
                    mesAtual = "Fevereiro",
                    onClickPrevious = {
                        println("")
                    },
                    onClickNext = {
                        println("")
                    }
                )
            }

            Divider(
                color = Color(0xFFCDCDCD),
                thickness = 1.dp,
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(10.dp))

            LazyColumn(
                modifier = Modifier.weight(1f),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            )


            {
                item {
                    Text(
                        text = "Hoje",
                        fontFamily = FontFamily(Font(R.font.montserrat)),
                        fontSize = 15.sp,
                        color = Color.Black,
                        modifier = Modifier.padding(16.dp)
                    )
                    Lista(lancamentos = lancamentosState)
                }

                item {
                    Text(
                        text = "Segunda, 17",
                        fontFamily = FontFamily(Font(R.font.montserrat)),
                        fontSize = 15.sp,
                        color = Color.Black,
                        modifier = Modifier.padding(16.dp)
                    )
                    Lista(lancamentos = lancamentosState)
                }
                item {
                    Text(
                        text = "Domingo, 16",
                        fontFamily = FontFamily(Font(R.font.montserrat)),
                        fontSize = 15.sp,
                        color = Color.Black,
                        modifier = Modifier.padding(16.dp)
                    )
                    Lista(lancamentos = lancamentosState)
                }

                item {
                    Text(
                        text = "Sabado, 15",
                        fontFamily = FontFamily(Font(R.font.montserrat)),
                        fontSize = 15.sp,
                        color = Color.Black,
                        modifier = Modifier.padding(16.dp)
                    )
                    Lista(lancamentos = lancamentosState)
                }

                item {
                    Text(
                        text = "Sexta, 14",
                        fontFamily = FontFamily(Font(R.font.montserrat)),
                        fontSize = 15.sp,
                        color = Color.Black,
                        modifier = Modifier.padding(16.dp)
                    )
                    Lista(lancamentos = lancamentosState)

                }

                itemsIndexed(lancamentosState) { index, lancamento ->
                    Text(
                        text = lancamento.data,
                        fontFamily = FontFamily(Font(R.font.montserrat)),
                        fontSize = 15.sp,
                        color = Color.Black,
                        modifier = Modifier.padding(16.dp)
                    )
                    LancamentosGet(
                        nome = lancamento.nome,
                        data = lancamento.data,
                        valor = lancamento.valor,
                        fkCategoria = lancamento.fkCategoria
                    )
                }
            }
            FooterBar(navController)

        }
    }
}

