<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html lang="pt-BR">

	<c:import url="include/head.jsp" />
	
	<!-- Custom CSS -->
		<link href="${pageContext.request.contextPath}/resources/css/landing-page.css" rel="stylesheet">
	
	<body>
		
		<c:import url="include/navigation.jsp" />
	    <!-- Header -->
	    <div class="intro-header">
	        <div class="container">
	
	            <div class="row">
	                <div class="col-lg-12">
	                    <div class="intro-message">
	                        <h1>Ismart Online</h1>
	                        <h3>Selecione o Módulo</h3>
	                        <hr class="intro-divider">
	                        <ul class="list-inline intro-social-buttons">
	                            <li>
	                                <a href="<c:url value='/cultura'/>" class="btn btn-default btn-lg"><i class="fa fa-twitter fa-fw"></i> <span class="network-name">Cultura</span></a>
	                            </li>
	                           
	                            <li>
	                                <a href="<c:url value='/materias'/>" class="btn btn-default btn-lg"><i class="fa fa-linkedin fa-fw"></i> <span class="network-name">Matérias</span></a>
	                            </li>
	                            
	                            <li>
	                                <a href="<c:url value='/desempenho'/>" class="btn btn-default btn-lg"><i class="fa fa-linkedin fa-fw"></i> <span class="network-name">Desempenho</span></a>
	                            </li>
	                            
	                            <li>
	                                <a href="<c:url value='/interacao'/>" class="btn btn-default btn-lg"><i class="fa fa-linkedin fa-fw"></i> <span class="network-name">Interação</span></a>
	                            </li>
	                        </ul>
	                    </div>
	                </div>
	            </div>
	
	        </div>
	        <!-- /.container -->
	
	    </div>
	    <!-- /.intro-header -->
	
	   <c:import url="include/footer.jsp" />
	
	</body>

</html>
