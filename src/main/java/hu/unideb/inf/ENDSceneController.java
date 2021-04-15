package hu.unideb.inf;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;

public class ENDSceneController {
    @FXML
    void NextButtonPushed(ActionEvent event) throws IOException {

        file_delete();

        Parent Next_to_Menu = FXMLLoader.load(getClass().getResource("/fxml/Menu.fxml") );
        Scene Menu_Scene = new Scene(Next_to_Menu);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(Menu_Scene);
        window.show();
    }
    void file_delete(){
        File ID = new File("C:/Users/WaterMelon/Desktop/Repu/MoziSFM/src/main/resources/DB/Current_order.txt");
        if (ID.delete()) {
            System.out.println("Deleted the file: " + ID.getName());
        } else {
            System.out.println("Failed to delete the file.");
        }
    }
}
