package teste1;
import java.util.Scanner;

public class TabuleiroNaval {

	public static final char VAZIO = ' ';
	public static final char ATACADO = '*';
	public static final char ERRO = '~';
	public static final char Jogador1 = 'X';
	public static final char Jogador2 = 'X';
	public static int NaviosJogador1 = 3;
	public static int NaviosJogador2 = 3;
	public static int NaviosPosicionadosJogador1 = 9;
	public static int NaviosPosicionadosJogador2 = 9;
	
	 public static char [][] tabuleiroJogador1;
	 public static char[][] tabuleiroJogador2;
	 public static char [][] tabuleiroGeral1;
	 public static char [][] tabuleiroGeral2;
	 
	 Scanner scanner;
	
	TabuleiroNaval(){
		tabuleiroJogador1 = new char [7][7];
		tabuleiroJogador2 = new char[7][7];
		tabuleiroGeral1 = new char[7][7];
		tabuleiroGeral2 = new char[7][7];
		scanner = new Scanner(System.in);
		inicializarTabuleiro(tabuleiroJogador1);
        inicializarTabuleiro(tabuleiroJogador2);
	}
	
	void inicializarTabuleiro(char[][] tabuleiro) {
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 7; j++) {
                tabuleiro[i][j] = VAZIO;
            }
        }
    }

    
    void imprimirTabuleiro(char[][] tabuleiro) {
        System.out.print("  "); 
        for (int i = 0; i < 7; i++) {
            System.out.print(i + " ");
        }
        System.out.println();

        for (int i = 0; i < 7; i++) {
            System.out.print(i + " "); 
            for (int j = 0; j < 7; j++) {
                System.out.print(tabuleiro[i][j] + " ");
            }
            System.out.println();
        }
    }
    
 
	
	void posionarNavioJogador1() {
		
		System.out.println("Escolha 3 posições para o seu navio (linha e coluna)");
		
		
		while(NaviosPosicionadosJogador1 > 0 ) {
			System.out.println("Posição restante: " + NaviosPosicionadosJogador1);
			int linha = scanner.nextInt();
			int coluna = scanner.nextInt();
			
			
			if(linha >= 0 && linha < 7 && coluna >= 0 && coluna < 7) {
				if(tabuleiroJogador1[linha][coluna] == VAZIO) {
					tabuleiroJogador1[linha][coluna] = Jogador1;
					NaviosPosicionadosJogador1 --;
					
				}else {
					System.out.println("Posicao ja ocupada");
				}
			}else {
				System.out.println("Movimento inválido, fora do tabuleiro");
				}
			}
		}
	
	
	
	void posionarNavioJogador2() {
		
		while(NaviosPosicionadosJogador2 > 0) {
		System.out.println("Posição restante: " + NaviosPosicionadosJogador2);
		int linha = scanner.nextInt();
		int coluna = scanner.nextInt();
		
		
		if(linha >= 0 && linha < 7 && coluna >= 0 && coluna < 7) {
			if(tabuleiroJogador2[linha][coluna] == VAZIO) {
				tabuleiroJogador2[linha][coluna] = Jogador2;
				NaviosPosicionadosJogador2 --;
			}else {
				System.out.println("Posicao ja ocupada");
			}
			}else {
				System.out.println("Movimento inválido, fora do tabuleiro");
				}
			}
			System.out.println("Jogador 2 posicionou todos seus navios");
		}
	
	
	void verificarAtaqueJogador1() {
		System.out.println("Jogador 1, escolha a linha e a coluna para atacar: ");
		int linha = scanner.nextInt();
		int coluna = scanner.nextInt();
		
		 if (linha >= 0 && linha < 7 && coluna >= 0 && coluna < 7) {
	            if (tabuleiroGeral2[linha][coluna] != ATACADO && tabuleiroGeral2[linha][coluna] != ERRO) {
	                if (tabuleiroJogador2[linha][coluna] == Jogador2) {
	                    System.out.println("Você acertou o navio inimigo.");
	                    NaviosJogador2--;
	                    tabuleiroGeral2[linha][coluna] = ATACADO;
	                } else {
	                    System.out.println("Você errou o ataque");
	                    tabuleiroGeral2[linha][coluna] = ERRO;
	                }
	            } else {
	                System.out.println("Esta posição já foi atacada");
	            }
	        } else {
	            System.out.println("Movimento fora do tabuleiro");
	        }
	}
	
	
	void verificarAtaqueJogador2() {
		System.out.println("Jogador 2, escolha a linha e a coluna para atacar: ");
		int linha = scanner.nextInt();
		int coluna = scanner.nextInt();
		 if (linha >= 0 && linha < 7 && coluna >= 0 && coluna < 7) {
	            if (tabuleiroGeral1[linha][coluna] != ATACADO && tabuleiroGeral1[linha][coluna] != ERRO) {
	                if (tabuleiroJogador1[linha][coluna] == Jogador1) {
	                    System.out.println("Você acertou o navio inimigo.");
	                    NaviosJogador1--;
	                    tabuleiroGeral1[linha][coluna] = ATACADO;
	                } else {
	                    System.out.println("Você errou o ataque");
	                    tabuleiroGeral1[linha][coluna] = ERRO;
	                }
	            } else {
	                System.out.println("Esta posição já foi atacada");
	            }
	        } else {
	            System.out.println("Movimento fora do tabuleiro");
	        }
	}
	
	
	char verificarVitoria() {
		if(NaviosJogador1 == 0){
			System.out.println("Parabens jogador 2, voce venceu!!!");
			return Jogador2;
		}else	if(NaviosJogador2 == 0) {
			System.out.println("Parabens jogador 1, voce venceu!!!");
			return Jogador1;
		}
		return ' ';
	}
	
}
