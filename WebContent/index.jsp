<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta charset="UTF-8">
</head>
<body>
	Bem vindo ao nosso gerenciador de empresa!
	<c:if test="${not empty usuarioLogado}">
        </br>Você está logado como ${usuarioLogado.email}<br/>
    </c:if>
	<br />

	<form action="executa" method="post">
		<input type="hidden" name="tarefa" value="NovaEmpresa">
		Nome: <input type="text" name="nome" /><br /> 
		<input type="submit" value="Enviar" />
	</form>
	
	<form action="executa" method="post">
		<input type="hidden" name="tarefa" value="Login">
	    Email: <input type="text" name="email" /><br />
	    Senha: <input type="password" name="senha" /><br />
	    <input type="submit" value="Login" />
	</form>
	
	<form action="executa" method="post">
		<input type="hidden" name="tarefa" value="Logout">
	    <input type="submit" value="Logout" />
	</form>


</body>
</html>