package ru.rvukolov.dao;

import ru.rvukolov.model.Customer;

import java.util.List;

public interface ICustomerDAO {
    List<Customer> selectCustomerByName(String name);
}
