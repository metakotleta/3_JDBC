package ru.rvukolov.dao;

import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import ru.rvukolov.mapper.OrderPropertyRowMapper;
import ru.rvukolov.model.Order;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

@Component
public class OrderDAOImpl implements IOrderDAO {
    private static final String ORDER_BY_ID = "select * from orders where customer_id = ?;";
    public JdbcTemplate jdbcTemplate;

    public OrderDAOImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Order> selectOrdersByCustomerId(int id) {
        return jdbcTemplate.query(ORDER_BY_ID, new OrderPropertyRowMapper(), id);
    }

    public List<Order> read(String name) {
        String query = makeQuery("select.sql");
        return jdbcTemplate.query(query, new OrderPropertyRowMapper(), name);
    }

    private String makeQuery(String queryName) {
        try (FileInputStream fis = new FileInputStream(
                new ClassPathResource(queryName).getFile())) {
            return new String(fis.readAllBytes());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
