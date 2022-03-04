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
    Box(){
        Image(
            modifier = Modifier.fillMaxWidth().fillMaxHeight().offset(0.dp,-100.dp),
            painter = painterResource("hall.png"),
            contentDescription = "descripcion"
        )
        Text(modifier = Modifier.offset(15.dp, 0.dp),
            fontSize = 15.sp,
            text = "HA GANADO ${pokemon.name.uppercase()}",
            color = Color.White
        )
    }
    Image(
        modifier = Modifier.offset(110.dp,80.dp),
        painter = painterResource("${pokemon.name}1.png"),
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