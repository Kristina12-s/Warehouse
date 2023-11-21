package cs.vsu.ru.KristinaPetrova;

import cs.vsu.ru.KristinaPetrova.json.Deserializer;
import cs.vsu.ru.KristinaPetrova.json.Serializer;
import cs.vsu.ru.KristinaPetrova.logic.Logic;
import cs.vsu.ru.KristinaPetrova.generator.Generator;
import cs.vsu.ru.KristinaPetrova.models.Customer;
import cs.vsu.ru.KristinaPetrova.models.Product;
import cs.vsu.ru.KristinaPetrova.models.Supplier;
import cs.vsu.ru.KristinaPetrova.models.Warehouse;

import java.io.File;
import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static void soutSomeInfo(Database db, Logic logic){
        System.out.println("products size: " + db.getAllArrivals().size());
        for (Customer customer: db.getAllCustomers()){
            System.out.println("(id: " + customer.getID() + " email" + customer.getEmail() + ")");
        }
        for (Supplier supplier: db.getAllSuppliers()){
            System.out.println("(id: " + supplier.getID() + " email" + supplier.getEmail() + ")");
        }
        for (Warehouse warehouse : db.getAllWarehouses()) {
            System.out.print("all products arrived in " + warehouse.getName());
            System.out.println();
            for (Logic.Pair<Product, Integer> pair: logic.getProductsArrivedOnWarehouse(warehouse.getID())) {
                System.out.print("(" + pair.f.getName() + " q: " + pair.s + "), ");
            }
            System.out.println();
            System.out.println();
        }

        for (Customer customer : db.getAllCustomers()) {
            System.out.print("all products byed by " + customer.getFirstName() + " " + customer.getLastName());
            System.out.println();
            for (Logic.Pair<Product, Integer> pair: logic.getByedProducts(customer.getID())) {
                System.out.print("(" + pair.f.getName() + " q: " + pair.s + "), ");
            }
            System.out.println();
            System.out.println();
        }
    }
    public static void main(String[] args) {
        Database db = DatabaseMemory.getINSTANCE();
        Logic logic = new Logic(db);
        File file = new File("test.json");

        System.out.println("do you want to generate and write or read file? w/r");
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();

        if (Objects.equals(s, "w")) {

            Generator generator = new Generator(db);
            generator.generate();
            soutSomeInfo(db, logic);
            Serializer serializer = new Serializer(db);
            file = new File("test.json");
            serializer.serialize(file);

            System.out.println("wrote");
        }
        else {

            Deserializer deserializer = new Deserializer(db);
            deserializer.deserialize(file);

            System.out.println("read");
            soutSomeInfo(db, logic);
        }
    }
}