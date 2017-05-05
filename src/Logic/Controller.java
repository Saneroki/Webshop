/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic;

/**
 *
 * @author Marcg
 */
public class Controller implements Mediator{
    Logic logic;
    public Controller(){
        logic = new Logic();
        
    }

    @Override
    public void sendData(String string) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void getData() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public void getWidgetX(String widgetName) {
        
    }
    
    public void getWidgetY(String widgetName) {
        
    }


    
}
