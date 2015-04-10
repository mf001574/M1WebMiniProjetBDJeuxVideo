<%-- 
    Document   : template
    Created on : 9 avr. 2015, 16:33:07
    Author     : florian
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML>
<html>
    <head>
    <title>PlayInHTML5 : ${param.title}</title>
    <link rel="stylesheet" type="text/css"
            href="${pageContext.request.contextPath}/resources/style.css" />
    	<link href="//maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css" rel="stylesheet">
    </head>
    <body>
            <div class='container'>
                <jsp:include page="header.jsp"/>
                <div class='content'>
                    <h2>${param.title}</h2>
                    <hr>
                    <jsp:include page="${param.content}.jsp"/>
                </div>
                <jsp:include page="footer.jsp"/>
            </div>


    </body>
</html>
