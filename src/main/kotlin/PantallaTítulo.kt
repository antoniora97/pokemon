import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch
import androidx.compose.runtime.*
import androidx.compose.ui.res.loadImageBitmap
import androidx.compose.ui.res.useResource
import kotlinx.coroutines.delay

@Composable
fun PantallaTitulo(cambiarPantalla:(Int)->Unit){
    val corutina = rememberCoroutineScope()
    var contador = 0
    var no by  remember { mutableStateOf(1) }
    corutina.launch { while(true){
        if(no==50){no=1}
        no++
        delay(10000L)
    }}
    Column(modifier = Modifier.size(width = 400.dp, height = 384.dp)
        .clickable { cambiarPantalla(1) },
        horizontalAlignment = Alignment.Start){
        }
        Image(modifier = Modifier.offset(55.dp, 185.dp),
            bitmap = useResource(""+no+".png"){ loadImageBitmap(it)},
            contentDescription = "descripcion")
        Image(modifier = Modifier.fillMaxWidth()
            .fillMaxHeight(),
            painter = painterResource("TitleScreen.png"),
            contentDescription = "descripcion")
    }
