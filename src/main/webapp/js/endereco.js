/**
 * Created by BWeninger on 23/05/2015.
 */
$(document).ready(function () {
    var idCliente = window.location.href.split("idCliente=")[1];
    $("#idCliente").val(idCliente);

    var cliente = {
        id: idCliente
    }

    $.ajax({
        url: "/loja/clientes/buscarEnderecos.html",
        type: "POST",
        data: JSON.stringify(cliente),
        contentType: "application/json;charset=utf-8",
        success: function (data) {
            $.each(data, function(k,v){
                var row = $("<tr>");
                var radioId = 'radio_' + v.idEndereco;
                var radio = $("<input type='radio' id='" + radioId + "'/>");
                var logradouro = $("<td>").text(v.logradouro);
                var nro = $("<td>").text(v.numero);
                var complemento = $("<td>").text(v.complemento);
                var cep = $("<td>").text(v.cep);
                row.append(radio).append(logradouro).append(nro).append(complemento).append(cep);
                $("#tabelaEnderecos").find("tbody").append(row)
            });
        }
    })
});

function incluirEndereco() {
    var logradouro = jQuery("#logradouro").val();
    var numero = jQuery("#numero").val();
    var complemento = jQuery("#complemento").val();
    var cep = jQuery("#cep").val();
    var form = {
        logradouro: logradouro,
        numero: numero,
        complemento: complemento,
        cep: cep
    }

    var idCliente = $("#idCliente").val();
    var json = JSON.stringify(form);

    jQuery.ajax({
        type: "POST",
        url: "/loja/clientes/incluirNovoEndereco/" + idCliente + ".html",
        data: json,
        contentType: "application/json;charset=utf-8",
        success: function (cliente) {
            jQuery.ajax({
                type: "POST",
                url: "/loja/pedidos/selecionarDadosEntrega/" + cliente.id + "/" + cliente.enderecos[0].idEndereco + ".html",
                success: function () {
                    jQuery.ajax({
                        type: "POST",
                        url: "/loja/pedidos/selecionarPagamento/1.html",
                        success: function () {
                            jQuery.ajax({
                                type: "POST",
                                url: "/loja/pedidos/concluirPedido.html",
                                success: function (codigoPedido) {
                                    window.location.href = "/loja/pedidos/gerarBoleto/" + codigoPedido + ".html";
                                }
                            });
                        }
                    });
                }
            });
        }
    });
}