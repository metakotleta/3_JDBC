package ru.rvukolov.mapper;

import org.springframework.jdbc.core.RowMapper;
import ru.rvukolov.model.Order;

import java.sql.ResultSet;
import java.sql.SQLException;

public class OrderPropertyRowMapper implements RowMapper<Order> {
    @Override
    public Order mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new Order(rs.getInt("order_id"), rs.getDate("date").toString(),
                rs.getInt("customer_id"), rs.getString("product_name"),
                rs.getInt("amount"));
    }
}
