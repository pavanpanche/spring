package com.hotel.service;

import com.hotel.dao.ReservationDao;
import com.hotel.dao.RoomDao;
import com.hotel.model.Reservation;
import com.hotel.model.Room;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;
@Service
public class ReservationServiceImpl implements ReservationService {
    @Autowired
    private ReservationDao reservationDAO;

    @Autowired
    private RoomDao roomDAO;

    @Override
    public boolean reserveRoom(int hotelId, String customerName, String check_In_Date, String check_Out_Date, String roomType) {
        try {
            List<Room> availableRooms = roomDAO.getAvailableRoomsByHotel(hotelId);

            if (availableRooms.isEmpty()) {
                return false; // NO rooms available
            }
            Room room = availableRooms.get(0); // Choose first available

            Reservation reservation = new Reservation();
            reservation.setRoomId(room.getRoomId());
            reservation.setCustomerName(customerName);
            reservation.setCheck_In_Date(Date.valueOf(check_In_Date));
            reservation.setCheck_Out_Date(Date.valueOf(check_Out_Date));
            reservation.setRoomType(roomType);

            reservationDAO.bookRoom(reservation);
            roomDAO.updateRoomAvailability(room.getRoomId(), false); // Mark as booked

            return true;
        } catch (Exception exception) {
            System.out.println("Error while reserving room:" + exception.getMessage());
            return false;
        }


    }


    @Override
    public List<Reservation> getAllReservationInfo() {
        return reservationDAO.getAllReservationInfo();
    }
}



