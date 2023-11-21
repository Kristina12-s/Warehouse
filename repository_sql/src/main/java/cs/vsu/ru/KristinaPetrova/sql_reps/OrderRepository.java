package cs.vsu.ru.KristinaPetrova.sql_reps;

import cs.vsu.ru.KristinaPetrova.models.Arrival;
import cs.vsu.ru.KristinaPetrova.models.Order;

import java.sql.ResultSet;
import java.sql.SQLException;

public class OrderRepository extends SQLRepository<Order> {
    @Override
    String[] getColumnNames() {
        return new String[] {"order_date", "quantity", "price", "customer_address",
        "customer_id", "warehouse_id", "product_id"};
    }

    @Override
    Order getNewT(ResultSet rs) throws SQLException {
        Order w = new Order(
                rs.getDate("order_date"),
                rs.getInt("quantity"),
                rs.getDouble("price"),
                rs.getString("customer_address"),
                rs.getInt("customer_id"),
                rs.getInt("warehouse_id"),
                rs.getInt("product_id")
                );
        w.setID(rs.getInt("id"));
        return w;
    }

    @Override
    String[] getColumns(Order object) {
        return new String[]{
                String.valueOf(object.getOrderDate()),
                String.valueOf(object.getQuantity()),
                String.valueOf(object.getPrice()),
                String.valueOf(object.getCustomerAddress()),
                String.valueOf(object.getCustomerId()),
                String.valueOf(object.getWarehouseId()),
                String.valueOf(object.getProductId())
        };
    }

    @Override
    String getTablename() {
        return "order_table";
    }
}
