package cs.vsu.ru.KristinaPetrova.web;

import cs.vsu.ru.KristinaPetrova.database.DatabaseSQL;
import cs.vsu.ru.KristinaPetrova.models.Arrival;
import cs.vsu.ru.KristinaPetrova.models.Customer;

import javax.servlet.annotation.WebServlet;

@WebServlet(name = "customers", urlPatterns = {"/customers/*"} )
public class CustomerServlet extends CRUDServlet<Customer> {
    public CustomerServlet() {
        super(Customer.class, DatabaseSQL.getINSTANCE().customers);
    }

    @Override
    protected boolean validate(Customer obj) {
        return
                obj.getFirstName() != null &&
                obj.getLastName() != null &&
                obj.getEmail() != null;
    }
}
