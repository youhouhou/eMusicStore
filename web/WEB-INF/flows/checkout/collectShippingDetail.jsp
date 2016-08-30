<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@include file="/WEB-INF/views/templete/header.jsp"%>


<div class="container-wrapper">

    <div class="container">
        <div class="page-header">
            <h1>Customer</h1>
            <p class="lead">Customer Detrails:</p>
        </div>

        <form:form commandName="order" class="form-horizontal">



        <h3>Shipping Address</h3>

        <div class="form-group">
            <label for="apartmentNumber">Apartment Number</label>
            <form:input path="cart.customer.shippingAddress.apartmentNumber" id="apartmentNumber" class="form-Control"/>
        </div>

        <div class="form-group">
            <label for="streetName">Street Name</label>
            <form:input path="cart.customer.shippingAddress.streetName" id="streetName" class="form-Control"/>
        </div>

        <div class="form-group">
            <label for="city">City</label>
            <form:input path="cart.customer.shippingAddress.city" id="city" class="form-Control"/>
        </div>

        <div class="form-group">
            <label for="state">State</label>
            <form:input path="cart.customer.shippingAddress.state" id="state" class="form-Control"/>
        </div>

        <div class="form-group">
            <label for="country">Country</label>
            <form:input path="cart.customer.shippingAddress.country" id="country" class="form-Control"/>
        </div>

        <div class="form-group">
            <label for="zipCode">Zip Code</label>
            <form:input path="cart.customer.shippingAddress.zipCode" id="zipCode" class="form-Control"/>
        </div>

        <input type="hidden" name="_flowExecutionKey"/>


        <br><br>

        <button class="btn btn-default" name="_eventId_backToCollectCustomerInfo">Back</button>
        <input type="submit" value="Next" class="btn btn-default" name="_eventId_shippingDetailCollected"/>
        <button class="btn btn-default" name="_eventId_cancel">Cancel</button>

        </form:form>

        <%@include file="/WEB-INF/views/templete/footer.jsp"%>


