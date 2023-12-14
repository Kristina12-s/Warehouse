package cs.vsu.ru.KristinaPetrova.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.util.Date;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Arrival implements Identifiable {
    protected Integer id;
    protected Integer quantity;
    protected Double price;
    protected Date date;

    protected Integer supplierId;

    protected Integer warehouseId;
    protected Integer productId;

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
        return id;
    }

    @Override
    public void setID(int id) {
        this.id = id;
    }
}
