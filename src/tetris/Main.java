package tetris;

import java.util.Scanner;

public class Main {

	public static void MostrarTaulell(int Tauler[][]) {
		// bucle imprimir la matriz
		for (int i = 0; i < Tauler.length; i++) {
			for (int j = 0; j < Tauler[0].length; j++) {
				System.out.print(Tauler[i][j] + " ");
			}
			System.out.println();
		}
	}

	public static int[][] NovaPieza(int[][] Pieza) {
		int dau = (int) (Math.random() * 7 + 1);
		switch (dau) {
		case 1:// PiezaI
			for (int i = 0; i < 4; i++) {
				Pieza[i][0] = 1;
			}
			break;
		case 2:// PiezaO
			Pieza[3][0] = 2;
			Pieza[3][1] = 2;
			Pieza[2][0] = 2;
			Pieza[2][1] = 2;
			break;
		case 3:// PiezaS
			Pieza[3][0] = 3;
			Pieza[3][1] = 3;
			Pieza[2][1] = 3;
			Pieza[2][2] = 3;
			break;
		case 4:// PiezaJ
			Pieza[3][0] = 4;
			Pieza[3][1] = 4;
			Pieza[2][1] = 4;
			Pieza[1][1] = 4;
			break;
		case 5:// PiezaL
			Pieza[3][0] = 5;
			Pieza[2][0] = 5;
			Pieza[1][0] = 5;
			Pieza[3][1] = 5;
			break;
		case 6:// PiezaZ
			Pieza[3][1] = 6;
			Pieza[3][2] = 6;
			Pieza[2][0] = 6;
			Pieza[2][1] = 6;
			break;
		case 7:// PiezaT
			Pieza[3][0] = 7;
			Pieza[3][1] = 7;
			Pieza[3][2] = 7;
			Pieza[2][1] = 7;
			break;

		default:
			break;
		}
		return Pieza;
	}

	public static int[][] MourePiezaCostats(int[][] Pieza) {
		Scanner scan = new Scanner(System.in);
		boolean lanzar = false;
		while (!lanzar) {
			boolean imposible = false;
			MostrarTaulell(Pieza);
			System.out.println("a: moure esquerra, d: moure dreta, s: llençar peça");
			switch(scan.nextLine().toLowerCase()) {
				case "a":
					for (int i = 0; i < Pieza[0].length&&!imposible; i++) {
						for (int j = 0; j < Pieza.length&&!imposible; j++) {
							if(Pieza[j][i]!=0&&i>0) {
								Pieza[j][i-1] = Pieza[j][i];
								Pieza[j][i] = 0;
							}else if(Pieza[j][i]!=0&&i==0) {
								imposible = true;
							}
						}
					}
					break;
				case "d":
					for (int i = Pieza[0].length-1; i >= 0&&!imposible; i--) {
						for (int j = 0; j <Pieza.length&&!imposible; j++) {
							if(Pieza[j][i]!=0&&i<Pieza[0].length-1) {
								Pieza[j][i+1] = Pieza[j][i];
								Pieza[j][i] = 0;
							}else if(Pieza[j][i]!=0&&i==Pieza[0].length-1) {
								imposible = true;
							}
						}
					}
					break;
				case "s":
					lanzar = true;
					break;
				default:
					break;
			}
		}
		return Pieza;
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
			NovaPieza(Pieza);
			MourePiezaCostats(Pieza);
		}
	}
}
