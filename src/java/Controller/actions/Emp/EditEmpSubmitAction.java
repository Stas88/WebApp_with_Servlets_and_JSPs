package Controller.actions.Emp;

import Controller.actions.ActionDispatcher.IAction;
import javax.servlet.http.*;
import java.util.*;
import java.text.*;
import Model.*;
import Model.DAO.*;
import java.io.*;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Admin
 */
public class EditEmpSubmitAction implements IAction {

    @Override
    public String perform(HttpServletRequest request, HttpServletResponse response) throws ModelException {
        HttpSession session = request.getSession();
        if ("".equals(request.getParameter("empno"))) {
            Emp emp = createEmpWithoutEmpno(request);
            DAOFactory.getModel().addEmp(emp);
            session.setAttribute("EmpList", DAOFactory.getModel().getEmpList());
            session.setAttribute("DeptList", DAOFactory.getModel().getDeptList());
            session.removeAttribute("Emp");
        } else {
            Emp emp = createEmp(request);
            DAOFactory.getModel().editEmp(emp);
            session.removeAttribute("Emp");
            session.setAttribute("EmpList", DAOFactory.getModel().getEmpList());
            session.setAttribute("DeptList", DAOFactory.getModel().getDeptList());
        }
        return "redirect:EmpTable";
    }

    private Emp createEmp(HttpServletRequest request) throws ModelException {
        Emp emp = null;
        try {
            Integer mgr;
            int empno = Integer.valueOf(request.getParameter("empno"));
            String name = request.getParameter("ename");
            String job = request.getParameter("job");
            String mgrString = request.getParameter("mgr");
            if ("".equals(mgrString)) {
                mgr = 1;
            } else {
                mgr = Integer.valueOf(mgrString);
            }
            Date hiredate = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("hiredate"));
            double sal = Double.valueOf(request.getParameter("sal"));
            double comm = Double.valueOf(request.getParameter("comm"));
            int deptno = Integer.valueOf(request.getParameter("deptno"));
            emp = new Emp(empno, name, job, mgr, hiredate, sal, comm, deptno);
        }  catch (ParseException ex) {
            throw new ModelException(ex.getMessage());
        }
         catch (NumberFormatException ex) {
            throw new ModelException(ex.getMessage());
        }
        return emp;
    }

    private Emp createEmpWithoutEmpno(HttpServletRequest request) throws ModelException {
        Emp emp = new Emp();
        try {
            emp.setEname(request.getParameter("ename"));
            emp.setJob(request.getParameter("job"));
            emp.setMgr(Integer.valueOf(request.getParameter("mgr")));
            emp.setHiredate(new SimpleDateFormat("dd/MM/yyyy").parse(request.getParameter("hiredate")));
            emp.setSal(Double.valueOf(request.getParameter("sal")));
            emp.setComm(Double.valueOf(request.getParameter("comm")));
            emp.setDeptno(Integer.valueOf(request.getParameter("deptno")));
        } catch (ParseException ex) {
            throw new ModelException(ex.getMessage());
        }
         catch (NumberFormatException ex) {
            throw new ModelException(ex.getMessage());
        }
        return emp;
    }
}
