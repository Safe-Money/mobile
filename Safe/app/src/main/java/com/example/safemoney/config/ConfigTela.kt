package com.example.safemoney.config

import DeletarLogin
import LoginViewModel
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
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
import androidx.compose.material.icons.outlined.Delete
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.window.Dialog
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.safemoney.FooterBar
import com.example.safemoney.R
import kotlinx.coroutines.launch

@Composable
fun ConfigScreen(navController: NavController, loginViewModel: LoginViewModel) {
    var name by remember { mutableStateOf(loginViewModel.getNome() ?: " Nome não encontrado") }
    var email by remember { mutableStateOf(loginViewModel.getEmail() ?: "") }
    var password by remember { mutableStateOf("") }
    var confirmPassword by remember { mutableStateOf("") }
    val showDialog = remember { mutableStateOf(false) }

    val coroutineScope = rememberCoroutineScope()
    val snackbarHostState = remember { SnackbarHostState() }

    val textFieldModifier = Modifier
        .fillMaxWidth(0.8f)
        .height(60.dp)

    Scaffold(
        snackbarHost = { SnackbarHost(hostState = snackbarHostState) }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues),
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

                    onClick = {
                        showDialog.value = true


                    },
                    contentPadding = PaddingValues(horizontal = 7.dp, vertical = 0.dp),
                    modifier = Modifier.padding(end = 16.dp),
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
                            modifier = Modifier
                                .size(20.dp)
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
                        "nome",
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
                visualTransformation = PasswordVisualTransformation(),
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
                visualTransformation = PasswordVisualTransformation(),
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
                        "Confirma Senha",
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
                    onClick = { /* Implement your cancel action */ },
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

                    onClick = {
                        if (password == confirmPassword) {
                            coroutineScope.launch {
                                val nomeAlterado = name != loginViewModel.getNome()
                                val emailAlterado = email != loginViewModel.getEmail()
                                val senhaAlterada =
                                    password.isNotEmpty() && password == confirmPassword

                                val result = if (nomeAlterado || emailAlterado || senhaAlterada) {
                                    if (senhaAlterada) {
                                        loginViewModel.atualizarUsuario(name, email, password)
                                    } else {
                                        loginViewModel.atualizarUsuario(name, email, null)
                                    }
                                } else {
                                    false
                                }

                                if (result) {
                                    if (emailAlterado || senhaAlterada) {
                                        navController.navigate("login")
                                    } else {
                                        snackbarHostState.showSnackbar("Dados atualizados com sucesso")
                                    }
                                } else {
                                    snackbarHostState.showSnackbar("Falha ao atualizar os dados")
                                }
                            }
                        }
                    },
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

            Spacer(modifier = Modifier.weight(1f))
            FooterBar(navController = navController)
        }
    }

    if (showDialog.value) {
        DeletarLogin(
            onConfirm = { showDialog.value = false },
            onDismiss = { showDialog.value = false },
            navController = navController,
            loginViewModel = loginViewModel
        )
    }
}




