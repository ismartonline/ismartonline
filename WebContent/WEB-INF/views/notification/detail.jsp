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
			<h3>&nbsp;</h3>
		</div>

		<div class="row">
                    <div class="container">
                         <div class="thumbnail">
                            <div class="caption">
                                <div class="row">    
                                    <h3 class="col-xs-4 col-xs-offset-4">${notification.title}</h3>
                                    <h4 class="col-xs-4 text-right" style="font-size:15px; padding-right: 20px; font-weight: normal; color: #888;"><span class="glyphicon glyphicon-time" aria-hidden="true"></span> ${notification.formattedDate}</h4>
                                    <p class="col-xs-12">${notification.brief}</p>
                                    <div class="col-xs-10 col-xs-offset-1" style="font-weight: normal;">${notification.content}</div>
                                </div>
                            </div>
                            <div class="btn-ver-mensagens-detail">
                                <a href="<c:url value='/mensagens'/>">&#8592; Ver outras mensagens</a>
                            </div>
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

