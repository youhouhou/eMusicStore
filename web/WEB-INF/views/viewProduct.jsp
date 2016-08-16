<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

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

       <div class="container">
           <div class="row">
               <div class="col-md-6">
                   <img src="#" alt="image" style="width: 100%; height: 300px"/>
               </div>

               <div class="col-md-6">
                   <h1>${product.productName}</h1>
                   <p>${product.productDescription}</p>
                   <p><strong>Manufacturer</strong> : ${product.productManufacturer}</p>
                   <p><strong>Category</strong> : ${product.productCategory}</p>
                   <p><strong>Condition</strong> : ${product.productCondition}</p>
                   <h4>${product.productPrice}</h4>
               </div>
           </div>
       </div>

        <%@include file="/WEB-INF/views/templete/footer.jsp"%>


