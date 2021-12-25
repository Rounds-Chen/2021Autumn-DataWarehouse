package com.example.datawarehouse.dto;

import java.util.List;

public class MovieDirectorSimple {
    private String peopleName;
    private String title;
    private List<String> asins;

    public void setPeopleName(String peopleName) {
        this.peopleName = peopleName;
    }

    public String getPeopleName() {
        return peopleName;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setAsins(List<String> asins) {
        this.asins = asins;
    }

    public List<String> getAsins() {
        return asins;
    }
}
