package com.example.datawarehouse.DTO;

import java.util.List;

public class MovieActorSimple {
    private String title;
    private String actorName;
    private List<String> asins;

    public String getTitle() {
        return title;
    }

    public void setAsins(List<String> asins) {
        this.asins = asins;
    }

    public List<String> getAsins() {
        return asins;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getActorName() {
        return actorName;
    }

    public void setActorName(String actorName) {
        this.actorName = actorName;
    }
}
