<%-- 
    Document   : SalGradeTable
    Created on : Sep 22, 2011, 12:09:35 PM
    Author     : sikorskyi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Salary Grade</title>
        <link rel="stylesheet" type="text/css" href="main.css" />
    </head>
    <body>
        <table width="100%" width="100%" cellspacing="0" cellpadding="0">
            <tr>
                <td width="170"></td>
                <td><h1 align="center">Salary Grade Table</h1>
                    <form action="AddSalGrade">
                        <p align="center"><input type="submit" name="press" value="Add Salary Grade" >
                    </form>
                    <form action="FindSalGrade">
                        <p align="center"><input type="submit" name="press" value="Find Salary Grade" >
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
                            <th>Grade <a href="SortSalGrades?sort=ByGradeAsc"><</a> <a href="SortSalGrades?sort=ByGradeDsc">></a></th>
                            <th>MinSal</th>
                            <th>MaxSal</th>
                        </tr>
                        <c:forEach var="x" items="${SalGradeList}">
                        <tr>
                            <td width="50"><a href="RemoveSalGrade?grade=${x.grade}">Remove<a/></td>
                            <td width="30"><a href="EditSalGrade?grade=${x.grade}">Edit<a/></td>
                            <td width="30"><a href="SalGradeInfo?grade=${x.grade}">View<a/></td>
                            <td>${x.grade}</td>
                            <td>${x.minSal}</td>
                            <td>${x.maxSal}</td>
                        </tr>
                        </c:forEach>
                    </table>
                </td>
            </tr>
        </table>
        <br>
        <br>
        <p align="center">Just table of Salary Grade</p>
    </body>
</html>
