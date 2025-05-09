package com.hotel.dao;
import com.hotel.model.Room;
import java.util.List;
public interface RoomDao {
    List<Room> getAvailableRoomsByHotel(int hotelId);
    void updateRoomAvailability(int roomId, boolean isAvailable);
}

