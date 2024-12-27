package teste1;

public class BatalhaNavalTeste {
	public static void main(String[] args) {
		TabuleiroNaval tabuleiro = new TabuleiroNaval();
		char vencedor = ' ';
		
		
	System.out.println("Bem-vindo ao Jogo de Batalha Naval!");
	
	
	System.out.println("Jogador 1, posicione seus navios.");
		 
	tabuleiro.imprimirTabuleiro(TabuleiroNaval.tabuleiroJogador1);
	
	tabuleiro.posionarNavioJogador1();
	
	System.out.println("Tabuleiro final do Jogador 1:");
	
    tabuleiro.imprimirTabuleiro(TabuleiroNaval.tabuleiroJogador1);;
	
	
	System.out.println("Jogador 2, posicione seus navios.");
	
	tabuleiro.posionarNavioJogador2();
	
	tabuleiro.imprimirTabuleiro(TabuleiroNaval.tabuleiroJogador2);
	
	System.out.println("Tabuleiro final do Jogador 2:");
	
    tabuleiro.imprimirTabuleiro(TabuleiroNaval.tabuleiroJogador2);
        
        
    while(vencedor == ' ') {
        
        tabuleiro.verificarAtaqueJogador1();
        tabuleiro.imprimirTabuleiro(TabuleiroNaval.tabuleiroGeral2);
        vencedor = tabuleiro.verificarVitoria();
        	
        if(vencedor != ' ')
        	break;
        	
        tabuleiro.verificarAtaqueJogador2();
        tabuleiro.imprimirTabuleiro(TabuleiroNaval.tabuleiroGeral2);
        vencedor = tabuleiro.verificarVitoria();
        }
        
	}
}
