package com.example.safemoney

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
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
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.safemoney.ui.theme.Cinza
@Composable
fun FooterBar(navController: NavController) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .fillMaxWidth()
            .height(90.dp)
            .background(color = Color.White)
            .shadow(
                elevation = 2.dp,
                clip = false
            )
    ) {
        LazyRow(
            horizontalArrangement =
            Arrangement.spacedBy(40.dp),
        ) {
            items(pageOptions) { option ->
                ColunaOption(p = option, navController = navController)
            }
        }
    }
}

class Page(val icone: Int, val label: String, val route: String)

val pageOptions = listOf(
    Page(icone = R.drawable.home, label = "Início", route = "painel"),
    Page(icone = R.drawable.lancamento, label = "Lançamentos", route = "lancamentos"),
    Page(icone = R.drawable.cartao, label = "Cartões", route = "splash"),
    Page(icone = R.drawable.mais, label = "Mais", route = "menu")
)

@Composable
fun ColunaOption(p: Page, navController: NavController) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            modifier = Modifier
                .size(20.dp)
                .clickable { navController.navigate(p.route) }
        ) {
            Icon(
                painterResource(id = p.icone),
                contentDescription = "Icon",
                tint = Cinza,
                modifier = Modifier.fillMaxSize()
            )
        }
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = p.label,
            color = Cinza,
            fontFamily = FontFamily(Font(R.font.montserrat_medium)),
            modifier = Modifier.clickable { navController.navigate(p.route) }
        )
    }
}
