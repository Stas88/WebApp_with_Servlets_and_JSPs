/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller.actions.Emp;

import Controller.actions.ActionDispatcher.IAction;
import javax.servlet.http.*;
import Model.DAO.*;
import org.apache.log4j.xml.*;
import org.apache.log4j.*;

/**
 *
 * @author Admin
 */
public class ViewEmpsAction implements IAction{
   private static Logger logger = Logger.getRootLogger();
    
    public String perform(HttpServletRequest request, HttpServletResponse response) throws ModelException {
        HttpSession session = request.getSession();
        session.setAttribute("EmpListPlus", DAOFactory.getModel().getEmpList());
        session.setAttribute("EmpList", DAOFactory.getModel().getEmpList());
        session.setAttribute("DeptList", DAOFactory.getModel().getDeptList());
        session.removeAttribute("ParentList");
        return  "redirect:EmpTable";
    }
}
