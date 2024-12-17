package conta;

import java.io.IOException;
import java.util.InputMismatchException; // try catch
import java.util.Scanner;

import conta.util.Cores; // importando a classe Cores que foi criada

import conta.controller.ContaController; // importa o controller

import conta.model.Conta; // importando a classe Conta para criar o obj

import conta.model.ContaCorrente; // importando a classe ContaCorrente para criar o obj

import conta.model.ContaPoupanca; // importando a Classe ContaCorrente para instanciar

public class Menu {

	public static void main(String[] args) {
		
		ContaController contas = new ContaController();
		
		Scanner leia = new Scanner(System.in);
		
		int opcao, numero, agencia, tipo, aniversario, numeroDestino;
		String titular;
		float saldo, limite, valor;
		
		// Instanciamento / Convertendo uma Classe em Objeto utilizável
		// o "new" serve para criar um objeto

	
		System.out.println("\nCriar Contas");

		ContaCorrente cc1 = new ContaCorrente(contas.gerarNumero(), 123, 1, "João da Silva", 1000f, 100.0f);
		contas.cadastrar(cc1);
		
		ContaCorrente cc2 = new ContaCorrente(contas.gerarNumero(), 124, 1, "Maria da Silva", 2000f, 100.0f);
		contas.cadastrar(cc2);
		
		ContaPoupanca cp1 = new ContaPoupanca(contas.gerarNumero(), 125, 2, "Mariana dos Santos", 4000f, 12);
		contas.cadastrar(cp1);
		
		ContaPoupanca cp2 = new ContaPoupanca(contas.gerarNumero(), 126, 2, "Juliana Ramos", 8000f, 15);
		contas.cadastrar(cp2);
		
		contas.listarTodas();
		
		
		while(true) {
			
			System.out.println(Cores.TEXT_BLACK_BOLD + Cores.ANSI_PURPLE_BACKGROUND
					          +"**********************************************");
			
			System.out.println("**********************************************");
			System.out.println("                                              ");
			System.out.println("            BANCO DO BRAZIL COM Z             ");
			System.out.println("                                              ");
			System.out.println("**********************************************");
			System.out.println("                                              ");
			System.out.println("      1 - Criar conta                         ");
			System.out.println("      2 - Listar todas as Contas              ");
			System.out.println("      3 - Buscar Conta por Número             ");
			System.out.println("      4 - Atualizar Dados da Conta            ");
			System.out.println("      5 - Apagar Conta                        ");
			System.out.println("      6 - Sacar                               ");
			System.out.println("      7 - Depositar                           ");
			System.out.println("      8 - Transferir valores entre Contas     ");
			System.out.println("      9 - Sair                                ");
			System.out.println("                                              ");
			System.out.println("**********************************************");		
			System.out.println(" Entre com a opção desejada:                  ");
			System.out.println("                                              " +Cores.TEXT_RESET);
																	// Reseta as cores
			try {
				opcao = leia.nextInt();
			}catch(InputMismatchException e) {
				System.out.println("\nDigite valores inteiros!");
				leia.nextLine();
				opcao = 0; // variável reiniciada
			}
			
			
			if(opcao == 9) {
				System.out.println("\nBanco do Brasil com Z - O seu Futuro começa aqui! ");
				sobre(); // método
				leia.close();
				System.exit(0); // finaliza sistema
			}
			
			switch(opcao) {
			case 1:
				System.out.println(Cores.TEXT_WHITE_BOLD+ "Criar Conta \n\n"); // O "Cores." define a cor de texto da msg
				
				System.out.println("Digite o Número da Agência: ");
				agencia = leia.nextInt();
				System.out.println("Digite o Nome do Titular: ");
				leia.skip("\\R?");
				titular = leia.nextLine();
				
				do {
					System.out.println("Digite o Tipo da Conta (1 - CC ou 2 - CP): ");
					tipo = leia.nextInt();
					
				}while(tipo < 1 && tipo > 2); // faz o loop até que seja cumprido as "regras" 
				
				System.out.println("Digite o Saldo da Conta (R$): ");
				saldo = leia.nextFloat();
				
				switch(tipo) {
				case 1 ->{
					System.out.println("Digite o Limite de Crédito (R$): ");
					limite = leia.nextFloat();
					contas.cadastrar(new ContaCorrente(contas.gerarNumero(), agencia, tipo, titular, saldo, limite));
				}
				case 2 ->{
					System.out.println("Digite o dia do Aniversário da Conta: ");
					aniversario = leia.nextInt();
					contas.cadastrar(new ContaPoupanca(contas.gerarNumero(), agencia, tipo, titular, saldo, aniversario));
				}
			}
				
				
				keyPress(); // aguarda o usuário pressionar o Enter antes de mostrar o Menu novamente.
				break;
			
			case 2:
				System.out.println(Cores.TEXT_WHITE_BOLD+ "Listar todas as Contas\n\n");
				contas.listarTodas(); // chama e executa o método da Controller
				
				keyPress();
				break;
			case 3:
				System.out.println(Cores.TEXT_WHITE_BOLD+ "Consultar dados da Conta\n\n");
				
				System.out.println("Digite o número da conta: ");
				numero = leia.nextInt();
				
				contas.procurarPorNumero(numero); // chama e executa o metodo da classe controller
				
				keyPress();
				break;
			case 4:
				System.out.println(Cores.TEXT_WHITE_BOLD+ "Atualizar dados da Conta\n\n");
				
				System.out.println("Digite o número da conta: ");
				numero = leia.nextInt();
				
				var buscaConta = contas.buscarNaCollection(numero); // envia o dado "num" para executar no metodo
				
				if (buscaConta != null){
					System.out.println("Digite o número da Agência: ");
					agencia = leia.nextInt();
					System.out.println("Digite o nome do Titular: ");
					leia.skip("\\R?");
					titular = leia.nextLine();
					
					System.out.println("Digite o saldo da Conta: R$");
					saldo = leia.nextFloat();
					
					tipo = buscaConta.getTipo(); // trás o tipo da conta de acordo com a Classe Conta
					
					switch(tipo) {
						case 1 -> {
							System.out.println("Digite o Limite de Crédito: R$");
							limite = leia.nextFloat();
							
							contas.atualizar(new ContaCorrente(numero, agencia, tipo, titular, saldo, limite));
						
						}
						case 2 -> {
							System.out.println("Digite o dia do Aniversário da Conta: ");
							aniversario = leia.nextInt();
							
							contas.atualizar(new ContaPoupanca(numero, agencia, tipo, titular, saldo, aniversario));
						}
						default -> {
							System.out.println("Tipo de conta inválida!");
						}
					}
				}else {
					System.out.println("A Conta não foi encontrada! ");
				}
				
				keyPress();
				break;
			case 5:
				System.out.println(Cores.TEXT_WHITE_BOLD+ "Apagar a Conta\n\n");
				
				System.out.println("Digite o número da conta: ");
				numero = leia.nextInt();
				
				contas.deletar(numero); //chama o metodo deletar da Classe Controller
				
				keyPress();
				break;
			case 6:
				System.out.println(Cores.TEXT_WHITE_BOLD+ "Saque\n\n");
				
				System.out.println("Digite o número da conta: ");
				numero = leia.nextInt();
				
				do { //laço de repetição para garantir que seja inserido um valor positivo acima de 0
					System.out.println("Digite o Valor do Saque: ");
					valor = leia.nextFloat();
				}while(valor <= 0);
				
				contas.sacar(numero, valor); //envia os 2 parametros para o Método Sacar que esta na Classe Controller
				
				keyPress();
				break;
			case 7:
				System.out.println(Cores.TEXT_WHITE_BOLD+ "Depósito\n\n");
				
				System.out.println("Digite o número da conta: ");
				numero = leia.nextInt();
				
				do {
					System.out.println("Digite o valor do Depósito: ");
					valor = leia.nextFloat();
				}while(valor <= 0);
				
				contas.depositar(numero, valor);
				
				keyPress();
				break;
			case 8:
				System.out.println(Cores.TEXT_WHITE_BOLD+ "Transferência entre Contas\n\n");
				
				System.out.println("Digite o número da Conta de Origem: ");
				numero = leia.nextInt();
				System.out.println("Digite o número da Conta de Destino: ");
				numeroDestino = leia.nextInt();
				
				do {
					System.out.println("Digite o valor a ser transferido: ");
					valor = leia.nextFloat();
				}while(valor <= 0);
				
				contas.transferir(numero, numeroDestino, valor);
				
				keyPress();
				break;
			default:
				System.out.println(Cores.TEXT_RED_BOLD+ "\nOpção Inválida!\n" + Cores.TEXT_RESET);
				keyPress();
				break;			// Define a cor VERMELHA para a msg e após exibir RESETA as cores
			}
		}	
	}

	public static void sobre() {
		System.out.println("\n**********************************************");
		System.out.println("Projeto Desenvolvido por: ");
		System.out.println("Paola Patricia - patricia-9856@hotmail.com");
		System.out.println("https://github.com/PaolaPatricia16");
		System.out.println("************************************************");
	}
	
	public static void keyPress() {
		try {
			System.out.println(Cores.TEXT_RESET + "\n\nPressione Enter para Continuar...");
			System.in.read(); //leitura de um dispositivo de entrada
			
		}catch (IOException e) {
			System.out.println("Você pressionou uma tecla diferente de enter!");
		}
	}
}
