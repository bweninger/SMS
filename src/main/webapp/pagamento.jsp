<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta http-equiv="content-type" content="text/html; charset=UTF-8">
<meta charset="utf-8">
<title>Loja APD3</title>
<script type="text/javascript" src="js/app.js"></script>
<script src="js/jquery-2.0.0.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/pagamento.js"></script>
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
					<li><a href="/loja/"><span
							class="glyphicon glyphicon-home"></span> Home</a></li>
					<li><a href="/loja/cliente.jsp"><span
							class="glyphicon glyphicon-user"></span> Cadastro</a></li>
					<li><a href="/loja/sobre.jsp"><span
							class="glyphicon glyphicon-info-sign"></span> Sobre</a></li>
				</ul>
			</div>
			<!--/.nav-collapse -->
		</div>
	</div>

	<div class="container">
		<form id="formCliente" class="form-horizontal">
			<div class="form-group">

				<label class="col-md-4 control-label" ></label>

				<div class="col-md-4">
					<form class="form-horizontal">
						<fieldset>

							<!-- Form Name -->
							<legend>Selecione forma de pagamento</legend>

							<!-- Multiple Radios -->
							<div class="control-group">
								
								<div class="controls">
									<label class="radio" for="pagamento-0"> <input
										name="pagamento" id="pagamento-0" type="radio"
										checked="checked" value="1"> Boleto
									</label> <label class="radio" for="pagamento-1"> <input
										name="pagamento" id="pagamento-1" type="radio"
										value="2"> Débito online
									</label>
								</div>
							</div>

							<!-- Button -->
							<div class="control-group">
								<label class="control-label" for="btn-selecionar"></label>
								<div class="controls">
									<button type="button" name="Selecionar" class="btn btn-info" id="btn-selecionar">Selecionar</button>
								</div>
							</div>

						</fieldset>
					</form>

				</div>
			</div>
			<br />
		</form>
	</div>
	<!-- /.container -->
	<!-- script references -->
</body>
</html>