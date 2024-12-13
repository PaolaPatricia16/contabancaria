package conta.model;

public class ContaCorrente extends Conta { // extends = herança

	// Atributos / Variáveis

	private float limite;
	
	
	// O Método Construtor deve ter o mesmo nome do Arquivo Classe
	/* No momento da instânciação (criação do objeto)
	 * ele permite que criemos um obj com valores pré determinados */
	 
	public ContaCorrente(int numero, int agencia, int tipo, String titular, float saldo, float limite) {
		
		// invoca o metodo construtor da clase Conta com os seus parametros.
		super(numero, agencia, tipo, titular, saldo);
		
		// O "this." faz referencia ao atributo da classe, as cores tbm fazem referencia
		/* 	o numero a esquerda refere-se atributo (da classe) e o da direita parametro (do método)
		 */

		// o unico atributo que pertence a ClasseCorrente
		this.limite = limite;
		
	}
	
	public ContaCorrente(int numero, int agencia, int tipo, String titular, float saldo) {
		super(numero, agencia, tipo, titular, saldo);
		this.limite = 5000.0f;
	}
	
	

	// Metodo de Acesso
	public float getLimite() { // visualiza valor atribuido pelo Set
		return limite;
	}


	public void setLimite(float limite) { //atribui valor
		this.limite = limite;
	}
	
	
	@Override
	// Polimorfismo - Este método esta sendo Sobreescrito, 
	//pois ele já existe na Classe Conta, porém com outra lógica.
	public boolean sacar(float valor) {
		if (this.getSaldo() + this.getLimite() < valor) {
			System.out.println("\nSaldo Insuficiente!");
			return false;
		}
		// setSaldo irá atualizar o valor após o saque (.getSaldo - valor)
		this.setSaldo(this.getSaldo() - valor);
		return true;
	}
	
	
	
	//Polimorfismo de Sobrescrita -> add mais lógica a um método existente
	public void visualizar () { // o mesmo nome
		super.visualizar(); // Executa o Método da CLasse Conta
		System.out.println("limite de Crédito:" +this.limite); // o "this" faz referencia ao Obj que vai exibir os dados no print
	}
	
	
}
