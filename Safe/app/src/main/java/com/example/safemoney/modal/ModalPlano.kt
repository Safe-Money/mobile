import androidx.annotation.DrawableRes
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
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import com.example.safemoney.R
import com.example.safemoney.planejamento.PlanejamentoItem
import com.example.safemoney.ui.theme.Cinza
import com.example.safemoney.ui.theme.Vermelho


@Composable
fun DeletarPlano(
    plano: PlanejamentoItem,
    image: Painter,
    onConfirm: () -> Unit,
    onDismiss: () -> Unit
) {

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
                            text = "Remover plano?",
                            fontFamily = FontFamily(Font(R.font.montserrat)),
                            fontSize = 17.sp,
                            color = Color.White,

                            )
                    }
                }

                Spacer(modifier = Modifier.height(16.dp))

                Text(
                    text = "Você está prestes a remover o plano:",
                    fontFamily = FontFamily(Font(R.font.montserrat_semibold)),
                    fontSize = 11.sp,
                    color = Color.Black,
                    modifier = Modifier.padding(top = 16.dp)
                )
                Spacer(modifier = Modifier.height(30.dp))

                Row(
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier

                ){

                    Image(
                        painter = image,
                        contentDescription = "Cartão Image",
                        modifier = Modifier
                            .size(20.dp)
                            .clip(shape = CircleShape)
                    )

                    Spacer(modifier = Modifier.width(10.dp))
                    Text(
                        text = plano.categoria.nome!!,
                        fontFamily = FontFamily(Font(R.font.montserrat)),
                        fontSize = 14.sp,
                        color = Color.Black,
                    )
                }

                Spacer(modifier = Modifier.height(20.dp))

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
                        onClick = { onConfirm() },
                        contentPadding = PaddingValues(horizontal = 20.dp, vertical = 0.dp),
                        modifier = Modifier
                            .height(23.dp),
                        shape = RoundedCornerShape(20.dp),
                        colors = ButtonDefaults.buttonColors(containerColor = Vermelho),

                        ) {
                        Text("Remover",
                            fontSize = 10.sp,
                            fontFamily = FontFamily(Font(R.font.montserrat)))
                    }
                }
                Spacer(modifier = Modifier.height(20.dp))
            }
        }
    }
}




/*@Preview
@Composable

fun PreviewDeletarPlano() {
    val showDialog = remember { mutableStateOf(true) }
    val meuPlano = Plano(nome = "Lazer", icone = R.drawable.lazer)

    if (showDialog.value) {
        DeletarPlano(
            plano = meuPlano,
            onConfirm = {  },
            onDismiss = {  }
        )
    }
}
*/