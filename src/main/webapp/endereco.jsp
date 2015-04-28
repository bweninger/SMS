<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
                <li><a href="/loja/index.jsp">Home</a></li>
                <li><a href="/loja/cadastro.jsp">Cadastro Cliente</a></li>
                <li><a href="#contact">Sobre</a></li>
            </ul>
        </div>
        <!--/.nav-collapse -->
    </div>
</div>

<div class="container">
    <form class="form-horizontal">
        <input type="hidden" value="${idCliente}" name="idCliente"/>
        <fieldset>
            <!-- Form Name -->
            <legend>Endereço de entrega</legend>

            <!-- Text input-->
            <div class="form-group">
                <label class="col-md-4 control-label" for="logradouro">Logradouro:</label>

                <div class="col-md-4">
                    <input id="logradouro" name="logradouro" type="text" placeholder="R. dos Bobos"
                           class="form-control input-md">

                </div>
            </div>

            <!-- Text input-->
            <div class="form-group">
                <label class="col-md-4 control-label" for="numero">No.</label>

                <div class="col-md-4">
                    <input id="numero" name="numero" type="text" placeholder="0" class="form-control input-md">

                </div>
            </div>

            <!-- Text input-->
            <div class="form-group">
                <label class="col-md-4 control-label" for="complemento">Complemento</label>

                <div class="col-md-4">
                    <input id="complemento" name="complemento" type="text" placeholder="Casa 2"
                           class="form-control input-md">

                </div>
            </div>

            <!-- Text input-->
            <div class="form-group">
                <label class="col-md-4 control-label" for="cep">CEP</label>

                <div class="col-md-4">
                    <input id="cep" name="cep" type="text" placeholder="12345-140" class="form-control input-md"
                           required="">

                </div>
            </div>

            <!-- Button -->
            <div class="form-group">
                <label class="col-md-4 control-label" for="btnEndereco"></label>

                <div class="col-md-4">
                    <button id="btnEndereco" name="btnEndereco" class="btn btn-primary" onclick="incluirEndereco()  ">Concluir Pedido</button>
                </div>
            </div>

        </fieldset>
    </form>
</div>
<!-- /.container -->
<!-- script references --></body>
</html>