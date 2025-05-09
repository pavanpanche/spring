package com.hotel.service;

import com.hotel.model.Hotel;

import java.util.List;

public interface HotelService {
    List<Hotel> listAllHotels();
    Hotel getHotelById(int hotelId);
    void addHotel(Hotel hotel);



}
