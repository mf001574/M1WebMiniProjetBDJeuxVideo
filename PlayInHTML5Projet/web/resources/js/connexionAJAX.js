$(document).ready(function () {
    $('#formConnexion').on('submit',function(){
        $.ajax({
            url : 'connexion',
            type : 'POST',
            dataType : 'json',
            data : {action: 'connexion', login:$('#idC').val(), mdp:$('#mdpC').val()},
            timeout: 5000,
            success : function(objJSON, statut){ // success est toujours en place, bien sûr !
               if(objJSON.login === undefined){
                   $('#msgConnexion').append("Utilisateur inconnu ou mot de passe incorrect");
               }else{
                   $('#msgConnexion').append("Bienvenue "+ objJSON.login);
               }
               alert("ppp");
            },

            error : function(objJSON, statut, erreur){
                alert('La requête AJAX a rencontrée un problème');
            }

        });
        return false;
    });
    
});

