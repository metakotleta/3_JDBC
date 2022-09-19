package ru.rvukolov.model;

public record Order(int orderId, String date, int customerId,
                    String productName, long amount) {
}
