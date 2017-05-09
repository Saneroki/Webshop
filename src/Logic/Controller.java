/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic;

import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author Marcg
 */
public class Controller implements Mediator{
    Logic logic;
    private static Controller controller;
    
    public Controller(){
        logic = new Logic();
        
    }
    
    public static Controller getController() {
        if (controller == null) {
            controller = new Controller();
        }
        return controller;
    }

    @Override
    public void sendData(String string) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void getData() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public void loadPage(int siteID){
        logic.loadPage(siteID);
    }
    
    public double getWidgetX(int widgetID) {
        return logic.getWidgetX(widgetID);
    }
    
    public double getWidgetY(int widgetID) {
        return logic.getWidgetY(widgetID);
    }
    
    public double getWigdetHeight(int widgetID) {
        return (double)logic.getWidgetHeight(widgetID);
    }
    
    public double getWidgetWidth(int widgetID){
        return (double)logic.getWidgetWidth(widgetID);
    }
    
    public ArrayList<Integer> getWidgets(){
        return logic.getWidgetID();
    }
    
//    public String getArea(int id){
//        return logic.getArea(id);
//    }
    
    public int getNoteID(int widgetID){
        return logic.getNodeID(widgetID);
    }
    
    public HashMap<Integer, String> getStaticWidget(){
        return logic.getStaticWidget();
    }
    
    public String getTest(){
        return "Hello";
    }


    
}
