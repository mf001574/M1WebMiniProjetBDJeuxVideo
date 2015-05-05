<%-- 
    Document   : contenuVueJeu
    Created on : 3 mai 2015, 11:11:03
    Author     : florian
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:if test="${loginU != null}">
    
    <table id='table'>
        <thead>
            <tr>
                <th>Image</th>
                <th>Titre</th>
                <th>Tags</th>
                <th>Actions</th>
            </tr>
        </thead>
        <tbody
            <c:forEach var="j" items="${listeContenu}">
                <tr>
                    <td><img src="${j.cheminImg}"></td>
                    <td>${j.titre}</td>
                    
                    <td>
                        <ul>
                        <c:forEach var="li" items="${j.tags}"> 
                            <li>${li.libelle}</li>
                        </c:forEach>
                        </ul>
                    </td>
                    <td>
                        <a href="ServletContenu?action=afficherDetail&id=${j.id}" style="color:#7EC5DF; text-decoration:underline;">Plus de détail</a>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
        <tfoot>
            <tr>
                <td><a href='${pageContext.request.contextPath}/ServletContenu?action=reculer#table'>Précédent</a></td>
                <td colspan="2">${departJeu}-${departJeu+5}</td>
                <td><a href='${pageContext.request.contextPath}/ServletContenu?action=avancer#table'>Suivant</a></td>
            </tr>
        </tfoot>
      </table>
               
</c:if>
<c:if test="${loginU == null}">
    <h3>Vous n'avez pas l'authorisation pour accéder au contenu de cette page</h3>
</c:if>
   
