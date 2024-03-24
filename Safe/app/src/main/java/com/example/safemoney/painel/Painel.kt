package com.example.safemoney.painel

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.absoluteOffset
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.currentCompositionLocalContext
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import androidx.navigation.NavController
import com.example.a4adsb_29_02.BarGraph
import com.example.safemoney.FooterBar
import com.example.safemoney.R

@Composable
fun ThreeContainersWithList(navController: NavController) {

    val listaContas = listOf(
        ContaBancaria(R.drawable.logo_bradesco, "Banco A", 5000.00),
        ContaBancaria(R.drawable.logo_santander, "Banco B", -3200.00),
        ContaBancaria(R.drawable.logo_itau, "Banco C", 8500.00),
        ContaBancaria(R.drawable.logo_santander, "Banco D", 8500.00)
        // Adicione mais contas conforme necessário
    )
    val listaCartao = listOf(
        CartaoBancario(R.drawable.logo_elo, "Banco A", 5000.00, 5000.00),
        CartaoBancario(R.drawable.logo_visa, "Banco B", 3200.00, 5000.00),
        CartaoBancario(R.drawable.logo_mastercard, "Banco C", 8500.00, 5000.00)
        // Adicione mais contas conforme necessário
    )

    val listaTransacao = listOf(
        TransacaoBancaria(R.drawable.saude, "Shopping", "01/10", 5000.00),
        TransacaoBancaria(R.drawable.saude, "Academia", "01/11", 5000.00),
        TransacaoBancaria(R.drawable.saude, "Farmácia", "04/12", 5000.00),
        TransacaoBancaria(R.drawable.saude, "Amazon", "04/12", 5000.00) ,
        TransacaoBancaria(R.drawable.saude, "Consulta", "04/12", 5000.00)
        // Adicione mais contas conforme necessário
    )


    LazyColumn(
        modifier = Modifier.fillMaxSize()
    ) {

        item {
            Box(
                modifier = Modifier
                    .fillMaxSize()

            ) {

                Surface(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(220.dp),
                    color = Color(0xFF08632D)
                ) {
                    // Row para posicionar elementos à esquerda, no centro e à direita
                    Row(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(8.dp),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.Top
                    ) {
                        // Imagem à esquerda
                        Image(
                            painter = painterResource(id = R.drawable.logo),
                            contentDescription = null,
                            modifier = Modifier
                                .size(30.dp)
                                .padding(top = 8.dp)
                        )

                        // Texto no centro
                        Text(
                            text = "SafeMoney",
                            style = TextStyle(
                                fontWeight = FontWeight.Bold,
                                fontSize = 17.sp
                            ),
                            modifier = Modifier
                                .weight(0.2f)
                                .padding(8.dp)
                                .align(Alignment.Top),
                            color = Color.White
                        )

                        // Imagem à direita
                        Image(
                            painter = painterResource(id = R.drawable.sino),
                            contentDescription = null,
                            modifier = Modifier
                                .size(40.dp)
                        )
                    }
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(8.dp, top = 60.dp)

                    ) {
                        Text(
                            text = "seu Balanço:",
                            style = MaterialTheme.typography.bodyLarge,
                            modifier = Modifier
                                .padding(8.dp),
                            color = Color.White
                        )
                        Text(
                            text = "R$ 10.000,00",
                            style = TextStyle(
                                fontSize = 24.sp,
                                fontWeight = FontWeight.Bold,
                                letterSpacing = 2.sp
                            ),
                            modifier = Modifier
                                .padding(8.dp, top = 1.dp),
                            color = Color.White
                        )
                    }
                }
                // container sobreposto do meio

                Box(
                    modifier = Modifier
                        .height(250.dp)
                        .width(300.dp)
                        .padding(8.dp, top = 170.dp)
                        .clip(shape = RoundedCornerShape(8.dp))
                        .shadow(elevation = 20.dp,)
                        .background(Color.White) // Define o fundo branco
                        .align(Alignment.Center)
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxSize()
                            .zIndex(1f)
                            .padding(8.dp),
                        horizontalArrangement = Arrangement.SpaceAround,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Column() {
                            Image(
                                painter = painterResource(id = R.drawable.receita_logo),
                                contentDescription = null,
                                modifier = Modifier
                                    .size(40.dp)
                                    .clip(CircleShape)
                                    .zIndex(1f)
                                    .padding(horizontal = 3.dp)
                                    .align(Alignment.CenterHorizontally)
                            )
                            Text(
                                text = "Receita",
                                style = TextStyle(
                                    fontSize = 12.sp,
                                ),
                                color = Color.Black
                            )
                        }

                        // Imagem 2
                        Column{
                            Image(
                                painter = painterResource(id = R.drawable.despesa_logo),
                                contentDescription = null,
                                modifier = Modifier
                                    .size(40.dp)
                                    .align(Alignment.CenterHorizontally)
                                    .padding(horizontal = 3.dp) // Adapte o espaçamento conforme necessário
                            )

                            Text(
                                text = "Despesa",
                                style = TextStyle(
                                    fontSize = 12.sp,
                                ),
                                modifier = Modifier,
                                color = Color.Black
                            )
                        }

                        // Imagem 3

                        Column() {
                            Image(
                                painter = painterResource(id = R.drawable.transferencia_logo),
                                contentDescription = null,
                                modifier = Modifier
                                    .size(40.dp)
                                    .padding(horizontal = 3.dp)
                                    .align(Alignment.CenterHorizontally)
                            )

                            Text(
                                text = "Transição",
                                style = TextStyle(
                                    fontSize = 12.sp,
                                ),
                                modifier = Modifier,
                                color = Color.Black
                            )
                        }
                    }
                }
            }
        }

        // Adicionando um espaçador para ocupar espaço na parte superior
        item { Spacer(modifier = Modifier.height(20.dp)) }

        // Adicionando conteúdo da parte branca
        item {
            Container("Contas", 10) {
                LazyColumn(
                    modifier = Modifier
                        .height(175.dp)
                        .fillMaxWidth()
                ) {
                    items(listaContas) { conta ->
                        ContasTableRow(
                            imagemResId = conta.imagemResId,
                            nomeBanco = conta.nomeBanco,
                            saldo = conta.saldo
                        )
                    }
                }
            }
        }

        item {
            Container2("Cartões", 60) {
                LazyColumn(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(175.dp)
                    ,
                    contentPadding = PaddingValues(horizontal = 8.dp, vertical = 4.dp)
                ) {
                    items(listaCartao) { conta ->
                        CartoesTableRow(
                            imagemResId = conta.imagemResId,
                            nomeBanco = conta.nomeBanco,
                            fatura = conta.fatura,
                            disponivel = conta.disponivel,
                        )
                    }
                }
            }
        }

        item {
            Container3("Transações Recentes", 60) {
                LazyColumn(
                    modifier = Modifier
                        .height(250.dp)
                        .fillMaxWidth()
                ) {
                    items(listaTransacao.take(5)) { conta ->
                        TransacaoTableRow(
                            imagemResId = conta.imagemResId,
                            nomeTransacao = conta.nomeTransacao,
                            data = conta.data,
                            valor= conta.valor
                        )
                    }
                }
            }
        }
        item {
            Container4("Previsão final do mês", 60) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Box(
                        modifier = Modifier.weight(1f)
                    ) {
                        BarGraph(
                            graphBarData = listOf(0.5f, 0.8f),
                            xAxisScaleData = listOf(1, 2),
                            barData_ = listOf(0, 1500, 3000, 4500, 6000),
                            height = 200.dp,
                            roundType = BarType.TOP_CURVED,
                            barWidth = 55.dp,
                            barColor = Color.Green, // Lista de cores para as barras
                            barArrangement = Arrangement.SpaceEvenly
                        )
                    }
                    Column(
                        modifier = Modifier.padding(start = 16.dp),
                    ) {
                        Text(
                            text = "Receita: R$4.500,00",
                            style = MaterialTheme.typography.bodyMedium,
                            color = Color(0XFF030303),
                            modifier = Modifier
                                .border(1.dp, Color.Black, CircleShape)
                                .padding(6.dp)// Adicionar borda circular
                        )
                        Text(
                            text = "Despesa: R$4.500,00",
                            style = MaterialTheme.typography.bodyMedium,
                            color = Color(0XFF030303),
                            modifier = Modifier
                                .border(1.dp, Color.Black, CircleShape)
                                .padding(6.dp)
                        )
                        Text(
                            text = "Balanço: R$4.500,00",
                            style = MaterialTheme.typography.bodyMedium,
                            color = Color(0XFF030303),
                            modifier = Modifier
                                .border(1.dp, Color.Black, CircleShape)
                                .padding(6.dp)
                        )
                    }
                }
            }
        }


        item { Spacer(modifier = Modifier.height(20.dp)) }
    }

    FooterBar(navController)
}

data class ContaBancaria(
    @DrawableRes val imagemResId: Int,
    val nomeBanco: String,
    val saldo: Double
)
data class CartaoBancario(
    @DrawableRes val imagemResId: Int,
    val nomeBanco: String,
    val fatura: Double,
    val disponivel: Double
)

data class TransacaoBancaria(
    @DrawableRes val imagemResId: Int,
    val nomeTransacao: String,
    val data: String,
    val valor: Double
)

@Composable
fun ContasTableRow(
    @DrawableRes imagemResId: Int,
    nomeBanco: String,
    saldo: Double
) {
    val textColor = if (saldo > 0) Color.Green else Color.Red

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically

    ) {
        // Parte 1: Imagem
        Image(
            painter = painterResource(id = imagemResId),
            contentDescription = null,
            modifier = Modifier
                .weight(0.12f)
                .size(40.dp)
                .clip(CircleShape)
        )

        Spacer(modifier = Modifier.width(8.dp))

        // Parte 2: Nome do Banco
        Column(
            modifier = Modifier.weight(0.55f)
        ) {
            Text(
                text = nomeBanco,
                style = MaterialTheme.typography.bodyMedium,
                color = Color(0XFF030303)
            )
            Text(
                text = "Vencimento 01/10",
                style = TextStyle(
                    fontSize = 8.sp
                ),
                color = Color(0XFF565656)
            )
        }

        Spacer(modifier = Modifier.width(8.dp))

        // Parte 3: Saldo
        Text(
            text = "R$ $saldo" ,
            style = MaterialTheme.typography.bodyMedium,
            color = textColor,
            textAlign = TextAlign.Center,
            modifier = Modifier.weight(0.3f)
        )
    }
    Spacer(
        modifier = Modifier
            .fillMaxWidth()
            .height(1.dp)
            .background(color = Color(0XFFCDCDCD))
    )
}

@Composable
fun CartoesTableRow(
    @DrawableRes imagemResId: Int,
    nomeBanco: String,
    fatura:Double,
    disponivel: Double
) {

    val textColor = if (fatura > 0) Color.Green else Color.Red

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 8.dp, bottom = 8.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        // Parte 1: Imagem
        Image(
            painter = painterResource(id = imagemResId),
            contentDescription = null,
            modifier = Modifier
                .weight(0.12f)
                .size(40.dp)
                .clip(CircleShape)
        )

        Spacer(modifier = Modifier.width(8.dp))

        // Parte 2: Nome do Banco

        Column(
            modifier = Modifier.weight(0.28f)
        ) {
            Text(
                text = nomeBanco,
                style = MaterialTheme.typography.bodyMedium,
                color = Color(0XFF030303)
            )
            Text(
                text = "Vencimento 01/10",
                style = TextStyle(
                    fontSize = 8.sp
                ),
                color = Color(0XFF565656)
            )
        }

        Spacer(modifier = Modifier.width(8.dp))

        // Parte 3: fatura
        Text(
            text = "R$ $fatura",
            style = MaterialTheme.typography.bodyMedium,
            color = textColor,
            textAlign = TextAlign.Center,
            modifier = Modifier.weight(0.3f)
        )
        Spacer(modifier = Modifier.width(8.dp))

        // Parte 3: disponivel
        Text(
            text = "R$ $disponivel",
            style = MaterialTheme.typography.bodyMedium,
            color = Color(0XFFC568F6),
            textAlign = TextAlign.Center,
            modifier = Modifier.weight(0.3f)
        )
    }
    Spacer(
        modifier = Modifier
            .fillMaxWidth()
            .height(1.dp)
            .background(color = Color(0XFFCDCDCD))
    )
}
@Composable
fun TransacaoTableRow(
    @DrawableRes imagemResId: Int,
    nomeTransacao: String,
    data: String,
    valor: Double
) {

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 4.dp, bottom = 4.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        // Parte 1: Imagem
        Image(
            painter = painterResource(id = imagemResId),
            contentDescription = null,
            modifier = Modifier
                .weight(0.12f)
                .size(40.dp)
                .clip(CircleShape)
        )

        Spacer(modifier = Modifier.width(8.dp))

        // Parte 2: Nome do Banco

        Column(
            modifier = Modifier.weight(0.28f)
        ) {
            Text(
                text = nomeTransacao,
                style = MaterialTheme.typography.bodyMedium,
                color = Color(0XFF030303)
            )
            Text(
                text = "Débito",
                style = TextStyle(
                    fontSize = 8.sp
                ),
                color = Color(0XFF565656)
            )
        }

        Spacer(modifier = Modifier.width(8.dp))

        // Parte 3: fatura
        Text(
            text = "R$ $data",
            style = MaterialTheme.typography.bodyMedium,
            color = Color(0xFF3A3A3A),
            textAlign = TextAlign.Center,
            modifier = Modifier.weight(0.3f)
        )
        Spacer(modifier = Modifier.width(8.dp))

        // Parte 3: disponivel
        Text(
            text = "R$ $valor",
            style = MaterialTheme.typography.bodyMedium,
            color = Color(0XFF3A3A3A),
            textAlign = TextAlign.Center,
            modifier = Modifier.weight(0.3f)
        )
    }
    Spacer(
        modifier = Modifier
            .fillMaxWidth()
            .height(1.dp)
            .background(color = Color(0XFFCDCDCD))
    )
}



@Composable
fun Container(title: String, distancia: Int, content: @Composable (() -> Unit)? = null) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = distancia.dp, start = 16.dp, end = 16.dp)
    ) {
        Row() {
            Image(
                painter = painterResource(id = R.drawable.container_logo), // Substitua pelo recurso de imagem adequado
                contentDescription = null,
                modifier = Modifier
                    .size(40.dp)
                    .padding(5.dp)
                    .clip(CircleShape)
            )

            Text(
                text = title,
                style = TextStyle(
                    fontWeight = FontWeight.Medium,
                    fontSize = 18.sp

                ),
                modifier = Modifier
                    .weight(0.4f)
                    .padding(8.dp)
                    .align(Alignment.Top)
            )
        }
        Row(
            modifier = Modifier
                .padding(start=8.dp)
        ){
            Text(
                text = "",
                style = MaterialTheme.typography.bodyLarge,
                modifier = Modifier
                    .weight(0.7f)

            )
            Text(
                text = "saldo",
                color = Color(0XFFA7A7A7),
                style = TextStyle(
                    fontSize = 12.sp
                ),
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .weight(0.3f)
            )
        }
        content?.invoke()
    }
}

@Composable
fun Container2(title: String, distancia: Int, content: @Composable (() -> Unit)? = null) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = distancia.dp, start = 16.dp, end = 16.dp)
    ) {
        Row() {
            Image(
                painter = painterResource(id = R.drawable.container_logo), // Substitua pelo recurso de imagem adequado
                contentDescription = null,
                modifier = Modifier
                    .size(40.dp)
                    .padding(5.dp)
                    .clip(CircleShape)
            )

            Text(
                text = title,
                style = TextStyle(
                    fontWeight = FontWeight.Medium,
                    fontSize = 18.sp

                ),
                modifier = Modifier
                    .weight(0.4f)
                    .padding(8.dp)
                    .align(Alignment.Top)
            )
            Text(
                text = "Ver Todos >",
                style = TextStyle(
                    fontWeight = FontWeight.Normal,
                    fontSize = 12.sp
                ),
                textAlign = TextAlign.End,
                modifier = Modifier
                    .weight(0.2f)
                    .padding(8.dp)
                    .align(Alignment.Top)
            )
        }
        Row(
            modifier = Modifier
                .padding(start=8.dp)
        ){
            Text(
                text = "",
                style = MaterialTheme.typography.bodyLarge,
                modifier = Modifier
                    .weight(0.4f)

            )
            Text(
                text = "saldo",
                color = Color(0XFFA7A7A7),
                style = TextStyle(
                    fontSize = 12.sp
                ),
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .weight(0.3f)
            )
            Text(
                text = "disponivel",
                color = Color(0XFFA7A7A7),
                style = TextStyle(
                    fontSize = 12.sp
                ),
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .weight(0.3f)
            )
        }
        content?.invoke()
    }
}

@Composable
fun Container3(title: String, distancia: Int, content: @Composable (() -> Unit)? = null) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = distancia.dp, start = 16.dp, end = 16.dp)
    ) {
        Row() {
            Image(
                painter = painterResource(id = R.drawable.container_logo), // Substitua pelo recurso
                contentDescription = null,
                modifier = Modifier
                    .size(40.dp)
                    .padding(5.dp)
                    .clip(CircleShape)
            )

            Text(
                text = title,
                style = TextStyle(
                    fontWeight = FontWeight.Medium,
                    fontSize = 18.sp

                ),
                modifier = Modifier
                    .weight(0.4f)
                    .padding(8.dp)
                    .align(Alignment.Top)
            )
            Text(
                text = "Ver Todos >",
                style = TextStyle(
                    fontWeight = FontWeight.Normal,
                    fontSize = 12.sp
                ),
                textAlign = TextAlign.End,
                modifier = Modifier
                    .weight(0.2f)
                    .padding(8.dp)
                    .align(Alignment.Top)
            )
        }
        Row(
            modifier = Modifier
                .padding(start=8.dp)
        ){
            Text(
                text = "",
                style = MaterialTheme.typography.bodyLarge,
                modifier = Modifier
                    .weight(0.4f)

            )
            Text(
                text = "data",
                color = Color(0XFFA7A7A7),
                style = TextStyle(
                    fontSize = 12.sp
                ),
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .weight(0.3f)
            )
            Text(
                text = "valor",
                color = Color(0XFFA7A7A7),
                style = TextStyle(
                    fontSize = 12.sp
                ),
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .weight(0.3f)
            )
        }
        content?.invoke()
    }
}

@Composable
fun Container4(title: String, distancia: Int, content: @Composable (() -> Unit)? = null) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = distancia.dp, start = 16.dp, end = 16.dp)
    ) {
        Row() {
            Image(
                painter = painterResource(id = R.drawable.container_logo), // Substitua pelo recurso de imagem adequado
                contentDescription = null,
                modifier = Modifier
                    .size(40.dp)
                    .padding(5.dp)
                    .clip(CircleShape)
            )

            Text(
                text = title,
                style = TextStyle(
                    fontWeight = FontWeight.Medium,
                    fontSize = 18.sp

                ),
                modifier = Modifier
                    .weight(0.4f)
                    .padding(8.dp)
                    .align(Alignment.Top)
            )
        }
        content?.invoke()

    }


}

