/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic;

import DB.DBMediator;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

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
    }
    
    void loadPage(int i){
        HashMap<Widgets, String> widgets = new HashMap<>();
        String sql = "SELECT \"site\".site_id, \"site\".\"Description\", \"site_widget\".x, \"site_widget\".y, " +
            "\"widget\".id, \"widget\".widget_name, \"widget_type\".type_name FROM \"site\"\n" +
            "JOIN \"site_widget\" ON (\"site_widget\".site_id = \"site\".site_id)\n" +
            "JOIN \"widget\" ON (\"site_widget\".widget_id = \"widget\".id)\n" +
            "JOIN \"widget_type\" ON (\"widget\".type_id = \"widget_type\".id)" +
            "WHERE \"site\".site_id = " + i;
        
            dB.sendData(sql);
            result = dB.getResult();
            String siteName = "";
            int id = 0;
        
        try{
            siteName = result.getString(2);
            id = result.getInt(1);
            while(result.next()){
                widgets.put(createWidget(result.getInt(5), result.getInt(3), result.getInt(4), result.getString(6)), result.getString(7));
            }
            
        } catch(SQLException e){
            System.out.println("no data found!");
        }
        
        currentPage = new Page(id, siteName, widgets);
    }
    
    
    Widgets createWidget(int id, int x, int y, String desc){
        Widgets widget = null;
        String tabel;
        switch(desc){
            case"top":
                tabel = "top_widget";
                break;
            case"bottom":
                tabel = "bottom_widget";
                break;
            case"left":
                tabel = "left_widget";
                break;
            case"center":
                tabel = "center_widget";
                break;
            default:
                tabel = "";
        }
       
        widget = new Widgets(x, y, desc);
        return widget;
    }
    
    
    double getWidgetX(String widgetName){
        double x = 0;
        for(Widgets w: currentPage.getAllWidgets().keySet()){
            if(w.getDesc().equals(widgetName)){
                x = w.getX();
            }
        }
        return x;
    }
    
    double getWidgetY(String widgetName){
        double y = 0;
        for(Widgets w: currentPage.getAllWidgets().keySet()){
            if(w.getDesc().equals(widgetName)){
                y = w.getY();
            }
        }
        return y;
    }
    
    
    
    
    
}
