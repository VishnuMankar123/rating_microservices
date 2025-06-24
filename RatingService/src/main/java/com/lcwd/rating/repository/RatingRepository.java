package com.lcwd.rating.repository;

import com.lcwd.rating.entities.Rating;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface RatingRepository extends MongoRepository<Rating,String> {

    // Custom query methods can be defined here if needed
    // For example, to find ratings by userId or hotelId, you can add:
    List<Rating> findByUserId(String userId);
    List<Rating> findByHotelId(String hotelId);
}
