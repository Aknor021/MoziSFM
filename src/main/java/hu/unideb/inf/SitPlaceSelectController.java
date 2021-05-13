package hu.unideb.inf;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Control;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.ResourceBundle;

public class SitPlaceSelectController implements Initializable {

    @FXML
    void BackToTimeSelectPushed(javafx.event.ActionEvent event) throws Exception {
        MainApp.order.setIdopont(null);
        MainApp.order.setDp(null);
        Parent Back_to_Time = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/fxml/Time_Select.fxml")));
        Scene Time_scene = new Scene(Back_to_Time);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(Time_scene);
        window.show();
    }

    @FXML
    void NextToMealSelectPushed(ActionEvent event) throws Exception {
        arhoz_adas(cnt);
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < Seat_list.size(); i++) {
            str.append(Seat_list.get(i));
            if (i != (Seat_list.size() - 1))
                str.append(";");
        }
        MainApp.order.setUlo_hely(str.toString());

        Parent Next_to_Meal = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/fxml/Meal_Select.fxml")));
        Scene Meal_scene = new Scene(Next_to_Meal);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
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
            if (i == Seat_list.size() - 1)
                sb.append(Seat_list.get(i));
            else
                sb.append(Seat_list.get(i)).append(", ");
        }
        Selected_Seat_Label.setText(sb.toString());
    }

    List<String> Seat_list = new ArrayList<>();
    String Seat;

    int cnt =0;
    public void handle(ActionEvent actionEvent) {
        Seat = ((Control) actionEvent.getSource()).getId();
        if(!foglalt_helyek.contains(Seat))
        {
            if (!(Seat_list.contains(Seat))) {
                Seat_list.add(Seat);
                sitPlaceColor(Seat_list, 'g');
                cnt ++;

            } else {
                Seat_list.remove(Seat);
                List<String> torolt = new ArrayList<>();
                torolt.add(Seat);
                sitPlaceColor(torolt, 'o');
                torolt.clear();
                cnt--;
            }
        }
    }
    void arhoz_adas(int cnt){
        int tmp = cnt *1000;
        //MainApp.order.getAr()+1000;
        MainApp.order.setAr(tmp);
        }

    public void sitPlaceColor(List<String> helyek, char c) {
        String style = null;
        if (c == 'r')
            style = "-fx-background-color: #FF0000;";
        else if(c == 'g')
            style = "-fx-background-color: #00FF00;";
        else if(c == 'o')
            style = "-fx-background-color: #F5821E;";


        for (String s : helyek) {
            switch (s) {
                case "A1" -> A1.setStyle(style);
                case "A2" -> A2.setStyle(style);
                case "A3" -> A3.setStyle(style);
                case "A4" -> A4.setStyle(style);
                case "A5" -> A5.setStyle(style);
                case "A6" -> A6.setStyle(style);
                case "B1" -> B1.setStyle(style);
                case "B2" -> B2.setStyle(style);
                case "B3" -> B3.setStyle(style);
                case "B4" -> B4.setStyle(style);
                case "B5" -> B5.setStyle(style);
                case "B6" -> B6.setStyle(style);
                case "C1" -> C1.setStyle(style);
                case "C2" -> C2.setStyle(style);
                case "C3" -> C3.setStyle(style);
                case "C4" -> C4.setStyle(style);
                case "C5" -> C5.setStyle(style);
                case "C6" -> C6.setStyle(style);
                case "D1" -> D1.setStyle(style);
                case "D2" -> D2.setStyle(style);
                case "D3" -> D3.setStyle(style);
                case "D4" -> D4.setStyle(style);
                case "D5" -> D5.setStyle(style);
                case "D6" -> D6.setStyle(style);
                case "E1" -> E1.setStyle(style);
                case "E2" -> E2.setStyle(style);
                case "E3" -> E3.setStyle(style);
                case "E4" -> E4.setStyle(style);
                case "E5" -> E5.setStyle(style);
                case "E6" -> E6.setStyle(style);
                case "F1" -> F1.setStyle(style);
                case "F2" -> F2.setStyle(style);
                case "F3" -> F3.setStyle(style);
                case "F4" -> F4.setStyle(style);
                case "F5" -> F5.setStyle(style);
                case "F6" -> F6.setStyle(style);
            }
        }
    }

    @FXML
    public Button A1;
    @FXML
    public Button A2;
    @FXML
    public Button A3;
    @FXML
    public Button A4;
    @FXML
    public Button A5;
    @FXML
    public Button A6;
    @FXML
    public Button B1;
    @FXML
    public Button B2;
    @FXML
    public Button B3;
    @FXML
    public Button B4;
    @FXML
    public Button B5;
    @FXML
    public Button B6;
    @FXML
    public Button C1;
    @FXML
    public Button C2;
    @FXML
    public Button C3;
    @FXML
    public Button C4;
    @FXML
    public Button C5;
    @FXML
    public Button C6;
    @FXML
    public Button D1;
    @FXML
    public Button D2;
    @FXML
    public Button D3;
    @FXML
    public Button D4;
    @FXML
    public Button D5;
    @FXML
    public Button D6;
    @FXML
    public Button E1;
    @FXML
    public Button E2;
    @FXML
    public Button E3;
    @FXML
    public Button E4;
    @FXML
    public Button E5;
    @FXML
    public Button E6;
    @FXML
    public Button F1;
    @FXML
    public Button F2;
    @FXML
    public Button F3;
    @FXML
    public Button F4;
    @FXML
    public Button F5;
    @FXML
    public Button F6;

    public List<String> foglalt_helyek = new ArrayList<>();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        OrderDAO oDAO = new JpaOrderDAO();
        foglalt_helyek = oDAO.getFoglaltHelyek();
        sitPlaceColor(foglalt_helyek, 'r');

        try {
            oDAO.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}

