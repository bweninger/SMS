<html>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<head>
    <script src="../js/jquery-2.0.0.min.js"></script>
    <script src="../js/bootstrap.min.js"></script>
    <script src="../js/sms.js"></script>
    <link href="../css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<form:form cssClass="form-horizontal" modelAttribute="formulario" action="/sms/traduzir" method="POST">
    <fieldset>
        <div class="container">
            <h3>O objetivo desta aplica&ccedil;&atilde;o &eacute; traduzir uma palavra ou frase para uma sequ&ecirc;ncia
                de caracteres a serem
                pressionados em um teclado n&atilde;o-QWERTY</h3>

            <!-- Form Name -->
            <legend>Teclado num&eacute;rico</legend>

            <!-- Textarea -->
            <div class="form-group">
                <label class="col-md-4 control-label" for="texto">Frase:</label>

                <div class="col-md-4">
                        <form:textarea path="texto" cssclass="form-control" id="texto" name="texto" placeholder="Insira a frase a ser traduzida."></form:textarea>
                </div>
            </div>
            <button type="submit">Traduzir</button>
        </div>
    </fieldset>
</form:form>

</body>
</html>