package cs.vsu.ru.KristinaPetrova.models;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Supplier implements Identifiable {
    protected Integer id;
    protected String companyName;
    protected String address;
    protected String contactPerson;
    protected String email;

    public Supplier(String companyName, String address, String contactPerson, String email) {
        this.id = null;
        this.companyName = companyName;
        this.address = address;
        this.contactPerson = contactPerson;
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
