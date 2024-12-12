package Urna;
import Elementos.Candidato;
import Elementos.Partido;
import java.util.List;

public class Eleicao {
    private List<Partido>partidos;
    private int votoValidos = 0;
    private Candidato vencedor;

    public Eleicao(List<Partido>partidos){
        this.partidos = partidos;
    }
    public void calcularVotos(){
        votoValidos = 0;
        for (Partido partido : partidos){
            List<Candidato>candidatos = partido.getCandidatos();
            for (Candidato candidato : candidatos){
                votoValidos += candidato.getvotos();
            }
        }
    }
    public Candidato getVencedor() {
        int quantVotos = 0;
        for (Partido partido : partidos) {
            List<Candidato> candidatos = partido.getCandidatos();
            for (Candidato candidato : candidatos) {
                if(candidato.getvotos() > quantVotos){
                    quantVotos = candidato.getvotos();
                    vencedor = candidato;
                }
            }
        }
        return vencedor;

    }
    public int getvotoValidos() {
        return votoValidos;
    }

    public void setVotoValidos(int votoValidos) {
        this.votoValidos = votoValidos;
    }
}
