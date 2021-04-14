package hu.unideb.inf;



import java.io.*;
import java.net.URL;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.Scanner;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import javax.xml.crypto.Data;

public class FilmSelectController    {

    String film;

    public FilmSelectController() throws IOException {
    }


    @FXML
    void BackButtonPushed(ActionEvent event) throws IOException {
        Parent Back_to_Menu = FXMLLoader.load(getClass().getResource("/fxml/Menu.fxml") );
        Scene Menu_scene = new Scene(Back_to_Menu);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(Menu_scene);
        window.show();
    }


/*    @FXML
    void NextButtonPushed(ActionEvent event) throws IOException {
        Parent Next_to_Time = FXMLLoader.load(getClass().getResource("/fxml/Time_Select.fxml") );
        Scene Time_scene = new Scene(Next_to_Time);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(Time_scene);
        window.show();
    }
    */

    @FXML
    void film1(ActionEvent event) throws IOException {
        film = "Free Guy";
        film_save(film);
        Parent Next_to_Time = FXMLLoader.load(getClass().getResource("/fxml/Time_Select.fxml") );
        Scene Time_scene = new Scene(Next_to_Time);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(Time_scene);
        window.show();
    }
    @FXML
    void film2(ActionEvent event) throws IOException {
        film_save("Fekete özvegy");
        Parent Next_to_Time = FXMLLoader.load(getClass().getResource("/fxml/Time_Select.fxml") );
        Scene Time_scene = new Scene(Next_to_Time);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(Time_scene);
        window.show();
    }
    @FXML
    void film3(ActionEvent event) throws IOException {
        film_save("Lelki terror");
        Parent Next_to_Time = FXMLLoader.load(getClass().getResource("/fxml/Time_Select.fxml") );
        Scene Time_scene = new Scene(Next_to_Time);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(Time_scene);
        window.show();
    }
    @FXML
    void film4(ActionEvent event) throws IOException {
        film_save("film4");
        Parent Next_to_Time = FXMLLoader.load(getClass().getResource("/fxml/Time_Select.fxml") );
        Scene Time_scene = new Scene(Next_to_Time);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(Time_scene);
        window.show();
    }



    void film_save(String film) throws IOException {
        try {
            FileWriter myWriter = new FileWriter("Current_order.txt");
            myWriter.write(film);
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

    }







}
