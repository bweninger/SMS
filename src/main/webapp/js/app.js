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
    var json = {
        nome : nome,
        email : email,
        cpf : cpf
    }

    jQuery.ajax({
        type: "POST",
        url: "/loja/clientes/incluirDados.html",
        data: json,
        contentType: "application/json;charset=utf-8",
        success: function () {
            alert('Dados informados com sucesso.');
        }
    });

}