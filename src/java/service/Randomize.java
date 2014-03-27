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

    private Random r;
    
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
      
        r = new Random();
        try {
            response.setContentType("text/html;charset=UTF-8");
            PrintWriter out = response.getWriter();
            
            Download test = new Download();
            Set<URL> url = test.downloadFileNames(".txt", "");
            String title = "";
            String adj = "";
            String meat = "";
            String cans = "";
            String liquid = "";
            URL measures = null;
            String dish = "";
            String sideMeat = "";
            URL spices = null;
            String veggies = "";            
            URL[] y = url.toArray(new URL[0]);
            
            for(URL x : y)
            {
                if(x.toString().contains("NameAdj"))
                    adj = setValue(x);
                else if(x.toString().contains("NameTitle"))
                    title = setValue(x);            
                else if(x.toString().contains("SideMeats"))
                    sideMeat = setValue(x);
                else if(x.toString().contains("Meats"))
                    meat = setValue(x);
                else if(x.toString().contains("Liquid"))
                    liquid = setValue(x);
                else if(x.toString().contains("Rice"))
                    dish = setValue(x);
                else if(x.toString().contains("Veg"))
                    veggies = setValue(x);
                else if(x.toString().contains("Spi"))
                    spices = x;
                else if(x.toString().contains("Meas"))
                    measures = x;
                else if(x.toString().contains("Can"))
                    cans = setValue(x);
                else
                    System.out.println(x);
            }
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
                
                out.print("-----------------");
                out.print("<br />");
                out.print("Ingredients:");
                out.print("<br />");
                out.print(setValue(measures) + " " + meat);
                out.print("<br />");
                out.print(setValue(measures) + " " + sideMeat);
                out.print("<br />");
                out.print(setValue(measures) + " " + cans);
                out.print("<br />");
                out.print(setValue(measures) + " " + dish);
                out.print("<br />");
                out.print(setValue(measures) + " " + liquid);
                out.print("<br />");
                out.print(setValue(measures) + " " + veggies);
                out.print("<br />");
                out.print(setValue(measures) + " " + setValue(spices));
                out.print("<br />");
                out.print(setValue(measures) + " " + setValue(spices));
                out.print("<br />");
                out.print(setValue(measures) + " " + setValue(spices));
                out.print("<br />");
                out.print("<br />");
                out.print("Directions:");
                out.print("<br />");
                out.print("Throw in crockpot on low for " + r.nextInt(24) + " hour(s)!");
                out.print("<br />");
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
                temp.add(strTemp);
            }            
            i1=(r.nextInt(temp.size()));            
        } catch (IOException ex) {
        }
        System.out.println(temp.get(i1));
        return temp.get(i1);
    }

}
