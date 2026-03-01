create database if not exists projetoIndividual;
use projetoIndividual;
create table if not exists usuario(
	id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(150) NOT NULL,
    email VARCHAR(150) NOT NULL UNIQUE,
    senha VARCHAR(255) NOT NULL,
    cor_dos_olhos VARCHAR(50),
    sexo CHAR(1),
    dt_nascimento DATE,
    escolaridade VARCHAR(100)
    );
    
    CREATE TABLE IF NOT EXISTS tarefa (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    titulo VARCHAR(100) NOT NULL,
    descricao TEXT,
    prioridade INT DEFAULT 1, -- 1: Baixa, 2: Média, 3: Alta
    data_criacao DATETIME DEFAULT CURRENT_TIMESTAMP,
    fk_usuario BIGINT NOT NULL,
    
    status VARCHAR(20) DEFAULT 'PENDENTE' 
    CHECK (status IN ('PENDENTE', 'EM_ANDAMENTO', 'CONCLUIDO')),
    CONSTRAINT fk_tarefa_usuario FOREIGN KEY (fk_usuario) REFERENCES usuario(id) 
        ON DELETE CASCADE 
);