<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>PLATO | Change Password</title>
    <!-- Tell the browser to be responsive to screen width -->
    <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
    <!-- Bootstrap 3.3.5 -->
   
    <link rel="stylesheet" href="resources/css/bootstrap.min.css" type = "text/css">
    <!-- Font Awesome -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css" type = "text/css">
    <!-- Ionicons -->
    <link rel="stylesheet" href="https://code.ionicframework.com/ionicons/2.0.1/css/ionicons.min.css" type = "text/css">
    <!-- Theme style -->
    <link rel="stylesheet" href="resources/css/AdminLTE.min.css" type = "text/css">
    <!-- iCheck -->
    <link rel="stylesheet" href="resources/css/iCheck/square/blue.css" type = "text/css">

    <style>
		.error {
		color: #ff0000;
		font-style: italic;
		}
	</style>
  </head>
  <body class="hold-transition login-page">
    <div class="login-box">
      <div class="login-logo">
        <a href="#"><b>PLATO</b>v1.0</a>
      </div><!-- /.login-logo -->
      <div class="login-box-body">
        
        <p class="login-box-msg">Change your Password</p>
        <form:form method="POST" commandName="change" modelAttribute="change" action="confirmPassword.html">
          <div class="form-group has-feedback">
           <c:if test="${success==true }">
          		<font color="green"><b>Password changed success</b></font>
          	</c:if>
          	<c:if test="${success==false }">
          		<font color="red"><b>Password changed failed</b></font>
          	</c:if>
          
          	<form:input path="userName" value=" ${username}" type="text" class="form-control" placeholder="Username"/>
            <form:errors path="userName" cssClass = "error"/>
            <span class="glyphicon glyphicon-envelope form-control-feedback"></span>
          </div>
          <div class="form-group has-feedback">
          	
          	<form:input path="oldPassword" value="${oldPassword}" type="password" class="form-control" placeholder="Old Password"/>
            <form:errors path="oldPassword" cssClass = "error"/>
            <span class="glyphicon glyphicon-lock form-control-feedback"></span>
          </div>
          
           <div class="form-group has-feedback">
          	
          	<form:input path="newPassword" value="${newPassword}" type="password" class="form-control" placeholder="New Password"/>
            <form:errors path="newPassword" cssClass = "error"/>
            <span class="glyphicon glyphicon-lock form-control-feedback"></span>
          </div>
          
          <div class="row">
            <div class="col-xs-8">
              
            </div><!-- /.col -->
            <div class="col-xs-4">
              <button type="submit" class="btn btn-primary btn-block btn-flat">Change</button>
            </div><!-- /.col -->
          </div>
          
         
       </form:form>

       
      </div><!-- /.login-box-body -->
    </div><!-- /.login-box -->

    <!-- jQuery 2.1.4 -->
    <script src="resources/js/jQuery-2.1.4.min.js"></script>
    <!-- Bootstrap 3.3.5 -->
    <script src="resources/js/bootstrap.min.js"></script>
    <!-- iCheck -->
    <script src="resources/js/iCheck/icheck.min.js"></script>
   
  </body>
</html>
