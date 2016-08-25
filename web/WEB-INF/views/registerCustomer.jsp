<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@include file="/WEB-INF/views/templete/header.jsp"%>


<div class="container-wrapper">

    <div class="container">
        <div class="page-header">
            <h1>Register Customer</h1>
            <p class="lead">Please fill in your information:</p>
        </div>

        <form:form action="${pageContext.request.contextPath}/register"
                   method="post" commandName="customer">

        <h3>Basic Info</h3>


        <div class="form-group">
            <label for="name">Name</label>
            <form:input path="customerName" id="name" class="form-Control"/>
        </div>

        <div class="form-group">
            <label for="email">Email</label>
            <form:input path="customerEmail" id="email" class="form-Control"/>
        </div>

        <div class="form-group">
            <label for="phone">Phone</label>
            <form:input path="customerPhone" id="phone" class="form-Control"/>
        </div>

        <div class="form-group">
            <label for="username">User Name</label>
            <form:input path="username" id="username" class="form-Control"/>
        </div>

        <div class="form-group">
            <label for="password">Password</label>
            <form:input path="password" id="password" class="form-Control"/>
        </div>

        <h3>Shipping Address</h3>

        <div class="form-group">
            <label for="apartmentNumber">Apartment Number</label>
            <form:input path="shippingAddress.apartmentNumber" id="apartmentNumber" class="form-Control"/>
        </div>

        <div class="form-group">
            <label for="streetName">Street Name</label>
            <form:input path="shippingAddress.streetName" id="streetName" class="form-Control"/>
        </div>

        <div class="form-group">
            <label for="city">City</label>
            <form:input path="shippingAddress.city" id="city" class="form-Control"/>
        </div>

        <div class="form-group">
            <label for="state">State</label>
            <form:input path="shippingAddress.state" id="state" class="form-Control"/>
        </div>

        <div class="form-group">
            <label for="country">Country</label>
            <form:input path="shippingAddress.country" id="country" class="form-Control"/>
        </div>

        <div class="form-group">
            <label for="zipCode">Zip Code</label>
            <form:input path="shippingAddress.zipCode" id="zipCode" class="form-Control"/>
        </div>

       <br><br>

        <input type="submit" value="Submit" class="btn btn-default">
        <a href="<c:url value="/"/> " class="btn btn-default">Cancel</a>

        </form:form>

        <%@include file="/WEB-INF/views/templete/footer.jsp"%>


