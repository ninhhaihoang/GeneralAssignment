<%--
  Created by IntelliJ IDEA.
  User: ninhh
  Date: 7/13/2022
  Time: 10:22 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="<c:url value="/css/bootstrap-5.1.3-dist/css/bootstrap.min.css" />" />
    <link rel="stylesheet" href="<c:url value="/css/fontawesome-free-6.0.0-web/css/all.min.css" />" />
    <script src="<c:url value="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js" />"></script>
    <style>
        .form-group {
            padding: 10px 0;
        }
    </style>
    <title>Computer</title>
</head>
<body>

<div class="container-fluid">
    <div class="row header" style="background-color: rgb(66, 64, 81); padding: 10px">
        <div class="col col-md-6">
            <!-- big header -->
            <div class="btn-group" role="group" aria-label="...">
                <a type="button" class="btn btn-secondary" href="<c:url value="home.jsp" />" style="background-color: rgb(66, 64, 81); border: 0;">Home</a>
                <a type="button" class="btn btn-secondary" href="<%=request.getContextPath()%>/computers/list?pageNumber=1" style="background-color: rgb(66, 64, 81); border: 0;">Computer</a>
                <a type="button" class="btn btn-secondary" href="<%=request.getContextPath()%>/customers/list?pageNumber=1" style="background-color: rgb(66, 64, 81); border: 0;">Customer</a>
                <a type="button" class="btn btn-secondary" href="<%=request.getContextPath()%>/services/list?pageNumber=1"
                   style="background-color: rgb(66, 64, 81); border: 0;">Service</a>
            </div>
        </div>
        <div class="col col-md-6 justify-content-end flex-row" style="display: flex;">
            <!-- adding new button here  -->

        </div>
    </div>
    <c:if test="${computer == null}">
        <h1 style="color:rgb(66, 64, 81); text-align: center;">Add Computer</h1>
    </c:if>
    <c:if test="${computer != null}">
        <h1 style="color:rgb(66, 64, 81); text-align: center;">Edit Computer</h1>
    </c:if>

    <div class="container"
         style="width: 500px; background-color: rgb(66, 64, 81); border-radius: 10px; padding: 30px; color: white;">
        <c:if test="${computer != null}">
            <form method="post" action="edit-process" onsubmit="return submitForm();">
        </c:if>
        <c:if test="${computer == null}">
            <form method="post" action="add-process" onsubmit="return submitForm();">
        </c:if>
            <c:if test="${errorMessage != null}">
                <span class="text-danger" id="computer_add_error"><c:out value="${errorMessage}"/> </span>
            </c:if>
            <div class="form-group">
                <label for="computerCode">Code</label>
                <c:if test="${computer != null}">
                    <input type="text" class="form-control" id="computerCode" readonly="readonly" name="computerCode"
                           value="<c:out value="${computer.computerCode}"/>" placeholder="Enter computer code">
                </c:if>
                <c:if test="${computer == null}">
                    <input type="text" class="form-control" id="computerCode" name="computerCode"
                           value="<c:out value="${computer.computerCode}"/>" placeholder="Enter computer code">
                </c:if>
                <span class="text-danger" id="computer_code_error"></span>
            </div>
            <div class="form-group">
                <label for="location">Location</label>
                <input type="text" class="form-control" id="location" name="location"
                       value="<c:out value="${computer.location}"/>"placeholder="Enter location">
            </div>
            <div class="form-group">
                <label for="status">Status</label>
                <input type="text" class="form-control" id="status" name="status"
                       value="<c:out value="${computer.status}"/>"placeholder="Enter status">
            </div>
            <button type="submit" class="btn btn-primary">Submit</button>
            <a type="button" class="btn btn-danger" href="<%=request.getContextPath()%>/computers/list?pageNumber=1">Cancel</a>
        </form>
    </div>
</div>

<script src="<c:url value="/js/addComputerValidate.js" />"></script>
<script src="<c:url value="/css/bootstrap-5.1.3-dist/js/bootstrap.bundle.min.js" />"></script>
<!-- jQuery library -->
<script src="<c:url value="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js" />"></script>
</body>
</html>
