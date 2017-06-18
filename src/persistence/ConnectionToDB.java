/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence;

import java.sql.*;
import java.util.logging.*;

// java -cp postgresql-9.4-1201.jdbc4.jar:. DBtest

public class ConnectionToDB {
	
    Connection con = null;
    ResultSet result = null;
    String url = null;
    String user = null;
    String password = null;

    protected ConnectionToDB(String user, String password, String url){

        this.url = url;
        this.user = user;
        this.password = password;

        try {

            Class.forName("org.postgresql.Driver");

        } catch (ClassNotFoundException e) {

            System.out.println("Something is wrong with your jdbc path!");
            e.printStackTrace();

        }

    }

    protected String connect(){

        try {
            con = DriverManager.getConnection(url, user, password);

        } catch (SQLException ex) {
            Logger lgr = Logger.getLogger(ConnectionToDB.class.getName());
            lgr.log(Level.WARNING, ex.getMessage(), ex);
            System.out.println(ex);
        }

        if (con != null) {
            return "Connection to database established!";
        } else {
            return "Failed to make connection!";
        }
    }


    public void sendDBStatement(String statement){
        PreparedStatement prepStat = null;
        try {
            System.out.println(statement);
            prepStat = con.prepareStatement(statement);
            result = prepStat.executeQuery();
            
        } catch (SQLException e) {
            System.out.println(e);
        }

    }
    
    protected ResultSet getResult(){
        return result;
    }
}