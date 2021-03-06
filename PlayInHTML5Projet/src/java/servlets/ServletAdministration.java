/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import gestionnaires.GestionnaireContenu;
import gestionnaires.GestionnaireTag;
import gestionnaires.GestionnaireUtilisateur;
import java.io.IOException;
import java.io.PrintWriter;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
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
@WebServlet(name = "ServletAdministration", urlPatterns = {"/ServletAdministration"})
public class ServletAdministration extends HttpServlet {
    @EJB
    private GestionnaireUtilisateur gestionnaireUtilisateur;
    @EJB
    private GestionnaireContenu gestionnaireContenu; 
    private int indiceCourantUtilisateur;
    private int indiceCourantJeu;
    private int indiceCourantDemo;
    private int indiceCourantTuto;

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
        try (PrintWriter out = response.getWriter()) {
             String action = request.getParameter("action");        
             if(action!=null){
                
                 if(action.equals("creer1000")){
                    this.gestionnaireUtilisateur.creer1000UtilisateursDeTest();
                    
                 }else if(action.equals("avancer")){
                     this.indiceCourantUtilisateur+=10;
                 }else if(action.equals("reculer")){
                     if(!(this.indiceCourantUtilisateur<=0))
                         this.indiceCourantUtilisateur-=10;
                }else if(action.equals("creerJeux")){
                     this.gestionnaireContenu.CreerJeux();
                 } else if(action.equals("avancerJeu")){
                     this.indiceCourantJeu+=5;
                 }else if(action.equals("reculerJeu")){
                     if(!(this.indiceCourantJeu<=0))
                         this.indiceCourantJeu-=5;   
                 }else if(action.equals("creerDemo")){
                     this.gestionnaireContenu.creerDemos();
                 }else if(action.equals("avancerDemo")){
                     this.indiceCourantDemo+=5;
                 }else if(action.equals("reculerDemo")){
                     if(!(this.indiceCourantDemo<=0))
                         this.indiceCourantDemo-=5; 
                 }else if(action.equals("creerTuto")){
                     this.gestionnaireContenu.creerTutoriaux();
                 }else if(action.equals("avancerTuto")){
                     this.indiceCourantTuto+=5;
                 }else if(action.equals("reculerTuto")){
                     if(!(this.indiceCourantTuto<=0))
                         this.indiceCourantTuto-=5; 
                 }else if(action.equals("supprimer")){
                     this.gestionnaireContenu.supprimerContenu(request.getParameter("id"));
                 }else if(action.equals("supprimerU")){
                     
                     this.gestionnaireUtilisateur.supprimerUtilisateur(request.getParameter("id"));
                 }
             }
          
            //request.setAttribute("listeUtilisateurs", this.gestionnaireUtilisateur.getAllUsers());
            //RequestDispatcher dp = request.getRequestDispatcher("vueAdministration.jsp");
            //dp.forward(request, response);
             HttpSession session = request.getSession(true);
             session.setAttribute("listeUtilisateurs", this.gestionnaireUtilisateur.get10Users(this.indiceCourantUtilisateur));
             session.setAttribute("depart", this.indiceCourantUtilisateur);
             session.setAttribute("departJeu", this.indiceCourantJeu);
             session.setAttribute("departDemo", this.indiceCourantDemo);
              session.setAttribute("departTuto", this.indiceCourantTuto);
             session.setAttribute("listeJeux", this.gestionnaireContenu.get5Jeux(indiceCourantJeu));
             session.setAttribute("listeDemos", this.gestionnaireContenu.get5Demos(this.indiceCourantDemo));
             session.setAttribute("listeTutos", this.gestionnaireContenu.get5Tutos(this.indiceCourantTuto));
             
             response.sendRedirect("vueAdministration.jsp");
           
            
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
