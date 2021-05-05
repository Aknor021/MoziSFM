package hu.unideb.inf;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class FXMLController implements Initializable {

    @FXML
    private Button ChangeScenePushed;

    @FXML
    void ChangeScenePushed(ActionEvent event) throws IOException {
        Parent Film_Select = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/fxml/Film_Select.fxml")));
        Scene Film_Scene = new Scene(Film_Select);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(Film_Scene);
        window.show();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
}
