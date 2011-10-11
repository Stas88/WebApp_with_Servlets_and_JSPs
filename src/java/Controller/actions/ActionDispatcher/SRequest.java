/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller.actions.ActionDispatcher;

import javax.servlet.http.*;
import  java.util.*;
import java.text.*;
/**
 *
 * @author Admin
 */
public class SRequest extends HttpServletRequestWrapper {
    
   SRequest request =  (SRequest)super.getRequest();
    
   public SRequest(HttpServletRequest request) {
       super(request);
   }
    
   public int getEmpno() {
       return Integer.valueOf(request.getParameter("empno"));
   }
   
    public String getEname() {
        return request.getParameter("ename");
    }
    
    public String getJob() {
        return request.getParameter("job");
    }
    
    public int getMgr() {
        return Integer.valueOf(request.getParameter("mgr"));
    }
    
    public Date getHiredate() {
        Date date = null;
        try {
            date =  new SimpleDateFormat("EEE MMM dd HH:mm:ss z yyyy").parse(request.getParameter("hiredate"));
        } catch (ParseException ex) {
            System.out.println(ex.getMessage());
        }
        return date;
    }
    
    public double getSal() {
        return Double.valueOf(request.getParameter("sal"));
    }
    
    public double getComm() {
        return Double.valueOf(request.getParameter("comm"));
    }
    
    public int getDeptno() {
        return Integer.valueOf(request.getParameter("deptno"));
    }
    
    public String getDname() {
        return request.getParameter("dname");
    }
    
    public String getLoc() {
        return request.getParameter("loc");
    }
   
}