
interface IPlanta {

    var absorcion : Int

    //El pokemon recupera un porcentaje de vida
    fun absorber (enemyCurrentHP : Int) : Int

    //El pokemon crea una barrera con espinas que aumenta su defensa y causa daño si es atacado
    fun barreraEspinosa ()

}