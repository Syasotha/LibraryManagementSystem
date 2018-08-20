/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sgc.controller;

import com.sgc.model.MainClassification;
import com.sgc.model.MainClassificationDAO;
import com.sgc.model.SubClassification;
import com.sgc.model.SubClassificationDAO;
import static com.sun.org.apache.xalan.internal.xsltc.compiler.util.Type.String;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Yasotha
 */
@WebServlet(name = "changeSubclassificationController", urlPatterns = {"/changeSubclassificationController"})
public class changeSubclassificationController extends HttpServlet {

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
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet changeSubclassificationController</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet changeSubclassificationController at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
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
       // processRequest(request, response);
       String mid=request.getParameter("mainClassificationId");
        try {
            //processRequest(request, response);
            List<MainClassification> mainClassificatons = MainClassificationDAO.getMainClassific();
            request.setAttribute("mainClassifications", mainClassificatons);
            
            List<SubClassification> subClassificatons = SubClassificationDAO.getChangeSubclassi(mid);
            request.setAttribute("subClassifications", subClassificatons);
             
            request.setAttribute("bookID", request.getParameter("bookID"));
            request.setAttribute("title", request.getParameter("title"));
            request.setAttribute("auth", request.getParameter("auth"));
            request.setAttribute("mainClassificationId", request.getParameter("mainClassificationId"));
            request.setAttribute("sID", request.getParameter("sID"));
            
            
         //   List<SubClassification> SubClassifica =SubClassificationDAO.getChangeSubclassi(mid);
         //   request.setAttribute("subClassifications", SubClassifica);
           
            
        
            
            request.getRequestDispatcher("./pages/AddBookDetails.jsp").forward(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(changeSubclassificationController.class.getName()).log(Level.SEVERE, null, ex);
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
