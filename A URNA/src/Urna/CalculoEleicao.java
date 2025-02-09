package Urna;

import Elementos.Candidato;
import Elementos.Partido;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CalculoEleicao {
    private List<Partido> partidos;

    public CalculoEleicao(List<Partido> partidos) {
        this.partidos = partidos;
    }

    public Map<String, Candidato> calcularResultados() {
        Map<String, Candidato> vencedores = new HashMap<>();
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

        vencedores.put("PRESIDENTE", vencedorPresidente);
        vencedores.put("GOVERNADOR", vencedorGovernador);
        vencedores.put("SENADOR", vencedorSenador);
        vencedores.put("DEPUTADO_FEDERAL", vencedorDeputadoFederal);
        vencedores.put("DEPUTADO_ESTADUAL", vencedorDeputadoEstadual);
        return vencedores;
    }

    private Candidato obterVencedorAtual(Candidato vencedorAtual, Candidato candidato) {
        if (vencedorAtual == null || candidato.getVotos() > vencedorAtual.getVotos()) {
            return candidato;
        }
        return vencedorAtual;
    }
}
