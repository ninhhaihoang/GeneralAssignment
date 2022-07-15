<%--
  Created by IntelliJ IDEA.
  User: ninhh
  Date: 7/12/2022
  Time: 3:49 PM
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
    <link rel="stylesheet" href="<c:url value="/css/listComputers.css" />" />
    <script src="<c:url value="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js" />"></script>
    <title>List Computers</title>
</head>
<body>
<div class="container-fluid">
    <div class="row header" style="background-color: rgb(66, 64, 81); padding: 10px">
        <div class="col col-md-6">
            <!-- big header -->
            <div class="btn-group" role="group" aria-label="...">
                <a type="button" class="btn btn-secondary" href="<c:url value="home.jsp" />" style="background-color: rgb(66, 64, 81); border: 0;">Home</a>
                <a type="button" class="btn btn-secondary" href="<c:url value="listComputers.jsp" />" style="background-color: rgb(66, 64, 81); border: 0;">Computer</a>
                <a type="button" class="btn btn-secondary" href="<c:url value="listCustomer.jsp" />" style="background-color: rgb(66, 64, 81); border: 0;">Customer</a>
                <a type="button" class="btn btn-secondary" href="<c:url value="listService.jsp" />" style="background-color: rgb(66, 64, 81); border: 0;">Service</a>
            </div>
        </div>
        <div class="col col-md-6 justify-content-end flex-row" style="display: flex;">
            <!-- adding new button here  -->
            <a class="btn btn-success" style="margin-left: 20px; width:200px" href="<c:url value="addComputer.jsp" />"><i
                    class="fas fa-plus-circle text-white"></i> Add New Computer</a>
        </div>
    </div>
            <h1 style="color:rgb(66, 64, 81); text-align: center;">Manage Computers</h1>
    <div class="row">
        <div class="container" style="padding: 10px 50px;">
            <div class="row">
                <!-- table here -->
                <table class="table table-striped">
                    <thead>
                    <tr>
                        <th>
                            Code
                        </th>
                        <th>
                            Location
                        </th>
                        <th>
                            Status
                        </th>
                    </tr>
                    </thead>
                    <tbody>
                    <tr>

                        <td>
                            Thomas Hardy
                        </td>
                        <td>
                            thomashardy@gmail.com
                        </td>
                        <td>
                            89 Chiarostuo Portland, USA
                        </td>

                        <td>
                            <i class="fa fa-pen text-warning " style="margin-right: 10px;"></i>
                            <i class="fa fa-trash-alt text-danger "></i>
                        </td>
                    </tr>
                    <tr>

                        <td>
                            Thomas Hardy
                        </td>
                        <td>
                            thomashardy@gmail.com
                        </td>
                        <td>
                            89 Chiarostuo Portland, USA
                        </td>
                        <td>
                            <i class="fa fa-pen text-warning" style="margin-right: 10px;"></i>
                            <i class="fa fa-trash-alt text-danger"></i>
                        </td>
                    </tr>
                    <tr>

                        <td>
                            Thomas Hardy
                        </td>
                        <td>
                            thomashardy@gmail.com
                        </td>
                        <td>
                            89 Chiarostuo Portland, USA
                        </td>

                        <td>
                            <i class="fa fa-pen text-warning " style="margin-right: 10px;"></i>
                            <i class="fa fa-trash-alt text-danger "></i>
                        </td>
                    </tr>
                    <tr>

                        <td>
                            Thomas Hardy
                        </td>
                        <td>
                            thomashardy@gmail.com
                        </td>
                        <td>
                            89 Chiarostuo Portland, USA
                        </td>

                        <td>
                            <i class="fa fa-pen text-warning " style="margin-right: 10px;"></i>
                            <i class="fa fa-trash-alt text-danger "></i>
                        </td>
                    </tr>
                    <tr>

                        <td>
                            Thomas Hardy
                        </td>
                        <td>
                            thomashardy@gmail.com
                        </td>
                        <td>
                            89 Chiarostuo Portland, USA
                        </td>

                        <td>
                            <i class="fa fa-pen text-warning " style="margin-right: 10px;"></i>
                            <i class="fa fa-trash-alt text-danger "></i>
                        </td>
                    </tr>
                    </tbody>
                </table>
            </div>
            <div class="row footer-container flex-row justify-content-between">
                <!-- pagination -->
                <div class="col col-md-6 align-items-center" style="display: flex;">
                    Showing &nbsp; <strong> 5 </strong>&nbsp; out of&nbsp; <strong> 25 </strong>&nbsp; entries
                </div>
                <div class="col col-md-6 justify-content-end flex-row" style="display: flex;">
                    <nav aria-label="...">
                        <ul class="pagination">
                            <li class="page-item disabled">
                                <a class="page-link">Previous</a>
                            </li>
                            <li class="page-item"><a class="page-link" href="#">1</a></li>
                            <li class="page-item" aria-current="page">
                                <a class="page-link" href="#">2</a>
                            </li>
                            <li class="page-item active"><a class="page-link" href="#">3</a></li>
                            <li class="page-item"><a class="page-link" href="#">4</a></li>
                            <li class="page-item"><a class="page-link" href="#">5</a></li>
                            <li class="page-item">
                                <a class="page-link" href="#">Next</a>
                            </li>
                        </ul>
                    </nav>
                </div>
            </div>
        </div>
    </div>
</div>

<script src="<c:url value="/css/bootstrap-5.1.3-dist/js/bootstrap.bundle.min.js" />"></script>
<!-- jQuery library -->
<script src="<c:url value="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js" />"></script>
</body>
</html>
