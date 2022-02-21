package com.opticsolutions.moviecatalogservice.resources;

import com.opticsolutions.moviecatalogservice.Models.CatalogItem;
import com.opticsolutions.moviecatalogservice.Models.Movie;
import com.opticsolutions.moviecatalogservice.Models.Rating;
import com.opticsolutions.moviecatalogservice.Models.UserRating;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/catalog")
public class MovieCatalogResource {
    // creating the object of the rest template using bean method
    @Autowired
    private RestTemplate template;


    @RequestMapping("/{userId}")
    public List<CatalogItem> getCatalog(@PathVariable("userId") int userId){

        // get  all the rating movies Ids,
        UserRating userRating = template.getForObject("http://localhost:8083/ratingsdata/users/" + userId, UserRating.class);

        // for each movieid, call a movie info service to get details

        // putting everything together
        return userRating.getRatings().stream().map(rating-> {
            Movie movie = template.getForObject("http://localhost:8082/movies/" + rating.getMovieId(), Movie.class);
            System.out.println(movie);
            assert movie != null;
            return  new CatalogItem(movie.getName(), "test", rating.getRating());
        }).collect(Collectors.toList());
    }
}
