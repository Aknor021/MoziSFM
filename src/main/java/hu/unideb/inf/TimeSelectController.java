package hu.unideb.inf;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class TimeSelectController {
    @FXML
    void BackButtonPushed(javafx.event.ActionEvent event) throws IOException {
        Parent Back_to_Film_Select= FXMLLoader.load(getClass().getResource("/fxml/Film_Select.fxml") );
        Scene Film_Select_scene = new Scene(Back_to_Film_Select);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(Film_Select_scene);
        window.show();
    }

    @FXML
    void NextButtonPushed(ActionEvent event) throws IOException {
        Parent Next_to_Sit_Place = FXMLLoader.load(getClass().getResource("/fxml/Sit_Place_Select.fxml") );
        Scene Sit_Select_scene = new Scene(Next_to_Sit_Place);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(Sit_Select_scene);
        window.show();
    }

}

