package hu.unideb.inf;



import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class FilmSelectController implements Initializable {

    @FXML
    void BackButtonPushed(ActionEvent event) throws IOException {
        Parent Back_to_Menu = FXMLLoader.load(getClass().getResource("/fxml/Menu.fxml") );
        Scene Menu_scene = new Scene(Back_to_Menu);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(Menu_scene);
        window.show();
    }

    @FXML
    void NextButtonPushed(ActionEvent event) throws IOException {
        Parent Next_to_Time = FXMLLoader.load(getClass().getResource("/fxml/Time_Select.fxml") );
        Scene Time_scene = new Scene(Next_to_Time);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(Time_scene);
        window.show();
    }






    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
}
