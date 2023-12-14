package cs.vsu.ru.KristinaPetrova.web;

import cs.vsu.ru.KristinaPetrova.database.DatabaseSQL;
import cs.vsu.ru.KristinaPetrova.models.Product;
import cs.vsu.ru.KristinaPetrova.models.Supplier;

import javax.servlet.annotation.WebServlet;

@WebServlet(name = "suppliers", urlPatterns = {"/suppliers/*"} )
public class SupplierServlet extends CRUDServlet<Supplier> {
    public SupplierServlet() {
        super(Supplier.class, DatabaseSQL.getINSTANCE().suppliers);
    }

    @Override
    protected boolean validate(Supplier obj) {
        return
                obj.getCompanyName() != null &&
                obj.getAddress() != null &&
                obj.getContactPerson() != null &&
                obj.getEmail() != null;
    }
}
