package Urna;

import Elementos.Candidato;
import Elementos.Cargo;
import Elementos.Partido;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Partido partidoA = new Partido("PSDV");
        Partido partidoB = new Partido("PD");


        Candidato candidato1 = new Candidato("João", 97, partidoA, Cargo.PRESIDENTE);
        Candidato candidato2 = new Candidato("José", 56, partidoB, Cargo.PRESIDENTE);
        Candidato candidato3 = new Candidato("Maria", 23, partidoA, Cargo.DEPUTADO_FEDERAL);
        Candidato candidato4 = new Candidato("Lucas", 45, partidoB, Cargo.DEPUTADO_FEDERAL);


        partidoA.addCandidato(candidato1);
        partidoA.addCandidato(candidato3);
        partidoB.addCandidato(candidato2);
        partidoB.addCandidato(candidato4);


        List<Partido> partidos = new ArrayList<>();
        partidos.add(partidoA);
        partidos.add(partidoB);

        candidato1.addVoto();
        candidato1.addVoto();
        candidato1.addVoto();
        candidato2.addVoto();
        candidato2.addVoto();
        candidato2.addVoto();
        candidato2.addVoto();
        candidato3.addVoto();
        candidato4.addVoto();
        candidato4.addVoto();
        

        Urna urna = new Urna(partidos);// Instancia a urna
        urna.exibirResultados(); // Chama o método para exibir os resultados
        
    }

}
