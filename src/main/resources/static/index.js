angular.module('app', []).controller('indexController', function ($scope, $http) {
    const contextPath = 'http://localhost:8189/app';

    $scope.loadProducts = function () {
        $http.get(contextPath + '/products')
            .then(function (response) {
                $scope.productsList = response.data;
            });
    };

    $scope.deleteProduct = function (Id) {
        $http.get(contextPath + '/products/delete/' + Id)
            .then(function (response) {
                $scope.loadProducts();
            });
    }

    $scope.createProduct = function (){
        $http.post(contextPath + '/products', $scope.newProduct)
            .then(function (response) {
                $scope.loadProducts()
            });
    }

    $scope.loadProducts();
});