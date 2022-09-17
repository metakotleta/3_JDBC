package ru.rvukolov.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public record Order(int orderId, String date, String customerName,
                    String customerSurname, String productName,
                    long amount) {
}
