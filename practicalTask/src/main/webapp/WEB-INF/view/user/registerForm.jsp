<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Yevhen_Vasyliev
  Date: 21.08.2015
  Time: 10:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="<c:url value="/css/bootstrap.min.css"/>">
    <script src="<c:url value="/js/jquery-ui.min.js"/>"></script>
    <script src="<c:url value="/js/bootstrap.min.js"/>"></script>
</head>
<body>
<div class="row">
    <div class="col-lg-3"></div>
    <div class="col-lg-6">
        <div class="box-header with-border">
            <h3 class="box-title">Registration form</h3>
        </div>

        <form action="add" method="POST">
            <div class="box-body">
                <div class="form-group">
                    <lable for="firstName">First name</lable>
                    <input type="text" placeholder="First name" name="firstName">
                </div>
                <div class="form-group">
                    <lable for="lastName">Last name</lable>
                    <input type="text" placeholder="Last name" name="lastName">
                </div>
                <div class="form-group">
                    <lable for="email">Email</lable>
                    <input type="text" placeholder="Email" name="email">
                </div>
                <div class="form-group">
                    <lable for="birthday">Birthday</lable>
                    <input type="date" placeholder="Birthday" name="birthday">
                </div>
                <div class="box-footer">
                    <button id="addUserBtn" type="submit" class="btn btn-primary">Create</button>
                </div>
            </div>
        </form>
    </div>
</div>

</body>
</html>
