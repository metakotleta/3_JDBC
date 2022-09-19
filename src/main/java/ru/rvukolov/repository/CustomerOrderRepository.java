package ru.rvukolov.repository;

import org.springframework.stereotype.Repository;
import ru.rvukolov.dao.ICustomerDAO;
import ru.rvukolov.dao.OrderDAOImpl;
import ru.rvukolov.model.Order;

import java.util.List;

@Repository
public class CustomerOrderRepository {
    private final OrderDAOImpl orderDAO;
    private final ICustomerDAO customerDAO;

    public CustomerOrderRepository(OrderDAOImpl orderDAO, ICustomerDAO customerDAO) {
        this.orderDAO = orderDAO;
        this.customerDAO = customerDAO;
    }

    public List<Order> getOrderByCustomerName(String name) {
        var customers = customerDAO.selectCustomerByName(name);
        return customers.stream()
                .flatMap(c -> orderDAO.selectOrdersByCustomerId(c.getId()).stream())
                .toList();
    }

    public List<Order> getOrderByCustomerName2(String name) {
        return orderDAO.read(name);
    }
}
