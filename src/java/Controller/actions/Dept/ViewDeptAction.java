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
public class ViewDeptAction implements IAction {
    
    @Override
    public String perform(HttpServletRequest request, HttpServletResponse response) throws ModelException {
        HttpSession session = request.getSession();
        session.setAttribute("DeptList", DAOFactory.getModel().getDeptList());
        return "redirect:DeptTable";
    }
}
