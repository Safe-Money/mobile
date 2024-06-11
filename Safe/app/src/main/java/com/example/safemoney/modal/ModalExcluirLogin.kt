import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.outlined.Delete
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.safemoney.R
import com.example.safemoney.ui.theme.Cinza
import com.example.safemoney.ui.theme.Vermelho
import kotlinx.coroutines.launch

@Composable
fun DeletarLogin(
    onConfirm: () -> Unit,
    onDismiss: () -> Unit,
    navController: NavController,
    loginViewModel: LoginViewModel
) {

    val coroutineScope = rememberCoroutineScope()
    Dialog(
        onDismissRequest = { onDismiss() }
    ) {
        Card(
            modifier = Modifier
                .fillMaxWidth(),
            shape = RoundedCornerShape(15.dp),


            ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.White),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Surface(
                    color = Vermelho,
                    shape = RoundedCornerShape(topStart = 8.dp, topEnd = 8.dp),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth(),
                        contentAlignment = Alignment.TopEnd
                    ) {
                        IconButton(onClick = { onDismiss() }) {
                            Icon(
                                imageVector = Icons.Default.Close,
                                contentDescription = "Fechar Icon",
                                tint = Color.White,
                                modifier = Modifier.size(20.dp)
                            )
                        }
                    }

                    Row(
                        horizontalArrangement = Arrangement.Center,
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier
                            .padding(vertical = 8.dp)
                            .height(65.dp)
                    ) {
                        Icon(
                            imageVector = Icons.Outlined.Delete,
                            contentDescription = "Delete Icon",
                            tint = Color.White,
                            modifier = Modifier.size(40.dp)
                        )
                        Text(
                            text = "Excluir sua conta?",
                            fontFamily = FontFamily(Font(R.font.montserrat)),
                            fontSize = 17.sp,
                            color = Color.White,

                            )
                    }
                }

                Spacer(modifier = Modifier.height(70.dp))

                Row(
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier

                ) {


                    Text(
                        text = "Você está prestes a excluir sua conta da SafeMoney",
                        fontFamily = FontFamily(Font(R.font.montserrat_semibold)),
                        fontSize = 11.sp,
                        color = Color.Black,

                        )

                }

                Spacer(modifier = Modifier.height(50.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    TextButton(
                        onClick = { onDismiss() },


                        ) {

                        Text("Cancelar",
                            fontSize = 10.sp,
                            color = Cinza,
                            fontFamily = FontFamily(Font(R.font.montserrat)))
                    }


                    Spacer(modifier = Modifier.width(40.dp))

                    Button(

                        onClick = {
                            coroutineScope.launch {
                                val result = loginViewModel.excluirUsuario()
                                if (result) {
                                    onConfirm()
                                    navController.navigate("login")
                                } else {

                                }
                            }
                        },
                        contentPadding = PaddingValues(horizontal = 20.dp, vertical = 0.dp),
                        modifier = Modifier
                            .height(23.dp),
                        shape = RoundedCornerShape(20.dp),
                        colors = ButtonDefaults.buttonColors(containerColor = Vermelho),

                        ) {
                        Text("Excluir",
                            fontSize = 10.sp,
                            fontFamily = FontFamily(Font(R.font.montserrat)))
                    }


                }
                Spacer(modifier = Modifier.height(10.dp))
            }
        }
    }

}



