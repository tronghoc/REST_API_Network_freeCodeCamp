package com.example.api_android;

public class MoreDetails {
    private String release;
    private String catecory;
    private String duration;



    //Getters
    public String getRelease() {
        return release;
    }

    public String getCatecory() {
        return catecory;
    }

    public String getDuration() {
        return duration;
    }

    //Contructor

    public MoreDetails(String release, String catecory, String duration) {
        this.release = release;
        this.catecory = catecory;
        this.duration = duration;
    }
}
