<%-- 
    Document   : EditEmp
    Created on : Sep 14, 2011, 8:11:54 PM
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
                <c:when test="${ActionEmp eq add}">
                   Please, add Employee
                </c:when>
                <c:otherwise>
                   Please, edit Employee
                </c:otherwise>      
        </c:choose></h1>
        <fieldset>
            <legend>Edit employee</legend>
            <form method="post" action="EditEmpSubmit?empno=${Emp.empno}">
                <table>
                    <tr>
                        <td>Name</td>
                        <td><input type="text" size="30" name="ename" value="${Emp.ename}"></td>
                    </tr>
                    <tr>
                        <td>Job</td>
                        <td>
                           <input type="text" size="30" name="job" value="${Emp.job}">
                        </td>
                    </tr>
                    <tr>
                        <td>Manager</td>
                        
                        <td>
                            
                            <select size="1" name="mgr">
                                     <option value=""  selected="yes">Выберите менеджера</option>
                                <c:forEach var="x" items="${EmpList}">
                                    <option value="${x.empno}"  
                                            <c:if test="${Emp.mgr eq x.empno}">
                                            selected="yes"
                                            </c:if>>${x.ename}</option>
                                </c:forEach>
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <td>HireDate</td>
                        <td><input type="text" size="30" name="hiredate" value="${Emp.hiredate}"</td>
                        </td>
                    </tr>
                    <tr>
                        <td>Salary</td>
                        <td><input type="text"size="10" name="sal" value="${Emp.sal}"></td>
                    </tr>
                    <tr>
                        <td>Commission</td>
                        <td><input type="text"size="10" name="comm" value="${Emp.comm}"></td>
                    </tr>
                    <tr>
                        <td>Department name</td>
                        <td>
                            <select size="1" name="deptno">
                                <option value=""  selected="yes">Выберите отдел</option>
                                <c:forEach var="z" items="${DeptList}">       
                                    <option value="${z.deptno}"
                                    <c:if test="${Emp.deptno eq z.deptno}">
                                        selected="yes"
                                    </c:if>>${z.dname}</option>
                                </c:forEach>
                            </select>
                        </td>
                    </tr>
                </table>
                <br>
                <input  type="submit" name="addEmp" value="Ok" >
            </form>
        </fieldset>
    </body>
</html>
