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
import javafx.scene.control.Hyperlink;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import service.CategorieDiabeteFacade;
import service.PatientFacade;


/**
 * FXML Controller class
 *
 * @author fatima
 */
public class InscriptionMaladeController implements Initializable {
      CategorieDiabeteFacade categorieDiabeteFacade = new CategorieDiabeteFacade();
      @FXML
      private Hyperlink visiteurLink;
      @FXML
      private JFXButton inscriptionBtn;
      @FXML
      private JFXButton seConnBtn;
      @FXML 
      private JFXTextField nomTF;
      @FXML 
      private JFXTextField prenomTF;
      @FXML 
      private JFXTextField loginTF;
      @FXML 
      private JFXTextField emailTF;
      @FXML 
      private JFXPasswordField mdpTF;
      @FXML 
      private JFXPasswordField cmdpTF;
      @FXML 
      private JFXTextField gsmTF;
      @FXML 
      private JFXTextField tailleTF;
      @FXML 
      private JFXTextField poidsTF;
      
      @FXML 
      private JFXDatePicker dnDP;
     
      @FXML 
      private JFXComboBox<CategorieDiabete> typeCB;
      @FXML
      PatientFacade patientFacade = new PatientFacade();
      
      
      
      
       
      
      public void PatientInscrire(){
          String nom = nomTF.getText();
          String prenom = prenomTF.getText();
          String email = emailTF.getText();
          String password = mdpTF.getText();
          String confirmeMdp = cmdpTF.getText();
          String gsm = gsmTF.getText();
          Date dateNaissance = Date.valueOf(dnDP.getValue()) ;
          float poids =Float.valueOf(poidsTF.getText()) ;
          float taille = Float.valueOf(tailleTF.getText());
          CategorieDiabete typeDiabete = typeCB.getValue();
          
          if(password.equals(confirmeMdp)){
              System.out.println("passwords kif kif");
              JOptionPane.showMessageDialog(null, "Inscription avec succée","Bienvenue",JOptionPane.INFORMATION_MESSAGE);
              int resultat = patientFacade.createPatient(nom,prenom,1,email,password,gsm,dateNaissance,taille,poids,typeDiabete);
              if(resultat == 1){
                  System.out.println("insertion succces");
              }
             
          }
          else{
              JOptionPane.showMessageDialog(null, "Erreur de confirmation Mot De Passe","Error",JOptionPane.ERROR_MESSAGE);
          }
          
          
      }
      private void initComboboxTypes() {
        typeCB.setItems(FXCollections.observableArrayList(categorieDiabeteFacade.findAll()));
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
        
        initComboboxTypes();
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
            stage.setTitle("Connexion");
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
