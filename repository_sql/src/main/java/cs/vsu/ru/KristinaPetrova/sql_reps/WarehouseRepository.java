package cs.vsu.ru.KristinaPetrova.sql_reps;

import cs.vsu.ru.KristinaPetrova.models.Supplier;
import cs.vsu.ru.KristinaPetrova.models.Warehouse;
import cs.vsu.ru.KristinaPetrova.repository.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class WarehouseRepository extends SQLRepository<Warehouse> {

    @Override
    String[] getColumnNames() {
        return new String[] {"name", "address"};
    }

    @Override
    Warehouse getNewT(ResultSet rs) throws SQLException {
        Warehouse w = new Warehouse(rs.getString("name"),
                rs.getString("address"));
        w.setID(rs.getInt("id"));
        return w;
    }

    @Override
    String[] getColumns(Warehouse object) {
        return new String[]{object.getName(), object.getAddress()};
    }

    @Override
    String getTablename() {
        return "warehouse";
    }
}
