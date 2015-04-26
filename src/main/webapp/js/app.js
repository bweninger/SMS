/**
 * Julio Cesar Maciel
 */

function produtos($scope, $http) {
    $http.get('http://localhost:8080/loja/produtos/listar.html').
        success(function(data) {
            $scope.produtos = data;
        });
}

