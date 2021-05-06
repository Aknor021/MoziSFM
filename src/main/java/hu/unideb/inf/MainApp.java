package hu.unideb.inf;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Control;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import org.h2.tools.Server;

import javax.persistence.*;
import java.io.IOException;
import java.sql.SQLException;
import java.time.format.DateTimeFormatter;
import java.util.*;


public class MainApp extends Application {

    static Order order = new Order();

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

    public static void generateRecord(Order order)
    {




    }



    //----------------------------------FilmSelectController--------------------------------------------------

    @FXML
    void BackToMenuPushed(ActionEvent event) throws IOException {
        Parent Back_to_Menu = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/fxml/Menu.fxml")));
        Scene Menu_scene = new Scene(Back_to_Menu);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(Menu_scene);
        window.show();
    }

    @FXML
    void film1(ActionEvent event) throws IOException {
        order.setFilm_cim("Free Guy");
        tovabbAzIdoKivalasztasra(event);
    }
    @FXML
    void film2(ActionEvent event) throws IOException {
        order.setFilm_cim("Fekete ozvegy");
        tovabbAzIdoKivalasztasra(event);
    }
    @FXML
    void film3(ActionEvent event) throws IOException {
        order.setFilm_cim("Lelki ismeretek");
        tovabbAzIdoKivalasztasra(event);
    }
    @FXML
    void film4(ActionEvent event) throws IOException {
        order.setFilm_cim("Deadpool");
        tovabbAzIdoKivalasztasra(event);
    }
    void tovabbAzIdoKivalasztasra(ActionEvent event) throws IOException {
        Parent Next_to_Time = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/fxml/Time_Select.fxml")));
        Scene Time_scene = new Scene(Next_to_Time);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(Time_scene);
        window.show();
    }

    //----------------------------------FilmSelectController_VÉGE---------------------------------------------

    //----------------------------------TimeSelectController--------------------------------------------------

    @FXML
    void BackToFilmSelectPushed(javafx.event.ActionEvent event) throws IOException {
        order.setFilm_cim(null);
        Parent Back_to_Film_Select= FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/fxml/Film_Select.fxml")));
        Scene Film_Select_scene = new Scene(Back_to_Film_Select);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(Film_Select_scene);
        window.show();
    }

    @FXML
    void NextToSitPlaceSelectPushed(ActionEvent event) throws IOException {
        Parent Next_to_Sit_Place = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/fxml/Sit_Place_Select.fxml")));
        Scene Sit_Select_scene = new Scene(Next_to_Sit_Place);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(Sit_Select_scene);
        window.show();
    }

    @FXML
    private DatePicker dp;

    @FXML
    void DatePickePicked() {
        String date = dp.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        order.setDp(date);
    }

    @FXML
    void Time1(ActionEvent event) throws IOException {
        order.setIdopont("10:00 - 12:30");
        NextToSitPlaceSelectPushed(event);
    }

    @FXML
    void Time2(ActionEvent event) throws IOException {
        order.setIdopont("13:00 - 14:30");
        NextToSitPlaceSelectPushed(event);
    }
    @FXML
    void Time3(ActionEvent event) throws IOException {
        order.setIdopont("15:00 - 16:30");
        NextToSitPlaceSelectPushed(event);
    }
    @FXML
    void Time4(ActionEvent event) throws IOException {
        order.setIdopont("17:00 - 18:30");
        NextToSitPlaceSelectPushed(event);
    }

    //----------------------------------TimeSelectController_VÉGE-------------------------------------------------

    //----------------------------------SitPlaceSelectController--------------------------------------------------

    @FXML
    void BackToTimeSelectPushed(javafx.event.ActionEvent event) throws IOException {
        Parent Back_to_Time = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/fxml/Time_Select.fxml")));
        Scene Time_scene = new Scene(Back_to_Time);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(Time_scene);
        window.show();
    }

    @FXML
    void NextToMealSelectPushed(ActionEvent event) throws IOException {
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < Seat_list.size(); i++) {
            str.append(Seat_list.get(i));
            if(i != (Seat_list.size() - 1))
                str.append(";");
        }
        order.setUlo_hely(str.toString());

        Parent Next_to_Meal = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/fxml/Meal_Select.fxml")));
        Scene Meal_scene = new Scene(Next_to_Meal);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(Meal_scene);
        window.show();
    }
    @FXML
    private Label Selected_Seat_Label;

    @FXML
    void SeatButton(ActionEvent event) {
        handle(event);
        Selected_Seat_Label.setText(String.valueOf(Seat_list));
    }

    List<String> Seat_list = new ArrayList<>();
    String Seat;

    public void handle(ActionEvent actionEvent) {
        Seat =((Control)actionEvent.getSource()).getId();
        if (!(Seat_list.contains(Seat))) {
            Seat_list.add(Seat);
        }
        else {
            Seat_list.remove(Seat);
        }
    }

    //----------------------------------SitPlaceSelectController_VÉGE---------------------------------------------

    //----------------------------------MealSelectController------------------------------------------------------

    List<String> order_list=new ArrayList<>();
    List<String> order_list_DB=new ArrayList<>();

    @FXML
    void ALL_Items_DEL() {
        order_list.clear();
        Orders_list.setText(String.valueOf(order_list));

    }
    @FXML
    void Last_item_DEL() {
        if (order_list.size()<1) {
            Orders_list.setText("Nincs elem");
        }
        else {
            int last = order_list.size() - 1;
            order_list.remove(last);
            Orders_list.setText(String.valueOf(order_list));
        }
    }

    @FXML
    void BackToSitPlacePushed(javafx.event.ActionEvent event) throws IOException {
        Parent Back_to_Sit_Place_Select= FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/fxml/Sit_Place_Select.fxml")));
        Scene Sit_Place_Select_scene = new Scene(Back_to_Sit_Place_Select);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(Sit_Place_Select_scene);
        window.show();
    }

    static int y = 0;
    @FXML
    void NextToSummaryPushed(ActionEvent event) throws IOException {
        StringBuilder str2 = new StringBuilder();
        for (int i = 0; i < order_list_DB.size(); i++) {
            str2.append(order_list_DB.get(i));
            if(i != (order_list_DB.size() - 1))
                str2.append(";");
        }
        order.setEtel_ital(str2.toString());

        y = 1;

        Parent Next_to_Summary = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/fxml/Summary.fxml")));
        Scene Summary_Scene = new Scene(Next_to_Summary);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(Summary_Scene);
        window.show();

        summary();
    }
    @FXML
    private Label Orders_list;

    @FXML
    void Cola_kicsi() {
        order_list.add("Cola kicsi\n");
        order_list_DB.add("c_s");
        Orders_list.setText(String.valueOf(order_list));
    }

    @FXML
    void Cola_kozepes() {
        order_list.add("Cola közepes\n");
        order_list_DB.add("c_m");
        Orders_list.setText(String.valueOf(order_list));
    }

    @FXML
    void Cola_nagy() {
        order_list.add("Cola Nagy\n");
        order_list_DB.add("c_l");
        Orders_list.setText(String.valueOf(order_list));
    }

    @FXML
    void Fanta_kicsi() {
        order_list.add("Fanta kicsi\n");
        order_list_DB.add("f_s");
        Orders_list.setText(String.valueOf(order_list));
    }

    @FXML
    void Fanta_kozepes() {
        order_list.add("Fanta közepes\n");
        order_list_DB.add("f_m");
        Orders_list.setText(String.valueOf(order_list));
    }

    @FXML
    void Fanta_nagy() {
        order_list.add("Fanta nagy\n");
        order_list_DB.add("f_l");
        Orders_list.setText(String.valueOf(order_list));
    }

    @FXML
    void Nachos_kicsi() {
        order_list.add("Nachos kicsi\n");
        order_list_DB.add("n_s");
        Orders_list.setText(String.valueOf(order_list));
    }

    @FXML
    void Nachos_kozepes() {
        order_list.add("Nachos közepes\n");
        order_list_DB.add("n_m");
        Orders_list.setText(String.valueOf(order_list));
    }

    @FXML
    void Nachos_nagy() {
        order_list.add("Nachos nagy\n");
        order_list_DB.add("n_l");
        Orders_list.setText(String.valueOf(order_list));
    }

    @FXML
    void Popcorn_kicsi() {
        order_list.add("Popcorn kicsi\n");
        order_list_DB.add("p_s");
        Orders_list.setText(String.valueOf(order_list));
    }

    @FXML
    void Popcorn_kozepes() {
        order_list.add("popcorn közepes\n");
        order_list_DB.add("p_m");
        Orders_list.setText(String.valueOf(order_list));
    }

    @FXML
    void Popcorn_nagy() {
        order_list.add("Popcorn nagy\n");
        order_list_DB.add("p_l");
        Orders_list.setText(String.valueOf(order_list));
    }


    //----------------------------------MealSelectController_VÉGE-------------------------------------------------

    //----------------------------------SummarySelectController---------------------------------------------------

    @FXML
    private Label Film_Label;

    @FXML
    private Label Time_label;

    @FXML
    private Label Meal_label;

    @FXML
    private Label Seat_label;

    @FXML
    void BackToMealPushed(ActionEvent event) throws IOException {
        Parent Back_to_Meal = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/fxml/Meal_Select.fxml")));
        Scene Meal_scene = new Scene(Back_to_Meal);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(Meal_scene);
        window.show();
    }


    @FXML
    void NextToEndScenePushed(ActionEvent event) throws IOException {
        generateRecord(order);

        Parent Next_to_End = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/fxml/END_Scene.fxml")));
        Scene End_scene = new Scene(Next_to_End);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(End_scene);
        window.show();
    }

    //-----KI_ÍRÓ_METÓDUS---------------NEM_MŰKÖDIK_MÉG------------------------

    public void summary() {

        //Film címe
        Film_Label.setText(order.getFilm_cim());

        //Datum és ido
        Time_label.setText(order.getDp() + " " + order.getIdopont());

        //Etel_ital
        String tomb[] = order.getEtel_ital().split(";");
        StringBuilder meal = new StringBuilder();

        Map<String, Integer> map = new TreeMap<>();

        for (int i = 0; i < tomb.length; i++) {
            if (map.containsKey(tomb[i])) {
                int x = map.get(tomb[i]);
                x++;
                map.put(tomb[0], x);
            } else
                map.put(tomb[0], 1);
        }
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            meal.append(entry.getValue()).append(" * ").append(entry.getKey()).append("\n");
        }
        Meal_label.setText(meal.toString());

        //Ülőhely
        String tomb2[] = order.ulo_hely.split(";");
        StringBuilder seat = new StringBuilder();

        for (int i = 0; i < tomb2.length; i++) {
            seat.append(tomb2[i]);
            if (i != tomb2.length - 1)
                seat.append(", ");
            else
                seat.append(".");
        }
        Seat_label.setText(seat.toString());
        }



    //----------------------------------SummarySelectController_VÉGE-------------------------------------------------

}
