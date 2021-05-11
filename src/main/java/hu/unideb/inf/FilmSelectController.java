package hu.unideb.inf;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Control;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class FilmSelectController  {
    @FXML
    void BackToMenuPushed(ActionEvent event) throws IOException {
        Parent Back_to_Menu = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/fxml/Menu.fxml")));
        Scene Menu_scene = new Scene(Back_to_Menu);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(Menu_scene);
        window.show();
    }
    String film_nev;
    @FXML
    void film1(ActionEvent event) throws Exception {
        film_nev =((Control)event.getSource()).getId();
        MainApp.order.setFilm_cim(film_nev);
        tovabbAzIdoKivalasztasra(event);
    }



    void tovabbAzIdoKivalasztasra(ActionEvent event) throws Exception {
        Parent Next_to_Time = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/fxml/Time_Select.fxml")));
        Scene Time_scene = new Scene(Next_to_Time);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(Time_scene);
        window.show();
    }


}
