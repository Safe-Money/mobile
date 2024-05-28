package com.example.safemoney.componentes

import LancamentosGet
import android.os.Bundle
import android.util.Log
import com.example.safemoney.R
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

import com.example.safemoney.ui.theme.Cinza
import com.example.safemoney.ui.theme.CinzaClaro
import com.example.safemoney.ui.theme.CinzaGab
import com.example.safemoney.ui.theme.SafeMoneyTheme





@Composable
fun Lista(lancamentos: List<LancamentosGet>) {
    Log.d("Lista", "Total de lançamentos: ${lancamentos.size}")
    Column(
        modifier = Modifier.padding(horizontal = 10.dp)
    ) {
        lancamentos.forEach { lancamento ->
            LancamentoItem(lancamento = lancamento)
            Divider(
                color = Color(0xFFCDCDCD),
                thickness = 0.5.dp,
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
}


fun getIconResourceId(local: String): Int {
    return when (local) {
        "saude" -> R.drawable.icon___saude
        "academia" -> R.drawable.icon___academia
        "lazer" -> R.drawable.icon___shopping
        else -> R.drawable.logo
    }
}

@Composable
fun LancamentoItem(lancamento: LancamentosGet) {
    Surface(
        shape = RoundedCornerShape(8.dp),
        color = Color.Transparent,
    ) {
        Row(
            modifier = Modifier
                .padding(8.dp)
                .clickable { },
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier
                    .size(30.dp)
                    .clip(CircleShape)

            ) {
                Image(
                    painter = painterResource(id = getIconResourceId(lancamento.fkCategoria?.nome ?: "")),
                    contentDescription = null,
                    modifier = Modifier
                        .size(30.dp)
                        .clip(CircleShape)
                )


            }

            Column(
                modifier = Modifier
                    .padding(start = 15.dp)
                    .weight(0.1f)
            ) {
                Text(
                    text = lancamento.nome,
                    fontFamily = FontFamily(Font(R.font.montserrat)),
                    fontSize = 11.sp,
                    fontWeight = FontWeight(100),
                    color = CinzaClaro

                )
                Text(
                    text = lancamento.data,
                    fontFamily = FontFamily(Font(R.font.montserrat)),
                    fontSize = 8.sp,
                    color = Color.Gray
                )
            }

            Column(
                modifier = Modifier
                    .padding(start = 15.dp)
                    .weight(0.1f)

            ) {
                Text(
                    text = lancamento.fkConta?.nome ?: "",
                    fontFamily = FontFamily(Font(R.font.montserrat)),
                    fontSize = 10.sp,
                    textAlign = TextAlign.Center,
                    color = CinzaClaro
                )
            }
            Spacer(modifier = Modifier.height(3.dp))

            Row(
                modifier = Modifier.align(Alignment.CenterVertically)
            ) {
                Text(
                    text = "R$ ${lancamento.valor}",
                    fontFamily = FontFamily(Font(R.font.montserrat)),
                    fontSize = 12.sp,
                    textAlign = TextAlign.Center,
                    color = Color.Black
                )
            }
        }
    }
}