/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic;

import DB.DBMediator;
import java.sql.ResultSet;
import java.sql.SQLException;

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
        dB.sendData("SELECT * FROM \"site\" WHERE \"site\".site_id = " + i);
        result = dB.getResult();
        
        
        try{
           currentPage = new Page(createWidget(result.getInt(2), "top"), 
                createWidget(result.getInt(4), "left"), 
                createWidget(result.getInt(5), "center"), 
                createWidget(result.getInt(6), "bottom"));
        } catch(SQLException e){
            System.out.println("no data found!");
        }
        
    }
    
    Widgets createWidget(int id, String desc){
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
        
        String sql = "SELECT * FROM \"" + tabel + "\" JOIN \"widget\" ON (\"widget\".id = \"" + tabel + "\".widget_id) WHERE \"" + tabel + "\".id = " + id;
        
        dB.sendData(sql);
        ResultSet widgetresult = dB.getResult();
        try{
            widget = new Widgets(widgetresult.getInt(2), widgetresult.getInt(3), widgetresult.getString(6));
        } catch(SQLException e){
            System.out.println("no data found!");
        }
        
        return widget;
    }
    
    
    
    
    
    
}
