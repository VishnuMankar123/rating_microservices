package com.lcwd.user.service.service;

import com.lcwd.user.service.entities.Hotel;
import com.lcwd.user.service.entities.Rating;
import com.lcwd.user.service.entities.User;
import com.lcwd.user.service.exception.ResourceNotFoundException;
import com.lcwd.user.service.external.services.HotelService;
import com.lcwd.user.service.external.services.RatingService;
import com.lcwd.user.service.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.logging.Logger;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired(required = true)
    private RestTemplate restTemplate;
    
    @Autowired
    private HotelService hotelService;

    @Autowired
    private RatingService ratingService;

    private Logger logger = Logger.getLogger(UserServiceImpl.class.getName());

    @Override
    public User createUser(User user) {
      // Generate a random UUID for the user ID
        String string = UUID.randomUUID().toString();
        // Set the generated UUID as the user ID
        user.setUserId(string);
        return userRepository.save(user);
    }

    @Override
    public User getUser(String userId) {
        // Retrieve the user by ID from the repository
        User user =userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User not found with id: " + userId));
        //fetch ratings of the user from rating service
       // http://localhost:8083/ratings/users/583a75e9-eacf-43b8-9834-2bf734d1787a\
       // Rating[] ratings = this.restTemplate.getForObject("http://RATING-SERVICE/ratings/users/" + user.getUserId(), Rating[].class);
        Rating[] ratings = this.ratingService.getRatingsByUserId(user.getUserId());

        // Set the fetched ratings to the user object
        logger.info("Fetching ratings for user: " + ratings);

        List<Rating> list = Arrays.stream(ratings).toList();

        List<Rating> newRating = list.stream().map(rating ->{
            //ResponseEntity<Hotel> hotel = this.restTemplate.getForEntity("http://HOTEL-SERVICE/hotels/" + rating.getHotelId(), Hotel.class);
            ResponseEntity<Hotel> hotelById = this.hotelService.getHotelById(rating.getHotelId());
            rating.setHotel(hotelById.getBody());
            return rating;
        }).collect(Collectors.toList());
        user.setRatings(newRating);

        return user;

    }

    @Override
    public User updateUser(String userId, User user) {
       return userRepository.findById(userId)
                .map(existingUser -> {
                    existingUser.setName(user.getName());
                    existingUser.setEmail(user.getEmail());
                    // Update other fields as necessary
                    existingUser.setAbout(user.getAbout());
                    return userRepository.save(existingUser);
                })
                .orElseThrow(() -> new ResourceNotFoundException("User not found with id: " + userId));
    }

    @Override
    public void deleteUser(String userId) {
        userRepository.findById(userId)
                .ifPresentOrElse(
                        user -> userRepository.delete(user),
                        () -> { throw new ResourceNotFoundException("User not found with id: " + userId); }
                );
    }

    @Override
    public List<User> getAllUsers() {
        List<User> userlist = userRepository.findAll().stream().peek(user -> {
            // Fetch ratings for each user from the rating service
            List<Rating> ratings = this.restTemplate.getForObject("http://RATING-SERVICE/ratings/users/" + user.getUserId(), List.class);
            // Set the fetched ratings to the user object
            user.setRatings(ratings);
        }).toList();

        return userlist;
    }
}
