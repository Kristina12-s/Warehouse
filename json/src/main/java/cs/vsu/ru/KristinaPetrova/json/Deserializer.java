package cs.vsu.ru.KristinaPetrova.json;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import cs.vsu.ru.KristinaPetrova.Database;
import cs.vsu.ru.KristinaPetrova.models.*;

import java.io.File;
import java.io.IOException;

public class Deserializer {
    protected final Database db;
    private final ObjectMapper objectMapper = new ObjectMapper();

    public Deserializer(Database db){
        this.db = db;
    }

    public void deserialize(File file){
        try {
            ListWrapper listWrapper = objectMapper.readValue(file, ListWrapper.class);
            for (Customer customer : listWrapper.getCustomers()) {
                db.createCustomer(customer);
            }
            for (Product product : listWrapper.getProducts()) {
                db.createProduct(product);
            }
            for (Warehouse warehouse : listWrapper.getWarehouses()) {
                db.createWarehouse(warehouse);
            }
            for (Order order : listWrapper.getOrders()) {
                db.createOrder(order);
            }
            for (Supplier supplier : listWrapper.getSuppliers()) {
                db.createSupplier(supplier);
            }
            for (Arrival arrival : listWrapper.getArrivals()) {
                db.createArrival(arrival);
            }
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new IllegalArgumentException("wrong file");
        }
    }
}
