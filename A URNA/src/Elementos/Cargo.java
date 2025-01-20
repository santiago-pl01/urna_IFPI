package Elementos;

public enum Cargo {
    PRESIDENTE("MAJORITARIO"),
    GOVERNADOR("MAJORITARIO"),
    DEPUTADO_FEDERAL("PROPORCIONAL"),
    DEPUTADO_ESTADUAL("PROPORCIONAL"),
    SENADOR("MAJORITARIO");

    private final String tipoEleicao;

    // Construtor do enum
    private Cargo(String tipoEleicao) {
        this.tipoEleicao = tipoEleicao;
    }

    // Getter para acessar o tipo de eleição
    public String getTipoEleicao() {
        return tipoEleicao;
    }
}
