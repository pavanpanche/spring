package com.hotel.dao;

import com.hotel.model.Reservation;

import java.util.List;

public interface ReservationDao {
    void bookRoom(Reservation reservation);
    List<Reservation> getAllReservationInfo();

}
