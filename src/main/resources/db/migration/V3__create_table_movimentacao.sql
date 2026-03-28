CREATE TABLE tb_movimentacao (
    id_movimentacao BIGSERIAL PRIMARY KEY,
    valor NUMERIC(12,2) NOT NULL,
    fk_usuario_origem BIGINT NOT NULL,
    fk_usuario_destino BIGINT NOT NULL,
    data_hora_movimentacao TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP,
    tipo VARCHAR(15) NOT NULL,
    CONSTRAINT movimentacao_usuario_origem_fk FOREIGN KEY (fk_usuario_origem) REFERENCES tb_usuario(id),
    CONSTRAINT movimentacao_usuario_destino_fk FOREIGN KEY (fk_usuario_destino) REFERENCES tb_usuario(id),
    CONSTRAINT chk_tipo CHECK (tipo IN ('C', 'D'))
);