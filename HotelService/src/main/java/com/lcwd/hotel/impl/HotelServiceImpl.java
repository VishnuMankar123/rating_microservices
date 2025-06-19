package com.lcwd.hotel.impl;

import com.lcwd.hotel.entities.Hotel;
import com.lcwd.hotel.exception.ResourceNotFoundException;
import com.lcwd.hotel.repositories.HotelRepository;
import com.lcwd.hotel.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;

@Service
public class HotelServiceImpl implements HotelService {

    @Autowired
    private HotelRepository hotelRepository;
    @Override
    public Hotel create(Hotel hotel) {
        //String string = UUID.randomUUID().toString();
        // hotel.setId(string );
        return hotelRepository.save(hotel);
    }

    @Override
    public Hotel update(Hotel hotel, String hotelId) {
      return hotelRepository.findById(hotelId).map(hotel1 -> {
            hotel1.setName(hotel.getName());
            hotel1.setLocation(hotel.getLocation());
            hotel1.setAbout(hotel.getAbout());
            return hotelRepository.save(hotel1);
                })
                .orElseThrow(() -> new ResourceNotFoundException("Hotel with given ID not found: " + hotelId));
    }

    @Override
    public void delete(String hotelId) {


    }

    @Override
    public Hotel get(String hotelId) {
       return hotelRepository.findById(hotelId)
                .orElseThrow(() -> new ResourceNotFoundException("Hotel not found with id: " + hotelId));
    }

    @Override
    public List<Hotel> getAll() {
        return hotelRepository.findAll();
    }

    @Override
    public List<Hotel> findByLocation(String location) {
        return null;
    }
}
