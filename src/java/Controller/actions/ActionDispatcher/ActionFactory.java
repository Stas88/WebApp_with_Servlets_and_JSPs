/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller.actions.ActionDispatcher;



import Controller.actions.Emp.*;
import Controller.actions.Dept.*;
import Controller.actions.SalGrade.*;
import java.util.*;
/**
 *
 * @author Admin
 */
public class ActionFactory {
    
    private static Map actionMap = defaultMap();
    
    public static IAction create(String actionName) {
        Class klass = (Class)actionMap.get(actionName);
        if (klass == null) 
               throw new RuntimeException(" was unable to find " +
               	"an action named '" + actionName + "'.");
        IAction actionInstance = null;
        try {
            actionInstance = (IAction)klass.newInstance();
        } catch (Exception e) {
            e.getMessage();
        }
        return actionInstance;
    }
    
    private static Map defaultMap() {
        Map map = new HashMap();
        map.put("index.html", ViewEmpsAction.class);
        map.put("ViewEmp", ViewEmpsAction.class);
        map.put("ViewDept", ViewDeptAction.class);
        map.put("ViewSalGrade", ViewSalGradeAction.class);
        map.put("AddDept", AddDeptAction.class);
        map.put("AddEmp", AddEmpAction.class);
        map.put("AddSalGrade", AddSalGradeAction.class);
        map.put("RemoveDept", RemoveDeptAction.class);
        map.put("RemoveEmp", RemoveEmpAction.class);
        map.put("RemoveSalGrade", RemoveSalGradeAction.class);
        map.put("EditDept", EditDeptAction.class);
        map.put("EditDeptSubmit", EditDeptSubmitAction.class);
        map.put("EditEmp", EditEmpAction.class);
        map.put("EditEmpSubmit", EditEmpSubmitAction.class);
        map.put("EditSalGrade", EditSalGradeAction.class);
        map.put("EditSalGradeSubmit", EditSalGradeSubmitAction.class);
        map.put("DeptInfo", DeptInfoAction.class);
        map.put("DeptInfoSubmit", DeptInfoSubmitAction.class);
        map.put("EmpInfo", EmpInfoAction.class);
        map.put("EmpInfoSubmit", EmpInfoSubmitAction.class);
        map.put("SalGradeInfo", SalGradeInfoAction.class);
        map.put("SalGradeInfoSubmit", SalGradeInfoSubmitAction.class);
        map.put("Ierarhy", Ierarhy.class);
        map.put("SortEmps", SortEmps.class);
        map.put("SortDepts", SortDepts.class);
        map.put("SortSalGrades", SortSalGrades.class);
        map.put("FindDept", FindDept.class);
        map.put("FindDeptSubmit", FindDeptSubmit.class);
        map.put("FindEmp", FindEmp.class);
        map.put("FindEmpSubmit", FindEmpSubmit.class);
        map.put("FindSalGrade", FindSalGrade.class);
        map.put("FindSalGradeSubmit", FindSalGradeSubmit.class);
        return map;
    }
    
    
}
