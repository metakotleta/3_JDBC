package ru.rvukolov.dao;

import ru.rvukolov.model.Order;

import java.util.List;

public interface OrderDAO {
    List<Order> read(List<String> name);
}
