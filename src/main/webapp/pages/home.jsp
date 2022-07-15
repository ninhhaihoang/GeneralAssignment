<%--
  Created by IntelliJ IDEA.
  User: ninhh
  Date: 7/13/2022
  Time: 9:16 AM
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
    <link rel="stylesheet" href="<c:url value="/css/home.css" />" />
    <title>Home</title>
</head>
<body>
<div class="containersss">
    <div class="row header" style="background-color: rgb(66, 64, 81); padding: 10px">
        <div class="col col-md-6">
            <!-- big header -->
            <div class="btn-group" role="group" aria-label="...">
                <a type="button" class="btn btn-secondary" href="<c:url value="home.jsp" />"  style="background-color: rgb(66, 64, 81); border: 0;">Home</a>
                <a type="button" class="btn btn-secondary" href="<c:url value="listComputers.jsp" />" style="background-color: rgb(66, 64, 81); border: 0;">Computer</a>
                <a type="button" class="btn btn-secondary" href="<%=request.getContextPath()%>/customers/list" style="background-color: rgb(66, 64, 81); border: 0;">Customer</a>
                <a type="button" class="btn btn-secondary" href="<c:url value="listService.jsp" />" style="background-color: rgb(66, 64, 81); border: 0;">Service</a>
            </div>
        </div>
        <div class="col col-md-6 justify-content-end flex-row" style="display: flex;">
            <!-- adding new button here  -->
            <Button class="btn btn-success" style="margin-left: 20px; width:200px"><i
                    class="fas fa-plus-circle text-white"></i> Add New Service</Button>
        </div>
    </div>
    <h1 style="color:rgb(66, 64, 81); text-align: center;">Manage Service</h1>
    <div class="row">
        <div class="container-fluid">
            <div class="row">
                <!-- table here -->
                <div style="overflow-x:auto; margin: 0 10px;">
                    <table>
                        <thead>
                        <tr>
                            <th>
                                CusCode
                            </th>
                            <th>
                                CusName
                            </th>
                            <th>
                                ComCode
                            </th>
                            <th>
                                Location
                            </th>
                            <th>
                                Status
                            </th>
                            <th>
                                Start day
                            </th>
                            <th>
                                Start time
                            </th>
                            <th>
                                Duration
                            </th>
                            <th>
                                SerCode
                            </th>
                            <th>
                                Service day
                            </th>
                            <th>
                                Service time
                            </th>
                            <th>
                                Number
                            </th>
                            <th>
                                Sum Price
                            </th>
                        </tr>
                        </thead>
                        <tbody>
                        <tr>
                            <td>
                                KH00001
                            </td>
                            <td>
                                Ninh Hai Hoang
                            </td>
                            <td>
                                M001
                            </td>
                            <td>
                                1
                            </td>
                            <td>
                                unavailable
                            </td>
                            <td>
                                20/7/2022
                            </td>
                            <td>
                                20:30
                            </td>
                            <td>
                                180
                            </td>
                            <td>
                                DV00001
                            </td>
                            <td>
                                20/7/2022
                            </td>
                            <td>
                                21:00
                            </td>
                            <td>
                                1
                            </td>
                            <td>
                                10000
                            </td>
                        </tr>
                        <tr>
                            <td>
                                KH00002
                            </td>
                            <td>
                                Ninh Hoang
                            </td>
                            <td>
                                M002
                            </td>
                            <td>
                                2
                            </td>
                            <td>
                                unavailable
                            </td>
                            <td>
                                20/7/2022
                            </td>
                            <td>
                                19:30
                            </td>
                            <td>
                                200
                            </td>
                            <td>
                                DV00002
                            </td>
                            <td>
                                20/7/2022
                            </td>
                            <td>
                                20:00
                            </td>
                            <td>
                                2
                            </td>
                            <td>
                                24000
                            </td>
                        </tr>
                        </tbody>
                    </table>
                </div>
                <!-- </div> -->
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
</div>

    <script src="<c:url value="/css/bootstrap-5.1.3-dist/js/bootstrap.bundle.min.js" />"></script>
    <!-- jQuery library -->
    <script src="<c:url value="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js" />"></script>
</body>
</html>
