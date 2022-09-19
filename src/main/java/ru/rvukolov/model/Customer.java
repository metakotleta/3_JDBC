package ru.rvukolov.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Customer {
    private final int id;
    private final String name;
    private final String surname;
    private final int age;
    private final String phoneNumber;
}
