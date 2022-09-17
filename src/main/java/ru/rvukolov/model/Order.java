package ru.rvukolov.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@AllArgsConstructor
@Getter
@Setter
public class Order {
    private int orderId;
    private String date;
    private int customerId;
    private String productName;
    private long amount;
}
