import kotlin.math.round

class EspecieDePlanta (name: String, hp: Int, attack: Int, defense: Int, type: String, nombreEvoluciones: Array<String>) :
    Pokemon (name, hp, attack, defense, type, nombreEvoluciones),
    IPlanta {

    override var absorcion = 10 //absorbe el 10% de la vida del enemigo

    override val comandos = arrayOf("placaje","absorcion","barrera espinosa")

    override fun ataqueEspecial1() {
        absorber()
    }

    override fun ataqueEspecial2() {
        barreraEspinosa()
    }

    override fun absorber(enemyCurrentHP : Int) : Int {
        val cantidadAbsorbida = round(enemyCurrentHP * absorcion/100.0).toInt()
        currentHP += cantidadAbsorbida
        if (currentHP > hp) currentHP = hp
        return cantidadAbsorbida
    }

    override fun barreraEspinosa() {
        currentDefense += 3
        condition = 3
    }
}