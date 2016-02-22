<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html lang="pt-BR">
	<c:import url="../include/head.jsp" />


	<body>
	
	   <c:import url="../include/navigation.jsp" />
		
		<!-- Conteudo da pagina vai aqui! -->
		
		<div class="container-fluid intro-header">
			<div class="title">
				<h3></h3>
			</div>
			<div class="title">
				<h5>AQUI VOCÊ VAI APRENDER bla bla bla bla</h5>
			</div>
			
			<div class="row">
				<div class="col-sm-3">
					<div class="title">
						<h3>Menu</h3>
					</div>
					<!-- menu de categorias -->
					<div class="list-group ">
						<a href="#" class="list-group-item ">Planos de Estudo</a>
						<a href="#" class="list-group-item ">Outras Aulas</a>
						<a href="#" class="list-group-item ">Desempenho</a>
					</div>
				</div>
				<!-- bloco conteudo -->
				<div class="col-sm-9">
					<!-- novidades -->
					<div class="row" id="novidades">
						<div class="col-sm-12 text-center">
							<h3>Aulas</h3>
						</div>
					</div>
					<div class="row">
						<div class="col-sm-4 text-center wow fadeInUp" data-wow-delay=".2s">
							<div class="thumbnail">
								<div class="caption">
									<h4>História</h4>
									<div class="btn-group">
										<a href="#" class="btn btn-primary">
											Ver Aulas
										</a>
									</div>
								</div>
							</div>
						</div>
						<!-- e um produto -->
						<div class="col-sm-4 text-center wow fadeInUp" data-wow-delay=".2s">
							<div class="thumbnail">
								<div class="caption">
									<h4>Português</h4>
									<div class="btn-group">
										<a href="#" class="btn btn-primary">
											Ver Aulas
										</a>
									</div>
								</div>
							</div>
						</div>
						<div class="col-sm-4 text-center wow fadeInUp" data-wow-delay=".2s">
							<div class="thumbnail">
								<div class="caption">
									<h4>Matemática</h4>
									<div class="btn-group">
										<a href="#" class="btn btn-primary">
											Ver Aulas
										</a>
									</div>
								</div>
							</div>
						</div>
						
					</div><!-- fim dos mais vendidos -->
				</div><!-- fim do bloco conteudo -->
			</div> <!-- fim da linha principal -->
	
		</div> <!-- fim container fluid -->
		
		<!-- Fim do espaço para o conteudo da página -->
	
	
	   	<c:import url="../include/footer.jsp" />
	
	</body>

</html>
