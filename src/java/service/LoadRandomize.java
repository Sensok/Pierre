/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package service;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Adam
 */
@WebServlet(name = "LoadRandomize", urlPatterns = {"/LoadRandomize"})
public class LoadRandomize extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
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
            request.getRequestDispatcher("header.jsp").include(request, response);
                request.getRequestDispatcher("menu.jsp").include(request, response);
                out.print("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\"");
                out.print("\"http://www.w3.org/TR/html4/loose.dtd\">");
                out.print("<!-- start content -->");
                out.print("<div id=\"content\">");
                out.print("<div class=\"post\">");
                out.print("<div class=\"title\">");
                
                out.print("</div>");
                out.print("<div id=\"preload\">\n" +
                          "<img src=\"http://i.imgur.com/KUJoe.gif\">\n" +
                          "</div>");
                out.print("Trying to contact Martha Stewart from prison to create the perfect recipe for you!");
                out.print("This may take awhile");
                out.print("<div class=\"entry\">");
                
                out.print("</div>");
                out.print("</div>");
                out.print("</div>");
                out.print("<!-- end content -->");
                
                request.getRequestDispatcher("sidebar.jsp").include(request, response);
                request.getRequestDispatcher("footer.jsp").include(request, response);                                                                
        } finally {
            //response.sendRedirect("Randomize");
            Randomize ran = new Randomize();
            //ran.doGet(request, response);            
            ran.processRequest(request, response);
            
            out.close();
            //response.sendRedirect("Randomize");
            //Randomize ran = new Randomize();
            //ran.doGet(request, response);            
            ran.processRequest(request, response);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
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
     *
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
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
