package Urna;

import java.util.ArrayList;
import java.util.List;

import Elementos.Candidato;
import Elementos.Cargo;
import Elementos.Partido;

public class Urna {
    public static void main(String[] args) {
    	
    	Tela tela = new Tela();
    	
        Partido partidoA = new Partido("psdv");
        Partido partidoB = new Partido("pd");
        Candidato candidato1 = new Candidato("Joao",97,partidoA, Cargo.PRESIDENTE);
        Candidato candidato2 = new Candidato("José",56,partidoB,Cargo.PRESIDENTE);
        Candidato candidato3 = new Candidato("Maria",90,partidoA,Cargo.DEPUTADO_FEDERAL);
        Candidato candidato4 = new Candidato("Lucas",88,partidoB,Cargo.DEPUTADO_FEDERAL);
        partidoA.addCandidato(candidato1);
        partidoA.addCandidato(candidato3);
        partidoB.addCandidato(candidato2);
        partidoB.addCandidato(candidato4);
        List<Partido>partidos = new ArrayList<>();
        partidos.add(partidoA);
        partidos.add(partidoB);
        Eleicao eleicao = new Eleicao(partidos);
        candidato1.addvotos();
        candidato1.addvotos();
        candidato1.addvotos();
        candidato2.addvotos();
        candidato2.addvotos();
        candidato3.addvotos();
        candidato2.addvotos();
        candidato4.addvotos();
        candidato1.addvotos();
        eleicao.calcularVotos();
        Candidato candidatovencedor = eleicao.getVencedor();
        System.out.println("Vencedor: " + candidatovencedor.getnome());
        System.out.println("Total de votos: " + eleicao.getvotoValidos());

    }
}
