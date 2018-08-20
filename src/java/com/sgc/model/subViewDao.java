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
public class subViewDao {
     public static List<SubClassification> getsubTableDe() throws SQLException{
        SubClassification viewSub=null;
        DbConnection dbConnection = new DbConnection();
        Connection con = dbConnection.getDbConnection();
        Statement statement = con.createStatement();
        ResultSet rs = statement.executeQuery("SELECT s.id as sid, s.title as stitle,m.title as mtitle, "
                + "m.id as mid FROM lms.sub_classification s "
                + " LEFT JOIN main_classification m on m.id=s.main_classification_id");
        List<SubClassification> results = new java.util.ArrayList<>();
        while(rs.next()) {
            viewSub = new SubClassification();
            viewSub.setId(rs.getInt("sid"));
            viewSub.setMid(rs.getInt("mid"));
            viewSub.setMainClassificationName(rs.getString("mtitle"));
            viewSub.setName(rs.getString("stitle"));
            
            results.add(viewSub);
        }
        return results;
    }
     
    
}
