package hu.unideb.inf;

import java.util.List;

public interface OrderDAO extends AutoCloseable{
    public void saveOrder(Order o);
    public void deleteOrder(Order o);
    public void updateOrder(Order o);
    public List<Order> getOrders();

}
