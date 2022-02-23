class Objeto(Nombre:String , Curacion:Int) {
    val salud: Int =  Curacion
    val nombre:String = Nombre

    fun curacion(): Int{
        return salud
    }
    fun nombre():String{
        return nombre
    }
}