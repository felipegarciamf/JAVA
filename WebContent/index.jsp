<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<body>
Bem vindo ao nosso gerenciador de empresas!<br/>

<c:if test="${usuarioLogado!=null}">
	Usuário logado como: ${usuarioLogado.email}
</c:if>


<form action="novaEmpresa" method="POST">

	<input type="text" name="nome">
	<input type="submit" value="Enviar">
	

</form>

<form action="login" method="post">
	Email: <input type="email" name="email">
	Senha: <input type="password" name="senha">
	
	<input type="submit" value="Enviar">
</form>

<form action="logout" method="post">
	<input type="submit" value="Deslogar"/>
</form>
</body>
</html>