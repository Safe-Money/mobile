package com.example.safemoney.cadastro

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
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
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import com.example.safemoney.R
import com.example.safemoney.ui.theme.SafeMoneyTheme
@Composable
fun CadastroScreen(navController: NavController) {
    MaterialTheme {

        var name by remember { mutableStateOf("") }
        var birthdate by remember { mutableStateOf("") }
        var email by remember { mutableStateOf("") }
        var password by remember { mutableStateOf("") }
        var confirmPassword by remember { mutableStateOf("") }

        val textFieldModifier = Modifier
            .fillMaxWidth(0.8f)
            .height(60.dp)


        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(start = 16.dp, top = 20.dp, end = 16.dp, bottom = 16.dp),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        )
        {
            Spacer(modifier = Modifier.height(20.dp))
            Image(
                painter = painterResource(id = R.drawable.safemoney2),
                contentDescription = null,
                modifier = Modifier
                    .size(100.dp)
                    .padding(bottom = 20.dp)
            )
            Spacer(modifier = Modifier.height(20.dp))

            Text(
                text = "Cadastro",
                fontFamily = FontFamily(Font(R.font.montserrat_semibold)),
                textAlign = TextAlign.Start,
                fontWeight = FontWeight.SemiBold,
                fontSize = 22.sp,
                modifier = Modifier
                    .fillMaxWidth(0.8f)
                    .padding(end = 40.dp)
            )
            Spacer(modifier = Modifier.height(20.dp))

            OutlinedTextField(
                modifier = textFieldModifier,
                value = name,
                onValueChange = {
                    name = it
                },

                shape = RoundedCornerShape(7.dp),
                colors = TextFieldDefaults.colors(
                    focusedContainerColor = Color.Transparent,
                    unfocusedContainerColor = Color.Transparent,
                    unfocusedIndicatorColor = Color(0XFF08632D),
                    focusedIndicatorColor = Color(0XFF08632D),
                    focusedLabelColor = Color(0XFF08632D),
                ),
                label = {
                    Text("Nome",
                        fontFamily = FontFamily(Font(R.font.montserrat)),
                        fontSize = 12.sp)
                }
            )

            Spacer(modifier = Modifier.height(15.dp))

            OutlinedTextField(
                modifier = textFieldModifier,
                value = birthdate,
                onValueChange = {
                    birthdate = it
                },
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
                        "Data de Nascimento",
                        fontFamily = FontFamily(Font(R.font.montserrat)),
                        fontSize = 12.sp)

                },
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Number
                )
            )

            Spacer(modifier = Modifier.height(15.dp))

            OutlinedTextField(
                modifier = textFieldModifier,
                value = email,
                onValueChange = {
                    email = it
                },
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
                        fontSize = 12.sp)

                }
            )

            Spacer(modifier = Modifier.height(15.dp))

            OutlinedTextField(
                modifier = textFieldModifier,
                value = password,
                onValueChange = {
                    password = it
                },
                shape = RoundedCornerShape(7.dp),
                colors = TextFieldDefaults.colors(
                    focusedContainerColor = Color.Transparent,
                    unfocusedContainerColor = Color.Transparent,
                    unfocusedIndicatorColor = Color(0XFF08632D),
                    focusedIndicatorColor = Color(0XFF08632D),
                    focusedLabelColor = Color(0XFF08632D),
                ),
                label = {
                    Text("Senha",
                        fontFamily = FontFamily(Font(R.font.montserrat)),
                        fontSize = 12.sp)

                },
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Password
                )
            )

            Spacer(modifier = Modifier.height(15.dp))

            OutlinedTextField(
                modifier = textFieldModifier,
                value = confirmPassword,
                onValueChange = {
                    confirmPassword = it
                },
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
                        fontSize = 12.sp)

                },
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Password
                )
            )

            Spacer(modifier = Modifier.height(40.dp))

            Button(
                onClick = {
                    navController.navigate("login")
                },
                modifier = Modifier
                    .fillMaxWidth(0.8f)
                    .height(45.dp),
                colors = ButtonDefaults.textButtonColors(
                    contentColor = Color.White,
                    containerColor = Color(0xFF08632D)
                ),
                shape = RoundedCornerShape(9.dp)
            ) {
                Text(
                    text = "Cadastrar",
                    fontSize = 15.sp
                )
            }
            Spacer(modifier = Modifier.height(16.dp))

            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth(0.8f)
            ) {
                Text(
                    text = "Já tem uma conta? ",
                    fontFamily = FontFamily(Font(R.font.montserrat)),
                    fontSize = 12.sp,
                    color = Color(0xFF676767),
                )
                Text(
                    text = "Clique aqui",
                    color = Color(0xFF08632D),
                    fontFamily = FontFamily(Font(R.font.montserrat)),
                    fontSize = 12.sp,
                    fontWeight = FontWeight.SemiBold,
                    modifier = Modifier.padding(start = 4.dp),

                    )
            }
        }
    }
}

