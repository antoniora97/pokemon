import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun pantallaMovimientos(cambiarPantalla:(Int)->Unit,cambiarPantalla1:(Int)->Unit){
    var Borde1 = Color.Red
    var Borde2 = Color.Red
    var Borde3 = Color.Red
    var accion by remember { mutableStateOf(-1) }
    var pantallaSeleccionada2 by remember { mutableStateOf(0) }
    val cambiarPantalla2:(Int)->Unit = {pantallaSeleccionada2 = it}
    when(pantallaSeleccionada2){
        1->descripcionCombate(cambiarPantalla2,accion)
        2->Efecitividad(cambiarPantalla,accion)
    }
    when(bat1.pokemon1.movimientos[0].type){
        "Agua" -> Borde1 = Color.Blue
        "Fuego" -> Borde1 = Color.Red
        "Planta" -> Borde1 = Color.Green
        "Normal" -> Borde1 = Color.Gray
    }
    when(bat1.pokemon1.movimientos[1].type){
        "Agua" -> Borde2 = Color.Blue
        "Fuego" -> Borde2 = Color.Red
        "Planta" -> Borde2 = Color.Green
        "Normal" -> Borde2 = Color.Gray
    }
    when(bat1.pokemon1.movimientos[2].type){
        "Agua" -> Borde3 = Color.Blue
        "Fuego" -> Borde3 = Color.Red
        "Planta" -> Borde3 = Color.Green
        "Normal" -> Borde3 = Color.Gray
    }
    Column(modifier = Modifier.size(width = 400.dp, height = 384.dp),
        horizontalAlignment = Alignment.Start)
    {
        Box(
            modifier = Modifier.size(width = 256.dp, height = 192.dp)
        ) {
            Column(modifier = Modifier.size(width = 256.dp, height = 192.dp).offset(-2.dp,-42.dp),
                horizontalAlignment = Alignment.Start) {
                OutlinedButton(modifier = Modifier.offset(5.dp, 198.dp)
                    .size(width = 155.dp, height = 55.dp),
                    border = BorderStroke(
                        width = 2.dp,
                        brush = Brush.horizontalGradient(
                            listOf(
                                Borde1,
                                Borde1
                            )
                        )
                    ),
                    colors = ButtonDefaults.buttonColors(
                        backgroundColor = Color.LightGray
                    ),
                    shape = CutCornerShape(0),
                    onClick = {
                        accion = 0
                        bat1.ejecutarAccion(bat1.pokemon1,bat1.pokemon2,accion,0)
                        cambiarPantalla2(1)}


                ) {
                    Text(
                        "${bat1.pokemon1.movimientos[0].nombre}  ${bat1.pokemon1.movimientos[0].currentPP}/${bat1.pokemon1.movimientos[0].PP}\n ${bat1.pokemon1.movimientos[0].type}"
                                , color = Color.Black, fontSize = 10.sp, textAlign = TextAlign.Start
                    )
                }
                OutlinedButton(modifier = Modifier.offset(5.dp, 198.dp)
                    .size(width = 155.dp, height = 55.dp),
                    border = BorderStroke(
                        width = 2.dp,
                        brush = Brush.horizontalGradient(
                            listOf(
                                Borde2,
                                Borde2
                            )
                        )
                    ),
                    shape = CutCornerShape(0),
                    colors = ButtonDefaults.buttonColors(
                        backgroundColor = Color.LightGray
                    ),
                    onClick = {
                        accion = 1
                        bat1.ejecutarAccion(bat1.pokemon1,bat1.pokemon2,0,1)
                        cambiarPantalla2(1)}
                ) {
                    Text(
                        "${bat1.pokemon1.movimientos[1].nombre}  ${bat1.pokemon1.movimientos[1].currentPP}/${bat1.pokemon1.movimientos[1].PP}\n ${bat1.pokemon1.movimientos[1].type}"
                        ,color = Color.Black,fontSize = 10.sp, textAlign = TextAlign.Start
                    )
                }
                OutlinedButton(modifier = Modifier.offset(5.dp, 198.dp)
                    .size(width = 155.dp, height = 55.dp),
                    border = BorderStroke(
                        width = 2.dp,
                        brush = Brush.horizontalGradient(
                            listOf(
                                Borde3,
                                Borde3
                            )
                        )
                    ),
                    shape = CutCornerShape(0),
                    colors = ButtonDefaults.buttonColors(
                        backgroundColor = Color.LightGray
                    ),
                    onClick = {
                        accion = 2
                        bat1.ejecutarAccion(bat1.pokemon1,bat1.pokemon2,0,2)
                        cambiarPantalla2(1)}
                ) {
                    Text(
                        "${bat1.pokemon1.movimientos[2].nombre} ${bat1.pokemon1.movimientos[2].currentPP}/${bat1.pokemon1.movimientos[2].PP}\n ${bat1.pokemon1.movimientos[2].type}"
                        ,color = Color.Black,fontSize = 10.sp, textAlign = TextAlign.Start
                    )
                }
            }
        }
    }

}
@Composable
fun pantallaObjetos(cambiarPantalla:(Int)->Unit,cambiarPantalla1:(Int)->Unit){
    when (bat1.pokemon1.objetos.size) {
        1 -> pantallaObjetosSingular()
        2 -> pantallaObjetosMedia()
        3 -> pantallaObjetosCompleta()
        else -> Text("${bat1.pokemon1.name} no tiene objetos.",
            modifier = Modifier
                .offset(5.dp, 198.dp)
                .size(width = 155.dp, height = 55.dp))
    }
}
@Composable
fun pantallaObjetosSingular () {
    Column(modifier = Modifier.size(width = 400.dp, height = 384.dp),
        horizontalAlignment = Alignment.Start)
    {
        Box(
            modifier = Modifier.size(width = 256.dp, height = 192.dp)
        ) {
            Column(modifier = Modifier.size(width = 256.dp, height = 192.dp).offset(-2.dp,-42.dp),
                horizontalAlignment = Alignment.Start) {
                OutlinedButton(modifier = Modifier.offset(5.dp, 198.dp)
                    .size(width = 155.dp, height = 55.dp),
                    border = BorderStroke(
                        width = 2.dp,
                        brush = Brush.horizontalGradient(
                            listOf(
                                Color.Magenta,
                                Color.Magenta
                            )
                        )
                    ),
                    colors = ButtonDefaults.buttonColors(
                        backgroundColor = Color.LightGray
                    ),
                    shape = CutCornerShape(0),
                    onClick = { bat1.pokemon1.Evolucionar() }
                ) {
                    Text(
                        "${bat1.pokemon1.objetos[0].nombre}     ${bat1.pokemon1.objetos[0].salud}"
                        , color = Color.Black, fontSize = 10.sp, textAlign = TextAlign.Start
                    )
                }
            }
        }
    }
}
@Composable
fun pantallaObjetosMedia () {
    Column(modifier = Modifier.size(width = 400.dp, height = 384.dp),
        horizontalAlignment = Alignment.Start)
    {
        Box(
            modifier = Modifier.size(width = 256.dp, height = 192.dp)
        ) {
            Column(modifier = Modifier.size(width = 256.dp, height = 192.dp).offset(-2.dp,-42.dp),
                horizontalAlignment = Alignment.Start) {
                OutlinedButton(modifier = Modifier.offset(5.dp, 198.dp)
                    .size(width = 155.dp, height = 55.dp),
                    border = BorderStroke(
                        width = 2.dp,
                        brush = Brush.horizontalGradient(
                            listOf(
                                Color.Magenta,
                                Color.Magenta
                            )
                        )
                    ),
                    colors = ButtonDefaults.buttonColors(
                        backgroundColor = Color.LightGray
                    ),
                    shape = CutCornerShape(0),
                    onClick = { bat1.pokemon1.Evolucionar() }
                ) {
                    Text(
                        "${bat1.pokemon1.objetos[0].nombre}     ${bat1.pokemon1.objetos[0].salud}"
                        , color = Color.Black, fontSize = 10.sp, textAlign = TextAlign.Start
                    )
                }
                OutlinedButton(modifier = Modifier.offset(5.dp, 198.dp)
                    .size(width = 155.dp, height = 55.dp),
                    border = BorderStroke(
                        width = 2.dp,
                        brush = Brush.horizontalGradient(
                            listOf(
                                Color.Magenta,
                                Color.Magenta
                            )
                        )
                    ),
                    shape = CutCornerShape(0),
                    colors = ButtonDefaults.buttonColors(
                        backgroundColor = Color.LightGray
                    ),
                    onClick = { bat1.pokemon1.Evolucionar() }
                ) {
                    Text(
                        "${bat1.pokemon1.objetos[1].nombre}     ${bat1.pokemon1.objetos[1].salud}"
                        ,color = Color.Black,fontSize = 10.sp, textAlign = TextAlign.Start
                    )
                }
            }
        }
    }
}
@Composable
fun pantallaObjetosCompleta () {
    Column(modifier = Modifier.size(width = 400.dp, height = 384.dp),
        horizontalAlignment = Alignment.Start)
    {
        Box(
            modifier = Modifier.size(width = 256.dp, height = 192.dp)
        ) {
            Column(modifier = Modifier.size(width = 256.dp, height = 192.dp).offset(-2.dp,-42.dp),
                horizontalAlignment = Alignment.Start) {
                OutlinedButton(modifier = Modifier.offset(5.dp, 198.dp)
                    .size(width = 155.dp, height = 55.dp),
                    border = BorderStroke(
                        width = 2.dp,
                        brush = Brush.horizontalGradient(
                            listOf(
                                Color.Magenta,
                                Color.Magenta
                            )
                        )
                    ),
                    colors = ButtonDefaults.buttonColors(
                        backgroundColor = Color.LightGray
                    ),
                    shape = CutCornerShape(0),
                    onClick = { bat1.pokemon1.Evolucionar() }
                ) {
                    Text(
                        "${bat1.pokemon1.objetos[0].nombre}     ${bat1.pokemon1.objetos[0].salud}"
                        , color = Color.Black, fontSize = 10.sp, textAlign = TextAlign.Start
                    )
                }
                OutlinedButton(modifier = Modifier.offset(5.dp, 198.dp)
                    .size(width = 155.dp, height = 55.dp),
                    border = BorderStroke(
                        width = 2.dp,
                        brush = Brush.horizontalGradient(
                            listOf(
                                Color.Magenta,
                                Color.Magenta
                            )
                        )
                    ),
                    shape = CutCornerShape(0),
                    colors = ButtonDefaults.buttonColors(
                        backgroundColor = Color.LightGray
                    ),
                    onClick = { bat1.pokemon1.Evolucionar() }
                ) {
                    Text(
                        "${bat1.pokemon1.objetos[1].nombre}     ${bat1.pokemon1.objetos[1].salud}"
                        ,color = Color.Black,fontSize = 10.sp, textAlign = TextAlign.Start
                    )
                }
                OutlinedButton(modifier = Modifier.offset(5.dp, 198.dp)
                    .size(width = 155.dp, height = 55.dp),
                    border = BorderStroke(
                        width = 2.dp,
                        brush = Brush.horizontalGradient(
                            listOf(
                                Color.Magenta,
                                Color.Magenta
                            )
                        )
                    ),
                    shape = CutCornerShape(0),
                    colors = ButtonDefaults.buttonColors(
                        backgroundColor = Color.LightGray
                    ),
                    onClick = { bat1.pokemon1.Evolucionar() }
                ) {
                    Text(
                        "${bat1.pokemon1.objetos[2].nombre}     ${bat1.pokemon1.objetos[2].salud}"
                        ,color = Color.Black,fontSize = 10.sp, textAlign = TextAlign.Start
                    )
                }
            }
        }
    }
}
@Composable
fun pantallaMovimientos2(cambiarPantalla1:(Int)->Unit){
    var Borde1 = Color.Red
    var Borde2 = Color.Red
    var Borde3 = Color.Red
    var accion2 by remember { mutableStateOf(-1) }
    var pantallaSeleccionada3 by remember { mutableStateOf(0) }
    val cambiarPantalla3:(Int)->Unit = {pantallaSeleccionada3 = it}
    when(pantallaSeleccionada3){
        1->descripcionCombate2(cambiarPantalla3,accion2)
        2->Efecitividad2(cambiarPantalla3,accion2)
    }
    when(bat1.pokemon2.movimientos[0].type){
        "Agua" -> Borde1 = Color.Blue
        "Fuego" -> Borde1 = Color.Red
        "Planta" -> Borde1 = Color.Green
        "Normal" -> Borde1 = Color.Gray
    }
    when(bat1.pokemon2.movimientos[1].type){
        "Agua" -> Borde2 = Color.Blue
        "Fuego" -> Borde2 = Color.Red
        "Planta" -> Borde2 = Color.Green
        "Normal" -> Borde2 = Color.Gray
    }
    when(bat1.pokemon2.movimientos[2].type){
        "Agua" -> Borde3 = Color.Blue
        "Fuego" -> Borde3 = Color.Red
        "Planta" -> Borde3 = Color.Green
        "Normal" -> Borde3 = Color.Gray
    }
    Column(modifier = Modifier.size(width = 400.dp, height = 384.dp),
        horizontalAlignment = Alignment.Start)
    {
        Box(
            modifier = Modifier.size(width = 256.dp, height = 192.dp)
        ) {
            Column(modifier = Modifier.size(width = 256.dp, height = 192.dp).offset(-2.dp,-42.dp),
                horizontalAlignment = Alignment.Start) {
                OutlinedButton(modifier = Modifier.offset(5.dp, 198.dp)
                    .size(width = 155.dp, height = 55.dp),
                    border = BorderStroke(
                        width = 2.dp,
                        brush = Brush.horizontalGradient(
                            listOf(
                                Borde1,
                                Borde1
                            )
                        )
                    ),
                    colors = ButtonDefaults.buttonColors(
                        backgroundColor = Color.LightGray
                    ),
                    shape = CutCornerShape(0),
                    onClick = {
                        accion2 = 0
                        bat1.ejecutarAccion(bat1.pokemon1,bat1.pokemon2,accion2,0)
                        cambiarPantalla3(1)}


                ) {
                    Text(
                        "${bat1.pokemon2.movimientos[0].nombre}  ${bat1.pokemon2.movimientos[0].currentPP}/${bat1.pokemon2.movimientos[0].PP}\n ${bat1.pokemon2.movimientos[0].type}"
                        , color = Color.Black, fontSize = 10.sp, textAlign = TextAlign.Start
                    )
                }
                OutlinedButton(modifier = Modifier.offset(5.dp, 198.dp)
                    .size(width = 155.dp, height = 55.dp),
                    border = BorderStroke(
                        width = 2.dp,
                        brush = Brush.horizontalGradient(
                            listOf(
                                Borde2,
                                Borde2
                            )
                        )
                    ),
                    shape = CutCornerShape(0),
                    colors = ButtonDefaults.buttonColors(
                        backgroundColor = Color.LightGray
                    ),
                    onClick = {
                        accion2 = 1
                        bat1.ejecutarAccion(bat1.pokemon2,bat1.pokemon1,0,1)
                        cambiarPantalla3(1)}
                ) {
                    Text(
                        "${bat1.pokemon2.movimientos[1].nombre}  ${bat1.pokemon2.movimientos[1].currentPP}/${bat1.pokemon2.movimientos[1].PP}\n ${bat1.pokemon2.movimientos[1].type}"
                        ,color = Color.Black,fontSize = 10.sp, textAlign = TextAlign.Start
                    )
                }
                OutlinedButton(modifier = Modifier.offset(5.dp, 198.dp)
                    .size(width = 155.dp, height = 55.dp),
                    border = BorderStroke(
                        width = 2.dp,
                        brush = Brush.horizontalGradient(
                            listOf(
                                Borde3,
                                Borde3
                            )
                        )
                    ),
                    shape = CutCornerShape(0),
                    colors = ButtonDefaults.buttonColors(
                        backgroundColor = Color.LightGray
                    ),
                    onClick = {
                        accion2 = 2
                        bat1.ejecutarAccion(bat1.pokemon2,bat1.pokemon1,0,2)
                        cambiarPantalla3(1)}
                ) {
                    Text(
                        "${bat1.pokemon2.movimientos[2].nombre} ${bat1.pokemon2.movimientos[2].currentPP}/${bat1.pokemon2.movimientos[2].PP}\n ${bat1.pokemon2.movimientos[2].type}"
                        ,color = Color.Black,fontSize = 10.sp, textAlign = TextAlign.Start
                    )
                }
            }
        }
    }
}
@Composable
fun pantallaObjetos2(cambiarPantalla1:(Int)->Unit){
    when (bat1.pokemon2.objetos.size) {
        1 -> pantallaObjetosSingular2()
        2 -> pantallaObjetosMedia2()
        3 -> pantallaObjetosCompleta2()
        else -> Text("${bat1.pokemon2.name} no tiene objetos.",
            modifier = Modifier
                .offset(5.dp, 198.dp)
                .size(width = 155.dp, height = 55.dp))
    }
}
@Composable
fun pantallaObjetosSingular2 () {
    Column(modifier = Modifier.size(width = 400.dp, height = 384.dp),
        horizontalAlignment = Alignment.Start)
    {
        Box(
            modifier = Modifier.size(width = 256.dp, height = 192.dp)
        ) {
            Column(modifier = Modifier.size(width = 256.dp, height = 192.dp).offset(-2.dp,-42.dp),
                horizontalAlignment = Alignment.Start) {
                OutlinedButton(modifier = Modifier.offset(5.dp, 198.dp)
                    .size(width = 155.dp, height = 55.dp),
                    border = BorderStroke(
                        width = 2.dp,
                        brush = Brush.horizontalGradient(
                            listOf(
                                Color.Magenta,
                                Color.Magenta
                            )
                        )
                    ),
                    colors = ButtonDefaults.buttonColors(
                        backgroundColor = Color.LightGray
                    ),
                    shape = CutCornerShape(0),
                    onClick = { bat1.pokemon2.Evolucionar() }
                ) {
                    Text(
                        "${bat1.pokemon2.objetos[0].nombre}     ${bat1.pokemon2.objetos[0].salud}"
                        , color = Color.Black, fontSize = 10.sp, textAlign = TextAlign.Start
                    )
                }
            }
        }
    }
}
@Composable
fun pantallaObjetosMedia2 () {
    Column(modifier = Modifier.size(width = 400.dp, height = 384.dp),
        horizontalAlignment = Alignment.Start)
    {
        Box(
            modifier = Modifier.size(width = 256.dp, height = 192.dp)
        ) {
            Column(modifier = Modifier.size(width = 256.dp, height = 192.dp).offset(-2.dp,-42.dp),
                horizontalAlignment = Alignment.Start) {
                OutlinedButton(modifier = Modifier.offset(5.dp, 198.dp)
                    .size(width = 155.dp, height = 55.dp),
                    border = BorderStroke(
                        width = 2.dp,
                        brush = Brush.horizontalGradient(
                            listOf(
                                Color.Magenta,
                                Color.Magenta
                            )
                        )
                    ),
                    colors = ButtonDefaults.buttonColors(
                        backgroundColor = Color.LightGray
                    ),
                    shape = CutCornerShape(0),
                    onClick = { bat1.pokemon2.Evolucionar() }
                ) {
                    Text(
                        "${bat1.pokemon2.objetos[0].nombre}     ${bat1.pokemon2.objetos[0].salud}"
                        , color = Color.Black, fontSize = 10.sp, textAlign = TextAlign.Start
                    )
                }
                OutlinedButton(modifier = Modifier.offset(5.dp, 198.dp)
                    .size(width = 155.dp, height = 55.dp),
                    border = BorderStroke(
                        width = 2.dp,
                        brush = Brush.horizontalGradient(
                            listOf(
                                Color.Magenta,
                                Color.Magenta
                            )
                        )
                    ),
                    shape = CutCornerShape(0),
                    colors = ButtonDefaults.buttonColors(
                        backgroundColor = Color.LightGray
                    ),
                    onClick = { bat1.pokemon2.Evolucionar() }
                ) {
                    Text(
                        "${bat1.pokemon2.objetos[1].nombre}     ${bat1.pokemon2.objetos[1].salud}"
                        ,color = Color.Black,fontSize = 10.sp, textAlign = TextAlign.Start
                    )
                }
            }
        }
    }
}
@Composable
fun pantallaObjetosCompleta2 () {
    Column(modifier = Modifier.size(width = 400.dp, height = 384.dp),
        horizontalAlignment = Alignment.Start)
    {
        Box(
            modifier = Modifier.size(width = 256.dp, height = 192.dp)
        ) {
            Column(modifier = Modifier.size(width = 256.dp, height = 192.dp).offset(-2.dp,-42.dp),
                horizontalAlignment = Alignment.Start) {
                OutlinedButton(modifier = Modifier.offset(5.dp, 198.dp)
                    .size(width = 155.dp, height = 55.dp),
                    border = BorderStroke(
                        width = 2.dp,
                        brush = Brush.horizontalGradient(
                            listOf(
                                Color.Magenta,
                                Color.Magenta
                            )
                        )
                    ),
                    colors = ButtonDefaults.buttonColors(
                        backgroundColor = Color.LightGray
                    ),
                    shape = CutCornerShape(0),
                    onClick = { bat1.pokemon2.Evolucionar() }
                ) {
                    Text(
                        "${bat1.pokemon2.objetos[0].nombre}     ${bat1.pokemon2.objetos[0].salud}"
                        , color = Color.Black, fontSize = 10.sp, textAlign = TextAlign.Start
                    )
                }
                OutlinedButton(modifier = Modifier.offset(5.dp, 198.dp)
                    .size(width = 155.dp, height = 55.dp),
                    border = BorderStroke(
                        width = 2.dp,
                        brush = Brush.horizontalGradient(
                            listOf(
                                Color.Magenta,
                                Color.Magenta
                            )
                        )
                    ),
                    shape = CutCornerShape(0),
                    colors = ButtonDefaults.buttonColors(
                        backgroundColor = Color.LightGray
                    ),
                    onClick = { bat1.pokemon2.Evolucionar() }
                ) {
                    Text(
                        "${bat1.pokemon2.objetos[1].nombre}     ${bat1.pokemon2.objetos[1].salud}"
                        ,color = Color.Black,fontSize = 10.sp, textAlign = TextAlign.Start
                    )
                }
                OutlinedButton(modifier = Modifier.offset(5.dp, 198.dp)
                    .size(width = 155.dp, height = 55.dp),
                    border = BorderStroke(
                        width = 2.dp,
                        brush = Brush.horizontalGradient(
                            listOf(
                                Color.Magenta,
                                Color.Magenta
                            )
                        )
                    ),
                    shape = CutCornerShape(0),
                    colors = ButtonDefaults.buttonColors(
                        backgroundColor = Color.LightGray
                    ),
                    onClick = { bat1.pokemon2.Evolucionar() }
                ) {
                    Text(
                        "${bat1.pokemon2.objetos[2].nombre}     ${bat1.pokemon2.objetos[2].salud}"
                        ,color = Color.Black,fontSize = 10.sp, textAlign = TextAlign.Start
                    )
                }
            }
        }}}
        @Composable
        fun descripcionCombate(cambiarPantalla2:(Int)->Unit,accion:Int){
            Column(modifier = Modifier.size(256.dp,30.dp).offset(15.dp,115.dp).clickable { cambiarPantalla2(2) }){
              Text("${bat1.pokemon1.name} usó ${bat1.pokemon1.movimientos[accion].nombre}",color = Color.Black,fontSize = 10.sp)}
              if (bat1.pokemon1.movimientos[accion].efecto!=0){
                  Column(modifier = Modifier.size(256.dp,30.dp).offset(135.dp,115.dp)){
                  when(bat1.pokemon1.movimientos[accion].efecto){
                      1 -> Text("${bat1.pokemon1.name} se ha sumergido",color = Color.Black,fontSize = 10.sp, modifier = Modifier.offset(-120.dp,10.dp))
                      2 -> Text("${bat1.pokemon2.name} se ha quemado",color = Color.Black,fontSize = 10.sp, modifier = Modifier.offset(-120.dp,10.dp))
                      3 -> {Text("${bat1.pokemon1.name} ha absorbido vida a ${bat1.pokemon2.name}",color = Color.Black,fontSize = 10.sp,modifier = Modifier.offset(-120.dp,10.dp))
                  }}
              }
            }
        }

        @Composable
        fun descripcionCombate2(cambiarPantalla3:(Int)->Unit,accion:Int){
            Column(modifier = Modifier.size(256.dp,30.dp).offset(15.dp,115.dp).clickable { cambiarPantalla3(2) }){
            Text("${bat1.pokemon2.name} usó ${bat1.pokemon2.movimientos[accion].nombre}",color = Color.Black,fontSize = 10.sp)}
            if (bat1.pokemon2.movimientos[accion].efecto!=0){
                Column(modifier = Modifier.size(256.dp,30.dp).offset(135.dp,115.dp)){
                    when(bat1.pokemon2.movimientos[accion].efecto){
                        1 -> Text("${bat1.pokemon2.name} se ha sumergido",color = Color.Black,fontSize = 10.sp, modifier = Modifier.offset(-120.dp,10.dp))
                        2 -> Text("${bat1.pokemon1.name} se ha quemado",color = Color.Black,fontSize = 10.sp, modifier = Modifier.offset(-120.dp,10.dp))
                        3 -> {Text("${bat1.pokemon2.name} ha absorbido vida a ${bat1.pokemon1.name}",color = Color.Black,fontSize = 10.sp,modifier = Modifier.offset(-120.dp,10.dp))
                        }}
                }
            }
        }
        @Composable
        fun Efecitividad(cambiarPantalla:(Int)->Unit,accion:Int){
            Row(modifier = Modifier.size(256.dp,100.dp).offset(10.dp,125.dp).clickable { cambiarPantalla(3) })
            {
                if (bat1.ComprobarEfectividad(bat1.pokemon1.movimientos[accion].type, bat1.pokemon2.Type()) == 2.0) {
                    Text(
                        "Ha sido muy eficaz!!",
                        color = Color.Black,
                        fontSize = 10.sp,
                        textAlign = TextAlign.Start)
                }
                if (bat1.ComprobarEfectividad(bat1.pokemon1.movimientos[accion].type, bat1.pokemon2.Type()) == 0.5) {
                    Text(
                        "Ha sido poco eficaz...",
                        color = Color.Black,
                        fontSize = 10.sp,
                        textAlign = TextAlign.Start,
                    )
                }
            }
        }
        @Composable
        fun Efecitividad2(cambiarPantalla:(Int)->Unit,accion:Int){
            Row(modifier = Modifier.size(256.dp,100.dp).offset(10.dp,125.dp).clickable { cambiarPantalla(2) })
            {
                if (bat1.ComprobarEfectividad(bat1.pokemon2.movimientos[accion].type, bat1.pokemon1.Type()) == 2.0) {
                    Text(
                        "Ha sido muy eficaz!!",
                        color = Color.Black,
                        fontSize = 10.sp,
                        textAlign = TextAlign.Start,
                    )
                }
                if (bat1.ComprobarEfectividad(bat1.pokemon2.movimientos[accion].type, bat1.pokemon1.Type()) == 0.5) {
                    Text(
                        "Ha sido poco eficaz...",
                        color = Color.Black,
                        fontSize = 10.sp,
                        textAlign = TextAlign.Start,
                    )
                }
            }
        }



