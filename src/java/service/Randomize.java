/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package service;

import com.dropbox.core.DbxException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Adam
 */
@WebServlet(name = "Randomize", urlPatterns = {"/Randomize"})
public class Randomize extends HttpServlet {

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
      
        try {
            response.setContentType("text/html;charset=UTF-8");
            PrintWriter out = response.getWriter();
            
            Download test = new Download();
            Set<URL> url = test.downloadFileNames(".txt", "");
            String title = "";
            String adj = "";
            URL[] y = url.toArray(new URL[0]);
            
            adj = setValue(y[5]);
            title = setValue(y[6]);            
            /*        title = setValue(item, 5);
            
            BufferedReader br = new BufferedReader(new InputStreamReader(item.openStream()));
            String strTemp = "";
            strTemp = br.readLine();
            */
            try {
                request.getRequestDispatcher("header.jsp").include(request, response);
                request.getRequestDispatcher("menu.jsp").include(request, response);
                out.print("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\"");
                out.print("\"http://www.w3.org/TR/html4/loose.dtd\">");
                out.print("<!-- start content -->");
                out.print("<div id=\"content\">");
                out.print("<div class=\"post\">");
                out.print("<div class=\"title\">");
                out.print("<h2>");
                out.print(adj + " " + title);
                out.print("</h2>");
                out.print("</div>");
                out.print("<div class=\"entry\">");
                // randomize values
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
        catch (DbxException ex)
        {
            Logger.getLogger(Randomize.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MalformedURLException ex) {
            Logger.getLogger(Randomize.class.getName()).log(Level.SEVERE, null, ex);
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

    private String setValue(URL url) {
        BufferedReader br;           
        ArrayList<String> temp = null;
        int i1 = 0;
        try {
            br = new BufferedReader(new InputStreamReader(url.openStream()));
            String strTemp = "";
            temp = new ArrayList<String>();
            while (null != (strTemp = br.readLine())) 
            {
                System.out.println(strTemp);
                temp.add(strTemp);
            }
            Random r=new Random();
            i1=(r.nextInt(temp.size()));            
        } catch (IOException ex) {
        }
        return temp.get(i1);
    }

}
