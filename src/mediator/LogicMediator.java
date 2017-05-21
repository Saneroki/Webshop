/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mediator;

import business.WebPageLogic;
import java.util.ArrayList;
import java.util.HashMap;


/**
 *
 * @author Marcg
 */
public class LogicMediator implements Mediator{
    
    private WebPageLogic logic;
    private static LogicMediator logicMediator;
    
    public LogicMediator(){
        logic = WebPageLogic.getLogic();
    }
    
    public static LogicMediator getMediator() {
        if (logicMediator == null) {
            logicMediator = new LogicMediator();
        }
        return logicMediator;
    }
    
    @Override
    public HashMap<Integer, String> LoadAllPages() {
        return logic.getAllPages();
    }

    @Override
    public void loadPage(int id) {
        logic.loadPage(id);
    }

    @Override
    public void setPW(String pw) {
        
    }

    @Override
    public void setUser(String user) {
        
    }

    @Override
    public void setURL(String url) {
        
    }
    
    
    public double getWidgetX(int widgetID) {
        return logic.getWidgetX(widgetID);
    }
    
    public double getWidgetY(int widgetID) {
        return logic.getWidgetY(widgetID);
    }
    
   
    public ArrayList<Integer> getWidgets(){
        return logic.getWidgetID();
    }
    
    
    public int getNoteID(int widgetID){
        return logic.getNodeID(widgetID);
    }
    
    public HashMap<Integer, String> getStaticWidget(){
        return logic.getStaticWidget();
    }
    
    public void reloadPages(int i){
        logic.loadPage(i);
    }
    
    public ArrayList<String> getPageList(){
        return logic.getPageList();
    }
    
    public int getPageID(String name){
        return logic.getPageID(name);
    }

    @Override
    public HashMap<Integer, String> createStaticWidgets() {
        return logic.getStaticWidget();
    }

    
    
}
