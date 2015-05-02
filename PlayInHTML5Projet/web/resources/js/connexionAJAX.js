$(document).ready(function () {
    $('#formConnexion').on('submit',function(){
        $.ajax({
            url : 'connexion',
            type : 'POST',
            dataType : 'json',
            data : {action: 'connexion', login:$('#idC').val(), mdp:$('#mdpC').val()},
            timeout: 5000,
            success : function(objJSON, statut){ 
               $('#msgConnexion').show();
               if(objJSON.login === undefined){
                   $('#msgConnexion').html("Utilisateur inconnu ou mot de passe incorrect");
           
               }else{
                   $('#msgConnexion').html("<i class='fa fa-user'></i> Bienvenue "+ objJSON.login +
                     "<p> <form method='post' action='connexion'>"+ 
                     '<input type="hidden" name="action" value="deconnexion">'+
                     '<input type="submit" value="Se d&eacute;connecter"> </form></p>');
                   $('#formConnexion').hide();
                   $('#titreConnexion').hide();
                   $('#titreInscription').hide();
                   $('.lienCache').show("slow");
               }
            },

            error : function(objJSON, statut, erreur){
                alert('La requête AJAX a rencontrée un problème');
            }

        });
        return false;
    });
    
});

