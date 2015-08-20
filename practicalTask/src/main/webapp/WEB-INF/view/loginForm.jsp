<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Yevhen_Vasyliev
  Date: 18.08.2015
  Time: 20:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <link rel="stylesheet" href="/SpringSelfStudy/css/bootstrap.min.css">
  <script src="<c:url value="/js/jquery-ui.min.js"/>"></script>
  <script src="<c:url value="/js/bootstrap.min.js"/>"></script>
  <title>Hello!</title>
</head>
<body>
<div id="loginModal" class="modal show" tabindex="-1" role="dialog" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
        <h1 class="text-center">Login</h1>
      </div>
      <div class="modal-body">
        <form class="form col-md-12 center-block">
          <div class="form-group">
            <input class="form-control input-lg" placeholder="Email" type="text" name="email">
          </div>
          <div class="form-group">
            <input class="form-control input-lg" placeholder="Password" type="password" name="password">
          </div>
          <div class="form-group">
            <button class="btn btn-primary btn-lg btn-block">Sign In</button>
            <span class="pull-right"><a href="#">Register</a></span><span><a href="#">Need help?</a></span>
          </div>
          Remember me<input type="checkbox" name="remember" checked/>
        </form>
      </div>
      <div class="modal-footer">
        <div class="col-md-12">
          <button class="btn" data-dismiss="modal" aria-hidden="true">Cancel</button>
        </div>
      </div>
    </div>
  </div>
</div>
</body>
</html>
