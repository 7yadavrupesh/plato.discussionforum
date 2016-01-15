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
        <p class="login-box-msg">Register a new Faculty member</p>
         <form:form method="POST" commandName="faculty" modelAttribute="faculty" action="facultyadded.html">
            
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
		            <form:select path="facultyType" value="${faculty.facultyType}" >
		             
		              <option>Temporary</option>
		              <option>Permanent</option>
		              <option>Visiting</option>
		             
		    		</form:select>
		             <form:errors path="qualification" cssClass = "error"/>
		             <span class="glyphicon glyphicon-book form-control-feedback"></span>
		          </div>
		        
		        
		          <div class="form-group has-feedback">
		            <label>Joining Date</label>
		            <form:input path="joiningDate" id = "datepicker1" value="${faculty.joiningDate}" type="text" class="form-control" placeholder="MM/DD/YYYY"/>
		            
		             <form:errors path="joiningDate" cssClass ="error"/>
		            <span class="glyphicon glyphicon-calendar form-control-feedback"></span>
		           
		            
		        </div>
		        
		        
		          <div class="form-group has-feedback">
		            <form:select path="designation" value="${faculty.designation}" >
		             
		              <c:forEach var="designations" items="${designationList}">
						           
						        <option>${designations.designationName}</option>
						                
						                
						                   
		        			</c:forEach>
					
		        		
		    		</form:select>
		             <form:errors path="designation" cssClass = "error"/>
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
      
		          
		       
    <!-- Bootstrap 3.3.5 -->
    <script src="resources/js/bootstrap.min.js"></script>
    <!-- iCheck -->
    <script src="resources/js/iCheck/icheck.min.js"></script>
        
   				
		<script src="http://code.jquery.com/jquery-1.10.2.js"></script>
<script src="http://code.jquery.com/ui/1.11.0/jquery-ui.js"></script>	

<script>
                    $(function() {
                        $("#datepicker1").datepicker();
                    });
                	</script>
			

</body>


</html>