class Pokemon(name: String, hp: Int, attack: Int, defense: Int, type: String,
  Evoluciones: ArrayList<String>, movimientos: ArrayList<Movimiento>,
  objetos: ArrayList<Objeto>, evasion:Int, estado:Int, velocidad:Int) :
    PokeStats(name, hp, attack, defense, type, Evoluciones, movimientos, objetos, evasion, estado, velocidad),
    Acciones{
    private var tipo:String = type
    private var objeto:ArrayList<Objeto> = objetos
    private val moves:ArrayList<Movimiento> = movimientos
    fun recibirDanyo (danyo : Int) : String {
        if (currentHP > 0) {
            currentHP -= danyo
            if (currentHP < 0) currentHP = 0
            return "$name recibió $danyo de daño.\n\n"
        }
        return "$name ya no puede recibir más daño.\n\n"
    }
    fun Type():String{
        return tipo
    }
    fun Objects():ArrayList<Objeto>{
        return objeto
    }
    fun Movimientos():ArrayList<Movimiento>{
        return moves
    }
    fun curar(recuperacion:Int){       //Recibe la cantidad a curar del objeto y cura al pokemon
        currentHP+=recuperacion
    }
    fun ComprobarEstado(estado: Int){       //Aplica los efectos de los distintos estados:
        if(estado==1){                      //1=Sumergido sube la evasion a 100 así no recibe daño
            evasion=100                     //2=Quemado recibe 3 de daño cada turno
            println("$name se ha sumergido!!") //3=Fotosintesis se cura 10 de vida
        }
        if(estado==2){
            currentHP-=3
            println("$name se ha quemado!!")
        }
        if(estado==3){
            currentHP+=10
            println("$name hace la fotosíntesis y se cura")
        }

    }
    override fun UsarObjeto(lista:ArrayList<Objeto>):Int{ //Devuelve a batalla la cantidad de salud
        val curacion=objeto[0].curacion()                  // que va a recuperar el pokemon
        println("Le has dado ${objeto[0].nombre()} a $name")
        return curacion
    }
    override fun Atacar(Movimientos:ArrayList<Movimiento>): ArrayList<String>{ //Anotación de la lista DatosMovimiento:
        val eleccion:Movimiento = Movimientos.random() // 0=ATK actual, 1=Potencia Movimiento 2=Tipo Movimiento
        val DatosMovimiento:ArrayList<String> = arrayListOf(currenAttack.toString(),eleccion.potencia.toString(),eleccion.tipo,eleccion.precision.toString(),eleccion.efecto1.toString())
        println("$name usó ${eleccion.nombre1}")       //3=Precision Movimiento 4=Efecto
        return  DatosMovimiento
    }
    override fun Evolucionar(): String { //Hace que el pokemon evolucione, le cambie el nombre,
            attack = (attack * 1.2).toInt() //y le suba el ATK
            val oldName = name
            return if (contadorEvoluciones < Evoluciones.size) {
                name = Evoluciones[contadorEvoluciones]
                contadorEvoluciones += 1
                "$oldName ha evolucionado a $name!!. Su ataque aumentó!!.\n\n"
            } else "$name ya no puede evolucionar más.\n\n"
        }
    }


