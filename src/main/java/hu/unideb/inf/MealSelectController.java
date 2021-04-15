package hu.unideb.inf;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.awt.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javafx.scene.control.Label;

public class MealSelectController {
    List<String> order_list=new ArrayList<String>();
    List<String> order_list_DB=new ArrayList<String>();

    @FXML
    void ALL_Items_DEL(ActionEvent event) {
        order_list.clear();
        Orders_list.setText(String.valueOf(order_list));

    }
    @FXML
    void Last_item_DEL(ActionEvent event) {
        if (order_list.size()<1){Orders_list.setText("Nincs elem");}
        else {
            int last = order_list.size() - 1;
            order_list.remove(last);
            Orders_list.setText(String.valueOf(order_list));
        }
    }


    @FXML
    void BackButtonPushed(javafx.event.ActionEvent event) throws IOException {
        Parent Back_to_Sit_Place_Select= FXMLLoader.load(getClass().getResource("/fxml/Sit_Place_Select.fxml") );
        Scene Sit_Place_Select_scene = new Scene(Back_to_Sit_Place_Select);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(Sit_Place_Select_scene);
        window.show();
    }

    @FXML
    void NextButtonPushed(ActionEvent event) throws IOException {
        Meal_save(order_list_DB);
        Parent Next_to_Summary = FXMLLoader.load(getClass().getResource("/fxml/Summary.fxml") );
        Scene Summary_Scene = new Scene(Next_to_Summary);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(Summary_Scene);
        window.show();
    }
    @FXML
    private Label Orders_list;




    @FXML
    void Cola_kicsi(ActionEvent event) {
        order_list.add("Cola kicsi\n");
        order_list_DB.add("Cola kicsi");
        Orders_list.setText(String.valueOf(order_list));
    }

    @FXML
    void Cola_kozepes(ActionEvent event) {
        order_list.add("Cola közepes\n");
        order_list_DB.add("Cola közepes");
        Orders_list.setText(String.valueOf(order_list));
    }

    @FXML
    void Cola_nagy(ActionEvent event) {
        order_list.add("Cola nagy\n");
        order_list_DB.add("Cola nagy");
        Orders_list.setText(String.valueOf(order_list));
    }

    @FXML
    void Fanta_kicsi(ActionEvent event) {
        order_list.add("Fanta kicsi\n");
        order_list_DB.add("Fanta kicsi");
        Orders_list.setText(String.valueOf(order_list));
    }

    @FXML
    void Fanta_kozepes(ActionEvent event) {
        order_list.add("Fanta közepes\n");
        order_list_DB.add("Fanta közepes");
        Orders_list.setText(String.valueOf(order_list));
    }

    @FXML
    void Fanta_nagy(ActionEvent event) {
        order_list.add("Fanta nagy\n");
        order_list_DB.add("Fanta nagy");
        Orders_list.setText(String.valueOf(order_list));
    }

    @FXML
    void Nachos_kicsi(ActionEvent event) {
        order_list.add("Nachos kicsi\n");
        order_list_DB.add("Nachos kicsi");
        Orders_list.setText(String.valueOf(order_list));
    }

    @FXML
    void Nachos_kozepes(ActionEvent event) {
        order_list.add("Nachos közepes\n");
        order_list_DB.add("Nachos közepes");
        Orders_list.setText(String.valueOf(order_list));
    }

    @FXML
    void Nachos_nagy(ActionEvent event) {
        order_list.add("Nachos nagy\n");
        order_list_DB.add("Nachos nagy");
        Orders_list.setText(String.valueOf(order_list));
    }

    @FXML
    void Popcorn_kicsi(ActionEvent event) {
        order_list.add("Popcorn kicsi\n");
        order_list_DB.add("Popcorn kicsi");
        Orders_list.setText(String.valueOf(order_list));
    }

    @FXML
    void Popcorn_kozepes(ActionEvent event) {
        order_list.add("Popcorn közepes\n");
        order_list_DB.add("Popcorn közepes");
        Orders_list.setText(String.valueOf(order_list));
    }

    @FXML
    void Popcorn_nagy(ActionEvent event) {
        order_list.add("Popcorn nagy\n");
        order_list_DB.add("Popcorn nagy");
        Orders_list.setText(String.valueOf(order_list));
    }



    void Meal_save(List<String> order_list) throws IOException {
        try {
            FileWriter myWriter = new FileWriter("src/main/resources/DB/Current_order.txt", true);
            BufferedWriter bw = new BufferedWriter(myWriter);
            bw.write(order_list + ";");
            bw.close();
            System.out.println("Successfully wrote the meals to the file: Current_order ");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

}
}
