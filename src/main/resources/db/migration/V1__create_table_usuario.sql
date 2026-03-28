CREATE TABLE usuario (
    id BIGSERIAL PRIMARY KEY,
    nome_completo VARCHAR(255) NOT NULL,
    cpf_cnpj VARCHAR(20) NOT NULL,
    tipo_pessoa VARCHAR(20) NOT NULL,
    email VARCHAR(150) NOT NULL,
    senha VARCHAR(255) NOT NULL,
    CONSTRAINT uk_usuario_email UNIQUE (email),
    CONSTRAINT uk_usuario_cpf_cnpj UNIQUE (cpf_cnpj),
    CONSTRAINT chk_tipo_pessoa
    CHECK (tipo_pessoa IN ('FISICA', 'JURIDICA'))
);