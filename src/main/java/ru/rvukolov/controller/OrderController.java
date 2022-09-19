package ru.rvukolov.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.rvukolov.model.Order;
import ru.rvukolov.service.OrderService;

import java.util.List;

@RestController
@RequestMapping("/products")
public class OrderController {
    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("/fetch-product")
    public List<Order> getOrder(@RequestParam String name) {
        return orderService.getOrder(name);
    }

    @GetMapping("/fetch-product2")
    public List<Order> getOrder2(@RequestParam String name) {
        return orderService.getOrder2(name);
    }
}
