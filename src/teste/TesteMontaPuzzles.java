package teste;

import br.com.github.filipeabs.heuristica.*;
import java.io.InputStream;

import br.com.github.filipeabs.puzzle.RandomChoice;
import br.com.github.filipeabs.puzzle.Puzzle;

public class TesteMontaPuzzles {

	public static void main(String[] args) {
		int n = 3;
		System.out.println("Matriz "+n+" x "+n);

		System.out.println("Montar Matriz Randomica");
		Puzzle puzzle  = new Puzzle(n, RandomChoice.RANDOMICO); 

		System.out.println("Montar Matriz Objetivo");
		//Puzzle puzzleGoal  = new Puzzle(n, RandomChoice.NAO_RANDOMICO);
		///puzzleGoal.getGoalArray();
		
		// Imprimindo os Puzzles no console:
		System.out.println();
		
		System.out.println("Bloco puzzle (Objetivo):");
		for (int i = 0; i < n; i++) {
			System.out.print("|");
			for (int j = 0; j < n; j++) {
				System.out.print(puzzle.getPuzzleGoalMatrix()[i][j]+" ");
			}
			System.out.print("|");
			System.out.println();
		}
		System.out.println();
		
		System.out.println("Bloco puzzle (montagem inicial aleatória):");
		for (int i = 0; i < n; i++) {
			System.out.print("|");
			for (int j = 0; j < n; j++) {
				System.out.print(puzzle.getValue(i, j)+" ");
			}
			System.out.print("|");
			System.out.println();
		}
		
		//System.out.println("Qual posicao quer procurar?");
		//InputStream x = System.in;
		int x = 8;
		System.out.println("TESTE: Posicao do "+x+" na Matriz Randomica: ["+puzzle.getPosition(x)[0]+"]["+puzzle.getPosition(x)[1]+"]");
		System.out.println("TESTE: Array Ideal: "+puzzle.getPuzzleGoalArray()[x]);
	
		// Chamando a heuristica:
		HillClimbing heuristica = new HillClimbing(puzzle);
		// Puzzle auxiliar:
		Puzzle puzzleAuxiliar = puzzle;
		
		while (!(heuristica.checkGoal(puzzleAuxiliar.getArrayFromMatrix(), puzzleGoal.getArrayFromMatrix()))){
			puzzleAuxiliar = heuristica.nextStep(puzzleAuxiliar);
		}
			
	}

}
