package com.lcwd.hotel.service;

import com.lcwd.hotel.entities.Hotel;
import com.lcwd.hotel.repositories.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


public interface HotelService
{

    // create
    Hotel create(Hotel hotel);

    // update
    Hotel update(Hotel hotel, String hotelId);

    // delete
    void delete(String hotelId);

    // get single hotel
    Hotel get(String hotelId);

    // get all hotels
    List<Hotel> getAll();

    // search by location
    List<Hotel> findByLocation(String location);
}
