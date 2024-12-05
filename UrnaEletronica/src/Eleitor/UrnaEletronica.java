import java.time.LocalDateTime;
import java.util.*;

public class UrnaEletronica {
    private Map<String, Cargo> cargos = new HashMap<>();
    private Map<Integer, Eleitor> eleitores = new HashMap<>();
    private LocalDateTime horarioLimite;
    private boolean encerrada = false;

    public static void main(String[] args) {
        UrnaEletronica urna = new UrnaEletronica();
        urna.configurarUrna();
        urna.iniciarVotacao();
        urna.exibirResultados();
    }

    // Configuração inicial da urna
    public void configurarUrna() {
        // Cadastro de cargos
        cargos.put("Presidente", new Cargo("Presidente", TipoEleicao.MAJORITARIA));
        cargos.put("Deputado Federal", new Cargo("Deputado Federal", TipoEleicao.PROPORCIONAL, 10));
        cargos.put("Deputado Estadual", new Cargo("Deputado Estadual", TipoEleicao.PROPORCIONAL, 30));

        // Cadastro de candidatos
        cargos.get("Presidente").adicionarCandidato(new Candidato(1, "Candidato A", "Partido X"));
        cargos.get("Presidente").adicionarCandidato(new Candidato(2, "Candidato B", "Partido Y"));
        cargos.get("Deputado Federal").adicionarCandidato(new Candidato(3, "Candidato C", "Partido X"));
        cargos.get("Deputado Federal").adicionarCandidato(new Candidato(4, "Candidato D", "Partido Z"));

        // Cadastro de eleitores
        eleitores.put(1001, new Eleitor(1001));
        eleitores.put(1002, new Eleitor(1002));

        // Configuração do horário limite
        horarioLimite = LocalDateTime.now().plusMinutes(30); // 30 minutos para votar
    }

    // Inicia a votação
    public void iniciarVotacao() {
        Scanner scanner = new Scanner(System.in);

        for (Eleitor eleitor : eleitores.values()) {
            if (encerrada || LocalDateTime.now().isAfter(horarioLimite)) {
                System.out.println("Votação encerrada!");
                break;
            }

            if (!eleitor.jaVotou()) {
                System.out.println("Eleitor ID: " + eleitor.getId());
                for (Cargo cargo : cargos.values()) {
                    System.out.println("Votando para: " + cargo.getNome());
                    System.out.print("Digite o número do candidato ou 0 para branco: ");
                    int numero = scanner.nextInt();
                    cargo.registrarVoto(numero);
                }
                eleitor.setJaVotou(true);
            }
        }
    }

    // Exibe os resultados após o encerramento
    public void exibirResultados() {
        System.out.println("\n--- Resultados ---");
        for (Cargo cargo : cargos.values()) {
            cargo.exibirResultados();
        }
        System.out.println("Votação encerrada em: " + LocalDateTime.now());
    }
}