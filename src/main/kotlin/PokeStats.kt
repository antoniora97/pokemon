
// HEALING ITEMS
val restoringItems : Map<String, Int> = mapOf(
    "berryjuice" to 10,
    "potion" to 30,
    "superPotion" to 50,
    "fullrestore" to 1000)
/* ********** */

abstract class PokeStats
    (
    var name: String,
    protected val hp : Int,
    protected var attack :  Int,
    protected val defense : Int,
    protected val type: String,
    protected var Evoluciones: ArrayList<String>,
    protected var movimientos: ArrayList<Movimiento>,
    protected var objetos: ArrayList<Objeto>,
    public var evasion:Int,
    public var velocidad:Int,
    public var estado:Int
    ) {

    //Atributos iniciales
    var currentHP = hp
    var currenAttack = attack
    var currentDefense = defense
    var contadorEvoluciones = 0
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

   /* fun saludo () : String {
        return "Hola, soy $name.\n\n"
    }

    fun curar (item : ItemsCurativos) : String {
        if (currentHP < hp) {
            currentHP += restoringItems[item.toString().lowercase()]!!
            if (currentHP > hp) currentHP = hp
            return "$name se ha curado con $item. ${graciasPorLaCura()}\n"
        }
        return "$name no puede curarse [${currentHP} / $hp].\n\n"
    }*/

    fun placaje () : Int {
        return (attack*0.6).toInt()
    }

    private fun graciasPorLaCura () : String {
        return "Te da las gracias por la curita.\n"
    }
}

//(ataqueAtacante/defensaEnemigo) * potenciaAtaque*0.5*modificador + 1