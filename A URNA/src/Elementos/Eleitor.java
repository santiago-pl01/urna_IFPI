package Elementos;

public class Eleitor {
	private String nome;
	private int id;
	
	public Eleitor(String nome, int id) {
		this.nome = nome;
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
}
