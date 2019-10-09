/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation;

import database.SQLMapper;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import logic.Book;

/**
 *
 * @author casper
 */
@WebServlet(name = "FrontController", urlPatterns = {"/FrontController"})
public class FrontController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     * @throws java.sql.SQLException
     * @throws java.lang.ClassNotFoundException
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException, ClassNotFoundException {
        response.setContentType("text/html;charset=UTF-8");

        if (request.getParameter("cmd").equals("search")) {
            //request.setAttribute("input", request.getParameter("input"));
            //request.setAttribute("type", request.getParameter("type"));
            request.getSession().setAttribute("input", request.getParameter("input"));
            request.getSession().setAttribute("type", request.getParameter("type"));

            RequestDispatcher rd = request.getRequestDispatcher("SearchResults.jsp");
            rd.forward(request, response);

        }
        if(request.getParameter("cmd").equals("gocheckout")){
            
            request.getSession().setAttribute("book", request.getParameter("book"));
            request.getSession().setAttribute("bookID", Integer.parseInt(request.getParameter("id")));
            RequestDispatcher rd = request.getRequestDispatcher("CheckOut.jsp");
            rd.forward(request, response);
        }
        if(request.getParameter("cmd").equals("processOrder")){
            
            SQLMapper mapper = new SQLMapper();
           
            mapper.createOrder(request.getParameter("firstName"),request.getParameter("lastName"), request.getParameter("email"), (int)request.getSession().getAttribute("bookID"));
            
            //mapper.createOrder(request.getParameter("firstName"),request.getParameter("lastName"), request.getParameter("email"), (int)request.getSession().getAttribute("bookID"));
            request.getSession().setAttribute("firstName", request.getParameter("firstName"));
            request.getSession().setAttribute("lastName", request.getParameter("lastName"));
            request.getSession().setAttribute("email", request.getParameter("email"));
            request.getSession().setAttribute("bookID", request.getSession().getAttribute("bookID"));
            
            RequestDispatcher rd = request.getRequestDispatcher("Confirmation.jsp");
            rd.forward(request, response);
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
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(FrontController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(FrontController.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(FrontController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(FrontController.class.getName()).log(Level.SEVERE, null, ex);
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
