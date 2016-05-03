<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html lang="pt-BR">

<c:import url="../../../../include/head-cultura.jsp" />

<body>

	<c:import url="../../../../include/navigation.jsp" />

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
						<a href="<c:url value='/cultura/missao-4/ano-1' />"
							class="list-group-item ">Como iniciar um projeto | Oi Seiiti Arata 01</a>
							<a href="<c:url value='/cultura/missao-4/ano-1/video-2' />"
							class="list-group-item ">Richard St. John: Os 8 segredos para o sucesso</a>
							<a href="<c:url value='/cultura/missao-4/ano-1/video-3' />"
							class="list-group-item ">How To Change The World (a work in progress) | Kid President</a>
					</div>
				</div>
				<div class="row" id="acoes">
					<div class="title">
						<h3>Ações</h3>
					</div>
					<!-- menu de categorias -->
					<div class="list-group ">
						<a href="<c:url value='/cultura/missao-4/ano-1/entrega' />" class="list-group-item ">Entrega</a>
						 <a href="<c:url value='/cultura/missao/resultado' />"	class="list-group-item ">Resultado</a> 
							<a href="#"
							class="list-group-item ">Fórum</a>
					</div>
				</div>
			</div>

			<!-- bloco conteudo -->
			<div class="col-sm-7">
				<!-- novidades -->
				<div class="row" id="novidades">
					<div class="col-sm-7 text-center">
						<h3>Missão 4 - Entrega!!</h3>
					</div>
				</div>

				<div class="row">
					<div class="col-lg-7 text-center wow fadeInUp content-center"
						data-wow-delay=".2s">
						<div class="thumbnail">
							
							<form:form action="${pageContext.request.contextPath}/entrega-missao-4/submit" method="post" commandName="deliver" enctype="multipart/form-data">
								
									<p style="color: black" id="fileName"></p>
								
									<label for="delivery"> <span class="btn btn-success btn-block">Selecione o arquivo</span></label>
									<input type="file" name="delivery" id="delivery" 	style="visibility: hidden; position: absolute;"/>
									
									<form:errors path="deliveryPath"/> 
								
									<label for="submitButton"> <span class="btn btn-primary btn-block">Salvar</span></label>
									<input id="submitButton" name="submit" type="submit" value="Salvar" style="visibility: hidden; position: absolute;">
									
							</form:form>

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


	<c:import url="../../../../include/footer.jsp" />
	
	<script type="text/javascript">
	
	function updated(event) {
	    var count = 0;
	    console.log(event.path);
	    for ( i = 0; i < event.path.length; i++ ) {
	        var tmpObj = event.path[i];
	        
	        if ( tmpObj.value !== undefined ) {
	        	
	        	$('#fileName').html(tmpObj.value.substr(12));
	        	
	        }
	    }
	    
	}

	var el = document.getElementById('delivery');
	
	el.onchange = updated;
	
	</script>

</body>

</html>
