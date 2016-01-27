<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>PLATO | User Registration</title>
    <!-- Tell the browser to be responsive to screen width -->
    <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
    <!-- Bootstrap 3.3.5 -->
    <link rel="stylesheet" href="resources/css/bootstrap.min.css">
    <!-- Font Awesome -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
    <!-- Ionicons -->
    <link rel="stylesheet" href="https://code.ionicframework.com/ionicons/2.0.1/css/ionicons.min.css">
    <!-- Theme style -->
    <link rel="stylesheet" href="resources/css/AdminLTE.min.css">
    <!-- iCheck -->
    <link rel="stylesheet" href="resources/css/iCheck/square/blue.css">
      <link rel="stylesheet" href="//code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">
  

    <style>
		.error {
		color: #ff0000;
		font-style: italic;
		}
	</style>
  </head>
  <body class="hold-transition register-page">
    <div class="register-box">
      <div class="register-logo">
        <a href="#"><b>PLATO</b>v1.0</a>
      </div>

      <div class="register-box-body">
        <p class="login-box-msg">Register a new user</p>
        <form:form method="POST" commandName="register" modelAttribute="register" action="validate.html" enctype="multipart/form-data"
        >
        <!--<form action="../../index.html" method="post">-->
        
        	 <div class="form-group has-feedback">
            <!-- <input type="text" class="form-control" placeholder="Full name">-->
            <form:input path="userName" value="${register.userName}" type="text" class="form-control" placeholder="User Name"/>
            <form:errors path="userName" cssClass="error"/>
            <span class="glyphicon glyphicon-user form-control-feedback"></span>
          	</div>
          <div class="form-group has-feedback">
            <!-- <input type="text" class="form-control" placeholder="Full name">-->
            <form:input path="firstName" value="${register.firstName}" type="text" class="form-control" placeholder="First Name"/>
            <form:errors path="firstName" cssClass="error"/>
            <span class="glyphicon glyphicon-user form-control-feedback"></span>
          </div>
          
          <div class="form-group has-feedback">
            <!-- <input type="text" class="form-control" placeholder="Full name">-->
            <form:input path="lastName" value="${register.lastName}" type="text" class="form-control" placeholder="Last Name"/>
            <form:errors path="lastName" cssClass="error"/>
            <span class="glyphicon glyphicon-user form-control-feedback"></span>
          </div>
          
          <div class="form-group has-feedback">
          <form:input path="email" value="${register.email}" type="email" class="form-control" placeholder="Email"/>
          <form:errors path="email" cssClass="error"/>
            <!--  <input type="email" class="form-control" placeholder="Email">-->
            <span class="glyphicon glyphicon-envelope form-control-feedback"></span>
          </div>
          
          <div class="form-group has-feedback">
           <label>Gender&nbsp;&nbsp;</label>
        	 <form:select path="gender" value="${register.gender}" >
		             
		            
						        <option>Male</option>
						        <option>Female</option>
						        <option>Choose not to answer</option>
						     
						     	   
						     
					
		    		</form:select>
		   
          </div>
         
           
            <div class="form-group has-feedback">
           <label>Date of Birth&nbsp;&nbsp;</label>
           <form:input path="dateOfBirth" id = "datepicker" value="${register.dateOfBirth}" type="text" placeholder = "MM/DD/YYYY"/>
            
            <form:errors path="dateOfBirth" cssClass="error"/>
            <!--  <input type="email" class="form-control" placeholder="Email">-->
            <span class="glyphicon glyphicon-image form-control-calendar"></span>
          </div>
           <div class="form-group has-feedback">
           <label>Profile picture</label>
           <form:input path="image" value="${register.image}" type="file" name="file"/>
            <form:errors path="image" cssClass="error"/>
            <!--  <input type="email" class="form-control" placeholder="Email">-->
            <span class="glyphicon glyphicon-image form-control-feedback"></span>
          </div>
          <div class="form-group has-feedback">
            <label>Role &nbsp;&nbsp;</label>
            <form:select path="role" value="${register.role}" >
              
              <c:forEach var="role" items="${roleList}">
				           
				        <option value = "${role.roleId},${role.roleName}">${role.roleName}</option>
				        
				                
				                
				                   
        			</c:forEach>
			
        		
    		</form:select>
            <form:errors path="role" cssClass="error"/>
          </div>
          
         
          <div class="row">
             <div class="col-xs-8">
              
            </div><!-- /.col -->
            <div class="col-xs-4">
              <button type="submit" class="btn btn-primary btn-block btn-flat">Register</button>
            </div><!-- /.col -->
          </div>
        </form:form>

        

        
      </div><!-- /.form-box -->
    </div><!-- /.register-box -->

    <!-- jQuery 2.1.4 -->
   
    <!-- Bootstrap 3.3.5 -->
    <script src="resources/js/bootstrap.min.js"></script>
    <!-- iCheck -->
    <script src="resources/js/iCheck/icheck.min.js"></script>
    
 <script src="//code.jquery.com/jquery-1.10.2.js"></script>
  <script src="//code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
  
   <script>
   var $datePicker = $("#datepicker");

   $datePicker.datepicker({
       changeMonth: true,
       changeYear: true,
       inline: true,
       altField: "#datep",
    }).change(function(e){
       setTimeout(function(){   
          console.log(e, e.currentTarget, $datePicker.find('.ui-datepicker-current-day:visible')[0]);
          $datePicker
            .find('.ui-datepicker-current-day')
            .next('td')
            .children('.ui-state-default')
            .addClass('ui-state-active');
       });
   });
                	</script>
  </body>
</html>
