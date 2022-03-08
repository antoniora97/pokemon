import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Composable
fun pantallaFinal(pokemon:Pokemon){
    var contador by  remember { mutableStateOf(1) }
    var corutina = rememberCoroutineScope()
    corutina.launch { while(true){
        delay(40L)
        if(contador==24){contador=1}
        contador++
        delay(10000L)
    }}
    val rutina = rememberCoroutineScope()
    var animacion by remember { mutableStateOf(1) }
    if (pokemon.name=="Totodile"){
        rutina.launch { while(true){
            delay(60L)
            if(animacion==66){animacion=1}
            animacion++
            delay(1000000000L)
        } }
    }
    if (pokemon.name=="Croconaw"){
        rutina.launch { while(true){
            delay(60L)
            if(animacion==388){animacion=1}
            animacion++
            delay(1000000000L)
        } }
    }
    if (pokemon.name=="Feraligatr"){
        rutina.launch { while(true){
            delay(60L)
            if(animacion==71){animacion=1}
            animacion++
            delay(1000000000L)
        } }
    }
    if (pokemon.name=="Chikorita"){
        rutina.launch { while(true){
            delay(60L)
            if(animacion==24){animacion=1}
            animacion++
            delay(1000000000L)
        } }
    }
    if (pokemon.name=="Bayleef"){
        rutina.launch { while(true){
            delay(60L)
            if(animacion==62){animacion=1}
            animacion++
            delay(1000000000L)
        } }
    }
    if (pokemon.name=="Meganium"){
        rutina.launch { while(true){
            delay(60L)
            if(animacion==108){animacion=1}
            animacion++
            delay(1000000000L)
        } }
    }
    if (pokemon.name=="Cyndaquil"){
        rutina.launch { while(true){
            delay(60L)
            if(animacion==89){animacion=1}
            animacion++
            delay(1000000000L)
        } }
    }
    if (pokemon.name=="Quilava"){
        rutina.launch { while(true){
            delay(60L)
            if(animacion==146){animacion=1}
            animacion++
            delay(1000000000L)
        } }
    }
    if (pokemon.name=="Typhlosion"){
        rutina.launch { while(true){
            delay(60L)
            if(animacion==250){animacion=1}
            animacion++
            delay(1000000000L)
        } }
    }
    Box(){
        Image(
            modifier = Modifier.fillMaxWidth().fillMaxHeight().offset(0.dp,-100.dp),
            painter = painterResource("hall.png"),
            contentDescription = "descripcion"
        )
        Text(modifier = Modifier.offset(30.dp, 0.dp),
            fontSize = 15.sp,
            text = "HA GANADO ${pokemon.name.uppercase()}",
            color = Color.White
        )
    }
    Image(
        modifier = Modifier.offset(90.dp,50.dp),
        painter = painterResource("${pokemon.name.lowercase()} ($animacion).png"),
        contentDescription = "descripcion"
    )
    Image(
        modifier = Modifier.fillMaxWidth().height(192.dp).offset(0.dp,149.dp),
        painter = painterResource("Creditos.png"),
        contentDescription = "descripcion"
    )
    Image(
        modifier = Modifier.size(70.dp,70.dp).offset(160.dp,263.dp),
        painter = painterResource("pikachu$contador.png"),
        contentDescription = "descripcion"
    )
}
@Composable
fun pantallaFinal2(pokemon:Pokemon){
    var contador by  remember { mutableStateOf(1) }
    var corutina = rememberCoroutineScope()
    corutina.launch { while(true){
        delay(40L)
        if(contador==24){contador=1}
        contador++
        delay(10000L)
    }}
    val rutina = rememberCoroutineScope()
    var animacion by remember { mutableStateOf(1) }
    if (pokemon.name=="Totodile"){
        rutina.launch { while(true){
            delay(60L)
            if(animacion==66){animacion=1}
            animacion++
            delay(1000000000L)
        } }
    }
    if (pokemon.name=="Croconaw"){
        rutina.launch { while(true){
            delay(60L)
            if(animacion==388){animacion=1}
            animacion++
            delay(1000000000L)
        } }
    }
    if (pokemon.name=="Feraligatr"){
        rutina.launch { while(true){
            delay(60L)
            if(animacion==71){animacion=1}
            animacion++
            delay(1000000000L)
        } }
    }
    if (pokemon.name=="Chikorita"){
        rutina.launch { while(true){
            delay(60L)
            if(animacion==24){animacion=1}
            animacion++
            delay(1000000000L)
        } }
    }
    if (pokemon.name=="Bayleef"){
        rutina.launch { while(true){
            delay(60L)
            if(animacion==62){animacion=1}
            animacion++
            delay(1000000000L)
        } }
    }
    if (pokemon.name=="Meganium"){
        rutina.launch { while(true){
            delay(60L)
            if(animacion==108){animacion=1}
            animacion++
            delay(1000000000L)
        } }
    }
    if (pokemon.name=="Cyndaquil"){
        rutina.launch { while(true){
            delay(60L)
            if(animacion==89){animacion=1}
            animacion++
            delay(1000000000L)
        } }
    }
    if (pokemon.name=="Quilava"){
        rutina.launch { while(true){
            delay(60L)
            if(animacion==146){animacion=1}
            animacion++
            delay(1000000000L)
        } }
    }
    if (pokemon.name=="Typhlosion"){
        rutina.launch { while(true){
            delay(60L)
            if(animacion==250){animacion=1}
            animacion++
            delay(1000000000L)
        } }
    }
    Box(){
        Image(
            modifier = Modifier.fillMaxWidth().fillMaxHeight().offset(0.dp,-100.dp),
            painter = painterResource("hall.png"),
            contentDescription = "descripcion"
        )
        Text(modifier = Modifier.offset(30.dp, 0.dp),
            fontSize = 15.sp,
            text = "HA GANADO ${pokemon.name.uppercase()}",
            color = Color.White
        )
    }
    Image(
        modifier = Modifier.offset(90.dp,50.dp),
        painter = painterResource("${pokemon.name.lowercase()} ($animacion).png"),
        contentDescription = "descripcion"
    )
    Image(
        modifier = Modifier.fillMaxWidth().height(192.dp).offset(0.dp,149.dp),
        painter = painterResource("Creditos.png"),
        contentDescription = "descripcion"
    )
    Image(
        modifier = Modifier.size(70.dp,70.dp).offset(160.dp,263.dp),
        painter = painterResource("pikachu$contador.png"),
        contentDescription = "descripcion"
    )
}