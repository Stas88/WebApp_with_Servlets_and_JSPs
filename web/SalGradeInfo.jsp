<%-- 
    Document   : SalGradeInfo
    Created on : Sep 22, 2011, 12:37:39 PM
    Author     : sikorskyi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Salary Grade</title>
    </head>
    <body>
        <%@ include file="/Navigation.jsp" %>
    <fieladset>
        <legend>Salary Grade</legend>
        <form method="post" action="SalGradeInfoSubmit">
            <table>
                <tr>
                    <td>Grade</td>
                    <td>${SalGrade.grade}</td>
                </tr>
                <tr>
                    <td>Minimal salary</td>
                    <td>${SalGrade.minSal}</td>
                </tr>
                <tr>
                    <td>Maximal salary </td>
                    <td>${SalGrade.maxSal}</td>
                </tr>
            </table>
            <input type="submit" value="Ok" >
        </form>
    </fieladset>
    </body>
</html>
