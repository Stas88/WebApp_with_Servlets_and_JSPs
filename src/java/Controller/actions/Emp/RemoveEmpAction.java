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

/**
 *
 * @author Admin
 */
public class RemoveEmpAction implements IAction{
    
    @Override
    public String perform(HttpServletRequest request, HttpServletResponse response) throws ModelException {
        HttpSession session = request.getSession();
        int empno = Integer.valueOf(request.getParameter("empno"));
        DAOFactory.getModel().removeEmp(empno);
        session.setAttribute("EmpList", DAOFactory.getModel().getEmpList());
        session.setAttribute("DeptList", DAOFactory.getModel().getDeptList());
        return  "redirect:EmpTable";
    }
}
