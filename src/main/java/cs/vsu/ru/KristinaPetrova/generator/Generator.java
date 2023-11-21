package cs.vsu.ru.KristinaPetrova.generator;



import cs.vsu.ru.KristinaPetrova.Database;
import cs.vsu.ru.KristinaPetrova.models.*;

import java.util.Date;
import java.util.List;
import java.util.Random;

public class Generator {
    protected final Database db;
    protected final Random random;

    public Generator(Database db){
        this.db = db;
        random = new Random();
    }

    protected Integer pickRandom(List<Integer> list){
        return list.get(random.nextInt(list.size()));
    }



    public void generate(){
        // customers 100
        String[] firstNames = {"John", "Jane", "Michael", "Emily", "David", "Olivia", "James", "Sophia", "William", "Emma"};
        String[] lastNames = {"Smith", "Johnson", "Brown", "Taylor", "Anderson", "Wilson", "Miller", "Davis", "Garcia", "Martinez"};
        for (String first : firstNames) {
            for (String last : lastNames) {
                db.createCustomer(new Customer(first, last, first+last+"@gmail.com"));
            }
        }
        // products 1000
        for (int i = 0; i < 1000; i++) {
            String name = "Product "+ i;
            String desc = "Great description: " + random.nextInt(0, 100000);
            double price = random.nextDouble(0, 70000);
            db.createProduct(new Product(name, desc, price));
        }
        // warehouses 100
        for (int i = 0; i < 1000; i++) {
            String name = "Warehouse "+ i * 2;
            String address = "Great address for " + name;
            db.createWarehouse(new Warehouse(name, address));
        }
        List<Integer> customersIDs = db.getAllCustomers().stream().map(Customer::getID).toList();
        List<Integer> productIDs = db.getAllProducts().stream().map(Product::getID).toList();
        List<Integer> warehousesIDs = db.getAllWarehouses().stream().map(Warehouse::getID).toList();
        // orders(200к 300к 500к милллион)
        for (int i = 0; i < 1000000; i++) {
            int customersID = pickRandom(customersIDs);
            int productID = pickRandom(productIDs);
            int warehouseID = pickRandom(warehousesIDs);

            Date date = new Date();
            int quantity = random.nextInt(1, 1000);
            double price = quantity * db.getProductById(productID).getPrice() * random.nextDouble(0.8, 1.0);
            String customerAddress = "Great address " + random.nextInt(1, 10000000);

            db.createOrder(new Order(date, quantity, price, customerAddress, customersID, productID, warehouseID));
        }
        // suppliers
        String[] newFirstNames = {"Alex", "Ella", "Benjamin", "Grace", "Daniel", "Ava", "Matthew", "Lily", "Christopher", "Chloe"};
        String[] newLastNames = {"Walker", "Clark", "Parker", "Moore", "Robinson", "Carter", "Turner", "Baker", "Wright", "Lewis"};
        for (String first : newFirstNames) {
            for (String last : newLastNames) {
                String company = "Company " + last + " " + first;
                String address = "Address for " + last + " " + first;
                String contactPerson = first + " " + last;
                String email = first + "." + last + "@mail.com";
                db.createSupplier(new Supplier(company, address, contactPerson, email));
            }
        }
        // arrivals
        List<Integer> suppliersIDs = db.getAllSuppliers().stream().map(Supplier::getID).toList();
        for (int i = 0; i < 10000; i++) {
            int suppliersID = pickRandom(suppliersIDs);
            int productID = pickRandom(productIDs);
            int warehouseID = pickRandom(warehousesIDs);

            Date date = new Date();
            int quantity = random.nextInt(100, 100000);
            double price = quantity * db.getProductById(productID).getPrice() * random.nextDouble(0.8, 1.0);

            db.createArrival(new Arrival(quantity, price, date, suppliersID, productID, warehouseID));
        }
    }
}
