delimiter $$

CREATE DATABASE `apd3loja` /*!40100 DEFAULT CHARACTER SET utf8 */$$

delimiter $$

CREATE TABLE `categoria` (
  `idCategoria` bigint(20) NOT NULL AUTO_INCREMENT,
  `descricao` varchar(20) NOT NULL,
  PRIMARY KEY (`idCategoria`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8$$

delimiter $$

CREATE TABLE `produto` (
  `idProduto` bigint(20) NOT NULL AUTO_INCREMENT,
  `nome` varchar(100) NOT NULL,
  `preco` decimal(6,2) NOT NULL,
  `descricao` varchar(500) DEFAULT NULL,
  `urlFoto` varchar(50) DEFAULT NULL,
  `avaliacaoMedia` int(11) NOT NULL,
  `idCategoria` bigint(20) NOT NULL,
  PRIMARY KEY (`idProduto`),
  KEY `produto_categoria_idx` (`idCategoria`),
  CONSTRAINT `produto_categoria` FOREIGN KEY (`idCategoria`) REFERENCES `categoria` (`idCategoria`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8$$

delimiter $$

CREATE TABLE `cliente` (
  `idCliente` bigint(20) NOT NULL AUTO_INCREMENT,
  `nome` varchar(50) NOT NULL,
  `email` varchar(50) NOT NULL,
  `cpf` varchar(11) NOT NULL,
  PRIMARY KEY (`idCliente`,`nome`),
  UNIQUE KEY `email_UNIQUE` (`email`),
  UNIQUE KEY `cpf_UNIQUE` (`cpf`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8$$

delimiter $$

CREATE TABLE `endereco` (
  `idEndereco` bigint(20) NOT NULL AUTO_INCREMENT,
  `logradouro` varchar(80) NOT NULL,
  `numero` int(11) NOT NULL,
  `complemento` varchar(10) DEFAULT NULL,
  `cep` varchar(8) NOT NULL,
  `idCliente` bigint(20) NOT NULL,
  PRIMARY KEY (`idEndereco`),
  KEY `endereco_cliente_idx` (`idCliente`),
  CONSTRAINT `endereco_cliente` FOREIGN KEY (`idCliente`) REFERENCES `cliente` (`idCliente`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8$$

delimiter $$

CREATE TABLE `pagamento` (
  `cdPagamento` bigint(20) NOT NULL AUTO_INCREMENT,
  `valor` decimal(6,2) NOT NULL,
  `idStatusPagamento` bigint(20) NOT NULL,
  `tipoPagamento` int(11) NOT NULL,
  PRIMARY KEY (`cdPagamento`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8$$

delimiter $$

CREATE TABLE `pedido` (
  `cdPedido` bigint(50) NOT NULL,
  `idCliente` bigint(20) NOT NULL,
  `idEndereco` bigint(20) NOT NULL,
  `dataPedido` date NOT NULL,
  `dataPrevisaoEntrega` date DEFAULT NULL,
  `idStatusPedido` bigint(20) NOT NULL,
  `cdPagamento` bigint(20) NOT NULL,
  PRIMARY KEY (`cdPedido`),
  KEY `pedido_cliente_idx` (`idCliente`),
  KEY `pedido_endereco_idx` (`idEndereco`),
  KEY `pedido_pagamento_idx` (`cdPagamento`),
  CONSTRAINT `pedido_cliente` FOREIGN KEY (`idCliente`) REFERENCES `cliente` (`idCliente`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `pedido_endereco` FOREIGN KEY (`idEndereco`) REFERENCES `endereco` (`idEndereco`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `pedido_pagamento` FOREIGN KEY (`cdPagamento`) REFERENCES `pagamento` (`cdPagamento`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8$$

delimiter $$

CREATE TABLE `item_pedido` (
  `idProduto` bigint(20) NOT NULL,
  `idPedido` bigint(50) NOT NULL,
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













