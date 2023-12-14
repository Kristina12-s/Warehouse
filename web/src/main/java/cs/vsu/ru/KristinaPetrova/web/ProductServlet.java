package cs.vsu.ru.KristinaPetrova.web;

import cs.vsu.ru.KristinaPetrova.database.DatabaseSQL;
import cs.vsu.ru.KristinaPetrova.models.Order;
import cs.vsu.ru.KristinaPetrova.models.Product;

import javax.servlet.annotation.WebServlet;

@WebServlet(name = "products", urlPatterns = {"/products/*"} )
public class ProductServlet extends CRUDServlet<Product> {
    public ProductServlet() {
        super(Product.class, DatabaseSQL.getINSTANCE().products);
    }

    @Override
    protected boolean validate(Product obj) {
        return
                obj.getName() != null &&
                obj.getDescription() != null &&
                obj.getPrice() != null;
    }
}
