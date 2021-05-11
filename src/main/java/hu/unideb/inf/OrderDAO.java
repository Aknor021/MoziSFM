package hu.unideb.inf;

import java.util.List;

public interface OrderDAO extends AutoCloseable{
    void saveOrder(Order o);
    void deleteOrder(Order o);
    void updateOrder(Order o);
    List<Order> getOrders();
    List<String> getFoglaltHelyek();

}
