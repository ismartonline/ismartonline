<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!-- Footer -->
<footer>
    <div class="container">
        <div class="row">
            <div class="col-lg-12">
                <ul class="list-inline">
                    <li>
                     <a href="<c:url value='/home'/>">Home</a>
                    </li>
                    <li class="footer-menu-divider">&sdot;</li>
                    <li>
                     <a href="<c:url value='/sobre'/>">Sobre</a>
                    </li>
                    <li class="footer-menu-divider">&sdot;</li>
                    <li>
                     <a href="<c:url value='/faq'/>">FAQ</a>
                    </li>
                    <li class="footer-menu-divider">&sdot;</li>
                    <li>
                     <a href="<c:url value='/contato'/>">Contato</a>
                    </li>
                </ul>
                <p class="copyright text-muted small">Copyright &copy; Ismart Online 2016. Todos os direitos reservados.</p>
            </div>
        </div>
    </div>
</footer>

<!-- jQuery -->
<script src="${pageContext.request.contextPath}/resources/js/jquery.js"></script>

<!-- Bootstrap Core JavaScript -->
<script src="${pageContext.request.contextPath}/resources/js/bootstrap.min.js"></script>