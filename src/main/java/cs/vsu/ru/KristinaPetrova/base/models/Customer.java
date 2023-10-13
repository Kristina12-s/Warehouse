package cs.vsu.ru.KristinaPetrova.base.models;

import cs.vsu.ru.KristinaPetrova.base.Identifiable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Customer implements Identifiable {
    protected Integer id;
    protected String firstName;
    protected String lastName;
    protected String email;
    public Customer(String firstName, String lastName, String email) {
        this.id = null;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
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
