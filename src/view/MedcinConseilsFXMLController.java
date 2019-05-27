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
import util.Session;

/**
 * FXML Controller class
 *
 * @author CHAACHAI Youssef
 */
public class MedcinConseilsFXMLController implements Initializable {

    ConseilsFacade conseilsFacade = new ConseilsFacade();
    CategorieDiabeteFacade categorieDiabeteFacade = new CategorieDiabeteFacade();
    MedcinFacade medcinFacade = new MedcinFacade();

    private MesConseilsFxHelper mesConseilsFxHelper;
    private CategorieDiabeteFxHelper categorieDiabeteFxHelper;

    @FXML
    private TableView typesTable;
    @FXML
    private TableView conseilsTable;

    @FXML
    private TextField typeFind;

    @FXML
    private Button ajouterConseil;
    @FXML
    private Button modifierConseil;
    @FXML
    private Button supprimerConseil;

    @FXML
    private Button mesCabinets;
    @FXML
    private Button mesConseils;
    @FXML
    private Button monProfile;

    @FXML
    private Text conseilText;
    @FXML
    private TextArea conseilField;
    @FXML
    private TextField titre;

    @FXML
    private ComboBox<CategorieDiabete> typesCombo = new ComboBox<>();

    private void initComboboxTypes() {
        typesCombo.setItems(FXCollections.observableArrayList(categorieDiabeteFacade.findAll()));
    }

    private void initHelper() {
        mesConseilsFxHelper = new MesConseilsFxHelper(conseilsTable);
        categorieDiabeteFxHelper = new CategorieDiabeteFxHelper(typesTable, categorieDiabeteFacade.findAll());
    }

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

    public void mouseClickedTableTypes() {
        CategorieDiabete type = categorieDiabeteFxHelper.getSelected();
        Session.updateAttribute(type, "categorieDiabete");
        mesConseilsFxHelper.setList(conseilsFacade.findByMedcinAndCategory(1L, type.getId()));
    }

    public void mouseClickedTableConseils() {
        Conseils conseil = mesConseilsFxHelper.getSelected();
        Session.updateAttribute(conseil, "conseil");
        conseilText.setText(conseil.getConseils());
        conseilField.setText(conseil.getConseils());
        titre.setText(conseil.getTitre());
        typesCombo.getSelectionModel().select(conseil.getCategorieDiabete());
    }

    public Conseils getParam() {
        Conseils conseil = new Conseils();
        Medcin medcin = medcinFacade.find(1L);
        conseil.setTitre(titre.getText());
        conseil.setConseils(conseilField.getText());
        conseil.setCategorieDiabete(typesCombo.getValue());
        conseil.setMedcin(medcin);
        return conseil;
    }

    public void addConseil() {
        if (titre.getText().equals("") || typesCombo.getValue() == null || conseilField.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Veuillez remplir tout les chapms !", "Echec!", JOptionPane.ERROR_MESSAGE);
        } else {
            Conseils conseil = getParam();
            conseilsFacade.create(conseil);
            mesConseilsFxHelper.create(conseil);
            clear();
            conseilText.setText(conseil.getConseils());
        }
    }

    public void updateConseil() {
        Conseils conseil = (Conseils) Session.getAttribut("conseil");
        Medcin medcin = medcinFacade.find(1L);
        conseil.setTitre(titre.getText());
        conseil.setConseils(conseilField.getText());
        conseil.setCategorieDiabete(typesCombo.getValue());
        conseil.setMedcin(medcin);
        conseilsFacade.edit(conseil);
        conseilsTable.refresh();
        clear();
    }

    public void deleteConseil() {
        Conseils conseils = (Conseils) conseilsTable.getSelectionModel().getSelectedItem();
        Alert aa = new Alert(Alert.AlertType.CONFIRMATION);
        aa.setHeaderText("ATTENTION!!");
        aa.setContentText("Voulez-vous vraiment supprimer ce conseil ?");
        aa.setTitle("ATTENTION!!");
        Optional<ButtonType> result = aa.showAndWait();
        if (result.get() == ButtonType.OK) {
            conseilsFacade.remove(conseils);
            mesConseilsFxHelper.remove(conseils);
            clear();
        } else {
            clear();
        }
    }

    public void recherche() {
        if (typeFind.getText() != null && !typeFind.getText().equals("")) {
            categorieDiabeteFxHelper.setList(categorieDiabeteFacade.findTypeByName(typeFind.getText()));
        } else {
            categorieDiabeteFxHelper.setList(categorieDiabeteFacade.findAll());
        }

    }

    public void clear() {
        titre.clear();
        conseilField.clear();
        typesCombo.setValue(null);
        conseilText.setText("");
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
        initHelper();
        initComboboxTypes();
    }

}
