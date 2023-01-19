package tetris;

import java.util.Scanner;

public class ControlPieza {
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
			Main.MostrarTaulell(Pieza);
			System.out.println("a: moure esquerra, d: moure dreta, s: llençar peça");
			switch (scan.nextLine().toLowerCase()) {
			case "a":
				Pieza = MoureEsquerra(Pieza);
				break;
			case "d":
				Pieza = MoureDreta(Pieza);
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

	public static int[][] MoureEsquerra(int[][] Pieza) {
		boolean imposible = false;
		for (int i = 0; i < Pieza[0].length && !imposible; i++) {
			for (int j = 0; j < Pieza.length && !imposible; j++) {
				if (Pieza[j][i] != 0 && i > 0) {
					Pieza[j][i - 1] = Pieza[j][i];
					Pieza[j][i] = 0;
				} else if (Pieza[j][i] != 0 && i == 0) {
					imposible = true;
				}
			}
		}
		return Pieza;
	}

	public static int[][] MoureDreta(int[][] Pieza) {
		boolean imposible = false;
		for (int i = Pieza[0].length - 1; i >= 0 && !imposible; i--) {
			for (int j = 0; j < Pieza.length && !imposible; j++) {
				if (Pieza[j][i] != 0 && i < Pieza[0].length - 1) {
					Pieza[j][i + 1] = Pieza[j][i];
					Pieza[j][i] = 0;
				} else if (Pieza[j][i] != 0 && i == Pieza[0].length - 1) {
					imposible = true;
				}
			}
		}
		return Pieza;
	}

	public static void ActualitzarTaulell(int[][] Taulell) {
		for (int j = Taulell.length - 2; j >= 0; j--) {
			for (int k = 0; k < Taulell[0].length; k++) {
				if (Taulell[j][k] != 0 && Taulell[j + 1][k] == 0) {
					Taulell[j + 1][k] = Taulell[j][k];
					Taulell[j][k] = 0;
				}
			}
		}
	}

	public static boolean PonerPieza(int[][] Pieza, int[][] Taulell) {
		int alturaPieza = 3;
		boolean posible = true;
		for (int i = 0; i < Pieza.length; i++) {
			for (int j = 0; j < Pieza[0].length; j++) {
				if (Pieza[i][j] != 0) {
					alturaPieza = Math.min(alturaPieza, i);
					if (Taulell[i - alturaPieza][j] == 0) {
						Taulell[i - alturaPieza][j] = Pieza[i][j];
					} else {
						posible = false;
					}
				}
			}
		}
		return posible;
	}

	public static void BajarPieza(int[][] Taulell) {
		
	}

	public static int[][] FerCaureLaPieza(int[][] Pieza, int[][] Taulell) {
		boolean posible = PonerPieza(Pieza, Taulell);
		if(posible) {
			BajarPieza(Taulell);
		}
		return Taulell;
	}
}

