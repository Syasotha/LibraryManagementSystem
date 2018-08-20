/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sgc.controller;

import com.sgc.model.MainClassification;
import com.sgc.model.MainClassificationDAO;
import com.sgc.model.updateMainDao;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Yasotha
 */
@WebServlet(name = "mainUpdateController", urlPatterns = {"/mainUpdateController"})
public class mainUpdateController extends HttpServlet {
MainClassification mc=new MainClassification();
updateMainDao umDao=new updateMainDao();
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
            out.println("<title>Servlet mainUpdateController</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet mainUpdateController at " + request.getContextPath() + "</h1>");
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
        //processRequest(request, response);
         try {
        //processRequest(request, response);
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        mc.setId(Integer.parseInt(request.getParameter("mainClsID")));
        mc.setName(request.getParameter("mainClassification"));
        
        umDao.editMcBook(mc);
        
        
        List<MainClassification> maincl = MainClassificationDAO.getMainClassific();
        request.setAttribute("main", maincl);
        request.getRequestDispatcher("./pages/mainClasiSearchUpdate.jsp").forward(request, response);
    } catch (ClassNotFoundException ex) {
        Logger.getLogger(mainUpdateController.class.getName()).log(Level.SEVERE, null, ex);
    } catch (SQLException ex) {
        Logger.getLogger(mainUpdateController.class.getName()).log(Level.SEVERE, null, ex);
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
