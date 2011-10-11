/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller.actions.SalGrade;

import Controller.actions.ActionDispatcher.IAction;
import javax.servlet.http.*;
import Model.*;
import Model.DAO.*;
import java.util.*;
/**
 *
 * @author sikorskyi
 */
public class FindSalGradeSubmit implements IAction {
    
    @Override
    public String perform(HttpServletRequest request, HttpServletResponse response) throws ModelException {
        String stringGrade = request.getParameter("grade");
         if ("".equals(stringGrade)) {
            throw new ModelException("You do not enter any data");
        } else if (!stringGrade.equals("")) {
            request.getSession().setAttribute("SalGradeList", DAOFactory.getModel().findSalGradesByGrade(Integer.valueOf(stringGrade)));
        }
        return "redirect:SalGradeTable";
    }
}
