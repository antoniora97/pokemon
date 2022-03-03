fun prueba() {
    val pelea = Batalla(chikorita,chikorita,-1,0)
    pelea.pokemon1.objetos1.forEach { println(it.nombre) }
    pelea.pokemon1.UsarObjeto(2)
    pelea.pokemon1.objetos1.forEach { println(it.nombre) }
}
fun main(){
    prueba()
}