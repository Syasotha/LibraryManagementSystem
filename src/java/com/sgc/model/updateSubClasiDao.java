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
public class updateSubClasiDao {
     public SubClassification getSubClasiById(String sid) throws SQLException{
         SubClassification editSub=null;
        DbConnection dbConnection = new DbConnection();
        Connection con = dbConnection.getDbConnection();
        Statement statement = con.createStatement();
        String query="SELECT s.id as sid, s.main_classification_id as mid, s.title as stitle,m.title as mtitle "
                + "FROM lms.sub_classification s "
                + " LEFT JOIN main_classification m on m.id=s.main_classification_id"
                + " WHERE s.id = \"" + sid + "\";";
                        
        ResultSet rs= statement.executeQuery(query);  
           
            if(rs.next()) {
                
            editSub = new SubClassification();
            editSub.setId(rs.getInt("sid"));
            editSub.setMid(rs.getInt("mid"));
            editSub.setMainClassificationName(rs.getString("mtitle"));
            editSub.setName(rs.getString("stitle"));
               return editSub;

                }
                 return null;
            
  }
      public static void updateSubclassific(SubClassification subclassification) {
         try {
             DbConnection dbconnection = new DbConnection();
             Connection con = dbconnection.getDbConnection();
             Statement statement = con.createStatement();
             statement.executeUpdate("UPDATE sub_classification SET " +
                     "main_classification_id = '" + subclassification.getMid() +
                     "', title = '"+ subclassification.getName() +
                     "' WHERE (id = '" + subclassification.getId() +"');");
         } catch (SQLException ex) {
             Logger.getLogger(updateSubClasiDao.class.getName()).log(Level.SEVERE, null, ex);
         }

    }
    
}
