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
		
		   <!-- Header -->
	    <div class="intro-header">
	        <div class="container">
	
	            <div class="row">
	                <div class="col-lg-12">
	                    <div class="intro-message caption">
	                        <h3>Módulo de Matérias</h3>
	                        <hr class="intro-divider">
	                        
	                        <div class="thumbnail row">
                                    <div class="col-xs-12">&nbsp;</div>
                                    <div class="col-xs-2 col-xs-offset-3">
                                        <form action="https://www.geekielab.com.br/login/launch" method="post" target="_blank" attribute-has-placeholders="action">
                                            <input type="hidden" name="user_id" value="${userId}">
                                            <input type="hidden" name="oauth_consumer_key"  value="${organizationId}">
                                            <input type="hidden" name="oauth_nonce"  value="${nonce}">
                                            <input type="hidden" name="oauth_signature_method" value="HMAC-SHA1">
                                            <input type="hidden" name="oauth_timestamp"  value="${timestamp}">
                                            <input type="hidden" name="oauth_version" value="1.0">
                                            <input type="hidden" name="oauth_signature" value="${signature}">

                                            <button class="btn btn-geekie">
                                              Acessar a Geekie&nbsp;&nbsp;<span class="glyphicon glyphicon-new-window"></span>
                                            </button>
                                        </form>
                                    </div>
                                        
                                    <div class="col-xs-2 col-xs-offset-2">
                                        <a href="<c:url value='/materias/imaginie'/>" class="btn btn-imaginie">
                                              Redação&nbsp;&nbsp;<span class="glyphicon glyphicon-list-alt"></span>
                                        </a>
                                    </div>
                                    <div class="col-xs-3">&nbsp;</div>
                                    <div class="col-xs-12">&nbsp;</div>
                                </div>
                                                         
	                    </div>
	                </div>
	            </div>
	
	        </div>
	        <!-- /.container -->
	
	    </div>
	    <!-- /.intro-header -->
	
	
	   	<c:import url="../include/footer.jsp" />
	
	</body>

</html>
