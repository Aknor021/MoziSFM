package hu.unideb.inf;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.h2.tools.Server;

import java.sql.SQLException;
import java.util.*;


public class MainApp extends Application {


    public static Order order;

    public static void newOrder() {
        order = new Order();
        order.setEtel_ital(null);
        order.setFilm_cim(null);
        order.setDp(null);
        order.setUlo_hely(null);
        order.setIdopont(null);

    }

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/fxml/Menu.fxml")));

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
    public static void main(String[] args) throws Exception { //kötelező kivételkezelés
        startDatabase(); //adatbázis elindítása

        newOrder();

        System.out.println("___________________________________________________________");
        System.out.println("Az adatbazis elindult, a megnyitasahoz tedd a kovetkezoket:");
        System.out.println("- Nyiss meg egy bongeszot");
        System.out.println("- Url-be ird be         : http://localhost:8082/");
        System.out.println("- JDBC URL              : jdbc:h2:file:~/database");
        System.out.println("- User Name             : sa");
        System.out.println("- Password              : [hagyd uresen]"); //egyelőre még nincs jelszó
        System.out.println("___________________________________________________________");

        launch(args);

    }

    private static void startDatabase() throws SQLException {//adatbázis elindítási metódus (programba beépített adatbázis)
        new Server().runTool("-tcp", "-web", "-ifNotExists");
    }
}
