package hu.unideb.inf;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;

public class SummaryController implements Initializable {
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
    @FXML
    private Label ID_Label;

    @FXML
    private Label Film_Label;

    @FXML
    private Label Time_label;

    @FXML
    private Label Meal_label;

    @FXML
    private Label Seat_label;


    String Current_order;
    String[] tokens;
    String ID,FILM,TIME,SEAT,MEAL;

    String Current_order_open() throws IOException {
        File file = new File("src/main/resources/DB/Current_order.txt");
        BufferedReader br = new BufferedReader(new FileReader(file));

        String st;
        while ((st = br.readLine()) != null){
            tokens= st.split(";");
            System.out.println(st);
        }


        ID =tokens[0];
        FILM =tokens[1];
        TIME =tokens[2];
        SEAT =tokens[3];
        MEAL =tokens[4];


        return Current_order;
    }




    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            Current_order_open();
        } catch (IOException e) {
            e.printStackTrace();
        }


        ID_Label.setText(ID);
        Film_Label.setText(FILM);
        Time_label.setText(TIME);
        Meal_label.setText(SEAT);
        Seat_label.setText(MEAL);
    }
}
