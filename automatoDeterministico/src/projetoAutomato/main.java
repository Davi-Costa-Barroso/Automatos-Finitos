package projetoAutomato;
// Davi Barroso
public class main {
	public static void main(String[] args) {
		
		Estado q1 = new Estado();
		Estado q2 = new Estado(true);
		q1.transicoes.add(new Transicao('1', q1));
		q1.transicoes.add(new Transicao('0', q2));
		q2.transicoes.add(new Transicao('0', q2));
		q2.transicoes.add(new Transicao('1', q1));		
		
		Automato automato = new Automato(q1);
		System.out.println(automato.procurarPalavra("0110"));
	}
}