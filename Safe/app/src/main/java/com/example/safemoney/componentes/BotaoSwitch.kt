package com.example.safemoney.componentes

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.safemoney.ui.theme.Cinza
import com.example.safemoney.ui.theme.CinzaClaro
import com.example.safemoney.ui.theme.CinzaGab
import com.example.safemoney.ui.theme.VerdeClaro

@Composable
fun BotoesSwitch() {
    val states = listOf(
        "Variáveis",
        "  Fixo   ",


        )
    var selectedOption by remember {
        mutableStateOf(states[0])
    }
    val onSelectionChange = { text: String ->
        selectedOption = text
    }

    Surface(
        shape = RoundedCornerShape(24.dp),

        modifier = Modifier
            .wrapContentSize()

    ) {
        Row(
            modifier = Modifier

                .background(CinzaGab)
        ) {
            states.forEach { text->
                Text(
                    text = text,
                    fontSize = 8.sp,
                    color = Color.Black,
                    modifier = Modifier
                        .clip(shape = RoundedCornerShape(24.dp))
                        .clickable {
                            onSelectionChange(text)
                        }
                        .background(
                            if (text == selectedOption) {
                                VerdeClaro
                            } else {
                                CinzaGab
                            }
                        )
                        .padding(

                            horizontal = 35.dp,
                        ),
                )
            }
        }
    }
}