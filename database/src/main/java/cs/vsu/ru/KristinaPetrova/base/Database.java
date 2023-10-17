package cs.vsu.ru.KristinaPetrova.base;
import cs.vsu.ru.KristinaPetrova.models.*;

import java.util.List;

public interface Database {
    // Для объектов типа Arrival
    void createArrival(Arrival arrival);
    List<Arrival> getAllArrivals();
    Arrival getArrivalById(int id);
    void updateArrival(int id, Arrival newArrival);
    void deleteArrival(int id);

    // Для объектов типа Customer
    void createCustomer(Customer customer);
    List<Customer> getAllCustomers();
    Customer getCustomerById(int id);
    void updateCustomer(int id, Customer newCustomer);
    void deleteCustomer(int id);

    // Для объектов типа Order
    void createOrder(Order order);
    List<Order> getAllOrders();
    Order getOrderById(int id);
    void updateOrder(int id, Order newOrder);
    void deleteOrder(int id);

    // Для объектов типа Product
    void createProduct(Product product);
    List<Product> getAllProducts();
    Product getProductById(int id);
    void updateProduct(int id, Product newProduct);
    void deleteProduct(int id);

    // Для объектов типа Supplier
    void createSupplier(Supplier supplier);
    List<Supplier> getAllSuppliers();
    Supplier getSupplierById(int id);
    void updateSupplier(int id, Supplier newSupplier);
    void deleteSupplier(int id);

    // Для объектов типа Warehouse
    void createWarehouse(Warehouse warehouse);
    List<Warehouse> getAllWarehouses();
    Warehouse getWarehouseById(int id);
    void updateWarehouse(int id, Warehouse newWarehouse);
    void deleteWarehouse(int id);
}