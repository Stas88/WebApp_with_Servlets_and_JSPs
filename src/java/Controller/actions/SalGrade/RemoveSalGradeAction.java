/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller.actions.SalGrade;

import Controller.actions.ActionDispatcher.IAction;
import Model.DAO.*;
import javax.servlet.http.*;
import Model.*;
import Model.DAO.DAOFactory;
/**
 *
 * @author sikorskyi
 */
public class RemoveSalGradeAction implements IAction {
    
    @Override
    public String perform(HttpServletRequest request, HttpServletResponse response) throws ModelException {
        int grade = Integer.valueOf(request.getParameter("grade"));
        DAOFactory.getModel().removeSalGrade(grade);
        request.getSession().setAttribute("SalGradeList", DAOFactory.getModel().getSalGradeList());
        return  "redirect:SalGradeTable";
    }
}
