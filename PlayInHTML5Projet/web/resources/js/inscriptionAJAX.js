$(document).ready(function () {
    $('#formInscription').on('submit',function(){
        if($('#mdpI').val()== $('#confirmI').val()){
         $.ajax({
            url : 'connexion',
            type : 'POST',
            dataType : 'json',
            data : {action: 'inscription', login:$('#idI').val(), mdp:$('#mdpI').val(),mdpAdmin:$('#adminI').val()},
            timeout: 5000,
            success : function(objJSON, statut){
             $('#msgInscription').show();
             $('#msgInscription').html(objJSON.message);
            },

            error : function(objJSON, statut, erreur){
              alert('La requête AJAX a rencontrée un problème');
            }

        });
        }else{
             $('#msgInscription').show();
             $('#msgInscription').html("Diff&eacute;rents mots de passe");
        }
        return false;
    });
    
});

