/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import gestionnaires.GestionnaireContenu;
import gestionnaires.GestionnaireTag;
import java.io.IOException;
import java.io.PrintWriter;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author florian
 */
@WebServlet(name = "ServletRecherche", urlPatterns = {"/ServletRecherche"})
public class ServletRecherche extends HttpServlet {
    
     @EJB
        private GestionnaireTag gestionnaireTags;
     @EJB
        private GestionnaireContenu gestionnaireContenu;
        private int departRecherche;
        private String loginRecherche;
        private String tagRecherche;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession(true);
        try (PrintWriter out = response.getWriter()) {
            String action = request.getParameter("action");   
            if(action!=null){
              
                if(action.equals("rechercher")){
                     this.loginRecherche = request.getParameter("titre");
                     this.tagRecherche =  request.getParameter("tags");
                     session.setAttribute("listeResultatRecherche2", this.gestionnaireContenu.rechercher5Contenus(this.departRecherche,this.loginRecherche,this.tagRecherche));
                    
                     session.setAttribute("tagsRecherche", request.getParameter("tagsRecherche") );
                
                }else if(action.equals("avancer")){
                     this.departRecherche+=5;
                     session.setAttribute("listeResultatRecherche2", this.gestionnaireContenu.rechercher5Contenus(this.departRecherche,this.loginRecherche,this.tagRecherche));
                
                }else if(action.equals("reculer")){
                     if(!(this.departRecherche<=0)){
                         this.departRecherche-=5;
                     }
                     session.setAttribute("listeResultatRecherche2", this.gestionnaireContenu.rechercher5Contenus(this.departRecherche,this.loginRecherche,this.tagRecherche));
                
                }
                
            }
            session.setAttribute("ListeTags", this.gestionnaireTags.getTags());
            session.setAttribute("departRecherche", this.departRecherche);
            response.sendRedirect("vueRecherche.jsp");
        }
       
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
