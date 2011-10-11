<%-- 
    Document   : EditSalGrade
    Created on : Sep 22, 2011, 12:55:22 PM
    Author     : sikorskyi
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
                <c:when test="${ActionSalGrade eq add}">
                    Please, add salary grade
                </c:when>
                <c:otherwise>
                    Please, edit salary grade
                </c:otherwise>    
                    </c:choose></h1>
        <fieladset>
            <legend>Edit Grade</legend>
            <form method="post" action="EditSalGradeSubmit?grade=${SalGrade.grade}">  
                <table>
                    <tr>
                        <td>Minimal salary</td>
                        <td><input type="text" size ="20" name="minSal" value ="${SalGrade.minSal}"</td>
                    </tr>
                    <tr>
                        <td>Maximal Salary</td>
                        <td><input type="text" size ="20" name="maxSal" value ="${SalGrade.maxSal}"</td>
                    </tr>
                </table>
                <input type="submit" value="Ok" >
            </form>
         </fieladset>
    </body>
</html>
