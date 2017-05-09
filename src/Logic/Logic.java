/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic;

import DB.DBMediator;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.layout.AnchorPane;

/**
 *
 * @author Marcg
 */
class Logic {
    
    Page currentPage;
    ResultSet result;
    DBMediator dB;
    
    Logic(){
        dB = new DBMediator();
        dB.connectToDB();
    }
    
    void loadPage(int i){
        ArrayList<BusinessWidget> widgets = new ArrayList<>();
        String sql = "SELECT \"site\".site_id, \"site\".\"Description\", \"site_widget\".x, \"site_widget\".y, \n" +
        "\"site_widget\".height, \"site_widget\".width, \"site_widget\".id, \n" +
        "\"widget\".id, \"widget\".widget_name FROM \"site\"\n" +
        "JOIN \"site_widget\" ON (\"site_widget\".site_id = \"site\".site_id)\n" +
        "JOIN \"widget\" ON (\"site_widget\".widget_id = \"widget\".id)\n" +
        "WHERE \"site\".site_id =" + i;
        
            dB.sendData(sql);
            result = dB.getResult();
         
            String siteName = "";
            int id = 0;
        
        
        
        try{
            
            while(result.next()){
                widgets.add(createWidget(result.getInt(7), result.getInt(3), result.getInt(4), result.getInt(6), result.getInt(5), result.getInt(8)));
           
            }
            siteName = result.getString(2);
            id = result.getInt(1);
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
    
//    String getArea(int widgetid){
//        AnchorPane pane = null;
//        BusinessWidget widget = null;
//        for(BusinessWidget w : currentPage.getAllWidgets()){
//            if(w.getID() == widgetid){
//                widget = w;
//                break;
//            } 
//        }
//        return currentPage.getAllWidgets().get(widget);
//    }
    
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
                System.out.println(staticWidget.getInt(1) + ": " + staticWidget.getString(2));
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        
        return widgets;
    
    }
    
    
    
    
}
