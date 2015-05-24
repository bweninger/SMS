<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
    <meta charset="utf-8">
    <title>Loja APD3</title>
    <script src="js/jquery-2.0.0.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script src="js/endereco.js"></script>
    <link href="css/bootstrap.min.css" rel="stylesheet">
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
                <li><a href="/loja/cliente.jsp">Cadastro Cliente</a></li>
                <li><a href="#contact">Sobre</a></li>
            </ul>
        </div>
        <!--/.nav-collapse -->
    </div>
</div>

<div class="container">
    <form class="form-horizontal">
        <input type="hidden" id="idCliente"/>

        <div class="col-md-12">
            <table id="tabelaEnderecos" class="table">
                <thead>
                    <tr>
                        <th></th>
                        <th>Logradouro</th>
                        <th>Número</th>
                        <th>Complemento</th>
                        <th>CEP</th>
                    </tr>
                </thead>
                <tbody>
                </tbody>
            </table>
            <button class="btn btn-primary">Selecionar</button>
            <button class="btn btn-primary" data-toggle="collapse" data-target="#toggleNovo">Novo Endereço</button>
            <br/>
        </div>
        <div id="toggleNovo" class="collapse">
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
                        <button id="btnEndereco" name="btnEndereco" class="btn btn-primary"
                                onclick="incluirEndereco()  ">Concluir Pedido
                        </button>
                    </div>
                </div>
            </fieldset>
        </div>
    </form>
</div>
<!-- /.container -->
<!-- script references --></body>
</html>