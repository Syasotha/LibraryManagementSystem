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
public class Book {
    String bookID,title,author,ISBNno;
    int subClassiID,yearOfPublishing,lastprintedyear,noOfPages,mainClassiID;
    private String mainClassificationName;
    private String subClassificationName;

    public int getMainClassiID() {
        return mainClassiID;
    }

    public void setMainClassiID(int mainClassiID) {
        this.mainClassiID = mainClassiID;
    }

    public String getMainClassificationName() {
        return mainClassificationName;
    }

    public void setMainClassificationName(String mainClassificationName) {
        this.mainClassificationName = mainClassificationName;
    }

    public String getSubClassificationName() {
        return subClassificationName;
    }

    public void setSubClassificationName(String subClassificationName) {
        this.subClassificationName = subClassificationName;
    }

    public String getBookID() {
        return bookID;
    }

    public void setBookID(String bookID) {
        this.bookID = bookID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getISBNno() {
        return ISBNno;
    }

    public void setISBNno(String ISBNno) {
        this.ISBNno = ISBNno;
    }

    public int getSubClassiID() {
        return subClassiID;
    }

    public void setSubClassiID(int subClassiID) {
        this.subClassiID = subClassiID;
    }

    public int getYearOfPublishing() {
        return yearOfPublishing;
    }

    public void setYearOfPublishing(int yearOfPublishing) {
        this.yearOfPublishing = yearOfPublishing;
    }

    public int getLastprintedyear() {
        return lastprintedyear;
    }

    public void setLastprintedyear(int lastprintedyear) {
        this.lastprintedyear = lastprintedyear;
    }

    public int getNoOfPages() {
        return noOfPages;
    }

    public void setNoOfPages(int noOfPages) {
        this.noOfPages = noOfPages;
    }
    
}
