package com.example.movieinfoservice;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/MovieInfo")
public class MovieInfoController {

    @GetMapping("/{MovieId}")
    public Movie getMovieInfo(@PathVariable ("MovieId") String MovieId){

        return  new Movie(MovieId,"Transformers","Robots alliens which tranform into cars where they protect earth from aliiens");

    }



}
