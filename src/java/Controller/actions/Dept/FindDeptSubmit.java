/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller.actions.Dept;

/**
 *
 * @author sikorskyi
 */
import Controller.actions.ActionDispatcher.IAction;
import javax.servlet.http.*;
import Model.*;
import Model.DAO.*;
import java.util.*;

public class FindDeptSubmit implements IAction {

    @Override
    public String perform(HttpServletRequest request, HttpServletResponse response) throws ModelException {
        HttpSession session = request.getSession();
        String dname = request.getParameter("dname");
        String loc = request.getParameter("loc");
        if (dname.equals("") &&  (loc.equals(""))) {
            throw new ModelException("You do not enter any data");
        } else if ((!dname.equals("")) && (!loc.equals(""))) {
            session.setAttribute("DeptList", DAOFactory.getModel().findDepts(dname, loc));
        } else if ((!dname.equals("")) && (loc.equals(""))) {
            session.setAttribute("DeptList", DAOFactory.getModel().findDeptsByDname(dname));
        } else if ((dname.equals("")) && (!loc.equals(""))) {
            session.setAttribute("DeptList", DAOFactory.getModel().findDeptsByLoc(loc));
        }
        return "redirect:DeptTable";
    }
}
