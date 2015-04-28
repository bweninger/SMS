/**
 * Julio Cesar Maciel
 */

function produtos($scope, $http) {
    $http.get('/loja/produtos/listar.html').
        success(function (data) {
            $scope.produtos = data;
        });
}

function comprar(idProduto, preco) {
    var compra = {
        produto: {
            id: idProduto,
            preco: preco
        },
        quantidade: 1
    }

    var compraJson = JSON.stringify(compra)

    jQuery.ajax({
        type: "POST",
        url: "/loja/pedidos/incluirProduto.html",
        data: compraJson,
        contentType: "application/json;charset=utf-8",
        success: function () {
            alert('Produto adicionado no carrinho.');
        }
    });
}

function fecharPedido() {
    jQuery.ajax({
        type: "POST",
        url: "/loja/pedidos/fecharPedido.html",
        success: function () {
            alert('Pedido fechado com sucesso.');
            window.location.href = "/loja/cadastro.jsp"
        }
    });
}

function incluiDadosCliente(){
    var nome = jQuery("#nome").val();
    var email = jQuery("#email").val();
    var cpf = jQuery("#cpf").val();
    var form = {
        nome : nome,
        email : email,
        cpf : cpf
    }

    var json = JSON.stringify(form);

    jQuery.ajax({
        type: "POST",
        url: "/loja/clientes/incluirDados.html",
        data: json,
        contentType: "application/json;charset=utf-8",
        success: function (data) {
            alert('Dados informados com sucesso.');
            window.location.href = "/loja/endereco.jsp?idCliente=" + data.id;
        }
    });
}

function incluirEndereco(){
    var logradouro = jQuery("#logradouro").val();
    var numero = jQuery("#numero").val();
    var complemento = jQuery("#complemento").val();
    var cep = jQuery("#cep").val();
    var form = {
        logradouro : logradouro,
        numero : numero,
        complemento : complemento,
        cep : cep
    }

    var idCliente = window.location.href.split("idCliente=")[1];
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