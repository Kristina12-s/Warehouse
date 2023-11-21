package cs.vsu.ru.KristinaPetrova.sql_reps;

import cs.vsu.ru.KristinaPetrova.models.Arrival;
import cs.vsu.ru.KristinaPetrova.models.Customer;
import cs.vsu.ru.KristinaPetrova.models.Supplier;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ArrivalRepository extends SQLRepository<Arrival> {

    @Override
    String[] getColumnNames() {
        return new String[] {"quantity", "price", "date", "supplier_id",
        "warehouse_id", "product_id"};
    }

    @Override
    Arrival getNewT(ResultSet rs) throws SQLException {
        Arrival w = new Arrival(
                rs.getInt("quantity"),
                rs.getDouble("price"),
                rs.getDate("date"),
                rs.getInt("supplier_id"),
                rs.getInt("warehouse_id"),
                rs.getInt("product_id")
                );
        w.setID(rs.getInt("id"));
        return w;
    }

    @Override
    String[] getColumns(Arrival object) {
        return new String[]{
                String.valueOf(object.getQuantity()),
                String.valueOf(object.getPrice()),
                String.valueOf(object.getDate()),
                String.valueOf(object.getSupplierId()),
                String.valueOf(object.getWarehouseId()),
                String.valueOf(object.getProductId())
        };
    }

    @Override
    String getTablename() {
        return "arrival";
    }
}
