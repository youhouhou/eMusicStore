<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@include file="/WEB-INF/views/templete/header.jsp"%>


<!-- Carousel================================================== -->
<div id="myCarousel" class="carousel slide" data-ride="carousel">
    <!-- Indicators -->
    <ol class="carousel-indicators">
        <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
        <li data-target="#myCarousel" data-slide-to="1"></li>
        <li data-target="#myCarousel" data-slide-to="2"></li>
    </ol>
    <div class="carousel-inner" role="listbox">
        <div class="item active">
            <img class="first-slide home-image" src="<c:url value="/resources/images/monkey.jpg"/> " alt="First slide">
            <div class="container">
                <div class="carousel-caption">
                    <h1>Welcome to Eric's Music Store</h1>
                    <p>take a look dude!</p>
                </div>
            </div>
        </div>
        <div class="item">
            <img class="second-slide home-image" src="<c:url value="/resources/images/water.jpg"/>" alt="Second slide">
            <div class="container">
                <div class="carousel-caption">
                    <h1>Welcome to Eric's Music Store</h1>
                    <p>take a look dude!</p>
                </div>
            </div>
        </div>
        <div class="item">
            <img class="third-slide home-image" src="<c:url value="/resources/images/city.jpg"/>" alt="Third slide">
            <div class="container">
                <div class="carousel-caption">
                    <h1>Welcome to Eric's Music Store</h1>
                    <p>take a look dude!</p>
                </div>
            </div>
        </div>
    </div>
    <a class="left carousel-control" href="#myCarousel" role="button" data-slide="prev">
        <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
        <span class="sr-only">Previous</span>
    </a>
    <a class="right carousel-control" href="#myCarousel" role="button" data-slide="next">
        <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
        <span class="sr-only">Next</span>
    </a>
</div><!-- /.carousel -->


<!-- Marketing messaging and featurettes
================================================== -->
<!-- Wrap the rest of the page in another container to center all the content. -->

<div class="container marketing">

    <!-- Three columns of text below the carousel -->
    <div class="row">
        <div class="col-lg-4">
            <a class="btn btn-default" href="<c:url value="/product/productList?searchCondition=instrument"/> "
               role="button">
                <img class="img-circle" src="<c:url value="/resources/images/city.jpg"/> " alt="Instrument img"
                     width="140" height="140">
            </a>
            <h2>Instument</h2>
            <p>Good Stuff!</p>
        </div><!-- /.col-lg-4 -->


        <div class="col-lg-4">
            <a class="btn btn-default" href="<c:url value="/product/productList?searchCondition=instrument"/> "
               role="button">
                <img class="img-circle" src="<c:url value="/resources/images/city.jpg"/> " alt="Instrument img"
                     width="140" height="140">
            </a>
            <h2>Instument</h2>
            <p>Good Stuff!</p>

        </div><!-- /.col-lg-4 -->

        <div class="col-lg-4">
            <a class="btn btn-default" href="<c:url value="/product/productList?searchCondition=instrument"/> "
               role="button">
                <img class="img-circle" src="<c:url value="/resources/images/city.jpg"/> " alt="Instrument img"
                     width="140" height="140">
            </a>
            <h2>Instument</h2>
            <p>Good Stuff!</p>
        </div><!-- /.col-lg-4 -->

    </div><!-- /.row -->

    <%@include file="/WEB-INF/views/templete/footer.jsp"%>
