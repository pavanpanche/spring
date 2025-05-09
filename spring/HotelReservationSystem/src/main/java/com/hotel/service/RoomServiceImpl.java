package com.hotel.service;

import com.hotel.dao.RoomDao;
import com.hotel.model.Room;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class RoomServiceImpl implements RoomService {

    @Autowired
    private RoomDao roomDAO;

    @Override
    public List<Room> getAvailableRoomsByHotel(int hotelId) {
        return roomDAO.getAvailableRoomsByHotel(hotelId);
    }

    @Override
    public void updateRoomAvailability(int roomId, boolean available) {
         roomDAO.updateRoomAvailability(roomId, available);
    }
}
