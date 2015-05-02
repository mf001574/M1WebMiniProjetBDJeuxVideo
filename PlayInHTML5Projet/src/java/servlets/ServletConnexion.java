/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import gestionnaires.GestionnaireUtilisateur;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.json.Json;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;
import javax.json.JsonWriter;
import javax.servlet.http.HttpSession;
import modeles.Utilisateur;


/**
 *
 * @author florian
 */
@WebServlet(name = "ServletConnexion", urlPatterns = {"/connexion"})
public class ServletConnexion extends HttpServlet {
     @EJB
    private GestionnaireUtilisateur gestionnaireUtilisateur;

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
        response.setContentType("application/json;charset=UTF-8");
        JsonObjectBuilder jsonBuilder = Json.createObjectBuilder();
        //JsonArrayBuilder phoneNumBuilder = Json.createArrayBuilder();
        String action = request.getParameter("action"); 
        HttpSession session = request.getSession(true);
        if(action!=null){
            if(action.equals("connexion")){
                //requete de connexion
                Utilisateur u = this.gestionnaireUtilisateur.demanderConnexion(request.getParameter("login"), request.getParameter("mdp"));
                //création de la réponse en JSON
                if(u!=null){
                    jsonBuilder.add("login", u.getId());
                    session.setAttribute("loginU", u.getId());
                    session.setAttribute("typeU", u.getType());
                }
                try (PrintWriter out = response.getWriter()) {
                    out.println(jsonBuilder.build());        
                }
            }else if(action.equals("deconnexion")){
                session.setAttribute("loginU", null);
                session.setAttribute("typeU", null);
                response.sendRedirect("ServletIndex");
            }else if(action.equals("inscription")){
                //On peut creer l'utilisateur
                if(this.gestionnaireUtilisateur.getUserWithLogin(request.getParameter("login")).isEmpty()){
                   this.gestionnaireUtilisateur.creerUtilisateur(request.getParameter("login"),request.getParameter("mdp"), 0);
                   jsonBuilder.add("message", "L'utilisateur "+ request.getParameter("login")+ " est bien enregistré");
                }else{
                   jsonBuilder.add("message", "Identifiant indisponible");
                }
                try (PrintWriter out = response.getWriter()) {
                    out.println(jsonBuilder.build());        
                }
            }
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
