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
public class SubClassificationDAO {
     public static void addsubclassific(SubClassification subclassificarion) throws ClassNotFoundException,SQLException {
        DbConnection dbconnection = new DbConnection();
        Connection con = dbconnection.getDbConnection();        
        Statement statement = con.createStatement(); 
        statement.executeUpdate ("insert into sub_classification values (0,'"+subclassificarion.getMid()+"','"+subclassificarion.getName()+"')");

    }
     public static List<SubClassification> getSubClassific() throws SQLException{
        DbConnection dbConnection = new DbConnection();
        Connection con = dbConnection.getDbConnection();
        Statement statement = con.createStatement();
        ResultSet rst = statement.executeQuery("select * from sub_classification");
        List<SubClassification> results = new java.util.ArrayList<>();
        while(rst.next()) {
            SubClassification subCla = new SubClassification();
            subCla.setId(rst.getInt("id"));
            subCla.setMid(rst.getInt("main_classification_id"));
            subCla.setName(rst.getString("title"));
            results.add(subCla);
        }
        return results;
    }
     public static List<SubClassification> getChangeSubclassi(String mid) throws SQLException{
        List<SubClassification> results = new java.util.ArrayList<>();
    try{    
        DbConnection dbConnection = new DbConnection();
        Connection con = dbConnection.getDbConnection();
        Statement statement = con.createStatement();
        String query="select * from sub_classification  where main_classification_id='"+mid+"'";
      ResultSet rs= statement.executeQuery(query);              
       
            while (rs.next()) {
                SubClassification subCla = new SubClassification();
                
                subCla.setName(rs.getString("title"));
              
                
            results.add(subCla);
               
            }
            
        }
             
      catch(SQLException e)
       {
           System.out.println(e.toString());
       }
       
    return results;  
     }
}
