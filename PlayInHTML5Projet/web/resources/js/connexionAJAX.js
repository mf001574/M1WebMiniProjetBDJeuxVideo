$(document).ready(function () {
    $('#formConnexion').on('submit',function(){
        $.ajax({
            url : 'connexion',
            type : 'POST',
            dataType : 'json',
            data : {action: 'connexion', login:'toto'},
            timeout: 5000,
            success : function(objJSON, statut){ // success est toujours en place, bien sûr !
               alert(objJSON.login);
               alert(objJSON.mdp);
               return false;
            },

            error : function(objJSON, statut, erreur){
                alert('erreur!');
                return false;
            }

        });
    });
    
});

