<%-- 
    Document   : EmpTable
    Created on : Sep 7, 2011, 1:52:37 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Employee Table</title>
        <link rel="stylesheet" type="text/css" href="main.css" /> 
    </head>
    <body>
        <table width="100%" width="100%" cellspacing="0" cellpadding="0">
            <tr>
                <td width="170"></td>
                <td><h1 align="center">Department Table</h1>
                    <form action="AddDept">
                        <p align="center"><input type="submit" name="press" value="Add Department" >
                    </form>
                    <form action="FindDept">
                        <p align="center"><input type="submit" name="press" value="Find dept" >
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
                            <th border="0" rules=none></th>
                            <th border="0" rules=none></th>
                            <th border="0" rules=none></th>
                            <th>Dname</th>
                            <th>Loc <a href="SortDepts?sort=ByLocAsc"><</a> <a href="SortDepts?sort=ByLocDsc">></a></th>
                        </tr>
                        <c:forEach var="x" items="${DeptList}">
                        <tr>
                            <td width="50"><a href="RemoveDept?deptno=${x.deptno}">Remove<a/></td>
                            <td width="30"><a href="EditDept?deptno=${x.deptno}">Edit<a/></td>
                            <td width="30"><a href="DeptInfo?deptno=${x.deptno}">View<a/></td>
                            <td>${x.dname}</td>
                            <td>${x.loc} </td>
                        </tr>
                        </c:forEach>
                    </table>
                </td>
            </tr>
        </table>
        <br>
        <br>
        <p align="center">Just table of departments</p>
    </body>
</html>
