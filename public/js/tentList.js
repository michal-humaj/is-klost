//runs when page is loaded -> bound to jQuery document ready function
function initKlostIS() {
    $(".linkDeleteTent").on('click', function(){
        var deleteUrl = $(this).attr('data-deleteUrl');
        var tentName = $(this).attr('data-tentName');
        $("#form").attr('action', deleteUrl);
        $("#headerTentDelete").text(tentName);
    });

    $("#modalDeleteTent").on('hidden.bs.modal', function () {
        setTimeout(function () {
            $(".linkDeleteTent").each(function () {
                this.blur();
            });
        }, 1);
    });
}
