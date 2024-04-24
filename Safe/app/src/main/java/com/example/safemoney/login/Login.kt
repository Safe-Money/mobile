package com.example.safemoney.login


import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.safemoney.R
import com.example.safemoney.viewmodel.CadastroViewModel

@Composable

fun LoginScreen1(navController: NavController,cadastroViewModel: CadastroViewModel = viewModel()) {
    MaterialTheme {

        var username by remember { mutableStateOf("") }
        var password by remember { mutableStateOf("") }

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(start = 16.dp, top = 20.dp, end = 16.dp, bottom = 16.dp),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(40.dp))
            Box(
                modifier = Modifier.fillMaxWidth(0.8f),
                contentAlignment = Alignment.Center
            ) {
                Image(
                    painter = painterResource(id = R.drawable.safemoney2),
                    contentDescription = null,
                    modifier = Modifier
                        .size(100.dp)
                        .align(Alignment.TopCenter)
                )
                Text(
                    text = "Login",
                    fontFamily = FontFamily(Font(R.font.montserrat_semibold)),
                    textAlign = TextAlign.Start,
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 22.sp,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 120.dp, end = 40.dp)

                )
            }

            Spacer(modifier = Modifier.height(17.dp))

            val textFieldModifier = Modifier
                .fillMaxWidth(0.8f)
                .height(60.dp)

            OutlinedTextField(
                modifier = textFieldModifier,

                value = username,
                shape = RoundedCornerShape(7.dp),
                colors = TextFieldDefaults.colors(
                    unfocusedContainerColor = Color.Transparent,
                    focusedContainerColor = Color.Transparent,
                    unfocusedIndicatorColor = Color(0XFF08632D),
                    focusedIndicatorColor = Color(0XFF08632D),
                    focusedLabelColor = Color(0XFF08632D),
                ),

                onValueChange = {
                    username = it
                },
                label = {
                    Text("E-mail",
                        fontFamily = FontFamily(Font(R.font.montserrat)),
                        fontSize = 12.sp)

                },

                placeholder = {
                    Text("Digite seu e-mail",
                        fontFamily = FontFamily(Font(R.font.montserrat)),
                        fontSize = 12.sp)
                },

                )

            Spacer(modifier = Modifier.height(20.dp))

            OutlinedTextField(
                modifier = textFieldModifier,
                value = password,
                shape = RoundedCornerShape(7.dp),
                colors = TextFieldDefaults.colors(
                    unfocusedContainerColor = Color.Transparent,
                    focusedContainerColor = Color.Transparent,
                    unfocusedIndicatorColor = Color(0XFF08632D),
                    focusedIndicatorColor = Color(0XFF08632D),
                    focusedLabelColor = Color(0XFF08632D),


                    ),
                onValueChange = {
                    password = it
                },
                label = {
                    Text("Senha",
                        fontFamily = FontFamily(Font(R.font.montserrat)),
                        fontSize = 12.sp)
                },
                placeholder = {
                    Text("Digite sua senha",
                        fontFamily = FontFamily(Font(R.font.montserrat)),
                        fontSize = 12.sp)
                },
                keyboardOptions = KeyboardOptions.Default.copy(
                    keyboardType = KeyboardType.Password
                )
            )

            Spacer(modifier = Modifier.height(20.dp))

            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth(0.8f)
            ) {
                Text(
                    text = "Esqueceu a senha? ",
                    fontFamily = FontFamily(Font(R.font.montserrat)),
                    fontSize = 12.sp,
                    color = Color(0xFF676767),
                )
                Text(
                    text = "Clique aqui",
                    color = Color(0xFF08632D),
                    fontFamily = FontFamily(Font(R.font.montserrat)),
                    fontWeight = FontWeight.SemiBold,
                    modifier = Modifier.padding(start = 4.dp),
                    fontSize = 12.sp
                )
            }

            Spacer(modifier = Modifier.height(40.dp))

            Button(
                onClick = {
                    navController.navigate("painel")
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
                    text = "Entrar",
                    fontSize = 15.sp
                )
            }

            Spacer(modifier = Modifier.height(16.dp))

            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth(0.8f)
            ) {
                Text(
                    text = "Não tem uma conta? ",
                    fontFamily = FontFamily(Font(R.font.montserrat)),
                    fontSize = 12.sp,
                    color = Color(0xFF676767),
                )
                Text(
                    text = "Inscreva-se",
                    color = Color(0xFF08632D),
                    fontFamily = FontFamily(Font(R.font.montserrat)),
                    fontWeight = FontWeight.SemiBold,
                    modifier = Modifier.padding(start = 4.dp),
                    fontSize = 12.sp
                )
            }
        }
    }
}


