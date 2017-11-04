<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta charset="UTF-8">
</head>
<body>
	Resultado da busca</br>
	 <ul>
	<c:forEach var="empresa" items="${empresas}">
	    <li>${empresa.getId()}: ${empresa.getNome()}</li>
	</c:forEach>
	</ul>
	

</body>
</html>