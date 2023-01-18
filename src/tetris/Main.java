package tetris;

import java.util.Scanner;

public class Main {

	public static void MostrarTaulell(int Taulell[][]) {
		// bucle imprimir la matriz
		for (int i = 0; i < Taulell.length; i++) {
			for (int j = 0; j < Taulell[0].length; j++) {
				System.out.print(Taulell[i][j] + " ");
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
