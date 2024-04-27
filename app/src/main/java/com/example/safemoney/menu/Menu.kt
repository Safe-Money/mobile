package com.example.safemoney.menu

import android.graphics.BitmapFactory
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.safemoney.FooterBar
import com.example.safemoney.R
import com.example.safemoney.ui.theme.Cinza

@Composable
fun Menu(navController: NavController) {
    Column(
        horizontalAlignment =
        Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize(),

        ) {
        Row(
            Modifier
                .fillMaxWidth()
                .padding(start = 20.dp, top = 30.dp)
        ) {

            Image(
                painter = painterResource(id = R.drawable.safemoney_2),
                contentDescription = "Logo SafeMoney",
                modifier = Modifier
                    .size(60.dp)
                    .padding(start = 15.dp)
            )

            Spacer(modifier = Modifier.width(20.dp))

            Text(
                text = "Evelyn Hugo",
                fontFamily = FontFamily(Font(R.font.montserrat_bold)),
                fontSize = 25.sp,
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.CenterVertically),
                color = Color(0xFF3A3A3A)
            )
        }

        Spacer(modifier = Modifier.height(20.dp))

        Options(navController)

        Spacer(modifier = Modifier.weight(1f))

        FooterBar( navController )


    }
}

data class MenuItem(val icone: Int, val label: String, var onClick: () -> Unit)

val menuOptions = listOf(
    MenuItem(icone = R.drawable.planejamento, label = "Planejamentos") {
        println("Planejamentos")
    },
    MenuItem(icone = R.drawable.objetivo, label = "Objetivos") {
        println("Objetivos")
    },
    MenuItem(icone = R.drawable.config, label = "Configurações") {
        println("Planejamentos")
    },
    MenuItem(icone = R.drawable.out, label = "Sair") {
        println("Sair")
    }
)
@Composable
fun Options(navController: NavController) {
    LazyColumn(
        contentPadding = PaddingValues(
            vertical = 40.dp,
        )
    ) {
        items(menuOptions) { menuOption ->
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 40.dp)
                    .clickable {
                        when (menuOption.label) {
                            "Planejamentos" -> navController.navigate("planejamento")
                            "Objetivos" -> navController.navigate("objetivo")
                            "Configurações" -> navController.navigate("configuracoes")
                            "Sair" -> navController.navigate("login")
                        }
                    },
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    painter = painterResource(menuOption.icone), contentDescription = "Icon",
                    modifier = Modifier.size(25.dp)
                )

                Spacer(modifier = Modifier.width(15.dp))

                Text(
                    text = menuOption.label, fontFamily = FontFamily(Font(R.font.montserrat)),
                    fontSize = 15.sp,
                    modifier = Modifier.width(250.dp),
                    textAlign = TextAlign.Left
                )

                Icon(
                    imageVector = Icons.Default.KeyboardArrowRight, contentDescription = "Icon",
                    modifier = Modifier.height(20.dp), tint = Cinza
                )
            }
            Spacer(modifier = Modifier.height(30.dp))
        }
    }
}

