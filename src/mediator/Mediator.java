
package mediator;

/**
 *
 * @author Marcg
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.HashMap;


public  interface Mediator {
    public abstract HashMap<Integer, String> LoadAllPages();
    public abstract void loadPage(int id);
    public abstract void setPW(String pw);
    public abstract void setUser(String user);
    public abstract void setURL(String url); 
    public abstract HashMap<Integer, String> createStaticWidgets();
    
}


