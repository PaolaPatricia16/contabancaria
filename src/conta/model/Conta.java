package conta.model;

public class Conta {

	// Atributos / Variáveis
	private int numero;
	private int agencia;
	private int tipo;
	private String titular;
	private float saldo;
	
	// Método Especial / Método Construtor
	/* No momento da instânciação (criação do objeto)
	 * ele permite que criemos um obj com valores pré determinados */
	 
	public Conta(int numero, int agencia, int tipo, String titular, float saldo) {
		
		
		// O "this." faz referencia ao atributo da classe, as cores tbm fazem referencia
		/* 	o numero a esquerda refere-se atributo (da classe) e o da direita parametro (do método)
		 */
	
		this.numero = numero;	
		this.agencia = agencia;
		this.tipo = tipo;
		this.titular = titular;
		this.saldo = saldo;
		
	}

	// O get e o set, permitem que outras classes acessem os atributos (mesmo
	// que Privados)

	public int getNumero() {
		//permite ver o valor atribuido pelo SET
		return numero;
	}

	public void setNumero(int numero) {
		// atribui o valor ao parametro
		this.numero = numero;
	}

	public int getAgencia() {
		return agencia;
	}

	public void setAgencia(int agencia) {
		this.agencia = agencia;
	}

	public int getTipo() {
		return tipo;
	}

	public void setTipo(int tipo) {
		this.tipo = tipo;
	}

	public String getTitular() {
		return titular;
	}

	public void setTitular(String titular) {
		this.titular = titular;
	}

	public float getSaldo() {
		return saldo;
	}

	public void setSaldo(float saldo) {
		this.saldo = saldo;
	}
	
	
	// "Valor" recebe o montante a ser sacado
	
	public boolean sacar(float valor) {
		if (this.getSaldo() < valor) {
			System.out.println("\nSaldo Insuficiente!");
			return false;
		}
		// setSaldo irá atualizar o valor após o saque (.getSaldo - valor)
		this.setSaldo(this.getSaldo() - valor);
		return true;
	}
	
	// do tipo VOID porque não precisa retornar nenhum dado, apenas exibir
	public void depositar(float valor) {
		this.setSaldo(this.getSaldo() + valor);
	}
	
	public void visualizar() {
		String tipo = "";
		switch(this.tipo) {
		case 1:
			tipo = "Conta Corrente";
			break;
		case 2:
			tipo = "Conta Poupança";
			break;
		}
		
		System.out.println("\n\n******************************************");
        System.out.println("Dados da Conta: ");
        System.out.println("*******************************************");
        System.out.println("Número da Conta: " +this.numero);
        System.out.println("Agência: " +this.agencia);
        System.out.println("Tipo da Conta: " +this.tipo);
        System.out.println("Titular: " +this.titular);
        System.out.println("Saldo: R$" +this.saldo);
	}
	
}
