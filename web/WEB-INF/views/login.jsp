<%@include file="/WEB-INF/views/templete/header.jsp"%>



<div class="container-wrapper">
    <div class="login-container">
        <div id="login-box">
            <h2>Welcom Back! Please Login~</h2>

            <c:if test="${not empty msg}">
                <div class="logout" style="color: #309dff;">${msg}</div>
                <br>
            </c:if>

            <c:url value=" ${request.contextPath}/j_spring_security_check" var="loginUrl" />

            <form name="loginForm" action="${loginUrl}"  method="post">
                <c:if test="${not empty error}">
                    <div class="error" style="color: #ff0000;">${error}</div>
                    <br>
                </c:if>
                <div class="form-group">
                    <label for="username">User: </label>
                    <input type="text" id="username" name="username" class="form-control"/>
                </div>
                <div class="form-group">
                    <label for="password">Password: </label>
                    <input type="password" id="password" name="password" class="form-control"/>
                </div>


                <input type="submit" value="Submit" class="btn btn-success"/>
                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>

            </form>

        </div>
    </div>

</div>



<%@include file="/WEB-INF/views/templete/footer.jsp"%>