package automato;

public class Transicao {
	private char simbolo;
	private Estado proximoEstado;

	public Transicao(char simbolo, Estado proxEstado) {
		this.simbolo = simbolo;
		this.proximoEstado = proxEstado;
	}

	public char getSimbolo() {
		return simbolo;
	}

	public void setSimbolo(char simbolo) {
		this.simbolo = simbolo;
	}

	public Estado getProximoEstado() {
		return proximoEstado;
	}

	public void setProximoEstado(Estado proximoEstado) {
		this.proximoEstado = proximoEstado;
	}
}
