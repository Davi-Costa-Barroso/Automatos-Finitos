package projetoAutomato;

public class Automato {
	Estado estadoInicial;

	Automato(Estado estadoIni) {
		this.estadoInicial = estadoIni;
	}

	public Estado getEstadoInicial() {
		return estadoInicial;
	}

	public boolean procurarPalavra(String palavra) {
		Estado corrente = estadoInicial;
		int tamanho = palavra.length();
		char c;
		// tamanho = 3
		// i = 3
		// 0110
		for (int i = 0; i < tamanho; i++) {
			c = palavra.charAt(i);
			// c = 0
			boolean encontrado = false;
			for (int j = 0; j < corrente.transicoes.size(); j++) {
				if (c == corrente.transicoes.get(j).getSimbolo()) {
					corrente = corrente.transicoes.get(j).proximoEstado;
					encontrado = true;
					break;
				}
			}
			if(encontrado == false) {
				return false;
			}
		}
		return corrente.terminal;
	}
}