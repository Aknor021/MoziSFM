package hu.unideb.inf;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.DatePicker;
import javafx.stage.Stage;

import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class TimeSelectController {
    @FXML
    void BackToFilmSelectPushed(javafx.event.ActionEvent event) throws Exception {
        MainApp.order.setFilm_cim(null);

        Parent Back_to_Film_Select= FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/fxml/Film_Select.fxml")));
        Scene Film_Select_scene = new Scene(Back_to_Film_Select);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(Film_Select_scene);
        window.show();
    }

    @FXML
    void NextToSitPlaceSelectPushed(ActionEvent event) throws Exception {
        Parent Next_to_Sit_Place = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/fxml/Sit_Place_Select.fxml")));
        Scene Sit_Select_scene = new Scene(Next_to_Sit_Place);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(Sit_Select_scene);
        window.show();
    }

    @FXML
    public DatePicker dp = null;
    public static String date;

    @FXML
    void DatePickePicked() {
        date = dp.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        MainApp.order.setDp(date);
    }

    @FXML
    void Time1(ActionEvent event) throws Exception {
        MainApp.order.setIdopont("10:00 - 12:30");
        NextToSitPlaceSelectPushed(event);
    }

    @FXML
    void Time2(ActionEvent event) throws Exception {
        MainApp.order.setIdopont("13:00 - 14:30");
        NextToSitPlaceSelectPushed(event);
    }
    @FXML
    void Time3(ActionEvent event) throws Exception {
        MainApp.order.setIdopont("15:00 - 16:30");
        NextToSitPlaceSelectPushed(event);
    }
    @FXML
    void Time4(ActionEvent event) throws Exception {
        MainApp.order.setIdopont("17:00 - 18:30");
        NextToSitPlaceSelectPushed(event);
    }
}
