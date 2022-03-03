import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.Start
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.HorizontalAlignmentLine
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Composable
fun pantallaInicio(cambiarPantalla:(Int)->Unit){
    val peleadores:ArrayList<Pokemon> = arrayListOf()
    var bat:Batalla
    var showDialog by remember { mutableStateOf(0) }
    var poke1 = "${chikorita.name}1.png"
    var poke2 = "${totodile.name}1.png"
    var poke3 = "${cyndaquil.name}1.png"
    val pok = "Pokeball1.png"
    val pok2 = "Pokeball2.png"
    val pok3 = "Pokeball3.png"
    var text4 by remember { mutableStateOf("FREE") }
    var text5 by remember { mutableStateOf("FREE") }
    var text6 by remember { mutableStateOf("FREE") }

    var pokemon1 by remember { mutableStateOf(pok) }
    var pokemon2 by remember { mutableStateOf(pok2) }
    var pokemon3 by remember { mutableStateOf(pok3) }
    var contador = 0
    var corutina = rememberCoroutineScope()
    MaterialTheme {
        Box(modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .background(Color.Green)) {
            Image(
                modifier = Modifier.fillMaxWidth().fillMaxHeight().offset(0.dp,-100.dp),
                painter = painterResource("FondoBosque.png"),
                contentDescription = "descripcion")
            Image(
                modifier = Modifier.size(300.dp,192.dp).offset(0.dp,139.dp),
                painter = painterResource("a$contador.png"),
                contentDescription = "descripcion")
            Image(
                modifier =
                Modifier.size(50.dp, 50.dp)
                    .offset(20.dp, 80.dp)
                    .clip(CircleShape)
                    .clickable {
                        text4 = when(text4){
                            "FREE" -> "SELECTED"
                            "SELECTED" -> "FREE"
                            else->""
                        }
                        if (text4=="SELECTED"){
                            peleadores.add(chikorita)
                            showDialog+=1

                        }else{peleadores.remove(chikorita);showDialog-=1}
                        contador = 1
                        if (showDialog==0){
                            contador = 0
                        }
                        pokemon1 = when (pokemon1) {
                            poke1 -> pok
                            pok -> poke1
                            else -> ""
                        }
                    },
                painter = painterResource(pokemon1),
                contentDescription = "descripcion")
            Image(
                modifier =
                Modifier.size(50.dp, 50.dp)
                    .offset(95.dp, 80.dp)
                    .clip(CircleShape)
                    .clickable {
                        text5 = when(text5){
                            "FREE" -> "SELECTED"
                            "SELECTED" -> "FREE"
                            else->""
                        }
                        if (text5=="SELECTED"){
                            peleadores.add(totodile)
                            showDialog+=1

                        }else{peleadores.remove(totodile);showDialog-=1}
                        contador = 3
                        if (showDialog==0){
                            contador = 0
                        }
                        pokemon2 = when (pokemon2) {
                            poke2 -> pok2
                            pok2 -> poke2
                            else -> ""
                        }
                    },
                painter = painterResource(pokemon2),
                contentDescription = "descripcion")
            Image(
                modifier =
                Modifier.size(50.dp, 50.dp)
                    .offset(170.dp, 80.dp)
                    .clip(CircleShape)
                    .clickable {
                        text6 = when(text6){
                            "FREE" -> "SELECTED"
                            "SELECTED" -> "FREE"
                            else->""
                        }
                        if (text6=="SELECTED"){
                            peleadores.add(cyndaquil)
                            showDialog+=1

                        }else{peleadores.remove(cyndaquil);showDialog-=1}
                        contador = 2
                        if (showDialog==0){
                            contador = 0
                        }
                        pokemon3 = when (pokemon3) {
                            poke3 -> pok3
                            pok3 -> poke3
                            else -> ""
                        }
                    },
                painter = painterResource(pokemon3),
                contentDescription = "descripcion"
            )
            Button(enabled = showDialog == 2, onClick = {
                bat1 = Batalla(peleadores[0], peleadores[1],-1,-1)
                if (bat1.comprobarVelocidad()) {
                    val aux = peleadores[0]
                    peleadores[0] = peleadores[1]
                    peleadores[1] = aux
                    bat1 = Batalla(peleadores[0], peleadores[1],-1,-1) }
                cambiarPantalla(2)}, modifier = Modifier.size(65.dp, 30.dp).offset(168.dp))

            {
                Text("START", color = Color.Green, textAlign = TextAlign.Justify, fontSize = 7.sp) }
        }
    }
}


