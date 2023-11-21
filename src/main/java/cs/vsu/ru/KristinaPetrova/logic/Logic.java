package cs.vsu.ru.KristinaPetrova.logic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import cs.vsu.ru.KristinaPetrova.Database;
import cs.vsu.ru.KristinaPetrova.models.Arrival;
import cs.vsu.ru.KristinaPetrova.models.Order;
import cs.vsu.ru.KristinaPetrova.models.Product;

public class Logic {
    // TODO add place order business logic(check how much product on warehouse, calculate price)
    // add calculate products on warehouses etc
    private final Database db;
    public Logic(Database db){
        this.db = db;
    }

    public static class Pair<T1, T2>{
        public final T1 f;
        public final T2 s;

        Pair(T1 f, T2 s) {
            this.f = f;
            this.s = s;
        }
    }


    public List<Pair<Product, Integer>> getProductsArrivedOnWarehouse(int warehouseID){
        HashMap<Integer, Integer> productsMap = new HashMap<>();
        for (Arrival arrival: db.getAllArrivals()) {
            if(arrival.getWarehouseId() == warehouseID){
                Product product = db.getProductById(arrival.getProductId());
                productsMap.put(product.getID(), productsMap.getOrDefault(product.getID(), 0) + arrival.getQuantity());
            }
        }
        List<Pair<Product, Integer>> products = new ArrayList<>();
        for (Integer productId: productsMap.keySet()) {
            products.add(new Pair<>(db.getProductById(productId), productsMap.get(productId)));
        }
        return products;
    }

    public List<Pair<Product, Integer>> getByedProducts(int customerID){
        HashMap<Integer, Integer> productsMap = new HashMap<>();
        for (Order order: db.getAllOrders()) {
            if(order.getWarehouseId() == customerID){
                Product product = db.getProductById(order.getProductId());
                productsMap.put(product.getID(), productsMap.getOrDefault(product.getID(), 0) + order.getQuantity());
            }
        }
        List<Pair<Product, Integer>> products = new ArrayList<>();
        for (Integer productId: productsMap.keySet()) {
            products.add(new Pair<>(db.getProductById(productId), productsMap.get(productId)));
        }
        return products;
    }
}
