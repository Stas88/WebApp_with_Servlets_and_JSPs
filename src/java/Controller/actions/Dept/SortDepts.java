/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller.actions.Dept;

import Controller.actions.ActionDispatcher.IAction;
import javax.servlet.http.*;
import Model.DAO.*;
/**
 *
 * @author sikorskyi
 */
public class SortDepts implements IAction {
    
    public String perform(HttpServletRequest request, HttpServletResponse response) throws ModelException {
        String sortDeptsBy = (String)request.getParameter("sort");
        request.getSession().setAttribute("DeptList", DAOFactory.getModel().getSortedDepts(sortDeptsBy));
        return  "redirect:DeptTable";
   
    }
}
