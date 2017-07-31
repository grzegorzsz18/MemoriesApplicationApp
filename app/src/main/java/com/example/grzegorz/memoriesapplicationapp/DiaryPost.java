package com.example.grzegorz.memoriesapplicationapp;

import java.util.Date;

/**
 * Created by Grzegorz on 2017-07-31.
 */

public class DiaryPost {
    long id;
    String author;
    String text;
    Date date;

    public DiaryPost(long id, String author, String text, Date date){
        this.id = id;
        this.author = author;
        this.text = text;
        this.date = date;
    }


}
