package br.com.github.filipeabs.heuristica;

import java.util.ArrayList;
import java.util.Map;
import java.util.PriorityQueue;

import br.com.github.filipeabs.puzzle.Puzzle;

public class HillClimbing {

	private static ArrayList<String> storeSteps;
	private AuxCosts auxCosts;
	private HillClimbing hillClimbing;
	
	public HillClimbing(Puzzle puzzle) {
	}
	
	public Puzzle nextStep(Puzzle puzzle){
		// testa a vizinhanca e olha qual o menor custo de mudanca para atingir o Goal
		// neste caso, verifica cada modificacao possivel da posicao "vazia"/zero, e 
		// checa qual a mudanca que esta mais proxima do Goal		
		Puzzle childPuzzle = auxCosts.checkBestChoice(puzzle, hillClimbing);
		
		return childPuzzle;
	}

	public boolean checkGoal(int[] arrayMix, int[] arrayGoal) {
		return auxCosts.checkGoal(arrayMix, arrayGoal);
	}
}
