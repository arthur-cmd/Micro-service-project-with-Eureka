package com.example.moviecatalog.Data;

import java.util.List;

public class UserRating {

    private List<Rating> userRating;

    public List<Rating> getUserRating(){
        return this.userRating;
    }

    public void setUserRating(List<Rating> userRating){

        this.userRating=userRating;

    }
}
