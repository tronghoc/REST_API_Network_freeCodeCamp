package com.example.api_android;

public class JSONResponse {
    private Movie[] moviz;

    public Movie[] getMovies(){
        return moviz;
    }

    public void setMoviesArray(Movie[] moviesArray){
        this.moviz= moviesArray;
    }
}
