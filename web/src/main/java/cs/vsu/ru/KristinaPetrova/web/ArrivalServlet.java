package cs.vsu.ru.KristinaPetrova.web;

import cs.vsu.ru.KristinaPetrova.Database;
import cs.vsu.ru.KristinaPetrova.database.DatabaseSQL;
import cs.vsu.ru.KristinaPetrova.models.Arrival;
import cs.vsu.ru.KristinaPetrova.repository.Repository;

import javax.servlet.annotation.WebServlet;

@WebServlet(name = "arrivals", urlPatterns = {"/arrivals/*"} )
public class ArrivalServlet extends CRUDServlet<Arrival> {
    public ArrivalServlet() {
        super(Arrival.class, DatabaseSQL.getINSTANCE().arrivals);
    }

    @Override
    protected boolean validate(Arrival obj) {
        return
                obj.getQuantity() != null &&
                obj.getPrice() != null &&
                obj.getDate() != null &&
                obj.getSupplierId() != null &&
                obj.getWarehouseId() != null &&
                obj.getProductId() != null;
    }
}
