/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller.actions.Emp;

import Controller.actions.ActionDispatcher.IAction;
import Model.DAO.*;
import javax.servlet.http.*;
import Model.*;
import Model.DAO.DAOFactory;
import java.util.*;
/**
 *
 * @author sikorskyi
 */
public class Ierarhy implements IAction {
    
    @Override
    public String perform(HttpServletRequest request, HttpServletResponse response) throws ModelException {
        int empno = Integer.valueOf(request.getParameter("empno"));
        HttpSession session = request.getSession();
        session.setAttribute("ParentList", DAOFactory.getModel().getParentIerarhy(empno));
        session.setAttribute("EmpList", DAOFactory.getModel().getIerarhy(empno));
        session.setAttribute("EmpListPlus", DAOFactory.getModel().getEmpList());
        session.setAttribute("EmpIerarhy", DAOFactory.getModel().findEmp(empno));
        session.setAttribute("DeptList", DAOFactory.getModel().getDeptList());
        return  "redirect:EmpTable";
    }
}
