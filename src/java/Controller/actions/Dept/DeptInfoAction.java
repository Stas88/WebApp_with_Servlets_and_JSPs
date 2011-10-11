/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller.actions.Dept;

import Controller.actions.ActionDispatcher.IAction;
import javax.servlet.http.*;
import Model.DAO.*;
/**
 *
 * @author Admin
 */
public class DeptInfoAction implements IAction {
    
    @Override
    public String perform(HttpServletRequest request, HttpServletResponse response) throws ModelException {
        int deptno = Integer.valueOf(request.getParameter("deptno"));
        request.getSession().setAttribute("Dept", DAOFactory.getModel().findDept(deptno));
        return "DeptInfo";
    }
}
