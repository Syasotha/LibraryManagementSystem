/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sgc.model;

import com.sgc.data.DbConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Yasotha
 */
public class searchUpdateDao {
    public static void editBook(Book book) throws ClassNotFoundException, SQLException{
        try { 
        DbConnection dbConnection = new DbConnection();
        Connection con = dbConnection.getDbConnection();
        
        Statement stmt =con.createStatement();
       String sql = "UPDATE book_details SET "
            + "title='" + book.getTitle() + "' ,"
            + " authour='"+book.getAuthor()+"' ,"
           // + "mainClassification='"+book.getMainClassificationName()+"' ,"
           // + "subClasiID='"+book.getMainClassificationName()+"' ,"
            + "yearOfPublishing='"+book.getYearOfPublishing()+"' ,"
            + "lastPrintedYear='"+book.getLastprintedyear()+"' ,"
            + "ISBNno='"+book.getISBNno()+"' ,"
            + "NoOfPages='"+book.getNoOfPages()+"' "
            + "WHERE bookID='" + book.getBookID() + "' ";
            stmt.executeUpdate(sql);
        } 
        catch (SQLException ex) {
            Logger.getLogger(searchUpdateDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    public Book getBookById(String bookId) throws SQLException{
        DbConnection dbConnection = new DbConnection();
        Connection con = dbConnection.getDbConnection();
        Statement statement = con.createStatement();
        String query = "SELECT b.bookID as bookid, b.title as title,"
                + " b.authour as author, m.title as mainClassification, "
                + "s.title as subClassification, b.yearOfPublishing as published,"
                + " b.lastPrintedYear as lastyear, b.ISBNno as ISBNno,"
                + " b.NoOfPages as noOfPages FROM lms.book_details b "
                + "LEFT JOIN lms.Sub_classification s on b.subClasiID=s.id"
                + " LEFT JOIN main_classification m on m.id=s.main_classification_id"
                + " WHERE b.bookID = \"" + bookId + "\";";
        
        ResultSet rs= statement.executeQuery(query);  
        
       
            while (rs.next()) {
            Book addbook = new Book();
            addbook.setBookID(rs.getString("bookid"));
            addbook.setTitle(rs.getString("title"));
            addbook.setAuthor(rs.getString("author"));
            //addbook.setMainClassiID(rs.getInt("main_classification_id"));
            addbook.setMainClassificationName(rs.getString("mainClassification"));
            addbook.setSubClassificationName(rs.getString("subClassification"));
            addbook.setYearOfPublishing(rs.getInt("published"));
            addbook.setLastprintedyear(rs.getInt("lastyear"));
            addbook.setISBNno(rs.getString("ISBNno"));
            addbook.setNoOfPages(rs.getInt("noOfPages"));
            
            return addbook;

                }
            

            return null;
            
  }
}