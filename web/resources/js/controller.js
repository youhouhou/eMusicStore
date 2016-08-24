/**
 * Created by YANG on 8/23/2016.
 */
angular.module('cartApp', []);

angular.module('cartApp').controller('cartCtrl', CartCtrl);

CartCtrl.$inject = ['$http'];

function CartCtrl($http) {
    var vm = this;

    vm.refreshCart = function (cartId) {
        $http.get('/rest/cart/' + vm.cartId).success(function (data) {
            vm.cart = data;
        });
    };

    vm.clearCart = function () {
        $http.delete('/rest/cart/' + vm.cartId).success(function() {
            vm.refreshCart(vm.cartId);
        });
    };

    vm.initCartId = function (cartId) {
        vm.cartId = cartId;
        vm.refreshCart(cartId);
    };

    vm.addToCart = function (productId) {
        $http.put('/rest/cart/add/' + productId).success(function (data) {
            alert("Product successfully added to the cart!");
        });
    };

    vm.removeFromCart = function (productId) {
        $http.put('/rest/cart/remove/' + productId).success(function (data) {
            alert("Product successfully removed to the cart!");
        });
    }
}