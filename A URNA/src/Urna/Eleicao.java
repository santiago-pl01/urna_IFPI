package Urna;

import Elementos.Candidato;
import Elementos.Partido;

import java.util.List;

public class Eleicao {
    private List<Partido> partidos;
    private int votoNulo;
    private int votoEmBranco;
    public Eleicao(List<Partido> partidos) {
        this.partidos = partidos;
    }
    public Candidato getCandidato(int numero){
        for (Partido partido : partidos){
            for (Candidato candidato : partido.getCandidatos()){
                if (candidato.getNumeroCandidato() == numero){
                    return candidato;
                }
            }
        }
        return null;
    }

    
    private void exibirVencedor(String cargo, Candidato vencedor) {
        if (vencedor != null) {
            System.out.printf("- Cargo: %s%n  - Vencedor: %s (%s) com %d votos.%n",
                    cargo, vencedor.getNome(), vencedor.getPartido().getNome(), vencedor.getVotos());
        } else {
            System.out.printf("- Cargo: %s%n  - Sem votos registrados.%n", cargo);
        }
    }
    public void exibirResultados() {
        Candidato vencedorPresidente = null;
        Candidato vencedorGovernador = null;
        Candidato vencedorSenador = null;
        Candidato vencedorDeputadoFederal = null;
        Candidato vencedorDeputadoEstadual = null;

        for (Partido partido : partidos) {
            for (Candidato candidato : partido.getCandidatos()) {
                switch (candidato.getCargo()) {
                    case PRESIDENTE:
                        vencedorPresidente = obterVencedorAtual(vencedorPresidente, candidato);
                        break;
                    case GOVERNADOR:
                        vencedorGovernador = obterVencedorAtual(vencedorGovernador, candidato);
                        break;
                    case SENADOR:
                        vencedorSenador = obterVencedorAtual(vencedorSenador, candidato);
                        break;
                    case DEPUTADO_FEDERAL:
                        vencedorDeputadoFederal = obterVencedorAtual(vencedorDeputadoFederal, candidato);
                        break;
                    case DEPUTADO_ESTADUAL:
                        vencedorDeputadoEstadual = obterVencedorAtual(vencedorDeputadoEstadual, candidato);
                        break;
                }
            }
        }

        System.out.println("\nResultados da Eleição Majoritária:");
        exibirVencedor("PRESIDENTE", vencedorPresidente);
        exibirVencedor("GOVERNADOR", vencedorGovernador);
        exibirVencedor("SENADOR", vencedorSenador);
        exibirVencedor("DEPUTADO FEDERAL", vencedorDeputadoFederal);
        exibirVencedor("DEPUTADO ESTADUAL", vencedorDeputadoEstadual);

    }
    public void adicionarVoto(Candidato escolhido){
        for (Partido partido : partidos){
            for (Candidato candidato : partido.getCandidatos()){
                if (candidato.equals(escolhido)) {
                    candidato.addVoto();
                }
            }
        }
    }


    private List<Candidato> calcularMajoritaria(){
        return null;
    }
    private List<Candidato> calcularProporcional(){
        return null;
    }
    private Candidato obterVencedorAtual(Candidato vencedorAtual, Candidato candidato) {
        if (vencedorAtual == null || candidato.getVotos() > vencedorAtual.getVotos()) {
            return candidato;
        }
        return vencedorAtual;
    }


    
    public void addVotoNulo(){
        votoNulo += 1;
    }
    public int getVotoNulo(){
        return  votoNulo;
    }
    public void addVotoEmBranco() {
        this.votoEmBranco += 1;
    }
    public int getVotoEmBranco() {
        return votoEmBranco;
    }
}
