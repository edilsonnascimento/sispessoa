package sispessoa;

/**
 * @author Edilson do Nascimento
 *
 */
public class Pessoa {

	private int cod;
	private String nome;

	public Pessoa(int cod, String nome) {
		this.cod = cod;
		this.nome = nome;
	}

	public Pessoa() {
	}

	public int getCod() {
		return cod;
	}

	public void setCod(int cod) {
		this.cod = cod;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
