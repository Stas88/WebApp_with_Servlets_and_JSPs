/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller.actions.Emp;

/**
 *
 * @author sikorskyi
 */
import Controller.actions.ActionDispatcher.IAction;
import javax.servlet.http.*;
import Controller.actions.*;
/**
 *
 * @author Admin
 */
public class FindEmp implements IAction {
    
    @Override
    public String perform(HttpServletRequest request, HttpServletResponse response) {
        return  "FindEmp";
    }
    
}
