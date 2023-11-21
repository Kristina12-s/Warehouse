package cs.vsu.ru.KristinaPetrova;


import cs.vsu.ru.KristinaPetrova.repository.Repository;
import cs.vsu.ru.KristinaPetrova.repository.RepositoryMemory;
import cs.vsu.ru.KristinaPetrova.models.*;

import java.util.ArrayList;
import java.util.List;

public class DatabaseMemory implements Database {

    Repository<Customer> customers;
    Repository<Order> orders;
    Repository<Product> products;
    Repository<Supplier> suppliers;
    Repository<Warehouse> warehouses;
    Repository<Arrival> arrivals;

    private static DatabaseMemory INSTANCE;

    public static DatabaseMemory getINSTANCE(){
        if(INSTANCE == null) {
            INSTANCE = new DatabaseMemory();
        }
        return INSTANCE;
    }

    private DatabaseMemory(){
        customers = new RepositoryMemory<>();
        orders = new RepositoryMemory<>();
        products = new RepositoryMemory<>();
        suppliers = new RepositoryMemory<>();
        warehouses = new RepositoryMemory<>();
        arrivals = new RepositoryMemory<>();
    }

    protected void checkArrival(Arrival arrival){
        if(products.getById(arrival.getProductId()) == null){
            throw new IllegalArgumentException("Illegal product ID");
        }
        if(suppliers.getById(arrival.getSupplierId()) == null){
            throw new IllegalArgumentException("Illegal product ID");
        }
        if(warehouses.getById(arrival.getWarehouseId()) == null){
            throw new IllegalArgumentException("Illegal warehouse ID");
        }
    }

    protected void checkOrder(Order order) {
        if(customers.getById(order.getCustomerId()) == null){
            throw new IllegalArgumentException("Illegal customer ID");
        }
        if(products.getById(order.getProductId()) == null){
            throw new IllegalArgumentException("Illegal product ID");
        }
        if(warehouses.getById(order.getWarehouseId()) == null){
            throw new IllegalArgumentException("Illegal warehouse ID");
        }
    }

    @Override
    public void deleteAll() {
        orders.deleteAll();
        arrivals.deleteAll();
        customers.deleteAll();
        products.deleteAll();
        suppliers.deleteAll();
        warehouses.deleteAll();
    }

    @Override
    public void createArrival(Arrival arrival) {
        checkArrival(arrival);
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
        checkArrival(newArrival);
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
        List<Order> ordersList = new ArrayList<>(getAllOrders());
        for (Order order : ordersList) {
            if(order.getCustomerId() == id) {
                orders.delete(order.getID());
            }
        }
        customers.delete(id);
    }

    @Override
    public void createOrder(Order order) {
        checkOrder(order);
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
        checkOrder(newOrder);
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
        List<Order> ordersList = new ArrayList<>(getAllOrders());
        for (Order order : ordersList) {
            if(order.getProductId() == id) {
                orders.delete(order.getID());
            }
        }
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
        List<Arrival> arrivalsList = new ArrayList<>(getAllArrivals());
        for (Arrival arrival : arrivalsList) {
            if(arrival.getSupplierId() == id) {
                arrivals.delete(arrival.getID());
            }
        }
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
        List<Order> ordersList = new ArrayList<>(getAllOrders());
        for (Order order : ordersList) {
            if(order.getWarehouseId() == id) {
                orders.delete(order.getID());
            }
        }
        List<Arrival> arrivalsList = new ArrayList<>(getAllArrivals());
        for (Arrival arrival : arrivalsList) {
            if(arrival.getWarehouseId() == id) {
                arrivals.delete(arrival.getID());
            }
        }
        warehouses.delete(id);
    }
}
