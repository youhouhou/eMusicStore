<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@include file="/WEB-INF/views/templete/header.jsp"%>


<div class="container-wrapper">

    <div class="container">
        <div class="page-header">
            <h1>Add Product</h1>
            <p class="lead">Fill the below information to add a product:</p>
        </div>

        <form:form action="${pageContext.request.contextPath}/admin/product/addProduct"
                   method="post" commandName="product" enctype="multipart/form-data">
        <div class="form-group">
            <label for="name">Name</label>&nbsp;&nbsp;<form:errors path="productName" cssStyle="color: #b92c28 "/>
            <form:input path="productName" id="name" class="form-Control"/>
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
            <form:textarea path="productDescription" id="description" class="form-Control"/>
        </div>

        <div class="form-group">
            <label for="price">Price</label>&nbsp;&nbsp;<form:errors path="productPrice" cssStyle="color: #b92c28 "></form:errors>
            <form:input path="productPrice" id="price" class="form-Control"/>
        </div>

        <div class="form-group">
            <label for="condition">Condition</label>
            <label class="checkbox-inline"><form:radiobutton path="productCondition" id="condition"
                                                             value="new"></form:radiobutton> New </label>
            <label class="checkbox-inline"><form:radiobutton path="productCondition" id="condition"
                                                             value="used"></form:radiobutton> Used </label>
        </div>

        <div class="form-group">
            <label for="unitInStock">Unit In Stock</label>&nbsp;&nbsp;<form:errors path="unitInStock" cssStyle="color: #b92c28 "></form:errors>
            <form:input path="unitInStock" id="unitInStock" class="form-Control"/>
        </div>

        <div class="form-group">
            <label for="manufacturer">Manufacturer</label>
            <form:input path="productManufacturer" id="manufacturer" class="form-Control"/>
        </div>

        <div class="form-group">
            <label class="control-label" for="productImage">Upload Picture</label>
            <form:input id="productImage"  path="productImage" type="file" class="form:input-large"/>
        </div>

        <br><br>

        <input type="submit" value="Submit" class="btn btn-default">
        <a href="<c:url value="/admin/productInventory"/> " class="btn btn-default">Cancel</a>

        <input type="hidden"  name="${_csrf.parameterName}" value="${_csrf.token}"/>

        </form:form>

        <%@include file="/WEB-INF/views/templete/footer.jsp"%>


