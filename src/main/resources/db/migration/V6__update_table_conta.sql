ALTER TABLE tb_conta
DROP CONSTRAINT conta_movimentacao_fk;

ALTER TABLE tb_conta
DROP CONSTRAINT chk_tipo;

ALTER TABLE tb_conta
DROP COLUMN tipo;

