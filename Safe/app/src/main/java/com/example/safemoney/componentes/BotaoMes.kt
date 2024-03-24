package com.example.safemoney.componentes

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.safemoney.R
import com.example.safemoney.ui.theme.Verde



@Composable
fun BotaoMes(
    mesAtual: String,
    onClickPrevious: () -> Unit,
    onClickNext: () -> Unit
) {
    Box(
        modifier = Modifier.fillMaxWidth()
    ) {
        Row(
            modifier = Modifier
                .align(Alignment.Center)
                .padding(horizontal = 16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            IconeSeta(
                imageVector = Icons.Default.KeyboardArrowLeft,
                contentDescription = "Icon esquerda",
                onClick = onClickPrevious
            )

            Spacer(modifier = Modifier.width(28.dp))

            Button(
                onClick = {
                    print("")
                },
                colors = ButtonDefaults.buttonColors(Verde),
                modifier = Modifier
                    .width(130.dp)
                    .height(30.dp),
                contentPadding = PaddingValues(horizontal = 10.dp, vertical = 0.dp),
            ) {
                Text(
                    text = mesAtual,
                    color = Color.White,
                    fontFamily = FontFamily(Font(R.font.montserrat)),
                    fontSize = 15.sp,

                    )

            }

            Spacer(modifier = Modifier.width(28.dp))

            IconeSeta(
                imageVector = Icons.Default.KeyboardArrowRight,
                contentDescription = "Icon direita",
                onClick = onClickNext
            )
        }
    }
}

@Composable
fun IconeSeta(
    imageVector: ImageVector,
    contentDescription: String,
    onClick: () -> Unit
) {
    Icon(
        imageVector = imageVector,
        contentDescription = contentDescription,
        modifier = Modifier
            .size(40.dp)
            .clickable { onClick() },
        tint = Verde
    )
}