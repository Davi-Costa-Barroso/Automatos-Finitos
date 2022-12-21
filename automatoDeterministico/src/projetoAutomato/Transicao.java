package projetoAutomato;

public class Transicao {
	char simbolo;
	Estado proximoEstado;
	
	public Transicao(char simbolo, Estado proxEstado){
		this.simbolo = simbolo;
		this.proximoEstado = proxEstado;
	}
	
	public char getSimbolo() {
		return simbolo;
	}
}