create table customers
(
    CUSTOMER_ID int generated always as identity,
    NAME        varchar(20) not null,
    SURNAME     varchar(50) not null,
    AGE         int         not null,
    PHONE       varchar(20) unique,
    primary key (CUSTOMER_ID)
);

create table orders
(
    ORDER_ID     int generated always as identity,
    DATE         date        not null,
    CUSTOMER_ID  int         not null,
    PRODUCT_NAME varchar(20) not null,
    AMOUNT       int         not null,
    constraint customer_fk
        foreign key (CUSTOMER_ID)
            references customers (CUSTOMER_ID)
);

insert into customers
(NAME, SURNAME, AGE, PHONE) VALUES
('Alexey', 'Ivanov', 20, 123456789),
('Ivan','Sergeev', 25, 987654321),
('Nikolay','Chudotvorets', 45, 88005553535);

insert into orders
(DATE, CUSTOMER_ID, PRODUCT_NAME, AMOUNT) VALUES
(current_date, 1, 'TV', 10000),
(current_date, 2, 'MusicBox', 5000),
(current_Date, 3, 'Phone', 300),
(current_date, 1, 'SomeGadget',450),
(current_date, 3, 'Toy', 6700);
