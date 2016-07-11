<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html lang="pt-BR">

<c:import url="../../../include/head-cultura.jsp" />

<body>

	<c:import url="../../../include/navigation.jsp" />

	<!-- Conteudo da pagina vai aqui! -->

	<div class="container-fluid intro-header">

		<div class="title">
			<h5>Módulo de Cultura</h5>
		</div>

		<div class="title">
			<h3>Módulo de Cultura</h3>
		</div>
		<div class="title">
			<h5>Aqui você vai aprender sobre a cultura e como ela vai te
				ajudar a Sonhar Grande e realizar cada vez mais!!</h5>
		</div>
		<div class="row">
			<div class="col-sm-3">
				<div class="row" id="video">
					<div class="title">
						<h3></h3>
					</div>
					<!-- menu de categorias -->
					<div class="list-group ">
							<a href="<c:url value='/cultura/missao-5/ano-8' />"
							class="list-group-item ">Desafios - A Partida de Xadrez</a>
						<a href="<c:url value='/cultura/missao-5/ano-8/video-2' />"
							class="list-group-item ">Desafios - Depoimento de bolsista Ismart</a> <a
							href="<c:url value='/cultura/missao-5/ano-8/video-3' />"
							class="list-group-item ">Desafios - Missão 5</a>
						</div>
				</div>
				<div class="row" id="acoes">
					<div class="title">
						<h3>Ações</h3>
					</div>
					<!-- menu de categorias -->
					<div class="list-group ">
						<a href="<c:url value='/cultura/missao-5/ano-8/entrega' />"
							class="list-group-item ">Entrega</a> 
							<a href="<c:url value='/cultura/missao/resultado' />"	class="list-group-item ">Resultado</a>
							 <a href="#"
							class="list-group-item ">Fórum</a>
					</div>
				</div>
			</div>

			<!-- bloco conteudo -->
			<div class="col-sm-9">
				<!-- novidades -->
				<div class="row" id="novidades">
					<div class="col-sm-12 text-center">
						<h3>Missão 5</h3>
					</div>
				</div>

				<div class="row">
					<div class="col-sm-9 text-center wow fadeInUp content-center"
						data-wow-delay=".2s">
						<div class="thumbnail">
							<iframe src="https://player.vimeo.com/video/133758171?title=0&byline=0&portrait=0" width="640" height="360" frameborder="0" webkitallowfullscreen mozallowfullscreen allowfullscreen></iframe>
							
							<div class="caption">
								<h4>Desafios - Missão 5</h4>
								<p>Missão 5</p>
								<div class="btn-group">

									<a href="<c:url value='/cultura/missao-5/ano-8/video-2' />"
										class="btn btn-primary"> << Anterior </a>
								</div>
								<div class="btn-group ">
									<a
										href="${pageContext.request.contextPath}/resources/doc/missao5_8.pdf"
										class="btn btn-primary"> <img
										src="${pageContext.request.contextPath}/resources/img/pdf-icon.png"
										height="20px" width="20px" />
									</a>
								</div>
							</div>
						</div>
					</div>
					<!-- e um produto -->


				</div>
				<!-- fim dos mais vendidos -->
			</div>
			<!-- fim do bloco conteudo -->

		</div>
		<!-- fim da linha principal -->

	</div>
	<!-- fim container fluid -->

	<!-- Fim do espaço para o conteudo da página -->


	<c:import url="../../../include/footer.jsp" />

</body>

</html>
