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
 * @author Yasotha
 */
public class McSearchViewDao {
     public static List<MainClassification> getMcDetails(String key, String value) throws SQLException {
        DbConnection dbconnection = new DbConnection();
        Connection con = dbconnection.getDbConnection(); 
        Statement statement = con.createStatement();
        String query = "select * from main_classification";

        if (key != null && value != null) {

            query += String.format(" where main_classification.%s=\"%s\"", key, value);
        }
        ResultSet rs = statement.executeQuery(query);
       List<MainClassification> results = new java.util.ArrayList<>();
        while (rs.next()) {
            MainClassification Mc = new MainClassification();
            Mc.setId(rs.getInt("id"));
            Mc.setName(rs.getString("title"));

            results.add(Mc);
            //System.out.println(rs.getString("M_Classi"));
        }
        return results;

    }
    
}
