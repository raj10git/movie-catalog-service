package com.rajat.moviecatalogservice.controllers;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.rajat.moviecatalogservice.Model.CatalogItem;
import com.rajat.moviecatalogservice.Model.MovieInfoModel;
import com.rajat.moviecatalogservice.Model.Rating;

@RestController
@RequestMapping("/catalog")
public class MovieCatalogController {
    
    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("/{userId}")
    public List<CatalogItem> getCatalog(@PathVariable("userId") String userId){

        List<Rating> ratings = Arrays.asList(
            new Rating("001", "3"),
            new Rating("002", "4")
        );

        return ratings.stream().map(rating -> {
            MovieInfoModel movie =  restTemplate.getForObject("http://localhost:8082/movies/" + rating.getMovieId(), MovieInfoModel.class);
            return new CatalogItem(movie.getName(), movie.getDescription(), rating.getRating());
        })
            .collect(Collectors.toList());
    }
}
