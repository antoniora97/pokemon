class EspecieDeAgua (name: String, hp: Int, attack: Int, defense: Int, type: String, nombreEvoluciones: Array<String>) :
    Pokemon(name, hp, attack, defense, type, nombreEvoluciones),
    IAgua {

    override val comandos = arrayOf("placaje","sumergir","respirar")

    override fun ataqueEspecial1() {
        sumergir()
    }

    override fun ataqueEspecial2() {
        respirar()
    }

    override fun sumergir() {
        condition = 1
    }

    override fun respirar() {
        condition = 0
    }

}