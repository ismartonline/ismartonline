
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/security/tags" prefix="sec"%>

<html lang="pt-BR">

	<c:import url="../include/head-cultura.jsp" />
	
	<body>

	<c:import url="../include/navigation.jsp" />   
	
	<!-- Conteudo da pagina vai aqui! -->
	
	<div class="intro-header">
		<div class="container">
		
           	<div class="intro-message">
           	
				<div class="title">
					<h3>Módulo de Cultura</h3>
				</div>
				
				<div class="title">
					<h5>Aqui você vai aprender sobre a cultura e como ela vai te ajudar a Sonhar Grande e realizar cada vez mais!!</h5>
				</div>
			
			
				<div class="row">
					
					<!-- bloco conteudo -->
					<div class="col-sm-9">
						<!-- novidades -->
						<div class="row" id="novidades">
							<div class="col-sm-12 text-center">
								<h3></h3>
							</div>
						</div>
						<div class="row">
							<div class="col-sm-4 text-center wow fadeInUp" data-wow-delay=".2s">
								<div class="thumbnail">
           						<sec:authentication property="principal" var="user"/>
									
									<div class="caption">
									<%--	<h4>Nova Vida - Outubro 2015</h4>   --%>
										<p>Missão 1</p>
										<div class="btn-group">
										
											<a href="<c:url value='/cultura/missao/ano-${user.ano}'/>" class="btn btn-primary">
												Ir para Missão
											</a>
										</div>
									</div>
								</div>
								</div>
							<!-- e um produto -->
						
							
						</div><!-- fim dos mais vendidos -->
					</div><!-- fim do bloco conteudo -->
				</div> <!-- fim da linha principal -->
				
			</div>
					
		</div>

	</div> <!-- fim container fluid -->
	
	<!-- Fim do espaço para o conteudo da página -->

    <c:import url="../include/footer.jsp" />

</body>

</html>
