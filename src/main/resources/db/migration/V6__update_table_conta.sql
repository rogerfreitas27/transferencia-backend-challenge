ALTER TABLE tb_movimentacao
DROP CONSTRAINT movimentacao_usuario_origem_fk;

ALTER TABLE tb_movimentacao
DROP CONSTRAINT movimentacao_usuario_destino_fk;

ALTER TABLE tb_movimentacao
DROP CONSTRAINT chk_tipo;

ALTER TABLE tb_movimentacao
DROP COLUMN fk_usuario_origem;

ALTER TABLE tb_movimentacao
DROP COLUMN fk_usuario_destino;

ALTER TABLE tb_movimentacao
DROP COLUMN tipo;

ALTER TABLE tb_movimentacao
ADD COLUMN descricao varchar(255) NULL;

ALTER TABLE tb_movimentacao
ADD COLUMN fk_conta_origem BIGINT NOT NULL;

ALTER TABLE tb_movimentacao
ADD COLUMN fk_conta_destino BIGINT NOT NULL;


ALTER TABLE tb_movimentacao
ADD CONSTRAINT movimentacao_conta_origem_fk
FOREIGN KEY (fk_conta_origem) REFERENCES tb_conta(id_conta);

ALTER TABLE tb_movimentacao
ADD CONSTRAINT movimentacao_conta_destino_fk
FOREIGN KEY (fk_conta_destino) REFERENCES tb_conta(id_conta);