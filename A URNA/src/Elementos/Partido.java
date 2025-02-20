package Elementos;
import java.util.List;
import java.util.ArrayList;

public class Partido {
    private List<Candidato> candidatos = new ArrayList<>();
    private String nome;
    private int votos = 0;

    public Partido(String nomePartido){
        this.nome = nomePartido;
    }
    public String getNome() {
        return nome;
    }
    public int getVotos() {
        return votos;
    }

    public void setVotos() {
        this.votos += 1;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    public void setCandidato(Candidato candidato){
        candidatos.add(candidato);
    }
    public void removeCandidato(Candidato candidato){
        for(Candidato candidato1:candidatos){
            if (candidato1.equals(candidato)){
                candidatos.remove(candidato1);
            }
        }
    }
    public List<Candidato> getCandidatos() {
        return candidatos;
    }

    public int contarCandidatos() {
        return candidatos.size();
    }


    // Metodo adiconado para ver se o partido ja possui um candidato cadastrado(usando em Urna)
    public boolean candidatoExistente(int numeroCandidato) { 
        for (Candidato candidato : candidatos) { // Percorre a lista de candidatos.
            if (candidato.getNumeroCandidato() == numeroCandidato) { // Verifica se o número do candidato ja existe.
                return true; // Retorna verdadeiro se o número do candidato ja existir.
            }
        }
        return false; // Retorna falso se o número do candidato não existir.
    }
}
