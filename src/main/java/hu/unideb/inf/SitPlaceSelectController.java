package hu.unideb.inf;

import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Control;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import java.awt.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class SitPlaceSelectController implements Initializable , EventHandler<ActionEvent> {
    ObservableList list = FXCollections.observableArrayList();

    @FXML
    void BackButtonPushed(javafx.event.ActionEvent event) throws IOException {
        Parent Back_to_Time = FXMLLoader.load(getClass().getResource("/fxml/Time_Select.fxml") );
        Scene Time_scene = new Scene(Back_to_Time);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(Time_scene);
        window.show();
    }

    @FXML
    void NextButtonPushed(ActionEvent event) throws IOException {

        Seat_save(Seat_list);

        Parent Next_to_Meal = FXMLLoader.load(getClass().getResource("/fxml/Meal_Select.fxml") );
        Scene Meal_scene = new Scene(Next_to_Meal);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(Meal_scene);
        window.show();
    }
    @FXML
    private Label Selected_Seat_Label;




    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }




    @FXML
    void SeatButton(ActionEvent event) {
        handle(event);
        Selected_Seat_Label.setText(String.valueOf(Seat_list));
    }
    List Seat_list = new ArrayList();
    String Seat;
    @Override
    public void handle(ActionEvent actionEvent) {
        Seat =((Control)actionEvent.getSource()).getId();
        //Seat_list.add(Seat);
        if (!(Seat_list.contains(Seat))){Seat_list.add(Seat);}
        else{Seat_list.remove(Seat);}
    }
    void Seat_save(List<String> Seat_list) throws IOException {
        try {
            FileWriter myWriter = new FileWriter("src/main/resources/DB/Current_order.txt", true);
            BufferedWriter bw = new BufferedWriter(myWriter);
            bw.write(Seat_list + ";");
            bw.close();
            System.out.println("Successfully wrote the seats to the file: Current_order ");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }


    }
}
