/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller.actions.ActionDispatcher;

import javax.servlet.http.*;
import java.io.*;
import Model.DAO.*;
/**
 *
 * @author Admin
 */
public interface IAction {
    
    public String perform(HttpServletRequest request, HttpServletResponse response) throws ModelException ;
}
