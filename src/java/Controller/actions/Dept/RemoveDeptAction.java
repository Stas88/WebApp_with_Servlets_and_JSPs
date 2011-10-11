/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller.actions.Dept;

import Controller.actions.ActionDispatcher.IAction;
import javax.servlet.http.*;
import Model.*;
import Model.DAO.*;


public class RemoveDeptAction implements IAction {
    
    @Override
    public String perform(HttpServletRequest request, HttpServletResponse response) throws ModelException  {
        int deptno = Integer.valueOf(request.getParameter("deptno"));
        DAOFactory.getModel().removeDept(deptno);
        request.getSession().setAttribute("DeptList", DAOFactory.getModel().getDeptList());
        return  "redirect:DeptTable";
    }
}
