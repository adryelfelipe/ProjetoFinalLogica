CREATE DATABASE IF NOT EXISTS ManutencaoServicos;
USE ManutencaoServicos;

-- 1. Tabelas de Apoio (Sem chaves estrangeiras)
CREATE TABLE `Departamento` (
  `id_departamento` int NOT NULL,
  `nome` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id_departamento`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE `Especialidade` (
  `id_especialidade` int NOT NULL,
  `nome` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id_especialidade`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE `NivelAcesso` (
  `id_na` int NOT NULL,
  `descricao` varchar(150) DEFAULT NULL,
  PRIMARY KEY (`id_na`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE `StatusMaquina` (
  `id_sm` int NOT NULL,
  `nome` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id_sm`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE `statusOc` (
  `id_statusOc` int NOT NULL,
  `nome` varchar(45) NOT NULL,
  PRIMARY KEY (`id_statusOc`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE `statusOs` (
  `status_ordem` int NOT NULL,
  `nome` varchar(45) NOT NULL,
  PRIMARY KEY (`status_ordem`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE `TipoOS` (
  `id_tipoOS` int NOT NULL AUTO_INCREMENT,
  `nome` varchar(100) NOT NULL,
  PRIMARY KEY (`id_tipoOS`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- 2. Tabelas Principais (Com chaves estrangeiras)

CREATE TABLE `Usuario` (
  `id_usuario` int NOT NULL AUTO_INCREMENT,
  `nome` varchar(100) NOT NULL,
  `cpf` varchar(11) NOT NULL,
  `senha` varchar(45) NOT NULL,
  `id_na` int NOT NULL,
  PRIMARY KEY (`id_usuario`),
  UNIQUE KEY `cpf` (`cpf`),
  KEY `id_na` (`id_na`),
  CONSTRAINT `Usuario_ibfk_1` FOREIGN KEY (`id_na`) REFERENCES `NivelAcesso` (`id_na`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE `UsuarioDepartamento` (
  `id_usuarioDep` int NOT NULL AUTO_INCREMENT,
  `id_usuario` int NOT NULL,
  `id_departamento` int NOT NULL,
  PRIMARY KEY (`id_usuarioDep`),
  KEY `id_usuario` (`id_usuario`),
  KEY `id_departamento` (`id_departamento`),
  CONSTRAINT `UsuarioDepartamento_ibfk_1` FOREIGN KEY (`id_usuario`) REFERENCES `Usuario` (`id_usuario`),
  CONSTRAINT `UsuarioDepartamento_ibfk_2` FOREIGN KEY (`id_departamento`) REFERENCES `Departamento` (`id_departamento`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE `Tecnico` (
  `id_tecnico` int NOT NULL,
  `id_especialidade` int NOT NULL,
  PRIMARY KEY (`id_tecnico`),
  KEY `id_especialidade` (`id_especialidade`),
  CONSTRAINT `Tecnico_ibfk_1` FOREIGN KEY (`id_tecnico`) REFERENCES `Usuario` (`id_usuario`),
  CONSTRAINT `Tecnico_ibfk_2` FOREIGN KEY (`id_especialidade`) REFERENCES `Especialidade` (`id_especialidade`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE `Supervisor` (
  `id_supervisor` int NOT NULL,
  `meta_mensal` decimal(10,2) NOT NULL,
  PRIMARY KEY (`id_supervisor`),
  CONSTRAINT `Supervisor_ibfk_1` FOREIGN KEY (`id_supervisor`) REFERENCES `Usuario` (`id_usuario`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE `Gerentes` (
  `id_gerente` int NOT NULL,
  `id_departamento` int NOT NULL,
  PRIMARY KEY (`id_gerente`),
  KEY `id_departamento` (`id_departamento`),
  CONSTRAINT `Gerentes_ibfk_1` FOREIGN KEY (`id_gerente`) REFERENCES `Usuario` (`id_usuario`),
  CONSTRAINT `Gerentes_ibfk_2` FOREIGN KEY (`id_departamento`) REFERENCES `Departamento` (`id_departamento`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE `Maquinas` (
  `id_maquina` int NOT NULL AUTO_INCREMENT,
  `nome` varchar(100) NOT NULL,
  `id_departamento` int NOT NULL,
  `id_sm` int NOT NULL,
  PRIMARY KEY (`id_maquina`),
  KEY `id_sm` (`id_sm`),
  KEY `id_departamento` (`id_departamento`),
  CONSTRAINT `Maquinas_ibfk_1` FOREIGN KEY (`id_sm`) REFERENCES `StatusMaquina` (`id_sm`),
  CONSTRAINT `Maquinas_ibfk_2` FOREIGN KEY (`id_departamento`) REFERENCES `Departamento` (`id_departamento`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- 3. Tabelas de Processos (Ordens e Ocorrências)

CREATE TABLE `OcorrenciasAtivas` (
  `id_oa` int NOT NULL AUTO_INCREMENT,
  `id_maquina` int NOT NULL,
  `id_departamento` int NOT NULL,
  `id_statusOc` int NOT NULL DEFAULT '1',
  PRIMARY KEY (`id_oa`),
  UNIQUE KEY `id_maquina` (`id_maquina`),
  KEY `id_departamento` (`id_departamento`),
  KEY `fk_oa_status` (`id_statusOc`),
  CONSTRAINT `fk_oa_status` FOREIGN KEY (`id_statusOc`) REFERENCES `statusOc` (`id_statusOc`),
  CONSTRAINT `OcorrenciasAtivas_ibfk_1` FOREIGN KEY (`id_departamento`) REFERENCES `Departamento` (`id_departamento`),
  CONSTRAINT `OcorrenciasAtivas_ibfk_2` FOREIGN KEY (`id_maquina`) REFERENCES `Maquinas` (`id_maquina`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE `OcorrenciasGerais` (
  `id_og` int NOT NULL AUTO_INCREMENT,
  `nome_maquina` varchar(100) NOT NULL,
  `id_departamento` int NOT NULL,
  `id_statusOc` int NOT NULL,
  PRIMARY KEY (`id_og`),
  KEY `id_departamento` (`id_departamento`),
  KEY `id_statusOc` (`id_statusOc`),
  CONSTRAINT `OcorrenciasGerais_ibfk_1` FOREIGN KEY (`id_departamento`) REFERENCES `Departamento` (`id_departamento`),
  CONSTRAINT `OcorrenciasGerais_ibfk_2` FOREIGN KEY (`id_statusOc`) REFERENCES `statusOc` (`id_statusOc`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE `OrdemDeServicosGerais` (
  `id_osg` int NOT NULL AUTO_INCREMENT,
  `id_departamento` int NOT NULL,
  `descricao` varchar(150) NOT NULL,
  `id_tipoOS` int NOT NULL,
  `statusOS` int NOT NULL,
  `valorOS` decimal(15,2) NOT NULL,
  `nome_maquina` varchar(100) NOT NULL,
  `nome_tecnico` varchar(100) NOT NULL,
  `nome_supervisor` varchar(100) NOT NULL,
  PRIMARY KEY (`id_osg`),
  KEY `id_departamento` (`id_departamento`),
  KEY `id_tipoOS` (`id_tipoOS`),
  KEY `statusOS` (`statusOS`),
  CONSTRAINT `OrdemDeServicosGerais_ibfk_1` FOREIGN KEY (`id_departamento`) REFERENCES `Departamento` (`id_departamento`),
  CONSTRAINT `OrdemDeServicosGerais_ibfk_2` FOREIGN KEY (`id_tipoOS`) REFERENCES `TipoOS` (`id_tipoOS`),
  CONSTRAINT `OrdemDeServicosGerais_ibfk_3` FOREIGN KEY (`statusOS`) REFERENCES `statusOs` (`status_ordem`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE `OrdemServicos` (
  `id_os` int NOT NULL AUTO_INCREMENT,
  `descricao` varchar(250) NOT NULL,
  `statusOS` int NOT NULL,
  `valorOS` decimal(15,2) NOT NULL,
  `id_tipoOS` int NOT NULL,
  `id_maquina` int NOT NULL,
  `id_tecnico` int NOT NULL,
  `id_supervisor` int NOT NULL,
  `id_departamento` int NOT NULL,
  PRIMARY KEY (`id_os`),
  KEY `id_tipoOS` (`id_tipoOS`),
  KEY `id_departamento` (`id_departamento`),
  KEY `statusOS` (`statusOS`),
  KEY `id_maquina` (`id_maquina`),
  KEY `id_tecnico` (`id_tecnico`),
  KEY `id_supervisor` (`id_supervisor`),
  CONSTRAINT `OrdemServicos_ibfk_1` FOREIGN KEY (`id_tipoOS`) REFERENCES `TipoOS` (`id_tipoOS`),
  CONSTRAINT `OrdemServicos_ibfk_2` FOREIGN KEY (`id_departamento`) REFERENCES `Departamento` (`id_departamento`),
  CONSTRAINT `OrdemServicos_ibfk_3` FOREIGN KEY (`statusOS`) REFERENCES `statusOs` (`status_ordem`),
  CONSTRAINT `OrdemServicos_ibfk_4` FOREIGN KEY (`id_maquina`) REFERENCES `Maquinas` (`id_maquina`),
  CONSTRAINT `OrdemServicos_ibfk_5` FOREIGN KEY (`id_tecnico`) REFERENCES `Tecnico` (`id_tecnico`),
  CONSTRAINT `OrdemServicos_ibfk_6` FOREIGN KEY (`id_supervisor`) REFERENCES `Supervisor` (`id_supervisor`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;


USE ManutencaoServicos;

SET SQL_SAFE_UPDATES = 0;

DELETE FROM Gerentes WHERE id_gerente NOT IN (SELECT id_usuario FROM Usuario);
DELETE FROM Tecnico WHERE id_tecnico NOT IN (SELECT id_usuario FROM Usuario);
DELETE FROM Supervisor WHERE id_supervisor NOT IN (SELECT id_usuario FROM Usuario);
DELETE FROM UsuarioDepartamento WHERE id_usuario NOT IN (SELECT id_usuario FROM Usuario);

SET SQL_SAFE_UPDATES = 1;

ALTER TABLE Tecnico DROP FOREIGN KEY tecnico_ibfk_1;
ALTER TABLE Supervisor DROP FOREIGN KEY supervisor_ibfk_1;
ALTER TABLE Gerentes DROP FOREIGN KEY gerentes_ibfk_1;
ALTER TABLE UsuarioDepartamento DROP FOREIGN KEY usuariodepartamento_ibfk_1;

ALTER TABLE Tecnico ADD CONSTRAINT fk_tecnico_cascade FOREIGN KEY (id_tecnico) REFERENCES Usuario(id_usuario) ON DELETE CASCADE;
ALTER TABLE Supervisor ADD CONSTRAINT fk_supervisor_cascade FOREIGN KEY (id_supervisor) REFERENCES Usuario(id_usuario) ON DELETE CASCADE;
ALTER TABLE Gerentes ADD CONSTRAINT fk_gerentes_cascade FOREIGN KEY (id_gerente) REFERENCES Usuario(id_usuario) ON DELETE CASCADE;
ALTER TABLE UsuarioDepartamento ADD CONSTRAINT fk_usudep_cascade FOREIGN KEY (id_usuario) REFERENCES Usuario(id_usuario) ON DELETE CASCADE;

USE ManutencaoServicos;

ALTER TABLE OrdemServicos DROP FOREIGN KEY OrdemServicos_ibfk_5;

ALTER TABLE OrdemServicos DROP FOREIGN KEY OrdemServicos_ibfk_6;

ALTER TABLE OrdemServicos
ADD CONSTRAINT fk_os_tecnico_cascade
FOREIGN KEY (id_tecnico) REFERENCES Tecnico(id_tecnico)
ON DELETE CASCADE;

ALTER TABLE OrdemServicos
ADD CONSTRAINT fk_os_supervisor_cascade
FOREIGN KEY (id_supervisor) REFERENCES Supervisor(id_supervisor)
ON DELETE CASCADE;

INSERT INTO Usuario (nome, cpf, senha, id_na) VALUES ('Admin2', '00000000000', '123456@Aa', 4);
UPDATE Usuario SET nome = 'AdminDois' where id_usuario = 23;


ALTER TABLE OcorrenciasAtivas DROP FOREIGN KEY OcorrenciasAtivas_ibfk_2;

ALTER TABLE OcorrenciasAtivas
ADD CONSTRAINT OcorrenciasAtivas_ibfk_2
FOREIGN KEY (id_maquina) REFERENCES Maquinas(id_maquina)
ON DELETE CASCADE;

ALTER TABLE OrdemServicos DROP FOREIGN KEY OrdemServicos_ibfk_4;

ALTER TABLE OrdemServicos
ADD CONSTRAINT OrdemServicos_ibfk_4
FOREIGN KEY (id_maquina) REFERENCES Maquinas(id_maquina)
ON DELETE CASCADE;

ALTER TABLE OrdemDeServicosGerais ADD COLUMN id_os_referencia INT;