/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guiMain;

import mediator.*;
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
import javafx.scene.control.TextArea;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Marcg
 */
public class PageSelectorController implements Initializable {
    LogicMediator control;
    int pageChoice;
    /**
     * Initializes the controller class.
     */
    
    @FXML
    private ChoiceBox<String> pageSelect;
    @FXML
    private Button selectPage;
    @FXML
    private Button dbLogin;
    @FXML
    private TextArea pw;
    @FXML
    private TextArea dbuser;
    @FXML
    private TextArea url;
    @FXML
    private Text status;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        control = LogicMediator.getMediator();
        updateBox(pageSelect, control.getPageList());
    }    
    
    
    private void updateBox(ChoiceBox box, ArrayList<?> list){
        box.setItems(FXCollections.observableArrayList(list));
    }
    
    @FXML
    private void buttonListener(ActionEvent event) {
        if (event.getSource() == selectPage) {
            switchScene(event);
        } else if (event.getSource() == dbLogin){
            updateChoicebox();
        }
    }
    
    private void switchScene(ActionEvent event) {
        try {
            control.setPW(pw.getText());
            control.setUser(dbuser.getText());
            control.setURL(url.getText());
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
            System.out.println("Error 404: Page not found!");
        }
    }
    
    private void updateChoicebox(){
        pageSelect.getItems().clear();
        control.setPW(pw.getText());
        control.setUser(dbuser.getText());
        control.setURL(url.getText());
        status.setText(control.connectToDB());
        updateBox(pageSelect, control.getPageList());
    }
    
    
    
    
    
    
    
}
