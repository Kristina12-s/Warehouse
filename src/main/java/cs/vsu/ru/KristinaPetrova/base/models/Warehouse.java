package cs.vsu.ru.KristinaPetrova.base.models;

import cs.vsu.ru.KristinaPetrova.base.Identifiable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Warehouse implements Identifiable {
    protected Integer id;
    protected String name;
    protected String address;

    public Warehouse(String name, String address) {
        this.id = null;
        this.name = name;
        this.address = address;
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
