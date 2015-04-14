delimiter $$

CREATE DATABASE `APD3Loja` /*!40100 DEFAULT CHARACTER SET utf8 */$$

CREATE  TABLE `APD3Loja`.`Cliente` (
  `idCliente` BIGINT NOT NULL AUTO_INCREMENT ,
  `nome` VARCHAR(50) NOT NULL ,
  `email` VARCHAR(50) NOT NULL ,
  `cpf` VARCHAR(11) NOT NULL ,
  `senha` VARCHAR(50) NOT NULL ,
  PRIMARY KEY (`idCliente`) ,
  UNIQUE INDEX `email_UNIQUE` (`email` ASC) ,
  UNIQUE INDEX `cpf_UNIQUE` (`cpf` ASC) );$$

CREATE  TABLE `APD3Loja`.`Endereco` (
  `idEndereco` BIGINT NOT NULL AUTO_INCREMENT ,
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
  `idCategoria` BIGINT NOT NULL AUTO_INCREMENT ,
  `descricao` VARCHAR(20) NOT NULL ,
  PRIMARY KEY (`idCategoria`) );$$

CREATE  TABLE `apd3loja`.`Produto` (
  `idProduto` BIGINT NOT NULL AUTO_INCREMENT ,
  `nome` VARCHAR(100) NOT NULL ,
  `preco` DECIMAL(6,2) NOT NULL ,
  `descricao` VARCHAR(500) NULL ,
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
  `idStatusPagamento` BIGINT NOT NULL AUTO_INCREMENT ,
  `descricao` VARCHAR(20) NOT NULL ,
  PRIMARY KEY (`idStatusPagamento`) ); $$

CREATE  TABLE `apd3loja`.`Pagamento` (
  `cdPagamento` BIGINT NOT NULL AUTO_INCREMENT ,
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
  `idStatusPedido` BIGINT NOT NULL AUTO_INCREMENT ,
  `descricao` VARCHAR(30) NOT NULL ,
  PRIMARY KEY (`idStatusPedido`) ); $$

CREATE TABLE `pedido` (
  `cdPedido` bigint(20) NOT NULL AUTO_INCREMENT ,
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

insert into categoria  (descricao) values ('Eletrônicos');$$
insert into categoria  (descricao) values ('Produtos de Beleza');$$
insert into categoria  (descricao) values ('Filmes');$$
insert into categoria  (descricao) values ('Música');$$
insert into categoria  (descricao) values ('Livros');$$
insert into categoria  (descricao) values ('Games');$$
insert into categoria  (descricao) values ('Escritório');$$

insert into produto(nome, preco, descricao, urlFoto, avaliacaoMedia, idCategoria)
values ('Box Trilogia Jogos Vorazes', 80.00, 'Katniss Everdeen é uma jovem de dezesseis anos que mora no Distrito 12 com a mãe e a irmã. Katniss sustenta sua família caçando ilegalmente na floresta com seu melhor amigo Gale. No dia da colheita, sua irmã mais nova é selecionada para participar dos Jogos Vorazes, mas ela se oferece para ir em seu lugar. Mas até onde ela estará disposta a ir para ser vitoriosa?',
null, 8, 5);$$
insert into produto(nome, preco, descricao, urlFoto, avaliacaoMedia, idCategoria)
values ('Motorola Novo Moto X', 1349.00, 'A Motorola inova em tecnologia trazendo a 2ª geração do incrível Moto X, um aparelho com uma série de novas tecnologias que já era capaz de antecipar seus desejos e conta agora com mais interação com usuário através da voz.',
null, 7, 1);$$
insert into produto(nome, preco, descricao, urlFoto, avaliacaoMedia, idCategoria)
values ('Game Grand Theft Auto V - PS4', 148.90, 'O mundo aberto da Rockstar Games que gerou sucesso de crítica chega a uma nova geração, depois da espera finalmente chega o atualizado Grand Theft Auto V!
Entre nas vidas de três criminosos muito diferentes, Michael, Franklin e Trevor, enquanto eles arriscam tudo em uma série de assaltos ousados que podem garantir o resto de suas vidas.',
null, 9, 6);$$
insert into produto(nome, preco, descricao, urlFoto, avaliacaoMedia, idCategoria)
values ('Blu-ray - Guardiões da Galáxia', 49.00, 'Da Marvel, o estúdio que trouxe franquias globais campeãs de bilheteria como Homem de Ferro, Thor, Capitão América e Os Vingadores - The Avengers, chega uma nova equipe, os Guardiões da Galáxia.',
null, 7, 3);$$
insert into produto(nome, preco, descricao, urlFoto, avaliacaoMedia, idCategoria)
values ('Blu-ray The Rolling Stones - Ladies And Gentlemen', 69.90, '"Ladies And Gentlemen... The Rolling Stones" finalmente chega em Blu-ray. Esta lendária gravação ao vivo do Rolling Stones, filmada em quatro noites no Texas durante a turnê "Exile On Main Street", de 1972, foi lançada nos cinemas para poucas exibições, em 1974, e permaneceu inédita por longo tempo. Agora, restaurada e remasterizada, "Ladies And Gentlemen... The Rolling Stones" faz sua primeira aparição autorizada em Blu-ray. ',
null, 8, 4);$$













