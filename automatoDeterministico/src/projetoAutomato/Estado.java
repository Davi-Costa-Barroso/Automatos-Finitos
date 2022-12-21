package projetoAutomato;

import java.util.ArrayList;

public class Estado {
	ArrayList<Transicao> transicoes = new ArrayList<Transicao>();
	boolean terminal;
	int identificador;
	static int contadorInstancia = 0;

	public Estado() {
		this.identificador = contadorInstancia;
		contadorInstancia++;
	}
	public Estado(boolean terminal) {
		this ();
		this.terminal = terminal;
	}

}