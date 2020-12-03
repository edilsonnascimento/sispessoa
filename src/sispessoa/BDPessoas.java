package sispessoa;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @author Edilson do Nascimento
 *
 */
public class BDPessoas {
	
	private List<Pessoa> pessoas;
	private Leitura in;
	
	public BDPessoas() {
		pessoas = new ArrayList<Pessoa>();
		in = new Leitura();
	}

	public void inserir() {
		int codigo = Integer.valueOf(in.entDados("Entre com o código da pessoa: "));
		String nome = in.entDados("Entre com o nome da pessoa: ");		
		pessoas.add(new Pessoa(codigo, nome));		
	}
	
	public Pessoa buscar(int codigo) {
		Optional<Pessoa> pessoaEncontrada = pessoas.stream()
				.filter(pessoa -> pessoa.getCod() == codigo)				
				.findFirst();
		
		return verificaOptional(pessoaEncontrada);
    }
	
	public Pessoa buscar(String nome) {		
		Optional<Pessoa> pessoaEncontrada = pessoas.stream()
				.filter(pessoa -> pessoa.getNome().equals(nome))
				.findFirst();
		
		return verificaOptional(pessoaEncontrada);
		
	}
	
	public Pessoa verificaOptional(Optional<Pessoa> pessoaOptinal) {
		
		if(pessoaOptinal.isPresent()) {
			return pessoaOptinal.get();
		}else {
			System.out.println("Pessoa não encontrada..");
			return new Pessoa();
		}
	}
	
	public void mostrarAll() {
		for (Pessoa pessoa : pessoas) {
			System.out.println("Posicao lista: " + pessoas.indexOf(pessoa));
			System.out.println("Código: " + pessoa.getCod() + " - Nome: " + pessoa.getNome() + "\n");
		}
	}
	
	public void mostraPessoa(Pessoa pessoa) {
		System.out.println("Código da Pessoa: " + pessoa.getCod());
		System.out.println("Nome da Pessoa: " + pessoa.getNome());
	}

	public int indice(Pessoa pessoa) {	
		return pessoas.indexOf(pessoa);
	}

	public void alterar(Pessoa pessoaAlterada) {		 
		this.pessoas.set(indice(pessoaAlterada), pessoaAlterada);
		mostraPessoa(pessoaAlterada);
	}

	public void excluir(Pessoa pessoaExcluida) {
		this.pessoas.remove(indice(pessoaExcluida));
		System.out.println("Pessoa excluída com sucesso!");
	}

	 
}
