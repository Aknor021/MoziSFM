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
        ID_open();
        ID_write();
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
        ID_open();
        ID_write();
        film = "Fekete özvegy";
        film_save(film);
        Parent Next_to_Time = FXMLLoader.load(getClass().getResource("/fxml/Time_Select.fxml") );
        Scene Time_scene = new Scene(Next_to_Time);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(Time_scene);
        window.show();
    }
    @FXML
    void film3(ActionEvent event) throws IOException {
        ID_open();
        ID_write();
        film = "Lelki ismeretek";
        film_save(film);
        Parent Next_to_Time = FXMLLoader.load(getClass().getResource("/fxml/Time_Select.fxml") );
        Scene Time_scene = new Scene(Next_to_Time);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(Time_scene);
        window.show();
    }
    @FXML
    void film4(ActionEvent event) throws IOException {
        ID_open();
        ID_write();
        film = "Deadpool";
        film_save(film);
        Parent Next_to_Time = FXMLLoader.load(getClass().getResource("/fxml/Time_Select.fxml") );
        Scene Time_scene = new Scene(Next_to_Time);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(Time_scene);
        window.show();
    }
    int ID ;
    int ID_open() throws IOException {
        FileReader file = new FileReader("src/main/resources/DB/ID.txt");
        Scanner sc = new Scanner(file);
        ID = sc.nextInt();
        return ID;
    }

    void ID_write(){
        try {
            FileWriter myWriter = new FileWriter("src/main/resources/DB/Current_order.txt",true);
            BufferedWriter bw = new BufferedWriter(myWriter);
            bw.write(ID+";");
            bw.close();
            System.out.println("Successfully wrote the ID to the file : Current_order ");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    void film_save(String film) throws IOException {
        try {
            FileWriter myWriter = new FileWriter("src/main/resources/DB/Current_order.txt",true);
            BufferedWriter bw = new BufferedWriter(myWriter);
            bw.write(film+";");
            bw.close();
            System.out.println("Successfully wrote the film to the file: Current_order ");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

    }







}
