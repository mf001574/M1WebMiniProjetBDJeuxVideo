/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modeles;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.criteria.Join;

/**
 *
 * @author florian
 */
@Entity
public class Tag implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String libelle;
   @ManyToMany(fetch = FetchType.EAGER,mappedBy = "tags",cascade = CascadeType.PERSIST)
    private Collection<Contenu> contenus;
    public Tag(){
        this.contenus = new ArrayList<>();
        
    }
    public Tag(String libelle) {
        this.contenus = new ArrayList<>();
        this.libelle = libelle;
    }

    

   public Collection<Contenu> getContenus() {
        return contenus;
    }

    public void setContenus(Collection<Contenu> contenus) {
        this.contenus = contenus;
    }
    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    
    public void addContenu(Contenu c){
        this.contenus.add(c);
    }
    public void removeContenu(Contenu c){
        this.contenus.remove(c);
    }


    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
     
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tag)) {
            return false;
        }
        Tag other = (Tag) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }
  
    @Override
    public String toString() {
        return "modeles.Tag[ id=" + id + " ]";
    }
    
}
