/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sgc.model;

/**
 *
 * @author User
 */
public class SubClassification {
    int id,mid;    
    String name;
    private String mainClassificationName;

    public String getMainClassificationName() {
        return mainClassificationName;
    }

    public void setMainClassificationName(String mainClassificationName) {
        this.mainClassificationName = mainClassificationName;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMid() {
        return mid;
    }

    public void setMid(int mid) {
        this.mid = mid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
}
