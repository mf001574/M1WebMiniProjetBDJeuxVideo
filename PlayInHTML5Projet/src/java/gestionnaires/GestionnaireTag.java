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
import modeles.Tag;

/**
 *
 * @author florian
 */
@Stateless
public class GestionnaireTag {
      @PersistenceContext
    private EntityManager em; 
      
    public GestionnaireTag(){
        
    }
    
    public Collection<Tag> getTags(){
        Query q = em.createQuery("select t from Tag t");
        return q.getResultList();
    }
}
