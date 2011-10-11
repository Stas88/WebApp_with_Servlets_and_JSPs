/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller.actions.Dept;


import Controller.actions.ActionDispatcher.IAction;
import javax.servlet.http.*;
import Controller.actions.*;
/**
 *
 * @author Admin
 */
public class AddDeptAction implements IAction {
    
    @Override
    public String perform(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        session.removeAttribute("Dept");
        session.setAttribute("ActionDept", "Add");
        return  "EditDept";
    }
    
}
