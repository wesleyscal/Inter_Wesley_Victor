$(function menuDropdown_Categorias(){

    $('#categoria-menu').click(function(){

        $('#menu-dropdown').fadeToggle(500);

    });

});

$(function mascarasForm_Usuario(){
    $("#input-nascimento").mask("99/99/9999");
    $(".input-celular").mask("(99) 99999-9999");
    $("#input-cpf").mask("999.999.999-99");
 });

 $(function mascarasForm_Empresas(){
    $(".input-cep-empresa").mask("99999-999");
    $(".input-cnpj").mask("99.999.999/9999-99");
 });