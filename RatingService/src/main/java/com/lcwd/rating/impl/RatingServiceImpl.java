package com.lcwd.rating.impl;

import com.lcwd.rating.entities.Rating;
import com.lcwd.rating.services.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RatingServiceImpl implements RatingService {

    @Autowired
    private com.lcwd.rating.repository.RatingRepository ratingRepository;

    @Override
    public Rating createRating(Rating rating) {
        return ratingRepository.save(rating);
    }

    @Override
    public List<Rating> getRatingsByUserId(String userId) {
        return ratingRepository.findByUserId(userId);
    }

    @Override
    public List<Rating> getRatingsByHotelId(String hotelId) {
       return ratingRepository.findByHotelId(hotelId);
    }

    @Override
    public void deleteRating(String ratingId) {
        ratingRepository.deleteById(ratingId);

    }

    @Override
    public Rating updateRating(Rating rating) {
        if (rating.getRatingId() == null || !ratingRepository.existsById(rating.getRatingId())) {
            throw new IllegalArgumentException("Rating ID is invalid or does not exist.");
        }
        return ratingRepository.save(rating);
    }

    @Override
    public List<Rating> getRatings() {
        return ratingRepository.findAll();
    }


}
