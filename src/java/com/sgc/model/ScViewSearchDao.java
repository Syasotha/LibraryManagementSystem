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
public class ScViewSearchDao {
     public static List<SubClassification> getScDetails(String key, String value) throws SQLException {
         DbConnection dbConnection = new DbConnection(); 
        Connection con = dbConnection.getDbConnection();

        String query = "SELECT s.id as sid, s.title as stitle,m.title as mtitle, "
                + "m.id as mid FROM lms.sub_classification s "
                + " LEFT JOIN main_classification m on m.id=s.main_classification_id";
        if (key != null && value != null) {
            query = query + String.format(" where s.%s=\"%s\"", key, value);
            //query += String.format(" where s.%s=\"%s\"", key, value);
        }

        Statement statement = con.createStatement();
        ResultSet rs = statement.executeQuery(query);
        List<SubClassification> results = new java.util.ArrayList<>();
        while (rs.next()) {
            SubClassification editSclassi = new SubClassification();
            editSclassi.setId(rs.getInt("sid"));
            editSclassi.setMainClassificationName(rs.getString("mtitle"));
            editSclassi.setName(rs.getString("stitle"));
            editSclassi.setMid(rs.getInt("mid"));
            results.add(editSclassi);
        }
        return results;
    }
}