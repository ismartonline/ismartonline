<%-- 
    Document   : mail-template
    Created on : 11/10/2016, 09:11:23
    Author     : RodrigoGuimaraes
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<!-- Bootstrap core CSS -->
<style type="text/css">
    .center{
        align: center;
        text-align: center;
    }
</style>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <table width="100%" border="0" cellspacing="0" cellpadding="0">
            <thead>
                <th style="align: center;">
                    <figure>
                        <a href="<c:url value='/home'/>">
                            <img src="${pageContext.request.contextPath}/resources/img/ismart-online-logo-2.jpg">
                        </a>
                    </figure>
                </th>
            </thead>
            <tbody>
                <td style="text-align: center;">
                    <h1>${title}</h1>
                </td>
                <td>
                    <p>
                        ${content}
                    </p>
                </td>
            </tbody>
        </table>
    </body>
</html>
