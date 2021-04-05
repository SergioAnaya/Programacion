package Ejercicio2;

public class Juego {

	// Esta clase contiene como atributo una matriz cuatrada de 3x3 que inicializaremos unicamente con
	// valores 0 o 1.
	int [][] matriz ={{1, 1, 0},
					  {0, 1, 0},
					  {1, 0, 0}};

	/**
	 * Logica principal del juego, que comprueba quien de las dos fichas ha ganado
	 * @param ficha Ficha que queremos comprobar si ha ganado o no
	 * @return un boolean en consonancia si ha ganado o no
	 */
	public boolean tresEnRaya(int ficha)
	{
		int contadorVertical, contadorHorizontal, contadorDiagonalDesc, contadorDiagonalAsc, valueToCheckAsc;
		int arrayTamano = this.matriz.length;
		for (int i = 0; i < arrayTamano; i++){
			contadorVertical = 0;
			contadorHorizontal = 0;
			contadorDiagonalDesc = 0;
			contadorDiagonalAsc = 0;
			for (int j = 0; j < arrayTamano; j++){
				if (matriz[i][j] == ficha)
					contadorHorizontal++;
				if (matriz[j][i] == ficha)
					contadorVertical++;
				if (matriz[j][j] == ficha)
					contadorDiagonalDesc++;
				valueToCheckAsc = arrayTamano - 1 - j;
				if (matriz[j][valueToCheckAsc] == ficha)
					contadorDiagonalAsc++;
			}
			if (contadorVertical == 3 || contadorHorizontal == 3 || contadorDiagonalAsc == 3 || contadorDiagonalDesc == 3)
				return true;
		}
		return false;
	}

	public static void main(String[] args) {
		boolean ganador;
		Juego miJuego = new Juego();
		System.out.println("Competicion nacional de 3 en raya\n" +
				"Analizando los resultados...");
		System.out.print("El jugador 1 ha sido: ");
		ganador = miJuego.tresEnRaya(1);
		if (ganador)
			System.out.println("GANADOR");
		else
			System.out.println("PERDEDOR");
		ganador = miJuego.tresEnRaya(0);
		System.out.print("El jugador 0 ha sido: ");
		if (ganador)
			System.out.println("GANADOR");
		else
			System.out.println("PERDEDOR");

	}


}