package com.example.tela_objetivos

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.projetoaula07_03.home.Content
import com.example.projetoaula07_03.home.TopBar
import com.example.safemoney.ui.theme.SafeMoneyTheme

@Composable
fun HomeScreen() {
    Column {
        TopBar()
        Content()

    }
}
@Preview(
    showBackground = true
)




@Composable
fun HomeScreenPreview() {
    SafeMoneyTheme {

Surface(
modifier = Modifier.fillMaxSize(),
color = MaterialTheme.colorScheme.background
) {
    HomeScreen()
}
}
}
