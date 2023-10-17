package cs.vsu.ru.KristinaPetrova.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Product implements Identifiable {
    protected Integer id;
    protected String name;
    protected String description;

    protected double price;

    public Product(String name, String description, double price) {
        this.id = null;
        this.name = name;
        this.description = description;
        this.price = price;
    }

    @Override
    public Integer getID() {
        return id;
    }
    @Override
    public void setID(int id) {
        this.id = id;
    }
}
