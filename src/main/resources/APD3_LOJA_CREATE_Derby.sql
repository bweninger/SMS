CREATE  TABLE Cliente (
idCliente BIGINT NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
nome VARCHAR(50) NOT NULL ,
email VARCHAR(50) NOT NULL ,
cpf VARCHAR(11) NOT NULL ,
senha VARCHAR(50) NOT NULL ,
PRIMARY KEY (idCliente) ,
UNIQUE (email),
UNIQUE (cpf));

CREATE  TABLE Endereco (
  idEndereco BIGINT NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1) ,
  logradouro VARCHAR(80) NOT NULL ,
  numero INT NOT NULL ,
  complemento VARCHAR(10) NOT NULL ,
  cep VARCHAR(8) NOT NULL ,
  idCliente BIGINT NOT NULL ,
  PRIMARY KEY (idEndereco),
  FOREIGN KEY (idCliente)
  REFERENCES cliente (idCliente)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);

CREATE  TABLE Categoria (
idCategoria BIGINT NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1) ,
descricao VARCHAR(20) NOT NULL ,
PRIMARY KEY (idCategoria));

CREATE  TABLE Produto (
idProduto BIGINT NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1) ,
nome VARCHAR(100) NOT NULL ,
preco DECIMAL(6,2) NOT NULL ,
descricao VARCHAR(500) ,
urlFoto VARCHAR(50) ,
avaliacaoMedia INT NOT NULL ,
idCategoria BIGINT NOT NULL ,
PRIMARY KEY (idProduto) ,
FOREIGN KEY (idCategoria)
REFERENCES categoria (idCategoria)
ON DELETE NO ACTION
ON UPDATE NO ACTION);

CREATE  TABLE StatusPagamento (
idStatusPagamento BIGINT NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1) ,
descricao VARCHAR(20) NOT NULL ,
PRIMARY KEY (idStatusPagamento) );

CREATE  TABLE Pagamento (
cdPagamento BIGINT NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1) ,
valor DECIMAL(6,2) NOT NULL ,
idStatusPagamento BIGINT NOT NULL ,
tipoPagamento INT NOT NULL ,
PRIMARY KEY (cdPagamento),
FOREIGN KEY (idStatusPagamento )
REFERENCES statuspagamento (idStatusPagamento )
ON DELETE NO ACTION
ON UPDATE NO ACTION);

CREATE  TABLE StatusPedido (
idStatusPedido BIGINT NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1) ,
descricao VARCHAR(30) NOT NULL ,
PRIMARY KEY (idStatusPedido));

CREATE TABLE pedido (
cdPedido bigint NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1000, INCREMENT BY 1) ,
idCliente bigint NOT NULL,
idEndereco bigint NOT NULL,
dataPedido date NOT NULL,
dataPrevisaoEntrega date NOT NULL,
idStatusPedido bigint NOT NULL,
cdPagamento bigint NOT NULL,
PRIMARY KEY (cdPedido),
 FOREIGN KEY (cdPagamento) REFERENCES pagamento (cdPagamento) ON DELETE NO ACTION ON UPDATE NO ACTION,
 FOREIGN KEY (idCliente) REFERENCES cliente (idCliente) ON DELETE NO ACTION ON UPDATE NO ACTION,
 FOREIGN KEY (idEndereco) REFERENCES endereco (idEndereco) ON DELETE NO ACTION ON UPDATE NO ACTION,
 FOREIGN KEY (idStatusPedido) REFERENCES statuspedido (idStatusPedido) ON DELETE NO ACTION ON UPDATE NO ACTION
);

CREATE TABLE item_pedido (
idProduto bigint NOT NULL,
idPedido bigint NOT NULL,
quantidade int NOT NULL,
comentario varchar(200) DEFAULT NULL,
avaliacao int DEFAULT NULL,
PRIMARY KEY (idProduto,idPedido),
 FOREIGN KEY (idPedido) REFERENCES pedido (cdPedido) ON DELETE NO ACTION ON UPDATE NO ACTION,
 FOREIGN KEY (idProduto) REFERENCES produto (idProduto) ON DELETE NO ACTION ON UPDATE NO ACTION
);

insert into categoria  (descricao) values ('Eletrônicos');
insert into categoria  (descricao) values ('Produtos de Beleza');
insert into categoria  (descricao) values ('Filmes');
insert into categoria  (descricao) values ('Música');
insert into categoria  (descricao) values ('Livros');
insert into categoria  (descricao) values ('Games');
insert into categoria  (descricao) values ('Escritório');

insert into produto(nome, preco, descricao, urlFoto, avaliacaoMedia, idCategoria)
values ('Box Trilogia Jogos Vorazes', 80.00, 'Katniss Everdeen é uma jovem de dezesseis anos que mora no Distrito 12 com a mãe e a irmã. Katniss sustenta sua família caçando ilegalmente na floresta com seu melhor amigo Gale. No dia da colheita, sua irmã mais nova é selecionada para participar dos Jogos Vorazes, mas ela se oferece para ir em seu lugar. Mas até onde ela estará disposta a ir para ser vitoriosa?',
null, 8, 5);
insert into produto(nome, preco, descricao, urlFoto, avaliacaoMedia, idCategoria)
values ('Motorola Novo Moto X', 1349.00, 'A Motorola inova em tecnologia trazendo a 2ª geração do incrível Moto X, um aparelho com uma série de novas tecnologias que já era capaz de antecipar seus desejos e conta agora com mais interação com usuário através da voz.',
null, 7, 1);
insert into produto(nome, preco, descricao, urlFoto, avaliacaoMedia, idCategoria)
values ('Game Grand Theft Auto V - PS4', 148.90, 'O mundo aberto da Rockstar Games que gerou sucesso de crítica chega a uma nova geração, depois da espera finalmente chega o atualizado Grand Theft Auto V! Entre nas vidas de três criminosos muito diferentes, Michael, Franklin e Trevor, enquanto eles arriscam tudo em uma série de assaltos ousados que podem garantir o resto de suas vidas.',
null, 9, 6);
insert into produto(nome, preco, descricao, urlFoto, avaliacaoMedia, idCategoria)
values ('Blu-ray - Guardiões da Galáxia', 49.00, 'Da Marvel, o estúdio que trouxe franquias globais campeãs de bilheteria como Homem de Ferro, Thor, Capitão América e Os Vingadores - The Avengers, chega uma nova equipe, os Guardiões da Galáxia.',
null, 7, 3);
insert into produto(nome, preco, descricao, urlFoto, avaliacaoMedia, idCategoria)
values ('Blu-ray The Rolling Stones - Ladies And Gentlemen', 69.90, '"Ladies And Gentlemen... The Rolling Stones" finalmente chega em Blu-ray. Esta lendária gravação ao vivo do Rolling Stones, filmada em quatro noites no Texas durante a turnê "Exile On Main Street", de 1972, foi lançada nos cinemas para poucas exibições, em 1974, e permaneceu inédita por longo tempo. Agora, restaurada e remasterizada, "Ladies And Gentlemen... The Rolling Stones" faz sua primeira aparição autorizada em Blu-ray.',
null, 8, 4);















