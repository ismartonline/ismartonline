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
			<h1>Painel de Controle</h1>
		</div>


		<div class="row">
			<div class="col-sm-3">
                            <div class="row" id="acoes">
                                <div class="col-xs-12">
                                    <div class="title">
                                            <h3>Ações</h3>
                                    </div>
                                    <c:import url="admin-menu.jsp" />
                                </div>
                            </div>
			</div>

			<!-- bloco conteudo -->
			<div class="col-sm-9">
                            <div class="row">
                                <div class="col-xs-12">
                                    <div class="title">
                                            <h3>&nbsp;</h3>
                                    </div>
                                    <div class="thumbnail" style="min-height: 200px;">
                                        <div class="col-xs-offset-11 col-xs-1">                                      
                                            <a href="<c:url value='/admin/notificacao/cadastro'/>" class="btn btn-primary">Incluir</a>
                                        </div>
                                        <table class="table table-notifications">
                                            <thead>
                                                <tr>
                                                    <th width="20%">Data</th>
                                                    <th width="30%">Título</th>
                                                    <th>Unidade(s)</th>
                                                    <th>Ano(s)</th>
                                                    <th></th>
                                                </tr>
                                            </thead>
                                            <tbody>
                                                <c:if test="${empty notifications}">
                                                    <tr>
                                                        <td colspan="3">Nenhum registro encontrado</td>
                                                    </tr>
                                                </c:if>
                                                <c:forEach items="${notifications}" var="notification">
                                                    <tr>
                                                        <td>${notification.formattedDate}</td>
                                                        <td>${notification.title}</td>
                                                        <td>
                                                            <c:forEach items="${notification.units}" var="unit" varStatus="status">
                                                                <c:choose>
                                                                    <c:when test="${status.index < (fn:length(notification.units)-1)}">
                                                                        ${unit},
                                                                    </c:when>
                                                                    <c:otherwise>
                                                                        ${unit}
                                                                    </c:otherwise>
                                                                </c:choose>
                                                            </c:forEach>
                                                        </td>
                                                        <td>
                                                            <c:forEach items="${notification.years}" var="year" varStatus="status">
                                                                <c:choose>
                                                                    <c:when test="${status.index < (fn:length(notification.years)-1)}">
                                                                        ${year}º ano,
                                                                    </c:when>
                                                                    <c:otherwise>
                                                                        ${year}º ano
                                                                    </c:otherwise>
                                                                </c:choose>
                                                            </c:forEach>
                                                        </td>
                                                        <td>
                                                            <a href="<c:url value='/admin/notificacao/ver/${notification.id}'/>">Visualizar</a>
                                                        </td>
                                                    </tr>
                                                </c:forEach>
                                            </tbody>
                                        </table>
                                    </div>  
                                </div>  
                            </div>
			</div>
			<!-- fim do bloco conteudo -->

		</div>
		<!-- fim da linha principal -->



	</div>
	<!-- fim container fluid -->

	<!-- Fim do espaço para o conteudo da página -->

	<c:import url="../include/footer.jsp" />

</body>

</html>
