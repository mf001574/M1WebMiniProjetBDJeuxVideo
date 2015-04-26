/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionnaires;

import javax.ejb.Stateless;
import java.util.Collection;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import modeles.Utilisateur;

/**
 *
 * @author Florian Massa
 */
@Stateless
public class GestionnaireUtilisateur {
    @PersistenceContext
    private EntityManager em; 
    public void creer1000UtilisateursDeTest(){
        for(int i = 1 ; i<=1000;i++){
            this.creerUtilisateur("Utilisateur"+i,"test",0);
        }
       
    }
    public Utilisateur creerUtilisateur(String login, String mdp,int type) {
        Utilisateur u = new Utilisateur(login,mdp,type);
        em.persist(u);
        return u;
    }
}
