import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.LinearProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
@Composable
fun pantalla3(cambiarPantalla:(Int)->Unit){
    var minipantalla by remember { mutableStateOf(0) }
    var coloVIda by remember { mutableStateOf(verde) }
    var coloVIda2 by remember { mutableStateOf(verde) }
    var vida1 by remember { mutableStateOf(bat1.pokemon2.currentHP) }
    var vida2 by remember { mutableStateOf(bat1.pokemon1.currentHP) }
    var nombe by remember { mutableStateOf(bat1.pokemon2.name) }
    var nombe2 = bat1.pokemon1.name
    var contador by remember { mutableStateOf(1) }
    val pantallaAccion:(Int)->Unit = {minipantalla = it}
    val actualizarVida:(Int)->Unit = {vida1 = it }
    val actualizarVida2:(Int)->Unit = {vida2 = it}
    val bloquearPantalla:(Int)->Unit = {contador = it}
    when(minipantalla){
        3->pantallaMovimientos2(bloquearPantalla,actualizarVida2,actualizarVida,cambiarPantalla,pantallaAccion)
        4->pantallaObjetos2(bloquearPantalla,actualizarVida,cambiarPantalla)
    }


    if(vida1<bat1.pokemon2.hp*0.5){
        coloVIda = Color(0xffFFFF00)
    }
    if(vida1<bat1.pokemon2.hp*0.2){
        coloVIda = Color(0xffD50000)
    }
    if(vida2<bat1.pokemon1.hp*0.5){
        coloVIda2 = Color(0xffFFFF00)
    }
    if(vida2<bat1.pokemon1.hp*0.2){
        coloVIda2 = Color(0xffD50000)
    }
    Box(){
        Image(
            modifier = Modifier.fillMaxWidth().fillMaxHeight().offset(0.dp,-100.dp),
            painter = painterResource("CampoBatalla.png"),
            contentDescription = "descripcion"
        )
        LinearProgressIndicator(
            vida2.toFloat() / bat1.pokemon1.hp,
            modifier = Modifier.width(50.dp).height(5.dp)
                .offset(45.dp, 22.dp),
            color = coloVIda2
        )
        LinearProgressIndicator(
            vida1.toFloat() / bat1.pokemon2.hp,
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
            text = "$vida1/${bat1.pokemon2.hp}",
            fontSize = 10.sp
        )
        Text(modifier = Modifier.offset(10.dp, 5.dp),
            fontSize = 13.sp,
            text = bat1.pokemon1.name,
        )
        Text(modifier = Modifier.offset(140.dp, 75.dp),
            fontSize = 13.sp,
            text = bat1.pokemon2.name,
        )
    }
    Image(
        modifier = Modifier.size(width = 256.dp, height = 192.dp).offset(0.dp,-22.dp),
        painter = painterResource("${nombe}E.png"),
        contentDescription = "descripcion"
    )
    Image(
        modifier = Modifier.size(width = 256.dp, height = 192.dp).offset(0.dp,-25.dp),
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
            modifier = Modifier.offset(150.dp, 156.dp)
                .size(width = 90.dp, height = 64.dp),
            onClick = { minipantalla = 3 }, enabled = contador==1) {
            Text("Atacar" ,color = Color.White)
        }
        MaterialTheme(colorAmarillo) {
            Button(
                modifier = Modifier.offset(150.dp, 220.dp)
                    .size(width = 90.dp, height = 64.dp),
                onClick = { minipantalla = 4},
                enabled = contador==1) {
                Text("Usar Objeto")
            }
        }}
    MaterialTheme(colorAzul) {
        Button(
            modifier = Modifier.offset(150.dp, 284.dp)
                .size(width = 90.dp, height = 64.dp),
            onClick = {
                bat1.pokemon2.Evolucionar()
                if (bat1.pokemon2.name != nombe) {
                    nombe = "${bat1.pokemon2.name}"
                }
                if (bat1.pokemon2.currentHP != vida1) {
                    vida1 = bat1.pokemon2.currentHP
                }
                if (vida2 != bat1.pokemon1.currentHP) {
                    vida2 = bat1.pokemon1.currentHP
                }
                if (vida2 < bat1.pokemon1.hp * 0.5) {
                    coloVIda2 = Color(0xffFFFF00)
                }
                if (vida2 < bat1.pokemon1.hp * 0.2) {
                    coloVIda2 = Color(0xffD50000)
                }
                cambiarPantalla(2)
            },
        enabled = contador==1) {
            Text("Evolucionar")
        }
    }
    Image(
        modifier = Modifier.fillMaxWidth().height(192.dp).offset(0.dp,149.dp),
        painter = painterResource("CajaAcciones.png"),
        contentDescription = "descripcion"
    )

}