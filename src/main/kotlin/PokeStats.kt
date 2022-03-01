import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue

abstract class PokeStats
    (
    var name: String,
    var hp : Int,
    protected var attack :  Int,
    protected var SpAttack: Int,
    protected var defense : Int,
    protected var SpDefense : Int,
    public var velocidad:Int,
    protected val type: String,
    protected val Evoluciones: ArrayList<String>,
    public val movimientos: ArrayList<Movimiento>,
    public val objetos: ArrayList<Objeto>,
    public var evasion:Int,
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
    fun showStats() : String {
        return "$name:\n" +
                "HP: $hp\n" +
                "ATK: $attack\n" +
                "DEF: $defense\n" +
                "SPATK: $SpAttack\n"+
                "SPDEF: $SpDefense\n"+
                "SPD: $velocidad"
    }
}

