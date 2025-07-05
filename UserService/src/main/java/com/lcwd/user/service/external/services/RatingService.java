package com.lcwd.user.service.external.services;

import com.lcwd.user.service.entities.Rating;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@FeignClient(name = "RATING-SERVICE")
public interface RatingService {

    // Define methods to interact with the Rating Service

    @GetMapping("/ratings/users/{userId}")
    Rating[] getRatingsByUserId(@PathVariable String userId);

    @PostMapping("/ratings")
    ResponseEntity<Rating> createRating(@RequestBody Rating rating);

    @GetMapping("ratings/hotels/{hotelId}")
    ResponseEntity<List<Rating>> getRatingByHotelId(@PathVariable String hotelId);

    @PutMapping("/ratings/{ratingId}")
    ResponseEntity<Rating> updateRating(@PathVariable String ratingId, @RequestBody Rating rating);

    @DeleteMapping("/ratings/{ratingId}")
    ResponseEntity<Void> deleteRating(@PathVariable String ratingId);


}
