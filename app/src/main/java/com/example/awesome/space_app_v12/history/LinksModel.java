package com.example.awesome.space_app_v12.history;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class LinksModel {

    @SerializedName("reddit")
    @Expose
    private Object reddit;
    @SerializedName("article")
    @Expose
    private String article;
    @SerializedName("wikipedia")
    @Expose
    private String wikipedia;

    public Object getReddit() {
        return reddit;
    }

    public void setReddit(Object reddit) {
        this.reddit = reddit;
    }

    public String getArticle() {
        return article;
    }

    public void setArticle(String article) {
        this.article = article;
    }

    public String getWikipedia() {
        return wikipedia;
    }

    public void setWikipedia(String wikipedia) {
        this.wikipedia = wikipedia;
    }
}

