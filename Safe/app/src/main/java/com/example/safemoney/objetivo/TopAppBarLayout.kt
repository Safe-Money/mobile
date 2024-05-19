package com.example.projetoaula07_03.home


import androidx.compose.ui.Alignment
import android.widget.Space
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
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
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.safemoney.R
import com.example.safemoney.ui.theme.Branco




@Composable
fun TopBar(
    modifier: Modifier = Modifier,
    navController : NavController,
) {

    Column {
        Row(
            modifier = modifier
                .fillMaxWidth()
                .background(
                    Branco
                )
                .padding(8.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Objetivos",
                fontFamily = FontFamily(Font(R.font.montserrat)),
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
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


                Spacer(
                    modifier = modifier.width(8.dp)
                )

                IconButton(
                    onClick = { navController.navigate("addObjetivos") },
                    modifier = Modifier.size(24.dp)
                ) {
                    Icon(
                        imageVector = Icons.Default.AddCircle,
                        contentDescription = null
                    )
                }
            }
        }

        Divider(
            modifier = Modifier.fillMaxWidth(),
            color = Color(0xFFCDCDCD),
            thickness = 0.5.dp
        )
    }



}