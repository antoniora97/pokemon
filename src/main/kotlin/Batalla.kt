import androidx.compose.material.Text
import androidx.compose.runtime.Composable

class Batalla(val pokemon1 : Pokemon, val pokemon2 : Pokemon, var accion:Int,var eleccion:Int) {
    var pokemonAtacaPrimero = pokemon1
    var pokemonAtacaSegundo = pokemon2

    fun turnos(){
        if (pokemonAtacaPrimero.currentHP>0) {
            ejecutarAccion(pokemonAtacaPrimero, pokemonAtacaSegundo, accion, eleccion) //TURNO DEL POKEMON QUE ATACA PRIMERO
        } else {
            print("${pokemonAtacaPrimero.name} se ha debilitado.\n")
        }
        if (pokemonAtacaSegundo.currentHP>0) {
            ejecutarAccion(pokemonAtacaSegundo, pokemonAtacaPrimero, accion, eleccion) //TURNO DEL POKEMON QUE ATACA SEGUNDO
        } else {
            print("${pokemonAtacaPrimero.name} se ha debilitado.\n")
        }
    }

    fun comprobarVelocidad () : Boolean {
        return pokemonAtacaPrimero.velocidad < pokemonAtacaSegundo.velocidad
    }

    //LISTO
    public fun ejecutarAccion (atacante: Pokemon, enemigo: Pokemon, accion:Int, eleccion:Int) {
        if (atacante.estado==2) {atacante.ComprobarEstado(atacante.estado,0)} //En caso de estar quemado, primero hace el efecto y luego vuelve a la normalidad
        if (atacante.estado==1) {
            atacante.evasion-95
            print("${atacante.name} ha salido del Agua\n")
        }
        atacante.estado=0
        var danio : Int = 0
        when (accion) {
            0 -> {
                val datos = atacante.Atacar(eleccion)
                if (ComprobarAcierto(datos["precision"]!!.toInt(), enemigo.evasion)){
                    when (datos["categoria"]) {
                        "Fisico"-> danio = calcularDanio(atacante.currenAttack, enemigo.currentDefense, datos["potencia"]!!.toInt(), datos["tipo"]!!, enemigo.Type())
                        "Especial" -> danio = calcularDanio(atacante.currentSpAttack, enemigo.currentSpDefense, datos["potencia"]!!.toInt(), datos["tipo"]!!, enemigo.Type())
                    }
                    enemigo.recibirDanyo(danio)//Hace to.do el cálculo del daño
                    ActivarHabilidad(atacante, enemigo, datos["efecto"]!!.toInt()) //Activa el efecto del movimiento
                    if (atacante.estado==1 || atacante.estado==3){ //Estos estados se tienen que activar en el mismo momento que se usa el movimiento
                        atacante.ComprobarEstado(atacante.estado,danio)
                    }
                }else{
                    print("${atacante.name} ha fallado")
                }
            }
            1 ->  RecibirObjeto(atacante,atacante.UsarObjeto())
            2 -> atacante.Evolucionar()
        }
        print("${enemigo.name} se ha quedado con ${enemigo.currentHP}/${enemigo.HP()}")
    }

    //LISTO
    private fun RecibirObjeto (poke : Pokemon, curacion : Int){
        poke.curar(curacion)
    }

    //LISTO
    fun calcularDanio(Ataque:Int, Defensa:Int, Potencia:Int, tipo1: String, tipo2: String) : Int{ // Hace el cálculo del daño,
        val danio : Int = ((Ataque.toDouble()/Defensa.toDouble())*Potencia.toDouble()*0.5+1).toInt() //tipo1 es el tipo del movimiento
        val modificador= ComprobarEfectividad(tipo1,tipo2)    // y tipo2 el tipo del pokemon enemigo
        when(modificador){
            2.0-> println("Ha sido muy eficaz!!")
            0.5-> println("Ha sido poco eficaz...")
        }
        val danioTotal=danio*modificador
        return danioTotal.toInt()
    }

    //LISTO
    fun ComprobarAcierto(Precision:Int,Evasion:Int):Boolean{ //Cuando se usa un movimiento se tira una moneda
        val acierto:Int = (1..Precision).random()      //al aire para ver si acierta o no, para acertar
        if (acierto>Evasion) {return true}                   //el resultado debe ser mayor a la evasión del pokemon enemigo
        return false
    }

    //LISTO
    fun ActivarHabilidad(aliado:Pokemon,enemigo:Pokemon,habilidad:Int){ //En el caso de que un movimiento tenga efecto, cambia el estado del pokemon
      if (habilidad==1){ aliado.estado=1 }
      if (habilidad==2){
          val dado:Int = (0..10).random()
          if (dado <=4){enemigo.estado=2 }}
      if (habilidad==3){ aliado.estado=3 }
    }

    //LISTO
    fun ComprobarEfectividad(tipo1: String, tipo2: String):Double { //Comprueba si el movimiento es efectivo, poco efectivo o neutral
        if (tipo1 == "Fuego" && tipo2 == "Planta") {
            return 2.0
        }
        if (tipo1 == "Planta" && tipo2 == "Agua") {
            return 2.0
        }
        if (tipo1 == "Agua" && tipo2 == "Fuego") {
            return 2.0
        }
        if (tipo1 == "Agua" && tipo2 == "Planta") {
            return 0.5
        }
        if (tipo1 == "Fuego" && tipo2 == "Agua") {
            return 0.5
        }
        if (tipo1 == "Planta" && tipo2 == "Fuego") {
            return 0.5
        }
        return 1.0
    }
}