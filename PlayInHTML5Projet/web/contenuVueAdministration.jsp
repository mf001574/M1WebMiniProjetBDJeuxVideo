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
            <input type='submit'  value='Générer 1000 utilisateurs de test'>
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
                            <input type="hidden" name="id" value="${u.id}">
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
            <input type='hidden' name='action' value='creerJeux'>
            <input type='submit'  value='Générer les jeux'>
        </p>
    </form>
      <table id='tableJeux'>
        <thead>
            <tr>
                <th>Image</th>
                <th>Identifiant</th>
                <th>Titre</th>
                <th>Résumé</th>
                <th>Liens</th>
                <th>Tags</th>
                <th>Actions</th>
            </tr>
        </thead>
        <tbody
            <c:forEach var="j" items="${listeJeux}">
                <tr>
                    <td><img src="${j.cheminImg}"></td>
                    <td>${j.id}</td>
                    <td>${j.titre}</td>
                    <td> <div style='max-height: 80px; overflow: scroll; overflow-x: hidden;'>${j.resume}</div></td>
                    <td>
                        <ul>
                            <c:set var="total" value="0"/>
                            <c:forEach var="l" items="${j.liens}">
                                <li><a href="${l.libelle}" target='_blank'>Lien<c:set var="total" value="${total+1}"/>${total}</a></li>
                            </c:forEach>
                            
                        </ul>
                    </td>
                    <td>
                        <ul>
                        <c:forEach var="li" items="${j.tags}">
                            <li>${li.libelle}<br/></li>
                        </c:forEach>
                        </ul>
                    </td>
                    <td>
                        <form method='post' action='ServletAdministration'>
                            <input type="hidden" name="id" value="${j.id}">
                            <input type="hidden" name="action" value="supprimer">
                            <input type="submit" value="Supprimer">
                        </form>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
        <tfoot>
            <tr>
                <td><a href='${pageContext.request.contextPath}/ServletAdministration?action=reculerJeu#tableJeux'>Précédent</a></td>
                <td colspan="5">${departJeu}-${departJeu+5}</td>
                <td><a href='${pageContext.request.contextPath}/ServletAdministration?action=avancerJeu#tableJeux'>Suivant</a></td>
            </tr>
        </tfoot>
      </table>
     <h3>Gestion des démos</h3>
     <form method='post' class="formCentre" action='ServletAdministration'>
        <p>
            <input type='hidden' name='action' value='creerDemo'>
            <input type='submit'  value='Générer les démos'>
        </p>
    </form>
     <table id='tableDemo'>
        <thead>
            <tr>
                <th>Image</th>
                <th>Identifiant</th>
                <th>Titre</th>
                <th>Résumé</th>
                <th>Liens</th>
                <th>Tags</th>
                <th>Actions</th>
            </tr>
        </thead>
        <tbody
            <c:forEach var="j" items="${listeDemos}">
                <tr>
                    <td><img src="${j.cheminImg}"></td>
                    <td>${j.id}</td>
                    <td>${j.titre}</td>
                    <td> <div style='max-height: 80px; overflow: scroll; overflow-x: hidden;'>${j.resume}</div></td>
                    <td>
                        <ul>
                            <c:set var="total" value="0"/>
                            <c:forEach var="l" items="${j.liens}">
                                <li><a href="${l.libelle}" target='_blank'>Lien<c:set var="total" value="${total+1}"/>${total}</a></li>
                            </c:forEach>
                            
                        </ul>
                    </td>
                    <td>
                        <ul>
                        <c:forEach var="li" items="${j.tags}">
                            <li>${li.libelle}<br/></li>
                        </c:forEach>
                        </ul>
                    </td>
                    <td>
                        <form method='post' action='ServletAdministration'>
                            <input type="hidden" name="id" value="${j.id}">
                            <input type="hidden" name="action" value="supprimer">
                            <input type="submit" value="Supprimer">
                        </form>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
        <tfoot>
            <tr>
                <td><a href='${pageContext.request.contextPath}/ServletAdministration?action=reculerDemo#tableDemo'>Précédent</a></td>
                <td colspan="5">${departDemo}-${departDemo+5}</td>
                <td><a href='${pageContext.request.contextPath}/ServletAdministration?action=avancerDemo#tableDemo'>Suivant</a></td>
            </tr>
        </tfoot>
      </table>
     
     <h3>Gestion des tutoriaux</h3>
      <form method='post' class="formCentre" action='ServletAdministration'>
        <p>
            <input type='hidden' name='action' value='creerTuto'>
            <input type='submit'  value='Générer les tutoriaux'>
        </p>
    </form>
     <table id='tableTutoriaux'>
        <thead>
            <tr>
                <th>Image</th>
                <th>Identifiant</th>
                <th>Titre</th>
                <th>Résumé</th>
                <th>Liens</th>
                <th>Tags</th>
                <th>Actions</th>
            </tr>
        </thead>
        <tbody
            <c:forEach var="j" items="${listeTutos}">
                <tr>
                    <td><img src="${j.cheminImg}"></td>
                    <td>${j.id}</td>
                    <td>${j.titre}</td>
                    <td> <div style='max-height: 80px; overflow: scroll; overflow-x: hidden;'>${j.resume}</div></td>
                    <td>
                        <ul>
                            <c:set var="total" value="0"/>
                            <c:forEach var="l" items="${j.liens}">
                                <li><a href="${l.libelle}" target='_blank'>Lien<c:set var="total" value="${total+1}"/>${total}</a></li>
                            </c:forEach>
                            
                        </ul>
                    </td>
                    <td>
                        <ul>
                        <c:forEach var="li" items="${j.tags}">
                            <li>${li.libelle}<br/></li>
                        </c:forEach>
                        </ul>
                    </td>
                    <td>
                        <form method='post' action='ServletAdministration'>
                            <input type="hidden" name="idU" value="${j.id}">
                            <input type="hidden" name="action" value="supprimerJ">
                            <input type="submit" value="Supprimer">
                        </form>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
        <tfoot>
            <tr>
                <td><a href='${pageContext.request.contextPath}/ServletAdministration?action=reculerTuto#tableTutoriaux'>Précédent</a></td>
                <td colspan="5">${departTuto}-${departTuto+5}</td>
                <td><a href='${pageContext.request.contextPath}/ServletAdministration?action=avancerTuto#tableTutoriaux'>Suivant</a></td>
            </tr>
        </tfoot>
      </table>
    </p>
</c:if>
<c:if test="${loginU == null || typeU==0}">
    <h3>Vous n'avez pas l'autorisation pour accéder au contenu de cette page</h3>
</c:if>