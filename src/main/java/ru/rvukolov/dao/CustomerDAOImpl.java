package ru.rvukolov.dao;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import ru.rvukolov.mapper.CustomerPropertyRowMapper;
import ru.rvukolov.model.Customer;

import java.util.List;

@Component
public class CustomerDAOImpl implements ICustomerDAO {

    private static final String CUSTOMERS_BY_NAME = "select * from customers where name = ?";
    private JdbcTemplate jdbcTemplate;

    public CustomerDAOImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Customer> selectCustomerByName(String name) {
        return jdbcTemplate.query(CUSTOMERS_BY_NAME,
                new CustomerPropertyRowMapper(),
                name);
    }
}
