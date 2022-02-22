import kotlin.reflect.typeOf

fun main () {
    val bulbasur = EspecieDePlanta("Bulbasur", 89, 34, 46, "Planta", arrayOf("e1", "e2"))
    val charmander = EspecieDeFuego("Charmander", 45, 45, 64, "Fuego", arrayOf("e1", "e2"))
    val squirtle = EspecieDeAgua("Squirtle", 32, 60, 34, "Agua", arrayOf("e1", "e2"))

    val pokedex = mapOf("Bulbasur" to bulbasur, "Charmander" to charmander, "Squirtle" to squirtle)

    print("Selecciona 2 pokemon [Bulbasur - Charmander - Squirtle]:\n")
    var opcion1 : String
    var opcion2 : String
    do {
        print("\tPokemon 1: ")
        opcion1 = readln()

        print("\tPokemon 2: ")
        opcion2 = readln()
    } while (opcion1 !in pokedex || opcion2 !in pokedex)

    val pokemon1 = pokedex[opcion1]
    val pokemon2 = pokedex[opcion2]

    if (opcion1 == "Bulbasur" && opcion2 == "Charmander") {
        bulbasur
        charmander
    } else if (opcion1 == "Bulbasur" && opcion2 == "Squirtle") {

    } else {

    }

    print(pokemon1)
    print(pokemon2)
}