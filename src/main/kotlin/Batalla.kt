class Batalla(pokemon1:Pokemon, pokemon2:Pokemon) {
 fun turnos(poke1:Pokemon,poke2:Pokemon){
  if (poke1.velocidad>poke2.velocidad){ //Comprueba quien es más rápido, ese empieza //Anotación de la lista DatosMovimiento:
    var accion:Int = (1..10).random() // 0=ATK actual, 1=Potencia Movimiento 2=Tipo Movimiento 3=Precision Movimiento 4=Efecto
    if (poke1.estado==2) {poke1.ComprobarEstado(poke1.estado)} //En caso de estar quemado, primero hace el efecto y luego vuelve a la normalidad
    poke1.estado=0 //Al principio de cada turno el estado del pokemon vuelve a ser normal
    if (accion<=7){ //Ataca
      var datos=poke1.Atacar(poke1.Movimientos())
      if (ComprobarAcierto(datos[3].toInt(),poke2.evasion)){ //Comprueba que el ataque acierta
       poke2.recibirDanyo(calcularDanio(poke1.currenAttack,poke2.currentDefense,datos[1].toInt(),datos[2],poke2.Type())) //Hace to.do el cálculo del daño
       ActivarHabilidad(poke1,poke2,datos[4].toInt()) //Activa el efecto del movimiento
       if (poke1.estado==1 || poke1.estado==3){ //Estos estados se tienen que activar en el mismo momento que se usa el movimiento
        poke1.ComprobarEstado(poke1.estado)
       }
      }else{
       println("${poke1.name} ha fallado") }
    }
    if (accion>7 && accion<9){ RecibirObjeto(poke1,poke1.UsarObjeto(poke1.Objects()))}
    if (accion==10){ poke1.evolucionar()}
   var accion2:Int = (1..10).random() // 0=ATK actual, 1=Potencia Movimiento 2=Tipo Movimiento 3=Precision Movimiento 4=Efecto
   if (poke1.estado==2) {poke1.ComprobarEstado(poke1.estado)} //En caso de estar quemado, primero hace el efecto y luego vuelve a la normalidad
   poke1.estado=0 //Al principio de cada turno el estado del pokemon vuelve a ser normal
   if (accion2<=7){ //Ataca
    var datos=poke1.Atacar(poke1.Movimientos())
    if (ComprobarAcierto(datos[3].toInt(),poke2.evasion)){ //Comprueba que el ataque acierta
     poke2.recibirDanyo(calcularDanio(poke1.currenAttack,poke2.currentDefense,datos[1].toInt(),datos[2],poke2.Type())) //Hace to.do el cálculo del daño
     ActivarHabilidad(poke1,poke2,datos[4].toInt()) //Activa el efecto del movimiento
     if (poke1.estado==1 || poke1.estado==3){ //Estos estados se tienen que activar en el mismo momento que se usa el movimiento
      poke1.ComprobarEstado(poke1.estado)
     }
    }else{
     println("${poke1.name} ha fallado") }
   }
   if (accion2>7 && accion<9){ RecibirObjeto(poke1,poke1.UsarObjeto(poke1.Objects()))}
   if (accion2==10){ poke1.evolucionar()}
  }
 }
 fun RecibirObjeto(poke:Pokemon, curacion:Int){
     poke.curar(curacion)
 }
 fun calcularDanio(Ataque:Int,Defensa:Int,Potencia:Int,tipo1:String,tipo2:String):Int{ // Hace el cálculo del daño,
  val danio:Int = ((Ataque.toDouble()/Defensa.toDouble())*Potencia.toDouble()*0.5+1).toInt() //tipo1 es el tipo del movimiento,
                                                                                       // y tipo2 el tipo del pokemon enemigo*/
  val modificador= ComprobarEfectividad(tipo1,tipo2)
  val danioTotal=danio*modificador
  return danioTotal.toInt()
 }
 fun ComprobarAcierto(Precision:Int,Evasion:Int):Boolean{ //Cuando se usa un movimiento se tira una moneda
     val acierto:Int = (1..Precision).random()            //al aire para ver si acierta o no, para acertar
     if (acierto>Evasion) return true                     //el resultado debe ser mayor a la evasión del pokemon enemigo
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
