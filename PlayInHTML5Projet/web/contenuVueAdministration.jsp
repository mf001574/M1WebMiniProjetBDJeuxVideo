<%-- 
    Document   : vueAdministration
    Created on : 26 avr. 2015, 11:58:52
    Author     : florian
--%>

            
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<h3>Liste des utilisateurs</h3>
<p>
<form method='post' action='ServletAdministration'>
    <input type='hidden' name='action' value='creer1000'>
    <input type='submit'  value='Créer 1000 utilisateurs'>
</form>
<table>
    <thead>
        <tr>
            <th>Login</th>
            <th>Mot de passe </th>
            <th>Type d'utilisateur </th>
        </tr>
    </thead>
    <tbody>
        <c:forEach var="u" items="${requestScope['listeUtilisateurs']}">
            <tr>
                <td>${u.id}</td>
                <td>${u.mdp}</td>
                <td>${u.type}</td>
            </tr>
        </c:forEach>
    </tbody>
</table>
</p>
