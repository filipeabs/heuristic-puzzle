package br.com.github.filipeabs.puzzle;

import java.util.Map;
import java.util.Random;

public class Puzzle extends SquareMatrix {

    private static int numeroDeInstanciasChamadas = 0;
    private static int grau;
    
	public Puzzle(int grau, RandomChoice opcao) {		
		super(setArrayNumbers(grau, opcao));
	}
	
	public int getNumeroInstancias() {
		return Puzzle.numeroDeInstanciasChamadas;
	}	
	
	private static int[] setArrayNumbers(int grau, RandomChoice opcao) {
		int qd = grau*grau;
		int[] incluiNum = new int[qd]; // array com todas as posições com 0 (zero)
		
		if(RandomChoice.RANDOMICO == opcao) { /*matriz aleatoria*/
			Random rd = new Random(); // Objeto Random
			
			int numRandomizado;
			int posicaoZero = rd.nextInt(qd); /*Escolha de uma POSICAO aleatorio para o numero 0 (zero), uma vez
			                                    que um array é inicializado com 0 (zero) em todas as posições.*/
			
			for (int i = 0; i < incluiNum.length; i++) {
				numRandomizado = rd.nextInt(qd); // : de 0..[quadrado - 1];

				while (contains(incluiNum, numRandomizado)) { // quero um numero aleatorio nao repetido
					numRandomizado = rd.nextInt(qd); 
				}
				incluiNum[i] = ((posicaoZero == i) ? 0 : numRandomizado);  /* evitar que na POSICAO escolhida para 
				                                                              o NUMERO zero tenha outro novo valor*/
			}
			
		} else { /*matriz ideal*/
			for (int i = 0; i < incluiNum.length; i++) {
				incluiNum[i] = i;
			}
		}
		return incluiNum;
	}
	
	// O que pode ser feito com o Puzzle?
	
	
	public Map<Integer, String> legalActions() { // Quais movimentos de posicao o Zero pode fazer?
		Map<Integer, String> movimentos = Map.of(0,"X", 1,"X", 2,"X", 3,"X");
		int[] posicao = this.getPosition(0);
		
		if ((posicao[1] - 1) > 0)                movimentos.put(0, "U"); /*UP   */
		if ((posicao[1] + 1) < this.getDegree()) movimentos.put(1, "D"); /*DOWN */
		/*--------------------------------------------------------------------- */
		if ((posicao[0] - 1) > 0)                movimentos.put(2, "L"); /*LEFT */ 
		if ((posicao[0] + 1) < this.getDegree()) movimentos.put(3, "R"); /*RIGHT*/
		
		return movimentos;
	}
	
	// Gerando filhos
	public Puzzle(int[] listaDosNumeros) {
		super(listaDosNumeros);
		numeroDeInstanciasChamadas += 1;
	}

	public int[] getPuzzleGoalArray() {
		return setArrayNumbers(this.getDegree(), RandomChoice.NAO_RANDOMICO);
	}

	@SuppressWarnings("null")
	public int[][] getPuzzleGoalMatrix() {
		int num = 0;
		int n = this.getDegree();
		int matrix[][] = new int[n][n];
		for (int i = 0; i < n; i++) { 
			for (int j = 0; j < n; j++) { 
				matrix[i][j] = getPuzzleGoalArray()[num];
			    num += 1;
			}
		}
		return matrix;
	}
}
