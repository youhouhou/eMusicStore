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

        <h3>Basic Info</h3>


        <div class="form-group">
            <label for="name">Name</label>
            <form:input path="cart.customer.customerName" id="name" class="form-Control"/>
        </div>

        <div class="form-group">
            <label for="email">Email</label>
            <form:input path="cart.customer.customerEmail" id="email" class="form-Control"/>
        </div>

        <div class="form-group">
            <label for="phone">Phone</label>
            <form:input path="cart.customer.customerPhone" id="phone" class="form-Control"/>
        </div>

        <input type="hidden" name="_flowExecutionKey"/>


        <br><br>

        <input type="submit" value="Next" class="btn btn-default" name="_eventId_customerInfoCollected"/>
        <button class="btn btn-default" name="_eventId_cancel">Cancel</button>

        </form:form>

        <%@include file="/WEB-INF/views/templete/footer.jsp"%>


