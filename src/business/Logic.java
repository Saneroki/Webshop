/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import persistence.DBMediator;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author Marcg
 */
class Logic {
    
    Page currentPage;
    ResultSet result;
    DBMediator dB;
    HashMap<Integer, String> allPages = new HashMap<>();
    
    Logic(){
        dB = new DBMediator();
        dB.connectToDB();
    }
    
    void loadPage(int i){
        ArrayList<BusinessWidget> widgets = new ArrayList<>();
        String sql = "SELECT site.site_id, site_widget.x, site_widget.y,\n" +
        "site_widget.height, site_widget.width, site_widget.id, widget.id\n" +
        "FROM site\n" +
        "JOIN site_widget ON (site_widget.site_id = site.site_id)\n" +
        "JOIN widget ON (site_widget.widget_id = widget.id)" +
        "WHERE site.site_id =" + i;
        
            dB.sendData(sql);
            result = dB.getResult();
         
            String siteName = allPages.get(i);
            int id = i;
        
        
        
        try{
            while(result.next()){
                widgets.add(createWidget(result.getInt(6), result.getInt(2), result.getInt(3), result.getInt(5), result.getInt(4), result.getInt(7)));
           
            }
        } catch(SQLException e){
            System.out.println(e);
            System.out.println("no data found!");
        }
        
        currentPage = new Page(id, siteName, widgets);
    }
    
    
    BusinessWidget createWidget(int id, int x, int y, int width, int height, int widgetid){
        BusinessWidget widget = null;
        widget = new BusinessWidget(x, y, height, width, id, widgetid);
        return widget;
    }
    
    
    double getWidgetX(int widgetID){
        double x = 0;
        for(BusinessWidget w: currentPage.getAllWidgets()){
            if(w.getID() == widgetID){
                x = w.getX();
            }
        }
        return x;
    }
    
    double getWidgetY(int widgetID){
        double y = 0;
        for(BusinessWidget w: currentPage.getAllWidgets()){
            if(w.getID() == widgetID){
                y = w.getY();
            }
        }
        return y;
    }
    
    int getWidgetHeight(int widgetID){
        int height = 0;
        for(BusinessWidget w: currentPage.getAllWidgets()){
            if(w.getID() == widgetID){
                height = w.getHeight();
            }
        }
        return height;
    }
    
    int getWidgetWidth(int widgetID){
        int width = 0;
        for(BusinessWidget w: currentPage.getAllWidgets()){
            if(w.getID() == widgetID){
                width = w.getHeight();
            }
        }
        return width;
    }
    
    ArrayList<Integer> getWidgetID(){
        return currentPage.getWidgetID();
    }
    
    
    int getNodeID(int id){
        int nodeID = 0;
        for(BusinessWidget w : currentPage.getAllWidgets()){
            if(w.getID() == id){
                nodeID = w.getDBID();
                break;
            } 
        }
        return nodeID;
    }
    
    HashMap<Integer, String> getStaticWidget(){
        HashMap<Integer, String> widgets = new HashMap<>();
        String sql = "SELECT * FROM widget";
        
        dB.sendData(sql);
        ResultSet staticWidget = dB.getResult();
        try {
            while(staticWidget.next()){
                widgets.put(staticWidget.getInt(1), staticWidget.getString(2));
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        
        return widgets;
    
    }
    
    void loadAllPages(){
        
        String sql = "SELECT * FROM site";
        dB.sendData(sql);
        ResultSet result = dB.getResult();
        
        try{
            while(result.next()){
                allPages.put(result.getInt(2), result.getString(1));
            }
        } catch(SQLException e){
            System.out.println(e);
        }
       
    }
    
    ArrayList<String> getPageList(){
        ArrayList<String> pageNameList = new ArrayList<String>();
        for(Integer i: allPages.keySet()){
            pageNameList.add(allPages.get(i));
        }
        return pageNameList;
    }
    
    int getPageID(String pageName){
        int siteID = -1;
        for(Integer i: allPages.keySet()){
            if(allPages.get(i).equals(pageName)){
                siteID = i;
                break;
            }
        }
        return siteID;
    }
}
