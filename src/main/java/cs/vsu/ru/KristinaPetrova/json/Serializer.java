package cs.vsu.ru.KristinaPetrova.json;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import cs.vsu.ru.KristinaPetrova.base.Database;

import java.io.File;
import java.io.IOException;

public class Serializer {
    protected final Database db;
    private final ObjectWriter objectWriter = new ObjectMapper().writerWithDefaultPrettyPrinter();

    public Serializer(Database db){
        this.db = db;
    }

    public void serialize(File file){
        ListWrapper listWrapper = new ListWrapper(
                db.getAllArrivals(),
                db.getAllCustomers(),
                db.getAllOrders(),
                db.getAllProducts(),
                db.getAllSuppliers(),
                db.getAllWarehouses()
        );
        try {
            objectWriter.writeValue(file, listWrapper);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new IllegalArgumentException("wrong file");
        }
    }
}
