<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/security/tags"
	prefix="sec"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

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
			<h1>Mensagens</h1>
		</div>


		<div class="row">
                    <div class="container">
                    <c:if test="${fn:length(notifications) == 0}">
                        <div class="list-group notification-list-item">
                            <a class="list-group-item">
                            <h3 class="list-group-item-heading">Nenhuma novidade</h3>
                            <p class="list-group-item-text" style="font-weight: normal; font-size: 0.9em;">Você não possui mensagens novas.</p>
                            </a>
                        </div>
                    </c:if>
                        <c:forEach items="${notifications}" var="notification">
                            <div class="list-group notification-list-item">
                                <a href="<c:url value='/mensagens/ver/${notification.id}'/>" class="list-group-item">
                                    <h3 class="list-group-item-heading">${notification.title}</h3>
                                    <p class="list-group-item-text" style="font-weight: normal; font-size: 0.9em;"><span class="glyphicon glyphicon-time" aria-hidden="true"></span> ${notification.formattedDate}</p>
                                    <br/>
                                    <div class="list-group-item-text" style="font-weight: normal; font-size: 1.2em;">
                                        <p>${notification.brief}</p>                                        
                                    </div>
                                </a>
                            </div>
                        </c:forEach>
                    </div>
		</div>
		<!-- fim da linha principal -->



	</div>
	<!-- fim container fluid -->

	<!-- Fim do espaço para o conteudo da página -->

	<c:import url="../include/footer.jsp" />

</body>

</html>
