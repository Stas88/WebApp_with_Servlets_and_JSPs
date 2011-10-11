/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.DAO;

/**
 *
 * @author Admin
 */
public class DAOFactory {
    
    public enum Type {Local, DBModel}
    
    private static IModel model = null;
    
    public static IModel getModel() {
            if (model == null) {
                model = new DBModel();
            }
        return model;
    }
    
   
}
