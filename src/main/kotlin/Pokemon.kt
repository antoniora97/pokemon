class Pokemon(name: String, hp: Int, attack: Int, SpAttack: Int, defense: Int, SpDefense: Int, type: String,
  Evoluciones: ArrayList<String>, movimientos: ArrayList<Movimiento>,
  objetos: ArrayList<Objeto>, evasion:Int, estado:Int, velocidad:Int) :
    PokeStats(name, hp, attack, SpAttack, defense, SpDefense, type, Evoluciones, movimientos, objetos, evasion, estado, velocidad),
    Acciones{
    private var tipo:String = type
    private var objeto:ArrayList<Objeto> = objetos
    private val moves:ArrayList<Movimiento> = movimientos
    fun recibirDanyo (danyo : Int) : String {
        if (currentHP > 0) {
            currentHP -= danyo
            if (currentHP < 0) currentHP = 0
            return "$name recibió $danyo de daño."
        }
        return "$name ya no puede recibir más daño."
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
    fun HP() : Int {
        return hp
    }

    //Recibe la cantidad a curar del objeto y cura al pokemon
    fun curar(recuperacion:Int){
        currentHP += recuperacion
        if (currentHP > hp) currentHP = hp
        println("$name se ha curado $recuperacion puntos de vida ($currentHP/$hp).")
    }

    fun ComprobarEstado(estado: Int){ //Aplica los efectos de los distintos estados:
        //1=Sumergido sube la evasion a 100 así no recibe daño
        //2=Quemado recibe 3 de daño cada turno
        //3=Fotosintesis se cura 10 de vida
        if(estado==0){
            evasion-=95
        }
        if(estado==1){
            evasion+=95
            println("$name se ha sumergido!!")
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
        val curacion=objeto[(0..objeto.size-1).random()].curacion()                  // que va a recuperar el pokemon
        println("Le has dado ${objeto[(0..objeto.size-1).random()].nombre()} a $name")
        return curacion
    }
    override fun Atacar(Movimientos:ArrayList<Movimiento>): ArrayList<String>{ //Anotación de la lista DatosMovimiento:
        val eleccion:Movimiento = Movimientos.random() // 0=ATK actual, 1=Potencia Movimiento 2=Categoría 3=Tipo Movimiento
        val DatosMovimiento:ArrayList<String>
        if (eleccion.categoria=="Fisico"){ DatosMovimiento = arrayListOf(currenAttack.toString(),eleccion.potencia.toString(),eleccion.tipo,eleccion.precision.toString(),eleccion.efecto1.toString())}
        else{DatosMovimiento = arrayListOf(currentSpAttack.toString(),eleccion.potencia.toString(),eleccion.tipo,eleccion.precision.toString(),eleccion.efecto1.toString())}
        println("$name usó ${eleccion.nombre1}")       //3=Precision Movimiento 4=Efecto
        return  DatosMovimiento
    }
    override fun Evolucionar() { //Hace que el pokemon evolucione, le cambie el nombre,
        val oldName = name
        if (contadorEvoluciones < Evoluciones.size) {
            name = Evoluciones[contadorEvoluciones]
            contadorEvoluciones += 1
            println("$oldName ha evolucionado a $name!!. Su ataque aumentó!!.")
        } else println("$name ya no puede evolucionar más.")
        when(name){
            "Bayleef"->{
                val newHP:Int = 60
                if (currentHP<hp){
                    currentHP+=(newHP-hp) }
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
            attack=80
            defense=80
            SpAttack=59
            SpDefense=63
            velocidad=58 }
        "Feraligtr"->{
            val newHP:Int = 85
            if (currentHP<hp){
                currentHP+=(newHP-hp)
                hp=newHP }
            attack=105
            defense=100
            SpAttack=79
            SpDefense=83
            velocidad=78 }
        }
    }
}


