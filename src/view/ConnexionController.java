/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import bean.Utilisateur;
import com.jfoenix.controls.JFXButton;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.stage.Stage;


/**
 * FXML Controller class
 *
 * @author fatima
 */
public class ConnexionController implements Initializable {
     @FXML
    private Hyperlink visiteurLink;
      @FXML
     private JFXButton inscriptionBtn;
       @FXML
     private JFXButton seConnBtn;
   
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
         visiteurLink.setOnAction(new EventHandler<ActionEvent>() {
    public void handle(ActionEvent event) {
        Parent root;
        try {
            root = FXMLLoader.load(getClass().getClassLoader().getResource("view/Accueil.fxml"));
            Stage stage = new Stage();
            stage.setTitle("Accueill");
            stage.setScene(new Scene(root));
            stage.show();
            // Hide this current window (if this is what you want)
            ((Node)(event.getSource())).getScene().getWindow().hide();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
});
           inscriptionBtn.setOnAction(new EventHandler<ActionEvent>() {
    public void handle(ActionEvent event) {
        Parent root;
        try {
            root = FXMLLoader.load(getClass().getClassLoader().getResource("view/Inscription.fxml"));
            Stage stage = new Stage();
            stage.setTitle("Inscription");
            stage.setScene(new Scene(root));
            stage.show();
            // Hide this current window (if this is what you want)
            ((Node)(event.getSource())).getScene().getWindow().hide();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
});
           seConnBtn.setOnAction(new EventHandler<ActionEvent>() {
    public void handle(ActionEvent event) {
        Parent root;
        try {
            root = FXMLLoader.load(getClass().getClassLoader().getResource("view/Connexion.fxml"));
            Stage stage = new Stage();
            stage.setTitle("Connexion3");
            stage.setScene(new Scene(root));
            stage.show();
            // Hide this current window (if this is what you want)
            ((Node)(event.getSource())).getScene().getWindow().hide();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
});
    }    
    
}
