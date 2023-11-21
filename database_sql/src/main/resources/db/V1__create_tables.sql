-- Создаем таблицу Warehouse
CREATE TABLE warehouse (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    address VARCHAR(255) NOT NULL
);

-- Создаем таблицу Supplier
CREATE TABLE supplier (
    id SERIAL PRIMARY KEY,
    company_name VARCHAR(255) NOT NULL,
    address VARCHAR(255) NOT NULL,
    contact_person VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL
);

-- Создаем таблицу Product
CREATE TABLE product (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    description VARCHAR(255) NOT NULL,
    price DECIMAL(10, 2) NOT NULL
);

-- Создаем таблицу Customer
CREATE TABLE customer (
    id SERIAL PRIMARY KEY,
    first_name VARCHAR(255) NOT NULL,
    last_name VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL
);

-- Создаем таблицу Arrival
CREATE TABLE arrival (
    id SERIAL PRIMARY KEY,
    quantity INT NOT NULL,
    price DECIMAL(10, 2) NOT NULL,
    date DATE NOT NULL,
    supplier_id INT REFERENCES supplier(id),
    warehouse_id INT REFERENCES warehouse(id),
    product_id INT REFERENCES product(id)
);

-- Создаем таблицу Order
CREATE TABLE order_table (
    id SERIAL PRIMARY KEY,
    order_date DATE NOT NULL,
    quantity INT NOT NULL,
    price DECIMAL(10, 2) NOT NULL,
    customer_address VARCHAR(255) NOT NULL,
    customer_id INT REFERENCES customer(id),
    warehouse_id INT REFERENCES warehouse(id),
    product_id INT REFERENCES product(id)
);