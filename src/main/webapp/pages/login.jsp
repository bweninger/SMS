<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Login</title>
    <script src="https://code.jquery.com/jquery-2.1.4.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>

<div id="login-box">

    <h2>Login</h2>

    <c:if test="${not empty error}">
        <div class="error">${error}</div>
    </c:if>
    <c:url value="/j_spring_security_check" var="loginUrl" />
    <form name='loginForm'
          action="${loginUrl}" method='POST' role="FORM">
        <table>
            <tr>
                <td>Usuario:</td>
                <td><input type='text' name='user' value=''></td>
            </tr>
            <tr>
                <td>Senha:</td>
                <td><input type='password' name='pass'/></td>
            </tr>
            <tr>
                <td colspan='2'>
                    <input name="submit" type="submit" value="Enviar"/>
                </td>
            </tr>
        </table>
        <input type="hidden"
               name="${_csrf.parameterName}" value="${_csrf.token}" />
    </form>
</div>
</body>
</html>