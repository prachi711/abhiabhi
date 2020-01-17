<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Profile</title>
</head>
<body>
     <form:form method="POST" modelAttribute="employee" action = "myProfile">
 <table>
 
             <tr>
            <td>Employee Id: ${EmpId}</td>
            </tr>
            <tr>
              <td>Firstname: ${FirstName}</td>
            </tr>
            
            <tr>
            <td>Lastname: ${LastName}</td>
            </tr>
            
            <tr>
            <td>Username: ${UserName}</td>
            </tr>
            
            <tr>
            <td>Expertise: ${Expertise}</td>
            </tr>
            
            <tr>
            <td>Designation: ${Designation}</td>
            </tr>
            
            <tr>
                <td><a href="hello.jsp">Home</a>
                </td>
            </tr>
           
        </table>
</form:form> 
</body>
</html>