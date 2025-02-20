package Urna;

import Elementos.Candidato;
import Elementos.Partido;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;
import Elementos.Mesario;

public class Eleicao {
    private List<Partido> partidos;
    private int votoNulo;
    private int votoEmBranco;
    private CalculoEleicao calculoEleicao;
    LocalDateTime dataHorario = LocalDateTime.now();
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
    String agora = dataHorario.format(formatter);
    private final LocalTime horarioEncerramento = LocalTime.of(14, 20);

    //////////////////////////////////
    private int votosValidos = 0;

    Mesario mesario = new Mesario();
    int eleitores = mesario.contarEleitores();
    //////////////////////////////////

    
    

    public Eleicao(List<Partido> partidos) {
        this.partidos = partidos;
        this.calculoEleicao = new CalculoEleicao(partidos);
    }

    public void adicionarVoto(Candidato escolhido) {
        if (checarHorarioEncerramento() || checarQuantidadeVotos(mesario)) {
            return;
        }

        for (Partido partido : partidos) {
            for (Candidato candidato : partido.getCandidatos()) {
                if (candidato.equals(escolhido)) {
                    candidato.setVoto();
                }
            }
        }
    }

    private boolean checarHorarioEncerramento() {
        LocalTime agora = LocalTime.now();
        if (agora.isAfter(horarioEncerramento) || agora.equals(horarioEncerramento)) {
            System.out.println("\nHorário limite atingido! Encerrando a eleição.");
            exibirResultados();
            System.exit(0);
            return true; // Nunca será executado, mas deixa claro a intenção
        }
        return false;
    }

    ////////////////////////////////////////////////
    public boolean checarQuantidadeVotos(Mesario mesario) {
        if (getVotosValidos() == mesario.contarEleitores()) {
            System.out.println("\nEncerrando a eleição.");
            exibirResultados();
            System.exit(0);
            return true;
        }
        return false;
    }
    ///////////////////////////////////////////////
    
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
        System.out.println("Data e Hora: " + agora);
        System.out.println("Votos Nulos: " + votoNulo);
        System.out.println("Votos em Branco: " + votoEmBranco);
    }

    public void setVotoNulo() {
        checarHorarioEncerramento();
        votoNulo += 1;
        votosValidos += 1;
    }

    public int getVotoNulo() {
        return votoNulo;
    }

    public void setVotoEmBranco() {
        checarHorarioEncerramento();
        votoEmBranco += 1;
        votosValidos += 1;
    }

    public int getVotoEmBranco() {
        return votoEmBranco;
    }
    public int getVotosValidos() {
        return votosValidos;
    }
    public int setVotosValidos() {
       return votosValidos += 1;
    }
}
