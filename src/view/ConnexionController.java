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
import javafx.scene.control.Hyperlink;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import static org.eclipse.persistence.jpa.rs.util.JPARSLogger.exception;
import service.UtilisateurFacade;
import util.Session;

/**
 * FXML Controller class
 *
 * @author fatima
 */
public class ConnexionController implements Initializable {

    UtilisateurFacade uf = new UtilisateurFacade();
    @FXML
    private Hyperlink visiteurLink;
    @FXML
    private JFXButton inscriptionBtn;
    @FXML
    private JFXButton seConnBtn;
    @FXML
    private JFXButton seConnectBtn;
    @FXML
    private TextField login;
    @FXML
    private PasswordField password;

    public void connect(ActionEvent actionEvent)throws IOException {
        
        System.out.println("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAa");
        int res = uf.seConnecter(login.getText(), password.getText());
        System.out.println(res);
        switch (res) {
            case 1:
                System.out.println("welcome");
                Utilisateur utilisateur = uf.getUtilisateurByTelOrEmail(login.getText());
                Session.createAtrribute(utilisateur, "connectedUser");
                switch (utilisateur.getRole()) {
                    case 1:
                        ViewLauncher.forward(actionEvent, "Accueil.fxml", this.getClass());
                        System.out.println("vous etes un patient");
                        break;
                    case 2:
                        ViewLauncher.forward(actionEvent, "Accueil.fxml", this.getClass());
                        System.out.println("vous etes medcin");
                        break;
                    default:
                        break;
                }
                break;
            case -2:
                JOptionPane.showMessageDialog(null, "L'identifiant ou le mot de passe est incorrect !", "Echec de la connexion", JOptionPane.ERROR_MESSAGE);
                break;
            default:
                JOptionPane.showMessageDialog(null, "something bad happened, please try again later !", "Error", JOptionPane.ERROR_MESSAGE);
                break;
        }
    }

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
                    ((Node) (event.getSource())).getScene().getWindow().hide();
                } catch (IOException e) {
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
                    ((Node) (event.getSource())).getScene().getWindow().hide();
                } catch (IOException e) {
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
                    ((Node) (event.getSource())).getScene().getWindow().hide();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }

}
