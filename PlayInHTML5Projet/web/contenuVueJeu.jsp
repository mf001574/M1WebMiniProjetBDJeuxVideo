<%-- 
    Document   : contenuVueJeu
    Created on : 3 mai 2015, 11:11:03
    Author     : florian
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:if test="${loginU != null}">
    <div class='DescriptionJeu'>
        <ul>
             <li>Id</li>
             <li>Titre</li>
             <li>Résumé</li>
             <li>Image</li>
             <li>lien</li>
             <li>Tag</li>
        </ul>
    </div>
               
</c:if>
<c:if test="${loginU == null}">
    <h3>Vous n'avez pas l'authorisation pour accéder au contenu de cette page</h3>
</c:if>
   
