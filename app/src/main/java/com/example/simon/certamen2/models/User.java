package com.example.simon.certamen2.models;

import java.util.List;

/**
 * Created by simon on 30-09-2016.
 */

public class User {

    private int id;
    private String name;
    private String description;
    private String updated_at;
    private String htmlUrl;

    public void setName(String name){this.name = name;}
    public void setDescription(String description){this.description = description;}
    public void setUpdated_at(String updated_at){this.updated_at = updated_at;}
    public void setHtmlUrl(String htmlUrl){this.htmlUrl = htmlUrl;}

    public String getName(){return this.name;}
    public String getDescription(){return this.description;}
    public String getUpdated_at(){return this.updated_at;}
    public String getHtmlUrl(){return  this.htmlUrl;}
}
