<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<%@include file="/WEB-INF/views/templete/header.jsp"%>


<!-- Marketing messaging and featurettes
================================================== -->
<!-- Wrap the rest of the page in another container to center all the content. -->

<div class="container-wrapper">

    <div class="container">
        <div class="page-header">
            <h1>Product Detail</h1>
            <p class="lead">Detail Information!</p>
        </div>

       <div class="container" ng-app="cartApp" ng-init = "initCartID(${pageContext.session.id})">

           {{cartID}}
           <div class="row">
               <div class="col-md-6">
                   <img src="<c:url value="/resources/images/${product.productID}.png"/> " alt="image" style="width: 100%;height: 300px"/>
               </div>

               <div class="col-md-6">
                   <h1>${product.productName}</h1>
                   <p>${product.productDescription}</p>
                   <p><strong>Manufacturer</strong> : ${product.productManufacturer}</p>
                   <p><strong>Category</strong> : ${product.productCategory}</p>
                   <p><strong>Condition</strong> : ${product.productCondition}</p>
                   <h4>${product.productPrice} USD</h4>
                   <br>
                   <c:set var="role" scope="page" value="${param.role}"/>
                   <c:set var="url" scope="page" value="/productList"/>
                   <c:if test="${role = 'admin'}">
                       <c:set var="url" scope="page" value="/admin/productInventory"/>
                   </c:if>

                   <p ng-controller="cartCtrl">
                       <a href="<c:url value="${url}"/> " class="btn btn-default">Back</a>
                       <a href="#" class="btn btn-warning btn-large"
                          ng-click="addToCart('${product.productID}')">
                           <span class="glyphicon glyphicon-shopping-cart"></span> Order Now!</a>
                       <a href="<spring:url value="/cart"/>" class="btn btn-default">
                           <span class="glyphicon glyphicon-hand-right"></span>View Cart</a>
                   </p>
               </div>
           </div>
       </div>

        <%@include file="/WEB-INF/views/templete/footer.jsp"%>


