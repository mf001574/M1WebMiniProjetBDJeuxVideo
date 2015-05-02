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
        <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>   
        <script type='text/javascript' src='resources/js/connexionAJAX.js'></script>
    </head>
    <body>
            <div class='container'>
                <jsp:include page="header.jsp"/>
                    
                    <div class='content-left'>
                       
                        <form method='post' id='formConnexion'>
                            <h3><i class="fa fa-user"></i> Connexion</h3>
                            <p>
                                <input type='text' id='idC'  name='login' placeholder="Identifiant" required>
                            </p>
                            <p>
                                <input type='password' id='mdpC' name='mdp'  placeholder="Mot de passe" required>
                            </p>
                            <p>
                                <input type='submit'  name='action' value='Se connecter'>
                            </p>
                        </form>
                       <div id='msgConnexion'>     
                        </div>
                        <form  id='formInscription'>
                            <h3><i class="fa fa-user"></i> Inscription</h3>
                            <p> 
                                <input type='text' name='login' placeholder="Identifiant" required>
                            </p>
                            <p>
                                <input type='password' name='mdp' placeholder="Mot de passe" required>
                            </p>
                            <p>
                                <input type='password' name='mdp2' placeholder="Confirmation mot de passe" required>
                            </p>
                            <p>
                                <input type='submit'  name='action' value="S'inscrire" >
                            </p>
                        </form>
                       
                    </div>
               
                    <div class='content'>
                        <h2>${param.title}</h2>
                        <jsp:include page="${param.content}.jsp"/>
                    </div>
              
                <jsp:include page="footer.jsp"/>
            </div>


    </body>
</html>
