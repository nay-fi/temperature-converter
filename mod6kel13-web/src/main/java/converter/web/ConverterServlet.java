/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package converter.web;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import converter.ejb.ConverterBean;

/**
 *
 * @author HP
 */
@WebServlet(name = "ConverterServlet", urlPatterns = {"/ConverterServlet"})
public class ConverterServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    
    private ConverterBean cb = new ConverterBean();
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        PrintWriter out = response.getWriter();
        // Output the results
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Temperature Converter</title>");
        out.println("</head>");
        out.println("<body bgcolor=\"#FFAF00\">");
        out.println("<h1 align=\"center\"><u>Temperature Converter</u></h1>");
//        try {
//            String degree = request.getParameter("degree");
//            if ((degree != null) && (degree.length() > 0)) {
//                double d = Double.parseDouble(degree);
//                if (request.getParameter("C TO F") != null) {
//                    String centigrade = cb.ctof(d); 
//                    out.println("<p>" + degree + " Celcius are " + centigrade + " Farenheit.</p>");
//                }
//                if (request.getParameter("F TO C") != null) {
//                    String fahrenheit = cb.ftoc(d);
//                    out.println("<p>" + degree + " Farenheit are " + fahrenheit + " Celcius.</p>");
//                }
//            } else {
//                out.println("<p>Enter degree to convert:</p>");
//                out.println("<form method=\"get\">");
//                out.println("<p> <input type=\"text\" name=\"degree\" size=\"25\"></p>");
//                out.println("<br/>");
//                out.println("<input type=\"submit\" name=\"F TO C\" value=\"F TO C\">"
//                        + "<input type=\"submit\" name=\"C TO F\" value=\"C TO F\">");
//                out.println("</form>");
//            }

        try {
            String degree = request.getParameter("degree");
            if ((degree != null) && (degree.length() > 0)) {
                double d = Double.parseDouble(degree);
                if (request.getParameter("C TO K") != null) {
                    String centigrade = cb.ctok(d); 
                    out.println("<p>" + degree + " Celcius are " + centigrade + " Kelvin.</p>");
                }
                if (request.getParameter("K TO C") != null) {
                    String kelvin = cb.ktoc((float) d);
                    out.println("<p>" + degree + " Kelvin are " + kelvin + " Celcius.</p>");
                }
            } else {
                out.printf("<bgcolor=#FFAF00>");
                out.println("<p align=\"center\">Enter degree to convert:</p>");
                out.println("<form method=\"get\">");
                out.println("<p align=\"center\"> <input type=\"text\" name=\"degree\" size=\"25\" placeholder=\"🔍 Isi disini yaa!\"></p>");
                out.println("<br/>");
                out.println("<input type=\"submit\" name=\"K TO C\" value=\"Kelvin 🥶 TO Celcius 😍\">"
                        +"<br/> <br/>"+ "<input type=\"submit\" name=\"C TO K\" value=\"Celcius 😍 TO Kelvin 🥶️\">");
                out.println("</form>");
            }

        } finally {
            out.println("</body>");
            out.println("</html>");
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

}
