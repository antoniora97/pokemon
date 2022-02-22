
interface IAgua {

    val comandos : Array<String> //lista de acciones que puede realizar el pokemon de agua

    //Sumerge al pokemon en el agua, haciéndolo imposible de atacar
    fun sumergir ()

    //Saca del agua al pokemon
    fun respirar ()

}