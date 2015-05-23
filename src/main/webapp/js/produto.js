$(document).ready(function () {
    var idProduto = window.location.href.split("idProduto=")[1]

    $.ajax({
            url: "/loja/produtos/detalhes/" + idProduto + ".html",
            type: "GET",
            success: function (produtoJson) {
                $("#tituloProduto").text(produtoJson.nome);
                $("#descricaoProduto").text(produtoJson.descricao);
                var img = $("<img>").attr("src", "/loja/" + produtoJson.urlFoto).attr("alt", produtoJson.nome).
                    css('height', 'auto').css('max-width', '100%');
                $("#imagemProduto").append(img);

                var precoHtml = $("<h3>").text("R$ " + produtoJson.precoStr);
                $("#imagemProduto").append(precoHtml);
            }
        }
    )

    $("#btnAddCart").click(function () {
        var compra = {
            produto: {
                id: idProduto
            },
            quantidade: 1
        }

        var compraJson = JSON.stringify(compra);

        jQuery.ajax({
            type: "POST",
            url: "/loja/pedidos/incluirProduto.html",
            data: compraJson,
            contentType: "application/json;charset=utf-8",
            success: function () {
                alert('Produto adicionado no carrinho.');
                window.location.href = "/loja/";
            }
        });
    });
});
