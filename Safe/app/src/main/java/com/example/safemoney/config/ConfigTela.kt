package com.example.safemoney.config

import android.os.Bundle
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.outlined.Delete
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import com.example.safemoney.R
import com.example.safemoney.ui.theme.SafeMoneyTheme



@Composable
fun ConfigScreen(navController: NavController) {
    var name by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var confirmPassword by remember { mutableStateOf("") }

    val textFieldModifier = Modifier
        .fillMaxWidth(0.8f)
        .height(60.dp)

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 0.dp),

        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Spacer(modifier = Modifier.height(-28.dp))

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Configurações",
                fontSize = 18.sp,
                fontFamily = FontFamily(Font(R.font.montserrat)),
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(start = 16.dp)
            )
            Button(
                onClick = {},
                contentPadding = PaddingValues(horizontal = 7.dp, vertical = 0.dp),
                modifier = Modifier.padding(
                    end = 16.dp,

                    ),

                colors = ButtonDefaults.textButtonColors(
                    contentColor = Color.White,
                    containerColor = Color(0xFFFF4545)
                ),
                shape = RoundedCornerShape(5.dp)
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(
                        imageVector = Icons.Outlined.Delete,
                        contentDescription = "Delete",
                        tint = Color.White,
                        modifier = Modifier.size(20.dp)
                            .padding(start = 1.dp)
                    )

                    Text(
                        text = "Excluir conta",
                        color = Color.White,
                        fontSize = 10.sp,
                        fontFamily = FontFamily(Font(R.font.montserrat)),
                        modifier = Modifier.padding(start = 1.dp)
                    )
                }
            }
        }

        Divider(
            color = Color(0xFFCDCDCD),
            thickness = 1.dp,
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(80.dp))
        Image(
            painter = painterResource(id = R.drawable.safemoney2),
            contentDescription = null,
            modifier = Modifier
                .size(100.dp)
                .padding(bottom = 20.dp)
        )
        Spacer(modifier = Modifier.height(20.dp))


        OutlinedTextField(
            modifier = textFieldModifier,
            value = name,
            onValueChange = { name = it },
            shape = RoundedCornerShape(7.dp),
            colors = TextFieldDefaults.colors(
                focusedContainerColor = Color.Transparent,
                unfocusedContainerColor = Color.Transparent,
                unfocusedIndicatorColor = Color(0XFF08632D),
                focusedIndicatorColor = Color(0XFF08632D),
                focusedLabelColor = Color(0XFF08632D),
            ),
            label = {
                Text(
                    "Nome",
                    fontFamily = FontFamily(Font(R.font.montserrat)),
                    fontSize = 12.sp
                )
            }
        )

        Spacer(modifier = Modifier.height(15.dp))

        OutlinedTextField(
            modifier = textFieldModifier,
            value = email,
            onValueChange = { email = it },
            shape = RoundedCornerShape(7.dp),
            colors = TextFieldDefaults.colors(
                focusedContainerColor = Color.Transparent,
                unfocusedContainerColor = Color.Transparent,
                unfocusedIndicatorColor = Color(0XFF08632D),
                focusedIndicatorColor = Color(0XFF08632D),
                focusedLabelColor = Color(0XFF08632D),
            ),
            label = {
                Text(
                    "E-mail",
                    fontFamily = FontFamily(Font(R.font.montserrat)),
                    fontSize = 12.sp
                )
            }
        )

        Spacer(modifier = Modifier.height(15.dp))

        OutlinedTextField(
            modifier = textFieldModifier,
            value = password,
            onValueChange = { password = it },
            shape = RoundedCornerShape(7.dp),
            colors = TextFieldDefaults.colors(
                focusedContainerColor = Color.Transparent,
                unfocusedContainerColor = Color.Transparent,
                unfocusedIndicatorColor = Color(0XFF08632D),
                focusedIndicatorColor = Color(0XFF08632D),
                focusedLabelColor = Color(0XFF08632D),
            ),
            label = {
                Text(
                    "Senha",
                    fontFamily = FontFamily(Font(R.font.montserrat)),
                    fontSize = 12.sp
                )
            },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Password
            )
        )

        Spacer(modifier = Modifier.height(15.dp))

        OutlinedTextField(
            modifier = textFieldModifier,
            value = confirmPassword,
            onValueChange = { confirmPassword = it },
            shape = RoundedCornerShape(7.dp),
            colors = TextFieldDefaults.colors(
                focusedContainerColor = Color.Transparent,
                unfocusedContainerColor = Color.Transparent,
                unfocusedIndicatorColor = Color(0XFF08632D),
                focusedIndicatorColor = Color(0XFF08632D),
                focusedLabelColor = Color(0XFF08632D),
            ),
            label = {
                Text(
                    "Confirmar Senha",
                    fontFamily = FontFamily(Font(R.font.montserrat)),
                    fontSize = 12.sp
                )
            },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Password
            )
        )

        Spacer(modifier = Modifier.height(25.dp))

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp),
            horizontalArrangement = Arrangement.SpaceAround
        ) {
            Button(
                onClick = { },
                modifier = Modifier
                    .height(45.dp)
                    .width(119.dp)
                    .fillMaxWidth(0.2f),
                contentPadding = PaddingValues(horizontal = 1.dp, vertical = 0.dp),
                colors = ButtonDefaults.textButtonColors(
                    contentColor = Color.White,
                    containerColor = Color(0xFFFF4545)
                ),
                shape = RoundedCornerShape(5.dp)
            ) {
                Text(
                    text = "Cancelar",
                    fontFamily = FontFamily(Font(R.font.montserrat)),
                    fontSize = 12.sp


                )
            }

            Button(
                onClick = { },
                modifier = Modifier
                    .padding(start = 1.dp)
                    .height(45.dp)
                    .width(119.dp)
                    .fillMaxWidth(0.2f),
                colors = ButtonDefaults.textButtonColors(
                    contentColor = Color.White,
                    containerColor = Color(0xFF08632D)
                ),
                contentPadding = PaddingValues(horizontal = 1.dp, vertical = 0.dp),
                shape = RoundedCornerShape(5.dp)
            ) {
                Text(
                    text = "Confirmar",
                    fontFamily = FontFamily(Font(R.font.montserrat)),
                    fontSize = 12.sp
                )
            }
        }
    }
}

