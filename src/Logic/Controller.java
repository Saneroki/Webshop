/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic;

import java.util.ArrayList;

/**
 *
 * @author Marcg
 */
public class Controller implements Mediator{
    Logic logic;
    public Controller(){
        logic = new Logic();
        
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
    
    public String getArea(int id){
        return logic.getArea(id);
    }
    
    public int getNoteID(int widgetID){
        return logic.getNodeID(widgetID);
    }


    
}
