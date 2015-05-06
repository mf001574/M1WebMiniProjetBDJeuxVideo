/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionnaires;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
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
    private HashMap<String,Tag> listeTag;
    private String[] nomTags = {"Jeu","Tutoriel","Démo","Aventure","Sport","Action","Arcade","Réflexion","Musique","Jeu de plateforme","Snake","Phaser","Quintus"};
    

    public GestionnaireContenu(){
        this.nbJeux = 0;
        this.listeTag = new HashMap<String,Tag>();
       
    }
    
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
    
   
    public Contenu creerJeu(String titre, StringBuilder resume, String cheminImg, int type) {
        Contenu j = new Contenu(titre,resume,cheminImg,type);
        return j;
    }
    public void CreerTags(){
        this.listeTag = new HashMap<String,Tag>();
        Tag t;
        for(String tag : nomTags){
            t= new Tag(tag);
            em.persist(t);
            this.listeTag.put(tag, t);
        } 
    }
    
    public void CreerJeux(){
        if(this.listeTag.isEmpty()){
            this.CreerTags(); 
        }
        if(!this.get5Jeux(0).isEmpty()){
            return;
        }
        Contenu j = this.creerJeu("Canvas Rider", new StringBuilder("Reprise du fameux Line Rider, Canvas Rider nous emmène à vélo dans un monde linéaire où la physique sera à la fois votre amie et votre ennemie."), "resources/canvasRider.png", 0);
        j.setTypeContenu(0);
        Lien l = new Lien("http://canvasrider.com/");
        l.setContenu(j);
        j.addLien(l);
        l = new Lien("http://www.jeux-en-html5.fr/jeu/canvas-rider");
        l.setContenu(j);
        j.addLien(l);
        j.addTag(this.listeTag.get("Jeu"));
        this.listeTag.get("Jeu").addContenu(j);
        j.addTag(this.listeTag.get("Sport"));
        this.listeTag.get("Sport").addContenu(j); 
        //em.persist(j);  
        //em.merge(j);
        
        j = this.creerJeu("Angry Birds", new StringBuilder("Les cochons ont dérobé les oeufs des oiseaux. Ils sont donc en colère " + 
"Pour les récupérer, vous devez adroitement envoyer les oiseaux au bon endroit pour dégommer les cochons et marquer un maximum de points." +
"Ce jeu d'une réalisation époustouflante rencontre un énorme succès. "), "resources/angryBirds.png", 0);
        j.setTypeContenu(0);
        l= new Lien("http://www.jeux-en-html5.fr/jeu/angry-birds");
        l.setContenu(j);
        j.addLien(l);
        j.addTag(this.listeTag.get("Jeu"));
        this.listeTag.get("Jeu").addContenu(j); 
        j.addTag(this.listeTag.get("Réflexion"));
        this.listeTag.get("Réflexion").addContenu(j);
        //em.merge(j);
        
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
        j.addTag(this.listeTag.get("Jeu"));
        this.listeTag.get("Jeu").addContenu(j); 
        //em.merge(j);
         
        j = this.creerJeu("Infinite Mario", new StringBuilder("Redécouvrez ce jeu mythique, dans une version spécialement retravaillée en HTML5, tout à fait jouable.\n" +
"Le score est partageable via facebook. "), "resources/infiniteMario.png", 0);
        j.setTypeContenu(0);
        l= new Lien("http://jeu.info/mario-bros-infini.html");
        l.setContenu(j);
        j.addLien(l);
        j.addTag(this.listeTag.get("Jeu"));
        this.listeTag.get("Jeu").addContenu(j); 
        j.addTag(this.listeTag.get("Arcade"));
        this.listeTag.get("Arcade").addContenu(j); 
        j.addTag(this.listeTag.get("Jeu de plateforme"));
        this.listeTag.get("Jeu de plateforme").addContenu(j); 
        
        //em.merge(j);
        
         j = this.creerJeu("Creatures and Castles", new StringBuilder("Voici un jeu de stratégie à l'ambiance médiévale. Vous incarnez un héros en quête de liberté, emprisonné dans un château peuplé de trois types d'ennemis.\n" +
"Le jeu fera appel à vos réflexes, mais surtout à vos neurones pour trouver le bon chemin entre les murs du château.\n" +
"La réalisation est très bonne, et on se prend à enchaîner les niveaux les uns après les autres ! "), "resources/creaturesCastles.png", 0);
        j.setTypeContenu(0);
        l= new Lien("http://creaturesandcastles.hiive.com/");
        l.setContenu(j);
        j.addLien(l);
        j.addTag(this.listeTag.get("Jeu"));
        this.listeTag.get("Jeu").addContenu(j); 
        j.addTag(this.listeTag.get("Réflexion"));
        this.listeTag.get("Réflexion").addContenu(j); 
        //em.merge(j);
        
        
         j = this.creerJeu("Music Can Be Fun", new StringBuilder(" Ce jeu simple mais surprenant se base sur une musique originale de Ra Ra Riot.\n" +
"\n" +
"Utilisez votre souris pour diriger un rayon vers des balles bleues, et évitez les rouges. Le classement des meilleurs scores s'affiche en fin de partie (et de musique).\n" +
""), "resources/musicFun.png", 0);
        j.setTypeContenu(0);
        l= new Lien("http://musiccanbefun.edankwan.com/");
        l.setContenu(j);
        j.addLien(l);
        j.addTag(this.listeTag.get("Jeu"));
        this.listeTag.get("Jeu").addContenu(j); 
        j.addTag(this.listeTag.get("Musique"));
        this.listeTag.get("Musique").addContenu(j); 
        //em.merge(j);
        
        j = this.creerJeu("Space Maze", new StringBuilder("Labyrinthe dans l'espace"), "resources/HTML5LOGO.png", 0);
        j.setTypeContenu(0);
        l= new Lien("http://www.jeux-html5.net/games.php?id=267");
        l.setContenu(j);
        j.addLien(l);
        j.addTag(this.listeTag.get("Jeu"));
        this.listeTag.get("Jeu").addContenu(j); 
        //em.merge(j);
        
        j = this.creerJeu("Mack Jetpack", new StringBuilder("Jeu où vous contrôllez un jetpack"), "resources/jetpack.jpeg", 0);
        j.setTypeContenu(0);
        l= new Lien("http://www.jeux-html5.net/games.php?id=279");
        l.setContenu(j);
        j.addLien(l);
        j.addTag(this.listeTag.get("Jeu"));
        this.listeTag.get("Jeu").addContenu(j); 
        //em.merge(j);
        
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
        j.addTag(this.listeTag.get("Jeu"));
        this.listeTag.get("Jeu").addContenu(j); 
        //em.merge(j);
        
        j = this.creerJeu("Snaky 360", new StringBuilder("C'est un jeu de serpent possédant de nombreux niveaux, tous très variés, avec des modes de jeux différents, un système de médailles, d'insignes, de progression, etc.\n" +
"Tout est fait pour que obtenir un vrai jeu addictif pour plusieurs heures, avec personnalisation des scores et classement public.\n" +
"\n" +
"Jouez directement à ce jeu ci-dessous. k"), "resources/snaky.png", 0);
        j.setTypeContenu(0);
        l= new Lien("http://www.jeux-en-html5.fr/jeu/snaky-360");
        l.setContenu(j);
        j.addLien(l);
        j.addTag(this.listeTag.get("Jeu"));
        this.listeTag.get("Jeu").addContenu(j); 
        j.addTag(this.listeTag.get("Snake"));
        this.listeTag.get("Snake").addContenu(j); 
        //em.merge(j);
        
        j = this.creerJeu("wArp", new StringBuilder("Dans ce jeu de plateformes, vous incarnez un petit robot bionique qui doit survivre parmi les différents niveaux du jeu.\n" +
"\n" +
"La subtilité principale réside dans les sphères de \"warp\" qui permettent au robot de se téléporter d'un endroit à l'autre. Il vous faudra également coordonner mouvements et directions pour actionner des objets et avancer jusqu'à l'objectif final, d'autant plus que rester immobile fait perdre des points de vie.\n" +
"\n" +
"La jouabilité et la fluidité sont excellentes ; wArp est un jeu à recommander. "), "resources/warp.png", 0);
        j.setTypeContenu(0);
        l= new Lien("http://www.ascendedarcade.com/games/wArp/");
        l.setContenu(j);
        j.addLien(l);
        j.addTag(this.listeTag.get("Jeu"));
        this.listeTag.get("Jeu").addContenu(j); 
        j.addTag(this.listeTag.get("Jeu de plateforme"));
        this.listeTag.get("Jeu de plateforme").addContenu(j); 
     
        em.persist(j);
     
       
       
    }
    
    public void creerDemos(){
      
        if(this.listeTag.isEmpty()){
            this.CreerTags(); 
        }
        if(!this.get5Demos(0).isEmpty()){
            return;
        }
        Contenu d = new Contenu("Démo QuakeII",new StringBuilder("Le moteur graphique de Quake II a été recréé entièrement en javascript avec Google Web Toolkit. Pour réussir cet exploit, ils les technologies suivantes ont été utilisé (WebGL (pour la 3D) et WebSockets (pour le mode multijoueur)). Le résultat est assez bluffant"),"resources/QuakeII.jpg",1);
        Lien l = new Lien("http://korben.info/demo-webgl.html");
        l.setContenu(d);
        d.addLien(l);
        d.addTag(this.listeTag.get("Démo"));
        this.listeTag.get("Démo").addContenu(d);
        em.merge(d); 
        
        
        d = new Contenu("Rubik's cube Démo HTML5",new StringBuilder("Jeu permettant de simuler un rubiks cube en HTML5"),"resources/HTML5LOGO.png",1);
        l = new Lien("https://developer.mozilla.org/fr/demos/detail/rubiks-cube-using-html5");
        l.setContenu(d);
        d.addLien(l);
        d.addTag(this.listeTag.get("Démo"));
        this.listeTag.get("Démo").addContenu(d);
         d.addTag(this.listeTag.get("Réflexion"));
        this.listeTag.get("Réflexion").addContenu(d);
        em.merge(d);
       
        d = new Contenu("Démo d'Epic Citadel en HTML5",new StringBuilder("Pour atteindre des performances qui permettent de tels progrès, Mozilla a développé asm.js, un sous-ensemble hautement optimisé du JavaScript qui permet aux applications compilées avec Emscripten d’atteindre des performances quasi natives. Ces performances de base permettent aux développeurs de créer des expériences de jeu sur le Web visuellement fascinantes et rapides. Avec cette technologie, le Web devient tout simplement une autre plateforme cible pour les développeurs."),"resources/HTML5LOGO.png",1);
        l = new Lien("http://blogzinet.free.fr/blog/index.php?post/2013/05/03/Unreal-JavaScript");
        l.setContenu(d);
        d.addLien(l);
        d.addTag(this.listeTag.get("Démo"));
        this.listeTag.get("Démo").addContenu(d);
        em.merge(d);
        
        d = new Contenu("Démo du jeu Elliot Quest",new StringBuilder("Elliot Quest, est jeu 8-bit retro implémenté avec Impact.js HTML5 Game Engine. C'est un exmple de portabilité du langage."),"resources/elliot-quest.png",1);
        l = new Lien("http://blogzinet.free.fr/blog/index.php?post/2013/05/03/Unreal-JavaScript");
        l.setContenu(d);
        d.addLien(l);
        l=new Lien("https://www.youtube.com/watch?v=qisxfEWLOrU");
        l.setContenu(d);
        d.addLien(l);
        d.addTag(this.listeTag.get("Démo"));
        this.listeTag.get("Démo").addContenu(d);
        d.addTag(this.listeTag.get("Jeu de plateforme"));
        this.listeTag.get("Jeu de plateforme").addContenu(d);
         em.merge(d);
        
        d = new Contenu("JS1K Dragons - Demo",new StringBuilder("Pour admirer des effets."),"resources/HTML5LOGO.png",1);
        l = new Lien("http://www.kevs3d.co.uk/dev/js1kdragons/");
        l.setContenu(d);
        d.addLien(l);
        d.addTag(this.listeTag.get("Démo"));
        this.listeTag.get("Démo").addContenu(d);
         em.merge(d);
        
        d = new Contenu("JS1K Dragons - Demo",new StringBuilder("Pour admirer des effets."),"resources/HTML5LOGO.png",1);
        l = new Lien("http://www.kevs3d.co.uk/dev/js1kdragons/");
        l.setContenu(d);
        d.addLien(l);
        d.addTag(this.listeTag.get("Démo"));
        this.listeTag.get("Démo").addContenu(d);
         em.merge(d);
        
         d = new Contenu("Exemple de jeu d'échec en HTML5",new StringBuilder("Reconstitution d'un jeu d'échec en HTML5"),"resources/HTML5LOGO.png",1);
        l = new Lien("http://htmlchess.sourceforge.net/demo/example.html");
        l.setContenu(d);
        d.addLien(l);
        d.addTag(this.listeTag.get("Démo"));
        this.listeTag.get("Démo").addContenu(d);
        d.addTag(this.listeTag.get("Réflexion"));
        this.listeTag.get("Réflexion").addContenu(d);
        em.merge(d);
        
        
        
    }
    
    public void creerTutoriaux(){
        if(this.listeTag.isEmpty()){
            this.CreerTags(); 
        }
        if(!this.get5Tutos(0).isEmpty()){
            return;
        }
        Contenu d = new Contenu("Tutorial Phaser : Creation d'un Flappy Bird",new StringBuilder("Phaser est un framework javascript qui vous permettra de créer plus facilement votre jeu 2D avec un rendu graphique WebGL ou Canvas. En effet, il intègre une gestion de plusieurs éléments nécessaires dans un jeu vidéo, ce qui vous permettra d’avancer plus rapidement dans le développement sans être obligé de tout réinventer."),"resources/phaser-flappyBird.png",2);
        Lien l = new Lien("http://www.soluka.fr/blog/jeux/phaser-creer-flappy-bird-en-html5-canvas/");
        l.setContenu(d);
        d.addLien(l);
        d.addTag(this.listeTag.get("Tutoriel"));
        this.listeTag.get("Tutoriel").addContenu(d);
        d.addTag(this.listeTag.get("Phaser"));
        this.listeTag.get("Phaser").addContenu(d);
        em.merge(d);
        
        d = new Contenu("Créer un jeu HTML5 avec Quintus ",new StringBuilder("Ce tutoriel s'adresse à tout le monde, débutants comme développeurs aguerris : j'ai donc fait en sorte d'être le plus explicite possible. Si vous n'y connaissez rien en développement de jeux vidéos, ne vous inquiétez pas, je n'en avais moi-même jamais développé avant de découvrir Quintus !"),"resources/quintus.png",2);
        l = new Lien("https://zestedesavoir.com/tutoriels/234/creer-un-jeu-html5-avec-quintus/");
        l.setContenu(d);
        d.addLien(l);
        l = new Lien("http://www.html5quintus.com/");
        l.setContenu(d);
        d.addLien(l);
        d.addTag(this.listeTag.get("Tutoriel"));
        this.listeTag.get("Tutoriel").addContenu(d);
        d.addTag(this.listeTag.get("Quintus"));
        this.listeTag.get("Quintus").addContenu(d);
        em.merge(d);
        
        d = new Contenu("Réaliser son premier jeu en HTML 5 / Javascript avec EaselJS",new StringBuilder("L’essentiel de la réalisation d’un jeu se compose d’interactions et d’effets visuels. Pour toute animations nous utiliserons la technique des Sprites. "),"resources/HTML5LOGO.png",2);
        l = new Lien("https://zestedesavoir.com/tutoriels/234/creer-un-jeu-html5-avec-quintus/");
        l.setContenu(d);
        d.addLien(l);
       
        d.addTag(this.listeTag.get("Tutoriel"));
        this.listeTag.get("Tutoriel").addContenu(d);
        em.merge(d);
        
        
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

    public Collection<Contenu> rechercher5Contenus(int depart, String nom, String tag) {
      String requete = "select c from Contenu c where c.titre like '%"+nom+"%' ";
       /*if(tags!=null){
        /*requete+= "and ( ";
        for(int i=0 ; i<tags.length;i++){
            if(i==tags.length-1)
                requete+= "t.id = '"+tags[i]+"') ";
            else
                requete+= "t.id = '"+tags[i]+"' or ";
        }
           
      }*/
      if(tag!=null){
       
        //requete="select c from Contenu c join Tag t where c.titre like '%"+nom+"%'  and t.id='"+tag+"' "; 
          requete="select t.contenus from Tag t where t.id='"+tag+"'";
      }
      
      //requete+=" order by c.id";
      
      System.out.println(requete);
      Query q = em.createQuery(requete);
      q.setFirstResult(depart);
      q.setMaxResults(5); 
      return q.getResultList();
    }
    
    
    public Collection<Contenu> get5Contenu(int depart){
       Query q = em.createQuery("select c from Contenu c order by c.id");
       q.setFirstResult(depart);
       q.setMaxResults(5);
       return q.getResultList();
    }

    public Collection<Contenu> get5Demos(int depart) {
        Query q = em.createQuery("select c from Contenu c where c.typeContenu=1 order by c.id");
        q.setFirstResult(depart);
        q.setMaxResults(5);
        return q.getResultList();
    }
     
    public Collection<Contenu> get5Tutos(int depart) {
        Query q = em.createQuery("select c from Contenu c where c.typeContenu=2 order by c.id");
        q.setFirstResult(depart);
        q.setMaxResults(5);
        return q.getResultList();
    }
    
    public int supprimerContenu(String id){
        Query q = em.createQuery("delete from Contenu c where c.id='"+id+"'");
        int nbsup = q.executeUpdate();
        return nbsup;
    }
   
}
