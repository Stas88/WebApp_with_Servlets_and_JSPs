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
public class EditSalGradeAction implements IAction {
    
    @Override
    public String perform(HttpServletRequest request, HttpServletResponse response) throws ModelException {
        HttpSession session = request.getSession();
        int grade = Integer.valueOf(request.getParameter("grade"));
        session.setAttribute("SalGrade",DAOFactory.getModel().findSalGrade(grade));
        session.setAttribute("ActionSalGrade", "Edit");
        return "EditSalGrade";
    }
}
