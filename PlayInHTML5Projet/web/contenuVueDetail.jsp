<%-- 
    Document   : contenuVueContenu
    Created on : 5 mai 2015, 15:28:49
    Author     : florian
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<a href='ServletContenu' style='float:left;color:#7EC5DF;font-size: 70%;margin-top:-15px; '>Retour</a>
<div class='contenu' style='margin:5;margin-top:30px;padding:5px; background-color: rgba(240,240,240,0.8); min-height: 200px;'>
   <h3 style="margin-top:0px;border:none;color:#FF9155;">${contenu.titre}</h3>
   <img src='${contenu.cheminImg}' style='float: left;margin-top:-15px; width:150px;height:150px;border-radius: 3px; border:1px rgb(200,200,200);margin-left:8px; '>
   <ul style='margin-left:130px;list-style-type:none;margin-top:-15px; font-size: 85%;margin-right:3px;'>
       <li>
           <label>Description</label>
           <p>
               ${contenu.resume}
           </p>
       </li>
       <li>
           <label>Liens</label>
           <ul>
               <c:forEach var='li' items="${contenu.liens}">
                   <li><a href='${li.libelle}' target='_blank' style='color:#FF9155;'>${li.libelle}</a></li>
               </c:forEach>
               
           </ul>
       </li>
   </ul>
</div>
           <ul id='tagsZone'style='list-style-type:none;margin-top: 10px;text-align: center;'>
               <c:forEach var='tag' items="${contenu.tags}">
                   <li>${tag.libelle}</li>
               </c:forEach>
           </ul>
