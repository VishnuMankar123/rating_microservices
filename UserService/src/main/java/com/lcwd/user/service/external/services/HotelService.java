package com.lcwd.user.service.external.services;

import com.lcwd.user.service.entities.Hotel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "HOTEL-SERVICE")
public interface HotelService {

    // Define methods to interact with the Hotel Service
    // For example:
     @GetMapping("/hotels/{hotelId}")
     ResponseEntity<Hotel> getHotelById(@PathVariable String hotelId);

}
