/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller.actions.Emp;

import Controller.actions.ActionDispatcher.IAction;
import javax.servlet.http.*;
import Model.DAO.*;
import Model.*;
/**
 *
 * @author Admin
 */
public class EditEmpAction implements IAction {
    
    @Override
    public String perform(HttpServletRequest request, HttpServletResponse response) throws ModelException  {
        HttpSession session = request.getSession();
        int empno = Integer.valueOf(request.getParameter("empno"));
        Emp emp = DAOFactory.getModel().findEmp(empno);
        session.setAttribute("Emp", emp);
        session.setAttribute("EmpList", DAOFactory.getModel().getEmpList());
        session.setAttribute("DeptList", DAOFactory.getModel().getDeptList());
        session.setAttribute("ActionEmp", "Edit");
        return "EditEmp";
    }
    
}
