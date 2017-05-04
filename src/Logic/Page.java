/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic;

import java.util.ArrayList;

/**
 *
 * @author Marcg
 */
class Page {
    ArrayList<Widgets> widgets;
    
    Page(Widgets top, Widgets left, Widgets center, Widgets bottom){
        widgets = new ArrayList<>();
        widgets.add(top);
        widgets.add(left);
        widgets.add(center);
        widgets.add(bottom);
        
    }
    
    Widgets getTop(){
        return widgets.get(0);
    }
    
    Widgets getLeft(){
        return widgets.get(1);
    }
    
    Widgets getCenter(){
        return widgets.get(2);
    }
    
    Widgets getBottom(){
        return widgets.get(3);
    }
}
