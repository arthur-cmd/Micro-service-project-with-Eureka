package com.example.moviecatalog.Data;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data

public class Rating {

    private String MovieId;
    private int rating;
}
