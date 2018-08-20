/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sgc.model;

import com.sgc.controller.deleteBookController;
import com.sgc.data.DbConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Yasotha
 */
public class deleteDao {
     public static void deleteBook(String bookId) throws ClassNotFoundException, SQLException {
        DbConnection dbconnection = new DbConnection();
        Connection con = dbconnection.getDbConnection();
       // Statement statement = con.createStatement();
         PreparedStatement ps=null;
        String query="DELETE from book_details  where bookID=?";
        //statement.executeQuery(query); 
        ps=con.prepareStatement(query);
        ps.setString(1,bookId);
        ps.executeUpdate();
    }
     
        public static void deleteMainClasi(String mid) throws ClassNotFoundException, SQLException {
        DbConnection dbconnection = new DbConnection();
        Connection con = dbconnection.getDbConnection();
        //Statement statement = con.createStatement();
         PreparedStatement ps=null;
        String query="DELETE from main_classification  where id=?";
        //statement.executeQuery(query); 
        ps=con.prepareStatement(query);
        ps.setString(1,mid);
        ps.executeUpdate();
    }
        
         public static void deleteSubClasi(String sid) throws ClassNotFoundException, SQLException {
        DbConnection dbconnection = new DbConnection();
        Connection con = dbconnection.getDbConnection();
        //Statement statement = con.createStatement();
         PreparedStatement ps=null;
        String query="DELETE from sub_classification  where id=?";
        //statement.executeQuery(query); 
        ps=con.prepareStatement(query);
        ps.setString(1,sid);
        ps.executeUpdate();
    }
    
}
