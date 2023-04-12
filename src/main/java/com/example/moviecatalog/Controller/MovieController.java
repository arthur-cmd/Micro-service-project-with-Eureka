package com.example.moviecatalog.Controller;



import com.example.moviecatalog.Data.CatalogItems;
import com.example.moviecatalog.Data.Movie;
import com.example.moviecatalog.Data.Rating;
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



    @GetMapping ("{userid}")
    public List<CatalogItems> getCatalog(@PathVariable ("userid")  String userid){
        RestTemplate restTemplate= new RestTemplate();
        //get rated movie ids

        List<Rating> ratings = Arrays.asList(
                new Rating("56y7",9),
                new Rating("o107",6)

        );


        //get information of each rated movie ids
        return ratings.stream().map(rating ->{
               Movie movie = restTemplate.getForObject("http://localhost:8080/MovieInfo/"+ rating.getMovieId(),Movie.class);
               return new CatalogItems(movie.getName(), movie.getDescription(), rating.getRating());
                } ) .collect(Collectors.toList());


        //put them all together




    }
}
