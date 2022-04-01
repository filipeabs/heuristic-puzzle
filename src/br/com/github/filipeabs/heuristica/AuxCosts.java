package br.com.github.filipeabs.heuristica;

import java.util.Map;

import br.com.github.filipeabs.puzzle.Puzzle;
import br.com.github.filipeabs.puzzle.SquareMatrix;

public class AuxCosts {

	private static final Exception err = "Erro de diferença na ordem das matrizes. Não são iguais";

	public AuxCosts() {
		// TODO Auto-generated constructor stub
	}

	protected Puzzle checkBestChoice(Puzzle puzzlePai, HillClimbing hill) {
		int lineZr = puzzlePai.getPosition(0)[0]; 
		int columnZr = puzzlePai.getPosition(0)[1]; 		
		// Agora preciso verificar qual dos puzzles "FILHOS" tem o 
		// menor número de posicões fora do lugar ideal (Goal):
		int k = puzzlePai.getSquare(); //referência do maior CUSTO (3x3=9, p.ex): todas os valores fora de suas posições
		
		Map<Integer, Integer> mapCusto = Map.of(0,k, 1,k, 2,k, 3,k); // uso assim para ajudar a recuperar o menor custo depois
		
		for (int i = 0; i < puzzlePai.legalActions().size(); i++) {
            if (puzzlePai.legalActions().get(i) == "U"){ // Aqui preciso fazer a troca para um filho UP:
            	int novoValor = puzzlePai.getValue(lineZr - 1, columnZr);
            	mapCusto.put(i, checkCosts(novoValor, puzzlePai));
            } else if (puzzlePai.legalActions().get(i) == "D") { // Aqui preciso fazer a troca para um filho DOWN:
            	int novoValor = puzzlePai.getValue(lineZr + 1, columnZr);
            	mapCusto.put(i, checkCosts(novoValor, puzzlePai));
            } else if  (puzzlePai.legalActions().get(i) == "L") { // Aqui preciso fazer a troca para um filho LEFT:
            	int novoValor = puzzlePai.getValue(lineZr, columnZr - 1);
            	mapCusto.put(i, checkCosts(novoValor, puzzlePai));
            } else if  (puzzlePai.legalActions().get(i) == "R") { // Aqui preciso fazer a troca para um filho RIGHT:
            	int novoValor = puzzlePai.getValue(lineZr, columnZr + 1);
            	mapCusto.put(i, checkCosts(novoValor, puzzlePai));
            }
       }
            children.append(Puzzle(new_state,self,action,1,self.needs_hueristic))
		while (!movements.isEmpty()) {	
			PriorityQueue
		}
		// Agora que já sei qual o melhor Puzzle, preciso guardar movimento realizado pelo ZERO.
		storeSteps.add(movements.get(1));
		
		// Devolvo o puzzle FILHO:
		return null;
	}

	public int checkCosts(int novoValor, Puzzle puzzlePai) {
		int cont = 0;
		int arrayPai[] = puzzlePai.getArrayFromMatrix();
    	int posicaoArrayNovoValor = puzzlePai.getArrayPosition(novoValor, arrayPai);
    	int posicaoArrayZero = puzzlePai.getArrayPosition(0, arrayPai);

    	// Agora troco o valor em um novo Puzzle Array Filho:
    	int arrayFilho[] =  arrayPai;
    	arrayFilho[posicaoArrayNovoValor] = 0; // zero vem pra cá
    	arrayFilho[posicaoArrayZero] = novoValor; // no lugar do zero
    	
		int [] arrayPuzzleGoal = puzzlePai.getPuzzleGoalArray();
		
		for (int i = 0; i < arrayPuzzleGoal.length; i++) {
			if (arrayFilho[i] != arrayPuzzleGoal[i]) {
				cont += 1;
			}
		}
		return cont;
	}

	public boolean checkGoal(int[] arrayMix, int[] arrayGoal) {
		if (arrayMix.length != arrayGoal.length) throw err;
		
		for (int i = 0; i < arrayMix.length; i++) {
			if (arrayMix[i] != arrayMix[i]) {
				return false;
			}
		}
		return true;
	}

}
