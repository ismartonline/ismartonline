<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html lang="pt-BR">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
<meta name="description" content="">
<meta name="author" content="juliocvidal">
<link rel="icon"
	href="${pageContext.request.contextPath}/resources/img/favicon.ico">

<title>Ismart | Ismart Online</title>

<!-- Bootstrap core CSS -->
<link
	href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css"
	rel="stylesheet">

<!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
<link
	href="${pageContext.request.contextPath}/resources/assets/css/ie10-viewport-bug-workaround.css"
	rel="stylesheet">

<!-- Custom styles for this template -->
<link href="${pageContext.request.contextPath}/resources/css/signin.css"
	rel="stylesheet">


<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
<!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>

<body>

	<div class="container">

		<form:form class="form-signin" action="${pageContext.request.contextPath}/cadastro/novo">
			<h2 class="form-signin-heading">Dados do Aluno</h2>
			
			<label for="inputName" class="sr-only">Nome</label>
			<input type="text" id="inputName" name="name"
				class="form-control" placeholder="Nome" autofocus>
			
			<label for="inputEmail" class="sr-only">Email</label>
			<input type="text" id="inputEmail" name="username"
				class="form-control" placeholder="Email" autofocus>
				
			<label for="inputPassword" class="sr-only">Senha Temporária</label>
			<input type="password" id="inputPassword" name="password"
				class="form-control" placeholder="Senha Temporária" required>
				
			<label for="inputPasswordConfirm" class="sr-only">Confirme a Senha Temporária</label>
			<input type="password" id="inputPasswordConfirm" name="passwordConfirm"
				class="form-control" placeholder="Confirme a Senha Temporária" required>
				
			
			<input class="btn btn-lg btn-primary btn-block" name="submit"
				type="submit" value="Salvar">
				
			
		</form:form>
		

	</div>
	<!-- /container -->


	<!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
	<script
		src="${pageContext.request.contextPath}/resources/assets/js/ie10-viewport-bug-workaround.js"></script>

	<script
		src="${pageContext.request.contextPath}/resources/js/required.js"></script>


	<script type="text/javascript">
		InvalidInputHelper(document.getElementById("inputEmail"), {
			defaultText : "Por favor, informe seu email.",

			emptyText : "Por favor, informe seu email.",

			invalidText : function(input) {
				return 'O email "' + input.value
						+ '" é inválido. O email deve ter uma "@".';
			}
		});
		InvalidInputHelper(document.getElementById("inputPassword"), {
			defaultText : "Por favor, informe a senha.",

			emptyText : "Por favor, informe a senha",

		});
	</script>
</body>
</html>
