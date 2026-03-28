package transferenciadesafiotecnico.com.br.model.enums;

public enum TipoPessoaEnum {

    FISICA("F", "Pessoa Física"),
    JURIDICA("J", "Pessoa Jurídica");

    private final String codigo;
    private final String descricao;

    TipoPessoaEnum(String codigo, String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public static TipoPessoaEnum fromCodigo(String codigo) {
        for (TipoPessoaEnum tipo : values()) {
            if (tipo.codigo.equalsIgnoreCase(codigo)) {
                return tipo;
            }
        }
        throw new IllegalArgumentException("Código inválido: " + codigo);
    }
}
