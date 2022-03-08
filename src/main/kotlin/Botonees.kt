import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown

@Composable
fun pantallaMovimientos(bloquearPantalla:(Int)->Unit,actualizarVida2:(Int)->Unit,actualizarVida:(Int)->Unit,cambiarPantalla:(Int)->Unit,cambiarPantalla1:(Int)->Unit){
    var Borde1 = Color.Red
    var Borde2 = Color.Red
    var Borde3 = Color.Red
    var pp1:Int by remember { mutableStateOf(bat1.pokemon1.movimientos[0].currentPP) }
    var pp2:Int by remember { mutableStateOf(bat1.pokemon1.movimientos[1].currentPP) }
    var pp3:Int by remember { mutableStateOf(bat1.pokemon1.movimientos[2].currentPP) }
    var accion by remember { mutableStateOf(-1) }
    var pantallaSeleccionada2 by remember { mutableStateOf(0) }
    val cambiarPantalla2:(Int)->Unit = {pantallaSeleccionada2 = it}
    val actualizarPP1:(Int)->Unit = { pp1= it}
    val actualizarPP2:(Int)->Unit = { pp2= it}
    val actualizarPP3:(Int)->Unit = { pp3= it}
    var acierto:Int by remember { mutableStateOf(0) }
    val actualizarAcierto:(Int)->Unit = { acierto= it}
    var contador by remember { mutableStateOf(1) }
    val bloquearPantalla2:(Int)->Unit = {contador = it}


    when(pantallaSeleccionada2){
        1->descripcionCombate(cambiarPantalla2,accion,acierto)
        2->Efectividad(cambiarPantalla2,cambiarPantalla,accion)
        3->Debilitado(cambiarPantalla)
        4->Fallo(cambiarPantalla)
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
                OutlinedButton(modifier = Modifier.offset(5.dp, 200.dp)
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
                        actualizarAcierto(bat1.ejecutarAccion(bat1.pokemon1,bat1.pokemon2,accion,0))
                        cambiarPantalla2(1)
                        actualizarVida2(bat1.pokemon2.currentHP)
                        actualizarPP1(bat1.pokemon1.movimientos[0].currentPP)
                        bloquearPantalla(0)
                        bloquearPantalla2(0) } ,
                enabled = contador==1
                ) {
                    Text(
                        "${bat1.pokemon1.movimientos[0].nombre}  $pp1/${bat1.pokemon1.movimientos[0].PP}\n ${bat1.pokemon1.movimientos[0].type}"
                                , color = Color.Black, fontSize = 10.sp, textAlign = TextAlign.Start
                    )
                }
                OutlinedButton(modifier = Modifier.offset(5.dp, 200.dp)
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
                        actualizarAcierto(bat1.ejecutarAccion(bat1.pokemon1,bat1.pokemon2,0,1))
                        cambiarPantalla2(1)
                        actualizarVida2(bat1.pokemon2.currentHP)
                        actualizarPP2(bat1.pokemon1.movimientos[1].currentPP)
                        bloquearPantalla2(0)
                        bloquearPantalla(0) }
                    ,
                    enabled = contador==1
                ) {
                    Text(
                        "${bat1.pokemon1.movimientos[1].nombre}  $pp2/${bat1.pokemon1.movimientos[1].PP}\n ${bat1.pokemon1.movimientos[1].type}"
                        ,color = Color.Black,fontSize = 10.sp, textAlign = TextAlign.Start
                    )
                }
                OutlinedButton(modifier = Modifier.offset(5.dp, 200.dp)
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
                        actualizarAcierto(bat1.ejecutarAccion(bat1.pokemon1,bat1.pokemon2,0,2))
                        cambiarPantalla2(1)
                        actualizarVida2(bat1.pokemon2.currentHP)
                        actualizarPP3(bat1.pokemon1.movimientos[2].currentPP)
                        bloquearPantalla(0)
                        bloquearPantalla2(0) },
                    enabled = contador==1
                ) {
                    Text(
                        "${bat1.pokemon1.movimientos[2].nombre} $pp3/${bat1.pokemon1.movimientos[2].PP}\n ${bat1.pokemon1.movimientos[2].type}"
                        ,color = Color.Black,fontSize = 10.sp, textAlign = TextAlign.Start
                    )
                }
            }
        }
    }

}
@Composable
fun pantallaObjetos(bloquearPantalla:(Int)->Unit,actualizarVida:(Int)->Unit,cambiarPantalla:(Int)->Unit){
    var bolsa by remember { mutableStateOf(bat1.pokemon1.objetos1.size) }
    val cambiarPantallaObj:(Int)->Unit = {bolsa = it}
    var objetoUsado by remember { mutableStateOf(0) }
    val seleccionarObjeto:(Int)->Unit = {objetoUsado = it}
    when (objetoUsado){
        1->usoObjeto(actualizarVida,cambiarPantalla,0)
        2->usoObjeto(actualizarVida,cambiarPantalla,1)
        3->usoObjeto(actualizarVida,cambiarPantalla,2)
    }

    when (bolsa) {
        1 -> pantallaObjetosSingular(seleccionarObjeto,cambiarPantallaObj,bloqueo,bloquearPantalla)
        2 -> pantallaObjetosMedia(seleccionarObjeto,cambiarPantallaObj,bloqueo,bloquearPantalla)
        3 ->  pantallaObjetosCompleta(seleccionarObjeto,cambiarPantallaObj,bloqueo,bloquearPantalla)
        else -> Text("${bat1.pokemon1.name} no tiene objetos.",
            modifier = Modifier
                .offset(5.dp, 198.dp)
                .size(width = 155.dp, height = 55.dp))
    }
}
@Composable
fun pantallaObjetosSingular (seleccionarObjeto:(Int)->Unit,cambiarPantallaObj:(Int)->Unit,bloqueo:Bloqueo,bloquearPantalla:(Int)->Unit) {
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
                    onClick = {
                        bloquearPantalla(0)
                        seleccionarObjeto(1)
                        cambiarPantallaObj(0)
                        },
                    enabled = bloqueo.bloqueo1==true
                ) {
                    Text(
                        "${bat1.pokemon1.objetos1[0].nombre}     ${bat1.pokemon1.objetos1[0].salud}"
                        , color = Color.Black, fontSize = 10.sp, textAlign = TextAlign.Start
                    )
                }
            }
        }
    }
}
@Composable
fun pantallaObjetosMedia (seleccionarObjeto:(Int)->Unit,cambiarPantallaObj:(Int)->Unit,bloqueo:Bloqueo,bloquearPantalla:(Int)->Unit) {
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
                    onClick = {
                        bloquearPantalla(0)
                        cambiarPantallaObj(1)
                        bloqueo.bloqueo1=false
                        seleccionarObjeto(1)
                        },
                    enabled = bloqueo.bloqueo1==true

                ) {
                    Text(
                        "${bat1.pokemon1.objetos1[0].nombre}     ${bat1.pokemon1.objetos1[0].salud}"
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
                    onClick = {
                        bloquearPantalla(0)
                        cambiarPantallaObj(1)
                        bloqueo.bloqueo1=false
                        seleccionarObjeto(2)

                        },
                    enabled = bloqueo.bloqueo1==true
                ) {
                    Text(
                        "${bat1.pokemon1.objetos1[1].nombre}     ${bat1.pokemon1.objetos1[1].salud}"
                        ,color = Color.Black,fontSize = 10.sp, textAlign = TextAlign.Start
                    )
                }
            }
        }
    }
}
@Composable
fun pantallaObjetosCompleta (seleccionarObjeto:(Int)->Unit,cambiarPantallaObj:(Int)->Unit,bloqueo:Bloqueo,bloquearPantalla:(Int)->Unit) {
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
                    onClick = {
                        bloquearPantalla(0)
                        cambiarPantallaObj(2)
                        seleccionarObjeto(1)
                        },
                ) {
                    Text(
                        "${bat1.pokemon1.objetos1[0].nombre}     ${bat1.pokemon1.objetos1[0].salud}"
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
                    onClick = {
                        bloquearPantalla(0)
                        cambiarPantallaObj(2)
                        seleccionarObjeto(2)
                        },
                ) {
                    Text(
                        "${bat1.pokemon1.objetos1[1].nombre}     ${bat1.pokemon1.objetos1[1].salud}"
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
                    onClick = {
                        bloquearPantalla(0)
                        cambiarPantallaObj(2)
                        seleccionarObjeto(3)
                        },
                ) {
                    Text(
                        "${bat1.pokemon1.objetos1[2].nombre}     ${bat1.pokemon1.objetos1[2].salud}"
                        ,color = Color.Black,fontSize = 10.sp, textAlign = TextAlign.Start
                    )
                }
            }
        }
    }
}
@Composable
fun pantallaMovimientos2(bloquearPantalla:(Int)->Unit,actualizarVida2:(Int)->Unit,actualizarVida:(Int)->Unit,cambiarPantalla:(Int)->Unit,cambiarPantalla1:(Int)->Unit){
    var Borde1 = Color.Red
    var Borde2 = Color.Red
    var Borde3 = Color.Red
    var pp1:Int by remember { mutableStateOf(bat1.pokemon2.movimientos[0].currentPP) }
    var pp2:Int by remember { mutableStateOf(bat1.pokemon2.movimientos[1].currentPP) }
    var pp3:Int by remember { mutableStateOf(bat1.pokemon2.movimientos[2].currentPP) }
    var accion by remember { mutableStateOf(-1) }
    var pantallaSeleccionada2 by remember { mutableStateOf(0) }
    val cambiarPantalla2:(Int)->Unit = {pantallaSeleccionada2 = it}
    val actualizarPP1:(Int)->Unit = { pp1= it}
    val actualizarPP2:(Int)->Unit = { pp2= it}
    val actualizarPP3:(Int)->Unit = { pp3= it}
    var acierto:Int by remember { mutableStateOf(0) }
    val actualizarAcierto:(Int)->Unit = { acierto= it}
    var contador by remember { mutableStateOf(1) }
    val bloquearPantalla2:(Int)->Unit = {contador = it}


    when(pantallaSeleccionada2){
        1->descripcionCombate2(cambiarPantalla2,accion,acierto)
        2->Efectividad2(cambiarPantalla2,cambiarPantalla,accion)
        3->Debilitado2(cambiarPantalla)
        4->Fallo2(cambiarPantalla)
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
                OutlinedButton(modifier = Modifier.offset(5.dp, 200.dp)
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
                        actualizarAcierto(bat1.ejecutarAccion(bat1.pokemon2,bat1.pokemon1,accion,0))
                        cambiarPantalla2(1)
                        actualizarVida2(bat1.pokemon1.currentHP)
                        actualizarPP1(bat1.pokemon2.movimientos[0].currentPP)
                        bloquearPantalla(0)
                        bloquearPantalla2(0) } ,
                    enabled = contador==1
                ) {
                    Text(
                        "${bat1.pokemon2.movimientos[0].nombre}  $pp1/${bat1.pokemon2.movimientos[0].PP}\n ${bat1.pokemon2.movimientos[0].type}"
                        , color = Color.Black, fontSize = 10.sp, textAlign = TextAlign.Start
                    )
                }
                OutlinedButton(modifier = Modifier.offset(5.dp, 200.dp)
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
                      actualizarAcierto(bat1.ejecutarAccion(bat1.pokemon2,bat1.pokemon1,0,1))
                        cambiarPantalla2(1)
                        actualizarVida2(bat1.pokemon1.currentHP)
                        actualizarPP2(bat1.pokemon2.movimientos[1].currentPP)
                        bloquearPantalla2(0)
                        bloquearPantalla(0) },
                    enabled = contador==1
                ) {
                    Text(
                        "${bat1.pokemon2.movimientos[1].nombre}  $pp2/${bat1.pokemon2.movimientos[1].PP}\n ${bat1.pokemon2.movimientos[1].type}"
                        ,color = Color.Black,fontSize = 10.sp, textAlign = TextAlign.Start
                    )
                }
                OutlinedButton(modifier = Modifier.offset(5.dp, 200.dp)
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
                       actualizarAcierto(bat1.ejecutarAccion(bat1.pokemon2,bat1.pokemon1,0,2))
                        cambiarPantalla2(1)
                        actualizarVida2(bat1.pokemon1.currentHP)
                        actualizarPP3(bat1.pokemon2.movimientos[2].currentPP)
                        bloquearPantalla(0)
                        bloquearPantalla2(0) },
                    enabled = contador==1
                ) {
                    Text(
                        "${bat1.pokemon2.movimientos[2].nombre} $pp3/${bat1.pokemon2.movimientos[2].PP}\n ${bat1.pokemon2.movimientos[2].type}"
                        ,color = Color.Black,fontSize = 10.sp, textAlign = TextAlign.Start
                    )
                }
            }
        }
    }
}
@Composable
fun pantallaObjetos2(bloquearPantalla:(Int)->Unit,actualizarVida:(Int)->Unit,cambiarPantalla:(Int)->Unit){
    var bolsa by remember { mutableStateOf(bat1.pokemon2.objetos1.size) }
    val cambiarPantallaObj:(Int)->Unit = {bolsa = it}
    var objetoUsado by remember { mutableStateOf(0) }
    val seleccionarObjeto:(Int)->Unit = {objetoUsado = it}
    when (objetoUsado){
        1->usoObjeto2(actualizarVida,cambiarPantalla,0)
        2->usoObjeto2(actualizarVida,cambiarPantalla,1)
        3->usoObjeto2(actualizarVida,cambiarPantalla,2)
    }

    when (bolsa) {
        1 -> pantallaObjetosSingular2(seleccionarObjeto,cambiarPantallaObj,bloqueo,bloquearPantalla)
        2 -> pantallaObjetosMedia2(seleccionarObjeto,cambiarPantallaObj,bloqueo,bloquearPantalla)
        3 ->  pantallaObjetosCompleta2(seleccionarObjeto,cambiarPantallaObj,bloqueo,bloquearPantalla)
        else -> Text("${bat1.pokemon2.name} no tiene objetos.",
            modifier = Modifier
                .offset(5.dp, 198.dp)
                .size(width = 155.dp, height = 55.dp))
    }
}
@Composable
fun pantallaObjetosSingular2 (seleccionarObjeto:(Int)->Unit,cambiarPantallaObj:(Int)->Unit,bloqueo:Bloqueo,bloquearPantalla:(Int)->Unit) {
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
                    onClick = {
                        bloquearPantalla(0)
                        seleccionarObjeto(1)
                        cambiarPantallaObj(0)
                    },
                    enabled = bloqueo.bloqueo1==true
                ) {
                    Text(
                        "${bat1.pokemon2.objetos1[0].nombre}     ${bat1.pokemon2.objetos1[0].salud}"
                        , color = Color.Black, fontSize = 10.sp, textAlign = TextAlign.Start
                    )
                }
            }
        }
    }
}
@Composable
fun pantallaObjetosMedia2 (seleccionarObjeto:(Int)->Unit,cambiarPantallaObj:(Int)->Unit,bloqueo:Bloqueo,bloquearPantalla:(Int)->Unit) {
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
                    onClick = {
                        bloquearPantalla(0)
                        cambiarPantallaObj(1)
                        bloqueo.bloqueo1=false
                        seleccionarObjeto(1)

                    },
                    enabled = bloqueo.bloqueo1==true

                ) {
                    Text(
                        "${bat1.pokemon1.objetos1[0].nombre}     ${bat1.pokemon1.objetos1[0].salud}"
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
                    onClick = {
                        bloquearPantalla(0)
                        cambiarPantallaObj(1)
                        bloqueo.bloqueo1=false
                        seleccionarObjeto(2)
                    },
                    enabled = bloqueo.bloqueo1==true
                ) {
                    Text(
                        "${bat1.pokemon2.objetos1[1].nombre}     ${bat1.pokemon2.objetos1[1].salud}"
                        ,color = Color.Black,fontSize = 10.sp, textAlign = TextAlign.Start
                    )
                }
            }
        }
    }
}
@Composable
fun pantallaObjetosCompleta2 (seleccionarObjeto:(Int)->Unit,cambiarPantallaObj:(Int)->Unit,bloqueo:Bloqueo,bloquearPantalla:(Int)->Unit) {
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
                    onClick = {
                        bloquearPantalla(0)
                        seleccionarObjeto(1)
                        bloqueo.bloqueo1=false
                        cambiarPantallaObj(2)
                    },
                ) {
                    Text(
                        "${bat1.pokemon2.objetos1[0].nombre}     ${bat1.pokemon2.objetos1[0].salud}"
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
                    onClick = {
                        bloquearPantalla(0)
                        seleccionarObjeto(2)
                        bloqueo.bloqueo1=false
                        cambiarPantallaObj(2)
                    },
                ) {
                    Text(
                        "${bat1.pokemon2.objetos1[1].nombre}     ${bat1.pokemon2.objetos1[1].salud}"
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
                    onClick = {
                        bloquearPantalla(0)
                        seleccionarObjeto(3)
                        cambiarPantallaObj(2)
                    },
                ) {
                    Text(
                        "${bat1.pokemon2.objetos1[2].nombre}     ${bat1.pokemon2.objetos1[2].salud}"
                        ,color = Color.Black,fontSize = 10.sp, textAlign = TextAlign.Start
                    )
                }
            }
        }
    }
}
        @Composable
        fun descripcionCombate(cambiarPantalla2:(Int)->Unit,accion:Int,acierto:Int){
            Column(modifier = Modifier.size(250.dp,30.dp).offset(10.dp,125.dp).clickable { if (acierto>0) {cambiarPantalla2(2)} else{cambiarPantalla2(4)} }){

              Text("${bat1.pokemon1.name} usó ${bat1.pokemon1.movimientos[accion].nombre}",color = Color.Black,fontSize = 10.sp)
                Icon(
                      Icons.Default.KeyboardArrowDown,
                contentDescription = null,
                modifier = Modifier.offset(190.dp,0.dp)
                )}

              if (bat1.pokemon1.movimientos[accion].efecto!=0){
                  Column(modifier = Modifier.size(256.dp,30.dp).offset(135.dp,115.dp)){
                  when(bat1.pokemon1.movimientos[accion].efecto){
                      1 -> Text("${bat1.pokemon1.name} se ha sumergido",color = Color.Black,fontSize = 10.sp, modifier = Modifier.offset(-125.dp,25.dp))
                      2 -> Text("${bat1.pokemon2.name} se ha quemado",color = Color.Black,fontSize = 10.sp, modifier = Modifier.offset(-125.dp,25.dp))
                      3 -> {Text("${bat1.pokemon1.name} ha absorbido vida a ${bat1.pokemon2.name}",color = Color.Black,fontSize = 10.sp,modifier = Modifier.offset(-125.dp,25.dp))
                  }}
              }
            }
        }

        @Composable
        fun descripcionCombate2(cambiarPantalla2:(Int)->Unit,accion:Int,acierto:Int){
            Column(modifier = Modifier.size(250.dp,30.dp).offset(10.dp,125.dp).clickable { if (acierto>0) {cambiarPantalla2(2)} else{cambiarPantalla2(4)}}){
            Text("${bat1.pokemon2.name} usó ${bat1.pokemon2.movimientos[accion].nombre}",color = Color.Black,fontSize = 10.sp)
                Icon(
                    Icons.Default.KeyboardArrowDown,
                    contentDescription = null,
                    modifier = Modifier.offset(190.dp,0.dp)
                )}
            if (bat1.pokemon2.movimientos[accion].efecto!=0){
                Column(modifier = Modifier.size(256.dp,30.dp).offset(135.dp,115.dp)){
                    when(bat1.pokemon2.movimientos[accion].efecto){
                        1 -> Text("${bat1.pokemon2.name} se ha sumergido",color = Color.Black,fontSize = 10.sp, modifier = Modifier.offset(-125.dp,25.dp))
                        2 -> Text("${bat1.pokemon1.name} se ha quemado",color = Color.Black,fontSize = 10.sp, modifier = Modifier.offset(-125.dp,25.dp))
                        3 -> {Text("${bat1.pokemon2.name} ha absorbido vida a ${bat1.pokemon1.name}",color = Color.Black,fontSize = 10.sp,modifier = Modifier.offset(-125.dp,25.dp))
                        }}
                }
            }
        }
        @Composable
        fun Efectividad(cambiarPantalla2:(Int)->Unit ,cambiarPantalla:(Int)->Unit,accion:Int){
            Row(modifier = Modifier.size(256.dp,100.dp).offset(10.dp,125.dp).clickable { if (bat1.pokemon2.estado==2) {bat1.pokemon2.ComprobarEstado(bat1.pokemon2.estado,0)} //En caso de estar quemado, primero hace el efecto y luego vuelve a la normalidad
                if (bat1.pokemon2.currentHP==0){
                    cambiarPantalla2(3)
                }else{ cambiarPantalla(3) }})
            {
                if (bat1.ComprobarEfectividad(bat1.pokemon1.movimientos[accion].type, bat1.pokemon2.Type()) == 2.0) {
                    Text(
                        "Ha sido muy eficaz!!",
                        color = Color.Black,
                        fontSize = 10.sp,
                        textAlign = TextAlign.Start)
                    Icon(
                        Icons.Default.KeyboardArrowDown,
                        contentDescription = null,
                        modifier = Modifier.offset(93.dp,10.dp)
                    )
                }
                if (bat1.ComprobarEfectividad(bat1.pokemon1.movimientos[accion].type, bat1.pokemon2.Type()) == 0.5) {
                    Text(
                        "Ha sido poco eficaz...",
                        color = Color.Black,
                        fontSize = 10.sp,
                        textAlign = TextAlign.Start,
                    )
                    Icon(
                        Icons.Default.KeyboardArrowDown,
                        contentDescription = null,
                        modifier = Modifier.offset(93.dp,10.dp)
                    )
                }
                if (bat1.ComprobarEfectividad(bat1.pokemon1.movimientos[accion].type, bat1.pokemon2.Type()) == 1.0) {
                    Text(
                        "Ha sido neutro.",
                        color = Color.Black,
                        fontSize = 10.sp,
                        textAlign = TextAlign.Start,
                    )
                    Icon(
                        Icons.Default.KeyboardArrowDown,
                        contentDescription = null,
                        modifier = Modifier.offset(93.dp,10.dp)
                    )
                }

            }
        }
        @Composable
        fun Efectividad2(cambiarPantalla2:(Int)->Unit ,cambiarPantalla:(Int)->Unit,accion:Int){
            Row(modifier = Modifier.size(256.dp,100.dp).offset(10.dp,125.dp).clickable {
                if (bat1.pokemon1.estado==2) {bat1.pokemon1.ComprobarEstado(bat1.pokemon1.estado,0)} //En caso de estar quemado, primero hace el efecto y luego vuelve a la normalidad
                if (bat1.pokemon1.estado==1) {
                    bat1.pokemon1.evasion-=95
                }
                if (bat1.pokemon1.currentHP==0){
                    cambiarPantalla2(3)
                }else{
                cambiarPantalla(2) }})
            {
                if (bat1.ComprobarEfectividad(bat1.pokemon2.movimientos[accion].type, bat1.pokemon1.Type()) == 2.0) {
                    Text(
                        "Ha sido muy eficaz!!",
                        color = Color.Black,
                        fontSize = 10.sp,
                        textAlign = TextAlign.Start,
                    )
                    Icon(
                        Icons.Default.KeyboardArrowDown,
                        contentDescription = null,
                        modifier = Modifier.offset(93.dp,10.dp)
                    )
                }
                if (bat1.ComprobarEfectividad(bat1.pokemon2.movimientos[accion].type, bat1.pokemon1.Type()) == 0.5) {
                    Text(
                        "Ha sido poco eficaz...",
                        color = Color.Black,
                        fontSize = 10.sp,
                        textAlign = TextAlign.Start,
                    )
                    Icon(
                        Icons.Default.KeyboardArrowDown,
                        contentDescription = null,
                        modifier = Modifier.offset(93.dp,10.dp)
                    )
                }
                if (bat1.ComprobarEfectividad(bat1.pokemon2.movimientos[accion].type, bat1.pokemon1.Type()) == 1.0) {
                    Text(
                        "Ha sido neutro.",
                        color = Color.Black,
                        fontSize = 10.sp,
                        textAlign = TextAlign.Start,
                    )
                    Icon(
                        Icons.Default.KeyboardArrowDown,
                        contentDescription = null,
                        modifier = Modifier.offset(93.dp,10.dp)
                    )
                }
            }
        }
    @Composable
    fun usoObjeto(actualizarVida:(Int)->Unit,cambiarPantalla:(Int)->Unit, eleccion:Int){
        Column(modifier = Modifier.size(250.dp,30.dp).offset(10.dp,125.dp).clickable {
            if (bat1.pokemon2.estado==2) {bat1.pokemon2.ComprobarEstado(bat1.pokemon2.estado,0)} //En caso de estar quemado, primero hace el efecto y luego vuelve a la normalidad
            if (bat1.pokemon2.estado==1) {
                bat1.pokemon2.evasion-=95
            }
            bloqueo.bloqueo1=true
            cambiarPantalla(3)
        }){
            Text("Le has dado ${bat1.pokemon1.objetos1[eleccion].nombre} a ${bat1.pokemon1.name}",color = Color.Black,fontSize = 10.sp)
            Icon(
                Icons.Default.KeyboardArrowDown,
                contentDescription = null,
                modifier = Modifier.offset(190.dp,0.dp)
            )
            bat1.RecibirObjeto(bat1.pokemon1,bat1.pokemon1.UsarObjeto(eleccion))
            actualizarVida(bat1.pokemon1.currentHP)
    }}
@Composable
fun usoObjeto2(actualizarVida:(Int)->Unit,cambiarPantalla:(Int)->Unit,eleccion:Int){
    Column(modifier = Modifier.size(250.dp,30.dp).offset(10.dp,125.dp).clickable {
        if (bat1.pokemon1.estado==2) {bat1.pokemon1.ComprobarEstado(bat1.pokemon1.estado,0)} //En caso de estar quemado, primero hace el efecto y luego vuelve a la normalidad
        if (bat1.pokemon1.estado==1) {
            bat1.pokemon1.evasion-=95
        }
        bloqueo.bloqueo1=true
        cambiarPantalla(2)
    }){
        Text("Le has dado ${bat1.pokemon2.objetos1[eleccion].nombre} a ${bat1.pokemon2.name}",color = Color.Black,fontSize = 10.sp)
        Icon(
            Icons.Default.KeyboardArrowDown,
            contentDescription = null,
            modifier = Modifier.offset(190.dp,0.dp)
        )
        bat1.RecibirObjeto(bat1.pokemon2,bat1.pokemon2.UsarObjeto(eleccion))
        actualizarVida(bat1.pokemon2.currentHP)
    }}
@Composable
fun Debilitado(cambiarPantalla:(Int)->Unit){
    Row(modifier = Modifier.size(256.dp,100.dp).offset(10.dp,125.dp).clickable { cambiarPantalla(4)})
    { Text(
    "${bat1.pokemon2.name} se ha debilitado...",
        color = Color.Black,
        fontSize = 10.sp,
        textAlign = TextAlign.Start,)
        Icon(
            Icons.Default.KeyboardArrowDown,
            contentDescription = null,
            modifier = Modifier.offset(70.dp,10.dp)
        )

    }
}
@Composable
fun Debilitado2(cambiarPantalla:(Int)->Unit){
    Row(modifier = Modifier.size(256.dp,100.dp).offset(10.dp,125.dp).clickable { cambiarPantalla(5)})
    { Text(
        "${bat1.pokemon1.name} se ha debilitado...",
        color = Color.Black,
        fontSize = 10.sp,
        textAlign = TextAlign.Start,)
        Icon(
            Icons.Default.KeyboardArrowDown,
            contentDescription = null,
            modifier = Modifier.offset(70.dp,10.dp)
        )

    }
}
@Composable
fun Fallo(cambiarPantalla:(Int)->Unit){
    Row(modifier = Modifier.size(256.dp,100.dp).offset(10.dp,125.dp).clickable {
        if (bat1.pokemon2.estado==1) {
            bat1.pokemon2.evasion-=95
        }
        cambiarPantalla(3)})
    { Text(
        "${bat1.pokemon1.name} ha fallado..",
        color = Color.Black,
        fontSize = 10.sp,
        textAlign = TextAlign.Start,)
        Icon(
            Icons.Default.KeyboardArrowDown,
            contentDescription = null,
            modifier = Modifier.offset(93.dp,10.dp)
        )

    }
}
@Composable
fun Fallo2(cambiarPantalla:(Int)->Unit){
    Row(modifier = Modifier.size(256.dp,100.dp).offset(10.dp,125.dp).clickable {
        if (bat1.pokemon1.estado==1) {
            bat1.pokemon1.evasion-=95
        }
        cambiarPantalla(2)})
    { Text(
        "${bat1.pokemon2.name} ha fallado..",
        color = Color.Black,
        fontSize = 10.sp,
        textAlign = TextAlign.Start,)
        Icon(
            Icons.Default.KeyboardArrowDown,
            contentDescription = null,
            modifier = Modifier.offset(93.dp,10.dp)
        )

    }
}



