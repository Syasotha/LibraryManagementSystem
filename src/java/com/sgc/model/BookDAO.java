/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sgc.model;

import com.sgc.data.DbConnection;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

/**
 *
 * @author User
 */
public class BookDAO {

    public static void addbook(Book addbook) throws ClassNotFoundException, SQLException {
        DbConnection dbconnection = new DbConnection();
        Connection con = dbconnection.getDbConnection();
        Statement statement = con.createStatement();
        statement.executeUpdate("insert into book_details values ('" + addbook.getBookID() + "','" + addbook.getTitle() + "','" + addbook.getAuthor() + "','" + addbook.getSubClassiID() + "','" + addbook.getYearOfPublishing() + "','" + addbook.getLastprintedyear() + "','" + addbook.getISBNno() + "','" + addbook.getNoOfPages() + "')");

    }

    public static void updateBook(Book book) throws ClassNotFoundException, SQLException {
        DbConnection dbconnection = new DbConnection();
        Connection con = dbconnection.getDbConnection();
        Statement statement = con.createStatement();
        statement.executeUpdate("', title='" + "update book_details SET bookID='"+
                 book.getBookID() + book.getTitle() + "',authour='"+
                 book.getAuthor() + "',subClasiID'=" + book.getSubClassiID() +
                "',yearOfPublishing='" + book.getYearOfPublishing() + "',lastPrintedYear='" 
                + book.getLastprintedyear() + "',ISBNno='" + book.getISBNno() 
                + "',NoOfPages='" + book.getNoOfPages() + "')");

    }

    public static List<Book> getBooks(String key, String value) throws SQLException {
        DbConnection dbConnection = new DbConnection();
        Connection con = dbConnection.getDbConnection();

        String query = "SELECT b.bookID as bookid, b.title as title,"
                + " b.authour as author, m.title as mainClassification, "
                + "s.title as subClassification, b.yearOfPublishing as published,"
                + " b.lastPrintedYear as lastyear, b.ISBNno as ISBNno,"
                + " b.NoOfPages as noOfPages FROM lms.book_details b "
                + "LEFT JOIN lms.Sub_classification s on b.subClasiID=s.id"
                + " LEFT JOIN main_classification m on m.id=s.main_classification_id";
        if (key != null && value != null) {
            query += String.format(" where b.%s=\"%s\"", key, value);
        }

        Statement statement = con.createStatement();
        ResultSet rs;
        rs = statement.executeQuery(query);
        List<Book> results = new java.util.ArrayList<>();
        while (rs.next()) {
            Book addbook = new Book();
            addbook.setBookID(rs.getString("bookid"));
            addbook.setTitle(rs.getString("title"));
            addbook.setAuthor(rs.getString("author"));
            addbook.setMainClassificationName(rs.getString("mainClassification"));
            addbook.setSubClassificationName(rs.getString("subClassification"));
            addbook.setYearOfPublishing(rs.getInt("published"));
            addbook.setLastprintedyear(rs.getInt("lastyear"));
            addbook.setISBNno(rs.getString("ISBNno"));
            addbook.setNoOfPages(rs.getInt("noOfPages"));
            results.add(addbook);
        }
        return results;
    }
     //public static List<SubClassification> getSubClassific() throws SQLException{
   

}
