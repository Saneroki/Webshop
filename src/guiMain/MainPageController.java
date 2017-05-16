/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guiMain;

import guiWidgets.WidgetSelector;
import business.Controller;
import java.awt.geom.Area;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
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
    WidgetSelector ws;
    
    @FXML
    private AnchorPane pageCenter;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ws = new WidgetSelector();
        controller = Controller.getController();
        
        loadPage(3);
    }
    
    
    private void loadPage(int id){
        controller.loadPage(id);
        ArrayList<Integer> widgetID = controller.getWidgets();
        
        for(Integer i: widgetID){
            System.out.println(ws.loadWidget(controller.getNoteID(i)).getFxmlName());
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
