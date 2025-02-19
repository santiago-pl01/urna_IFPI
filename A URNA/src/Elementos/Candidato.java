package Elementos;

public class Candidato {
   private String nome;
   private int numeroCandidato;
   private Partido partido;
   private int votos = 0;
   private Cargo cargo;
   
    public Candidato(String nome, int numeroCandidato, Partido partido, Cargo cargo){
       this.nome = nome;
       this.numeroCandidato = numeroCandidato;
       this.partido = partido;
       this.cargo = cargo;
   }
    public Cargo getCargo() {
        return cargo;
    }

    public String getNome() {
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

    public int getNumeroCandidato() {
        return numeroCandidato;
    }

    public void setNumeroCandidato(int NumeroCandidato) {
        this.numeroCandidato = NumeroCandidato;
   }
    public int getVotos(){
       return votos;
    }
    public void setVoto(){
       votos +=1 ;
    }
}

