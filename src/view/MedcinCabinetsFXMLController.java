/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import helper.CabinetFxHelper;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableView;
import service.CabinetFacade;

/**
 * FXML Controller class
 *
 * @author CHAACHAI Youssef
 */
public class MedcinCabinetsFXMLController implements Initializable {
    
    
    CabinetFacade cabinetFacade = new CabinetFacade();
    
    private CabinetFxHelper cabinetFxHelper;
    
    @FXML
    private TableView cabinetsTable;
    
     private void initHelper() {
        cabinetFxHelper = new CabinetFxHelper(cabinetsTable, cabinetFacade.findAll());
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
