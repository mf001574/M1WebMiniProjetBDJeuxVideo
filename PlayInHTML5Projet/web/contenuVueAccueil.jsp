<%-- 
    Document   : accueil
    Created on : 9 avr. 2015, 16:39:47
    Author     : florian
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


   
    <c:if test="${loginU == null}">
     <p>
        Le site <b>PlayInHTML5</b> vous permet d'acc�der au diff�rents jeux impl�ment�s
        en <b> HTML5 </b>. Vous trouverez �galement des d�mos ainsi que diff�rents tutoriaux concernant la cr�ation de jeu. 
    </p>
    <p>
           N'attendez pas inscrivez vous!
    </p>
    </c:if>
    <c:if test="${loginU != null}">
         <p>
        Le site <b>PlayInHTML5</b> vous permet d'acc�der au diff�rents jeux impl�ment�s
        en <b> HTML5 </b>. Vous trouverez �galement des d�mos ainsi que diff�rents tutoriaux concernant la cr�ation de jeu. 
        </p>
        <p>
           N'attendez pas inscrivez vous!
        </p>
        <form method="post" action="ServletIndex" class="formCentre">
            <h3>Recherche multicrit�res</h3>
            <input type="hidden" name="action" value="rechercher">
            <p><input type="text" name="titre" placeholder="Titre"></p>
            <p>
                <c:forEach var="t" items="${ListeTags}">
                     <label>${t.libelle}</label><input type="checkbox" name="tags" value="${t.id}">
                </c:forEach>
            </p>
            <input type="submit" value="Rechercher">
        </form>
        <c:if test="${resultatRecherche!=null}">
            <table id='tableJeux'>
                <thead>
                    <tr>
                        <th>Image</th>
                        <th>Titre</th>
                        <th>Tags</th>
                        <th>Actions</th>
                    </tr>
                </thead>
                <tbody
                    <c:forEach var="j" items="${listeJeux2}">
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
                                <a href="ServletJeu?action=afficherDetail&id=${j.id}" style="color:#7EC5DF; text-decoration:underline;">Plus de d�tail</a>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
                <tfoot>
                    <tr>
                        <td><a href='${pageContext.request.contextPath}/ServletJeu?action=reculerJeu#tableJeux'>Pr�c�dent</a></td>
                        <td colspan="2">${departJeu}-${departJeu+5}</td>
                        <td><a href='${pageContext.request.contextPath}/ServletJeu?action=avancerJeu#tableJeux'>Suivant</a></td>
                    </tr>
                </tfoot>
      </table>
            <c:forEach var="r" items="${resultatRecherche}">
              
            </c:forEach>
            
        </c:if>
        
    </c:if>
    
