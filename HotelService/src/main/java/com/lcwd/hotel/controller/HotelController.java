package com.lcwd.hotel.controller;

import com.lcwd.hotel.entities.Hotel;
import com.lcwd.hotel.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hotels")
public class HotelController {

    @Autowired
    private HotelService hotelService;

    @GetMapping("/")
    private ResponseEntity<List<Hotel>> getAllHotel() {
        // Logic to get a hotel by ID
        return ResponseEntity.ok(hotelService.getAll()); // Placeholder for actual implementation
    }

    @GetMapping("/{hotelId}")
    private ResponseEntity<Hotel> getHotelById(@PathVariable String hotelId) {
        // Logic to get a hotel by ID
        return ResponseEntity.ok(hotelService.get(hotelId)); // Placeholder for actual implementation
    }

    @PostMapping("/create")
    private ResponseEntity<Hotel> createHotel(@RequestBody Hotel hotel) {
        // Logic to create a new hotel
        return ResponseEntity.status(201).body(hotelService.create(hotel)); // Placeholder for actual implementation
    }

    @PutMapping("/update")
    private ResponseEntity<Hotel> updateHotel(@RequestBody Hotel hotel, @PathVariable String hotelId) {
        // Logic to update an existing hotel
        return ResponseEntity.ok(hotelService.update(hotel, hotelId)); // Placeholder for actual implementation
    }
}
