package com.example.datawarehouse.dto;

import java.util.List;

public class MovieCommon {
    private String title; // 电影名称
    private String releaseDate; // 上映时间
    private String rating; // 电影评级
    private String producer; // 电影制片人（所有制片人字符串拼接）
    private String language; // 电影语言
    private String genre; //电影类别
    private String formatNum;//版本数量
    private List<String> asins; //所有asins


    public String getTitle() {
        return title;
    }

    public void setTitle(String filmTitle) {
        this.title = filmTitle;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public String getFormatNum() {
        return formatNum;
    }

    public void setFormatNum(String formatNum) {
        this.formatNum = formatNum;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public List<String> getAsins() {
        return asins;
    }

    public void setAsins(List<String> asins) {
        this.asins = asins;
    }
}
