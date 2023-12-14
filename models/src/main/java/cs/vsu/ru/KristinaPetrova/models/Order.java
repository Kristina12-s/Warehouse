package cs.vsu.ru.KristinaPetrova.models;


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
    protected Integer quantity;
    protected Double price;
    protected String customerAddress;
    protected Integer customerId;
    protected Integer productId;
    protected Integer warehouseId;

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
