package Urna;

//import Elementos.Candidato; // Importa a classe Candidato nao usada
//import Elementos.Cargo; // Importa a classe Cargo nao usada
import Elementos.Partido;
//import Novocadastro.TelaCadastroCandidato; // Importa a classe TelaCadastroCandidato nao usada
//import Novocadastro.TelaOpcoes; // Importa a classe TelaOpcoes nao usada

import java.util.ArrayList;
import java.util.List;



// Classe Principal Main, foi reorganizada para ficar mais limpa 
public class Main {
    
    // Metodo Principal ele cria uma lista de partidos, e cria uma instancia da Urna, passando a lista de partidos como argumento.
    public static void main(String[] args) {

        List<Partido> partidos = criarPartidos();
        new Urna(partidos);
    }


    // Esse medodo cria uma lista de partidos com dois partidos. e retorna essa lista
    public static List<Partido> criarPartidos() {

        Partido partidoA = new Partido("PSDV");
        Partido partidoB = new Partido("PD");

        List<Partido> partidos = new ArrayList<>();
        partidos.add(partidoA);
        partidos.add(partidoB);

        return partidos;
    }
}

