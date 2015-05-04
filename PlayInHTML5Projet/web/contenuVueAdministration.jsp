<%-- 
    Document   : vueAdministration
    Created on : 26 avr. 2015, 11:58:52
    Author     : florian
--%>

            
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:if test="${typeU  == 1}">
    <p>
    <h3><i class='fa fa-user'></i> Gestion des utilisateurs</h3>
    <form method='post' class="formCentre" action='ServletAdministration'>
        <p>
            <input type='hidden' name='action' value='creer1000'>
            <input type='submit'  value='Créer 1000 utilisateurs de test'>
        </p>
    </form>
    <table id='tableUtilisateur'>
        <thead>
            <tr>
                <th>Identifiant</th>
                <th>Mot de passe </th>
                <th>Type d'utilisateur</th>
                <th>Actions</th>
            </tr>
        </thead>
        <tbody>
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
                    <td>
                        <form method='post' action='ServletAdministration'>
                            <input type="hidden" name="idU" value="${u.id}">
                            <input type="hidden" name="action" value="supprimerU">
                            <input type="submit" value="Supprimer">
                        </form>       
                    </td>
                </tr>
            </c:forEach>
        </tbody>
        <tfoot>
            <tr>
                <td><a href='${pageContext.request.contextPath}/ServletAdministration?action=reculer#tableUtilisateur'>Précédent</a></td>
                <td colspan="2">${depart}-${depart+9}</td>
                <td><a href='${pageContext.request.contextPath}/ServletAdministration?action=avancer#tableUtilisateur'>Suivant</a></td>
            </tr>
        </tfoot>
    </table>
     <h3> <i class='fa fa-gamepad'></i> Gestion des jeux</h3>
     <form method='post' class="formCentre" action='ServletAdministration'>
        <p>
            <input type='hidden' name='action' value='creer10Jeux'>
            <input type='submit'  value='Créer 10 jeux aléatoirement'>
        </p>
    </form>
    <form method='post' class="formCentre" action='ServletAdministration'>
        <p>
            <input type='hidden' name='action' value='creerJeux'>
            <input type='submit'  value='Créer les jeux'>
        </p>
    </form>
      <table id='tableJeux'>
        <thead>
            <tr>
                <th>Identifiant</th>
                <th>Titre</th>
                <th>Résumé</th>
                <th>Image</th>
                <th>Liens</th>
                <th>Tags</th>
                <th>Actions</th>
            </tr>
        </thead>
        <tbody>
        </tbody>
        <tfoot>
        </tfoot>
      </table>
     <h3>Gestion des démos</h3>
     <h3>Gestion des tutoriaux</h3>
    </p>
</c:if>
<c:if test="${loginU == null || typeU==0}">
    <h3>Vous n'avez pas l'authorisation pour accéder au contenu de cette page</h3>
</c:if>