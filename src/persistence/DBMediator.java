/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence;

import business.Mediator;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Marcg
 */
public class DBMediator implements Mediator{
    ConnectionToDB con;
    String status;
    ResultSet result;
    String user = "postgres";
    String pw = "Npaexmmf226";
    String url = "jdbc:postgresql://10.126.115.233:5432/ElectroMOSDB";
    public DBMediator(){
        
    }

    public void connectToDB() {
        con = new ConnectionToDB(user, pw, url);
        status = con.connect();
        System.out.println(status);
    }

    @Override
    public void sendData(String string) {
        System.out.println(string);
        con.sendDBStatement(string);
        result = con.getResult();
    }

    @Override
    public void getData() {
        
    }
    
    public String getDBstatus(){
        return status;
    }
    
    public ResultSet getResult(){
        return result;
    }
    
    public void setUser(String user){
        this.user = user;
    }
    
    public void setPW(String pw){
        this.pw = pw;
    }
    
    public void setURL(String url){
        this.url = url;
    }
}
