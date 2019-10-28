DROP DATABASE IF EXISTS pedidos;

CREATE DATABASE pedidos;

USE pedidos;

DROP TABLE IF EXISTS produtos;

CREATE TABLE produtos(
  id        BIGINT        NOT NULL AUTO_INCREMENT PRIMARY KEY,
  descricao VARCHAR(255)  NOT NULL,
  preco     DECIMAL(15,2) NOT NULL DEFAULT 0.0,
  estoque   DECIMAL(15,3) NOT NULL DEFAULT 0.0
);

DROP TABLE IF EXISTS clientes;

CREATE TABLE clientes(
  id          BIGINT        NOT NULL AUTO_INCREMENT PRIMARY KEY,
  nome        VARCHAR(255)  NOT NULL,
  tipo_pessoa SMALLINT      NOT NULL DEFAULT 0,
  cnpj_cpf    VARCHAR(18)   NOT NULL    
);

DROP TABLE IF EXISTS pedidos;

CREATE TABLE pedidos (
  id          BIGINT        NOT NULL AUTO_INCREMENT PRIMARY KEY,
  data        DATE          NOT NULL,
  cliente_id  BIGINT        NOT NULL,
  aprovado_em TIMESTAMP,
  faturado_em TIMESTAMP
);

DROP TABLE IF EXISTS pedidos_itens;

CREATE TABLE pedidos_itens (
  pedido_id   BIGINT        NOT NULL,
  produto_id  BIGINT        NOT NULL,
  preco       DECIMAL(15,2) NOT NULL DEFAULT 0.0,
  estoque     DECIMAL(15,3) NOT NULL DEFAULT 0.0,
  PRIMARY KEY(pedido_id, produto_id)
);