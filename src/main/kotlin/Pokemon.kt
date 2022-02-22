
// HEALING ITEMS
val restoringItems : Map<String, Int> = mapOf(
    "berryjuice" to 10,
    "potion" to 30,
    "superPotion" to 50,
    "fullrestore" to 1000)
/* ********** */

abstract class Pokemon
    (
    var name: String,
    protected val hp : Int,
    protected var attack :  Int,
    protected val defense : Int,
    protected val type: String,
    protected var nombreEvoluciones: Array<String>
    ) {

    //Atributos iniciales
    var currentHP = hp
    var currenAttack = attack
    var currentDefense = defense
    private var contadorEvoluciones = 0
    var condition = 0
    /*
        0 -> normal
        1 -> sumergido
        2 -> quemado
        3 -> pincho
     */

    //Imprime todas las estadísticas del pokemon
    fun showStats () : String {
        return "$name:\n" +
                "\tHP: $currentHP / $hp\n" +
                "\tATTACK: $attack\n" +
                "\tDEFENSE: $defense\n" +
                "\tTYPE: $type\n\n"
    }

    fun saludo () : String {
        return "Hola, soy $name.\n\n"
    }

    fun curar (item : ItemsCurativos) : String {
        if (currentHP < hp) {
            currentHP += restoringItems[item.toString().lowercase()]!!
            if (currentHP > hp) currentHP = hp
            return "$name se ha curado con $item. ${graciasPorLaCura()}\n"
        }
        return "$name no puede curarse [${currentHP} / $hp].\n\n"
    }

    fun placaje () : Int {
        return (attack*0.25).toInt()
    }

    fun recibirDanyo (danyo : Int) : String {
        if (currentHP > 0) {
            currentHP -= danyo
            if (currentHP < 0) currentHP = 0
            return "$name recibió $danyo de daño.\n\n"
        }
        return "$name ya no puede recibir más daño.\n\n"
    }

    fun evolucionar () : String {
        attack = (attack * 1.2).toInt()
        val oldName = name
        return if (contadorEvoluciones < nombreEvoluciones.size) {
            name = nombreEvoluciones[contadorEvoluciones]
            contadorEvoluciones += 1
            "$oldName ha evolucionado a $name. Su ataque aumentó.\n\n"
        } else "$name ya no puede evolucionar más.\n\n"
    }

    private fun graciasPorLaCura () : String {
        return "Te da las gracias por la curita.\n"
    }

    abstract fun ataqueEspecial1()
    abstract fun ataqueEspecial2()
}

//(ataqueAtacante/defensaEnemigo) * potenciaAtaque*0.5*modificador + 1