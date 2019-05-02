/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.smartservice.mapa;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL; 
import java.lang.StringBuffer;


/**
 *
 * @author jorge
 */
@WebServlet(name = "Mapa", urlPatterns = {"/Mapa"})
public class Mapa extends HttpServlet {
    double latitude=0;
    double longitude=0;
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
        try (PrintWriter out = response.getWriter()) {
            
            String url = "https://maps.googleapis.com/maps/api/distancematrix/"+
                    "json?origins="+latitude+"|"+longitude+"&destinations="+latitude+
                    "|"+longitude+"&mode=driving&language=fr-FR&key=AIzaSyDOXbhiOlje54s-im1CDxcV-cK0U6OxCB0";
            URL obj = new URL(url);
            HttpURLConnection con = (HttpURLConnection) obj.openConnection();
            con.setRequestMethod("GET");
            con.setRequestProperty("User-Agent", "Mozilla/5.0");
            int responseCode = con.getResponseCode();
            System.out.println("\nSending 'GET' request to URL : " + url);
            System.out.println("Response Code : " + responseCode);
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuffer datos = new StringBuffer();
            while ((inputLine = in.readLine()) != null) {
               datos.append(inputLine);
            }
            in.close();
            System.out.println(datos.toString());
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<meta charset=\"utf-8\">");
            out.println("<title>Servlet Mapa</title>"); 
            out.println("<script type='text/javascript' src='Mapa.js' ></script>");
            out.println("<script src=\"http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js\"></script>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>SmartServices</h1>");
            out.println("<button type=\"button\" onclick=\"main()\" value=\"IniciarAplicacion\">Iniciar</button>");
            out.println("<iframe\n" +
                    "      width=\"600\"\n" +
                    "      height=\"450\"\n" +
                    "      frameborder=\"0\" style=\"border:0\"\n" +
                    "      src=\"https://www.google.com/maps/embed/v1/place?key=AIzaSyDOXbhiOlje54s-im1CDxcV-cK0U6OxCB0\n" +
                    "        &q=Space+Needle,Seattle+WA\" allowfullscreen>\n" +
                    "    </iframe>");
            out.println("<p>Nueva entrada de Jorge</p>");
            out.println("<h1>Servlet Mapa at " + request.getContextPath() + "</h1>");
            //out.println("<source src='Mapa.js' ></p>");
            out.println("<p id='map'></p>");
            out.println("<div id='error'></div");
            out.println("</body>");
            out.println("</html>");
        }/*catch(ClassNotFoundException ex){
            ex.printStackTrace();
        }*/
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
