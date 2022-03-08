import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch


@Composable
fun pantalla2(cambiarPantalla:(Int)->Unit){
    var contador by remember { mutableStateOf(1) }
    var coloVIda by remember { mutableStateOf(verde) }
    var coloVIda2 by remember { mutableStateOf(verde) }
    var vida1 by remember { mutableStateOf(bat1.pokemon1.currentHP) }
    var vida2 by remember { mutableStateOf(bat1.pokemon2.currentHP) }
    var nombe by remember { mutableStateOf(bat1.pokemon1.name) }
    var nombe2 = bat1.pokemon2.name
    var minipantalla by remember { mutableStateOf(0) }
    val PantallaAccion:(Int)->Unit = {minipantalla = it}
    val actualizarVida:(Int)->Unit = {vida1 = it }
    val actualizarVida2:(Int)->Unit = {vida2 = it }
    val bloquearPantalla:(Int)->Unit = {contador = it}
    val rutinatotodile = rememberCoroutineScope()
    var animacion by remember { mutableStateOf(1) }
    if (bat1.pokemon2.name=="Totodile"){
        rutinatotodile.launch { while(true){
            delay(60L)
            if(animacion==66){animacion=1}
            animacion++
            delay(1000000000L)
        } }
    }
    if (bat1.pokemon2.name=="Croconaw"){
        rutinatotodile.launch { while(true){
            delay(60L)
            if(animacion==388){animacion=1}
            animacion++
            delay(1000000000L)
        } }
    }
    if (bat1.pokemon2.name=="Feraligatr"){
        rutinatotodile.launch { while(true){
            delay(60L)
            if(animacion==71){animacion=1}
            animacion++
            delay(1000000000L)
        } }
    }
    if (bat1.pokemon2.name=="Chikorita"){
        rutinatotodile.launch { while(true){
            delay(60L)
            if(animacion==24){animacion=1}
            animacion++
            delay(1000000000L)
        } }
    }
    if (bat1.pokemon2.name=="Bayleef"){
        rutinatotodile.launch { while(true){
            delay(60L)
            if(animacion==62){animacion=1}
            animacion++
            delay(1000000000L)
        } }
    }
    if (bat1.pokemon2.name=="Meganium"){
        rutinatotodile.launch { while(true){
            delay(60L)
            if(animacion==108){animacion=1}
            animacion++
            delay(1000000000L)
        } }
    }
    if (bat1.pokemon2.name=="Cyndaquil"){
        rutinatotodile.launch { while(true){
            delay(60L)
            if(animacion==89){animacion=1}
            animacion++
            delay(1000000000L)
        } }
    }
    if (bat1.pokemon2.name=="Quilava"){
        rutinatotodile.launch { while(true){
            delay(60L)
            if(animacion==146){animacion=1}
            animacion++
            delay(1000000000L)
        } }
    }
    if (bat1.pokemon2.name=="Typhlosion"){
        rutinatotodile.launch { while(true){
            delay(60L)
            if(animacion==250){animacion=1}
            animacion++
            delay(1000000000L)
        } }
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
    when(minipantalla){
        1->pantallaMovimientos(bloquearPantalla,actualizarVida2,actualizarVida,cambiarPantalla,PantallaAccion)
        2->pantallaObjetos(bloquearPantalla,actualizarVida,cambiarPantalla)
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
            modifier = Modifier.size(width = 256.dp, height = 192.dp).offset(0.dp,-25.dp),
            painter = painterResource("TextoCombate.png"),
            contentDescription = "descripcion"
        )
        Image(
            modifier = Modifier.offset(125.dp,5.dp),
            painter = painterResource("${nombe2} ($animacion).png"),
            contentDescription = "descripcion"
        )
    MaterialTheme(colorRojo) {
        Button(
            modifier = Modifier.offset(150.dp, 156.dp)
                .size(width = 90.dp, height = 64.dp),
            onClick = { minipantalla = 1 },
            enabled = contador == 1)
            { Text("Atacar" ,color = Color.White) }
        MaterialTheme(colorAmarillo) {
            Button(
                modifier = Modifier.offset(150.dp, 220.dp)
                    .size(width = 90.dp, height = 64.dp),
                onClick = { minipantalla = 2  },
                enabled = contador == 1 && bat1.pokemon1.objetos1.size>0) {
                Text("Usar Objeto")
            }
        }}
        MaterialTheme(colorAzul) {
            Button(
                modifier = Modifier.offset(150.dp, 284.dp)
                    .size(width = 90.dp, height = 64.dp),
                onClick = {
                    bat1.pokemon1.Evolucionar()
                    if (bat1.pokemon1.name != nombe) {
                        nombe = bat1.pokemon1.name
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
                    if (bat1.pokemon2.estado==1) {
                        bat1.pokemon2.evasion-=95
                    }
                    cambiarPantalla(3)
                },
                        enabled = contador == 1) {
                Text("Evolucionar")
            }
        }
    Image(
        modifier = Modifier.fillMaxWidth().height(192.dp).offset(0.dp,149.dp),
        painter = painterResource("CajaAcciones.png"),
        contentDescription = "descripcion"
    )
        }










