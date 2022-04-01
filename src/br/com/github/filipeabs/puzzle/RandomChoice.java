package br.com.github.filipeabs.puzzle;

public enum RandomChoice {
	NAO_RANDOMICO(0), RANDOMICO(1);
	private final int valor;
		
	RandomChoice(int valorOpcao){
		valor = valorOpcao;
	}
	
	public int getValor(){
		return valor;
	}
}
