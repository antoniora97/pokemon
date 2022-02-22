
fun main () {
    val Pelea= Batalla(bulbasur,squirtle)
    while(Pelea.pokemon1.currentHP>0 && Pelea.pokemon2.currentHP>0){
        Pelea.turnos()
    }
    if (Pelea.pokemon1.currentHP==0){
        println("Ha ganado ${Pelea.pokemon2.name}")
    }else{
        println("Ha ganado ${Pelea.pokemon1.name}")
    }

}