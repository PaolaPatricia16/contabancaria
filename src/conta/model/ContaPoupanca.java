package conta.model;

public class ContaPoupanca extends Conta{ // Classe filha da Classe Conta

	// Atributo específico da Classe ContaPoupanca
	private int aniversario;
	
	public ContaPoupanca(int numero, int agencia, int tipo, String titular, float saldo, int aniversario) {
		super(numero, agencia, tipo, titular, saldo);
		
		this.aniversario = aniversario; //informa ao java qual é o atributo e qual é o parametro
		
	}

	public int getAniversario() { // visualiza o valor do Set
		return aniversario;
	}

	public void setAniversario(int aniversario) { // atribuí valor
		this.aniversario = aniversario;
	} 

@Override //Polimorfismo - Sobreescrita
	public void visualizar() {
		super.visualizar(); // chama o método da Classe Mãe Conta
		System.out.println("Aniversário da conta: " +this.aniversario);
}
	
	
}
