CREATE TABLE tb_conta (
    id_conta BIGSERIAL PRIMARY KEY,
    saldo NUMERIC(12,2) NOT NULL,
    fk_usuario BIGINT NOT NULL,
    fk_movimentacao BIGINT NOT NULL,
    tipo VARCHAR(15) NOT NULL,
    CONSTRAINT conta_usuario_fk FOREIGN KEY (fk_usuario) REFERENCES tb_usuario(id),
    CONSTRAINT conta_movimentacao_fk FOREIGN KEY (fk_movimentacao) REFERENCES tb_movimentacao(id_movimentacao),
    CONSTRAINT chk_tipo CHECK (tipo IN ('C', 'D'))
);