ALTER TABLE tb_movimentacao
ADD CONSTRAINT fk_movimentacao_conta_origem
FOREIGN KEY (fk_conta_origem)
REFERENCES tb_conta (id_conta)
ON DELETE RESTRICT
ON UPDATE CASCADE;

ALTER TABLE tb_movimentacao
ADD CONSTRAINT fk_movimentacao_conta_destino
FOREIGN KEY (fk_conta_destino)
REFERENCES tb_conta (id_conta)
ON DELETE RESTRICT
ON UPDATE CASCADE;