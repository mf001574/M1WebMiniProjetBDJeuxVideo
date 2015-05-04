/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionnaires;

import java.util.Collection;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import modeles.Contenu;
import modeles.Lien;
import modeles.Tag;
import modeles.TypeContenu;

/**
 *
 * @author florian
 */
@Stateless
public class GestionnaireContenu {
    @PersistenceContext
    private EntityManager em; 
    private int nbJeux;

    public EntityManager getEm() {
        return em;
    }

    public void setEm(EntityManager em) {
        this.em = em;
    }

    public int getNbJeux() {
        return nbJeux;
    }

    public void setNbJeux(int nbJeux) {
        this.nbJeux = nbJeux;
    }
    
    public GestionnaireContenu(){
        this.nbJeux = 0;
    }
    public Contenu creerJeu(String titre, String resume, String cheminImg, int type) {
        Contenu j = new Contenu(titre,resume,cheminImg,type);
        this.nbJeux++;
        em.persist(j);
        return j;
    }
    
    public void Creer10Jeux(){
        for(int i=0;i<10;i++){
            System.out.println("--->"+i);
            int indice = this.nbJeux + 1;
            this.creerJeu("Jeu"+indice, "resumé...", "rssources/HTML5LOGO.png", 0);
        }
       
    }
     
    public Collection<Contenu> getJeux(){
        Query q = em.createQuery("select c from Contenu c, TypeContenu t where t.id=c.typeContenu and t.libelle='jeu'");
        return q.getResultList();
    }
    
    public Collection<Contenu> get10Jeux(int depart){
         Query q = em.createQuery("select c from Contenu c, TypeContenu t where t.id=c.typeContenu and t.libelle='jeu'");
         q.setFirstResult(depart);
         q.setMaxResults(10);
         return q.getResultList();
    }
   
}
