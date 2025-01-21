package Elementos;

public class Candidato {
   private String nome;
   private int numeroCandidato;
   private Partido partido;
   private int votos = 0;
   private Cargo cargo;
   public String caminhoFoto;

    public Candidato(String nome, int numeroCandidato, Partido partido, Cargo cargo){
       this.nome = nome;
       this.numeroCandidato = numeroCandidato;
       this.partido = partido;
       this.cargo = cargo;
    
   }
    public Cargo getCargo() {
        return cargo;
    }

    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
    }
    public String getnome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Partido getPartido() {
        return partido;
    }

    public void setPartido(Partido partido) {
        this.partido = partido;
    }

    public int numeroCandidato() {
        return numeroCandidato;
    }

    public void setNumeroCandidato(int numeroCandidato) {
        this.numeroCandidato = numeroCandidato;
   }
    public int getvotos(){
       return votos;
    }
    public void addvotos(){
       votos +=1;
    }
	public String getCaminhoFoto() {
		return caminhoFoto;
	}
	public void setCaminhoFoto(String caminhoFoto) {
		this.caminhoFoto = caminhoFoto;
	}
    
    
}
