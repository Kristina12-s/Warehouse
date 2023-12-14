package cs.vsu.ru.KristinaPetrova.database;

import cs.vsu.ru.KristinaPetrova.Database;
import cs.vsu.ru.KristinaPetrova.models.*;
import cs.vsu.ru.KristinaPetrova.repository.Repository;
import cs.vsu.ru.KristinaPetrova.repository.RepositoryMemory;
import cs.vsu.ru.KristinaPetrova.sql_reps.*;

import java.util.ArrayList;
import java.util.List;

public class DatabaseSQL implements Database {

    public final Repository<Customer> customers;
    public final Repository<Order> orders;
    public final Repository<Product> products;
    public final Repository<Supplier> suppliers;
    public final Repository<Warehouse> warehouses;
    public final Repository<Arrival> arrivals;

    private static DatabaseSQL INSTANCE;

    public static DatabaseSQL getINSTANCE(){
        if(INSTANCE == null) {
            INSTANCE = new DatabaseSQL();
        }
        return INSTANCE;
    }

    public void deleteAll(){
        orders.deleteAll();
        arrivals.deleteAll();
        customers.deleteAll();
        products.deleteAll();
        suppliers.deleteAll();
        warehouses.deleteAll();
    }

    private DatabaseSQL(){
        customers = new CustomerRepository();
        orders = new OrderRepository();
        products = new ProductRepository();
        suppliers = new SupplierRepository();
        warehouses = new WarehouseRepository();
        arrivals = new ArrivalRepository();
    }

    @Override
    public void createArrival(Arrival arrival) {
        arrivals.add(arrival);
    }

    @Override
    public List<Arrival> getAllArrivals() {
        return arrivals.getAll();
    }

    @Override
    public Arrival getArrivalById(int id) {
        return arrivals.getById(id);
    }

    @Override
    public void updateArrival(int id, Arrival newArrival) {
        arrivals.update(id, newArrival);
    }

    @Override
    public void deleteArrival(int id) {
        arrivals.delete(id);
    }

    @Override
    public void createCustomer(Customer customer) {
        customers.add(customer);
    }

    @Override
    public List<Customer> getAllCustomers() {
        return customers.getAll();
    }

    @Override
    public Customer getCustomerById(int id) {
        return customers.getById(id);
    }

    @Override
    public void updateCustomer(int id, Customer newCustomer) {
        customers.update(id, newCustomer);
    }

    @Override
    public void deleteCustomer(int id) {
        customers.delete(id);
    }

    @Override
    public void createOrder(Order order) {
        orders.add(order);
    }

    @Override
    public List<Order> getAllOrders() {
        return orders.getAll();
    }

    @Override
    public Order getOrderById(int id) {
        return orders.getById(id);
    }

    @Override
    public void updateOrder(int id, Order newOrder) {
        orders.update(id, newOrder);
    }

    @Override
    public void deleteOrder(int id) {
        orders.delete(id);
    }

    @Override
    public void createProduct(Product product) {
        products.add(product);
    }

    @Override
    public List<Product> getAllProducts() {
        return products.getAll();
    }

    @Override
    public Product getProductById(int id) {
        return products.getById(id);
    }

    @Override
    public void updateProduct(int id, Product newProduct) {
        products.update(id, newProduct);
    }

    @Override
    public void deleteProduct(int id) {
        products.delete(id);
    }


    @Override
    public void createSupplier(Supplier supplier) {
        suppliers.add(supplier);
    }

    @Override
    public List<Supplier> getAllSuppliers() {
        return suppliers.getAll();
    }

    @Override
    public Supplier getSupplierById(int id) {
        return suppliers.getById(id);
    }

    @Override
    public void updateSupplier(int id, Supplier newSupplier) {
        suppliers.update(id, newSupplier);
    }

    @Override
    public void deleteSupplier(int id) {
        suppliers.delete(id);
    }

    @Override
    public void createWarehouse(Warehouse warehouse) {
        warehouses.add(warehouse);
    }

    @Override
    public List<Warehouse> getAllWarehouses() {
        return warehouses.getAll();
    }

    @Override
    public Warehouse getWarehouseById(int id) {
        return warehouses.getById(id);
    }

    @Override
    public void updateWarehouse(int id, Warehouse newWarehouse) {
        warehouses.update(id, newWarehouse);
    }

    @Override
    public void deleteWarehouse(int id) {
        warehouses.delete(id);
    }
}
