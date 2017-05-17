/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guiMain;

import business.Controller;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Marcg
 */
public class PageSelectorController implements Initializable {
    Controller control;
    int pageChoice;
    /**
     * Initializes the controller class.
     */
    
    @FXML
    private ChoiceBox<String> pageSelect;
    @FXML
    private Button selectPage;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        control = Controller.getController();
        updateBox(pageSelect, control.getPageList());
    }    
    
    
    private void updateBox(ChoiceBox box, ArrayList<?> list){
        box.setItems(FXCollections.observableArrayList(list));
    }
    
    @FXML
    private void buttonListener(ActionEvent event) {
        if (event.getSource() == selectPage) {
            switchScene(event);
        }
    }
    
    private void switchScene(ActionEvent event) {
        try {
            FXMLLoader  loader = new FXMLLoader(getClass().getResource("MainPage.fxml"));
            Parent pageParent = loader.load();
            Scene newPageScene = new Scene(pageParent);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(newPageScene);
            MainPageController controller = loader.<MainPageController>getController();
            System.out.println("Loading page: " + pageSelect.getValue());
            System.out.println("ID: " + control.getPageID(pageSelect.getValue()));
            controller.loadPage(control.getPageID(pageSelect.getValue()));
            stage.show();
        } catch (IOException ex) {
            System.out.println("cannot find page");
            System.out.println(ex);
        }
    }
    
    private void alertConnectionError(){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText("Connection to the Database Failed!");
        alert.setContentText("Database is not available at the moment");
        alert.showAndWait();
    }
    
    
    
    
    
}
