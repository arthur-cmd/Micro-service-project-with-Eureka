package com.example.movieratingservice;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/MovieRating")
public class MovieRatingController {


    @GetMapping("{MovieId}")
    public Rating getMovieRate(@PathVariable ("MovieId") String MovieId){

        return new Rating(MovieId,7);

    }

    @GetMapping("user/{userid}")
    public UserRating getUserRating(@PathVariable ("userid") String userid){
      List<Rating>ratings= Arrays.asList(
              new Rating("789",9),
              new Rating("i98u",7)
      );

      UserRating userrating= new UserRating();
      userrating.setUserRating(ratings);
      return userrating;


    }
}
