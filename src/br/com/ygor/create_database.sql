CREATE DATABASE IF NOT EXISTS sigac;

use sigac;

CREATE TABLE IF NOT EXISTS escola
(
  id INT NOT NULL AUTO_INCREMENT,
  nome VARCHAR(250) NOT NULL,
  
  CONSTRAINT PK_id_escola PRIMARY KEY(id)
);

CREATE TABLE IF NOT EXISTS curso
(
  id INT NOT NULL AUTO_INCREMENT,
  nome VARCHAR(250) NOT NULL,
  id_escola INT UNIQUE,
  
  CONSTRAINT PK_id_curso PRIMARY KEY(id),
  CONSTRAINT FK_id_escola FOREIGN KEY (id_escola) REFERENCES escola(id)
);

CREATE TABLE IF NOT EXISTS aluno
(
  id INT NOT NULL AUTO_INCREMENT,
  id_curso INT UNIQUE,
  nome VARCHAR(50) NOT NULL,
  matricula INT UNIQUE NOT NULL,
  endereco VARCHAR(250),
  telefone VARCHAR(50),  
  
  CONSTRAINT PK_id_aluno PRIMARY KEY(id),
  CONSTRAINT FK_id_curso FOREIGN KEY (id_curso) REFERENCES curso(id)
);

CREATE TABLE IF NOT EXISTS disciplina
(
  id INT NOT NULL AUTO_INCREMENT,
  nome VARCHAR(250) NOT NULL,
  -- ACRESCENTAR LISTA DE CURSOS
  CONSTRAINT PK_id_disciplina PRIMARY KEY(id)
);

CREATE TABLE IF NOT EXISTS professor
(
  id INT NOT NULL AUTO_INCREMENT,
  nome VARCHAR(250) NOT NULL,
  matricula INT UNIQUE NOT NULL,
  salario DOUBLE NOT NULL,
  data_adm DATE NOT NULL,
  logradouro VARCHAR(100),
  cidade VARCHAR(50),
  uf VARCHAR(50),
  telefone VARCHAR(50),
  -- ACRESCENTAR LISTA DE ESCOLAS
  CONSTRAINT PK_id_professor PRIMARY KEY(id)
 );

CREATE TABLE IF NOT EXISTS turma
(
  id INT NOT NULL AUTO_INCREMENT,
  id_disciplina INT UNIQUE,
  id_professor INT UNIQUE,
  -- ACRESCENTAR LISTA DE ALUNOS
  CONSTRAINT PK_id_turma PRIMARY KEY(id),
  CONSTRAINT FK_id_disciplina FOREIGN KEY (id_disciplina) REFERENCES disciplina(id),
  CONSTRAINT FK_id_professor FOREIGN KEY (id_professor) REFERENCES professor(id)
);
 
 
/* Inserindo alguns valores */
INSERT INTO escola (nome) VALUES ('T.I');
INSERT INTO escola (nome) VALUES ('Engenharias');
INSERT INTO escola (nome) VALUES ('Saúde');
INSERT INTO escola (nome) VALUES ('Humanidades');

INSERT INTO curso (nome, id_escola) VALUES ('S.I', 1);
INSERT INTO curso (nome, id_escola) VALUES ('Engenharia Cívil', 2);
INSERT INTO curso (nome, id_escola) VALUES ('Medicina', 3);
INSERT INTO curso (nome, id_escola) VALUES ('Filosofia', 4);