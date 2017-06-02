    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import mediator.*;

/**
 *
 * @author Marcg
 */
public class DBLogic implements Colleague{
    ConnectionToDB con;
    DBMediator mediator;
    String status;
    ResultSet result;
    String user = "postgres";
    String pw = "Npaexmmf226";
    String url = "jdbc:postgresql://localhost:5432/ElectroMOSDB";
    
    public DBLogic(){
        connectToDB();
    }
    
    public void addMediator(DBMediator mediator){
        this.mediator = mediator;
    }
    
    @Override
    public String connectToDB() {
        con = new ConnectionToDB(user, pw, url);
        status = con.connect();
        System.out.println(status);
        return status;
    }

    
    public void sendData(String string) {
        con.sendDBStatement(string);
        result = con.getResult();
    }

    
    public String getDBstatus(){
        return status;
    }
    
    @Override
    public void setUser(String user){
        this.user = user;
    }
    
    @Override
    public void setPW(String pw){
        this.pw = pw;
    }
    
    @Override
    public void setURL(String url){
        this.url = url;
    }
    
    @Override
    public HashMap<Integer, String> getAllPages(){
        HashMap<Integer, String> allPages = new HashMap<>();
        String sql = "SELECT * FROM site";
        sendData(sql);
        
        try{
            while(result.next()){
                allPages.put(result.getInt(2), result.getString(1));
            }
        } catch(SQLException e){
            System.out.println(e);
        }
        return allPages;
    }
    
    @Override
    public HashMap<Integer, String> getStaticWidget(){
        HashMap<Integer, String> widgets = new HashMap<>();
        String sql = "SELECT * FROM widget";
        
        sendData(sql);
        try {
            while(result.next()){
                widgets.put(result.getInt(1), result.getString(2));
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        
        return widgets;
    
    }
    
    @Override
    public void createWidget(int id, int DBid, int x, int y){
        mediator.createWidget(id, DBid, x, y);
    }

    @Override
    public void loadPage(int i) {
        String sql = "SELECT site.site_id, site_widget.x, site_widget.y,\n" +
        "site_widget.height, site_widget.width, site_widget.id, widget.id\n" +
        "FROM site\n" +
        "JOIN site_widget ON (site_widget.site_id = site.site_id)\n" +
        "JOIN widget ON (site_widget.widget_id = widget.id)" +
        "WHERE site.site_id =" + i;
        
        sendData(sql);
        try{
            while(result.next()){
                
                createWidget(result.getInt(6), result.getInt(7), result.getInt(2), result.getInt(3));
            }
        } catch(SQLException e){
            System.out.println(e);
            System.out.println("no data found!");
        }
    }  
}