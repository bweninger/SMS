<html>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<head>
    <script src="https://code.jquery.com/jquery-2.1.4.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<form:form cssClass="form-horizontal" modelAttribute="formulario" action="/case/sms/traduzir" method="POST">
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
                        <form:textarea  maxlength="256" rows="10" cols="60" path="texto" cssclass="form-control" id="texto" name="texto" placeholder="Insira a frase a ser traduzida."></form:textarea>
                </div>
            </div>
            <button class="btn btn-primary" type="submit">Traduzir</button>
        </div>
    </fieldset>
    <br/>
        <div id="result" class="col-md-10">
            <c:if test="${formulario.resultado != null}">
            <h3>
                Seu resultado &eacute; ${formulario.resultado}
            </h3>
            </c:if>
        </div>
</form:form>

</body>
</html>