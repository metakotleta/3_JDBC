package ru.rvukolov.service;

import org.springframework.stereotype.Service;
import ru.rvukolov.model.Order;
import ru.rvukolov.repository.CustomerOrderRepository;

import java.util.List;

@Service
public class OrderService {

    private CustomerOrderRepository customerOrderRepository;

    public OrderService(CustomerOrderRepository customerOrderRepository) {
        this.customerOrderRepository = customerOrderRepository;
    }

    public List<Order> getOrder(String name) {
        return customerOrderRepository.getOrderByCustomerName(name);
    }

    public List<Order> getOrder2(String name) {
        return customerOrderRepository.getOrderByCustomerName2(name);
    }
}
