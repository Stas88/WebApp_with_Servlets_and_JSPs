<%-- 
    Document   : EmpInfo
    Created on : Sep 15, 2011, 12:53:53 AM
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
        <fieldset>
            <legend>Employee</legend>
            <form method="post" action="EmpInfoSubmit">
                <table>
                    <tr>
                        <td>Name</td>
                        <td>${Emp.ename}</td>
                    </tr>
                    <tr>
                        <td>Job</td>
                        <td>
                            ${Emp.job}
                        </td>
                    </tr>
                    <tr>
                        <td>Manager</td>
                        <c:forEach var="y" items="${EmpList}" > 
                            <c:if test="${Emp.mgr eq y.empno}">
                                <td>${y.ename}</td>
                           </c:if>
                        </c:forEach>
                    </tr>
                    <tr>
                        <td>HireDate</td>
                        <td>${Emp.hiredate}</td>
                    </tr>
                    <tr>
                        <td>Salary</td>
                        <td>${Emp.sal}</td>
                    </tr>
                    <tr>
                        <td>Commission</td>
                        <td>${Emp.comm}</td>
                    </tr>
                    <tr>
                        <td>Department number</td>
                        <c:forEach var="z" items="${DeptList}" > 
                            <c:if test="${Emp.deptno eq z.deptno}">
                                    <td>${z.dname}</td>
                           </c:if>    
                        </c:forEach>
                    </tr>
                </table>
                <br>
                <input  type="submit" name="addEmp" value="Ok" onclick="EmpInfoSubmit">
            </form>
        </fieldset>
    </body>
</html>
