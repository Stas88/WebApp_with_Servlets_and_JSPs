package Controller.actions.ActionDispatcher;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.DAO.*;
import org.apache.log4j.*;

/**
 *
 * @author Admin
 */
public class DispatcherServlet extends HttpServlet {
    
    private static Logger logger = Logger.getRootLogger();

    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet EmpServlet</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet EmpServlet at " + request.getServletPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        } finally {            
            out.close();
        }
    }
    
    private String getActionName(HttpServletRequest request) {
        String path = request.getServletPath();
        return path.substring(1, path.length());
    }
    
    @Override
    protected void service(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        try {
        IAction action = ActionFactory.create(getActionName(request));
        if (action != null) {
            String url = action.perform(request, response);
            if (url != null) {
                if ( url.startsWith("redirect:")) {
                    response.sendRedirect(url.substring(9, url.length()) + ".jsp");
                } 
                else {
                    getServletContext().getRequestDispatcher("/" + url + ".jsp").forward(request, response);
                }
            } else {
                response.sendRedirect("EmpTable.jsp");
            }   
        }
        } catch (ModelException e) {
            request.getSession().setAttribute("ErrorMessage" , e.getMessage());
            logger.info(e.getMessage());
            response.sendRedirect("Error.jsp");
            e.printStackTrace();
        }
    }
 // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /** 
     * Handles the HTTP <code>POST</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /** 
     * Returns a short description of the servlet.
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
