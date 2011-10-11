<%-- 
    Document   : FindEmp
    Created on : Sep 29, 2011, 4:35:37 PM
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
        <h1>Find Employee</h1>
        <fieladset>
        <form method="post" action="FindEmpSubmit">  
            <table>
                <tr>
                    <td>Employee name</td>
                    <td><input type="text" size ="20" name="ename" </td>
                </tr>
                <tr>
                    <td>Employee salary</td>
                    <td><input type="text" size ="20" name="sal" </td>
                </tr>
               
            </table>
            <input type="submit" value="Ok" >
        </form>
    </fieladset>
    </body>
</html>
