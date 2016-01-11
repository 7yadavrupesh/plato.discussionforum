<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Role</title>
</head>
<body>
<h2>Role Management </h2>
<form:form method="post" action="addRole.html"> 
    <table>
	    <tr>
	        <td><form:label path="roleName">Role Name</form:label></td>
	        <td><form:input path="roleName" /></td> 
	    </tr>
	    <tr>
	        <td><form:label path="description">Role Description</form:label></td>
	        <td><form:input path="description" /></td>
	    </tr>
	    <tr>
	        <td><form:label path="roleLevelId">Role Level</form:label></td>
	        <td><form:input path="roleLevelId" /></td>
	    </tr>    
	    <tr>
	        <td colspan="2">
	            <input type="submit" value="Add Role"/>
	        </td>
	    </tr>
	</table>  
     
</form:form>

</body>
</html>