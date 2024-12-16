package conta.controller;

import java.util.ArrayList;

import conta.model.Conta;

import conta.repository.ContaRepository; // pacote interface



public class ContaController implements ContaRepository{
	// "puxa" todos os métodos da interface obrigatoriamente
	
	private ArrayList<Conta> listaContas = new ArrayList<Conta>(); 
	//arraylist do tipo conta, irá armazenar os dados de Conta e suas filhas (Corrente e Poupança)
	
	int numero = 0; //contabiliza o número de contas
	
	@Override
	public void procurarPorNumero(int numero) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void listarTodas() {
		for(var conta: listaContas) { //"var" cria variáveis locais sem ser necessário definir o tipo delas
			conta.visualizar();	
		}	
	}

	@Override
	public void cadastrar(Conta conta) {

		listaContas.add(conta);
		System.out.println("\nA Conta número: " +conta.getNumero()+ " foi criada com sucesso!");
	}

	@Override
	public void atualizar(Conta conta) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deletar(int numero) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void sacar(int numero, float valor) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void depositar(int numero, float valor) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void transferir(int numeroOrigem, int numeroDestino, float valor) {
		// TODO Auto-generated method stub
		
	}
	public int gerarNumero() {
		int numero = 0;
		return ++numero ;
	}

}
