package com.example.grzegorz.memoriesapplicationapp;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.Date;

/**
 * Created by Grzegorz on 2017-07-31.
 */

public class DiaryPost {
    @SerializedName("title")
    @Expose
    String title;
    @SerializedName("id")
    @Expose
    long id;
    @SerializedName("authorId")
    @Expose
    String authorId;
    @SerializedName("text")
    @Expose
    String text;
    @SerializedName("date")
    @Expose
    long date;

    public DiaryPost(){

    }


    public DiaryPost(long id, String author, String title, String text, long date){

        this.id = id;
        this.title = title;
        this.authorId = author;
        this.text = text;
        this.date = date;
    }


    public void setTitle(String title) {
        this.title = title;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setAuthor(String author) {
        this.authorId = author;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setDate(long date) {
        this.date = date;
    }

    public String getAuthorId(){return this.authorId;}

    public long getId(){
        return this.id;
    }

    public String getText(){
        return this.text;
    }

    public String getTitle(){
        return this.title;
    }

    public long getDate(){
        return date;
    }

    public String getTransformedData(){
        return new Date(date).toGMTString();
    }

    public String toString(){
        return title + "  " + getTransformedData();
    }


}
