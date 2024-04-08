package com.example.safemoney.telas_acao.buttons

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.example.safemoney.ui.theme.Branco

@Preview
@Composable
fun SwitchButtonPreview() {
    SwitchButton()
}

@Composable
fun SwitchButton(
    modifier : Modifier = Modifier
) {
    var checked by remember { mutableStateOf(false) }

    Row (
        modifier = modifier
            .fillMaxWidth()
            .background(Branco)
    ){
        Switch(
            checked = checked,
            onCheckedChange = {
                checked = it
            },
            colors = SwitchDefaults.colors(
                checkedThumbColor = Color(0xFF3ABA6F),
                checkedTrackColor = Color(0xFFE6E6E6),
                uncheckedThumbColor = Color(0xFF568C6D),
                uncheckedTrackColor = Color(0xFFE6E6E6),
            )
        )
    }
}