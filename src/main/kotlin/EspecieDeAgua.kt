class EspecieDeAgua (name: String, hp: Int, attack: Int, defense: Int, type: String, nombreEvoluciones: Array<String>) :
    Pokemon(name, hp, attack, defense, type, nombreEvoluciones),
    IAgua {

    override fun sumergir() {
        condition = 1
    }

    override fun respirar() {
        condition = 0
    }

}