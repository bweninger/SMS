<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>APD3 Loja - Detalhe do Produto</title>
    <script src="js/jquery-2.0.0.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script src="js/produto.js"></script>
    <link rel="stylesheet" href="css/bootstrap.min.css"/>
    <link rel="stylesheet" href="css/styles.css"/>
</head>
<body>
<div class="navbar navbar-default navbar-static-top">
    <div class="container">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse"
                    data-target=".navbar-collapse">
                <span class="icon-bar"></span> <span class="icon-bar"></span> <span
                    class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="#">Loja APD3</a>
        </div>
           <div class="collapse navbar-collapse">
            <ul class="nav navbar-nav">
                <li><a href="/loja/"><span class="glyphicon glyphicon-home"></span> Home</a></li>
                <li><a href="/loja/cliente.jsp"><span class="glyphicon glyphicon-user"></span> Cadastro</a></li>
                <li><a href="/loja/sobre.jsp"><span class="glyphicon glyphicon-info-sign"></span> Sobre</a></li>
            </ul>
        </div>
        <!--/.nav-collapse -->
    </div>
</div>
<div class="container">
    <div class="center-block text-center">
        <h2>APD3 Loja</h2>
    </div>
    <div class="col-md-12">
        <hr/>
        <div class="col-sm-4" id="imagemProduto">
        </div>
        <div class="col-sm-8" id="detalhesProduto">
            <div>
                <h2 id="tituloProduto"></h2>
                <p id="descricaoProduto"></p>
                <input type="hidden" id="precoProduto" />
            </div>
            <div id="botoes">
                <a id="btnAddCart" class="btn btn-primary"><span class="glyphicon glyphicon-shopping-cart"></span>&nbsp Adicionar ao Carrinho</a>
                <a class="btn btn-danger" onclick="history.back()"><span class="glyphicon glyphicon-chevron-left"></span>&nbsp Voltar</a>
            </div>
        </div>
    </div>
</div>
</body>
</html>
