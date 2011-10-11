/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller.actions.Dept;

import Controller.actions.ActionDispatcher.IAction;
import javax.servlet.http.*;
import Model.DAO.*;
import Model.*;
/**
 *
 * @author Admin
 */
public class EditDeptAction implements IAction {
    
    @Override
    public String perform(HttpServletRequest request, HttpServletResponse response) throws ModelException {
        HttpSession session = request.getSession();
        int deptno = Integer.valueOf(request.getParameter("deptno"));
        session.setAttribute("Dept",DAOFactory.getModel().findDept(deptno));
        session.setAttribute("ActionDept", "Edit");
        return "EditDept";
    }
}
