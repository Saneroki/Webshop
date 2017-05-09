/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Logic.Controller;
import guiWidgets.*;
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
    private AnchorPane pageTop;
    @FXML
    private AnchorPane pageLeft;
    @FXML
    private AnchorPane pageFoot;
    @FXML
    private AnchorPane pageCenter;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ws = new WidgetSelector(controller);
        controller = new Controller();
        
        loadPage(3);
    }
    
    
    private void loadPage(int id){
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
    
    
//    private AnchorPane getArea(int id){
//        switch(controller.getArea(id)){
//            case"top":
//                return pageTop;
//            case"left":
//                return pageLeft;
//            case"bottom":
//                return pageFoot;
//            case"center":
//                return pageCenter;
//            default:
//                break;
//        }
//        return null;
//    }
}
