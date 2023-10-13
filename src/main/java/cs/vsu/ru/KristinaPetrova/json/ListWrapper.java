package cs.vsu.ru.KristinaPetrova.json;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;
import cs.vsu.ru.KristinaPetrova.base.models.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@JsonTypeInfo(use = Id.NAME, include = JsonTypeInfo.As.WRAPPER_OBJECT)
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ListWrapper {
    private List<Arrival> arrivals;
    private List<Customer> customers;
    private List<Order> orders;
    private List<Product> products;
    private List<Supplier> suppliers;
    private List<Warehouse> warehouses;
}