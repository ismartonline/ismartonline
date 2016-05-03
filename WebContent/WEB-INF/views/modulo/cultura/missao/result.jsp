
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/security/tags"
	prefix="sec"%>

<html lang="pt-BR">

<c:import url="../../../include/head-cultura.jsp" />

<body>

<script type="text/javascript">
             function avaliaMissao(year, missionNumber, id, grade, ismartId) {
                 $.post("${pageContext.request.contextPath}/evaluate", {'year': year, 'missionNumber': missionNumber, 'id' : id, 'grade' : grade}, function() {
                	 $('#check-' + ismartId).show();
		}); }
</script>

	<c:import url="../../../include/navigation.jsp" />

	<!-- Conteudo da pagina vai aqui! -->

	<div class="intro-header container-fluid">

		<div class="title">
			<h3>-</h3>
		</div>
		
		<div class="title">
			<h1>Painel de Controle</h1>
		</div>


		<div class="row" >
			
			<div class="col-sm-12" align="center">
				
					<a href="${pageContext.request.contextPath}/resources/doc/missao_pontuacao.pdf" target="_blank" class="btn btn-primary">
						Entenda a Pontuação
						<img src="${pageContext.request.contextPath}/resources/img/pdf-icon.png" height="20px" width="20px"/>
					</a>
			</div>
			
			<!-- bloco conteudo -->
			<div class="col-sm-12" align="center">
				<div class="row">
						<div class="wow fadeInUp" data-wow-delay=".2s">
							<div class="thumbnail" style="">
							<table>
								<tr>
									<td><label style="color: black; float: left; padding: 10px">Aluno </label></td>
									<td><label style="color: black;  float: left; padding: 10px">Arquivo </label></td>
									<%-- <td><label style="color: black;  float: left; padding: 10px">Entregue em</label></td>--%>
									<td><label style="color: black; padding: 10px">Nota</label></td>
								</tr>
								<c:forEach items="${missions}" var="mission">
								
									
									<tr >
											<td>
												<input type="hidden" value="${mission.id}"/>	
												<label  style="padding: 10px; color: gray;" >${mission.user.ismartId} - ${mission.user.name}</label> 
											</td>
											<td>	<a target="_blank" href="${mission.fileLink}"  style="padding: 10px">${mission.fileName}</a> </td>
											<%-- <td>	<label style="padding: 10px; color: gray;">${mission.deliveryDate}</label></td>--%>
											<td>
												<label  style="padding: 10px; color: gray;" >${mission.grade}</label>	
											</td>
												
																	</tr>
								</c:forEach>
							</table>
							<%--	<input class="btn btn-lg btn-primary btn-block" name="submit"
								type="submit" value="Avaliar Todos">  --%>
								
							</div>
						</div>

				</div>
				<!-- fim dos mais vendidos -->
			</div>
			<!-- fim do bloco conteudo -->

		</div>
		<!-- fim da linha principal -->



	</div>
	<!-- fim container fluid -->

	<!-- Fim do espaço para o conteudo da página -->

	<c:import url="../../../include/footer.jsp" />

</body>

</html>
