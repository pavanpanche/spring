package com.hotel.dao;

import com.hotel.model.Hotel;

import java.util.List;

public interface HotelDAO {
    List<Hotel> getAllHotels();

    Hotel getHotelByID(int hotelId);

    void addHotel(Hotel hotel);
}
