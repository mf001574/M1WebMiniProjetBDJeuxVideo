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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

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
    private StringBuilder resume;
    private String cheminImg; 
    private int typeContenu; //0=>jeu, 1=>Demo, 2=> Tutoriel
    
     
    @OneToMany(mappedBy = "contenu", fetch = FetchType.EAGER, cascade = CascadeType.PERSIST )
    private Collection<Lien> liens;
 
    @ManyToMany(fetch = FetchType.EAGER,cascade = CascadeType.PERSIST)
    private Collection<Tag> tags;
    public Contenu(){
        super();
        this.liens = new ArrayList<>();
        this.tags = new ArrayList<>();
        
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Collection<Lien> getLiens() {
        return liens;
    }

    public Collection<Tag> getTags() {
        return tags;
    }

    public Contenu(String titre, StringBuilder resume, String cheminImg, int typeContenu) {
        super();
        this.liens = new ArrayList<Lien>();
        this.tags = new ArrayList<Tag>();
        this.titre = titre;
        this.resume = resume;
        this.cheminImg = cheminImg;
        this.typeContenu = typeContenu;
    }
    
    
    public int getTypeContenu() {
        return typeContenu;
    }

    public void setTypeContenu(int typeContenu) {
        this.typeContenu = typeContenu;
    }
    
    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public StringBuilder getResume() {
        return resume;
    }

    public void setResume(StringBuilder resume) {
        this.resume = resume;
    }

    public String getCheminImg() {
        return cheminImg;
    }

    public void setCheminImg(String cheminImg) {
        this.cheminImg = cheminImg;
    }


    public void setLiens(Collection<Lien> liens) {
        this.liens = liens;
    }

    public void setTags(Collection<Tag> tags) {
        this.tags = tags;
    }
     
    public void removeTag(Tag t){
        this.tags.remove(t);
    }

    public void addTag(Tag t){
       this.tags.add(t);
    }
    
    public void addLien(Tag t){
        this.tags.add(t);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    
    public void removeLien(Lien l){
        this.liens.remove(l);
    }
    
    public void addLien(Lien l){
        this.liens.add(l);
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
