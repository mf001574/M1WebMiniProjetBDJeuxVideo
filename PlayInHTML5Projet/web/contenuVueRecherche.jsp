<%-- 
    Document   : contenuVueRecherche
    Created on : 6 mai 2015, 08:34:07
    Author     : florian
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:if test="${loginU != null}">
    <p>
<form method="post" action="ServletRecherche" class="formCentre">
            <input type="hidden" name="action" value="rechercher">
            <p><input type="text" name="titre" placeholder="Titre" required=""></p>
            <input type="submit" value="Rechercher">
</form>
            <h2> Recherche par tag </h2>
<form method="post" action="ServletRecherche" class="formCentre">
            <input type="hidden" name="action" value="rechercher">
            <p>
                <c:forEach var="t" items="${ListeTags}">
                     <label>${t.libelle}</label><input type="radio" name="tags" value="${t.id}">
                </c:forEach>
            </p>
           
            <input type="submit" value="Rechercher">
</form>
</p>
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
            <c:forEach var="j" items="${listeResultatRecherche2}">
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
                <td><a href='${pageContext.request.contextPath}/ServletRecherche?action=reculer#table'>Précédent</a></td>
                <td colspan="2">${departRecherche}-${departRecherche+5}</td>
                <td><a href='${pageContext.request.contextPath}/ServletRecherche?action=avancer#table'>Suivant</a></td>
            </tr>
        </tfoot>
      </table>
               
</c:if>
<c:if test="${loginU == null}">
    <h3>Vous n'avez pas l'autorisation pour accéder au contenu de cette page</h3>
</c:if>

