package cs.vsu.ru.KristinaPetrova.sql_reps;

import cs.vsu.ru.KristinaPetrova.models.Customer;
import cs.vsu.ru.KristinaPetrova.models.Product;
import cs.vsu.ru.KristinaPetrova.models.Supplier;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductRepository extends SQLRepository<Product> {

    @Override
    String[] getColumnNames() {
        return new String[] {"name", "description", "price"};
    }

    @Override
    Product getNewT(ResultSet rs) throws SQLException {
        Product w = new Product(rs.getString("name"),
                rs.getString("description"),
                rs.getDouble("price"));
        w.setID(rs.getInt("id"));
        return w;
    }

    @Override
    String[] getColumns(Product object) {
        return new String[]{
                object.getName(),
                object.getDescription(),
                String.valueOf(object.getPrice()),
        };
    }

    @Override
    String getTablename() {
        return "product";
    }
}
