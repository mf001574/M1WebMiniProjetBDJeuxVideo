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
    
    private int nbUtilisateurs;
    
    public GestionnaireUtilisateur(){
        this.nbUtilisateurs = 0;
    }

    public EntityManager getEm() {
        return em;
    }

    public void setEm(EntityManager em) {
        this.em = em;
    }
    
    public int getNbUtilisateurs() {
        return nbUtilisateurs;
    }

    public void setNbUtilisateurs(int nbUtilisateurs) {
        this.nbUtilisateurs = nbUtilisateurs;
    }
  
    
    
    public void creer1000UtilisateursDeTest(){
        for(int i = 1 ; i<=1000;i++){
            int indice = this.nbUtilisateurs+i;
            this.creerUtilisateur("Utilisateur"+indice,"test",0);
        }
       
    }
    public Utilisateur creerUtilisateur(String login, String mdp,int type) {
        Utilisateur u = new Utilisateur(login,mdp,type);
        em.persist(u);
        this.nbUtilisateurs++;
        return u;
    }
    
    public Collection<Utilisateur> getAllUsers(){
        Query q = em.createQuery("select u from Utilisateur u order by u.id");
        //q.setFirstResult(this.indiceDepart);
       // q.setMaxResults(10);
        return q.getResultList();
    }
}
