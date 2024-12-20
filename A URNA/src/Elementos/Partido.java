package Elementos;
import java.util.List;
import java.util.ArrayList;

public class Partido {
    private List<Candidato> candidatos;
    private String nome;
    private int votos = 0;

    public Partido(String nome){
        this.candidatos = new ArrayList<>();
        this.nome = nome;
    }
    public String getnome() {
        return nome;
    }
    public int votos() {
        return votos;
    }

    public void addVotos() {
        this.votos += 1;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    public void addCandidato(Candidato candidato){
        candidatos.add(candidato);
    }
    public void removeCandidato(Candidato candidato){
        for(Candidato candidato1:candidatos){
            if (candidato1.equals(candidato)){
                candidatos.remove(candidato1);
            }
        }
    }
    public List<Candidato> getCandidatos(){
        return candidatos;
    }
}
