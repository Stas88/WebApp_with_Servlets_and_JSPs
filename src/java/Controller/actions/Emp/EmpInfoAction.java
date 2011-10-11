/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller.actions.Emp;

import Controller.actions.ActionDispatcher.IAction;
import javax.servlet.http.*;
import Model.DAO.*;

/**
 *
 * @author Admin
 */
public class EmpInfoAction implements IAction {
    
    
    @Override
    public String perform(HttpServletRequest request, HttpServletResponse response) throws ModelException  {
        HttpSession session = request.getSession();
        int empno = Integer.valueOf(request.getParameter("empno"));
        session.setAttribute("Emp", DAOFactory.getModel().findEmp(empno));
        session.setAttribute("DeptList", DAOFactory.getModel().getDeptList());
        session.setAttribute("EmpList", DAOFactory.getModel().getEmpList());
        return  "EmpInfo";
    }
}
