import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.TopStart
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.key.Key.Companion.R
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import java.awt.SystemColor.text
import kotlin.reflect.KProperty



@Composable
fun pantalla2(cambiarPantalla:(Int)->Unit){
    var coloVIda by remember { mutableStateOf(verde) }
    var coloVIda2 by remember { mutableStateOf(verde) }
    var vida1 by remember { mutableStateOf(bat1.pokemon1.currentHP) }
    var vida2 by remember { mutableStateOf(bat1.pokemon2.currentHP) }
    var nombe by remember { mutableStateOf(bat1.pokemon1.name) }
    var nombe2 = bat1.pokemon2.name
    var pantallaSeleccionada1 by remember { mutableStateOf(0) }
    val cambiarPantalla1:(Int)->Unit = {pantallaSeleccionada1 = it}

    when(pantallaSeleccionada1){
        1->pantallaMovimientos(cambiarPantalla,cambiarPantalla1)
        2->pantallaObjetos (cambiarPantalla,cambiarPantalla1)
    }
    if(vida1<bat1.pokemon1.hp*0.5){
        coloVIda = Color(0xffFFFF00)
    }
    if(vida1<bat1.pokemon1.hp*0.2){
        coloVIda = Color(0xffD50000)
    }
    if(vida2<bat1.pokemon2.hp*0.5){
        coloVIda2 = Color(0xffFFFF00)
    }
    if(vida2<bat1.pokemon2.hp*0.2){
        coloVIda2 = Color(0xffD50000)
    }
    Box(){
            Image(
                modifier = Modifier.fillMaxWidth().fillMaxHeight().offset(0.dp,-100.dp),
                painter = painterResource("CampoBatalla.png"),
                contentDescription = "descripcion"
            )
            LinearProgressIndicator(
                vida2.toFloat() / bat1.pokemon2.hp,
                modifier = Modifier.width(50.dp).height(5.dp)
                    .offset(45.dp, 22.dp),
                color = coloVIda2
            )
            LinearProgressIndicator(
                vida1.toFloat() / bat1.pokemon1.hp,
                modifier = Modifier.width(46.dp).height(5.dp)
                    .offset(183.dp, 91.dp),
                color = coloVIda
            )
            Image(
                modifier = Modifier.size(width = 256.dp, height = 192.dp).offset(0.dp,-23.dp),
                painter = painterResource("Vida.png"),
                contentDescription = "descripcion"
            )

            Text(modifier = Modifier.offset(183.dp, 97.dp),
                text = "$vida1/${bat1.pokemon1.hp}",
                fontSize = 10.sp
            )
            Text(modifier = Modifier.offset(10.dp, 5.dp),
                fontSize = 13.sp,
                text = bat1.pokemon2.name,
            )
            Text(modifier = Modifier.offset(140.dp, 75.dp),
                fontSize = 13.sp,
                text = bat1.pokemon1.name,
            )
        }
       Image(
            modifier = Modifier.size(width = 256.dp, height = 192.dp).offset(0.dp,-22.dp),
            painter = painterResource("${nombe}E.png"),
            contentDescription = "descripcion"
        )
        Image(
            modifier = Modifier.size(width = 256.dp, height = 192.dp).offset(0.dp,-30.dp),
            painter = painterResource("TextoCombate.png"),
            contentDescription = "descripcion"
        )
        Image(
            modifier = Modifier.size(width = 256.dp, height = 192.dp).offset(0.dp,-25.dp),
            painter = painterResource("${nombe2}.png"),
            contentDescription = "descripcion"
        )
    MaterialTheme(colorRojo) {
        Button(
            modifier = Modifier.offset(150.dp, 151.dp)
                .size(width = 90.dp, height = 64.dp),
            onClick = { pantallaSeleccionada1 = 1 }) {
            Text("Atacar" ,color = Color.White)
        }
        MaterialTheme(colorAmarillo) {
            Button(
                modifier = Modifier.offset(150.dp, 215.dp)
                    .size(width = 90.dp, height = 64.dp),
                onClick = { pantallaSeleccionada1 = 2 }) {
                Text("Usar Objeto")
            }
        }}
        MaterialTheme(colorAzul) {
            Button(
                modifier = Modifier.offset(150.dp, 279.dp)
                    .size(width = 90.dp, height = 64.dp),
                onClick = {
                    bat1.pokemon1.Evolucionar()
                    if (bat1.pokemon1.name != nombe) {
                        nombe = "${bat1.pokemon1.name}"
                    }
                    if (bat1.pokemon1.currentHP != vida1) {
                        vida1 = bat1.pokemon1.currentHP
                    }
                    if (vida2 != bat1.pokemon2.currentHP) {
                        vida2 = bat1.pokemon2.currentHP
                    }
                    if (vida2 < bat1.pokemon2.hp * 0.5) {
                        coloVIda2 = Color(0xffFFFF00)
                    }
                    if (vida2 < bat1.pokemon2.hp * 0.2) {
                        coloVIda2 = Color(0xffD50000)
                    }
                    cambiarPantalla(3)
                }) {
                Text("Evolucionar")
            }
        }
    Image(
        modifier = Modifier.fillMaxWidth().height(192.dp).offset(0.dp,142.dp),
        painter = painterResource("CajaAcciones.png"),
        contentDescription = "descripcion"
    )
        Button(modifier = Modifier.offset(280.dp, 128.dp),
            onClick = {
                bat1.pokemon1.recibirDanyo(5)
                if (vida1 != bat1.pokemon1.currentHP) {
                    vida1 = bat1.pokemon1.currentHP
                }
                if (vida1 < bat1.pokemon1.hp * 0.5) {
                    coloVIda = Color(0xffFFFF00)
                }
                if (vida1 < bat1.pokemon1.hp * 0.2) {
                    coloVIda = Color(0xffD50000)
                }
            }) {
            Text("DAÑO")
        }
        Button(modifier = Modifier.offset(320.dp, 200.dp),
            onClick = {
                bat1.pokemon1.curar(5)
                if (vida1 != bat1.pokemon1.currentHP) {
                    vida1 = bat1.pokemon1.currentHP
                }
                if (vida1 > bat1.pokemon1.hp * 0.5) {
                    coloVIda = verde
                }
            }) { Text("CURAR")
        }}










