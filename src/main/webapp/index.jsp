<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" %>
<!DOCTYPE html>
<html lang="en" ng-app>
<head>
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
    <meta charset="utf-8">
    <title>Loja APD3</title>
    <script data-require="angular.js@*" data-semver="1.2.13"
            src="http://code.angularjs.org/1.2.13/angular.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.0.8/angular.min.js"></script>
    <script type="text/javascript" src="js/app.js"></script>
    <script src="js/jquery-2.0.0.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script src="js/app.js"></script>
    <meta name="generator" content="Bootply"/>
    <meta name="viewport"
          content="width=device-width, initial-scale=1, maximum-scale=1">
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <!--[if lt IE 9]>
    <script src="//html5shim.googlecode.com/svn/trunk/html5.js"></script>
    <![endif]-->
    <link href="css/styles.css" rel="stylesheet">
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
                <li><a href="/loja/index.jsp"><span class="glyphicon glyphicon-home"></span> Home</a></li>
                <li><a href="/loja/cliente.jsp"><span class="glyphicon glyphicon-user"></span> Cadastro</a></li>
                <li><a href="/loja/sobre.jsp"><span class="glyphicon glyphicon-info-sign"></span> Sobre</a></li>
            </ul>
        </div>
        <!--/.nav-collapse -->
    </div>
</div>

<div class="container">
    <form id="formProdutos">
        <div ng-controller="produtos">
            <div class="row">
                <div class="col-md-30">
                    <table id="tableData" class="table table-striped">
                        <thead>
                        <tr>
                            <th>ID</th>
                            <th>Nome</th>
                            <th>Preço</th>
                            <th>Categoria</th>
                            <th>Foto</th>
                            <th>Descrição</th>
                            <th>Ações</th>
                        </tr>
                        </thead>
                        <tbody>
                        <tr ng-repeat="produto in produtos">
                            <td>{{produto.id}}<input type="hidden" value="{{produto.id}}"/></td>
                            <td>{{produto.nome}}</td>
                            <td>R$ {{produto.precoStr}}</td>
                            <td>{{produto.categoria.descricao}}</td>
                            <td><img src="{{produto.urlFoto}}" width="100" height="100" alt="teste"></td>
                            <td>{{produto.descricao}}</td>
                            <td>
                            <div class="btn-group btn-group-vertical">
                                <button id="btnCompra" type="button" class="btn btn-success" onclick="comprar({{produto.id}},{{produto.preco}});">
                                    <span class="glyphicon glyphicon-shopping-cart"></span> Adicionar ao Carrinho
                                </button>
                                
                                <a id="btnDetalhe" type="button" class="btn btn-primary" href="/loja/produto.jsp?idProduto={{produto.id}}">
                                    <span class="glyphicon glyphicon-plus">    </span> Ver detalhes
                                </a>
                                </div>
                            </td>
                        </tr>
                        </tbody>
                    </table>
                    <div id="botoes">
                        <button type="submit" class="btn btn-success" onclick="fecharPedido()"> 
                        <span class="glyphicon glyphicon-send"></span> &nbsp Fechar Pedido
                        </button>
                    </div>
                </div>
            </div>
        </div>
    </form>
</div>
<!-- /.container -->
<!-- script references --></body>
</html>