/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller.actions.Emp;

import Controller.actions.ActionDispatcher.IAction;
import javax.servlet.http.*;
import Model.DAO.*;
/**
 *
 * @author sikorskyi
 */
public class SortEmps implements IAction {
    
    public String perform(HttpServletRequest request, HttpServletResponse response) throws ModelException {
        HttpSession session = request.getSession();
        String sortEmpsBy = (String)request.getParameter("sort");
        session.setAttribute("EmpList", DAOFactory.getModel().getSortedEmps(sortEmpsBy));
        session.setAttribute("DeptList", DAOFactory.getModel().getDeptList());
        return  "redirect:EmpTable";
   
    }
}
