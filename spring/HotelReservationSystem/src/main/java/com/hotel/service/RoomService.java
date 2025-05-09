package com.hotel.service;

import com.hotel.model.Room;


import java.util.List;

public interface RoomService {
    List<Room> getAvailableRoomsByHotel(int hotelId);
    void updateRoomAvailability(int roomId, boolean available);

}
