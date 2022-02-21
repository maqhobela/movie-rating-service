package com.opticsolutions.ratingsdataservice.controllers;

import com.opticsolutions.ratingsdataservice.models.Rating;
import com.opticsolutions.ratingsdataservice.models.UserRating;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/ratingsdata")
public class RatingsDataResource {
    @RequestMapping("/{movieId}")
    public Rating getRating(@PathVariable("movieId") int movieId){
        return new Rating(movieId, 5);
    }

    @RequestMapping("/users/{userId}")
    public UserRating getUserRating(@PathVariable("userId") int userId){
        List<Rating> ratings = Arrays.asList(
                new Rating(123, 4),
                new Rating(321, 5)
        );

        UserRating userRating = new UserRating();
        userRating.setRatings(ratings);
        return userRating;
    }
}
