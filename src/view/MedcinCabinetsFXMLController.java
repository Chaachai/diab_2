/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import bean.Cabinet;
import bean.Medcin;
import helper.CabinetFxHelper;
import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javax.swing.JOptionPane;
import service.CabinetFacade;
import service.MedcinFacade;
import util.Session;

/**
 * FXML Controller class
 *
 * @author CHAACHAI Youssef
 */
public class MedcinCabinetsFXMLController implements Initializable {

    CabinetFacade cabinetFacade = new CabinetFacade();
    MedcinFacade medcinFacade = new MedcinFacade();

    private CabinetFxHelper cabinetFxHelper;

    @FXML
    private TableView cabinetsTable;

    @FXML
    private TextField nomCabinet;
    @FXML
    private TextField adresseCabinet;
    @FXML
    private TextField telephoneCabinet;
    @FXML
    private TextField nomFind;

    @FXML
    private Button ajouterCabinet;
    @FXML
    private Button modifierCabinet;
    @FXML
    private Button supprimerCabinet;
    @FXML
    private Button rechercherCabinet;
    
    @FXML
    private Button mesCabinets;
    @FXML
    private Button mesConseils;

    private void initHelper() {
        cabinetFxHelper = new CabinetFxHelper(cabinetsTable, cabinetFacade.getCabinetsByMedcin(1L));
    }

    @FXML
    public void mesConseils(ActionEvent actionEvent) throws IOException {
        ViewLauncher.forward(actionEvent, "MedcinConseilsFXML.fxml", this.getClass());
    }
    
    @FXML
    public void mesCabinets(ActionEvent actionEvent) throws IOException {
        ViewLauncher.forward(actionEvent, "MedcinCabinetsFXML.fxml", this.getClass());
    }

    public void mouseClickedTable() {
        Cabinet cabinet = cabinetFxHelper.getSelected();
        Session.updateAttribute(cabinet, "cabinet");
        nomCabinet.setText(cabinet.getNom());
        adresseCabinet.setText(cabinet.getAdresse());
        telephoneCabinet.setText(cabinet.getTelephone());
    }

    public Cabinet getParam() {
        Cabinet cabinet = new Cabinet();
        Medcin medcin = medcinFacade.find(1L);
        cabinet.setNom(nomCabinet.getText());
        cabinet.setAdresse(adresseCabinet.getText());
        cabinet.setTelephone(telephoneCabinet.getText());
        cabinet.setMedcin(medcin);
        return cabinet;
    }

    public void addCabinet() {
        if (nomCabinet.getText().equals("") || adresseCabinet.getText().equals("") || telephoneCabinet.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Veuillez remplir tout les chapms !", "Echec!", JOptionPane.ERROR_MESSAGE);
        } else {
            Cabinet cabinet = getParam();
            cabinetFacade.create(cabinet);
            cabinetFxHelper.create(cabinet);
            clear();
        }
    }

    public void updateCabinet() {
        Cabinet cabinet = (Cabinet) Session.getAttribut("cabinet");
        cabinet.setNom(nomCabinet.getText());
        cabinet.setAdresse(adresseCabinet.getText());
        cabinet.setTelephone(telephoneCabinet.getText());
        cabinetFacade.edit(cabinet);
        cabinetsTable.refresh();
        clear();
    }

    public void deleteCabinet() {
        Cabinet cabinet = (Cabinet) cabinetsTable.getSelectionModel().getSelectedItem();
        Alert aa = new Alert(Alert.AlertType.CONFIRMATION);
        aa.setHeaderText("ATTENTION!!");
        aa.setContentText("Voulez-vous vraiment supprimer ce cabinet ?");
        aa.setTitle("ATTENTION!!");
        Optional<ButtonType> result = aa.showAndWait();
        if (result.get() == ButtonType.OK) {
            cabinetFacade.remove(cabinet);
            cabinetFxHelper.remove(cabinet);
            clear();
        } else {
            clear();
        }
    }

    public void recherche() {
        if (nomFind.getText() != null && !nomFind.getText().equals("")) {
            cabinetFxHelper.setList(cabinetFacade.findCabinetByName(nomFind.getText()));
        } else {
            cabinetFxHelper.setList(cabinetFacade.getCabinetsByMedcin(1L));
        }

    }

    public void test() {
        System.out.println(nomCabinet.getText());
    }

    public void clear() {
        nomCabinet.clear();
        adresseCabinet.clear();
        telephoneCabinet.clear();
        nomFind.clear();
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
    }

}
