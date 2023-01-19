package tetris;

import java.util.Scanner;

public class Main {
	
	public static final String ANSI_RESET = "\u001B[0m";
	public static final String ANSI_BLACK = "\u001B[30m";
	public static final String ANSI_RED = "\u001B[31m";
	public static final String ANSI_GREEN = "\u001B[32m";
	public static final String ANSI_YELLOW = "\u001B[33m";
	public static final String ANSI_BLUE = "\u001B[34m";
	public static final String ANSI_PURPLE = "\u001B[35m";
	public static final String ANSI_CYAN = "\u001B[36m";
	public static final String ANSI_WHITE = "\u001B[37m";

	public static void MostrarTaulell(int Taulell[][]) {
		// bucle imprimir la matriz
		for (int i = 0; i < Taulell.length; i++) {
			for (int j = 0; j < Taulell[0].length; j++) {
				switch(Taulell[i][j]) {
					case 0:
						System.out.print("□");
						break;
					case 1:
						System.out.print(ANSI_CYAN+"■");
						break;
					case 2:
						System.out.print(ANSI_YELLOW+"■");
						break;
					case 3:
						System.out.print(ANSI_GREEN+"■");
						break;
					case 4:
						System.out.print(ANSI_BLUE+"■");
						break;
					case 5:
						System.out.print(ANSI_WHITE+"■");
						break;
					case 6:
						System.out.print(ANSI_RED+"■");
						break;
					case 7:
						System.out.print(ANSI_PURPLE+"■");
						break;
				}
				System.out.print(ANSI_RESET);
			}
			System.out.println();
		}
	}

	
	

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Introdueix l'amplada del taulell: ");
		int amplada = scan.nextInt();
		System.out.println("Introdueix l'alçada del taulell: ");
		int alcada = scan.nextInt();
		int[][] Taulell = new int[alcada][amplada];
		boolean finalPartida = false;
		while (!finalPartida) {
			int[][] Pieza = new int[4][amplada];
			ControlPieza.NovaPieza(Pieza);
			ControlPieza.MourePiezaCostats(Pieza);
			ControlPieza.FerCaureLaPieza(Pieza, Taulell);
			MostrarTaulell(Taulell);
		}
	}
}
