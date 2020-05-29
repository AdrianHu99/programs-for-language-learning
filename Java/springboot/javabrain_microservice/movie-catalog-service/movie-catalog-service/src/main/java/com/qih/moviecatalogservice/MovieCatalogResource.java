package com.qih.moviecatalogservice;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.qih.moviecatalogservice.model.CatalogItem;
import com.qih.moviecatalogservice.model.Movie;
import com.qih.moviecatalogservice.model.Rating;
import com.qih.moviecatalogservice.model.UserRating;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

// 1. How do I make this as a REST resource? Add an annotation!
@RestController
@RequestMapping("/catalog")
public class MovieCatalogResource {

    // 4. Make restTemplate a singleton, to save resource
    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    MovieInfo movieInfo;

    @Autowired
    UserRatingInfo userRatingInfo;

    // 2. Make this mapping to certain request
    // 3. Get all rated movie IDs, for each movie ID, call movie info service to get details
    @RequestMapping("/{userId}")
    public List<CatalogItem> getCatalog(@PathVariable("userId") String userId) {

        UserRating ratings = userRatingInfo.getUserRating(userId);

        return ratings.getRatings().stream().map(rating -> {
            return movieInfo.getCatalogItem(rating);
        }).collect(Collectors.toList());
    }


}
