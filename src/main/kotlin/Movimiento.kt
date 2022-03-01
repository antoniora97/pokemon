
class Movimiento(val nombre: String,
                 val type: String,
                 val category: String,
                 val power:Int,
                 val accuracy:Int,
                 val PP:Int,
                 val efecto:Int) {

    var currentPP = PP

    fun showMovimiento () {
        print("$nombre (${currentPP}/$PP)\n")
    }


}