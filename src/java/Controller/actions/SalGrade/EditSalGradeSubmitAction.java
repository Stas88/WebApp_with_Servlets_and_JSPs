/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller.actions.SalGrade;

import Controller.actions.ActionDispatcher.IAction;
import Model.DAO.*;
import javax.servlet.http.*;
import java.util.*;
import java.text.*;
import Model.*;
import Model.DAO.DAOFactory;
import java.io.*;

/**
 *
 * @author sikorskyi
 */
public class EditSalGradeSubmitAction implements IAction {

    @Override
    public String perform(HttpServletRequest request, HttpServletResponse response) throws ModelException {
        HttpSession session = request.getSession();
        if ("".equals(request.getParameter("grade"))) {
            SalGrade salGrade = createSalGradeWithoutGrade(request);
            DAOFactory.getModel().addSalGrade(salGrade);
            session.removeAttribute("SalGrade");
            session.setAttribute("SalGradeList", DAOFactory.getModel().getSalGradeList());
        } else {
            SalGrade salGrade = createSalGrade(request);
            DAOFactory.getModel().editSalGrade(salGrade);
            session.removeAttribute("SalGrade");
            session.setAttribute("SalGradeList", DAOFactory.getModel().getSalGradeList());
        }
        return "redirect:SalGradeTable";
    }

    private SalGrade createSalGrade(HttpServletRequest request) {
        int grade = Integer.valueOf(request.getParameter("grade"));
        double minSal = Double.valueOf(request.getParameter("minSal"));
        double maxSal = Double.valueOf(request.getParameter("maxSal"));
        SalGrade salGrade = new SalGrade(grade, minSal, maxSal);
        return salGrade;
    }

    private SalGrade createSalGradeWithoutGrade(HttpServletRequest request) {
        SalGrade salGrade = new SalGrade();
        salGrade.setMinSal(Double.valueOf(request.getParameter("minSal")));
        salGrade.setMaxSal(Double.valueOf(request.getParameter("maxSal")));
        return salGrade;
    }
}
