
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

<script type="text/javascript">
             function avaliaMissao(year, missionNumber, id, grade, deliveryOut, deliveryIn, lateDelivery, videoNoiseless, videoTimeOk, assayCharsRespect, assayParagraphsDivision, audioNoiseless, audioClearTalk, sheetAndReportFormatting, sheetInfoOrganization, ismartId) {
                 $.post("${pageContext.request.contextPath}/evaluate", 
                		 {'year': year, 
                	 	  'missionNumber': missionNumber, 
                	 	  'id' : id, 
                	 	  'grade' : grade,
                	 	  'deliveryOut' : deliveryOut, 
						  'deliveryIn' : deliveryIn,
						  'lateDelivery' : lateDelivery,
						   'videoNoiseless' : videoNoiseless,
							'videoTimeOk' : videoTimeOk,
             				'assayCharsRespect' : assayCharsRespect, 
							'assayParagraphsDivision' : assayParagraphsDivision, 
							'audioNoiseless' : audioNoiseless, 
							'audioClearTalk' : audioClearTalk,
             				'sheetAndReportFormatting' : sheetAndReportFormatting, 
							'sheetInfoOrganization' : sheetInfoOrganization
                	 	  }, 
                	 	  function() {
		                	 $('#check-' + ismartId).show();
							}); 
                 }
             
             function atualizaPontuacao(ismartId, valor, checked) {
            	 
            	 if ($('#updateGrade')[0].checked){
	            		var val = parseFloat( $('#grade-'+ ismartId).val());
	             	 	console.log(checked);
	             	 	
	             	 	if (isNaN(val)) val = 0;
	             	 	
	             	 	if(checked){
	             	 		val += valor;
	             	 	} else {
	             	 		val -= valor;
	             	 	}
	             	 	
	             	 	$('#grade-'+ ismartId).val(val); 
            	 	}
            	 	
                 }
</script>

	<c:import url="../include/navigation.jsp" />

	<!-- Conteudo da pagina vai aqui! -->

	<div class="intro-header container-fluid">

		<div class="title">
			<h3>-</h3>
		</div>
		
		<div class="title">
			<h1 style="color: black">Painel de Controle</h1>
		</div>
		
		<div class="col-sm-12">

				<div class="row" id="acoes">
					<div class="title">
						<h3 style="color: gray">Ações</h3>
					</div>
					<!-- menu de categorias -->
					<div class="list-group ">
						<a href="<c:url value='/admin/avaliacao/ano-8' />"
							class="list-group-item ">Avaliar Missões 8 ano</a> <a
							href="<c:url value='/admin/avaliacao/ano-9' />"
							class="list-group-item ">Avaliar Missões 9 ano</a> <a
							href="<c:url value='/admin/avaliacao/ano-1' />"
							class="list-group-item ">Avaliar Missões 1 ano</a>

					</div>
				</div>
			</div>
		
		<div class="title">
			<h1 style="color: blue">Avaliando missão ${missionNumber} - Ano ${year} </h1>
			
			<label for="updateGrade" style="color: black "> Atualizar notas automaticamente</label>
			<input type="checkbox" checked id="updateGrade" />
		</div>
			
		<div class="row">
			
			<!-- bloco conteudo -->
			<div class="col-sm-12">
				<div class="row">
					<form:form action="${pageContext.request.contextPath}/evaluate-list">
						<div class="wow fadeInUp" data-wow-delay=".2s">
							<div class="thumbnail" style="">
							<table border="1px">
								<tr>
									<td style="background-color: #FFE5CC"><label style="color: black ">Aluno </label></td>
									
									<td style="background-color: #FFCCCC"><label style="color: black;">Entrega fora da proposta / não entregue</label></td>
									<td style="background-color: #FFCCCC"><label style="color: black;">Entrega dentro da proposta</label></td>
									
									<td style="background-color: #FFCCCC"><label style="color: black;">Entrega atrasada</label></td>
									
									<td style="background-color: #E5FFCC"><label style="color: black;  ">Video: Som sem ruido, imagem nítida</label></td>
									<td style="background-color: #E5FFCC"><label style="color: black;  ">Vídeo: tempo: respeitar o tempo de duração</label></td>
									
									<td style="background-color: #CCE5FF"><label style="color: black;  ">Redação: Respeitar o número de caracteres</label></td>
									<td style="background-color: #CCE5FF"><label style="color: black;  ">Redação: Divisão entre parágrafos</label></td>
									
									<td style="background-color: #FFFFCC"><label style="color: black;  ">Áudio: Som sem ruido</label></td>
									<td style="background-color: #FFFFCC"><label style="color: black;  ">Áudio: conversa (objetiva) clara</label></td>

									<td style="background-color: #E5CCFF"><label style="color: black;  ">Planilhas e Relatórios: Qualidade do conteúdo</label></td>
									<td style="background-color: #E5CCFF"><label style="color: black;  ">Planilhas e Relatórios: Formatação e organização das informações</label></td>
									
									<td style="background-color: #E0E0E0"><label style="color: black; ">Pontuação total:</label></td>
								</tr>
								<c:forEach items="${missions}" var="mission">
								
									
									<tr >
											<td  style="background-color: #FFE5CC">
												<input type="hidden" value="${mission.id}"/>	
												<a href="${mission.fileLink}" target="_blank"> ${mission.user.ismartId} - ${mission.user.name}</a> 
											</td>
											
											<td style="background-color: #FFCCCC">
												<c:if test="${mission.deliveryOut != null && mission.deliveryOut > 0}">
													<input type="checkbox" checked id="delivery-out-${mission.user.ismartId}"  onclick="atualizaPontuacao(${mission.user.ismartId}, 0, $(this)[0].checked);"/>
												</c:if>	
												<c:if test="${mission.deliveryOut != null && mission.deliveryOut <= 0}">
													<input type="checkbox"  id="delivery-out-${mission.user.ismartId}"  onclick="atualizaPontuacao(${mission.user.ismartId}, 0, $(this)[0].checked);"/>
												</c:if>	 
											</td>
											
											<c:if test="${mission.deliveryIn != null && mission.deliveryIn > 0}">
												<td style="background-color: #FFCCCC">	<input type="checkbox" checked id="delivery-in-${mission.user.ismartId}" onclick="atualizaPontuacao(${mission.user.ismartId}, 50, $(this)[0].checked);"/> </td>
											</c:if>
											<c:if test="${mission.deliveryIn != null && mission.deliveryIn <= 0}">
												<td style="background-color: #FFCCCC">	<input type="checkbox"  id="delivery-in-${mission.user.ismartId}" onclick="atualizaPontuacao(${mission.user.ismartId}, 50, $(this)[0].checked);"/> </td>
											</c:if>
											
											<c:if test="${mission.lateDelivery != null && mission.lateDelivery > 0}">
												<td style="background-color: #FFCCCC">	<input type="checkbox" checked id="lateDelivery-${mission.user.ismartId}" onclick="atualizaPontuacao(${mission.user.ismartId}, 50, $(this)[0].checked);"/> </td>
											</c:if>
											<c:if test="${mission.lateDelivery != null && mission.lateDelivery <= 0}">
												<td style="background-color: #FFCCCC">	<input type="checkbox"  id="lateDelivery-${mission.user.ismartId}" onclick="atualizaPontuacao(${mission.user.ismartId}, 50, $(this)[0].checked);"/> </td>
											</c:if>
											
											<c:if test="${mission.videoNoiseless != null && mission.videoNoiseless > 0}">
												<td style="background-color: #E5FFCC">	<input type="checkbox" checked id="videoNoiseless-${mission.user.ismartId}" onclick="atualizaPontuacao(${mission.user.ismartId}, 25, $(this)[0].checked);"/> </td>
											</c:if>
											<c:if test="${mission.videoNoiseless != null && mission.videoNoiseless <= 0}">
												<td style="background-color: #E5FFCC">	<input type="checkbox" id="videoNoiseless-${mission.user.ismartId}" onclick="atualizaPontuacao(${mission.user.ismartId}, 25, $(this)[0].checked);"/> </td>
											</c:if>
											
											<c:if test="${mission.videoTimeOk != null && mission.videoTimeOk > 0}">
												<td style="background-color: #E5FFCC">	<input type="checkbox" checked id="videoTimeOk-${mission.user.ismartId}" onclick="atualizaPontuacao(${mission.user.ismartId}, 25, $(this)[0].checked);"/> </td>
											</c:if>
											<c:if test="${mission.videoTimeOk != null && mission.videoTimeOk <= 0}">
												<td style="background-color: #E5FFCC">	<input type="checkbox"  id="videoTimeOk-${mission.user.ismartId}" onclick="atualizaPontuacao(${mission.user.ismartId}, 25, $(this)[0].checked);"/> </td>
											</c:if>
											
											<c:if test="${mission.assayCharsRespect != null && mission.assayCharsRespect > 0}">
												<td style="background-color: #CCE5FF">	<input type="checkbox" checked id="assayCharsRespect-${mission.user.ismartId}" onclick="atualizaPontuacao(${mission.user.ismartId}, 25, $(this)[0].checked);"/> </td>
											</c:if>
											<c:if test="${mission.assayCharsRespect != null && mission.assayCharsRespect <= 0}">
												<td style="background-color: #CCE5FF">	<input type="checkbox" id="assayCharsRespect-${mission.user.ismartId}" onclick="atualizaPontuacao(${mission.user.ismartId}, 25, $(this)[0].checked);"/> </td>
											</c:if>
											
											<c:if test="${mission.assayParagraphsDivision != null && mission.assayParagraphsDivision > 0}">
												<td style="background-color: #CCE5FF">	<input type="checkbox" checked id="assayParagraphsDivision-${mission.user.ismartId}" onclick="atualizaPontuacao(${mission.user.ismartId}, 25, $(this)[0].checked);"/> </td>
											</c:if>
											<c:if test="${mission.assayParagraphsDivision != null && mission.assayParagraphsDivision <= 0}">
												<td style="background-color: #CCE5FF">	<input type="checkbox" id="assayParagraphsDivision-${mission.user.ismartId}" onclick="atualizaPontuacao(${mission.user.ismartId}, 25, $(this)[0].checked);"/> </td>
											</c:if>
											
											<c:if test="${mission.audioNoiseless != null && mission.audioNoiseless > 0}">
												<td style="background-color: #FFFFCC">	<input type="checkbox" checked id="audioNoiseless-${mission.user.ismartId}" onclick="atualizaPontuacao(${mission.user.ismartId}, 25, $(this)[0].checked);"/> </td>
											</c:if>
											<c:if test="${mission.audioNoiseless != null && mission.audioNoiseless <= 0}">
												<td style="background-color: #FFFFCC">	<input type="checkbox" id="audioNoiseless-${mission.user.ismartId}" onclick="atualizaPontuacao(${mission.user.ismartId}, 25, $(this)[0].checked);"/> </td>
											</c:if>
											
											<c:if test="${mission.audioClearTalk != null && mission.audioClearTalk > 0}">
												<td style="background-color: #FFFFCC">	<input type="checkbox" checked id="audioClearTalk-${mission.user.ismartId}" onclick="atualizaPontuacao(${mission.user.ismartId}, 25, $(this)[0].checked);"/> </td>
											</c:if>
											<c:if test="${mission.audioClearTalk != null && mission.audioClearTalk <= 0}">
												<td style="background-color: #FFFFCC">	<input type="checkbox" id="audioClearTalk-${mission.user.ismartId}" onclick="atualizaPontuacao(${mission.user.ismartId}, 25, $(this)[0].checked);"/> </td>
											</c:if>
											
											<c:if test="${mission.sheetAndReportFormatting != null && mission.sheetAndReportFormatting > 0}">
												<td style="background-color: #E5CCFF">	<input type="checkbox" checked id="sheetAndReportFormatting-${mission.user.ismartId}" onclick="atualizaPontuacao(${mission.user.ismartId}, 25, $(this)[0].checked);"/> </td>
											</c:if>
											<c:if test="${mission.sheetAndReportFormatting != null && mission.sheetAndReportFormatting <= 0}">
												<td style="background-color: #E5CCFF">	<input type="checkbox" id="sheetAndReportFormatting-${mission.user.ismartId}" onclick="atualizaPontuacao(${mission.user.ismartId}, 25, $(this)[0].checked);"/> </td>
											</c:if>
											
											<c:if test="${mission.sheetInfoOrganization != null && mission.sheetInfoOrganization > 0}">
												<td style="background-color: #E5CCFF">	<input type="checkbox" checked id="sheetInfoOrganization-${mission.user.ismartId}" onclick="atualizaPontuacao(${mission.user.ismartId}, 25, $(this)[0].checked);"/> </td>
											</c:if>
											<c:if test="${mission.sheetInfoOrganization != null && mission.sheetInfoOrganization <= 0}">
												<td style="background-color: #E5CCFF">	<input type="checkbox" id="sheetInfoOrganization-${mission.user.ismartId}" onclick="atualizaPontuacao(${mission.user.ismartId}, 25, $(this)[0].checked);"/> </td>
											</c:if>
											
											
											
											<td style="background-color: #E0E0E0">	<input type="text" id="grade-${mission.user.ismartId}" size="6"  style="color: black" value="${mission.valued < 1 ? 'Não Av.' : mission.grade}"/> </td>
												
											<td >
				
													<a href="#" onclick="avaliaMissao(${year}, ${missionNumber}, ${mission.id}, 
																		$('#grade-${mission.user.ismartId}').val(), 
																		$('#delivery-out-${mission.user.ismartId}')[0].checked == true ? 1 : 0, 
																		$('#delivery-in-${mission.user.ismartId}')[0].checked == true ? 1 : 0,
																		$('#lateDelivery-${mission.user.ismartId}')[0].checked == true ? 1 : 0,
																		$('#videoNoiseless-${mission.user.ismartId}')[0].checked == true ? 1 : 0, 
																		$('#videoTimeOk-${mission.user.ismartId}')[0].checked == true ? 1 : 0,
																		$('#assayCharsRespect-${mission.user.ismartId}')[0].checked == true ? 1 : 0,
													 					$('#assayParagraphsDivision-${mission.user.ismartId}')[0].checked == true ? 1 : 0,
													 					$('#audioNoiseless-${mission.user.ismartId}')[0].checked == true ? 1 : 0,
													 					$('#audioClearTalk-${mission.user.ismartId}')[0].checked == true ? 1 : 0,
													 					$('#sheetAndReportFormatting-${mission.user.ismartId}')[0].checked == true ? 1 : 0,
													 					$('#sheetInfoOrganization-${mission.user.ismartId}')[0].checked == true ? 1 : 0,
													 					${mission.user.ismartId});"
														class="btn btn-primary "  > Avaliar </a>
											</td>
											<td><img src="${pageContext.request.contextPath}/resources/img/check-icon.png" id="check-${mission.user.ismartId}" style="display: none; size: 5px"/> </td>
										</tr>
								</c:forEach>
							</table>
							<%--	<input class="btn btn-lg btn-primary btn-block" name="submit"
								type="submit" value="Avaliar Todos">  --%>
								
							</div>
						</div>
					</form:form>

				</div>
				<!-- fim dos mais vendidos -->
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
