<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@include file="/WEB-INF/views/templete/header.jsp"%>



<div class="container-wrapper">

    <div class="container">
        <div class="page-header">
            <h1>Edit Product</h1>
            <p class="lead">Please update product information here:</p>
        </div>

        <form:form action="${pageContext.request.contextPath}/admin/productInventory/editProduct"
                   method="post" commandName="product" enctype="multipart/form-data">
            <!-- assign the id back to product!! since you didn't type the value before -->
            <form:hidden path="productID" value="${product.productID}"></form:hidden>



        <div class="form-group">
            <label for="name">Name</label>
            <form:input path="productName" id="name" class="form-Control" value="${product.productName}"/>
        </div>

        <div class="form-group">
            <label for="Category">Category</label>
            <label class="checkbox-inline"><form:radiobutton path="productCategory" id="category"
                                                             value="instrument"></form:radiobutton> Instrument </label>
            <label class="checkbox-inline"><form:radiobutton path="productCategory" id="category"
                                                             value="record"></form:radiobutton> Record </label>
            <label class="checkbox-inline"><form:radiobutton path="productCategory" id="category"
                                                             value="accessory"></form:radiobutton> Accessory </label>
        </div>

        <div class="form-group">
            <label for="description">Description</label>
            <form:textarea path="productDescription" id="description" class="form-Control" value="${product.productDescription}"/>
        </div>

        <div class="form-group">
            <label for="price">Price</label>
            <form:input path="productPrice" id="price" class="form-Control" value="${product.productPrice}"/>
        </div>

        <div class="form-group">
            <label for="condition">Condition</label>
            <label class="checkbox-inline"><form:radiobutton path="productCondition" id="condition"
                                                             value="new"></form:radiobutton> New </label>
            <label class="checkbox-inline"><form:radiobutton path="productCondition" id="condition"
                                                             value="used"></form:radiobutton> Used </label>
        </div>

        <div class="form-group">
            <label for="unitInStock">Unit In Stock</label>
            <form:input path="unitInStock" id="unitInStock" class="form-Control"  value="${product.unitInStock}"/>
        </div>

        <div class="form-group">
            <label for="manufacturer">Manufacturer</label>
            <form:input path="productManufacturer" id="manufacturer" class="form-Control" value="${product.productManufacturer}"/>
        </div>

        <div class="form-group">
            <label class="control-label" for="productImage">Upload Picture</label>
            <form:input id="productImage"  path="productImage" type="file" class="form:input-large"/>
        </div>

        <br><br>

        <input type="submit" value="Submit" class="btn btn-default">
        <a href="<c:url value="/admin/productInventory"/> " class="btn btn-default">Cancel</a>
        </form:form>

        <%@include file="/WEB-INF/views/templete/footer.jsp"%>


