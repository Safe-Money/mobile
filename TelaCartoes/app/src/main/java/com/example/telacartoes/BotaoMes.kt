package com.example.telacartoes

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.telacartoes.ui.theme.Branco
import com.example.telacartoes.ui.theme.CinzaDivisor
import com.example.telacartoes.ui.theme.VerdeClaro
import com.example.telacartoes.ui.theme.VerdeEscuro
import com.example.telacartoes.ui.theme.Vermelho

@Preview(
    showBackground = true,
)
@Composable
fun BotaoMesPreview() {
    BotaoMes()
}

@Composable
fun BotaoMes(
    modifier: Modifier = Modifier
) {
    Column (
        modifier = modifier
            .fillMaxWidth()
            .height(80.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween,
    ) {
        Divider(
            modifier = Modifier
                .fillMaxWidth(),
            color = CinzaDivisor,
            thickness = 0.6.dp
        )

        Row (
            modifier = modifier
                .width(290.dp)
                .height(40.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ){
            Icon(
                imageVector = Icons.Default.KeyboardArrowLeft,
                contentDescription = null,
                tint = VerdeEscuro,
            )


            Text(
                text = "Atual",
                modifier = modifier
                    .background(
                        color = VerdeEscuro,
                        shape = RoundedCornerShape(48)
                    )
                    .width(160.dp)
                    .height(30.dp)
                    .wrapContentSize(Alignment.Center),
                color = Branco,
                fontSize = 15.sp
            )


            Icon(
                imageVector = Icons.Default.KeyboardArrowRight,
                contentDescription = null,
                tint = VerdeEscuro,
            )
        }

        Divider(
            modifier = Modifier
                .fillMaxWidth(),
            color = CinzaDivisor,
            thickness = 0.6.dp
        )
    }
}