package com.hotel.service;

import com.hotel.dao.HotelDAO;
import com.hotel.model.Hotel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class HotelServiceImpl implements HotelService {

    @Autowired
    private HotelDAO hotelDAO;

    @Override
    public List<Hotel> listAllHotels() {
        return hotelDAO.getAllHotels();
    }

    @Override
    public Hotel getHotelById(int hotelId) {
        return hotelDAO.getHotelByID(hotelId);
    }

    @Override
    public void addHotel(Hotel hotel) {
        hotelDAO.addHotel(hotel);
    }
}
