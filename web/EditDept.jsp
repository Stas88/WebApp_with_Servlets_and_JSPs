<%-- 
    Document   : EditDept
    Created on : Sep 14, 2011, 6:33:11 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%@ include file="/Navigation.jsp" %>
        <c:set var = "add" value="Add"/>  
        <h1><c:choose>
                <c:when test="${ActionDept eq add}">
                    Please, add department
                </c:when>
                <c:otherwise>
                    Please, edit department
                </c:otherwise>    
                    </c:choose></h1>
        <fieladset>
            <legend>Edit Department</legend>
            <form method="post" action="EditDeptSubmit?deptno=${Dept.deptno}">  
                <table>
                    <tr>
                        <td>Department name</td>
                        <td><input type="text" size ="20" name="dname" value ="${Dept.dname}"</td>
                    </tr>
                    <tr>
                        <td>Location</td>
                        <td><input type="text" size ="20" name="loc" value ="${Dept.loc}"</td>
                    </tr>
                </table>
                <input type="submit" value="Ok" >
            </form>
        </fieladset>
    </body>
</html>
