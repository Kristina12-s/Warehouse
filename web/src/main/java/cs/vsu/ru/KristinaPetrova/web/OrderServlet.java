package cs.vsu.ru.KristinaPetrova.web;

import cs.vsu.ru.KristinaPetrova.database.DatabaseSQL;
import cs.vsu.ru.KristinaPetrova.models.Customer;
import cs.vsu.ru.KristinaPetrova.models.Order;

import javax.servlet.annotation.WebServlet;

@WebServlet(name = "orders", urlPatterns = {"/orders/*"} )
public class OrderServlet extends CRUDServlet<Order> {
    public OrderServlet() {
        super(Order.class, DatabaseSQL.getINSTANCE().orders);
    }

    @Override
    protected boolean validate(Order obj) {
        return
                obj.getOrderDate() != null &&
                obj.getQuantity() != null &&
                obj.getPrice() != null &&
                obj.getCustomerAddress() != null &&
                obj.getCustomerId() != null &&
                obj.getProductId() != null &&
                obj.getWarehouseId() != null;
    }
}
