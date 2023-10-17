package cs.vsu.ru.KristinaPetrova.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import java.util.Date;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Arrival implements Identifiable {
    protected Integer id;
    protected int quantity;
    protected double price;
    protected Date date;

    protected int supplierId;

    protected int warehouseId;
    protected int productId;

    public Arrival(int quantity, double price, Date date, int supplierId, int warehouseId, int productId) {
        this.id = null;
        this.quantity = quantity;
        this.price = price;
        this.date = date;
        this.supplierId = supplierId;
        this.warehouseId = warehouseId;
        this.productId = productId;
    }

    @Override
    public Integer getID() {
        return 0;
    }

    @Override
    public void setID(int id) {

    }
}
