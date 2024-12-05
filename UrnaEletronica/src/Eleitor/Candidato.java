package Eleitor;

public class Candidato {
	  private int numero;
	    private String nome;
	    private String partido;
	    private int votos = 0;

	    public Candidato(int numero, String nome, String partido) {
	        this.numero = numero;
	        this.nome = nome;
	        this.partido = partido;
	    }

	    public int getNumero() {
	        return numero;
	    }

	    public String getNome() {
	        return nome;
	    }

	    public int getVotos() {
	        return votos;
	    }

	    public void incrementarVotos() {
	        votos++;
	    }

	    @Override
	    public String toString() {
	        return nome + " (" + partido + ") - Votos: " + votos;
	    }
}
