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
                                                    <a href="<c:url value='/cultura/missao-7/ano-1' />"
                                                            class="list-group-item ">Como criar uma boa apresentação</a>
                                                    <a href="<c:url value='/cultura/missao-7/ano-1/video-2' />"
                                                    class="list-group-item ">Como acontece um processo de criação</a>
                                                    <a href="<c:url value='/cultura/missao-7/ano-1/video-3' />"
                                                    class="list-group-item ">O medo de falar em público</a>
                                                </div>
					</div>
					<div class="row" id="acoes">
							<div class="title">
								<h3>Ações</h3>
							</div>
							<!-- menu de categorias -->
							<div class="list-group ">
								<a href="<c:url value='/cultura/missao-7/ano-1/entrega' />" class="list-group-item ">Entrega</a>
								<a href="<c:url value='/cultura/missao/resultado' />"	class="list-group-item ">Resultado</a>
								<a href="#" class="list-group-item ">Fórum</a>
							</div>
					</div>
				</div>
				
				<!-- bloco conteudo -->
				<div class="col-sm-7">
					<!-- novidades -->
					<div class="row" id="novidades">
						<div class="col-sm-12 text-center">
							<h3>Missão 7</h3>
						</div>
					</div>
					
					<div class="row" >
						<div class="col-sm-11 text-center wow fadeInUp content-center" data-wow-delay=".2s" >
							<div class="thumbnail">
								<iframe width="560" height="315" src="https://www.youtube.com/embed/C9kppplVr1Y" frameborder="0" allowfullscreen></iframe>
								<div class="caption">
									<h4>O medo de falar em público</h4>
									<p>Missão 7</p>
									<div class="btn-group">
										
										<a href="<c:url value='/cultura/missao-7/ano-1/video-2' />" class="btn btn-primary">
											<< Anterior
										</a>
										
									</div>
									<div class="btn-group">
                                                                                <a href="${pageContext.request.contextPath}/resources/doc/missao7_1em.pdf"
                                                                                   class="btn btn-primary">
                                                                                    <img src="${pageContext.request.contextPath}/resources/img/pdf-icon.png"
                                                                                         height="20px"
                                                                                         width="20px" />
                                                                                </a> 
                                                                                <a href="${pageContext.request.contextPath}/resources/doc/missao7_1em.docx"
                                                                                   class="btn btn-primary">
                                                                                    <img src="${pageContext.request.contextPath}/resources/img/word-icon.jpg"
                                                                                         height="20px"
                                                                                         width="20px" />
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
	
	
	   <c:import url="../../../include/footer.jsp" />  
	
	</body>

</html>
