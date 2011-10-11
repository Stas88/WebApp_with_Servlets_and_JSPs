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
public class SortSalGrades implements IAction {
    
    public String perform(HttpServletRequest request, HttpServletResponse response) throws ModelException {
        String sortSalGradesBy = (String)request.getParameter("sort");
        request.getSession().setAttribute("SalGradeList", DAOFactory.getModel().getSortedSalGrades(sortSalGradesBy));
        return  "redirect:SalGradeTable";
   
    }
}
