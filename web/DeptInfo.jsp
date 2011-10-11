<%-- 
    Document   : DeptInfo
    Created on : Sep 15, 2011, 12:31:53 AM
    Author     : Admin
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
    <fieladset>
        
        <legend>Department</legend>
        <form method="post" action="DeptInfoSubmit">
            <table>
                <tr>
                    <td>Department name</td>
                    <td>${Dept.dname}</td>
                </tr>
                <tr>
                    <td>Location</td>
                    <td>${Dept.loc}</td>
                </tr>
            </table>
            <input type="submit" value="Ok" >
        </form>
    </fieladset>
    </body>
</html>
