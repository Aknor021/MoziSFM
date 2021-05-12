package hu.unideb.inf;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.net.URL;
import java.util.Map;
import java.util.Objects;
import java.util.ResourceBundle;
import java.util.TreeMap;

public class SummaryController implements Initializable{

    @FXML
    private Label terem_label;

    @FXML
    private Label Film_Label;

    @FXML
    private Label Time_label;

    @FXML
    private Label Meal_label;

    @FXML
    private Label Seat_label;

    @FXML
    void BackToMealPushed(ActionEvent event) throws Exception {
        MainApp.order.setEtel_ital(null);
        MealSelectController.order_list.clear();
        MealSelectController.order_list_DB.clear();

        Parent Back_to_Meal = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/fxml/Meal_Select.fxml")));
        Scene Meal_scene = new Scene(Back_to_Meal);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(Meal_scene);
        window.show();
    }

    @FXML
    void NextToEndScenePushed(ActionEvent event) throws Exception {
        OrderDAO oDAO = new JpaOrderDAO();
        oDAO.saveOrder(MainApp.order);
        oDAO.close();

        MealSelectController.order_list.clear();
        MealSelectController.order_list_DB.clear();

        Parent Next_to_End = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/fxml/END_Scene.fxml")));
        Scene End_scene = new Scene(Next_to_End);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(End_scene);
        window.show();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {


        terem_label.setText(Terem(film));

        //Film címe
        Film_Label.setText(MainApp.order.getFilm_cim());

        //Datum és ido
        Time_label.setText(MainApp.order.getDp() + " " + MainApp.order.getIdopont());

        if (MealSelectController.order_list_DB.size() != 0) {
            //Etel_ital
            String[] tomb = MainApp.order.getEtel_ital().split(";");
            StringBuilder meal = new StringBuilder();

            Map<String, Integer> map = new TreeMap<>();

            for (String s : tomb) {
                String str = switch (s) {
                    case "c_s" -> "Cola (kicsi)";
                    case "c_m" -> "Cola (közepes)";
                    case "c_l" -> "Cola (nagy)";
                    case "f_s" -> "Fanta (kicsi)";
                    case "f_m" -> "Fanta (közepes)";
                    case "f_l" -> "Fanta (nagy)";
                    case "p_s" -> "Popcorn (kicsi)";
                    case "p_m" -> "Popcorn (közepes)";
                    case "p_l" -> "Popcorn (nagy)";
                    case "n_s" -> "Nachos (kicsi)";
                    case "n_m" -> "Nachos (közepes)";
                    case "n_l" -> "Nachos (nagy)";
                    default -> null;
                };
                if (map.containsKey(str)) {
                    int x = map.get(str);
                    x++;
                    map.put(str, x);
                } else
                    map.put(str, 1);
            }

            for (Map.Entry<String, Integer> entry : map.entrySet()) {
                meal.append(entry.getValue()).append(" * ").append(entry.getKey()).append("\n");
            }
            Meal_label.setText(meal.toString());
        }
        else
            Meal_label.setText("Nem rendelt.");

        //Ülőhely
        String[] tomb2 = MainApp.order.getUlo_hely().split(";");
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
    String terem;
    String film = MainApp.order.getFilm_cim();

    public String Terem(String film)
    {
        int n=0 ;
        switch (film){
            case "Deadpool" -> n=1;
            case "Aquaman" -> n=2;
            case "Az_apáca" -> n=3;
            case "David_copperfield" -> n=4;
            case "doorman" -> n=5;
            case "Fekete_Ozvegy" -> n=6;
            case "Free_Guy" -> n=7;
            case "Szellemirtok" -> n=8;
            case "hivatlan" -> n=9;
            case "Lelki_Ismeretek" -> n=10;
            case "monster_hunter" -> n=11;
            case "spiral" -> n=12;
        }
        terem = String.valueOf(n);
        return terem;
    }
}
