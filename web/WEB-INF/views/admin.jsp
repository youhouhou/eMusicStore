<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<%@include file="/WEB-INF/views/templete/header.jsp"%>


<!-- Marketing messaging and featurettes
================================================== -->
<!-- Wrap the rest of the page in another container to center all the content. -->

<div class="container-wrapper">

    <div class="container">
        <div class="page-header">
            <h1>Administrator Page</h1>
            <p class="lead">This is the administrator page </p>
        </div>

        <c:if test="${pageContext.request.userPrincipal.name != null}">
            <h3>Welcome: ${pageContext.request.userPrincipal.name} | <a href="<c:url
            value="/logout"/> ">Logout</a>
                </h3>
        </c:if>

        <h3>
            <a href="<c:url value="/admin/productInventory"/> ">Product Inventory</a>
        </h3>

        <p>
            Here you can view, check and modify the product inventory
        </p>



        <%@include file="/WEB-INF/views/templete/footer.jsp"%>


