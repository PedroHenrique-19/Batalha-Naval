package teste1;
import java.util.Scanner;


public class Tabuleiro {
	public static final char player1 = 'X';
	public static final char player2 = 'O';
	static char [][]  tabuleiro = new char[3][3];
	
	public static void main(String[] args) {
		char vencedor = ' ';
		
			
		resetarTabuleiro();
		
		while(vencedor == ' ' || verificarEspacos() != 0) {
			printarTabuleiro();
			
			fazerJogadaPlayer1();
			vencedor = verificarVitoria();
			if(vencedor != ' ' || verificarEspacos() == 0)
				break;
			printarTabuleiro();
			
			fazerJogadaPlayer2();
			vencedor = verificarVitoria();
			if(vencedor != ' ' || verificarEspacos() == 0)
				break;
			
		}
			printarTabuleiro();
			verificarVencedor(vencedor);
		
	}
	
	
	public static void printarTabuleiro() {
		
	
	System.out.printf("  %c  | %c  |%c\n", tabuleiro[0][0], tabuleiro[0][1], tabuleiro[0][2]);
	System.out.println(" ----|----|---");
	System.out.printf("  %c  | %c  |%c\n", tabuleiro[1][0],tabuleiro[1][1], tabuleiro[1][2]);
	System.out.println(" ----|----|---");
	System.out.printf("  %c  |  %c |%c\n", tabuleiro[2][0],tabuleiro[2][1], tabuleiro[2][2]);
	
	}
	
	public static void resetarTabuleiro() {
		for(int i=0; i < 3; i++) {
			for(int j= 0; j < 3; j++) {
				tabuleiro[i][j] = ' ';
			}
		}
	}
	
	
	public static int verificarEspacos() {
		int espacos = 9;
		
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j ++) {
				if(tabuleiro[i][j] != ' ') {
					espacos --;
					if(espacos == 0) {
						return 0;
					}
				}
			}
		}
			return espacos;
	}
	
	
	public static void verificarVencedor(char vencedor) {
		
		if(vencedor == player1) {
			System.out.println("parabens player 1!!");
		}else if(vencedor == player2) {
			System.out.println("parabens player 2!!");
		}else {
			System.out.println("empate");
			}
		
	}
	
	
	public static void fazerJogadaPlayer1() {
		Scanner scanner = new Scanner(System.in);
		int linha, coluna;
		
		while(true) {
		System.out.println("Player1 digite a posicao da linha: ");
		linha = scanner.nextInt();
		System.out.println("Player1 digite a posica da coluna: ");
		coluna = scanner.nextInt(); 
		
		if(linha >= 0 && linha < 3 && coluna >= 0 && coluna < 3) {
			if(tabuleiro[linha][coluna] == ' ') {
				tabuleiro[linha][coluna] = player1;
				break;
			}else 
				System.out.println("Moviemnto invalido, posicao ocupada!");
			
		}else 
			System.out.println("posicao invalida!");
		}
	}
	
	
	public static void fazerJogadaPlayer2() {
		Scanner scanner = new Scanner(System.in);
		int linha, coluna;
		
		while(true) {
		System.out.println("Player2 digite a posicao da linha: ");
		linha = scanner.nextInt();
		System.out.println("Player2 digite a posica da coluna: ");
		coluna = scanner.nextInt(); 
		
		if(linha >= 0 && linha < 3 && coluna >= 0 && coluna < 3) {
			if(tabuleiro[linha][coluna] == ' ') {
				tabuleiro[linha][coluna] = player2;
				break;
			}else 
				System.out.println("Moviemnto invalido, posicao ocupada!");
			
		}else 
			System.out.println("posicao invalida!");
		}
	}
	
	public static char verificarVitoria() {
		for(int i =0; i < 3; i ++) {
			if(tabuleiro[0][i] == tabuleiro[1][i] & tabuleiro[0][i] == tabuleiro[2][i]) {
				return tabuleiro[0][i];
			}
		}
		
		for(int i =0; i < 3; i++) {
			if(tabuleiro[i][0] == tabuleiro[i][1] && tabuleiro[i][0] == tabuleiro[i][2]) {
				return tabuleiro[i][0];
			}
		}
		
		for(int i = 0; i < 3; i ++) {
			if(tabuleiro[0][0] == tabuleiro[1][1] && tabuleiro[0][0] == tabuleiro[2][2]) {
				return tabuleiro[0][0];
			}
		}
		for(int i = 0; i < 3; i++) {
			if(tabuleiro[0][2] == tabuleiro[1][1] && tabuleiro[0][2] == tabuleiro[2][0]) {
				return tabuleiro[0][2];
			}
		}
		return ' ';
	}
}
