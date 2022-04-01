package br.com.github.filipeabs.puzzle;

import java.util.Arrays;
import java.util.Random;

abstract class SquareMatrix {

	private int degree;
	private int square;
	private int matrix[][]; // lista vazia
	
	// #CONSTRUTOR.1
	protected SquareMatrix(int[] listaDosNumeros) {
		this.degree = (int) Math.sqrt(listaDosNumeros.length);
		this.matrix = new int[degree][degree];
		this.square = listaDosNumeros.length;
		SquareMatrixConstuctor(listaDosNumeros);
	}
	
	// "Montador" dos valores da Matriz Quadrada a partir do array de inteiros:
	private void SquareMatrixConstuctor(int[] numsParaIncluir) {
		int num = 0;
		int n = this.degree;
		for (int i = 0; i < n; i++) { 
			for (int j = 0; j < n; j++) { 
				this.setValuePosition(i,j, numsParaIncluir[num]);
			    num += 1;
			}
		}
	}
	
	// ### GETTERS e SETTERS ###
	// Retorna o valor de uma determinada posição:
	public int getValue(int lin, int col) {
		return matrix[lin][col];
	}
	
	// Retorna o grau da matriz quadrada:
	public int getDegree() {
		return degree;
	}

	// Retorna a quantidade de elementos da matriz quadrada:
	public int getSquare() {
		return square;
	}
	
	// Retorna a posição de um determinado valor:
	public int[] getPosition(int valor) {
		int n = this.degree;
		int[] posicao = new int[2];
		for (int lin = 0; lin < n; lin++) { 
			for (int col = 0; col < n; col++) { 
				if (this.matrix[lin][col] == valor) {
					posicao[0] = lin;
					posicao[1] = col;
					return posicao;
				}
			}
		}
		return null;
	}	
	

	public int getArrayPosition(int value, SquareMatrix square) {
		int[] squareArrayUnid = square.getArrayFromMatrix();
		int n = squareArrayUnid.length;
		for (int i = 0; i < n; i++) {
			if ( squareArrayUnid[i] == value) return i;
		}
		return n*n; //nao existe
	}
	

	public int getArrayPosition(int value, int[] squareArrayUnid) {
		int n = squareArrayUnid.length;
		for (int i = 0; i < n; i++) {
			if ( squareArrayUnid[i] == value) return i;
		}
		return n*n; //nao existe
	}
	// ####################### Metodos da classe MatrizQuadrada #######################
	// inserção
	public void setValuePosition(int lin, int col, int valor) {
		try {
			this.matrix[lin][col] = valor;
		}
		catch (Exception e) {
			System.out.println("\n tentativa de inserir uma posicao ("+lin+","+col+") fora do grau da matriz: "+this.degree);
		}
	}

	// comparador
	private boolean compareValues(int valor1, int valor2) {
		return valor1 == valor2;
	}
	
	//gera um Array (unidimensional) a partir da Matriz Quadrada:
	@SuppressWarnings("null")
	public int[] getArrayFromMatrix() {
		int num = 0;
		int n = this.degree;
		int[] numsParaIncluir = new int[n*n];
		for (int i = 0; i < n; i++) { 
			for (int j = 0; j < n; j++) { 
				numsParaIncluir[num] = this.getValue(i,j);
			    num += 1;
			}
		}
		return numsParaIncluir;
	}
	
	protected static boolean contains(final int[] arr, final int key){
		return Arrays.stream(arr).anyMatch(i -> i == key);
	}
}
