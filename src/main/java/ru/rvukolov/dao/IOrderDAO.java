package ru.rvukolov.dao;

import ru.rvukolov.model.Order;

import java.util.List;

public interface IOrderDAO {
    List<Order> selectOrdersByCustomerId(int id);
}
