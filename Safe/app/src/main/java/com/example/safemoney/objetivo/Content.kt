import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import com.example.safemoney.R
import com.example.safemoney.ui.theme.VerdeClaro


@Preview (showBackground = true)

@Composable
fun AppBarLayoutPreview2() {
    Content()
}

@Composable
fun Content(
    @DrawableRes image: Int = R.drawable.play5,
    trashImage: Int = R.drawable.excluir,
    moneyImage: Int = R.drawable.money,
    editImage: Int = R.drawable.edit,
    paris: Int = R.drawable.paris,

    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .fillMaxWidth(1f)
            .padding(vertical = 8.dp)
            .padding(horizontal = 20.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth(1f)
                .align(Alignment.TopCenter),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(80.dp)
                    .clip(CircleShape),
                painter = painterResource(id = image),
                contentDescription = null,
            )

            Column(
                modifier = Modifier.padding(start = 20.dp)
            ) {
                Text(
                    text = "Playstation 5",
                    style = TextStyle(
                        fontSize = 18.sp,
                        fontFamily = FontFamily(Font(R.font.montserrat)),
                    ),
                    modifier = Modifier.padding(bottom = 8.dp)
                )
                Row {
                    Text(
                        text = "30.000,00/40.000,00",
                        style = TextStyle(
                            fontSize = 8.sp,
                            fontFamily = FontFamily(Font(R.font.montserrat)),
                        ),
                        modifier = Modifier.padding(top = 0.dp)
                    )
                    Text(
                        text = "70%",
                        style = TextStyle(
                            fontSize = 12.sp,
                            fontFamily = FontFamily(Font(R.font.montserrat)),
                        ),
                        modifier = Modifier.padding(start = 55.dp)
                    )
                }


                LinearProgressIndicator(
                    modifier = Modifier
                        .width(180.dp)
                        .height(5.dp)
                        .padding(bottom = 0.dp, end = 20.dp),
                    color = VerdeClaro, // Altere a cor conforme necessário
                    progress = 0.7f // Define o progresso como 50%
                )



                Text(
                    text = "Início: 08/23 Término: 11/24",
                    style = TextStyle(
                        fontSize = 8.sp,
                        fontFamily = FontFamily(Font(R.font.montserrat)),
                    ),
                    modifier = Modifier.padding(bottom = 20.dp)
                )
            }
            Column(
                modifier = Modifier
                    .width(20.dp)
            ) {
                Image(
                    painter = painterResource(id = moneyImage),
                    contentDescription = null,
                    modifier = Modifier
                        .size(15.dp)
                )

            }
            Column(
                modifier = Modifier
                    .width(100.dp)
                    .padding(start = 3.dp)

            ) {

                Image(
                    painter = painterResource(id = editImage),
                    contentDescription = null,
                    modifier = Modifier.size(18.dp)
                )

                Spacer(modifier = Modifier.height(4.dp))

                Image(
                    painter = painterResource(id = trashImage),
                    contentDescription = null,
                    modifier = Modifier
                        .size(21.dp)
                )
            }

        }
    }

    Box(
        modifier = modifier
            .fillMaxWidth(1f)
            .padding(vertical = 8.dp)
            .padding(horizontal = 20.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth(1f)
                .align(Alignment.TopCenter),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(80.dp)
                    .clip(CircleShape),
                painter = painterResource(id = paris),
                contentDescription = null,
            )

            Column(
                modifier = Modifier.padding(start = 20.dp)
            ) {
                Text(
                    text = "Viagem Paris",
                    style = TextStyle(
                        fontSize = 18.sp,
                        fontFamily = FontFamily(Font(R.font.montserrat)),
                    ),
                    modifier = Modifier.padding(bottom = 8.dp)
                )
                Row {
                    Text(
                        text = "1.500,00/4.000,00",
                        style = TextStyle(
                            fontSize = 8.sp,
                            fontFamily = FontFamily(Font(R.font.montserrat)),
                        ),
                        modifier = Modifier.padding(top = 0.dp)
                    )
                    Text(
                        text = "30%",
                        style = TextStyle(
                            fontSize = 12.sp,
                            fontFamily = FontFamily(Font(R.font.montserrat)),
                        ),
                        modifier = Modifier.padding(start = 55.dp)
                    )
                }


                LinearProgressIndicator(
                    modifier = Modifier
                        .width(180.dp)
                        .height(5.dp)
                        .padding(bottom = 0.dp, end = 20.dp),
                    color = VerdeClaro, // Altere a cor conforme necessário
                    progress = 0.3f // Define o progresso como 50%
                )



                Text(
                    text = "Início: 05/23 Término: 01/24",
                    style = TextStyle(
                        fontSize = 8.sp,
                        fontFamily = FontFamily(Font(R.font.montserrat)),
                    ),
                    modifier = Modifier.padding(bottom = 20.dp)
                )
            }
            Column(
                modifier = Modifier
                    .width(20.dp)
            ) {
                Image(
                    painter = painterResource(id = moneyImage),
                    contentDescription = null,
                    modifier = Modifier
                        .size(15.dp)
                )

            }
            Column(
                modifier = Modifier
                    .width(100.dp)
                    .padding(start = 3.dp)

            ) {

                Image(
                    painter = painterResource(id = editImage),
                    contentDescription = null,
                    modifier = Modifier.size(18.dp)
                )

                Spacer(modifier = Modifier.height(8.dp))

                Image(
                    painter = painterResource(id = trashImage),
                    contentDescription = null,
                    modifier = Modifier
                        .size(21.dp)
                )
            }

        }

    }

}
