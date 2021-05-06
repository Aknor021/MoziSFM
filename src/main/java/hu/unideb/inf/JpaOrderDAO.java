package hu.unideb.inf;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class JpaOrderDAO implements OrderDAO {
    final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("br.com.fredericci.pu");
    final EntityManager entityManager = entityManagerFactory.createEntityManager();

    @Override
    public void saveOrder(Order o) {
        entityManager.getTransaction().begin(); //adatbázisba íráshoz megnyitás
        entityManager.persist(o);
        entityManager.getTransaction().commit(); //adatbázis írás lezárás
    }

    @Override
    public void deleteOrder(Order o) {

    }

    @Override
    public void updateOrder(Order o) {

    }

    @Override
    public List<Order> getOrders() {
        return null;
    }

    @Override
    public void close() throws Exception {
        entityManager.close();
        entityManagerFactory.close();
    }
}
