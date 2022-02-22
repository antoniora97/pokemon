
interface IFuego {

    var probabilidadQuemado : Int

    val comandos : Array<String> //lista de acciones que puede realizar el pokemon de fuego

    //Tiene una probabilidad de quemar al pokemon enemigo
    fun ascuas () : Int

    //Aumenta la probabilidad de quemado
    fun calentarse ()

}