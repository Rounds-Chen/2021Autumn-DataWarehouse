package com.example.datawarehouse.dto;

import java.util.List;

public class MovieSimple {
    private String title;
    private String releaseDate;
    private String rating; // 电影评级
    private String genre; //电影类别
    private List<String> asins; //所有asins

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public void setAsins(List<String> asins) {
        this.asins = asins;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public List<String> getAsins() {
        return asins;
    }

    public String getReleaseDate() {
        return releaseDate;
    }
}
