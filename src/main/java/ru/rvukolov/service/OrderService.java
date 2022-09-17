package ru.rvukolov.service;

import org.springframework.stereotype.Service;
import ru.rvukolov.dao.OrderDAO;
import ru.rvukolov.model.Order;

import java.util.List;

@Service
public class OrderService {

    private final OrderDAO orderDAO;

    public OrderService(OrderDAO orderDAO) {
        this.orderDAO = orderDAO;
    }

    public List<Order> getOrder(String name) {
        return orderDAO.read(name);
    }
}
