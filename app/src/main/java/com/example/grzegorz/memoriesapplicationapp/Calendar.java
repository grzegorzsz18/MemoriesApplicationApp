package com.example.grzegorz.memoriesapplicationapp;

import java.util.Date;

public class Calendar {
    private int id;
    long creationTime;
    long executionTime;
    long timeBeforeRemind;
    String user;
    String text;
    String title;
    boolean sendEmail;
    int priority;

    public Calendar() {

    }

    public Calendar(long creationTime, long executionTime, long timeBeforeRemind, String user, String text, String title,
                    boolean sendEmail, int priority) {
        this.creationTime = creationTime;
        this.executionTime = executionTime;
        this.timeBeforeRemind = timeBeforeRemind;
        this.user = user;
        this.text = text;
        this.title = title;
        this.sendEmail = sendEmail;
        this.priority = priority;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public long getCreationTime() {
        return creationTime;
    }
    public void setCreationTime(long creationTime) {
        this.creationTime = creationTime;
    }
    public long getExecutionTime() {
        return executionTime;
    }
    public void setExecutionTime(long executionTime) {
        this.executionTime = executionTime;
    }
    public long getTimeBeforeRemind() {
        return timeBeforeRemind;
    }
    public void setTimeBeforeRemind(long timeBeforeRemind) {
        this.timeBeforeRemind = timeBeforeRemind;
    }

    public String getText() {
        return text;
    }
    public void setText(String text) {
        this.text = text;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public boolean isSendEmail() {
        return sendEmail;
    }
    public void setSendEmail(boolean sendEmail) {
        this.sendEmail = sendEmail;
    }
    public int getPriority() {
        return priority;
    }
    public void setPriority(int priority) {
        this.priority = priority;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }
    private String displayExecutionTime(){
        return new Date(getExecutionTime()).toGMTString();
    }
    public String toString(){
        return displayExecutionTime() + " " + title;
    }
}

