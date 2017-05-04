/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic;

import DB.DBMediator;

/**
 *
 * @author Marcg
 */
public class Logic {
    
    DBMediator dB;
    
    public Logic(){
        dB = new DBMediator();
    }
    
   public void connectDB(String user, String pw, String url){
       dB.connectToDB(user, pw, url);
   }
   
   
    
}
