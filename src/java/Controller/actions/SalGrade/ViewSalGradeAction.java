/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller.actions.SalGrade;

import Controller.actions.ActionDispatcher.IAction;
import javax.servlet.http.*;
import Model.DAO.*;
/**
 *
 * @author sikorskyi
 */
public class ViewSalGradeAction implements IAction  {
    
    @Override
    public String perform(HttpServletRequest request, HttpServletResponse response) throws ModelException {
        request.getSession().setAttribute("SalGradeList", DAOFactory.getModel().getSalGradeList());
        return "redirect:SalGradeTable";
    }
}
