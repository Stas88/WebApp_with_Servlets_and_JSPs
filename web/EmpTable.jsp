<%-- 
    Document   : EmpTable
    Created on : Sep 7, 2011, 1:52:37 PM
    Author     : Admin
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Employee Table</title>
        <link rel="stylesheet" type="text/css" href="main.css" /> 
   
    </head>
    <body>
        <table width="100%" cellspacing="0" cellpadding="0">
            <tr>
                <td width="170"></td>
                <td><h1 align="center">Employee Table</h1>
                    <form method="post" action="AddEmp">
                       <p align="center"><input type="submit" name="press" value="Add Employee" >
                    </form>
                    <form method="post" action="FindEmp">
                       <p align="center"><input type="submit" name="press" value="Find Employee" >
                    </form>
                </td> 
            </tr>
            <tr>
                <td>
                    <ul type="circle">
                        <li><a href="ViewDept">Department table</a></li>
                        <li><a href="ViewEmp">Employee table</a></li>
                        <li><a href="ViewSalGrade">Salary Grade table</a></li>
                        
                    </ul>
                </td>
                <td>  
                    <table  border="1" cellspacing="1" cellpadding="1" width="100%" frame="border" align="center">
                        <tr>
                          <c:forEach var="emp" items="${ParentList}"> 
                                <a href="Ierarhy?empno=${emp.empno}">${emp.ename}></a>
                         </c:forEach> 
                            <th border="0" rules=none></th>
                            <th border="0" rules=none></th>
                            <th border="0" rules=none></th>
                            <th>Name <a href="SortEmps?sort=ByNameAsc"><</a> <a href="SortEmps?sort=ByNameDsc">></a></th>
                            <th>Job</th>
                            <th>Manager</th>
                            <th>Hiredate <a href="SortEmps?sort=ByHiredateAsc"><</a> <a href="SortEmps?sort=ByHiredateDsc">></th>
                            <th>Salary <a href="SortEmps?sort=BySalAsc"><</a> <a href="SortEmps?sort=BySalDsc">></a></th>
                            <th>Commisions</th>
                            <th>Deptno</th>
                        </tr>
                        <c:forEach var="x" items="${EmpList}"> 
                        <tr>
                            <td width="50"><a href="RemoveEmp?empno=${x.empno}">Remove<a/></td>
                            <td width="30"><a href="EditEmp?empno=${x.empno}">Edit<a/></td>
                            <td width="30"><a href="EmpInfo?empno=${x.empno}" >View<a/></td>
                           
                            <td><a href="Ierarhy?empno=${x.empno}">${x.ename}<a/></td>
                            <td>${x.job}</td>
                            <c:choose>
                                <c:when test="${x.mgr eq 1}">
                                    <td>no manager</td>
                                </c:when>
                                <c:otherwise>
                                    <c:forEach var="y" items="${EmpListPlus}" > 
                                        <c:if test="${x.mgr eq y.empno}">
                                            <td>${y.ename}</td>
                                       </c:if>
                                    </c:forEach>
                                </c:otherwise>      
                            </c:choose>
                            <td>${x.hiredate}</td>
                            <td>${x.sal}</td>
                            <td>${x.comm}</td>
                            <c:forEach var="z" items="${DeptList}" > 
                                <c:if test="${x.deptno eq z.deptno}">
                                        <td>${z.dname}</td>
                               </c:if>    
                            </c:forEach>
                        </tr>
                        </c:forEach>
                    </table>
                </td>
            </tr>
        </table>
        <br>
        <br>
        <p align="center">Just table of employees</p>
    </body>
</html>
