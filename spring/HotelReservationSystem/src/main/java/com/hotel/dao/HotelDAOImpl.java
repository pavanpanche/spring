package com.hotel.dao;

import com.hotel.model.Hotel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class HotelDAOImpl implements HotelDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private RowMapper<Hotel> hotelMapper = new RowMapper<Hotel>() {
        @Override
        public Hotel mapRow(ResultSet rs, int rowNum) throws SQLException {
            Hotel hotel = new Hotel();
            hotel.setHotelId(rs.getInt("id"));
            hotel.setName(rs.getString("name"));
            hotel.setLocation(rs.getString("location"));
            return hotel;
        }
    };

    @Override
    public List<Hotel> getAllHotels() {
        String sql = "SELECT * FROM hotel";
        return jdbcTemplate.query(sql, hotelMapper);
    }

    @Override
    public Hotel getHotelByID(int id) {
        String sql = "SELECT * FROM hotel WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, hotelMapper, id);
    }



    @Override
    public void addHotel(Hotel hotel) {
        String sql = "INSERT INTO hotel (name, location) VALUES (?, ?)";
        jdbcTemplate.update(sql, hotel.getName(), hotel.getLocation());
    }

}
