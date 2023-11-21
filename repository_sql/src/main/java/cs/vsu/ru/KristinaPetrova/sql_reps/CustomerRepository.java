package cs.vsu.ru.KristinaPetrova.sql_reps;

import cs.vsu.ru.KristinaPetrova.models.Customer;
import cs.vsu.ru.KristinaPetrova.models.Product;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CustomerRepository extends SQLRepository<Customer> {
    @Override
    String[] getColumnNames() {
        return new String[] {"first_name", "last_name", "email"};
    }

    @Override
    Customer getNewT(ResultSet rs) throws SQLException {
        Customer w = new Customer(rs.getString("first_name"),
                rs.getString("last_name"),
                rs.getString("email"));
        w.setID(rs.getInt("id"));
        return w;
    }

    @Override
    String[] getColumns(Customer object) {
        return new String[]{
                object.getFirstName(),
                object.getLastName(),
                object.getEmail(),
        };
    }

    @Override
    String getTablename() {
        return "customer";
    }
}
