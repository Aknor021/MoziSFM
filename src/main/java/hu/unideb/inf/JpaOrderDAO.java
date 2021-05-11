package hu.unideb.inf;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
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
        entityManager.getTransaction().begin();
        entityManager.remove(o);
        entityManager.getTransaction().commit();
    }

    @Override
    public void updateOrder(Order o) {
        saveOrder(o);
    }

    @Override
    public List<Order> getOrders() {
        TypedQuery<Order> query = entityManager.createQuery("SELECT o FROM Order o", Order.class);
        return query.getResultList();
    }

    @Override
    public List<String> getFoglaltHelyek() {
        List<String> foglalt_helyek = new ArrayList<>();
        List<Order> o_list = getOrders();


        for (Order o : o_list) {
            System.out.println("     ---------" + o);
            String[] ulohelyek = o.getUlo_hely().split(";");

            for (String s : ulohelyek) {
                if (TimeSelectController.date.equals(o.getDp())
                        && MainApp.order.getIdopont().equals(o.getIdopont())
                        && MainApp.order.getFilm_cim().equals(o.getFilm_cim())) {
                    foglalt_helyek.add(s);
                }
            }


        }
        return foglalt_helyek;
    }

    @Override
    public void close() {
        entityManager.close();
        entityManagerFactory.close();
    }
}
