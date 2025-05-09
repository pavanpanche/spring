package com.hotel.service;

import com.hotel.model.Reservation;

import java.util.List;

public interface ReservationService {
    boolean reserveRoom(int hotelId, String customerName, String check_In_Date, String check_Out_Date, String roomType);
    List<Reservation> getAllReservationInfo();
}
