<%-- 
    Document   : notification-details
    Created on : 07/10/2016, 11:15:49
    Author     : RodrigoGuimaraes
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/security/tags"
	prefix="sec"%>

<html lang="pt-BR">

<c:import url="../include/head-cultura.jsp" />

<body>

	<c:import url="../include/navigation.jsp" />

	<!-- Conteudo da pagina vai aqui! -->

	<div class="intro-header container-fluid">

		<div class="title">
			<h3>-</h3>
		</div>
		
		<div class="title">
			<h1>${notification.title}</h1>
		</div>


		<div class="row">
                    <div class="container">
                        <div class="list-group">
                            <a class="list-group-item">
                                <h3 class="list-group-item-heading">${notification.title}</h3>
                                <p class="list-group-item-text">${notification.brief}</p>
                                <p class="list-group-item-text">${notification.content}</p>
                                <p class="list-group-item-text">${notification.date}</p>                 
                            </a>
                        </div>
                    </div>
		</div>
		<!-- fim da linha principal -->



	</div>
	<!-- fim container fluid -->

	<!-- Fim do espaço para o conteudo da página -->

	<c:import url="../include/footer.jsp" />

</body>

</html>

