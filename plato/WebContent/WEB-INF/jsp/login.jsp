<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>PLATO | Log in</title>
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

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
        <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
  </head>
  <body class="hold-transition login-page">
    <div class="login-box">
      <div class="login-logo">
        <a href="#"><b>PLATO</b>v1.0</a>
      </div><!-- /.login-logo -->
      <div class="login-box-body">
        <p class="login-box-msg">Sign in</p>
        <form:form method="POST" commandName="user" modelAttribute="user" action="authenticate.html">
          <div class="form-group has-feedback">
          	<c:if test="${val==false }">
          		<font color="red"><b>Authentication Failure</b></font>
          	</c:if>
          	<form:input path="userName" value="${user.userName}" type="text" class="form-control" placeholder="Username"/>
            <!--  <input type="text" class="form-control" placeholder="Username">-->
            <span class="glyphicon glyphicon-envelope form-control-feedback"></span>
          </div>
          <div class="form-group has-feedback">
          	
          	<form:input path="password" value="${user.password}" type="password" class="form-control" placeholder="Password"/>
            <!--  <input type="password" class="form-control" placeholder="Password">-->
            <span class="glyphicon glyphicon-lock form-control-feedback"></span>
          </div>
          <div class="row">
            <div class="col-xs-8">
              <div class="checkbox icheck">
                <!--<form:label path=""></form:label></td>-->
              	<form:checkbox path="rememberMe" value="rememberMe"/>Remember Me
                <!-- <label>
                
                  <input type="checkbox"> 
                </label>-->
              </div>
            </div><!-- /.col -->
            <div class="col-xs-4">
              <button type="submit" class="btn btn-primary btn-block btn-flat">Log In</button>
            </div><!-- /.col -->
          </div>
       </form:form>

        <a href="changePassword.html">Change Password</a><br>
        <a href="register.html" class="text-center">Register</a>

      </div><!-- /.login-box-body -->
    </div><!-- /.login-box -->

    <!-- jQuery 2.1.4 -->
    <script src="resources/js/jQuery-2.1.4.min.js"></script>
    <!-- Bootstrap 3.3.5 -->
    <script src="resources/js/bootstrap.min.js"></script>
    <!-- iCheck -->
    <script src="resources/js/iCheck/icheck.min.js"></script>
    <script>
      $(function () {
        $('input').iCheck({
          checkboxClass: 'icheckbox_square-blue',
          radioClass: 'iradio_square-blue',
          increaseArea: '20%' // optional
        });
      });
    </script>
  </body>
</html>
