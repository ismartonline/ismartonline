<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/security/tags" prefix="sec"%>

<!-- Navigation -->
<nav class="navbar navbar-default navbar-fixed-top topnav" role="navigation">
    <div class="container topnav">
        <!-- Brand and toggle get grouped for better mobile display -->
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand header-line topnav" href="http://www.ismart.org.br" target="_blank" >Ismart</a> 
            <a class="navbar-brand header-line topnav"  href="#">|</a>
            <a class="navbar-brand header-line topnav" href="<c:url value='/home'/>" >Ismart Online</a>
            
            
            <sec:authorize access="isAuthenticated()">
            	<a class="navbar-brand header-line topnav"  href="#">|</a>
            	
            	<sec:authentication property="principal" var="user"/>
            	<a class="navbar-brand header-line topnav" href="<c:url value='/aluno'/>" >${user.name} - ${user.ano} Ano</a>
            	
            	<sec:authorize access="hasRole('ROLE_ADMIN')">
            		<a class="navbar-brand header-line topnav"  href="#">|</a>
	            	<a class="navbar-brand header-line topnav" href="<c:url value='/admin'/>" >Painel de Controle</a>
            	</sec:authorize>
                        
                <a class="navbar-brand header-line topnav"  href="#">|</a>
                <div class="navbar-brand header-line topnav dropdown btnNotification">
                    <button class="btn btn-default dropdown-toggle" type="button" id="dropdownMenu1" data-toggle="dropdown" aria-haspopup="true" aria-expanded="true">
                        Mensagens
                        <span class="notification-bubble">2</span>
                        <span class="caret"></span>
                    </button>
                    <ul class="dropdown-menu" aria-labelledby="dropdownMenu1">
                      <li>
                          <h4>Título da notificação</h4>
                          <p>Seja bem-vindo ao Ismart Online. Aproveite de nossa plataforma.</p>
                          <p class="btnReadMore">
                              <a href="#" class="btn btn-primary">Ler mais</a>
                          </p>
                      </li>
                      <li role="separator" class="divider"></li>
                      <li>
                          <h4>Título da notificação</h4>
                          <p>Seja bem-vindo ao Ismart Online. Aproveite de nossa plataforma.</p>
                          <p class="btnReadMore">
                              <a href="#" class="btn btn-primary">Ler mais</a>
                          </p>
                      </li>
                    </ul>
                </div>
                
            	<a class="navbar-brand header-line topnav"  href="#">|</a>
            	<a class="navbar-brand header-line topnav" href="<c:url value='/logout'/>" >Sair</a>
            </sec:authorize>
            
            
        </div>
        <!-- Collect the nav links, forms, and other content for toggling -->
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <ul class="nav navbar-nav navbar-right navbar-nav-header">
                 <li>
                    <a href="<c:url value='/home'/>">Home</a>
                </li>
                <li>
                    <a href="<c:url value='/sobre'/>">Sobre</a>
                </li>
                <li>
                    <a href="<c:url value='/faq'/>">FAQ</a>
                </li>
                <li>
                    <a href="<c:url value='/contato'/>">Contato</a>
                </li>
                <li>
                    <figure>
                     <a href="<c:url value='/home'/>">
                     	<img src="${pageContext.request.contextPath}/resources/img/ismart-online-logo-2.jpg">
                    	</a>
                   	</figure>
                </li>
            </ul>
        </div>
        <!-- /.navbar-collapse -->
    </div>
    <!-- /.container -->
</nav>