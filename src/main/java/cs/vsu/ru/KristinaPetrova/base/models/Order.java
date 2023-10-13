package cs.vsu.ru.KristinaPetrova.base.models;

import cs.vsu.ru.KristinaPetrova.base.Identifiable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Order implements Identifiable {
    protected Integer id;
    protected Date orderDate;
    protected int quantity;
    protected double price;
    protected String customerAddress;
    protected int customerId;
    protected int productId;
    protected int warehouseId;

    public Order(Date orderDate, int quantity, double price, String customerAddress, int customerId, int productId,
                 int warehouseId) {
        this.id = null;
        this.orderDate = orderDate;
        this.quantity = quantity;
        this.price = price;
        this.customerAddress = customerAddress;
        this.customerId = customerId;
        this.productId = productId;
        this.warehouseId = warehouseId;
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
