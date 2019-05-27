/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.sql.Date;
import bean.CategorieDiabete;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Hyperlink;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import service.CategorieDiabeteFacade;
import service.MedcinFacade;

/**
 * FXML Controller class
 *
 * @author fatima
 */
public class InscriptionMedcinController implements Initializable {

    @FXML
    private JFXButton confirmerBtn;
    @FXML
    private JFXTextField nomMD;
    @FXML
    private JFXTextField prenomMD;
    @FXML
    private JFXTextField emailMD;
    @FXML
    private JFXPasswordField mdpMD;
    @FXML
    private JFXPasswordField cmdpMD;
    @FXML
    private JFXTextField gsmMD;
    @FXML
    private DatePicker dateMD;
    @FXML
    private JFXTextField specialiteMD;

    MedcinFacade medcinFacade = new MedcinFacade();

    public void MedcinInscrire() {
        String nom = nomMD.getText();
        String prenom = prenomMD.getText();
        String email = emailMD.getText();
        String password = mdpMD.getText();
        String confirmeMdp = cmdpMD.getText();
        String gsm = gsmMD.getText();
        Date dateNaissance = Date.valueOf(dateMD.getValue());
        String specialite = specialiteMD.getText();
        if (password.equals(confirmeMdp)) {
            System.out.println("passwords kif kif");
            JOptionPane.showMessageDialog(null, "Inscription avec succée", "Bienvenue", JOptionPane.INFORMATION_MESSAGE);
            int resultat = medcinFacade.createPatient(nom, prenom, 1, email, password, gsm, dateNaissance, specialite);
            if (resultat == 1) {
                System.out.println("insertion succces");
            }

        } else {
            JOptionPane.showMessageDialog(null, "Erreur de confirmation Mot De Passe", "Error", JOptionPane.ERROR_MESSAGE);
        }

    }

//      public void create(ActionEvent actionEvent){
//          Date date1 = java.sql.Date.valueOf(dnDP.getValue());
//
//        Patient patient = new Patient(new Float(tailleTF.getText()),new Float(poidsTF.getText()), Long.MIN_VALUE, nomTF.getText(), prenomTF.getText(), emailTF.getText(), mdpTF.getText(), gsmTF.getText(), date1);
//         if(!mdpTF.getText().equals(cmdpTF.getText())){
//                JOptionPane.showMessageDialog(null, "Erreur de confirmation Mot De Passe","Error",JOptionPane.ERROR_MESSAGE);
//        }else { JOptionPane.showMessageDialog(null, "Inscription avec succée","Bienvenue",JOptionPane.INFORMATION_MESSAGE);
//        patientFacade.create(patient);
//        
//       
//    }
//    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

}
