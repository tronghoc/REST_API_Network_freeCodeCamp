package com.example.api_android;

public class Movie {
    private int id;
    private String title;
    private double rating;
    private String poster;

    private MoreDetails moreDetails;
     //Contructor

    public Movie(int id, String title, double rating, String poster, MoreDetails moreDetails) {
        this.id = id;
        this.title = title;
        this.rating = rating;
        this.poster = poster;
        this.moreDetails = moreDetails;
    }

    //Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public String getPoster() {
        return poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }

    public MoreDetails getMoreDetails() {
        return moreDetails;
    }

    public void setMoreDetails(MoreDetails moreDetails) {
        this.moreDetails = moreDetails;
    }
}
