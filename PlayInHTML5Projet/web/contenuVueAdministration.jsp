<%-- 
    Document   : vueAdministration
    Created on : 26 avr. 2015, 11:58:52
    Author     : florian
--%>

            
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<p>
<form method='post' action='ServletAdministration'>
    <input type='hidden' name='action' value='creer1000'>
    <input type='submit'  value='Cr�er 1000 utilisateurs'>
</form>
<table>
    <thead>
        <tr>
            <th>Identifiant</th>
            <th>Mot de passe </th>
            <th>Type d'utilisateur</th>
        </tr>
    </thead>
    <tbody>
    <h3>Liste des utilisateurs</h3>
        <c:forEach var="u" items="${listeUtilisateurs}">
            <tr>
                <td>${u.id}</td>
                <td>${u.mdp}</td>
                <c:if test="${u.type  == '0'}">
                    <td>Utilisateur classique</td>
                </c:if>
                <c:if test="${u.type  == '1'}">
                    <td>Administrateur</td>
                </c:if>
            </tr>
        </c:forEach>
    </tbody>
    <tfoot>
        <tr>
            <td><a href='${pageContext.request.contextPath}/ServletAdministration?action=reculer'>Pr�c�dent</a></td>
            <td>${depart}-${depart+9}</td>
            <td><a href='${pageContext.request.contextPath}/ServletAdministration?action=avancer'>Suivant</a></td>
        </tr>
    </tfoot>
</table>
 <h3>Liste des jeux</h3>
 <h3>Liste des d�mos</h3>
 <h3>Liste des tutoriaux</h3>
</p>
