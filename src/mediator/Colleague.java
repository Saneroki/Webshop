/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mediator;

import java.util.HashMap;

/**
 *
 * @author Marcg
 */
public interface Colleague {
    public abstract void loadPage(int i);
    public abstract HashMap<Integer, String> getStaticWidget();
    public abstract HashMap<Integer, String> getAllPages();
    public abstract void createWidget(int id, int DBid, int x, int y); 
    public abstract void setURL(String url);
    public abstract void setPW(String pw);
    public abstract void setUser(String user);
    public abstract String connectToDB();
    
}
