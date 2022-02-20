
class EspecieDeFuego (name: String, hp: Int, attack: Int, defense: Int, type: String, nombreEvoluciones: Array<String>) :
    Pokemon (name, hp, attack, defense, type, nombreEvoluciones),
    IFuego {

    override var probabilidadQuemado : Int = 40 //40% de probabilidad de quemar

    override fun ascuas() : Int {
        val damage = placaje()
        if ((1..100).random() <= probabilidadQuemado) return 2
        return 0
    }

    override fun calentarse() {
        probabilidadQuemado += 5
    }

}