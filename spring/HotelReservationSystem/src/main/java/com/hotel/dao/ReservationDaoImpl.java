package com.hotel.dao;

import com.hotel.model.Reservation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class ReservationDaoImpl implements ReservationDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private RowMapper<Reservation> reservationMapper = new RowMapper<Reservation>() {
        @Override
        public Reservation mapRow(ResultSet rs, int rowNum) throws SQLException {
            Reservation reservation = new Reservation();
            reservation.setId(rs.getInt("id"));
            reservation.setRoomId(rs.getInt("room_id"));
            reservation.setCustomerName(rs.getString("customer_name"));
            reservation.setCheck_In_Date(rs.getDate("check_in"));
            reservation.setCheck_Out_Date(rs.getDate("check_out"));
            reservation.setRoomType(rs.getString("room_type"));
            return reservation;

        }
    };
    @Override
    public void bookRoom(Reservation reservation){
        String sql = "INSERT INTO reservation (room_id, customer_name, check_in, check_out, room_type) VALUES (?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql, reservation.getRoomId(),reservation.getCustomerName(), reservation.getCheck_In_Date(), reservation.getCheck_Out_Date(), reservation.getRoomType());
    }

    @Override
    public List<Reservation> getAllReservationInfo(){
        String sql = "SELECT * FROM reservation";
        return jdbcTemplate.query(sql, reservationMapper);

    }
}
