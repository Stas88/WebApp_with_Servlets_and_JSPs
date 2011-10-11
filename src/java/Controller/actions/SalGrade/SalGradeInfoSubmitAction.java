/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller.actions.SalGrade;

import Controller.actions.ActionDispatcher.IAction;
import javax.servlet.http.*;
/**
 *
 * @author sikorskyi
 */
public class SalGradeInfoSubmitAction implements IAction  {
    
    @Override
    public String perform(HttpServletRequest request, HttpServletResponse response) {
        request.getSession().removeAttribute("SalGrade");
        return "redirect:SalGradeTable";
    }
    
}
