package automato;

import java.util.LinkedList;

public class Estado {
	LinkedList<Transicao> transicoes = new LinkedList<Transicao>();
	private boolean terminal;
	private int identificador;
	public static int contadorInstancias = 0;

	public Estado(boolean terminal) {
		this.terminal = terminal;
		this.identificador = contadorInstancias;
		contadorInstancias++;
	}

	public LinkedList<Transicao> getTransicoes() {
		return transicoes;
	}

	public void setTransicoes(LinkedList<Transicao> transicoes) {
		this.transicoes = transicoes;
	}

	public boolean isTerminal() {
		return terminal;
	}

	public void setTerminal(boolean terminal) {
		this.terminal = terminal;
	}

	public int getIdentificador() {
		return identificador;
	}

	public void setIdentificador(int identificador) {
		this.identificador = identificador;
	}

}