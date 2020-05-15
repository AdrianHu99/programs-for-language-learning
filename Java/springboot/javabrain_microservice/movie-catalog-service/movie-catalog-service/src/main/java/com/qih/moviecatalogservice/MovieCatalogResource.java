package com.qih.moviecatalogservice;

import com.qih.moviecatalogservice.model.CatalogItem;
import com.qih.moviecatalogservice.model.Movie;
import com.qih.moviecatalogservice.model.Rating;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

// 1. How do I make this as a REST resource? Add an annotation!
@RestController
@RequestMapping("/catalog")
public class MovieCatalogResource {

    // 4. Make restTemplate a singleton, to save resource
    @Autowired
    private RestTemplate restTemplate;

    // 2. Make this mapping to certain request
    // 3. Get all rated movie IDs, for each movie ID, call movie info service to get details
    @RequestMapping("/{var1}")
    public List<CatalogItem> getCatalog(@PathVariable("var1") String userId) {

        List<Rating> ratings = Arrays.asList(
                new Rating("12", 5),
                new Rating("13", 4)
        );

        return ratings.stream().map(rating -> {
            Movie movie = restTemplate.getForObject("http://localhost:8082/movies/" + rating.getMovieId(), Movie.class);
            return new CatalogItem(movie.getName(), "TestDescription", rating.getRating());
        }).collect(Collectors.toList());
    }
}
