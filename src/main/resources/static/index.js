angular.module('app', []).controller('indexController', function ($scope, $http) {
    const contextPath = 'http://localhost:8189/app';

    $scope.loadProduct = function () {
        $http.get(contextPath + '/product/all')
            .then(function (response) {
                $scope.productList = response.data;
            });
    };

    $scope.cardAdd = function (productId){
        $http({
            url: contextPath + '/card/add',
            method: 'GET',
            params: {
                productId: productId,
            }
        }).then(function (response){
            $scope.loadProduct();
        });
    };
    $scope.loadProduct();

    $scope.loadCard = function () {
            $http.get(contextPath + '/card/all')
                .then(function (response) {
                    $scope.cardList = response.data;
                    $scope.countCost();
                });
        };


    $scope.clearId = function (productId){
                $http({
                    url: contextPath + '/card/del',
                    method: 'GET',
                    params: {
                        productId: productId,
                    }
                }).then(function (response){
                    $scope.loadCard();
                });
            };

    $scope.countCost = function () {
                $http.get(contextPath + '/card/countCost')
                    .then(function (response) {
                        $scope.countCost = response.data;
               });
    };

    $scope.addProduct = function (name, price){
                $http({
                    url: contextPath + '/product/add',
                    method: 'GET',
                    params: {
                        name: name,
                        price: price,
                    }
                }).then(function (response){
                    $scope.loadProduct();
                });
            };

    $scope.countCost();
    $scope.loadCard();



});