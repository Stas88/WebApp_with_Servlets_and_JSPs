<%-- 
    Document   : FindDept
    Created on : Sep 28, 2011, 3:52:24 PM
    Author     : sikorskyi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Department searching</title>
    </head>
    <body>
        <%@ include file="/Navigation.jsp" %>s
        <h1>Find department</h1>
        <fieladset>
        <form method="post" action="FindDeptSubmit">  
            <table>
                <tr>
                    <td>Department name</td>
                    <td><input type="text" size ="20" name="dname" </td>
                </tr>
                <tr>
                    <td>Location</td>
                    <td><input type="text" size ="20" name="loc" </td>
                </tr>
            </table>
            <input type="submit" value="Ok" >
        </form>
    </fieladset>
    </body>
</html>
