<%--
  Created by IntelliJ IDEA.
  User: ninhh
  Date: 7/12/2022
  Time: 3:49 PM
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
    <link rel="stylesheet" href="<c:url value="/css/listComputers.css" />"/>
    <script src="<c:url value="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js" />"></script>
    <title>List Computers</title>
</head>
<body>
<div class="container-fluid">
    <div class="row header" style="background-color: rgb(66, 64, 81); padding: 10px">
        <div class="col col-md-6">
            <!-- big header -->
            <div class="btn-group" role="group" aria-label="...">
                <a type="button" class="btn btn-secondary" href="<c:url value="home.jsp" />"
                   style="background-color: rgb(66, 64, 81); border: 0;">Home</a>
                <a type="button" class="btn btn-secondary" href="<%=request.getContextPath()%>/computers/list?pageNumber=1"
                   style="background-color: rgb(66, 64, 81); border: 0;">Computer</a>
                <a type="button" class="btn btn-secondary" href="<%=request.getContextPath()%>/customers/list?pageNumber=1"
                   style="background-color: rgb(66, 64, 81); border: 0;">Customer</a>
                <a type="button" class="btn btn-secondary" href="<%=request.getContextPath()%>/services/list?pageNumber=1"
                   style="background-color: rgb(66, 64, 81); border: 0;">Service</a>
            </div>
        </div>
        <div class="col col-md-6 justify-content-end flex-row" style="display: flex;">
            <!-- adding new button here  -->
            <a class="btn btn-success" style="margin-left: 20px; width:200px"
               href="<%=request.getContextPath()%>/computers/show-add-page"><i
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
                    <c:forEach var="c" items="${computerList}">
                        <tr>

                            <td>
                                <c:out value="${c.computerCode}"/>
                            </td>
                            <td>
                                <c:out value="${c.location}"/>
                            </td>
                            <td>
                                <c:out value="${c.status}"/>
                            </td>

                            <td>
                                <a href="show-edit-page?id=<c:out value='${c.computerCode}'/>"><i
                                        class="fa fa-pen text-warning " style="margin-right: 10px;"></i></a>
                                <a href="delete?id=<c:out value='${c.computerCode}'/>" onclick="return confirm('Chắc là muốn xoá khum?')"><i
                                        class="fa fa-trash-alt text-danger "></i></a>
                            </td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
            <div class="row footer-container flex-row justify-content-between">
                <!-- pagination -->
                <div class="col col-md-6 align-items-center" style="display: flex;">
                    &nbsp;
                </div>
                <div class="col col-md-6 justify-content-end flex-row" style="display: flex;">
                    <nav aria-label="...">
                        <ul class="pagination">
                            <c:if test="${currentPage != 1}">
                                <li class="page-item">
                                    <a class="page-link" href="<%=request.getContextPath()%>/computers/list?pageNumber=${currentPage-1}">Previous</a>
                                </li>
                            </c:if>
                            <c:if test="${currentPage == 1}">
                                <li class="page-item disabled">
                                    <a class="page-link" href="<%=request.getContextPath()%>/computers/list?pageNumber=${currentPage-1}">Previous</a>
                                </li>
                            </c:if>
                            <c:forEach var="i" begin="1" end="${totalPages}">
                                <c:if test="${currentPage == i}">
                                    <li class="page-item active">
                                        <a class="page-link" href="<%=request.getContextPath()%>/computers/list?pageNumber=${i}">
                                            <c:out value="${i}"/>
                                        </a>
                                    </li>
                                </c:if>
                                <c:if test="${currentPage != i}">
                                    <li class="page-item">
                                        <a class="page-link" href="<%=request.getContextPath()%>/computers/list?pageNumber=${i}">
                                            <c:out value="${i}"/>
                                        </a>
                                    </li>
                                </c:if>
                            </c:forEach>
                            <c:if test="${currentPage != totalPages}">
                                <li class="page-item">
                                    <a class="page-link" href="<%=request.getContextPath()%>/computers/list?pageNumber=${currentPage+1}">Next</a>
                                </li>
                            </c:if>
                            <c:if test="${currentPage == totalPages}">
                                <li class="page-item disabled">
                                    <a class="page-link" href="<%=request.getContextPath()%>/computers/list?pageNumber=${currentPage+1}">Next</a>
                                </li>
                            </c:if>
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
