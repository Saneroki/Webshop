/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mediator;

import business.WebPageLogic;
import java.util.HashMap;
import mediator.Mediator;
import persistence.DBLogic;

/**
 *
 * @author Marcg
 */
public class DBMediator implements Mediator{
    private DBLogic dblogic;
    private static DBMediator dbMediator;
    private WebPageLogic logic;
    
    public DBMediator(){
        dblogic = new DBLogic();
        dblogic.addMediator(this);
    }
    
    public void addLogic(WebPageLogic wpl){
        this.logic = wpl;
    }
    
    public static DBMediator getMediator() {
        if (dbMediator == null) {
            dbMediator = new DBMediator();  
        }
        return dbMediator;
    }
    
    public void connectToDB() {
        dblogic.connectToDB();
    }

    
    public String getDBstatus(){
        return dblogic.getDBstatus();
    }
    
    
    @Override
    public void setUser(String user){
        dblogic.setUser(user);
    }
    
    @Override
    public void setPW(String pw){
        dblogic.setPW(pw);
    }
    
    @Override
    public void setURL(String url){
        dblogic.setURL(url);
    }
    
    @Override
    public HashMap<Integer, String> createStaticWidgets(){
        return dblogic.getStaticWidget();
    }

    @Override
    public HashMap<Integer, String> LoadAllPages() {
        return dblogic.getAllPages();
    }

    @Override
    public void loadPage(int id) {
        dblogic.loadPage(id);
    }

    
    public void createWidget(int id, int DBid, int x, int y) {
        logic.createWidget(id, DBid, x, y);
    }
    
}
