package cs.vsu.ru.KristinaPetrova.web;

import cs.vsu.ru.KristinaPetrova.database.DatabaseSQL;
import cs.vsu.ru.KristinaPetrova.models.Warehouse;

import javax.servlet.annotation.WebServlet;

@WebServlet(name = "warehouses", urlPatterns = {"/warehouses/*"} )
public class WarehouseServlet extends CRUDServlet<Warehouse> {
    public WarehouseServlet() {
        super(Warehouse.class, DatabaseSQL.getINSTANCE().warehouses);
    }

    @Override
    protected boolean validate(Warehouse obj) {
        return
                obj.getName() != null &&
                obj.getAddress() != null;
    }
}
