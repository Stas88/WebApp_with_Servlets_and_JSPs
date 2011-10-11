/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller.actions.Emp;


import Controller.actions.ActionDispatcher.IAction;
import javax.servlet.http.*;
import Controller.actions.*;
/**
 *
 * @author Admin
 */
public class AddEmpAction implements IAction{
    
    
    @Override
    public String perform(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        session.removeAttribute("Emp");
        session.setAttribute("ActionEmp", "Add");
        return  "EditEmp";
    }
}
