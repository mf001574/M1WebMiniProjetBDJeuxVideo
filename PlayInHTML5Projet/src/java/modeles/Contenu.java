/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modeles;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author florian
 */
@Entity
public class Contenu implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String titre;
    private String resume;
    private String cheminImg;
    private TypeContenu typeContenu;
    private Collection<Lien> liens;
    private Collection<Tag> tags;
    
    public Contenu(){
        
    }

    public Contenu(String titre, String resume, String cheminImg, TypeContenu typeContenu) {
        this.titre = titre;
        this.resume = resume;
        this.cheminImg = cheminImg;
        this.liens = new ArrayList<Lien>();
        this.tags = new ArrayList<Tag>();
        this.typeContenu = typeContenu;
    }
    
    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getResume() {
        return resume;
    }

    public void setResume(String resume) {
        this.resume = resume;
    }

    public String getCheminImg() {
        return cheminImg;
    }

    public void setCheminImg(String cheminImg) {
        this.cheminImg = cheminImg;
    }

    public Collection<Lien> getLiens() {
        return liens;
    }

    public void setLiens(Collection<Lien> liens) {
        this.liens = liens;
    }

    public Collection<Tag> getTags() {
        return tags;
    }

    public void setTags(Collection<Tag> tags) {
        this.tags = tags;
    }
    

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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
        if (!(object instanceof Contenu)) {
            return false;
        }
        Contenu other = (Contenu) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modeles.Contenu[ id=" + id + " ]";
    }
    
}
