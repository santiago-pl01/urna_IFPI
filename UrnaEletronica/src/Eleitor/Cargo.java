package Eleitor;

import java.util.HashMap;

public class Cargo {

	private String nome;
    private TipoEleicao tipo;
    private int vagas;
    private Map<Integer, Candidato> candidatos = new HashMap<>();
    private int votosBrancos = 0;
    private int votosNulos = 0;

    public Cargo(String nome, TipoEleicao tipo) {
        this(nome, tipo, 0);
    }

    public Cargo(String nome, TipoEleicao tipo, int vagas) {
        this.nome = nome;
        this.tipo = tipo;
        this.vagas = vagas;
    }

    public String getNome() {
        return nome;
    }

    public void adicionarCandidato(Candidato candidato) {
        candidatos.put(candidato.getNumero(), candidato);
    }

    public void registrarVoto(int numero) {
        if (numero == 0) {
            votosBrancos++;
        } else if (candidatos.containsKey(numero)) {
            candidatos.get(numero).incrementarVotos();
        } else {
            votosNulos++;
        }
    }

    public void exibirResultados() {
        System.out.println("Cargo: " + nome);
        candidatos.values().forEach(c -> System.out.println(c));
        System.out.println("Votos brancos: " + votosBrancos);
        System.out.println("Votos nulos: " + votosNulos);
        if (tipo == TipoEleicao.PROPORCIONAL) {
            calcularProporcionalidade();
        }
    }

    private void calcularProporcionalidade() {
        int totalVotosValidos = candidatos.values().stream().mapToInt(Candidato::getVotos).sum();
        System.out.println("Distribuição de vagas:");
        candidatos.values().forEach(c -> {
            double proporcao = (double) c.getVotos() / totalVotosValidos;
            int vagasObtidas = (int) Math.round(proporcao * vagas);
            System.out.println(c.getNome() + " - Vagas: " + vagasObtidas);
        });
    }
}
