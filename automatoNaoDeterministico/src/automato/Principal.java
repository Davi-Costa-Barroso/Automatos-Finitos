package automato;
// Davi Barroso
public class Principal {
	public static void main(String[] args) {
		Automato automato = new Automato();
		automato.criarAutomato("11+");
		System.out.println(automato.processarPalavra("11"));
	}
}