/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller.actions.Dept;

import Controller.actions.ActionDispatcher.IAction;
import javax.servlet.http.*;
/**
 *
 * @author Admin
 */
public class DeptInfoSubmitAction implements IAction{
    
    @Override
    public String perform(HttpServletRequest request, HttpServletResponse response) {
        request.getSession().removeAttribute("Dept");
        return "redirect:DeptTable";
    }
    
}
