package hu.unideb.inf;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.h2.tools.Server;

import javax.persistence.*;
import java.sql.SQLException;
import java.util.Date;


public class MainApp extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/Menu.fxml"));
        
        Scene scene = new Scene(root);
        scene.getStylesheets().add("/styles/Styles.css");
        
        stage.setTitle("Mozi");
        stage.setScene(scene);
        stage.show();
    }

    /**
     * The main() method is ignored in correctly deployed JavaFX application.
     * main() serves only as fallback in case the application can not be
     * launched through deployment artifacts, e.g., in IDEs with limited FX
     * support. NetBeans ignores main().
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException { //kötelező kivételkezelés
        startDatabase(); //adatbázis elindítása


        launch(args);
    }

    private static void startDatabase() throws SQLException //adatbázis elindítási metódus (programba beépített adatbázis)
    {
        new Server().runTool("-tcp", "-web", "-ifNotExists");
    }

    void generateRecord(String id, String film, String ulo_hely, Date date, String meal)
    {
        Order order = new Order();
        order.setFILM(film);
        order.setULO_HELY(ulo_hely);
        order.setDATE(date);
        order.setMEAL(meal);

        save(order);
    }

    void save(Order order)
    {
        final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("br.com.fredericci.pu");
        final EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin(); //adatbázisba íráshoz megnyitás
        entityManager.persist(order);
        entityManager.getTransaction().commit(); //adatbázis írás lezárás
    }
}
