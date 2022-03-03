// Copyright 2000-2021 JetBrains s.r.o. and contributors. Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE file.
import androidx.compose.material.MaterialTheme
import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.key.Key.Companion.R
import androidx.compose.ui.layout.HorizontalAlignmentLine
import androidx.compose.ui.layout.VerticalAlignmentLine
import androidx.compose.ui.res.loadImageBitmap
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.useResource
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.semantics.Role.Companion.Image
import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.WindowState
import androidx.compose.ui.window.application
import kotlinx.coroutines.launch
import org.intellij.lang.annotations.JdkConstants
import org.jetbrains.skia.Image

@Composable
fun App() {
    var pantallaSeleccionada by remember { mutableStateOf(0) }
    val cambiarPantalla:(Int)->Unit = {pantallaSeleccionada = it}
        when (pantallaSeleccionada) {
            -1-> pantallaFinal(chikorita)
            0->PantallaTitulo(cambiarPantalla)
            1 -> pantallaInicio(cambiarPantalla)
            2 -> pantalla2(cambiarPantalla)
            3 ->pantalla3(cambiarPantalla)
        }
    }

fun main() = application {
    Window(onCloseRequest = ::exitApplication,
            title = "Pokemon Battle",
            resizable = false,
            state = WindowState(size = DpSize(250.dp, 384.dp))) {
        App()
    }
}