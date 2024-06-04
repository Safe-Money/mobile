package com.example.safemoney.painel

import ContaViewModel
import UserConta
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
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
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.currentCompositionLocalContext
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.a4adsb_29_02.BarGraph
import com.example.safemoney.FooterBar
import com.example.safemoney.R
import com.example.safemoney.model.Cartao
import com.example.safemoney.model.CartaoGet
import com.example.safemoney.model.Transacao
import com.example.safemoney.ui.theme.VerdeEscuro
import com.example.safemoney.viewmodel.CartaoViewModel
import com.example.safemoney.viewmodel.TransacaoViewModel
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.Locale

@Composable
fun ThreeContainersWithList(navController: NavController, contaViewModel: ContaViewModel,  cartaoViewModel: CartaoViewModel, transacaoViewModel: TransacaoViewModel) {

    val (listaContas, setListaContas) = remember { mutableStateOf(emptyList<UserConta>()) }
    val (listaCartao, setListaCartao) = remember { mutableStateOf(emptyList<CartaoGet>()) }
    val (listaTransacoes, setListaTransacoes) = remember { mutableStateOf(emptyList<Transacao>()) }

    var balanco = 0.0
    var receita = 0.0
    var despesa = 0.0
    var balancoPrevisao = 0.0

    listaContas.forEach {
        balanco += it.saldo
    }

    listaTransacoes.forEach {
        if(it.tipo.id == 1 || it.tipo.id == 2 || it.tipo.id == 3){
            despesa += it.valor
        }else if(it.tipo.id == 4 || it.tipo.id == 5){
            receita += it.valor
        }

        balancoPrevisao = receita - despesa
    }




    val bancoImageMap = mapOf(
        "bradesco" to R.drawable.bradesco,
        "Itau" to R.drawable.itau,
        "Santander" to R.drawable.santander

    )

    val bandeiraImageMap = mapOf(
        "visa" to R.mipmap.visa,
        "mastercard" to R.mipmap.mastercard,
        "elo" to R.mipmap.elo
    )

    fun getBandeiraImageResId(nomeBandeira: String): Int {
        return bandeiraImageMap[nomeBandeira.toLowerCase()] ?: R.drawable.safemoney2
    }



    contaViewModel.contasLiveData.observeAsState().value?.let { listaContas ->
        setListaContas(listaContas)
    }

    cartaoViewModel.cartaoLiveData.observeAsState().value?.let { listaCartao ->
        setListaCartao(listaCartao)
    }

    transacaoViewModel.transacoes.observeAsState().value?.let{ listaTransacoes ->
        setListaTransacoes(listaTransacoes)
    }


    Log.d("ThreeContainersWithList", "Composable chamado")

    fun getBancoImageResId(nomeBanco: String): Int {
        return bancoImageMap[nomeBanco] ?: R.drawable.safemoney2
    }



    val barColor1 = Color.Red
    val barColor2 = Color.Green

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
                        .height(200.dp),
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
                            painter = painterResource(id = R.drawable.safemoney_branco),
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
                                fontSize = 17.sp,
                                fontFamily = FontFamily(Font(R.font.montserrat)),
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
                            fontFamily = FontFamily(Font(R.font.montserrat)),
                            modifier = Modifier
                                .padding(8.dp),
                            color = Color.White
                        )
                        Text(
                            text = String.format("R$ %.2f", balanco),
                            style = TextStyle(
                                fontSize = 24.sp,
                                fontWeight = FontWeight.Bold,
                                fontFamily = FontFamily(Font(R.font.montserrat)),
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
                                    .clickable {
                                        navController.navigate("addReceita")
                                    }
                            )
                            Text(
                                text = "Receita",
                                style = TextStyle(
                                    fontSize = 12.sp,
                                    fontFamily = FontFamily(Font(R.font.montserrat)),
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
                                    .padding(horizontal = 3.dp)
                                    .clickable {
                                        navController.navigate("addDespesa")
                                    }
                            )

                            Text(
                                text = "Despesa",
                                style = TextStyle(
                                    fontSize = 12.sp,
                                    fontFamily = FontFamily(Font(R.font.montserrat)),
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
                                    fontFamily = FontFamily(Font(R.font.montserrat)),
                                ),
                                modifier = Modifier,
                                color = Color.Black
                            )
                        }
                    }
                    Box(
                        modifier = Modifier
                            .matchParentSize() // Preenche todo o espaço disponível
                            .border(1.dp, Color(0x55000000), shape = RoundedCornerShape(8.dp)) // Cor semi-transparente da borda
                    )
                }
            }
        }

        // Adicionando um espaçador para ocupar espaço na parte superior
        item { Spacer(modifier = Modifier.height(20.dp)) }




        // Adicionando conteúdo da parte branca
        item {



            Container("Contas",navController, 10) {
                LazyColumn(
                    modifier = Modifier
                        .height(175.dp)
                        .fillMaxWidth()

                )


                {
                    items(listaContas) { conta ->
                        ContasTableRow(
                            imagemResId = getBancoImageResId(conta.banco),
                            nomeBanco = conta.nome,
                            saldo = conta.saldo
                        )
                    }
                }
            }
        }

        item {
            Container2("Cartões", navController,60) {
                LazyColumn(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(175.dp)
                    ,
                    contentPadding = PaddingValues(horizontal = 8.dp, vertical = 4.dp)
                ) {
                    items(listaCartao) { cartao ->
                        val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd", Locale.getDefault())
                        val dataVencimento = LocalDate.parse(cartao.vencimento, formatter)
                        val vencimentoFormatado = dataVencimento.format(DateTimeFormatter.ofPattern("dd/MM", Locale.getDefault()))
                            CartoesTableRow(
                                imagemResId = getBandeiraImageResId(cartao.bandeira.toLowerCase()),
                                nomeBanco = cartao.nome,
                                fatura = cartao.limite,
                                disponivel = cartao.limite,
                                vencimento = vencimentoFormatado

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
                    items(listaTransacoes.take(5)) { conta ->
                        val image = when(conta.categoria.nome){
                            "saúde" -> R.drawable.saude
                            "alimentacao" -> R.drawable.alimentacao
                            "lazer" -> R.drawable.game
                            "gym" -> R.drawable.icon___academia
                            "pet" -> R.drawable.pet
                            "vestuario" -> R.drawable.icon___shopping
                            "economia" -> R.drawable.economia
                            "transporte" -> R.drawable.onibus_escolar
                            else -> R.drawable.safemoney2
                        }
                        TransacaoTableRow(
                            imagemResId = image,
                            nomeTransacao = conta.nome,
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
                            graphBarData = listOf(0.8f, 0.5f),
                            xAxisScaleData = listOf(1, 2),
                            barData_ = listOf(0, 1500, 3000, 4500, 6000),
                            height = 150.dp,
                            roundType = BarType.TOP_CURVED,
                            barWidth = 30.dp,
                            barColor1 = barColor2,
                            barColor2 = barColor1,
                            barArrangement = Arrangement.SpaceEvenly
                        )
                    }
                    Column(

                        modifier = Modifier
                            .padding(start = 16.dp, bottom = 24.dp)
                            .fillMaxHeight()
                            .height(140.dp),
                        verticalArrangement = Arrangement.SpaceBetween

                    ) {
                        Row(
                            modifier = Modifier
                                .border(1.dp, Color.Black, CircleShape)
                                .padding(6.dp),
                            verticalAlignment = Alignment.CenterVertically

                        ) {
                            Text(
                                text = "Receita: ",
                                style = TextStyle(
                                    fontSize = 12.sp,
                                ),
                                fontFamily = FontFamily(Font(R.font.montserrat)),
                                color = Color(0xFF030303),
                            )

                            Text(
                                text = String.format("R$ %.2f", receita),
                                style = TextStyle(
                                    fontSize = 12.sp,
                                ),
                                fontFamily = FontFamily(Font(R.font.montserrat)),
                                color = Color(0xFF09B451),
                                modifier = Modifier
                            )
                        }
                        Row(
                            modifier = Modifier
                                .border(1.dp, Color.Black, CircleShape)
                                .padding(6.dp),
                            verticalAlignment = Alignment.CenterVertically

                        ) {
                            Text(
                                text = "Despesa: ",
                                style = TextStyle(
                                    fontSize = 12.sp,
                                ),
                                fontFamily = FontFamily(Font(R.font.montserrat)),
                                color = Color(0xFF030303),
                            )

                            Text(
                                text = String.format("R$ %.2f", despesa),
                                style = TextStyle(
                                    fontSize = 12.sp,
                                ),
                                fontFamily = FontFamily(Font(R.font.montserrat)),
                                color = Color(0xFFEE0E0E),
                                modifier = Modifier
                            )
                        }
                        Row(
                            modifier = Modifier
                                .border(1.dp, Color.Black, CircleShape)
                                .padding(6.dp),
                            verticalAlignment = Alignment.CenterVertically

                        ) {
                            Text(
                                text = "Balanço: ",
                                style = TextStyle(
                                    fontSize = 12.sp,
                                ),
                                fontFamily = FontFamily(Font(R.font.montserrat)),
                                color = Color(0xFF030303),
                            )

                            Text(
                                text = String.format("R$ %.2f", balancoPrevisao),
                                style = TextStyle(
                                    fontSize = 12.sp,
                                ),
                                fontFamily = FontFamily(Font(R.font.montserrat)),
                                color = Color(0xFF150863),
                                modifier = Modifier
                            )
                        }
                    }
                }
            }
        }
        item { Spacer(modifier = Modifier.height(100.dp)) }
    }
}





@Composable
fun ContasTableRow(
    @DrawableRes imagemResId: Int,
    nomeBanco: String,
    saldo: Double
) {
    val textColor = if (saldo > 0) VerdeEscuro else Color.Red

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically

    ) {
        // Parte 1: Imagem
        Box(
            modifier = Modifier
                .size(25.dp)
                .clip(CircleShape)
        ) {
            Image(
                painter = painterResource(id = imagemResId),
                contentDescription = null,
                modifier = Modifier.fillMaxSize()
            )
        }

        Spacer(modifier = Modifier.width(8.dp))

        // Parte 2: Nome do Banco
        Column(
            modifier = Modifier.weight(0.55f)
        ) {
            Text(
                text = nomeBanco,
                style = MaterialTheme.typography.bodyMedium,
                fontFamily = FontFamily(Font(R.font.montserrat)),
                color = Color(0XFF030303)
            )




        }

        Spacer(modifier = Modifier.width(8.dp))

        // Parte 3: Saldo
        Text(
            text = String.format("R$ %.2f", saldo),
            style = MaterialTheme.typography.bodyMedium,
            fontFamily = FontFamily(Font(R.font.montserrat)),
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
    fatura:  Int,
    disponivel: Int,
    vencimento: String


) {
    println("imageResId: $imagemResId")

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 8.dp, bottom = 8.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        // Parte 1: Imagem
        Box(
            modifier = Modifier
                .size(25.dp)
                .clip(CircleShape)
        ) {
            Image(
                painter = painterResource(id = imagemResId),
                contentDescription = null,
                modifier = Modifier.fillMaxSize()
            )
        }

        Spacer(modifier = Modifier.width(8.dp))

        // Parte 2: Nome do Banco

        Column(
            modifier = Modifier.weight(0.28f)
        ) {
            Text(
                text = nomeBanco,
                style = MaterialTheme.typography.bodyMedium,
                fontFamily = FontFamily(Font(R.font.montserrat)),
                color = Color(0XFF030303)
            )

            Text(
                text = "Vencimento: ${vencimento}",
                style = TextStyle(
                    fontSize = 8.sp,
                    fontFamily = FontFamily(Font(R.font.montserrat)),
                ),
                color = Color(0XFF565656)
            )
        }

        Spacer(modifier = Modifier.width(8.dp))

        // Parte 3: fatura

        Text(
            text = "R$ $fatura",
            color = Color(0XFFA7A7A7),
            style = TextStyle(
                fontSize = 12.sp,
                fontFamily = FontFamily(Font(R.font.montserrat)),
            ),
            textAlign = TextAlign.Center,
            modifier = Modifier
                .weight(0.3f)
        )

        Spacer(modifier = Modifier.width(8.dp))

        // Parte 3: disponivel
        Text(
            text = "R$ $disponivel",
            style = MaterialTheme.typography.bodyMedium,
            fontFamily = FontFamily(Font(R.font.montserrat)),
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
                fontFamily = FontFamily(Font(R.font.montserrat)),
                color = Color(0XFF030303)
            )
            Text(
                text = "Débito",
                style = TextStyle(
                    fontSize = 8.sp,
                    fontFamily = FontFamily(Font(R.font.montserrat)),
                ),
                color = Color(0XFF565656)
            )
        }

        Spacer(modifier = Modifier.width(8.dp))

        val dataFormatada = LocalDate.parse(data)
        val formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy")
        val dataBR = formatter.format(dataFormatada)

        Text(
            text = "${dataBR}",
            style = MaterialTheme.typography.bodyMedium,
            fontFamily = FontFamily(Font(R.font.montserrat)),
            color = Color(0xFF3A3A3A),
            textAlign = TextAlign.Center,
            modifier = Modifier.weight(0.3f)
        )
        Spacer(modifier = Modifier.width(8.dp))

        val valorDouble = valor.toDouble()
        Text(
            text = String.format("R$ %.2f", valorDouble),
            style = MaterialTheme.typography.bodyMedium,
            fontFamily = FontFamily(Font(R.font.montserrat)),
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
fun Container( title: String, navController: NavController, distancia: Int, content: @Composable (() -> Unit)? = null) {



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
                    fontFamily = FontFamily(Font(R.font.montserrat)),
                    fontSize = 18.sp

                ),
                modifier = Modifier
                    .weight(0.4f)
                    .padding(8.dp)
                    .align(Alignment.Top)

            )
            Text(
                text = "Nova Conta >",
                style = TextStyle(
                    fontWeight = FontWeight.Normal,
                    fontFamily = FontFamily(Font(R.font.montserrat)),
                    fontSize = 12.sp
                ),
                textAlign = TextAlign.End,
                modifier = Modifier
                    .weight(0.2f)
                    .padding(8.dp)
                    .align(Alignment.Top)
                    .clickable {
                        navController.navigate("addConta")
                    },
            )

        }
        Row(
            modifier = Modifier
                .padding(start=8.dp)
        ){
            Text(
                text = "",
                style = MaterialTheme.typography.bodyLarge,
                fontFamily = FontFamily(Font(R.font.montserrat)),
                modifier = Modifier
                    .weight(0.7f)

            )

            Text(
                text = "saldo",
                color = Color(0XFFA7A7A7),
                style = TextStyle(
                    fontSize = 12.sp,
                    fontFamily = FontFamily(Font(R.font.montserrat)),
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
fun Container2(title: String, navController: NavController, distancia: Int, content: @Composable (() -> Unit)? = null) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = distancia.dp, start = 16.dp, end = 16.dp)
    ) {
        Row() {
            Image(
                painter = painterResource(id = R.drawable.container_logo),
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
                    fontSize = 18.sp,
                    fontFamily = FontFamily(Font(R.font.montserrat)),
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
                    fontFamily = FontFamily(Font(R.font.montserrat)),
                    fontSize = 12.sp
                ),
                textAlign = TextAlign.End,
                modifier = Modifier
                    .weight(0.2f)
                    .padding(8.dp)
                    .align(Alignment.Top)
                    .clickable {
                        navController.navigate("telaCartao")
                    },
            )
        }
        Row(
            modifier = Modifier
                .padding(start=8.dp)
        ){
            Text(
                text = "",
                style = MaterialTheme.typography.bodyLarge,
                fontFamily = FontFamily(Font(R.font.montserrat)),
                modifier = Modifier
                    .weight(0.4f)

            )
            Text(
                text = "saldo",
                color = Color(0XFFA7A7A7),
                style = TextStyle(
                    fontSize = 12.sp,
                    fontFamily = FontFamily(Font(R.font.montserrat)),
                ),
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .weight(0.3f)
            )
            Text(
                text = "disponivel",
                color = Color(0XFFA7A7A7),
                style = TextStyle(
                    fontSize = 12.sp,
                    fontFamily = FontFamily(Font(R.font.montserrat)),
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
                painter = painterResource(id = R.drawable.container_logo),
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
                    fontFamily = FontFamily(Font(R.font.montserrat)),
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
                    fontFamily = FontFamily(Font(R.font.montserrat)),
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
                fontFamily = FontFamily(Font(R.font.montserrat)),
                modifier = Modifier
                    .weight(0.4f)

            )
            Text(
                text = "data",
                color = Color(0XFFA7A7A7),
                style = TextStyle(
                    fontSize = 12.sp,
                    fontFamily = FontFamily(Font(R.font.montserrat)),
                ),
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .weight(0.3f)
            )
            Text(
                text = "valor",
                color = Color(0XFFA7A7A7),
                style = TextStyle(
                    fontSize = 12.sp,
                    fontFamily = FontFamily(Font(R.font.montserrat)),
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
                    fontSize = 18.sp,
                    fontFamily = FontFamily(Font(R.font.montserrat)),
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



