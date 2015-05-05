/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionnaires;

import java.util.ArrayList;
import java.util.Collection;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import modeles.Contenu;
import modeles.Lien;
import modeles.Tag;



/**
 *
 * @author florian
 */
@Stateless
public class GestionnaireContenu {
    @PersistenceContext
    private EntityManager em; 
    private int nbJeux = 0;
    private ArrayList<Tag> listeTag;

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
    public Contenu creerJeu(String titre, StringBuilder resume, String cheminImg, int type) {
        Contenu j = new Contenu(titre,resume,cheminImg,type);
        return j;
    }
    public void CreerTags(){
        this.listeTag = new ArrayList<Tag>();
        Tag t;
        String[] nomTags = {"Jeu","Tutoriel","Demo","Aventure","Sport","Action","Arcade"};
        for(String tag : nomTags){
            t= new Tag(tag);
            em.persist(t);
            this.listeTag.add(t);
        } 
    }
    
    public void CreerJeux(){
        this.CreerTags();
        Contenu j = this.creerJeu("Canvas Rider", new StringBuilder("Reprise du fameux Line Rider, Canvas Rider nous emmène à vélo dans un monde linéaire où la physique sera à la fois votre amie et votre ennemie."), "resources/canvasRider.png", 0);
        j.setTypeContenu(0);
        Lien l = new Lien("http://canvasrider.com/");
        l.setContenu(j);
        j.addLien(l);
        l = new Lien("http://www.jeux-en-html5.fr/jeu/canvas-rider");
        l.setContenu(j);
        j.addLien(l);
        j.addTag(this.listeTag.get(4));
        this.listeTag.get(4).addContenu(j);
        j.addTag(this.listeTag.get(0));
        this.listeTag.get(4).addContenu(j); 
        em.persist(j);   
        
        j = this.creerJeu("Angry Birds", new StringBuilder("Les cochons ont dérobé les oeufs des oiseaux. Ils sont donc en colère " + 
"Pour les récupérer, vous devez adroitement envoyer les oiseaux au bon endroit pour dégommer les cochons et marquer un maximum de points." +
"Ce jeu d'une réalisation époustouflante rencontre un énorme succès. "), "resources/angryBirds.png", 0);
        j.setTypeContenu(0);
        l= new Lien("http://www.jeux-en-html5.fr/jeu/angry-birds");
        l.setContenu(j);
        j.addLien(l);
        j.addTag(this.listeTag.get(0));
        this.listeTag.get(4).addContenu(j); 
        em.persist(j);
        
         j = this.creerJeu("StarPutt", new StringBuilder("Il s'agit avant tout d'un jeu de mini golf.\n" +
"\n" +
"Mais il se déroule dans l'espace, et vos obstacles ne sont rien d'autre que des étoiles. Chaque étoile possède une force de gravitation qui peut être à la fois un inconvénient mais aussi une aide si vous lancez votre balle au bon endroit.  "), "resources/starPutt.png", 0);
        j.setTypeContenu(0);
        l= new Lien("http://www.starputt.com/");
        l.setContenu(j);
        j.addLien(l);
        l= new Lien("http://www.jeux-en-html5.fr/jeu/starputt");
        l.setContenu(j);
        j.addLien(l);
        j.addTag(this.listeTag.get(0));
        this.listeTag.get(4).addContenu(j); 
        em.persist(j);
         
        j = this.creerJeu("Infinite Mario", new StringBuilder("Redécouvrez ce jeu mythique, dans une version spécialement retravaillée en HTML5, tout à fait jouable.\n" +
"Le score est partageable via facebook. "), "resources/infiniteMario.png", 0);
        j.setTypeContenu(0);
        l= new Lien("http://jeu.info/mario-bros-infini.html");
        l.setContenu(j);
        j.addLien(l);
        j.addTag(this.listeTag.get(0));
        this.listeTag.get(4).addContenu(j); 
        em.persist(j);
        
         j = this.creerJeu("Creatures and Castles", new StringBuilder("Voici un jeu de stratégie à l'ambiance médiévale. Vous incarnez un héros en quête de liberté, emprisonné dans un château peuplé de trois types d'ennemis.\n" +
"Le jeu fera appel à vos réflexes, mais surtout à vos neurones pour trouver le bon chemin entre les murs du château.\n" +
"La réalisation est très bonne, et on se prend à enchaîner les niveaux les uns après les autres ! "), "resources/creaturesCastles.png", 0);
        j.setTypeContenu(0);
        l= new Lien("http://creaturesandcastles.hiive.com/");
        l.setContenu(j);
        j.addLien(l);
        j.addTag(this.listeTag.get(0));
        this.listeTag.get(4).addContenu(j); 
        em.persist(j);
        
        
         j = this.creerJeu("Music Can Be Fun", new StringBuilder(" Ce jeu simple mais surprenant se base sur une musique originale de Ra Ra Riot.\n" +
"\n" +
"Utilisez votre souris pour diriger un rayon vers des balles bleues, et évitez les rouges. Le classement des meilleurs scores s'affiche en fin de partie (et de musique).\n" +
""), "resources/musicFun.png", 0);
        j.setTypeContenu(0);
        l= new Lien("http://musiccanbefun.edankwan.com/");
        l.setContenu(j);
        j.addLien(l);
        j.addTag(this.listeTag.get(0));
        this.listeTag.get(4).addContenu(j); 
        em.persist(j);
        
        j = this.creerJeu("Space Maze", new StringBuilder("Labyrinthe dans l'espace"), "resources/HTML5LOGO.png", 0);
        j.setTypeContenu(0);
        l= new Lien("http://www.jeux-html5.net/games.php?id=267");
        l.setContenu(j);
        j.addLien(l);
        j.addTag(this.listeTag.get(0));
        this.listeTag.get(4).addContenu(j); 
        em.persist(j);
        
        j = this.creerJeu("Mack Jetpack", new StringBuilder("Jeu où vous contrôllez un jetpack"), "resources/jetpack.jpeg", 0);
        j.setTypeContenu(0);
        l= new Lien("http://www.jeux-html5.net/games.php?id=279");
        l.setContenu(j);
        j.addLien(l);
        j.addTag(this.listeTag.get(0));
        this.listeTag.get(4).addContenu(j); 
        em.persist(j);
        
        j = this.creerJeu("Biolab Disaster", new StringBuilder(" Ce petit jeu de plateforme peut sembler un peu trop pixelisé au début, mais sa jouabilité et son ambiance sonore sont réellement bluffants.\n" +
"\n" +
"Utilisez les flèches pour vous déplacer, X et C pour sauter et tirer.\n" +
"\n" +
"Les ennemis sont plutôt réactifs et les effets spéciaux étonnants pour un jeu en HTML5 ! "), "resources/biolab.png", 0);
        j.setTypeContenu(0);
        l= new Lien("http://www.jeux-en-html5.fr/jeu/biolab-disaster");
        l.setContenu(j);
        j.addLien(l);
        l= new Lien("http://playbiolab.com/");
        l.setContenu(j);
        j.addLien(l);
        j.addTag(this.listeTag.get(0));
        this.listeTag.get(4).addContenu(j); 
        em.persist(j);
        
        j = this.creerJeu("Snaky 360", new StringBuilder("C'est un jeu de serpent possédant de nombreux niveaux, tous très variés, avec des modes de jeux différents, un système de médailles, d'insignes, de progression, etc.\n" +
"Tout est fait pour que obtenir un vrai jeu addictif pour plusieurs heures, avec personnalisation des scores et classement public.\n" +
"\n" +
"Jouez directement à ce jeu ci-dessous. k"), "resources/snaky.png", 0);
        j.setTypeContenu(0);
        l= new Lien("http://www.jeux-en-html5.fr/jeu/snaky-360");
        l.setContenu(j);
        j.addLien(l);
        j.addTag(this.listeTag.get(0));
        this.listeTag.get(4).addContenu(j); 
        em.persist(j);
        
        j = this.creerJeu("wArp", new StringBuilder("Dans ce jeu de plateformes, vous incarnez un petit robot bionique qui doit survivre parmi les différents niveaux du jeu.\n" +
"\n" +
"La subtilité principale réside dans les sphères de \"warp\" qui permettent au robot de se téléporter d'un endroit à l'autre. Il vous faudra également coordonner mouvements et directions pour actionner des objets et avancer jusqu'à l'objectif final, d'autant plus que rester immobile fait perdre des points de vie.\n" +
"\n" +
"La jouabilité et la fluidité sont excellentes ; wArp est un jeu à recommander. "), "resources/warp.png", 0);
        j.setTypeContenu(0);
        l= new Lien("http://www.ascendedarcade.com/games/wArp/");
        l.setContenu(j);
        j.addLien(l);
        j.addTag(this.listeTag.get(0));
        this.listeTag.get(4).addContenu(j); 
        em.persist(j);
     
       
       
    }
     
    public Collection<Contenu> getJeux(){
        Query q = em.createQuery("select c from Contenu c where c.typeContenu=0 order by c.id ");
        return q.getResultList();
    }
    
    public Collection<Contenu> get5Jeux(int depart){
         Query q = em.createQuery("select c from Contenu c where c.typeContenu=0 order by c.id");
         q.setFirstResult(depart);
         q.setMaxResults(5);
         return q.getResultList();
    }

    public Contenu getContenu(String id) {
         Query q = em.createQuery("select c from Contenu c where c.id='"+id+"'");
         Collection<Contenu> c = (Collection<Contenu>) q.getResultList();
         if(!c.isEmpty()){
             return c.iterator().next();
         }
         return null;
         
    }

    public Collection<Contenu> rechercher(String nom, String tags) {
      Query q = em.createQuery("select c from Contenu c");
      return q.getResultList();
    }
   
}
