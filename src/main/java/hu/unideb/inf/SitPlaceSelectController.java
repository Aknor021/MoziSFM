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
import java.io.IOException;
import java.net.URL;
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
        Parent Next_to_Meal = FXMLLoader.load(getClass().getResource("/fxml/Meal_Select.fxml") );
        Scene Meal_scene = new Scene(Next_to_Meal);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(Meal_scene);
        window.show();
    }
    @FXML
    private Label Selected_Seat_Label;
    @FXML
    private Button A1;
    @FXML
    private ChoiceBox<Integer> choicebox;
    @FXML
    private Label choice_box_display;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        fill_list();
    }

    private void fill_list() {
        for (int i = 1; i < 6; i++) {
            list.add(i);
        }
        choicebox.getItems().addAll(list);
    }

    @FXML
    void Choice_box_selected(ActionEvent event) {
        String display = String.valueOf(choicebox.getValue());
        if (display==null){choice_box_display.setText("Nem maradt több ülőhely !");}
        else{choice_box_display.setText("Ennyi ülőhelyet választott : "+choicebox.getValue());}
    }
    @FXML
    void SeatButton(ActionEvent event) {
        handle(event);
    }


    @Override
    public void handle(ActionEvent actionEvent) {
        if (actionEvent.getSource()==A1){System.out.println(((Control)actionEvent.getSource()).getId());}
    }



}
