package com.hotel.dao;

import com.hotel.model.Room;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class RoomDaoImpl implements RoomDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private RowMapper<Room>  rowMapper = new RowMapper<Room>() {
        @Override
        public Room mapRow(ResultSet rs, int rowNum) throws SQLException {
            Room r = new Room();

            r.setRoomId(rs.getInt("id"));
            r.setHotelId(rs.getInt("hotel_id"));
            r.setRoomNumber(rs.getInt("room_number"));
            r.setAvailable(rs.getBoolean("is_available"));
            r.setPrice(rs.getDouble("price"));
            return r;
        }
    };

    @Override
    public List<Room> getAvailableRoomsByHotel(int hotelId) {
        String sql = "SELECT * FROM room WHERE hotel_id = ? AND is_available = TRUE";
        return jdbcTemplate.query(sql, rowMapper, hotelId);
    }



    @Override
    public void updateRoomAvailability(int roomId, boolean isAvailable) {
        String sql = "UPDATE room SET is_available =? WHERE id =?";
    }


}
