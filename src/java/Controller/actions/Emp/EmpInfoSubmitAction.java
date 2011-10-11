/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller.actions.Emp;

import Controller.actions.ActionDispatcher.IAction;
import javax.servlet.http.*;
/**
 *
 * @author Admin
 */
public class EmpInfoSubmitAction implements IAction {
    
    @Override
    public String perform(HttpServletRequest request, HttpServletResponse response) {
        request.getSession().removeAttribute("Emp");
        return  "redirect:EmpTable";
    }
}
