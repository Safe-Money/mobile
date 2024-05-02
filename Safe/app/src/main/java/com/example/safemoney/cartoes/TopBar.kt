package com.example.safemoney.cartoes

import androidx.compose.ui.Alignment
import android.widget.Space
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

import com.example.safemoney.ui.theme.Branco
import com.example.safemoney.ui.theme.Verde
import com.example.safemoney.ui.theme.Vermelho


@Preview
@Composable
fun TopBarPreview() {
    val navController = rememberNavController()
    TopBar(navController = navController)
}

@Composable
fun TopBar(
    modifier: Modifier = Modifier,
    navController: NavController
) {

    Column {
        Row(
            modifier = modifier
                .fillMaxWidth()
                .background(
                    Branco
                )
                .padding(16.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Cartões",
                fontWeight = FontWeight.Medium,
                fontSize = 16.sp
            )

            Row() {

                /*
                    Image(
                        painter = painterResource(id = R.drawable.icon_deletar),
                        contentDescription = null,
                        modifier = modifier
                            .size(20.dp)
                            .clip(RoundedCornerShape(2.dp))
                            .background(Vermelho)
                            .padding(3.dp)
                    )

                Image(painter = painterResource(id = R.drawable.icon_editar),
                    contentDescription = null,
                    modifier = modifier.size(20.dp)
                )

                 */

                Icon(imageVector = Icons.Default.Delete, contentDescription = null, tint = Vermelho)

                Spacer(
                    modifier = modifier.width(8.dp)
                )

                Icon(imageVector = Icons.Default.Edit, contentDescription = null)
                Spacer(
                    modifier = modifier.width(8.dp)
                )
                IconButton(
                    onClick = { navController.navigate("painel") },
                    modifier = Modifier.size(24.dp)
                ) {
                    Icon(
                        imageVector = Icons.Default.AddCircle,
                        contentDescription = null
                    )
                }

                Button(
                    onClick = { navController.navigate("addCartao") },
                    modifier = Modifier.padding(16.dp)
                ) {
                    Icon(
                        imageVector = Icons.Default.Add,
                        contentDescription = "Add Csjsjartão"
                    )
                }
            }
        }

        Divider(
            modifier = Modifier.fillMaxWidth(),
            color = Color(0xFFCDCDCD),
            thickness = 0.6.dp
        )
    }



}