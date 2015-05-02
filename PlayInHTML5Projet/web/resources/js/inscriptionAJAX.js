$(document).ready(function () {
    $('#formInscription').on('submit',function(){
        $.ajax({
            url : 'connexion',
            type : 'POST',
            dataType : 'json',
            data : {action: 'inscription', login:$('#idI').val(), mdp:$('#mdpI').val()},
            timeout: 5000,
            success : function(objJSON, statut){
             $('#msgInscription').show();
             $('#msgInscription').html(objJSON.message);
            },

            error : function(objJSON, statut, erreur){
              alert('La requête AJAX a rencontrée un problème');
            }

        });
        return false;
    });
    
});

