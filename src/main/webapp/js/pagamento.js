$(document).ready(function () {
    $("#btn-selecionar").click(function () {
        var checked = $(":checked").val();

        if (checked == 2) {
            alert('O grupo responsavel pelo Banco nao disponibilizou o WebService a tempo da entrega.')
        } else {
            jQuery.ajax({
                type: "POST",
                url: "/loja/pedidos/selecionarPagamento/" + checked + ".html",
                success: function () {
                    if (checked == 1) {
                        jQuery.ajax({
                            type: "POST",
                            url: "/loja/pedidos/concluirPedido.html",
                            success: function (codigoPedido) {
                                window.location.href = "/loja/pedidos/gerarBoleto/" + codigoPedido + ".html";
                            }
                        });
                    }
                }
            });
        }
    });
});