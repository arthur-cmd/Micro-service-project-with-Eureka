package com.example.moviecatalog.Controller;



import com.example.moviecatalog.Data.CatalogItems;
import com.example.moviecatalog.Data.Movie;
import com.example.moviecatalog.Data.Rating;
import com.example.moviecatalog.Data.UserRating;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class MovieController {
@Autowired
private RestTemplate restTemplate;

    @GetMapping ("{userid}")
    public List<CatalogItems> getCatalog(@PathVariable ("userid")  String userid){
        RestTemplate restTemplate= new RestTemplate();
        //get rated movie ids

        UserRating ratings = restTemplate.getForObject("http://movie-rating/MovieRating/user/" + userid, UserRating.class);


        //get information of each rated movie ids
        return ratings.getUserRating().stream().map(rating ->{
               Movie movie = restTemplate.getForObject("http://movie-info/MovieInfo/"+ rating.getMovieId(),Movie.class);

            //put them all together
               return new CatalogItems(movie.getName(), movie.getDescription(), rating.getRating());
                } ) .collect(Collectors.toList());







    }
}
