package cs.vsu.ru.KristinaPetrova.sql_reps;

import cs.vsu.ru.KristinaPetrova.models.Product;
import cs.vsu.ru.KristinaPetrova.models.Supplier;
import cs.vsu.ru.KristinaPetrova.models.Warehouse;

import java.sql.ResultSet;
import java.sql.SQLException;

public class SupplierRepository extends SQLRepository<Supplier> {
    @Override
    String[] getColumnNames() {
        return new String[] {"company_name", "address", "contact_person", "email"};
    }

    @Override
    Supplier getNewT(ResultSet rs) throws SQLException {
        Supplier w = new Supplier(rs.getString("company_name"),
                rs.getString("address"),
                rs.getString("contact_person"),
                rs.getString("email"));
        w.setID(rs.getInt("id"));
        return w;
    }

    @Override
    String[] getColumns(Supplier object) {
        return new String[]{
                object.getCompanyName(),
                object.getAddress(),
                object.getContactPerson(),
                object.getEmail()
        };
    }

    @Override
    String getTablename() {
        return "supplier";
    }
}
