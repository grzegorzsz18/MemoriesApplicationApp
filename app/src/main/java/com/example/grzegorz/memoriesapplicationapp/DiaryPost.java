package com.example.grzegorz.memoriesapplicationapp;

import java.util.Date;

/**
 * Created by Grzegorz on 2017-07-31.
 */

public class DiaryPost {
    String title;
    long id;
    String author;
    String text;
    Date date;

    public DiaryPost(long id, String author, String title, String text, Date date){
        this.id = id;
        this.title = title;
        this.author = author;
        this.text = text;
        this.date = date;
    }

    public long getId(){
        return this.id;
    }

    public String getText(){
        return this.text;
    }

    public String getTitle(){
        return this.title;
    }

    public Date getDate(){
        return date;
    }

    public String getTransformedData(){
        return date.toGMTString();
    }

    public String toString(){
        return title + "  " + getTransformedData();
    }


}
