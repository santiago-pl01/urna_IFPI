package Urna;

//import Elementos.Candidato;
//import Elementos.Cargo;
import Elementos.Partido;
import Novocadastro.TelaCadastroCandidato;
import Novocadastro.TelaOpcoes;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Partido partidoA = new Partido("PSDV");
        Partido partidoB = new Partido("PD");


        List<Partido> partidos = new ArrayList<>();
        partidos.add(partidoA);
        partidos.add(partidoB);



        TelaCadastroCandidato telaCadastroCandidato = new TelaCadastroCandidato(partidos);
        telaCadastroCandidato.setVisible(true);
       

        // TelaOpcoes telaOpcoes = new TelaOpcoes();
        // telaOpcoes.setVisible(true);
    }

}
