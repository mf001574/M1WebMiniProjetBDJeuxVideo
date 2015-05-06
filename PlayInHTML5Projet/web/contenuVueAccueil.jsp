<%-- 
    Document   : accueil
    Created on : 9 avr. 2015, 16:39:47
    Author     : florian
--%>
 <script type='text/javascript' src='resources/js/carousel.js'></script>
        
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


   
    <c:if test="${loginU == null}">
     <p>
        Le site <b>PlayInHTML5</b> vous permet d'accéder au différents jeux implémentés
        en <b> HTML5 </b>. Vous trouverez également des démos ainsi que différents tutoriaux concernant la création de jeu. 
    </p>
    <p>
           N'attendez pas inscrivez vous!
    </p>
    </c:if>
    <c:if test="${loginU != null}">
         <p>
        Le site <b>PlayInHTML5</b> vous permet d'accéder au différents jeux implémentés
        en <b> HTML5 </b>. Vous trouverez également des démos ainsi que différents tutoriaux concernant la création de jeu. 
        </p>
        <p>
           N'attendez pas inscrivez vous!
        </p>
        
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
                                <a href="ServletJeu?action=afficherDetail&id=${j.id}" style="color:#7EC5DF; text-decoration:underline;">Plus de détail</a>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
                <tfoot>
                    <tr>
                        <td><a href='${pageContext.request.contextPath}/ServletJeu?action=reculerJeu#tableJeux'>Précédent</a></td>
                        <td colspan="2">${departJeu}-${departJeu+5}</td>
                        <td><a href='${pageContext.request.contextPath}/ServletJeu?action=avancerJeu#tableJeux'>Suivant</a></td>
                    </tr>
                </tfoot>
      </table>
            <c:forEach var="r" items="${resultatRecherche}">
              
            </c:forEach>
            
        </c:if>
        
    </c:if>
        
   <div id="owl-demo" class="owl-carousel owl-theme">
 
  <div class="item"><img src="resources/angryBirds.png"></div>
  <div class="item"><img src="resources/biolab.png"  ></div>
  <div class="item"><img src="resources/css3logo.png"  ></div>
  <div class="item"><img src="resources/musicFun.png" ></div>
  <div class="item"><img src="resources/jetpack.jpeg" ></div>
  <div class="item"><img src="resources/starPutt.png"  ></div>
 
</div>
    
