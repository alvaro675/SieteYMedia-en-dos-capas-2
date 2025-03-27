import recursos.Carta

fun presentarJuego(){
    println("- El usuario es el jugador y el ordenador la  banca.")
    println("- No hay en la baraja 8s y 9s. El 10 es la sota, el 11 el caballo y el 12 el Rey.")
    println("- las figuras (10-sota, 11-caballo y 12-rey) valen medio punto y, el resto, su valor.")
    println(
        "- Hay dos turnos de juego: el turno del jugador y el turno de la banca. Se comienza por el turno del jugador.");
    println("- El jugador va pidiendo cartas a la banca de una en una.");
    println("- El jugador puede plantarse en cualquier momento.");
    print("- Si la suma de los valores de las cartas sacadas es superior ");
    println("a 7 y medio, el jugador 'se pasa de siete y medio' y  pierde.");
    println(
        "- Si el jugador no se pasa, comienza a sacar cartas la banca y ésta  está obligada a sacar cartas hasta empatar o superar al jugador.");
    println(
        "- Si la banca consigue empatar o superar la puntuación del jugador 'sin pasarse de siete y medio', gana la banca.");
    println(
        "- La banca no se puede plantar y tiene que empatar o superar la puntuación del  jugador sin pasarse.");
    println(
        "- En este proceso puede ocurrir que la banca 'se pase' y entonces pierde la banca y gana el jugador.");
    println("\nEmpecemos!!!\n");
}
fun turnoJugador() { //tiene codigo java cambialo a kotlin

    var  opc = 'C';
    // obligamos a que como mínimo se tenga 1 carta
        println("Como mínimo recibes una carta, luego puedes decidir si seguir o plantarte");
    while (objeto.valorCartas(objeto.cartasJugador) < 7.5 && opc == 'C') {
        var c:Carta = objeto.baraja.darCartas(1)[0];
        // insertamos c en las cartas del jugador
        objeto.insertarCartaEnArray(objeto.cartasJugador, c);
        // mostramos cartas y su valor, si se pasa se sale del bucle
        println("Éstas son tus cartas jugador:");
        objeto.mostrarCartas(objeto.cartasJugador);
        var valor:Double = objeto.valorCartas(objeto.cartasJugador);
        println("\n\tValor de cartas: " + valor);
        if (valor < 7.5) {
            // suponemos que el usuario teclea bien !!!
            System.out.println("\n¿Pides [C]arta o te [P]lantas?");
            opc = readln()[0].uppercaseChar()//.trim().toUpperCase().charAt(0);                          //buscar como pasar trim a readln
        }

    }

}
fun turnoBanca() {
    // lo primero es consultar el valor que alcanzó el jugador en su turno
    var valorCartasJugador:Double = objeto.valorCartas(objeto.cartasJugador);
    if (valorCartasJugador > 7.5) {
        println("Jugador, te has pasado en tu jugada anterior, gana la banca");
        return;
    }
    System.out.println("\n\nTurno de banca ...");

    // juega hasta empatar o superar
    while (objeto.valorCartas(objeto.cartasBanca) < valorCartasJugador) {
        var c:Carta = objeto.baraja.darCartas(1)[0];
        objeto.insertarCartaEnArray(objeto.cartasBanca, c);
    }
    println("Éstas son mis cartas:");
    objeto.mostrarCartas(objeto.cartasBanca);
    println("\nValor de  mis cartas(banca): " + objeto.valorCartas(objeto.cartasBanca));
    if (objeto.valorCartas(objeto.cartasBanca) > 7.5) {
        println("me pasé, ganas tú,jugador");
    } else {
        println("Gana la banca");
    }
}

var objeto= SieteYMedia()

fun jugar() {
    turnoJugador()
    turnoBanca()
    println("Adios")
}

fun main() {
    presentarJuego()
    jugar()

}

