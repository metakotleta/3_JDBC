package ru.rvukolov.mapper;

import org.springframework.jdbc.core.RowMapper;
import ru.rvukolov.model.Customer;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CustomerPropertyRowMapper implements RowMapper<Customer> {
    @Override
    public Customer mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new Customer(rs.getInt("customer_id"), rs.getString("name"),
                rs.getString("surname"), rs.getInt("age"), rs.getString("phone"));
    }
}
