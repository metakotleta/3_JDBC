package ru.rvukolov.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.rvukolov.model.Order;
import ru.rvukolov.service.OrderService;

import java.util.List;

@RestController
public class OrderController {
    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("/order")
    public List<Order> getOrder(@RequestParam String name) {
        return orderService.getOrder(name);
    }
}
