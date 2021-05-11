package hu.unideb.inf;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.awt.*;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.ResourceBundle;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class ENDSceneController implements Initializable {

    @FXML
    void NextButtonPushed(ActionEvent event) throws IOException {
        MainApp.newOrder();
        Parent Next_to_Menu = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/fxml/Menu.fxml")));
        Scene Menu_Scene = new Scene(Next_to_Menu);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(Menu_Scene);
        window.show();
    }
    @FXML
    public Label sorszam;

    public List<Order> o_list = new ArrayList<>();
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        OrderDAO oDAO = new JpaOrderDAO();

        o_list = oDAO.getOrders();
        Order order = o_list.get(o_list.size() - 1);
        sorszam.setText(String.valueOf(order.getId()));

        try {
            oDAO.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
