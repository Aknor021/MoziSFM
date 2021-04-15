package hu.unideb.inf;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.DatePicker;
import javafx.stage.Stage;

import javax.xml.crypto.Data;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;

public class TimeSelectController {
    String Date_Time;
    String time;
    LocalDate ld;

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


    @FXML
    private DatePicker dp;

    @FXML
    void DatePickePicked(ActionEvent event) {
        ld = dp.getValue();
        System.out.println("picked date : "+ld);
    }


    @FXML
    void Time1(ActionEvent event) throws IOException {
        time="10:00-12:30";
        time_changer(time,ld);
        Date_save(time_changer(time,ld));
        NextButtonPushed(event);
    }

    @FXML
    void Time2(ActionEvent event) throws IOException {
        time="10:00-12:30";
        time_changer(time,ld);
        Date_save(time_changer(time,ld));
        NextButtonPushed(event);
    }
    @FXML
    void Time3(ActionEvent event) throws IOException {
        time="10:00-12:30";
        Date_save(time_changer(time,ld));
        NextButtonPushed(event);
    }
    @FXML
    void Time4(ActionEvent event) throws IOException {
        time="10:00-12:30";
        Date_save(time_changer(time,ld));
        NextButtonPushed(event);
    }

    void Date_save(String Date_Time) throws IOException {
        try {
            FileWriter myWriter = new FileWriter("src/main/resources/DB/Current_order.txt",true);
            BufferedWriter bw = new BufferedWriter(myWriter);
            bw.write(Date_Time+";");
            bw.close();
            System.out.println("Successfully wrote the time to the file: Current_order ");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
    String time_changer(String date ,LocalDate ld )
    {
        Date_Time =date+" "+ld;
        System.out.println(Date_Time);
        return Date_Time;
    }


}