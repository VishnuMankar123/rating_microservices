package com.lcwd.rating.services;

import com.lcwd.rating.entities.Rating;

import java.util.List;

public interface RatingService {

    // Method to create a new rating
    Rating createRating(Rating rating);

    // Method to get all ratings for a specific user
    List<Rating> getRatingsByUserId(String userId);

    // Method to get all ratings for a specific hotel
    List<Rating> getRatingsByHotelId(String hotelId);

    // Method to delete a rating by its ID
    void deleteRating(String ratingId);

    // Method to update an existing rating
    Rating updateRating(Rating rating);

    List<Rating> getRatings();
}
