/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import mediator.DBMediator;

import java.util.ArrayList;
import java.util.HashMap;
import mediator.*;

/**
 *
 * @author Marcg
 */
public class WebPageLogic implements Colleague{
    
    private Page currentPage;
    private DBMediator dB;
    private HashMap<Integer, String> allPages;
    private static WebPageLogic logic;
    
    public WebPageLogic(){
        dB = DBMediator.getMediator();
        dB.addLogic(this);
        dB.connectToDB();
    }
   
    
    
    public static WebPageLogic getLogic() {
        if (logic == null) {
            logic = new WebPageLogic();
        }
        return logic;
    }
    
    @Override
    public void loadPage(int id) {
        String siteName = allPages.get(id);
        currentPage = new Page(id, siteName);
        dB.loadPage(id);
    }
    
    @Override
    public void createWidget(int id, int DBid, int x, int y){
        BusinessWidget widget = new BusinessWidget(x, y, id, DBid);
        currentPage.addWidget(widget);
        return;
    }
    
    
    public double getWidgetX(int widgetID){
        double x = 0;
        for(BusinessWidget w: currentPage.getAllWidgets()){
            if(w.getID() == widgetID){
                x = w.getX();
            }
        }
        return x;
    }
    
    public double getWidgetY(int widgetID){
        double y = 0;
        for(BusinessWidget w: currentPage.getAllWidgets()){
            if(w.getID() == widgetID){
                y = w.getY();
            }
        }
        return y;
    }
    

    
    public ArrayList<Integer> getWidgetID(){
        return currentPage.getWidgetID();
    }
    
    
    public int getNodeID(int id){
        int nodeID = 0;
        for(BusinessWidget w : currentPage.getAllWidgets()){
            if(w.getID() == id){
                nodeID = w.getDBID();
                break;
            } 
        }
        return nodeID;
    }
    
    @Override
    public HashMap<Integer, String> getStaticWidget(){
        return dB.createStaticWidgets();
    }
    
    
    public ArrayList<String> getPageList(){
        getAllPages();
        ArrayList<String> pageNameList = new ArrayList<String>();
        for(Integer i: allPages.keySet()){
            pageNameList.add(allPages.get(i));
        }
        return pageNameList;
    }
    
    public int getPageID(String pageName){
        int siteID = -1;
        for(Integer i: allPages.keySet()){
            if(allPages.get(i).equals(pageName)){
                siteID = i;
                break;
            }
        }
        return siteID;
    }

    @Override
    public HashMap<Integer, String> getAllPages() {
        allPages = dB.LoadAllPages();
        return allPages;
    }

    @Override
    public void setURL(String url) {
        dB.setURL(url);
    }

    @Override
    public void setPW(String pw) {
        dB.setPW(pw);
    }

    @Override
    public void setUser(String user) {
        dB.setUser(user);
    }

    @Override
    public String connectToDB() {
        return dB.connectToDB();
    }

    
}
