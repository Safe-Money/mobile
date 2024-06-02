package com.example.safemoney.planejamento

import DeletarPlano
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.Icon
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import com.example.safemoney.R
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.safemoney.telas_acao.despesa_acao.EditarPlano
import com.example.safemoney.ui.theme.Cinza
import com.example.safemoney.ui.theme.Verde
import com.example.safemoney.ui.theme.VerdeClaro
import com.example.safemoney.ui.theme.VerdePercent
import com.example.safemoney.viewmodel.PlanejamentoViewModel
import org.koin.androidx.compose.getViewModel

@Composable
fun PlanItem(i: PlanejamentoItem, planejamentoViewModel: PlanejamentoViewModel = getViewModel(), navController: NavController){
    val modalExcluir = remember { mutableStateOf<Boolean?>(false) }
    val modalEditar = remember { mutableStateOf<Boolean?>(false) }
;
    Box(modifier = Modifier
        .fillMaxWidth()
        .padding(horizontal = 2.dp, vertical = 5.dp)
    )
    {
        val image = when(i.categoria.nome){
            "saúde" -> painterResource(id = R.drawable.saude)
            "alimentacao" -> painterResource(id = R.drawable.alimentacao)
            "lazer" -> painterResource(id = R.drawable.game)
            "gym" -> painterResource(id = R.drawable.icon___academia)
            "pet" -> painterResource(id = R.drawable.pet)
            "vestuario" -> painterResource(id = R.drawable.icon___shopping)
            "economia" -> painterResource(id = R.drawable.economia)
            "transporte" -> painterResource(id = R.drawable.onibus_escolar)
            else -> painterResource(id = R.drawable.excluir)
        }

        Row (modifier = Modifier
            .fillMaxWidth()
            .align(Alignment.Center)
            .height(45.dp),
            horizontalArrangement = Arrangement.spacedBy(10.dp)
        ){
            Image(
                painter = image,
                contentDescription = "Categoria",
                modifier = Modifier.padding(top = 8.dp, end = 5.dp)
            )

            val mostrarGasto =  if (i.totalGasto != null) i.totalGasto else 0.0

            Text(text = "R$ "+ String.format("%.2f", mostrarGasto),
                fontSize = 10.sp,
                fontFamily = FontFamily(Font(R.font.montserrat)),
                modifier = Modifier
                    .height(26.dp)
                    .padding(top = 11.dp)
                    .width(60.dp)
            )

            val progresso = if (i.totalGasto != null) i.totalGasto / i.valorPlanejado else 0.0

            Column (
                modifier = Modifier
                    .height(30.dp)
                    .width(100.dp)
                    .padding(top = 3.dp)
            ){
                Text(text = String.format("%.0f", progresso * 100) + "%",
                    color = VerdePercent,
                    fontSize = 8.sp,
                    fontFamily = FontFamily(Font(R.font.montserrat_bold)),
                    modifier = Modifier.fillMaxWidth(),
                    textAlign = TextAlign.Center)

                LinearProgressIndicator(
                    progress = progresso.toFloat(),
                    color = VerdeClaro,
                    modifier = Modifier
                        .width(140.dp)
                        .height(6.dp)
                        .clip(RoundedCornerShape(5.dp))
                )
            }

            Text(text = "R$ "+ String.format("%.2f", i.valorPlanejado),
                fontSize = 10.sp,
                fontFamily = FontFamily(Font(R.font.montserrat)),
                modifier = Modifier
                    .height(25.dp)
                    .padding(top = 11.dp)
                    .width(65.dp)
            )

            Column(
                modifier = Modifier
                    .width(20.dp)
                    .height(60.dp),
                verticalArrangement = Arrangement.spacedBy(7.dp)

            ) {
                Image(
                    painter = painterResource(id = R.drawable.editar),
                    contentDescription = "Editar",
                    modifier = Modifier
                        .size(14.dp)
                        .align(Alignment.CenterHorizontally)
                        .clickable {
                            modalEditar.value = true
                        }
                )

                Image(
                    painter = painterResource(id = R.drawable.excluir),
                    contentDescription = "Excluir",
                    modifier = Modifier
                        .size(26.dp)
                        .align(Alignment.CenterHorizontally)
                        .clickable {
                            modalExcluir.value = true
                        }
                )
            }



        }

        if (modalExcluir.value!!) {
            DeletarPlano(
                plano = i,
                image = image,
                onConfirm = {
                    planejamentoViewModel.excluirPlanejamento(i.id!!)
                    modalExcluir.value = false
                    navController.navigate("planejamento")
                },
                onDismiss = {
                    modalExcluir.value = false
                }
            )
        }

        if(modalEditar.value!!){
            navController.navigate("editarPlanejamento/${i.id}")
        }
    }
}



/*@Preview(showBackground = true)
@Composable
fun planItemPreview(){
    PlanItem(i = itemTeste)
}

 */