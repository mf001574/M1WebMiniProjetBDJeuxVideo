$(document).ready(function () {
        $('#formConnexion').hide();
        $('#formInscription').hide();
        $('#affichageConnexion').click(function(){
            $('#formConnexion').slideToggle("slow")
        });
        $('#affichageInscription').click(function(){
            $('#formInscription').slideToggle("slow")
        });
        $('#msgConnexion').hide();
        $('#msgInscription').hide();
        $('.lienCache').hide();
});
