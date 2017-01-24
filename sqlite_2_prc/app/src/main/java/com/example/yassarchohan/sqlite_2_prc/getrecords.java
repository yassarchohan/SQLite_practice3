package com.example.yassarchohan.sqlite_2_prc;

/**
 * Created by Yassar chohan on 11/6/2016.
 */
public class getrecords {

    String name;
    String fname;
    int marks;

    public getrecords(String name, String fname, int marks) {
        this.name = name;
        this.fname = fname;
        this.marks = marks;
    }

    public getrecords(){

    }

    public String getName() {
        return name;
    }

    public String getFname() {
        return fname;
    }

    public int getMarks() {
        return marks;
    }
}
