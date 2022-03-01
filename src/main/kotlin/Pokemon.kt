import androidx.compose.material.Text
import androidx.compose.runtime.Composable

class Pokemon(name: String, hp: Int, attack: Int, SpAttack: Int, defense: Int, SpDefense: Int, velocidad: Int, type: String,
              Evoluciones: ArrayList<String>, movimientos: ArrayList<Movimiento>,
              objetos: ArrayList<Objeto>, evasion:Int, estado:Int) :
    PokeStats(name, hp, attack, SpAttack, defense, SpDefense,velocidad, type, Evoluciones, movimientos, objetos, evasion, estado),
    Acciones{

    private var tipo:String = type

    //LISTO
    fun recibirDanyo (danyo : Int) {
        if (currentHP > 0) {
            currentHP -= danyo
            if (currentHP < 0) currentHP = 0
        }
        println("$name ha recibido $danyo puntos  de daño $currentHP")
    }

    //LISTO
    fun Type():String{
        return tipo
    }

    //LISTO
    fun HP() : Int {
        return hp
    }

    //LISTO
    //Recibe la cantidad a curar del objeto y cura al pokemon
    fun curar (recuperacion : Int){
        if (recuperacion!=0) {
            val HPactual:Int = currentHP
            currentHP += recuperacion
            if (currentHP > hp) currentHP = hp
            println("$name se ha curado ${currentHP-HPactual} puntos de vida ($currentHP/$hp).")
        }
    }

    //LISTO
    fun ComprobarEstado(estado: Int,danio: Int){ //Aplica los efectos de los distintos estados:
        //1=Sumergido sube la evasion a 100 así no recibe daño
        //2=Quemado recibe 3 de daño cada turno
        //3=Fotosintesis se cura 10 de vida
        if(estado==1){
            evasion+=95
            println("$name se ha sumergido!!")
        }
        if(estado==2){
            currentHP-=3
            println("$name se ha quemado!!")
        }
        if(estado==3){
            val HPactual:Int = currentHP
            currentHP += (danio*0.5).toInt()
            if (currentHP > hp) currentHP = hp
            println("$name ha absorbido la vida del enemigo y se ha curado ${currentHP-HPactual} puntos de vida")
        }
    }

    //LISTO
    override fun UsarObjeto() : Int{ //Devuelve a batalla la cantidad de salud
        if (objetos.size!=0) {
            while (true) {
                print("$name tiene los siguientes objetos:\n")
                showObjetos()
                //le pedimos el objeto
                print("Qué objeto le quieres dar? : ")
                val nombreObjeto = readLine()!!.lowercase() // que va a recuperar el pokemon
                //Buscamos la coincidencia
                for (o in objetos) {
                    if (nombreObjeto == o.nombre.lowercase()) {
                        val curacion = o.curacion()
                        objetos.remove(o)
                        return curacion
                    }
                }
                //si no se encuentra avisamos
                print("Ese objeto no lo tiene $name.")
            }
        }
        print("$name no tiene objetos para curarse.")
        return 0
    }

    //LISTO
    override fun Atacar(eleccion: Int): Map<String, String>{
        val movimientoElegido : Movimiento = movimientos[eleccion]
        val datosMovimiento : Map<String, String>
        if (movimientoElegido.category=="Fisico") {
            datosMovimiento =
                mapOf(
                    "potencia" to movimientoElegido.power.toString(),
                    "tipo" to movimientoElegido.type,
                    "precision" to movimientoElegido.accuracy.toString(),
                    "efecto" to movimientoElegido.efecto.toString(),
                    "categoria" to movimientoElegido.category
                )
        } else {
            datosMovimiento =
                mapOf(
                    "potencia" to movimientoElegido.power.toString(),
                    "tipo" to movimientoElegido.type,
                    "precision" to movimientoElegido.accuracy.toString(),
                    "efecto" to movimientoElegido.efecto.toString(),
                    "categoria" to movimientoElegido.category
                )
        }
        print("$name usó ${movimientoElegido.nombre}")
        if (movimientoElegido.currentPP>0) movimientoElegido.currentPP -= 1
        return datosMovimiento
    }

    //LISTO
    override fun Evolucionar() { //Hace que el pokemon evolucione, le cambie el nombre,
        val oldName = name
        if (contadorEvoluciones < Evoluciones.size) {
            name = Evoluciones[contadorEvoluciones]
            contadorEvoluciones += 1
            println("$oldName ha evolucionado a $name!!. Su ataque aumentó!!.")
            println("Ahora se llama $name")
        } else println("$name ya no puede evolucionar más.")
        when(name){
            "Bayleef"->{
                val newHP:Int = 60
                if (currentHP<hp){
                    currentHP+=(newHP-hp)
                    hp = newHP
                }else{currentHP=newHP
                    hp=newHP}
                attack=62
                defense=80
                SpAttack=63
                SpDefense=80
                velocidad=60 }
        "Meganium"->{
            val newHP:Int = 80
            if (currentHP<hp){
                currentHP+=(newHP-hp)
                hp=newHP }
            else{currentHP=newHP
                hp=newHP}
            attack=82
            defense=100
            SpAttack=83
            SpDefense=100
            velocidad=80 }
        "Quilava"->{
            val newHP:Int = 58
            if (currentHP<hp){
                currentHP+=(newHP-hp)
                hp=newHP }
            else{currentHP=newHP
                hp=newHP}
            attack=64
            defense=58
            SpAttack=80
            SpDefense=65
            velocidad=80 }
        "Typhlosion"->{
            val newHP:Int = 78
            if (currentHP<hp){
                currentHP+=(newHP-hp)
                hp=newHP }
            else{currentHP=newHP
                hp=newHP}
            attack=84
            defense=78
            SpAttack=109
            SpDefense=85
            velocidad=100 }
        "Croconaw"->{
            val newHP:Int = 65
            if (currentHP<hp){
                currentHP+=(newHP-hp)
                hp=newHP }
            else{currentHP=newHP
                hp=newHP}
            attack=80
            defense=80
            SpAttack=59
            SpDefense=63
            velocidad=58 }
        "Feraligatr"->{
            val newHP:Int = 85
            if (currentHP<hp){
                currentHP+=(newHP-hp)
                hp=newHP }
            else{currentHP=newHP
                hp=newHP}
            attack=105
            defense=100
            SpAttack=79
            SpDefense=83
            velocidad=78 }
        }
    }

    //LISTO
    //Muestra los movimientos que tiene el pokemon
    private fun showMovimientos () {
        var cont = 0
        for (m in movimientos) {
            print("$cont - ")
            m.showMovimiento()
            cont += 1
        }
    }

    //LISTO
    //Muestra los objetos curativos que tiene el pokemon
    private fun showObjetos () {
        for (o in objetos) {
            print("\t${o.nombre} (cura ${o.curacion()} puntos de vida)\n")
        }
    }


}


