/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import bean.Cabinet;
import bean.CategorieDiabete;
import bean.Conseils;
import bean.Medcin;
import helper.CategorieDiabeteFxHelper;
import helper.MesConseilsFxHelper;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javax.swing.JOptionPane;
import service.CabinetFacade;
import service.CategorieDiabeteFacade;
import service.ConseilsFacade;
import service.MedcinFacade;
import util.DateUtil;
import util.Session;

/**
 * FXML Controller class
 *
 * @author CHAACHAI Youssef
 */
public class MedcinProfileFXMLController implements Initializable {

    MedcinFacade medcinFacade = new MedcinFacade();

    @FXML
    private TextField nomField;
    @FXML
    private TextField prenomField;
    @FXML
    private TextField emailField;
    @FXML
    private TextField telephoneField;
    @FXML
    private TextField passwordField;
    @FXML
    private TextField specialiteField;
    @FXML
    private DatePicker dateNaissance;

    @FXML
    private Button modifierMedcin;

    @FXML
    private Button mesCabinets;
    @FXML
    private Button mesConseils;
    @FXML
    private Button monProfile;

    @FXML
    public void mesCabinets(ActionEvent actionEvent) throws IOException {
        ViewLauncher.forward(actionEvent, "MedcinCabinetsFXML.fxml", this.getClass());
    }

    @FXML
    public void mesConseils(ActionEvent actionEvent) throws IOException {
        ViewLauncher.forward(actionEvent, "MedcinConseilsFXML.fxml", this.getClass());
    }

    @FXML
    public void monProfile(ActionEvent actionEvent) throws IOException {
        ViewLauncher.forward(actionEvent, "MedcinProfileFXML.fxml", this.getClass());
    }

    public Conseils getParam() {
        Conseils conseil = new Conseils();
//        Medcin medcin = medcinFacade.find(1L);
//        conseil.setTitre(titre.getText());
//        conseil.setConseils(conseilField.getText());
//        conseil.setCategorieDiabete(typesCombo.getValue());
//        conseil.setMedcin(medcin);
        return conseil;
    }

    public void updateMedcin() {
        Medcin medcin = medcinFacade.find(1L);
        medcin.setNom(nomField.getText());
        medcin.setPrenom(prenomField.getText());
        medcin.setEmail(emailField.getText());
        medcin.setTelephone(telephoneField.getText());
        medcin.setSpeciaite(specialiteField.getText());
        medcin.setDateNaissance(java.sql.Date.valueOf(dateNaissance.getValue()));
        medcinFacade.edit(medcin);
        alert("Votre profil a été modifié avec succès", "Terminé!");
    }

    public void clear() {
//        titre.clear();
//        conseilField.clear();
//        typesCombo.setValue(null);
//        conseilText.setText("");
    }

    public void alert(String contenttext, String headertext) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText(headertext);
        alert.setContentText(contenttext);
        alert.setTitle("Information dialog");
        alert.show();
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        Medcin medcin = medcinFacade.find(1L);
        if (medcin != null) {
            nomField.setText(medcin.getNom());
            prenomField.setText(medcin.getPrenom());
            emailField.setText(medcin.getEmail());
            telephoneField.setText(medcin.getTelephone());
            specialiteField.setText(medcin.getSpeciaite());
            specialiteField.setText(medcin.getSpeciaite());
            if (medcin.getDateNaissance() != null && !medcin.getDateNaissance().equals("")) {
                String dateNai = DateUtil.formateDate("dd-MM-yyyy", medcin.getDateNaissance());
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
                dateNaissance.setValue(LocalDate.parse(dateNai, formatter));
            }

        }

    }

}
