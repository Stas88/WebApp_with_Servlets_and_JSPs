<%-- 
    Document   : FindSalGrade
    Created on : Sep 29, 2011, 3:34:31 PM
    Author     : sikorskyi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%@ include file="/Navigation.jsp" %>
        <h1>Find Salary Grade</h1>
        <fieladset>
        <form method="post" action="FindSalGradeSubmit">  
            <table>
                <tr>
                    <td>Salary grade</td>
                    <td><input type="text" size ="20" name="grade" </td>
                </tr>
            </table>
            <input type="submit" value="Ok" >
        </form>
    </fieladset>
    </body>
</html>
