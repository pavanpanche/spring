package com.hotel.model;

import java.util.Date;

public class Reservation {

    private int Id;
    private int hotelId;
    private int roomId;
    private String customerName;
    private Date check_In_Date;
    private Date check_Out_Date;
    private String roomType;

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public int getHotelId() {
        return hotelId;
    }

    public void setHotelId(int hotelId) {
        this.hotelId = hotelId;
    }

    public int getRoomId() {
        return roomId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public Date getCheck_In_Date() {
        return check_In_Date;
    }

    public void setCheck_In_Date(Date check_In_Date) {
        this.check_In_Date = check_In_Date;
    }

    public Date getCheck_Out_Date() {
        return check_Out_Date;
    }

    public void setCheck_Out_Date(Date check_Out_Date) {
        this.check_Out_Date = check_Out_Date;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }
}
