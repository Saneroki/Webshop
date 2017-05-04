/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Logic.Controller;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author Marcg
 */
public class MainPageController implements Initializable {
    
    Controller controller;
    
    @FXML
    private AnchorPane pageTop;
    @FXML
    private AnchorPane pageLeft;
    @FXML
    private AnchorPane pageFoot;
    @FXML
    private AnchorPane pageCenter;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        controller = new Controller();
    }


    private void placeWidget(AnchorPane pane, Node node) {
        
    }
    
}
