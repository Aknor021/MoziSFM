package hu.unideb.inf;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class MealSelectController {
    static List<String> order_list=new ArrayList<>();
    public static List<String> order_list_DB=new ArrayList<>();

    @FXML
    void ALL_Items_DEL() {
        order_list.clear();
        order_list_DB.clear();
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
    void BackToSitPlacePushed(javafx.event.ActionEvent event) throws Exception {
        MainApp.order.setUlo_hely(null);

        Parent Back_to_Sit_Place_Select= FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/fxml/Sit_Place_Select.fxml")));
        Scene Sit_Place_Select_scene = new Scene(Back_to_Sit_Place_Select);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(Sit_Place_Select_scene);
        window.show();
    }

    @FXML
    void NextToSummaryPushed(ActionEvent event) throws Exception {
        StringBuilder str2 = new StringBuilder();
        for (int i = 0; i < order_list_DB.size(); i++) {
            str2.append(order_list_DB.get(i));
            if(i != (order_list_DB.size() - 1))
                str2.append(";");
        }
        MainApp.order.setEtel_ital(str2.toString());


        Parent Next_to_Summary = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/fxml/Summary.fxml")));
        Scene Summary_Scene = new Scene(Next_to_Summary);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(Summary_Scene);
        window.show();

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
}
