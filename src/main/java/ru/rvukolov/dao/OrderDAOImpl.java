package ru.rvukolov.dao;

import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import ru.rvukolov.model.Order;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

@Component
public class OrderDAOImpl implements OrderDAO {
    private final String selectQuery;
    public JdbcTemplate jdbcTemplate;

    public OrderDAOImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
        try (FileInputStream fis = new FileInputStream(
                new ClassPathResource("select.sql").getFile())) {
            selectQuery = new String(fis.readAllBytes());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Order> read(List<String> name) {
        String tempParams;

        return jdbcTemplate.query(selectQuery,
                (rs, oo) -> new Order(rs.getInt("order_id"),
                        rs.getDate("date").toString(),
                        rs.getInt("customer_id"),
                        rs.getString("product_name"),
                        rs.getLong("amount")), name);
    }
}
