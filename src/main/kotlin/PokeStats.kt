

abstract class PokeStats
    (
    var name: String,
    protected var hp : Int,
    protected var attack :  Int,
    protected var SpAttack: Int,
    protected var defense : Int,
    protected var SpDefense : Int,
    protected val type: String,
    protected val Evoluciones: ArrayList<String>,
    protected val movimientos: ArrayList<Movimiento>,
    protected val objetos: ArrayList<Objeto>,
    public var evasion:Int,
    public var velocidad:Int,
    public var estado:Int
    ) {

    //Atributos iniciales
    var currentHP = hp
    var currenAttack = attack
    var currentSpAttack = SpAttack
    var currentDefense = defense
    var currentSpDefense = SpDefense
    var contadorEvoluciones = 0

    //Imprime todas las estadísticas del pokemon
    fun showStats () : String {
        return "$name:\n" +
                "\tHP: $currentHP / $hp\n" +
                "\tATTACK: $attack\n" +
                "\tDEFENSE: $defense\n" +
                "\tTYPE: $type\n\n"
    }
}

