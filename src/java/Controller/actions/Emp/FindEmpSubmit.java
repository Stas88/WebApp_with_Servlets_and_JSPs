/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller.actions.Emp;

import Controller.actions.ActionDispatcher.IAction;
import javax.servlet.http.*;
import Controller.actions.*;
import Controller.actions.ActionDispatcher.IAction;
import javax.servlet.http.*;
import Model.*;
import Model.DAO.*;
import java.util.*;
/**
 *
 * @author sikorskyi
 */
public class FindEmpSubmit implements IAction {
    
    @Override
    public String perform(HttpServletRequest request, HttpServletResponse response) throws ModelException {
        HttpSession session = request.getSession();
        String ename = request.getParameter("ename");
        String salString = request.getParameter("sal");
        if ("".equals(salString) &&  ("".equals(ename))) {
            throw new ModelException("You do not enter any data");
        } else if ((!"".equals(ename)) && (!"".equals(salString))) {
            session.setAttribute("EmpList", DAOFactory.getModel().findEmps(ename, Integer.valueOf(salString))); 
        } else if ((!"".equals(ename)) && ("".equals(salString))) {
            session.setAttribute("EmpList", DAOFactory.getModel().findEmpsByEname(ename));
        } else if (("".equals(ename)) && (!"".equals(salString))) {
            session.setAttribute("EmpList", DAOFactory.getModel().findEmpsBySal(Integer.valueOf(salString)));
        }
        return "redirect:EmpTable";
    }
    
}
