/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller.actions.Dept;

import Controller.actions.ActionDispatcher.IAction;
import Model.DAO.*;
import javax.servlet.http.*;
import java.util.*;
import java.text.*;
import Model.*;
import Model.DAO.DAOFactory;
import java.io.*;
/**
 *
 * @author Admin
 */
public class EditDeptSubmitAction implements IAction {
    
    @Override
    public String perform(HttpServletRequest request, HttpServletResponse response) throws ModelException {
        HttpSession session = request.getSession();
        if ("".equals(request.getParameter("deptno"))) {
            Dept dept = createDeptWithoutDeptno(request);
            DAOFactory.getModel().addDept(dept);
            session.removeAttribute("Dept");
            session.setAttribute("DeptList", DAOFactory.getModel().getDeptList());
        }
        else {
            Dept dept = createDept(request);
            DAOFactory.getModel().editDept(dept);
            session.removeAttribute("Dept");
            session.setAttribute("DeptList", DAOFactory.getModel().getDeptList());
        }
        return "redirect:DeptTable";
    }
    
    private Dept createDept(HttpServletRequest request) {
        int deptno = Integer.valueOf(request.getParameter("deptno"));
        String dname = request.getParameter("dname");
        String loc = request.getParameter("loc");
        Dept dept = new Dept(deptno, dname, loc);
        return dept;
    }
    
    private Dept createDeptWithoutDeptno(HttpServletRequest request) {
        Dept dept = new Dept();
        dept.setDname(request.getParameter("dname"));
        dept.setLoc(request.getParameter("loc"));
        return dept;
    }
    
}
