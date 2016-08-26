<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="/WEB-INF/views/templete/header.jsp"%>


<div class="container-wrapper">

    <div class="container">
        <div class="page-header">
            <h1>Product Detail</h1>

            <p class="lead">Here is the product detail.</p>
        </div>

        <div class="container" ng-app="cartApp">
            <div class="row">
                <div class="col-md-6">
                    <img src="<c:url value="/resources/images/${product.productID}.png"/>" alt="image" style="width: 100%;" alt="image"/>
                </div>

                <div class="col-md-6">
                    <h3>${product.productName}</h3>
                    <p>${product.productDescription}</p>
                    <p>
                        <strong>Manufacture</strong> : ${product.productManufacturer}
                    </p>
                    <p>
                        <strong>Category</strong> : ${product.productCategory}
                    </p>
                    <p>
                        <strong>Condition</strong> : ${product.productCondition}
                    </p>
                    <p>
                        <strong>Price</strong> : ${product.productPrice} USD
                    </p>

                    <br>

                    <%--TODO:??????????????????????????????????????????????????--%>
                    <c:set var="role" scope="page" value="${param.role}"/>
                    <c:set var="url" scope="page" value="/product/productList"/>
                    <c:if test="${role='admin'}">
                        <c:set var="url" scope="page" value="/admin/productInventory"/>
                    </c:if>

                    <p ng-controller="cartCtrl as myCtrl">
                        <a href="<c:url value="${url}"/>" class="btn btn-default">Back</a>
                        <a href="#" class="btn btn-warning btn-large" ng-click="myCtrl.addToCart('${product.productID}')">
                            <span class="glyphicon glyphicon-shopping-cart"></span>
                            Order Now</a>

                        <a href="<spring:url value="/customer/cart"/>" class="btn btn-default">
                            <span class="glyphicon glyphicon-hand-right"></span>
                            View Cart</a>
                    </p>
                </div>
            </div>
        </div>

        <script src="<c:url value="/resources/js/controller.js"/>"></script>
        <%@include file="/WEB-INF/views/templete/footer.jsp"%>
