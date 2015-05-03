<%-- 
    Document   : header
    Created on : 9 avr. 2015, 16:38:41
    Author     : florian
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="header">
    <img src="resources/logoplayinhtml5.png" id="logo">
    <span id="slogan">Simple way to play in your web browser!</span>
</div>

<div class='nav'>
    <ul>
        <li><i class="fa fa-arrow-right"></i> </li>
        <li><a href='ServletIndex'><i class="fa fa-home"></i> Accueil</a></li>
         <c:if test="${loginU  != null}">
            <li><a href='ServletJeu'><i class="fa fa-gamepad"></i> Jeu</a></li>
            <li><a href=''><i class="fa fa-share"></i> Démo</a></li>
            <li><a href=''><i class="fa fa-book"></i> Tutoriel</a></li>
        </c:if>
        <c:if test="${typeU  == 1}">
            <li><a href='ServletAdministration'><i class="fa fa-cogs"></i> Administration </a></li>
        </c:if>
         <li class="lienCache"><a href='ServletJeu'><i class="fa fa-gamepad"></i> Jeu</a></li>
         <li class="lienCache"><a href=''><i class="fa fa-share"></i> Démo</a></li>
         <li class="lienCache"><a href=''><i class="fa fa-book"></i> Tutoriel</a></li>
         <li class="lienAdminCache"><a href='ServletAdministration'><i class="fa fa-cogs"></i> Administration </a></li>
    </ul>
</div>


