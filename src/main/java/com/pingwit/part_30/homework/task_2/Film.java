package com.pingwit.part_30.homework.task_2;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Film {
    @JsonProperty("h2")
    private String movieName;
    @JsonProperty("b")
    private String description;
    @JsonProperty("excerpt")
    private String excerpt;

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public String getDescription(String text) {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getExcerpt() {
        return excerpt;
    }

    public void setExcerpt(String excerpt) {
        this.excerpt = excerpt;
    }

    @Override
    public String toString() {
        return "Film{" +
                "movieName='" + movieName + '\'' +
                ", description='" + description + '\'' +
                ", excerpt='" + excerpt + '\'' +
                '}';
    }
}
