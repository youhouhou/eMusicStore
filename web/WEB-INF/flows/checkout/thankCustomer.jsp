<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="/WEB-INF/views/templete/header.jsp" %>

<div class="container-wrapper">
    <div class="container">
        <section>
            <div class="jumbotron">
                <div class="container">
                    <h1>Thank you for your money!</h1>
                    <p>Your order will be shipped in TWO business days!</p>
                </div>
            </div>
        </section>

        <section class="container" >
            <p>
                <a href="<spring:url value="/"/>" class="btn btn-default">OK</a>
            </p>
        </section>
    </div>
</div>

<%@include file="/WEB-INF/views/templete/footer.jsp" %>