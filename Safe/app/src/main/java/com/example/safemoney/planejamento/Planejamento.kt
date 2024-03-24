package com.example.safemoney.planejamento

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.safemoney.FooterBar
import com.example.safemoney.R
import com.example.safemoney.componentes.BotaoMes
import com.example.safemoney.splash.SplashScreen
import com.example.safemoney.ui.theme.Cinza
import com.example.safemoney.ui.theme.SafeMoneyTheme
import com.example.safemoney.ui.theme.Verde

@Composable
fun Planejamento(navController: NavController) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize(),
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp)
                .shadow(elevation = 1.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = "Planejamento",
                fontFamily = FontFamily(Font(R.font.montserrat)),
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(10.dp)
            )

            Icon(
                imageVector = Icons.Default.AddCircle,
                contentDescription = "Add",
                modifier = Modifier.padding(13.dp)
            )
        }


        Spacer(modifier = Modifier.height(20.dp))

        Box(
            modifier = Modifier.fillMaxWidth()
        ) {
            Row(
                modifier = Modifier
                    .align(Alignment.Center)
                    .padding(horizontal = 16.dp),
                horizontalArrangement = Arrangement.spacedBy(40.dp),
                verticalAlignment = Alignment.CenterVertically
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


        }

        Spacer(modifier = Modifier.height(15.dp))

        Row (
            modifier = Modifier
                .fillMaxWidth(0.97f)
                .padding(10.dp)
        ){
            Text(text = "Categoria",
                modifier = Modifier.padding( start = 15.dp),
                fontSize = 7.sp,
                fontFamily = FontFamily(Font(R.font.montserrat_semibold)),
                color = Cinza
            )

            Spacer(modifier = Modifier.width(15.dp))

            Text(text = "Gasto",
                fontSize = 7.sp,
                fontFamily = FontFamily(Font(R.font.montserrat_semibold)),
                color = Cinza
            )

            Spacer(Modifier.width(160.dp))

            Text(text = "Planejado",
                fontSize = 7.sp,
                fontFamily = FontFamily(Font(R.font.montserrat_semibold)),
                textAlign = TextAlign.Right,
                color = Cinza
            )

        }

        Spacer(Modifier.height(15.dp))

        LazyColumn(
            contentPadding = PaddingValues(vertical = 10.dp),
            modifier = Modifier.fillMaxWidth(0.8f),
        ) {
            items(planejamentos) { planejamento ->
                Row(
                    modifier = Modifier.fillParentMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(4.dp)
                ) {
                    PlanItem(i = planejamento)

                }
            }
        }

        Spacer(modifier = Modifier.weight(1f))

        FooterBar(navController)

    }


}

val planejamentos = listOf(
    Item(R.drawable.saude, 10.0, 100.0),
    Item(R.drawable.saude, 45.0, 300.0),
    Item(R.drawable.saude, 250.0, 2000.0)
)

@Preview(showBackground = true)
@Composable
fun LoginScreenPreview1() {
    val navController = rememberNavController()
    SafeMoneyTheme {
        Planejamento(navController = navController)
    }
}
