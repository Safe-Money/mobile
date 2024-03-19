package com.example.a4adsb_29_02

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
import com.example.a4adsb_29_02.ui.theme._4ADSB_29_02Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            _4ADSB_29_02Theme {

            }
        }
    }
}

@Composable
fun ThreeContainersWithList() {
    var greens = Color(R.color.verdeSafeMoney)
    val listaContas = listOf(
        ContaBancaria(R.drawable.peixes, "Banco A", "R$ 5.000,00"),
        ContaBancaria(R.drawable.img_primeira, "Banco B", "R$ 3.200,00"),
        ContaBancaria(R.drawable.ic_launcher_foreground, "Banco C", "R$ 8.500,00"),
        ContaBancaria(R.drawable.ic_launcher_foreground, "Banco D", "R$ 8.500,00")
        // Adicione mais contas conforme necessário
    )
    val listaCartao = listOf(
        CartaoBancario(R.drawable.peixes, "Banco A", "R$ 5.000,00", "R$5.000,00"),
        CartaoBancario(R.drawable.img_primeira, "Banco B", "R$ 3.200,00", "R$5.000,00"),
        CartaoBancario(R.drawable.ic_launcher_foreground, "Banco C", "R$ 8.500,00", "R$5.000,00")
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
                            painter = painterResource(id = R.drawable.peixes),
                            contentDescription = null,
                            modifier = Modifier
                                .size(40.dp),
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
                            painter = painterResource(id = R.drawable.peixes),
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
                        .border(1.dp, Color.Black, shape = RoundedCornerShape(8.dp)) // Adiciona borda com raio de curvatura
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
                        Image(
                            painter = painterResource(id = R.drawable.peixes),
                            contentDescription = null,
                            modifier = Modifier
                                .size(40.dp)
                                .clip(CircleShape)
                                .zIndex(1f)
                        )

                        // Imagem 2
                        Image(
                            painter = painterResource(id = R.drawable.img_primeira),
                            contentDescription = null,
                            modifier = Modifier
                                .size(40.dp)
                                .padding(horizontal = 8.dp) // Adapte o espaçamento conforme necessário
                        )

                        // Imagem 3
                        Image(
                            painter = painterResource(id = R.drawable.ic_launcher_foreground),
                            contentDescription = null,
                            modifier = Modifier
                                .size(40.dp)
                        )
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
                    modifier = Modifier.fillMaxWidth()
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
            Container("Transações Recentes", 60) {
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
            Container("Previsão final do mes", 60) {
                    ColumnWithTwoRows()

            }
        }

        item { Spacer(modifier = Modifier.height(20.dp)) }
    }
}

@Composable
fun ColumnWithTwoRows() {
    // Dados de exemplo para as colunas
    val data = listOf(
        Pair("Categoria A", 100),
        Pair("Categoria B", 200),
        Pair("Categoria C", 150),
        Pair("Categoria D", 300)
    )

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        // Itera sobre os dados e cria uma linha para cada par de dados
        data.forEach { (label, value) ->
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp)
            ) {
                // Rótulo da categoria
                Text(
                    text = label,
                    modifier = Modifier
                        .weight(1f)
                        .padding(end = 8.dp)
                        .align(Alignment.CenterVertically)
                )

                // Barra representando o valor
                Box(
                    modifier = Modifier
                        .weight(3f)
                        .height(20.dp)
                        .background(Color.Gray)
                ) {
                    // Ajusta a largura da barra de acordo com o valor
                    Box(
                        modifier = Modifier
                            .fillMaxHeight()
                            .fillMaxWidth(value.toFloat() / data.maxOf { it.second }.toFloat())
                            .background(Color.Red)
                    )
                }
            }
        }
    }
}


data class ContaBancaria(
    @DrawableRes val imagemResId: Int,
    val nomeBanco: String,
    val saldo: String
)
data class CartaoBancario(
    @DrawableRes val imagemResId: Int,
    val nomeBanco: String,
    val fatura: String,
    val disponivel: String
)

@Composable
fun ContasTableRow(
    @DrawableRes imagemResId: Int,
    nomeBanco: String,
    saldo: String
) {
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
                    .weight(0.15f)
                    .size(40.dp)
                    .clip(CircleShape)
            )

            Spacer(modifier = Modifier.width(8.dp))

            // Parte 2: Nome do Banco
            Text(
                text = nomeBanco,
                style = MaterialTheme.typography.bodyMedium,
                modifier = Modifier.weight(0.55f)
            )

            Spacer(modifier = Modifier.width(8.dp))

            // Parte 3: Saldo
            Text(
                text = saldo,
                style = MaterialTheme.typography.bodyMedium,
                modifier = Modifier.weight(0.3f)
            )
    }
    Spacer(
        modifier = Modifier
            .fillMaxWidth()
            .height(1.dp)
            .background(color = Color.Gray)
    )
}

@Composable
fun CartoesTableRow(
    @DrawableRes imagemResId: Int,
    nomeBanco: String,
    fatura:String,
    disponivel: String
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        // Parte 1: Imagem
        Image(
            painter = painterResource(id = imagemResId),
            contentDescription = null,
            modifier = Modifier
                .weight(0.15f)
                .size(40.dp)
                .clip(CircleShape)
        )

        Spacer(modifier = Modifier.width(8.dp))

        // Parte 2: Nome do Banco
        Text(
            text = nomeBanco,
            style = MaterialTheme.typography.bodyMedium,
            modifier = Modifier.weight(0.25f)
        )

        Spacer(modifier = Modifier.width(8.dp))

        // Parte 3: fatura
        Text(
            text = fatura,
            style = MaterialTheme.typography.bodyMedium,
            modifier = Modifier.weight(0.3f)
        )
        Spacer(modifier = Modifier.width(8.dp))

        // Parte 3: disponivel
        Text(
            text = disponivel,
            style = MaterialTheme.typography.bodyMedium,
            modifier = Modifier.weight(0.3f)
        )
    }
    Spacer(
        modifier = Modifier
            .fillMaxWidth()
            .height(1.dp)
            .background(color = Color.Gray)
    )
}

@Composable
fun Container(title: String, distancia: Int, content: @Composable (() -> Unit)? = null) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top=distancia.dp, start = 8.dp, end = 8.dp)
    ) {
        Row() {
            Image(
                painter = painterResource(id = R.drawable.peixes), // Substitua pelo recurso de imagem adequado
                contentDescription = null,
                modifier = Modifier
                    .size(40.dp)
                    .padding(5.dp)
                    .clip(CircleShape)
            )

            Text(
                text = title,
                style = TextStyle(
                    fontWeight = FontWeight.Bold,
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
                    fontSize = 15.sp

                ),
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
                    .weight(0.7f)

            )
            Text(
                text = "saldo",
                style = MaterialTheme.typography.bodyLarge,
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
            .padding(top=distancia.dp, start = 8.dp, end = 8.dp)
    ) {
        Row() {
            Image(
                painter = painterResource(id = R.drawable.peixes), // Substitua pelo recurso de imagem adequado
                contentDescription = null,
                modifier = Modifier
                    .size(40.dp)
                    .padding(5.dp)
                    .clip(CircleShape)
            )

            Text(
                text = title,
                style = TextStyle(
                    fontWeight = FontWeight.Bold,
                    fontSize = 18.sp

                ),
                modifier = Modifier
                    .weight(0.4f)
                    .padding(8.dp)
                    .align(Alignment.Top)
            )
            Text(
                text = "Ver Todos >",
                style = MaterialTheme.typography.bodyLarge,
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
                style = MaterialTheme.typography.bodyLarge,
                modifier = Modifier
                    .weight(0.3f)
            )
            Text(
                text = "disponivel",
                style = MaterialTheme.typography.bodyLarge,
                modifier = Modifier
                    .weight(0.3f)
            )
        }
        content?.invoke()
    }
}


@Composable
fun ListItemContainer(itemText: String) {
    Container(itemText,1)
}

@Preview(showBackground = true)
@Composable
fun ThreeContainersWithListPreview() {
    ThreeContainersWithList()
}
