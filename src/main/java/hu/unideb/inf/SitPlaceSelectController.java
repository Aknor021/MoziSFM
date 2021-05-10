package hu.unideb.inf;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Control;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.net.URL;
import java.util.*;

public class SitPlaceSelectController implements Initializable {
    @FXML
    void BackToTimeSelectPushed(javafx.event.ActionEvent event) throws Exception {
        MainApp.order.setIdopont(null);
        MainApp.order.setDp(null);


        Parent Back_to_Time = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/fxml/Time_Select.fxml")));
        Scene Time_scene = new Scene(Back_to_Time);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(Time_scene);
        window.show();
    }

    @FXML
    void NextToMealSelectPushed(ActionEvent event) throws Exception {
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < Seat_list.size(); i++) {
            str.append(Seat_list.get(i));
            if(i != (Seat_list.size() - 1))
                str.append(";");
        }
        MainApp.order.setUlo_hely(str.toString());


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

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < Seat_list.size(); i++) {
            if(i == Seat_list.size() - 1)
                sb.append(Seat_list.get(i));
            else
                sb.append(Seat_list.get(i)).append(", ");
        }
        Selected_Seat_Label.setText(sb.toString());
    }

    List<String> Seat_list = new ArrayList<>();
    String Seat;

    public void handle(ActionEvent actionEvent) {
    Seat =((Control)actionEvent.getSource()).getId();
        if (!(Seat_list.contains(Seat))) {
            Seat_list.add(Seat);
        } else {
            Seat_list.remove(Seat);
        }
    }


    public List<String> foglalt_helyek = new ArrayList<>();
    public List<Order> o_list = new ArrayList<>();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        OrderDAO oDAO = new JpaOrderDAO();

        o_list = oDAO.getOrders();
        for (Order o : o_list) {
            String[] ulohelyek = o.getUlo_hely().split(";");

            if(TimeSelectController.date.equals(o.getDp())
                    && MainApp.order.getIdopont().equals(o.getIdopont())
                    && MainApp.order.getFilm_cim().equals(o.getFilm_cim()))
            {
                Collections.addAll(foglalt_helyek, ulohelyek);
            }
        }
        //a foglalt_helyek változóban az összes foglalt hely szerepel Stringként



        try {
            oDAO.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
