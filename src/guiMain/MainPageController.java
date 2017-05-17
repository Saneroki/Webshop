/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guiMain;

import guiWidgets.WidgetSelector;
import business.Controller;
import java.awt.geom.Area;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Marcg
 */
public class MainPageController implements Initializable {
    
    Controller controller;
    WidgetSelector ws;
    
    @FXML
    private AnchorPane pageCenter;
    @FXML
    private Button backButton;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ws = WidgetSelector.getWidgetSelector();
        controller = Controller.getController();
    }
    
    @FXML
    private void buttonListener(ActionEvent event) {
        if (event.getSource() == backButton) {
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("PageSelector.fxml"));
                Parent pageParent = loader.load();
                Scene newPageScene = new Scene(pageParent);
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.setScene(newPageScene);
                stage.show();
            } catch (IOException ex) {
                System.out.println("cannot find page");
                System.out.println(ex);
            }
        }
    }
    
    public void loadPage(int id){
        System.out.println(id);
        controller.loadPage(id);
        ArrayList<Integer> widgetID = controller.getWidgets();
        
        for(Integer i: widgetID){
            this.addWidget(ws.loadWidget(controller.getNoteID(i)).getNode(), i);
        }
        
    }
    
    private void addWidget(Node node, int id){
        AnchorPane parent = pageCenter;
        parent.getChildren().add(node);
        node.setLayoutX(controller.getWidgetX(id));
        node.setLayoutY(controller.getWidgetY(id));
        node.resize(controller.getWigdetHeight(id), controller.getWidgetWidth(id));
    }
    
    
    
   
    
    

}
