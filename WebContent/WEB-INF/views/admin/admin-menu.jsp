
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/security/tags"
	prefix="sec"%>

<div class="list-group ">
        <a href="<c:url value='/admin/avaliacao/ano-8' />" class="list-group-item ">Avaliar Missões 8 ano</a>
        <a href="<c:url value='/admin/avaliacao/ano-9' />" class="list-group-item ">Avaliar Missões 9 ano</a>
        <a href="<c:url value='/admin/avaliacao/ano-1' />" class="list-group-item ">Avaliar Missões 1 ano</a>
        <a href="<c:url value='/admin/notificacao' />" class="list-group-item ">Notificações</a>
</div>