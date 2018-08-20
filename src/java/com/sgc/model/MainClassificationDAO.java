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
import java.util.ArrayList;

/**
 *
 * @author User
 */
public class MainClassificationDAO {
     public static void addmainclassific(MainClassification mainClassification) throws ClassNotFoundException,SQLException {
        DbConnection dbconnection = new DbConnection();
        Connection con = dbconnection.getDbConnection();        
        Statement statement = con.createStatement(); 
        statement.executeUpdate ("insert into main_classification values (0,'"+mainClassification.getName()+"')");

    }
    public static List<MainClassification> getMainClassific() throws SQLException{
        DbConnection dbConnection = new DbConnection();
        Connection con = dbConnection.getDbConnection();
        Statement statement = con.createStatement();
        ResultSet rs = statement.executeQuery("select * from main_classification");
        List<MainClassification> results = new ArrayList<>();
        while(rs.next()) {
            MainClassification mainCla = new MainClassification();
            mainCla.setName(rs.getString("title"));
            mainCla.setId(rs.getInt("id"));
            results.add(mainCla);
        }
        return results;
    }
    public static List<MainClassification> getmainClassi() throws SQLException {
        DbConnection dbConnection = new DbConnection();
        Connection con = dbConnection.getDbConnection();

        String query = "SELECT * from main_classification";
         Statement statement = con.createStatement();
        ResultSet rs = statement.executeQuery(query);
        List<MainClassification> results = new java.util.ArrayList<>();
        while (rs.next()) {
            MainClassification addmainc = new MainClassification();
            addmainc.setId(rs.getInt("id"));
            addmainc.setName(rs.getString("title"));
            results.add(addmainc);
        }
        return results;
    }
}
