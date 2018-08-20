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
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Yasotha
 */
public class updateMainDao {
  public static void editMcBook(MainClassification mcbook) throws ClassNotFoundException, SQLException{
        try { 
        DbConnection dbconnection = new DbConnection();
        Connection con = dbconnection.getDbConnection();
        Statement stmt =con.createStatement();
       String sql = "UPDATE main_classification SET "
            + "id='" + mcbook.getId() + "' ,"
            + " title='"+mcbook.getName()+"' "
               + "WHERE id='" + mcbook.getId() + "' ";
            stmt.executeUpdate(sql);
        } 
        catch (SQLException ex) {
            Logger.getLogger(updateMainDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    public MainClassification getMainClasiById(String mid) throws SQLException{
        DbConnection dbConnection = new DbConnection();
        Connection con = dbConnection.getDbConnection();
        Statement statement = con.createStatement();
        String query="select * from main_classification where id='"+mid+"'";
        ResultSet rs= statement.executeQuery(query);  
               
            while (rs.next()) {
               MainClassification mc=new MainClassification();
                
               mc.setId(rs.getInt("id"));
               mc.setName(rs.getString("title"));
               
       
                return mc;

                }
            

            return null;
            
  }
   
}
