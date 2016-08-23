/**
 * Created by 泽宏 on 2016/8/22.
 */


var cartApp = angular.module("cartApp",[]);

cartApp.controller("cartCtrl",function ($scope, $http){

    $scope.refreshCart = function(cartID){
       $http.get("/e-MusicStore/rest/cart/"+cartID).success(function (data) {
           $scope.cart = data;
       });
    };

    $scope.clearCart = function(){
        $http.delete("/rest/cart/"+$scope.cartID).success($scope.refreshCart($scope.cartID))
    };

    $scope.initCartID = function (cartID) {
        $scope.cartID = cartID;
        $scope.refreshCart(cartID);
    };

    $scope.addToCart = function (productID) {
        $http.put("/rest/cart/add/" + productID).success(function(data){
            $scope.refreshCart($http.get("/rest/cart/cartID"))
            alert("Product Successfully Added To the Cart!")
        });
    };

    $scope.removeFromCart = function (productID) {
        $http.put("/rest/cart/remove/"+productID).success(function (data) {
            $scope.refreshCart($http.get("/rest/cart/cartID"))
        });
    };

} );

