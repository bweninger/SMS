delimiter $$

CREATE DATABASE `APD3Loja` /*!40100 DEFAULT CHARACTER SET utf8 */$$

CREATE  TABLE `APD3Loja`.`Cliente` (
  `idCliente` BIGINT NOT NULL ,
  `nome` VARCHAR(50) NOT NULL ,
  `email` VARCHAR(50) NOT NULL ,
  `cpf` VARCHAR(11) NOT NULL ,
  `senha` VARCHAR(50) NOT NULL ,
  PRIMARY KEY (`idCliente`) ,
  UNIQUE INDEX `email_UNIQUE` (`email` ASC) ,
  UNIQUE INDEX `cpf_UNIQUE` (`cpf` ASC) );$$

CREATE  TABLE `APD3Loja`.`Endereco` (
  `idEndereco` BIGINT NOT NULL ,
  `logradouro` VARCHAR(80) NOT NULL ,
  `numero` INT NOT NULL ,
  `complemento` VARCHAR(10) NULL ,
  `cep` VARCHAR(8) NOT NULL ,
  `idCliente` BIGINT NOT NULL ,
  PRIMARY KEY (`idEndereco`) ,
  INDEX `endereco_cliente_idx` (`idCliente` ASC) ,
  CONSTRAINT `endereco_cliente`
    FOREIGN KEY (`idCliente` )
    REFERENCES `APD3Loja`.`cliente` (`idCliente` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);$$

CREATE  TABLE `apd3loja`.`Categoria` (
  `idCategoria` BIGINT NOT NULL ,
  `descricao` VARCHAR(20) NOT NULL ,
  PRIMARY KEY (`idCategoria`) );$$

CREATE  TABLE `apd3loja`.`Produto` (
  `idProduto` BIGINT NOT NULL ,
  `nome` VARCHAR(30) NOT NULL ,
  `preco` DECIMAL(6,2) NOT NULL ,
  `descricao` VARCHAR(200) NULL ,
  `urlFoto` VARCHAR(50) NULL ,
  `avaliacaoMedia` INT NOT NULL ,
  `idCategoria` BIGINT NOT NULL ,
  PRIMARY KEY (`idProduto`) ,
  INDEX `produto_categoria_idx` (`idCategoria` ASC) ,
  CONSTRAINT `produto_categoria`
    FOREIGN KEY (`idCategoria` )
    REFERENCES `apd3loja`.`categoria` (`idCategoria` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);$$

CREATE  TABLE `apd3loja`.`StatusPagamento` (
  `idStatusPagamento` BIGINT NOT NULL ,
  `descricao` VARCHAR(20) NOT NULL ,
  PRIMARY KEY (`idStatusPagamento`) ); $$

CREATE  TABLE `apd3loja`.`Pagamento` (
  `cdPagamento` BIGINT NOT NULL ,
  `valor` DECIMAL(6,2) NOT NULL ,
  `idStatusPagamento` BIGINT NOT NULL ,
	`tipoPagamento` INT NOT NULL ,	
  PRIMARY KEY (`cdPagamento`) ,
  INDEX `pagamento_status_idx` (`idStatusPagamento` ASC) ,
  CONSTRAINT `pagamento_status`
    FOREIGN KEY (`idStatusPagamento` )
    REFERENCES `apd3loja`.`statuspagamento` (`idStatusPagamento` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION); $$

CREATE  TABLE `apd3loja`.`StatusPedido` (
  `idStatusPedido` BIGINT NOT NULL ,
  `descricao` VARCHAR(30) NOT NULL ,
  PRIMARY KEY (`idStatusPedido`) ); $$

CREATE TABLE `pedido` (
  `cdPedido` bigint(20) NOT NULL,
  `idCliente` bigint(20) NOT NULL,
  `idEndereco` bigint(20) NOT NULL,
  `dataPedido` date NOT NULL,
  `dataPrevisaoEntrega` date NOT NULL,
  `idStatusPedido` bigint(20) NOT NULL,
  `cdPagamento` bigint(20) NOT NULL,
  PRIMARY KEY (`cdPedido`),
  KEY `pedido_status_idx` (`idStatusPedido`),
  KEY `pedido_cliente_idx` (`idCliente`),
  KEY `pedido_endereco_idx` (`idEndereco`),
  KEY `pedido_pagamento_idx` (`cdPagamento`),
  CONSTRAINT `pedido_pagamento` FOREIGN KEY (`cdPagamento`) REFERENCES `pagamento` (`cdPagamento`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `pedido_cliente` FOREIGN KEY (`idCliente`) REFERENCES `cliente` (`idCliente`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `pedido_endereco` FOREIGN KEY (`idEndereco`) REFERENCES `endereco` (`idEndereco`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `pedido_status` FOREIGN KEY (`idStatusPedido`) REFERENCES `statuspedido` (`idStatusPedido`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8$$

CREATE TABLE `apd3loja`.`item_pedido` (
  `idProduto` bigint(20) NOT NULL,
  `idPedido` bigint(20) NOT NULL,
  `quantidade` int(11) NOT NULL,
  `comentario` varchar(200) DEFAULT NULL,
  `avaliacao` int(11) DEFAULT NULL,
  PRIMARY KEY (`idProduto`,`idPedido`),
  KEY `item_pedido_pedido_idx` (`idPedido`),
  KEY `item_pedido_produto_idx` (`idProduto`),
  CONSTRAINT `item_pedido_pedido` FOREIGN KEY (`idPedido`) REFERENCES `pedido` (`cdPedido`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `item_pedido_produto` FOREIGN KEY (`idProduto`) REFERENCES `produto` (`idProduto`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8$$













