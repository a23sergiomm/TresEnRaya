import java.util.Scanner;
import motor3R.TresEnRaya;
public class InterfaceConsola {

    public static void main(String[] args) {
        TresEnRaya juego = new TresEnRaya();
        juego.Game(); 
        presentar();
        jugar(juego);
    }
    public static Scanner sc = new Scanner(System.in);

    public static void presentar() {
        System.out.println("Bienvenido al juego del tres en raya");
        System.out.println("Tu juegas con la X y la máquina con la O");
    }

    //Mostramos el tablero 
    public static void imprimirTablero(char[][] tablero) {
        System.out.println("---------");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print("|"+tablero[i][j]+"|");
            }
            System.out.println();
        }
        System.out.println("---------");
    }

    public static int[] coordenadas() {
        int[] coordenadas = new int[2];
        System.out.println("Es tu turno, introduce la fila y la columna separadas por un espacio");
        coordenadas[0] = sc.nextInt();
        coordenadas[1] = sc.nextInt();
        return coordenadas;
    }

    public static void jugar(TresEnRaya juego) {
        String otraPartida = "S";
        while(!otraPartida.equals("N")){
            System.out.println("Introduce la dificultad: ");
            System.out.println("\t facil |  normal | dificil");
            String dificultad = sc.next();
            System.out.println("Has seleccionado la dificultad: " + dificultad);
            switch (dificultad) {
                case "facil":
                System.out.println("Nueva partida, tablero vacío:");
                juego.inicializarTablero();
                imprimirTablero(juego.getTablero());
                while (true) {
                    int[] coordenadas = coordenadas(); // Obtener las coordenadas del jugador
                    if (juego.validarMovimiento(coordenadas[0], coordenadas[1])) { // Verificar si el movimiento es válido
                        juego.getTablero()
                        [coordenadas[0]][coordenadas[1]] = 'X'; // Colocar marca X en el tablero
                        imprimirTablero(juego.getTablero()); // Imprimir el tablero después del movimiento del jugador
        
                        // Verificar si el jugador ganó
                        if (juego.hayGanador('X')) {
                            System.out.println("¡Felicidades! ¡Has ganado!");
                            break;
                        }
        
                        // Verificar si hay empate
                        if (juego.tableroLleno()) {
                            System.out.println("¡Es un empate!");
                            break;
                        }
        
                        System.out.println("Turno de la máquina");
                        juego.turnoMaquinaFacil(); // Turno de la máquina
                        imprimirTablero(juego.getTablero()); // Imprimir el tablero después del movimiento de la máquina
        
                        // Verificar si la máquina ganó
                        if (juego.hayGanador('O')) {
                            System.out.println("¡La máquina ha ganado!");
                            break;
                        }
        
                        // Verificar si hay empate
                        if (juego.tableroLleno()) {
                            System.out.println("¡Es un empate!");
                            break;
                        }
                    } else {
                        System.out.println("ERROR, casilla no disponible."); // Mensaje de error de la casilla
                    }
                }
                    break;
                
                case "normal":
                System.out.println("Nueva partida, tablero vacío:");
                juego.inicializarTablero();
                imprimirTablero(juego.getTablero());
                while (true) {
                    int[] coordenadas = coordenadas(); // Obtener las coordenadas del jugador
                    if (juego.validarMovimiento(coordenadas[0], coordenadas[1])) { // Verificar si el movimiento es válido
                        juego.getTablero()
                        [coordenadas[0]][coordenadas[1]] = 'X'; // Colocar marca X en el tablero
                        imprimirTablero(juego.getTablero()); // Imprimir el tablero después del movimiento del jugador
        
                        // Verificar si el jugador ganó
                        if (juego.hayGanador('X')) {
                            System.out.println("¡Felicidades! ¡Has ganado!");
                            break;
                        }
        
                        // Verificar si hay empate
                        if (juego.tableroLleno()) {
                            System.out.println("¡Es un empate!");
                            break;
                        }
        
                        System.out.println("Turno de la máquina");
                        juego.turnoMaquinaNormal(); // Turno de la máquina
                        imprimirTablero(juego.getTablero()); // Imprimir el tablero después del movimiento de la máquina
        
                        // Verificar si la máquina ganó
                        if (juego.hayGanador('O')) {
                            System.out.println("¡La máquina ha ganado!");
                            break;
                        }
        
                        // Verificar si hay empate
                        if (juego.tableroLleno()) {
                            System.out.println("¡Es un empate!");
                            break;
                        }
                    } else {
                        System.out.println("ERROR, casilla no disponible."); // Mensaje de error de la casilla
                    }
                }

                    break;

                case "dificil":
                System.out.println("Nueva partida, tablero vacío:");
                juego.inicializarTablero();
                imprimirTablero(juego.getTablero());
                while (true) {
                    int[] coordenadas = coordenadas(); // Obtener las coordenadas del jugador
                    if (juego.validarMovimiento(coordenadas[0], coordenadas[1])) { // Verificar si el movimiento es válido
                        juego.getTablero()
                        [coordenadas[0]][coordenadas[1]] = 'X'; // Colocar marca X en el tablero
                        imprimirTablero(juego.getTablero()); // Imprimir el tablero después del movimiento del jugador
        
                        // Verificar si el jugador ganó
                        if (juego.hayGanador('X')) {
                            System.out.println("¡Felicidades! ¡Has ganado!");
                            break;
                        }
        
                        // Verificar si hay empate
                        if (juego.tableroLleno()) {
                            System.out.println("¡Es un empate!");
                            break;
                        }
        
                        System.out.println("Turno de la máquina");
                        juego.turnoMaquinaDificil(); // Turno de la máquina
                        imprimirTablero(juego.getTablero()); // Imprimir el tablero después del movimiento de la máquina
    
                    } else {
                        System.out.println("ERROR, casilla no disponible."); // Mensaje de error de la casilla
                    }
                }
                    break;
            
                default:
                System.out.println("ERROR, opción no válida");
                    break;
            }
        
            System.out.println("¿Quieres jugar otra partida? s/n");
            otraPartida = sc.next().toUpperCase();
            while (!otraPartida.equals("S") && !otraPartida.equals("N")) {
                System.out.println("Opción no válida");
                System.out.println("¿Quieres jugar otra partida? s/n");
                otraPartida = sc.next().toUpperCase();   
            }
        }
        System.out.println("Gracias por jugar, hasta la próxima!!!");
    }

}
