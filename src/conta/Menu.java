package conta;

import java.util.Scanner;

import conta.util.Cores; // importando a classe cores que foi criada

import conta.model.Conta; 

public class Menu {

	public static void main(String[] args) {
		
		// Instanciamento / Convertendo uma Classe em Objeto utilizável
		// o "new" serve para criar um objeto
		// Teste da Classe Conta
		Conta c1 = new Conta(1, 123, 1, "Adriana", 10000.0f);
		c1.visualizar();
		c1.sacar(12000.0f);
		c1.visualizar();
		c1.depositar(5000.0f);
		c1.visualizar();
		
		
		Scanner leia = new Scanner(System.in);
		
		int opcao;
		
		while(true) {
			
			System.out.println(Cores.TEXT_YELLOW + Cores.ANSI_BLACK_BACKGROUND
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
			opcao = leia.nextInt();
			if(opcao == 9) {
				System.out.println("\nBanco do Brasil com Z - O seu Futuro começa aqui! ");
				sobre(); // método
				leia.close();
				System.exit(0); // finaliza sistema
			}
			
			switch(opcao) {
			case 1:
				System.out.println(Cores.TEXT_WHITE_BOLD+ "Criar Conta n\n"); // O "Cores." define a cor de texto da msg
				
				break;
			case 2:
				System.out.println(Cores.TEXT_WHITE_BOLD+ "Listar todas as Contas\n\n");
				
				break;
			case 3:
				System.out.println(Cores.TEXT_WHITE_BOLD+ "Consultar dados da Conta\n\n");
				
				break;
			case 4:
				System.out.println(Cores.TEXT_WHITE_BOLD+ "Atualizar dados da Conta\n\n");
				
				break;
			case 5:
				System.out.println(Cores.TEXT_WHITE_BOLD+ "Apagar a Conta\n\n");
				
				break;
			case 6:
				System.out.println(Cores.TEXT_WHITE_BOLD+ "Saque\n\n");
				
				break;
			case 7:
				System.out.println(Cores.TEXT_WHITE_BOLD+ "Depósito\n\n");
				
				break;
			case 8:
				System.out.println(Cores.TEXT_WHITE_BOLD+ "Transferência entre Contas\n\n");
				
				break;
			default:
				System.out.println(Cores.TEXT_RED_BOLD+ "\nOpção Inválida!\n" + Cores.TEXT_RESET);
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
}
