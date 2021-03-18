package hu.unideb.inf;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class SummaryController {
    @FXML
    void BackButtonPushed(ActionEvent event) throws IOException {
        Parent Back_to_Meal = FXMLLoader.load(getClass().getResource("/fxml/Meal_Select.fxml") );
        Scene Meal_scene = new Scene(Back_to_Meal);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(Meal_scene);
        window.show();
    }

    @FXML
    void NextButtonPushed(ActionEvent event) throws IOException {
        Parent Next_to_End = FXMLLoader.load(getClass().getResource("/fxml/END_Scene.fxml") );
        Scene End_scene = new Scene(Next_to_End);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(End_scene);
        window.show();
    }
}
