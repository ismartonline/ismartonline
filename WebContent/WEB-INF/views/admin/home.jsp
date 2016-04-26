
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
					<h3>Painel de Controle</h3>
				</div>
				
				
			
				<div class="row">
				<div class="col-sm-3">
					
					<div class="row" id="acoes">
							<div class="title">
								<h3>Ações</h3>
							</div>
							<!-- menu de categorias -->
							<div class="list-group ">
								<a href="<c:url value='/admin/avaliacao/ano-8' />" class="list-group-item ">Avaliar Missões 8 ano</a>
								<a href="<c:url value='/admin/avaliacao/ano-9' />" class="list-group-item ">Avaliar Missões 9 ano</a>
								<a href="<c:url value='/admin/avaliacao/ano-1' />" class="list-group-item ">Avaliar Missões 1 ano</a>
								
							</div>
					</div>
				</div>
				
				<!-- bloco conteudo -->
				<div class="col-sm-9">
					
				</div><!-- fim do bloco conteudo -->
				
			</div> <!-- fim da linha principal -->
				
			</div>
					
		</div>

	</div> <!-- fim container fluid -->
	
	<!-- Fim do espaço para o conteudo da página -->

    <c:import url="../include/footer.jsp" />

</body>

</html>
