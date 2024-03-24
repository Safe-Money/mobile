package com.example.safemoney.planejamento

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Divider
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
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
import com.example.safemoney.FooterBar
import com.example.safemoney.R
import com.example.safemoney.componentes.BotaoMes
import com.example.safemoney.componentes.BotoesSwitch
import com.example.safemoney.componentes.Lancamento
import com.example.safemoney.componentes.Lista

@Composable
fun LancamentosScreen2(navController: NavController) {

    val listaBox1 = listOf(
        Lancamento(
            local = "Shopping",
            tipo = "Débito",
            nomeConta = "Conta Corrente",
            valor = "- R\$ 150,00"
        ),
        Lancamento(
            local = "Medico",
            tipo = "Tipo 1",
            nomeConta = "Conta 1",
            valor = "R\$ 100,00"
        ),
        Lancamento(
            local = "Academia",
            tipo = "Tipo 1",
            nomeConta = "Conta 1",
            valor = "R\$ 100,00"
        ),
        Lancamento(
            local = "Academia",
            tipo = "Tipo 1",
            nomeConta = "Conta 1",
            valor = "R\$ 100,00"
        ),


        )


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
            Text(
                text = "Lançamentos",
                fontFamily = FontFamily(Font(R.font.montserrat)),
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .padding(start = 16.dp)
                    .align(Alignment.Start)
            )
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
                    Lista(lancamentos = listaBox1)
                }

                item {
                    Text(
                        text = "Segunda, 17",
                        fontFamily = FontFamily(Font(R.font.montserrat)),
                        fontSize = 15.sp,
                        color = Color.Black,
                        modifier = Modifier.padding(16.dp)
                    )
                    Lista(lancamentos = listaBox1)
                }
                item {
                    Text(
                        text = "Domingo, 16",
                        fontFamily = FontFamily(Font(R.font.montserrat)),
                        fontSize = 15.sp,
                        color = Color.Black,
                        modifier = Modifier.padding(16.dp)
                    )
                    Lista(lancamentos = listaBox1)
                }

                item {
                    Text(
                        text = "Sabado, 15",
                        fontFamily = FontFamily(Font(R.font.montserrat)),
                        fontSize = 15.sp,
                        color = Color.Black,
                        modifier = Modifier.padding(16.dp)
                    )
                    Lista(lancamentos = listaBox1)
                }

                item {
                    Text(
                        text = "Sexta, 14",
                        fontFamily = FontFamily(Font(R.font.montserrat)),
                        fontSize = 15.sp,
                        color = Color.Black,
                        modifier = Modifier.padding(16.dp)
                    )
                    Lista(lancamentos = listaBox1)

                }


            }
            FooterBar(navController)

        }
    }

}

