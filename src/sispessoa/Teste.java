package sispessoa;

/**
 * @author Edilson do Nascmento
 *
 */
public class Teste {

	private static String opcao = "";

	public static void main(String[] args) {

		Leitura leitura = new Leitura();
		BDPessoas bdPessoas = new BDPessoas();		
		operarMenu(leitura, bdPessoas);
	}

	
		
	public static void mostraMenu() {

		System.out.println("Sistema de Gestão de Pessoas - Menu Inicial\n");
		System.out.println("1) Cadastrar uma Pessoa");
		System.out.println("2) Imprimir todas as Pessoas");
		System.out.println("3) Consultar Pessoa pelo código");
		System.out.println("4) Alterar Pessoa pelo código");
		System.out.println("5) Excluir Pessoa");
		System.out.println("6) Sair do Sistema");

	}

	public static void operarMenu(Leitura leitura, BDPessoas bdPessoas) {		 
		
		
		while (true) {

			mostraMenu();
			opcao = (leitura.entDados(""));

			switch (opcao) {
				case "1":
						bdPessoas.inserir();
						break;
	
				case "2":
						bdPessoas.mostrarAll();
						break;
	
				case "3":
						bdPessoas.mostraPessoa(buscarPessoaCodigo(leitura, bdPessoas));
						break;
					
				case "4":
						bdPessoas.alterar(buscarPessoaAlterar(leitura, bdPessoas));
						break;
	
				case "5":
						bdPessoas.excluir(buscarPessoaCodigo(leitura, bdPessoas));
						break;
	
				case "6":
						System.out.println("Sistema finalizado...");
						System.exit(0);
						break;				
				
				default:
						System.out.println("Valor fora das opções do Menu");
						break;
					
			}//switch
			
		}//while
	
	}
	
	public static Pessoa buscarPessoaCodigo(Leitura leitura, BDPessoas bdPessoas) {
		
		return  bdPessoas.buscar(Integer.valueOf(leitura.entDados("Entre com o código")));
	}
	
	public static Pessoa buscarPessoaAlterar(Leitura leitura, BDPessoas bdPessoas) {
		
		Pessoa pessoaAlterada =  buscarPessoaCodigo(leitura, bdPessoas);
		pessoaAlterada.setCod(Integer.valueOf(leitura.entDados("Entre com o NOVO CÓDIGO: ")));
		pessoaAlterada.setNome(leitura.entDados("Entre com o NOVO NOME: "));
		
		return pessoaAlterada;
	}

}// class
