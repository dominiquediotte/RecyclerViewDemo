package com.example.recyclerviewdemo.models;

import java.util.Date;

public class Todo {
    private Date mDateAdded;
    private String mTitle;
    private String mDescription;

    public Date getDateAdded() {
        return mDateAdded;
    }

    public void setDateAdded(Date dateAdded) {
        this.mDateAdded = dateAdded;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        this.mTitle = title;
    }

    public String getDescription() {
        return mDescription;
    }

    public void setDescription(String description) {
        this.mDescription = description;
    }

    public Todo(Date date, String title, String description) {
        mDateAdded = date;
        mTitle = title;
        mDescription = description;
    }
}
