<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/security/tags"
	prefix="sec"%>

<html lang="pt-BR">

<c:import url="../include/head-cultura.jsp" />

<script src="${pageContext.request.contextPath}/resources/js/tinymce/tinymce.min.js"></script>
<script>
    tinymce.init({
        selector: '#contentArea',
        plugins: 'image, preview, imagetools, anchor',
        language: 'pt_BR'
    });
  </script>

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
                                            <h3>Notificação - Cadastro</h3>
                                    </div>
                                    <div class="notification_form">
                                        <form:form action="${pageContext.request.contextPath}/admin/notificacao/cadastro/submit"
                                                   method="post" commandName="notificationForm">

                                            <div class="form-group">
                                                <label for="title">Título</label>
                                                <form:input path="title" class="form-control" />
                                                <form:errors path="title" />
                                            </div>
                                            
                                            <div class="form-group">
                                                <label for="brief">Resumo</label>
                                                <form:textarea path="brief" class="form-control" rows="4" />
                                                <form:errors path="brief" />
                                            </div>
                                            
                                            <div class="form-group">
                                                <label for="content">Conteúdo</label>
                                                <form:textarea path="content" class="form-control" id="contentArea" rows="20" />
                                                <form:errors path="content" />
                                            </div>
                                            
                                            <div class="form-group checkboxes">
                                                <label for="units">Unidade(s)</label>
                                                <div>
                                                    <form:checkboxes path="units" class="form-control" items="${unitsList}" />
                                                </div>
                                            </div>
                                            
                                            <div class="form-group checkboxes">
                                                <label for="years">Ano(s)</label>
                                                <div>
                                                    <span>
                                                        <form:checkbox value="8" class="form-control" path="years" id="years8" />
                                                        <label for="years8">8º ano</label>
                                                    </span>
                                                    <span>
                                                        <form:checkbox value="9" class="form-control" path="years" id="years9" />
                                                        <label for="years9">9º ano</label>
                                                    </span>
                                                    <span>
                                                        <form:checkbox value="1" class="form-control" path="years" id="years1" />
                                                        <label for="years1">1º ano</label>
                                                    </span>
                                                </div>
                                                <form:errors path="content" />
                                            </div>

                                            <label for="submitButton"> <span
                                                    class="btn btn-primary btn-block">Salvar</span></label>
                                            <input id="submitButton" name="submit" type="submit"
                                                    value="Salvar" style="visibility: hidden; position: absolute;">

                                        </form:form>
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
