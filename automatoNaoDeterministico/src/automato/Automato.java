package automato;

import java.util.LinkedList;

public class Automato {
	Estado estadoInicial;

	public Estado getEstadoInicial() {
		return estadoInicial;
	}

	public void criarAutomato(String regex) {
		char caractereAtual;
		Estado estadoAtual = new Estado(false);
		this.estadoInicial = estadoAtual;
		for (int i = 0; i < regex.length(); i++) {
			caractereAtual = regex.charAt(i);
			if (caractereAtual == '1' || caractereAtual == '0') {
				if (i == (regex.length() - 1)) {
					Estado estadoFinal = new Estado(true);
					estadoAtual.transicoes.add(new Transicao(caractereAtual, estadoFinal));
					estadoAtual = estadoFinal;
				} else {
					if (regex.charAt(i + 1) == '*') {
						estadoAtual.transicoes.add(new Transicao(caractereAtual, estadoAtual));
						i++;
					} else if (regex.charAt(i + 1) == '?') {
						Estado proximoEstado = new Estado(false);
						estadoAtual.transicoes.add(new Transicao('E', proximoEstado));
						estadoAtual.transicoes.add(new Transicao(caractereAtual, proximoEstado));
						estadoAtual = proximoEstado;
						i++;
					} else if (regex.charAt(i + 1) == '+') {
						Estado proximoEstado = new Estado(false);
						estadoAtual.transicoes.add(new Transicao(caractereAtual, proximoEstado));
						proximoEstado.transicoes.add(new Transicao(caractereAtual, proximoEstado));
						estadoAtual = proximoEstado;
						i++;
					} else {
						Estado proximoEstado = new Estado(false);
						estadoAtual.transicoes.add(new Transicao(caractereAtual, proximoEstado));
						estadoAtual = proximoEstado;
					}
				}
			}

			else if (caractereAtual == 'T') {
				if (i == (regex.length() - 1)) {
					Estado estadoFinal = new Estado(true);
					estadoAtual.transicoes.add(new Transicao(caractereAtual, estadoFinal));
					estadoAtual = estadoFinal;
				} else {
					if (regex.charAt(i + 1) == '*') {
						estadoAtual.transicoes.add(new Transicao('0', estadoAtual));
						estadoAtual.transicoes.add(new Transicao('1', estadoAtual));
						i++;
					} else if (regex.charAt(i + 1) == '?') {
						Estado proximoEstado = new Estado(false);
						estadoAtual.transicoes.add(new Transicao('E', proximoEstado));
						estadoAtual.transicoes.add(new Transicao('0', proximoEstado));
						estadoAtual.transicoes.add(new Transicao('1', proximoEstado));
						estadoAtual = proximoEstado;
						i++;
					} else if (regex.charAt(i + 1) == '+') {
						Estado proximoEstado = new Estado(false);
						estadoAtual.transicoes.add(new Transicao('0', proximoEstado));
						estadoAtual.transicoes.add(new Transicao('1', proximoEstado));
						proximoEstado.transicoes.add(new Transicao('0', proximoEstado));
						proximoEstado.transicoes.add(new Transicao('1', proximoEstado));
						estadoAtual = proximoEstado;
						i++;
					} else {
						Estado proximoEstado = new Estado(false);
						estadoAtual.transicoes.add(new Transicao('0', proximoEstado));
						estadoAtual.transicoes.add(new Transicao('1', proximoEstado));
						estadoAtual = proximoEstado;
					}
				}
			}
			if (i == regex.length() - 1) {
				estadoAtual.setTerminal(true);
			}
		}
	}

	public boolean processarPalavra(String palavra) {
		Estado corrente = estadoInicial;
		LinkedList<Estado> estadosCorrente = new LinkedList<>();
		estadosCorrente.add(estadoInicial);
		for (int i = 0; i < palavra.length(); i++) {
			LinkedList<Estado> proximosEstados = new LinkedList<>();
			char c = palavra.charAt(i);
			for (int j = 0; j < estadosCorrente.size(); j++) {// estadosCorrente = q0
				corrente = estadosCorrente.get(j);
				for (int k = 0; k < corrente.transicoes.size(); k++) {
					if (corrente.transicoes.get(k).getSimbolo() == 'E') {
						if (!estadosCorrente.contains(corrente.transicoes.get(k).getProximoEstado())) {
							estadosCorrente.add(corrente.transicoes.get(k).getProximoEstado());
						}
					}
					if (c == corrente.transicoes.get(k).getSimbolo()) {
						if (!proximosEstados.contains(corrente.transicoes.get(k).getProximoEstado())) {
							proximosEstados.add(corrente.transicoes.get(k).getProximoEstado());
						}
					}
				}
			}
			estadosCorrente = proximosEstados;
			if (proximosEstados.size() == 0) {
				return false;
			}
		}

		for (Estado estado : estadosCorrente) {
			// System.out.println("q" + estado.getIdentificador());
			if (estado.isTerminal()) {
				return true;
			}
		}
		return false;
	}
}