<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

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

 <!-- Custom CSS -->
<link href="${pageContext.request.contextPath}/resources/css/landing-page-cultura.css" rel="stylesheet">

<!-- Custom Fonts -->
<link href="${pageContext.request.contextPath}/resources/css/font-awesome.min.css" rel="stylesheet" type="text/css">
<link href="http://fonts.googleapis.com/css?family=Lato:300,400,700,300italic,400italic,700italic" rel="stylesheet" type="text/css">

<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
<!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>


<body>

    <!-- Navigation -->
    <nav class="navbar navbar-default navbar-fixed-top topnav" role="navigation">
        <div class="container topnav">
            <!-- Brand and toggle get grouped for better mobile display -->
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand topnav" href="#" >Ismart | Ismart Online</a>
            </div>
            <!-- Collect the nav links, forms, and other content for toggling -->
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <ul class="nav navbar-nav navbar-right">
                    <li>
                        <a href="#about">Sobre</a>
                    </li>
                    <li>
                        <a href="#about">FAQ</a>
                    </li>
                    <li>
                        <a href="#contact">Contato</a>
                    </li>
                </ul>
            </div>
            <!-- /.navbar-collapse -->
        </div>
        <!-- /.container -->
    </nav>
	<!-- Navigation End -->
	
	
	
	<!-- Conteudo da pagina vai aqui! -->
	
	<div class="container-fluid intro-header">
	
		<div class="title">
			<h3>Módulo de Cultura</h3>
		</div>
		<div class="title">
			<h5>Aqui você vai aprender sobre a cultura e como ela vai te ajudar a Sonhar Grande e realizar cada vez mais!!</h5>
		</div>
		<div class="row">
			<div class="col-sm-3">
				<div class="row" id="video">
					<div class="title">
						<h3></h3>
					</div>
					<!-- menu de categorias -->
					<div class="list-group ">
						<a href="#" class="list-group-item ">Vídeo 1</a>
						<a href="#" class="list-group-item ">Vídeo 2</a>
						<a href="#" class="list-group-item ">Vídeo 3</a>
					</div>
				</div>
				<div class="row" id="acoes">
						<div class="title">
							<h3>Ações</h3>
						</div>
						<!-- menu de categorias -->
						<div class="list-group ">
							<a href="#" class="list-group-item ">Entrega</a>
							<a href="#" class="list-group-item ">Resultado</a>
							<a href="#" class="list-group-item ">Fórum</a>
						</div>
				</div>
			</div>
			
			<!-- bloco conteudo -->
			<div class="col-sm-9">
				<!-- novidades -->
				<div class="row" id="novidades">
					<div class="col-sm-12 text-center">
						<h3>Missão 8</h3>
					</div>
				</div>
				
				<div class="row" >
					<div class="col-sm-9 text-center wow fadeInUp content-center" data-wow-delay=".2s" >
						<div class="thumbnail">
							<figure>
								<a href="https://vimeopro.com/user25854406/modulo-de-cultura-8-ano/video/124248088">
									<img src="${pageContext.request.contextPath}/resources/img/nova-vida.jpg" class="img-responsive center-block" >
								</a>
							</figure>
							<div class="caption">
								<h4>Nova Vida - Outubro 2015</h4>
								<p>Missão 8</p>
								<div class="btn-group">
									<a href="#" class="btn btn-primary">
										<< Anterior
									</a>
									&nbsp;
									<a href="#" class="btn btn-primary">
										Próximo >>
									</a>
								</div>
							</div>
						</div>
				</div>
					<!-- e um produto -->
					
					
				</div><!-- fim dos mais vendidos -->
			</div><!-- fim do bloco conteudo -->
			
		</div> <!-- fim da linha principal -->

	</div> <!-- fim container fluid -->
	
	<!-- Fim do espaço para o conteudo da página -->


    <!-- Footer -->
    <footer>
        <div class="container">
            <div class="row">
                <div class="col-lg-12">
                    <ul class="list-inline">
                        <li>
                            <a href="#">Home</a>
                        </li>
                        <li class="footer-menu-divider">&sdot;</li>
                        <li>
                            <a href="#about">Sobre</a>
                        </li>
                        <li class="footer-menu-divider">&sdot;</li>
                        <li>
                            <a href="#services">FAQ</a>
                        </li>
                        <li class="footer-menu-divider">&sdot;</li>
                        <li>
                            <a href="#contact">Contato</a>
                        </li>
                    </ul>
                    <p class="copyright text-muted small">Copyright &copy; Ismart Online 2016. Todos os direitos reservados.</p>
                </div>
            </div>
        </div>
    </footer>

    <!-- jQuery -->
    <script src="${pageContext.request.contextPath}/resources/js/jquery.js"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="${pageContext.request.contextPath}/resources/js/bootstrap.min.js"></script>

</body>

</html>
