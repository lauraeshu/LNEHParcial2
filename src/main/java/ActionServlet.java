/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 *
 * @author Natalia
 */
public class ActionServlet extends HttpServlet {

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
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
           
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
        response.setContentType("text/html;charset=UTF-8");
        
        PrintWriter out = response.getWriter();
                /* Leer JSON*/
                
        JSONParser parser = new JSONParser();

        try{
            
            Object jsonObj = parser.parse(new FileReader("C:\\json_salidas\\responseParcial.json"));
            
            JSONArray jsonObject = (JSONArray)jsonObj;
            
            out.println("<table style= cellspacing='1' bgcolor='#0099cc'>");
            out.println("<TR>");
            out.println("<td style= rowspan='7' align='center' bgcolor='#f8f8f8'>N.</td>");
            out.println("<td style= rowspan='7' align='center' bgcolor='#f8f8f8'>Respuesta</td>");
            

            out.println("</TR>");
            out.println("<TR>");
            
            for (int i = 0; i < jsonObject.size(); i++) {

                JSONObject jsonObjectRow = (JSONObject) jsonObject.get(i);
                String num = (String) jsonObjectRow.get("id");
                String solution = (String) jsonObjectRow.get("response");
               
                out.println("<TR>");
                out.println("<td style= rowspan='7' align='center' bgcolor='#f8f8f8'>"+num+"</td>");	
                out.println("<td style= rowspan='7' align='center' bgcolor='#f8f8f8'>"+solution+"</td>");
                out.println("</TR>");
            }
           
            jsonObject = null;
            out.println("</TABLE>");
            
            



        }catch (IOException e) {
                e.printStackTrace();
        } catch (ParseException ex) {
                Logger.getLogger(ArchivoPreguntas.class.getName()).log(Level.SEVERE, null, ex);
        }

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
