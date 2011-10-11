/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.DAO;

import Model.Dept;
import Model.Emp;
import Model.SalGrade;
import java.util.*;
import java.sql.*;
/**
 *
 * @author Admin
 */
public interface IModel {
    
    Collection<Emp> getEmpList() throws ModelException;
    
    Collection<Dept> getDeptList() throws ModelException;
    
    Collection<SalGrade> getSalGradeList() throws ModelException;
    
    Collection<Emp> getIerarhy(int empno) throws ModelException;
    
    Collection<Emp> getParentIerarhy(int empno) throws ModelException;
    
    Collection<Emp> getSortedEmps(String sortBy) throws ModelException;
    
    Collection<Dept> getSortedDepts(String sortBy) throws ModelException;
    
    Collection<Dept> findDeptsByDname(String dname) throws ModelException;
    
    Collection<SalGrade> getSortedSalGrades(String sortBy) throws ModelException;
    
    Collection<Dept> findDepts(String dname, String loc) throws ModelException;
    
    Collection<Dept> findDeptsByLoc(String loc) throws ModelException;
    
    Collection<Emp> findEmps(String ename, int sal) throws ModelException; 
             
    Collection<Emp> findEmpsByEname(String ename) throws ModelException;
    
    Collection<Emp> findEmpsBySal(int sal) throws ModelException;
    
    void addEmp(Emp emp )throws ModelException ;
    
    void addDept(Dept dept) throws ModelException;
    
    void addSalGrade(SalGrade salGrade) throws ModelException;
    
    void editEmp(Emp emp) throws ModelException;
    
    void editDept(Dept dept) throws ModelException;
    
    void editSalGrade(SalGrade salGrade) throws ModelException;
    
    void removeDept(int index) throws ModelException;
    
    void removeEmp(int index) throws ModelException;
    
    void removeSalGrade(int grade) throws ModelException; 
    
    Dept findDept(int deptno) throws ModelException;
    
    Emp findEmp (int empno) throws ModelException;
    
    SalGrade findSalGrade (int grade) throws ModelException;
    
    Collection<SalGrade> findSalGradesByGrade(int grade) throws ModelException;
   
}
