package motor3R;


public class TresEnRaya {
    
    private char[][] tablero; //creanmos la variable tablero
    public void Game() {
        tablero = new char[3][3];  //creamos la matriz 3x3 que será el tablero

    }


    public void inicializarTablero() {
        
        //inicializamos el tablero
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                tablero[i][j] = '_'; 
            }
        }
    }

    public char[][] getTablero() {
        return tablero;
    }
    
    // Método para validar si una casilla está ocupada
    public boolean validarMovimiento(int fila, int columna) {
        if (fila < 0 || fila >= 3 || columna < 0 || columna >= 3) {
            return false; // No está dentro del tablero
        } else {
            return !casillaOcupada(fila, columna); // Devuelve verdadero si la casilla está vacía
        }
    }


    public boolean casillaOcupada(int fila, int columna) {
        return tablero[fila][columna] != '_';
    }

    public void turnoMaquinaFacil() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (tablero[i][j] == '_') {
                    tablero[i][j] = 'O'; // La máquina elige la primera casilla vacía
                    return;
                }
            }
        }
    }
    public void turnoMaquinaNormal(){
        char jugador = 'X';
        for (int i = 0; i < 3; i++) {
            if (tablero[i][0] == jugador && tablero[i][1] == jugador && tablero[i][2] == '_') {
                tablero[i][2] = 'O';
                return;
            }
            if (tablero[i][0] == jugador && tablero[i][1] == '_' && tablero[i][2] == jugador) {
                tablero[i][1] = 'O';
                return;
            }
            if(tablero[i][0] == '_' && tablero[i][1] == jugador && tablero[i][2] == jugador){
                tablero[i][0] = 'O';
                return;
            }
        }

        for (int j = 0; j < 3; j++) {
            if (tablero[0][j] == jugador && tablero[1][j] == jugador && tablero[2][j] == '_') {
                tablero[2][j] = 'O';
                return;
            }
            if (tablero[0][j] == jugador && tablero[1][j] == '_' && tablero[2][j] == jugador) {
                tablero[1][j] = 'O';
                return;
            }
            if(tablero[0][j] == '_' && tablero[1][j] == jugador && tablero[2][j] == jugador){
                tablero[0][j] = 'O';
                return;
            }
        }

        //verificamos las diagonales
        if ((tablero[0][0] == jugador && tablero[1][1] == jugador && tablero[2][2] == '_') ||
            (tablero[0][0] == jugador && tablero[1][1] == '_' && tablero[2][2] == jugador) ||
            (tablero[0][0] == '_' && tablero[1][1] == jugador && tablero[2][2] == jugador)) {
            tablero[2][2] = 'O';
            return;
        }

        if((tablero[0][2] == jugador && tablero[1][1] == jugador && tablero[2][0] == '_') ||
            (tablero[0][2] == jugador && tablero[1][1] == '_' && tablero[2][0] == jugador) ||
            (tablero[0][2] == '_' && tablero[1][1] == jugador && tablero[2][0] == jugador)){
            tablero[2][0] = 'O';
            return;
        }

        while (true) { // Hacemos esto para que la maquina elija un movimiento aleatorio mientras haya
                       // solo una casilla ocupada en el tablero, ya que no puede comparar nada
            int i = (int) (Math.random() * 3);
            int j = (int) (Math.random() * 3);
            if (tablero[i][j] == '_') {
                tablero[i][j] = 'O';
                return;
            }
        }
    }

    private boolean hacerRaya(char jugador){
        for (int i = 0; i < 3; i++) {
            if (tablero[i][0] == jugador && tablero[i][1] == jugador && tablero[i][2] == '_') {
                tablero[i][2] = 'O';
                return true;
            }
            if (tablero[i][0] == jugador && tablero[i][1] == '_' && tablero[i][2] == jugador) {
                tablero[i][1] = 'O';
                return true;
            }
            if(tablero[i][0] == '_' && tablero[i][1] == jugador && tablero[i][2] == jugador){
                tablero[i][0] = 'O';
                return true;
            }
        }

        //Verificamos las columnas
        for (int j = 0; j < 3; j++) {
            if (tablero[0][j] == jugador && tablero[1][j] == jugador && tablero[2][j] == '_') {
                tablero[2][j] = 'O';
                return true;
            }
            if (tablero[0][j] == jugador && tablero[1][j] == '_' && tablero[2][j] == jugador) {
                tablero[1][j] = 'O';
                return true;
            }
            if(tablero[0][j] == '_' && tablero[1][j] == jugador && tablero[2][j] == jugador){
                tablero[0][j] = 'O';
                return true;
            }
        }

        //verificamos las diagonales
        if ((tablero[0][0] == jugador && tablero[1][1] == jugador && tablero[2][2] == '_') ||
            (tablero[0][0] == jugador && tablero[1][1] == '_' && tablero[2][2] == jugador) ||
            (tablero[0][0] == '_' && tablero[1][1] == jugador && tablero[2][2] == jugador)) {
            tablero[2][2] = 'O';
            return true;
        }

        if((tablero[0][2] == jugador && tablero[1][1] == jugador && tablero[2][0] == '_') ||
            (tablero[0][2] == jugador && tablero[1][1] == '_' && tablero[2][0] == jugador) ||
            (tablero[0][2] == '_' && tablero[1][1] == jugador && tablero[2][0] == jugador)){
            tablero[2][0] = 'O';
            return true;
        }

        return false;
    }
    public void turnoMaquinaDificil(){
        char jugador = 'X';
        if(hacerRaya('O')){
            return;
        }
        if(hacerRaya(jugador)){
            return;
        }
        if(tablero[1][1] == '_'){
            tablero[1][1] = 'O';
            return;
        }
        if(tablero[0][0] == jugador && tablero[2][2] == jugador){
            tablero[0][1] = 'O';
            return;
        }
        if(tablero[0][2] == jugador && tablero[2][0] == jugador){
            tablero[0][1] = 'O';
            return;
        }
        if(tablero[0][0] == jugador && tablero[2][2] == jugador){
            tablero[1][0] = 'O';
            return;
        }
        if(tablero[0][2] == jugador && tablero[2][0] == jugador){
            tablero[1][2] = 'O';
            return;
        }
        if(tablero[0][0] == jugador && tablero[1][1] == jugador){
            tablero[2][2] = 'O';
            return;
        }
        if(tablero[0][2] == jugador && tablero[1][1] == jugador){
            tablero[2][0] = 'O';
            return;
        }
        if(tablero[1][1] == jugador && tablero[2][2] == jugador){
            tablero[0][0] = 'O';
            return;
        }
        if(tablero[1][1] == jugador && tablero[2][0] == jugador){
            tablero[0][2] = 'O';
            return;
        }
        if(tablero[0][0] == jugador && tablero[1][1] == jugador){
            tablero[2][2] = 'O';
            return;
        }
        if(tablero[0][2] == jugador && tablero[1][1] == jugador){
            tablero[2][0] = 'O';
            return;
        }
        if(tablero[1][1] == jugador && tablero[2][2] == jugador){
            tablero[0][0] = 'O';
            return;
        }
    }

    public boolean hayGanador(char jugador) {
        // Verificar filas
        for (int i = 0; i < 3; i++) {
            if (tablero[i][0] == jugador && tablero[i][1] == jugador && tablero[i][2] == jugador) {
                return true; 
            }
        }

        // Verificar columnas
        for (int j = 0; j < 3; j++) {
            if (tablero[0][j] == jugador && tablero[1][j] == jugador && tablero[2][j] == jugador) {
                return true; 
            }
        }

        // Verificar diagonales
        if ((tablero[0][0] == jugador && tablero[1][1] == jugador && tablero[2][2] == jugador) ||
            (tablero[0][2] == jugador && tablero[1][1] == jugador && tablero[2][0] == jugador)) {
            return true;
        }

        return false; // No hay ganador
    }

    public boolean tableroLleno() {
        // Verificar si hay alguna celda vacía en el tablero
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (tablero[i][j] == '_') {
                    return false; // Hay al menos una celda vacía
                }
            }
        }
        return true; // No hay celdas vacías, el tablero está lleno
    }
    
    
    
}