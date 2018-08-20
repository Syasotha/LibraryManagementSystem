/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sgc.controller;

import com.sgc.model.Book;
import com.sgc.model.BookDAO;
import com.sgc.model.SubClassification;
import com.sgc.model.SubClassificationDAO;
import com.sgc.model.searchUpdateDao;
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
@WebServlet(name = "updateController", urlPatterns = {"/updateController"})
public class updateController extends HttpServlet {
    Book book=new Book();
    searchUpdateDao sudao=new searchUpdateDao();
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
            out.println("<title>Servlet updateController</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet updateController at " + request.getContextPath() + "</h1>");
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
        try {
            //processRequest(request, response);
            List<SubClassification> subClassificatons = SubClassificationDAO.getSubClassific();
            request.setAttribute("subClassifications", subClassificatons);
             List<Book> books = BookDAO.getBooks(null,null);
            request.setAttribute("books", books);
            new onchangeBookUpdate().doPost(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(updateController.class.getName()).log(Level.SEVERE, null, ex);
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
            // processRequest(request, response);
            response.setContentType("text/html");
            PrintWriter out = response.getWriter();
            book.setBookID(request.getParameter("bookID"));
            book.setTitle(request.getParameter("title"));
            book.setAuthor(request.getParameter("auth"));
            book.setSubClassiID(Integer.parseInt(request.getParameter("sID")));
            book.setYearOfPublishing(Integer.parseInt(request.getParameter("YofPublish")));
            book.setLastprintedyear(Integer.parseInt(request.getParameter("lastPrintYr")));
            book.setISBNno(request.getParameter("ISBNno"));
            book.setNoOfPages(Integer.parseInt(request.getParameter("NoOfPages")));
            
            sudao.editBook(book);
              List<Book> books = BookDAO.getBooks(null,null);
            request.setAttribute("books", books);
            request.getRequestDispatcher("./pages/Books.jsp").forward(request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(updateController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(updateController.class.getName()).log(Level.SEVERE, null, ex);
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
