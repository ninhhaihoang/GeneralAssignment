<%--
  Created by IntelliJ IDEA.
  User: ninhh
  Date: 7/13/2022
  Time: 10:30 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="<c:url value="/css/bootstrap-5.1.3-dist/css/bootstrap.min.css" />"/>
    <link rel="stylesheet" href="<c:url value="/css/fontawesome-free-6.0.0-web/css/all.min.css" />"/>
    <script src="<c:url value="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js" />"></script>
    <style>
        .form-group {
            padding: 10px 0;
        }
    </style>
    <title>Customer</title>
</head>
<body>

<div class="container-fluid">
    <div class="row header" style="background-color: rgb(66, 64, 81); padding: 10px">
        <div class="col col-md-6">
            <!-- big header -->
            <div class="btn-group" role="group" aria-label="...">
                <a type="button" class="btn btn-secondary" href="<c:url value="home.jsp" />"
                   style="background-color: rgb(66, 64, 81); border: 0;">Home</a>
                <a type="button" class="btn btn-secondary"
                   href="<%=request.getContextPath()%>/computers/list?pageNumber=1"
                   style="background-color: rgb(66, 64, 81); border: 0;">Computer</a>
                <a type="button" class="btn btn-secondary"
                   href="<%=request.getContextPath()%>/customers/list?pageNumber=1"
                   style="background-color: rgb(66, 64, 81); border: 0;">Customer</a>
                <a type="button" class="btn btn-secondary" href="<%=request.getContextPath()%>/services/list?pageNumber=1"
                   style="background-color: rgb(66, 64, 81); border: 0;">Service</a>
            </div>
        </div>
        <div class="col col-md-6 justify-content-end flex-row" style="display: flex;">
            <!-- adding new button here  -->

        </div>
    </div>
    <c:if test="${customer == null}">
        <h1 style="color:rgb(66, 64, 81); text-align: center;">Add Customer</h1>
    </c:if>
    <c:if test="${customer != null}">
        <h1 style="color:rgb(66, 64, 81); text-align: center;">Edit Customer</h1>
    </c:if>

    <div class="container"
         style="width: 500px; background-color: rgb(66, 64, 81); border-radius: 10px; padding: 30px; color: white;">
        <c:if test="${customer != null}">
            <form method="post" action="edit-process" onsubmit="return submitForm();">
        </c:if>
        <c:if test="${customer == null}">
            <form method="post" action="add-process" onsubmit="return submitForm();">
        </c:if>
                <c:if test="${errorMessage != null}">
                    <span class="text-danger" id="customer_add_error"><c:out value="${errorMessage}"/> </span>
                </c:if>
                <div class="form-group">
                    <label for="customerCode">Code</label>
                    <c:if test="${customer != null}">
                        <input type="text" class="form-control" id="customerCode" readonly="readonly"
                               name="customerCode"
                               value="<c:out value="${customer.customerCode}"/>" placeholder="Enter customer code">
                    </c:if>
                    <c:if test="${customer == null}">
                        <input type="text" class="form-control" id="customerCode" name="customerCode"
                               value="<c:out value="${customer.customerCode}"/>" placeholder="Enter customer code">
                    </c:if>
                    <span class="text-danger" id="customer_code_error"></span>
                </div>
                <div class="form-group">
                    <label for="fullName">Full name</label>
                    <input type="text" class="form-control" id="fullName" name="fullName"
                           value="<c:out value="${customer.fullName}"/>" placeholder="Enter full name">
                </div>
                <div class="form-group">
                    <label for="address">Address</label>
                    <input type="text" class="form-control" id="address" name="address"
                           value="<c:out value="${customer.address}"/>" placeholder="Enter address">
                </div>
                <div class="form-group">
                    <label for="phone">Phone</label>
                    <input type="text" class="form-control" id="phone" name="phone"
                           value="<c:out value="${customer.phone}"/>" placeholder="Enter phone">
                    <span class="text-danger" id="phone_error"></span>
                </div>
                <div class="form-group">
                    <label for="email">Email</label>
                    <input type="text" class="form-control" id="email" name="email"
                           value="<c:out value="${customer.email}"/>" placeholder="Enter email">
                    <span class="text-danger" id="email_error"></span>
                </div>
                <button type="submit" class="btn btn-primary">Submit</button>
                <button type="button" class="btn btn-danger">Cancel</button>
            </form>
    </div>
</div>

<script src="<c:url value="/js/addCustomerValidate.js" />"></script>
<script src="<c:url value="/css/bootstrap-5.1.3-dist/js/bootstrap.bundle.min.js" />"></script>
<!-- jQuery library -->
<script src="<c:url value="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js" />"></script>
</body>
</html>
