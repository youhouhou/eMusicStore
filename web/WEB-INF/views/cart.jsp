<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="/WEB-INF/views/templete/header.jsp" %>

<div class="container-wrapper">
    <div class="container">
        <section>
            <div class="jumbotron">
                <div class="container">
                    <h1>Cart</h1>

                    <p>All the selected products in your shopping cart.</p>
                </div>
            </div>
        </section>

        <section class="container" ng-app="cartApp">
            <%--In CartItemController, already attach the "cartId" to the model, and bind the model to the cart.jsp view--%>
            <div ng-controller="cartCtrl as myCtrl" ng-init="myCtrl.initCartId('${cartId}')">
                <div>
                    <a class="btn btn-danger pull-left" ng-click="myCtrl.clearCart()"><span class="glyphicon glyphicon-remove"></span>Clear Cart</a>
                </div>

                <table class="table table-hover">
                    <tr>
                        <th>Product</th>
                        <th>Unit Price</th>
                        <th>Quantity</th>
                        <th>Price</th>
                        <th>Action</th>
                    </tr>

                    <tr ng-repeat="item in myCtrl.cart.cartItems">
                        <td>{{item.product.productName}}</td>
                        <td>{{item.product.productPrice}}</td>
                        <td>{{item.quantity}}</td>
                        <td>{{item.totalPrice}}</td>
                        <td><a href="#" class="label label-danger" ng-click="myCtrl.removeFromCart(item.product.productID)">
                            <span class="glyphicon glyphicon-remove"></span>
                            Remove</a></td>
                    </tr>

                    <tr>
                        <th></th>
                        <th></th>
                        <th>Grand total</th>
                        <th>{{calGrandTotal()}}</th>
                        <th></th>
                    </tr>
                </table>

                <a href="<spring:url value="/product/productList"/>" class="btn btn-default">Continue Shopping</a>
        </section>
    </div>
</div>
</div>

<script src="<c:url value="/resources/js/controller.js"/>"></script>
<%@include file="/WEB-INF/views/templete/footer.jsp" %>