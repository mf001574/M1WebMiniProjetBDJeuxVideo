<%-- 
    Document   : contenuVueJeu
    Created on : 3 mai 2015, 11:11:03
    Author     : florian
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:if test="${loginU != null}">
    <form method="post" action="ServletJeu" class="formCentre">
        <input type="hidden" name="action" value="listerJeux">
        <p><input type="text" name="titre" placeholder="Titre"></p>
        <button class="hideShowButton">+</button>
        <p>
            <select required>
               <option value="" disabled selected>Selectionnez un tag </option>
            </select>
        </p>
        <input type="submit" value="Rechercher">
    </form>
    <div class='DescriptionJeu'>
        
    </div>
               
</c:if>
<c:if test="${loginU == null}">
    <h3>Vous n'avez pas l'authorisation pour accéder au contenu de cette page</h3>
</c:if>
   
