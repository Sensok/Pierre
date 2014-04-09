/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URL;
import java.util.Set;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Adam
 */
@WebServlet(name = "search", urlPatterns = {"/search"})
public class search extends HttpServlet {

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
        Download test = new Download();
        String data = request.getParameter("query");
        data = parse(data);
        
        try {
            Set<URL> downloadFileNames = test.downloadFileNames(data, "Recipes");        
            request.getRequestDispatcher("header.jsp").include(request, response);
            request.getRequestDispatcher("menu.jsp").include(request, response);
            
            out.print("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\"");
            out.print("\"http://www.w3.org/TR/html4/loose.dtd\">");
            out.print("<!-- start content -->");
            out.print("<div id=\"content\">");
            out.print("<div class=\"post\">");
            out.print("<div class=\"title\">");
            out.print("<h2>Search Results</h2>");
            out.print("</div>");
            out.print("<div class=\"entry\">");
            int i = 1;
            for(URL item : downloadFileNames) {
                           
                BufferedReader br = new BufferedReader(new InputStreamReader(item.openStream()));            
                String strTemp = "";
                strTemp = br.readLine();
                out.print("<form name=\"" + strTemp + "\" method=\"POST\" action=\"/MiniPierre/Page\">");
                out.print("<input type=\"hidden\" name=\"" + "name" + "\" value=\"" + item + "\">");
                out.print("<a href=\"javascript:document.forms[" + i + "].submit()\">" + strTemp + "</a>");               
                out.print("</form>");                
                out.println("<br />");
                i++;
            }	            
            out.print("</div>");
            out.print("</div>");
            out.print("</div>");
            out.print("<!-- end content -->");

            request.getRequestDispatcher("sidebar.jsp").include(request, response);
            request.getRequestDispatcher("footer.jsp").include(request, response);
        }
        catch (Exception e)
        {
        }
        finally {
            out.close();
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

    private String parse(String data) {
        data = data.replaceAll(" ", ";").toLowerCase();
        return data + ";";
    }

}
