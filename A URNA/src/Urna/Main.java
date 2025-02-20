package Urna;

import Elementos.Partido;



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
        Partido partidoC = new Partido("AB");

        List<Partido> partidos = new ArrayList<>();
        partidos.add(partidoA);
        partidos.add(partidoB);
        partidos.add(partidoC);

        return partidos;
    }
}

