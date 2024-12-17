package conta.controller;

import java.util.ArrayList;

import conta.model.Conta;

import conta.repository.ContaRepository; // pacote interface

public class ContaController implements ContaRepository {
	// "puxa" todos os métodos da interface obrigatoriamente

	private ArrayList<Conta> listaContas = new ArrayList<Conta>();
	// arraylist do tipo conta, irá armazenar os dados de Conta e suas filhas
	// (Corrente e Poupança)

	int numero = 0; // contabiliza o número de contas

	@Override
	public void procurarPorNumero(int numero) { // "numero" recebe a nº da conta a ser localizada
		var conta = buscarNaCollection(numero);
		
		if(conta != null)
			conta.visualizar();
		else
			System.out.println("\nA Conta número: " +numero+ " não foi encontrada!");
	}

	@Override
	public void listarTodas() {
		for (var conta : listaContas) { // "var" cria variáveis locais sem ser necessário definir o tipo delas
			conta.visualizar();
		}
	}

	@Override
	public void cadastrar(Conta conta) {

		listaContas.add(conta);
		System.out.println("\nA Conta número: " + conta.getNumero() + " foi criada com sucesso!");
	}

	@Override
	public void atualizar(Conta conta) {
		// "buscaCOnta" armazena o retorno da execução do método "buscarNaCollection"
		var buscaConta = buscarNaCollection(conta.getNumero()); 
		
		if(buscaConta != null) {
			listaContas.set(listaContas.indexOf(buscaConta), conta); // o index localiza a conta para att os dados
			System.out.println("\nA Conta número " +conta.getNumero()+ " foi atualizada com sucesso!");
		}else {
			System.out.println("\nA Conta número " +conta.getNumero()+ " não foi encontrada!");
		}
	}

	@Override
	public void deletar(int numero) { //recebe como parametro o numero da Conta inserida pelo usuario
		// chama e executa o metodo para buscar a conta
		var conta = buscarNaCollection(numero);
		
		if(conta != null) {
			if(listaContas.remove(conta) == true) //".remove" é uma ação nativa do arraylist
				System.out.println("\nA Conta número " +numero+ " foi deletada com sucesso!");		
		}else
			System.out.println("\nA Conta número " +numero+ " não foi encontrada!");
		
	}

	@Override
	public void sacar(int numero, float valor) {
		var conta = buscarNaCollection(numero);
		
		if (conta != null ) {
			if(conta.sacar(valor) == true)
				System.out.println("\nO Saque na Conta numero: " +numero+ " foi efetuado com sucesso!");
		}else
			System.out.println("\nA Conta número: " +numero+ " não foi encontrada!");
	}

	@Override
	public void depositar(int numero, float valor) {
		var conta = buscarNaCollection(numero);
		
		if(conta != null) {
			conta.depositar(valor);
			System.out.println("\nO depósitona Conta número: " +numero+ " foi realizado com sucesso! ");
			
		}else {
			System.out.println("\nA conta número: " +numero+ " não foi encontrada ou a Conta de destino não é uma Conta Corrente!");
		}
	}

	@Override
	public void transferir(int numeroOrigem, int numeroDestino, float valor) {
		var contaOrigem = buscarNaCollection(numeroOrigem);
		var contaDestino = buscarNaCollection(numeroDestino);
		
		if(contaOrigem != null && contaDestino != null) {
			if(contaOrigem.sacar(valor) == true) {
				contaDestino.depositar(valor);
				System.out.println("\nA transferência foi efetuada com sucesso!");
			}
		}else {
			System.out.println("\nA conta de Origem e/ou Destino não foram encontradas!");
		}
		
		
	}

	public int gerarNumero() {
		return ++ numero;
	}

	public Conta buscarNaCollection(int numero) {
		for (var conta : listaContas) { // busca a conta dentro da array listaContas
			if (conta.getNumero() == numero) {
				return conta;
			}
		}
		return null;
	}

}
