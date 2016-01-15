<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
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
        <p class="login-box-msg">Register a new Student member</p>
         <form:form method="POST" commandName="student" modelAttribute="student" action="studentadded.html">
         
        
				
				   <div class="form-group has-feedback">
		            
		            <form:input path="studentId" value="${student.studentId}" type="text" class="form-control" placeholder="Student Id"/>
		             <form:errors path="studentId" cssClass = "error"/>
		            <span class="glyphicon glyphicon-user form-control-feedback"></span>
		        </div>
		        
		         <div class="form-group has-feedback">
		            <form:select path="qualification" value="${faculty.qualification}" >
		              
		              <option>10th</option>
		              <option>12th</option>
		              <option>Bachelores</option>
		              <option>Masters</option>
		              <option>Ph.D</option>
		              
		        		
		    		</form:select>
		             <form:errors path="qualification" cssClass = "error"/>
		             <span class="glyphicon glyphicon-book form-control-feedback"></span>
		          </div>
				
				
				 <div class="form-group has-feedback">
				 
				   
		            
		            <form:input path="presentAddress" value="${student.presentAddress}" type="text" class="form-control" placeholder="Permanenet Address"/>
		             <form:errors path="presentAddress" cssClass = "error"/>
		            <span class="glyphicon glyphicon-location form-control-feedback"></span>
		        </div>
		        <div class="form-group has-feedback">
		            
		            <form:input path="permanentAddress" value="${student.permanentAddress}" type="text" class="form-control" placeholder="Permanenet Address"/>
		             <form:errors path="permanentAddress" cssClass = "error"/>
		            <span class="glyphicon glyphicon-location form-control-feedback"></span>
		        </div>
		        
		           <div class="form-group has-feedback">
		            
		            <form:input path="phone1" value="${student.phone1}" type="text" class="form-control" placeholder="Phone 1"/>
		             <form:errors path="phone1" cssClass = "error"/>
		            <span class="glyphicon glyphicon-phone form-control-feedback"></span>
		        </div>
		        
		           <div class="form-group has-feedback">
		            
		            	<form:input path="phone2" value="${student.phone2}" type="text" class="form-control" placeholder="Phone 2"/>
		            	 <form:errors path="phone2" cssClass = "error"/>
		            	<span class="glyphicon glyphicon-phone form-control-feedback"></span>
		        	</div>
		        	
		        	   <div class="form-group has-feedback">
		            
		            <form:input path="nationality" value="${student.nationality}" type="text" class="form-control" placeholder="Nationality"/>
		             <form:errors path="nationality" cssClass = "error"/>
		            <span class="glyphicon glyphicon-country form-control-feedback"></span>
		        </div>
		        
		           <div class="form-group has-feedback">
		            
		            <form:input path="idCardPath" value="${student.idCardPath}" type="text" class="form-control" placeholder="Id Card Path"/>
		             <form:errors path="idCardPath" cssClass = "error"/>
		            <span class="glyphicon glyphicon-file form-control-feedback"></span>
		        </div>
		        
		        
		          
		        
		          <div class="form-group has-feedback">
		          <label>Id Card Issued</label>
        	 		<form:select path="idCardIssued" value="${student.idCardIssued}" >
		             
		             	<c:forEach var="i" begin="0" end="1">
   								<option value="${i}"><c:out value="${i}"/></option>
						</c:forEach>
						        
						     
						     	   
						     
					
		    		</form:select>
		   
          </div>
		  		          
		        <div class="form-group has-feedback">
		            
		            <form:input path="docsPath" value="${student.docsPath}" type="text" class="form-control" placeholder="Docs Path"/>
		            <span class="glyphicon glyphicon-file form-control-feedback"></span>
		        </div>
		          
		          
   				   <div class="row">
             	<div class="col-xs-8">
              
            	</div><!-- /.col -->
            		<div class="col-xs-4">
              			<button type="submit" class="btn btn-primary btn-block btn-flat">Register</button>
            		</div><!-- /.col -->
          		</div>
		
         </form:form>
</div>
</div>
</body>
</html>