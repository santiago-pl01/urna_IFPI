package Urna;

import Elementos.Candidato;
import Elementos.Partido;

import java.time.LocalTime;
//import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;

public class Eleicao {
    private List<Partido> partidos;
    private int votoNulo;
    private int votoEmBranco;
    private CalculoEleicao calculoEleicao;
    private final LocalTime horarioEncerramento = LocalTime.of(12, 24);

    public Eleicao(List<Partido> partidos) {
        this.partidos = partidos;
        this.calculoEleicao = new CalculoEleicao(partidos);
    }

    public void adicionarVoto(Candidato escolhido) {
        checarHorarioEncerramento();
        for (Partido partido : partidos) {
            for (Candidato candidato : partido.getCandidatos()) {
                if (candidato.equals(escolhido)) {
                    candidato.setVoto();
                }
            }
        }
    }
    private void checarHorarioEncerramento() {
        LocalTime agora = LocalTime.now();

        if (agora.isAfter(horarioEncerramento) || agora.equals(horarioEncerramento)) {
            System.out.println("\nHorário limite atingido! Eleição encerrada ");
        }
    }
    public Candidato getCandidato(int numero) {
        for (Partido partido : partidos) {
            for (Candidato candidato : partido.getCandidatos()) {
                if (candidato.getNumeroCandidato() == numero) {
                    return candidato;
                }
            }
        }
        return null;
    }


    public Map<String, Candidato> calcularMajoritaria() {
        return calculoEleicao.calcularResultados();
    }

    public void exibirResultados() {
        Map<String, Candidato> vencedores = calcularMajoritaria();

        System.out.println("\nResultados da Eleição Majoritária:");
        for (Map.Entry<String, Candidato> entrada : vencedores.entrySet()) {
            String cargo = entrada.getKey();
            Candidato vencedor = entrada.getValue();
            if (vencedor != null) {
                System.out.printf("- Cargo: %s%n  - Vencedor: %s (%s) com %d votos.%n",
                        cargo, vencedor.getNome(), vencedor.getPartido().getNome(), vencedor.getVotos());
            } else {
                System.out.printf("- Cargo: %s%n  - Sem votos registrados.%n", cargo);
            }
        }

        System.out.println("Votos Nulos: " + votoNulo);
        System.out.println("Votos em Branco: " + votoEmBranco);
    }

    public void addVotoNulo() {
        votoNulo += 1;
    }

    public int getVotoNulo() {
        return votoNulo;
    }

    public void addVotoEmBranco() {
        this.votoEmBranco += 1;
    }

    public int getVotoEmBranco() {
        return votoEmBranco;
    }
}
