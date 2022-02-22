class Batalla(pokemon1:Pokemon, pokemon2:Pokemon) {
    val pokemon1=pokemon1
    val pokemon2=pokemon2
 fun turnos(){
     var danio : Int = 0
  if (pokemon1.velocidad>pokemon2.velocidad){ //Comprueba quien es más rápido, ese empieza //Anotación de la lista DatosMovimiento:
    var accion:Int = (1..10).random() // 0=ATK actual, 1=Potencia Movimiento 2=Tipo Movimiento 3=Precision Movimiento 4=Efecto
    if (pokemon1.estado==2) {pokemon1.ComprobarEstado(pokemon1.estado)} //En caso de estar quemado, primero hace el efecto y luego vuelve a la normalidad
    pokemon1.estado=0
    //Al principio de cada turno el estado del pokemon vuelve a ser normal
    if (accion<=7){ //Ataca
      var datos=pokemon1.Atacar(pokemon1.Movimientos())
      if (ComprobarAcierto(datos[3].toInt(),pokemon2.evasion)){ //Comprueba que el ataque acierta
          when(datos[2]){
              "Fisico"->danio = calcularDanio(pokemon1.currenAttack,pokemon2.currentDefense,datos[1].toInt(),datos[3],pokemon2.Type())
              "Especial" ->danio = calcularDanio(pokemon1.currentSpAttack,pokemon2.currentSpDefense,datos[1].toInt(),datos[3],pokemon2.Type())
          }
       pokemon2.recibirDanyo(danio) //Hace to.do el cálculo del daño
       ActivarHabilidad(pokemon1,pokemon2,datos[4].toInt()) //Activa el efecto del movimiento
       if (pokemon1.estado==1 || pokemon1.estado==3){ //Estos estados se tienen que activar en el mismo momento que se usa el movimiento
        pokemon1.ComprobarEstado(pokemon1.estado)
       }
          println("${pokemon2.name} ha recibido $danio puntos de daño")
      }else{
       println("${pokemon1.name} ha fallado") }
    }
    if (accion>7 && accion<=9){ RecibirObjeto(pokemon2,pokemon2.UsarObjeto(pokemon2.Objects()))}
    if (accion==10){ pokemon1.Evolucionar()}
      println("${pokemon2.name} se ha quedado con ${pokemon2.currentHP}")
   var accion2:Int = (1..10).random() // 0=ATK actual, 1=Potencia Movimiento 2=Tipo Movimiento 3=Precision Movimiento 4=Efecto
   if (pokemon2.estado==2) {pokemon2.ComprobarEstado(pokemon2.estado)} //En caso de estar quemado, primero hace el efecto y luego vuelve a la normalidad
   pokemon1.estado=0 //Al principio de cada turno el estado del pokemon vuelve a ser normal
   if (accion2<=7){ //Ataca
    var datos2=pokemon2.Atacar(pokemon2.Movimientos())
    if (ComprobarAcierto(datos2[3].toInt(),pokemon1.evasion)){ //Comprueba que el ataque acierta
        when(datos2[2]){
            "Fisico"->danio = calcularDanio(pokemon1.currenAttack,pokemon2.currentDefense,datos2[1].toInt(),datos2[3],pokemon2.Type())
            "Especial" ->danio = calcularDanio(pokemon1.currentSpAttack,pokemon2.currentSpDefense,datos2[1].toInt(),datos2[3],pokemon2.Type())
        }
     pokemon2.recibirDanyo(danio) //Hace to.do el cálculo del daño
     ActivarHabilidad(pokemon1,pokemon2,datos2[4].toInt()) //Activa el efecto del movimiento
     if (pokemon2.estado==1 || pokemon2.estado==3){ //Estos estados se tienen que activar en el mismo momento que se usa el movimiento
      pokemon2.ComprobarEstado(pokemon2.estado)
     }
        println("${pokemon1.name} ha recibido $danio puntos de daño")
    }else{
     println("${pokemon2.name} ha fallado") }
   }
   if (accion2>7 && accion2<9){ RecibirObjeto(pokemon2,pokemon2.UsarObjeto(pokemon2.Objects()))}
   if (accion2==10){ pokemon2.Evolucionar()}
      println("${pokemon1.name} se ha quedado con ${pokemon1.currentHP}")
  }else{
      var accion2:Int = (1..10).random() // 0=ATK actual, 1=Potencia Movimiento 2=Tipo Movimiento 3=Precision Movimiento 4=Efecto
      if (pokemon2.estado==2) {pokemon2.ComprobarEstado(pokemon2.estado)} //En caso de estar quemado, primero hace el efecto y luego vuelve a la normalidad
      pokemon1.estado=0 //Al principio de cada turno el estado del pokemon vuelve a ser normal
      if (accion2<=7){ //Ataca
          var datos2=pokemon2.Atacar(pokemon2.Movimientos())
          if (ComprobarAcierto(datos2[3].toInt(),pokemon1.evasion)){ //Comprueba que el ataque acierta
              when(datos2[2]){
                  "Fisico"->danio = calcularDanio(pokemon1.currenAttack,pokemon2.currentDefense,datos2[1].toInt(),datos2[3],pokemon2.Type())
                  "Especial" ->danio = calcularDanio(pokemon1.currentSpAttack,pokemon2.currentSpDefense,datos2[1].toInt(),datos2[3],pokemon2.Type())
              }
              pokemon1.recibirDanyo(danio) //Hace to.do el cálculo del daño
              ActivarHabilidad(pokemon1,pokemon2,datos2[4].toInt()) //Activa el efecto del movimiento
              if (pokemon2.estado==1 || pokemon2.estado==3){ //Estos estados se tienen que activar en el mismo momento que se usa el movimiento
                  pokemon2.ComprobarEstado(pokemon2.estado)
              }
              println("${pokemon1.name} ha recibido $danio puntos de daño")
          }else{
              println("${pokemon2.name} ha fallado") }
      }
      if (accion2>7 && accion2<9){ RecibirObjeto(pokemon2,pokemon2.UsarObjeto(pokemon2.Objects()))}
      if (accion2==10){ pokemon2.Evolucionar()}
      println("${pokemon1.name} se ha quedado con ${pokemon1.currentHP}")
      var accion:Int = (1..10).random() // 0=ATK actual, 1=Potencia Movimiento 2=Tipo Movimiento 3=Precision Movimiento 4=Efecto
      if (pokemon1.estado==2) {pokemon1.ComprobarEstado(pokemon1.estado)} //En caso de estar quemado, primero hace el efecto y luego vuelve a la normalidad
      pokemon1.estado=0 //Al principio de cada turno el estado del pokemon vuelve a ser normal
      if (accion<=7){ //Ataca
          var datos=pokemon1.Atacar(pokemon1.Movimientos())
          if (ComprobarAcierto(datos[3].toInt(),pokemon2.evasion)){ //Comprueba que el ataque acierta
              when(datos[2]){
                  "Fisico"->danio = calcularDanio(pokemon1.currenAttack,pokemon2.currentDefense,datos[1].toInt(),datos[3],pokemon2.Type())
                  "Especial" ->danio = calcularDanio(pokemon1.currentSpAttack,pokemon2.currentSpDefense,datos[1].toInt(),datos[3],pokemon2.Type())
              }
              pokemon2.recibirDanyo(danio) //Hace to.do el cálculo del daño
              ActivarHabilidad(pokemon1,pokemon2,datos[4].toInt()) //Activa el efecto del movimiento
              if (pokemon1.estado==1 || pokemon1.estado==3){ //Estos estados se tienen que activar en el mismo momento que se usa el movimiento
                  pokemon1.ComprobarEstado(pokemon1.estado)
              }
              println("${pokemon2.name} ha recibido $danio puntos de daño")
          }else{
              println("${pokemon1.name} ha fallado") }
      }
      if (accion>7 && accion<9){ RecibirObjeto(pokemon2,pokemon2.UsarObjeto(pokemon2.Objects()))}
      if (accion==10){ pokemon1.Evolucionar()}

  }
 }
 fun RecibirObjeto(poke:Pokemon, curacion:Int){
     poke.curar(curacion)
 }
 fun calcularDanio(Ataque:Int,Defensa:Int,Potencia:Int,tipo1:String,tipo2:String):Int{ // Hace el cálculo del daño,
  val danio:Int = ((Ataque.toDouble()/Defensa.toDouble())*Potencia.toDouble()*0.5+1).toInt() //tipo1 es el tipo del movimiento
  val modificador= ComprobarEfectividad(tipo1,tipo2)    // y tipo2 el tipo del pokemon enemigo
 when(modificador){
     2.0-> println("Ha sido muy eficaz!!")
     0.5-> println("Ha sido poco eficaz...")
 }
  val danioTotal=danio*modificador
  return danioTotal.toInt()
 }

 fun ComprobarAcierto(Precision:Int,Evasion:Int):Boolean{ //Cuando se usa un movimiento se tira una moneda
     val acierto:Int = (1..Precision).random()            //al aire para ver si acierta o no, para acertar
     if (acierto>Evasion) {return true}                    //el resultado debe ser mayor a la evasión del pokemon enemigo
     return false
 }
  fun ActivarHabilidad(poke:Pokemon,poke2:Pokemon,habilidad:Int){ //En el caso de que un movimiento tenga efecto, cambia el estado del pokemon
  if (habilidad==1){ poke.estado=1 }                             //poke es el pokemon que usa el movimiento, poke2 el enemigo
  if (habilidad==2){ poke2.estado=2 }
  if (habilidad==3){ poke.estado=3 }
  }
  fun ComprobarEfectividad(tipo1: String, tipo2: String):Double{ //Comprueba si el movimiento es efectivo, poco efectivo o neutral
   if (tipo1=="Fuego" && tipo2=="Planta"){ return 2.0 }
   if(tipo1=="Planta" && tipo2=="Agua"){ return 2.0 }
   if(tipo1=="Agua" && tipo2=="Fuego") { return 2.0 }
   if(tipo1=="Agua" && tipo2=="Planta") { return 0.5 }
   if(tipo1=="Fuego" && tipo2=="Agua"){ return 0.5 }
   if (tipo1=="Planta" && tipo2=="Fuego") { return 0.5 }
   return 1.0 }
}

