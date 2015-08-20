<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Yevhen_Vasyliev
  Date: 18.08.2015
  Time: 20:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="<c:url value="/css/bootstrap.min.css"/>">
</head>
<body>
<div class="row">
    <div class="col-lg-1"></div>
    <div class="col-lg-6">
        <h1>Welcome page!</h1>
        <a href="<c:url value="user/loginform"/>">Linc</a>
    </div>

</div>
</body>
</html>
