package cadastroCandidato;
import cadastro.Cargo;

public class Candidato<cargo> {
	private String nome;
	private int id;
	private int numeroVotaçao;
	private Cargo cargo;
	
	public Candidato(String nome, int id, int numeroVotaçao, Cargo cargo) {
		this.setNome(nome);
		this.setId(id);
		this.setNumeroVotação(numeroVotaçao);
		this.setcargo(cargo);
	}
	
	public Cargo getcargo() {
		return cargo;
	}
	
	public void setcargo(Cargo cargo) {
		this.cargo = cargo;
	}

	public int getNumeroVotação() {
		return numeroVotaçao;
	}

	public void setNumeroVotação(int numeroVotaçao) {
		this.numeroVotaçao = numeroVotaçao;
	}

	public  int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public  String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}


}
